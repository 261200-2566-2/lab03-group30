public class Character {
    private String name;
    private int level, slots;
    private double MAX_Hp, MAX_Mp, MAX_Speed, base_Speed;
    private double hp, mp, speed, atk, def;
    private boolean isSword, isShield;
    private Equipments[] equipmentSlot;

    public Character (String name, int lv) {
        this.name = name;
        this.slots = 2;
        equipmentSlot = new Equipments[slots];
        this.base_Speed = 50;
        CalculateStat(lv);
    }

    private void CalculateStat (int lv) {
        this.level = lv;
        this.MAX_Hp = 100 + (10 * level);
        this.MAX_Mp = 50 + (2 * level);
        this.MAX_Speed = Math.ceil(base_Speed * (1 + 0.03 * level));

        this.hp = MAX_Hp;
        this.mp = MAX_Mp;
        this.speed = MAX_Speed;
    }

    public void setLevel (int lv) {
        CalculateStat(lv);
    }

    public void equip(Equipments e) { // hardcode slot1 sword, slot2 shield
        switch (e.getType()) {
            case "Sword":
                if (!isSword) {
                    atk += e.getAtk();
                    MAX_Speed += e.getSpeed();
                    speed = MAX_Speed;
                    equipmentSlot[0] = e;
                    isSword = true;
                } else if (e != equipmentSlot[0]) { // swap
                    atk -= equipmentSlot[0].getAtk();
                    MAX_Speed -= equipmentSlot[0].getSpeed();
                    atk += e.getAtk();
                    MAX_Speed += e.getSpeed();
                    speed = MAX_Speed;
                    equipmentSlot[0] = e;
                }
                break;
            case "Shield":
                if (!isShield) {
                    def += e.getDef();
                    MAX_Speed += e.getSpeed();
                    speed = MAX_Speed;
                    equipmentSlot[1] = e;
                    isShield = true;
                } else if (e != equipmentSlot[1]) { // swap
                    atk -= equipmentSlot[1].getDef();
                    MAX_Speed -= equipmentSlot[1].getSpeed();
                    atk += e.getDef();
                    MAX_Speed += e.getSpeed();
                    speed = MAX_Speed;
                    equipmentSlot[0] = e;
                }
                break;
            default:
                break;
        }
    }
    public void unEquip(int slot) {
        if(equipmentSlot[slot] == null) return;
        switch (equipmentSlot[slot].getType()) {
            case "Sword":
                if (isSword) {
                    atk -= equipmentSlot[slot].getAtk();
                    MAX_Speed -= equipmentSlot[slot].getSpeed();
                    speed = MAX_Speed;
                    equipmentSlot[slot] = null;
                    isSword = false;
                }
                break;
            case "Shield":
                if (isShield) {
                    def -= equipmentSlot[slot].getDef();
                    MAX_Speed -= equipmentSlot[slot].getSpeed();
                    speed = MAX_Speed;
                    equipmentSlot[slot] = null;
                    isShield = false;
                }
                break;
            default:
                break;
        }
    }

    public void attack (Character c) {
        double damage = this.atk - c.def;
        if(damage >= c.hp) {
            c.hp = 0;
        } else if (damage <= 0) {
            damage = 0;
        } else {
            c.hp -= damage;
        }
        System.out.println("=========================");
        System.out.println(this.name + " Attack " + c.name);
        System.out.println("Deal Damage : " + damage);
        System.out.println("=========================");
    }

    public void printAllStat () {
        System.out.println("=========================");
        System.out.println("Name : " + name);
        System.out.println("=========================");
        System.out.println("Level : " + level);
        System.out.println("MaxHP : " + MAX_Hp);
        System.out.println("HP : " + hp);
        System.out.println("MaxMP : " + MAX_Mp);
        System.out.println("Mp : " + mp);
        System.out.println("MaxSpeed : " + MAX_Speed);
        System.out.println("Speed : " + speed);
        System.out.println("Atk : " + atk);
        System.out.println("Def : " + def);
        System.out.println("isSword : " + isSword);
        System.out.println("isShield : " + isShield);
        System.out.print("Equipments : ");
        for (Equipments s : equipmentSlot) {
            if(s != null) System.out.print("[Lv. " + s.getLevel() + " " + s.getName() + "] ");
            else System.out.print("[None] ");
        }
        System.out.println("\n=========================\n");
    }

    public void printStat () {
        System.out.println("=========================");
        System.out.println("Name : " + name);
        System.out.println("=========================");
        System.out.println("Level : " + level);
        System.out.println("HP : " + hp);
        System.out.println("Mp : " + mp);
        System.out.println("Speed : " + speed);
        System.out.println("Atk : " + atk);
        System.out.println("Def : " + def);
        String e1 = (equipmentSlot[0] != null) ? "[Lv. " + equipmentSlot[0].getLevel() + " " + equipmentSlot[0].getName() + "] " : "[None] ";
        String e2 = (equipmentSlot[1] != null) ? "[Lv. " + equipmentSlot[1].getLevel() + " " + equipmentSlot[1].getName() + "] " : "[None] ";
        System.out.print("Equipments : " + e1 + e2);
        System.out.println("\n=========================\n");
    }
}