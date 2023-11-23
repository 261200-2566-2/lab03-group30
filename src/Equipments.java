public class Equipments {
    private String name, type;
    private int level;
    private double base_Atk, base_Def, base_Speed; // base stat for rebalance
    private double atk, def, hp, mp, speed; // stat
    public Equipments (String type, int lv) {
        this.type = type;
        this.base_Atk = 10;
        this.base_Def = 10;
        this.base_Speed = 10;
        CalculateStat(lv);
    }

    private void CalculateStat (int lv) {
        this.level = lv;
        switch (type) {
            case "Sword":
                name = "Sword";
                atk = Math.ceil(base_Atk * (1 + 0.1 * level));
                speed = -Math.ceil(base_Speed * (0.1 + (0.04 * level)));
                break;
            case "Shield":
                name = "Shield";
                def = Math.ceil(base_Def * (1 + 0.05 * level));
                speed = -Math.ceil(base_Speed * (0.1 + (0.08 * level)));
                break;
            default:
                break;
        }
    }

    public void setLevel (int lv) {
        CalculateStat(lv);
    }

    public String getName () {return name;}
    public String getType () {return type;}
    public int getLevel () {return level;}
    public double getAtk () {return atk;}
    public double getDef () {return def;}
    public double getSpeed () {return speed;}
    public double getHp () {return hp;}
    public double getMp () {return mp;}
}
