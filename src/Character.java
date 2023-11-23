public class Character {
    private String name;
    private double MAX_Hp, MAX_Mp, MAX_Speed, level, base_Speed;
    private double hp, mp, speed, atk, def;
    private boolean isSword, isShield;
    private Weapons[] weapons = new Weapons[2];
    public Character (String name, double lv) {
        this.name = name;
        this.level = lv;
        this.MAX_Hp = 100 + (10 * level);
        this.MAX_Mp = 50 + (2 * level);
        this.base_Speed = 100;
        this.MAX_Speed = Math.ceil(base_Speed * (1 + 0.1 * level));

        this.hp = MAX_Hp;
        this.mp = MAX_Mp;
        this.speed = MAX_Speed;
    }

    public void equipWeapon(Weapons w) {
        switch (w.getType()) {
            case "sword":
                if (!isSword) {
                    atk += Math.ceil(w.getBaseAtk() * (1 + 0.1 * level));
                    MAX_Speed -= Math.ceil(base_Speed * (0.1 + (0.02 * level)));
                    speed = MAX_Speed;
                    weapons[0] = w;
                    isSword = true;
                }
                break;
            case "shield":
                if (!isShield) {
                    def += Math.ceil(w.getBase_Def() * (1 + 0.05 * level));
                    MAX_Speed -= Math.ceil(base_Speed * (0.1 + (0.05 * level)));
                    speed = MAX_Speed;
                    weapons[1] = w;
                    isShield = true;
                }
                break;
            default:
                break;
        }
    }
    public void unEquipWeapon(Weapons w) {
        switch (w.getType()) {
            case "sword":
                if (isSword) {
                    atk -= Math.ceil(w.getBaseAtk() * (1 + 0.1 * level));
                    MAX_Speed += Math.ceil(base_Speed * (0.1 + (0.02 * level)));
                    speed = MAX_Speed;
                    weapons[0] = null;
                    isSword = false;
                }
                break;
            case "shield":
                if (isShield) {
                    def -= Math.ceil(w.getBase_Def() * (1 + 0.05 * level));
                    MAX_Speed += Math.ceil(base_Speed * (0.1 + (0.05 * level)));
                    speed = MAX_Speed;
                    weapons[1] = null;
                    isShield = false;
                }
                break;
            default:
                break;
        }
    }

    public void attack (Character c) {
        double damage = this.atk - c.def;
        if(c.hp <= damage) {
            c.hp = 0;
        } else {
            c.hp -= damage;
        }
        System.out.println(this.name + " Attack => " + c.name);
        System.out.println("Damage : " + damage);
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
        System.out.println("Weapons : " + weapons[0] + ", " + weapons[1]);
        System.out.println("=========================\n");
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
        System.out.println("=========================\n\n");
    }
}