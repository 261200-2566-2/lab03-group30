public class Equipments {
    private String name, type;
    private int level;
    private int base_Atk, base_Def, base_Spd; // base stat for rebalance
    private int atk, def, hp, mp, spd; // stat
    public Equipments (String type, int lv) {
        this.type = type;
        this.base_Atk = 10;
        this.base_Def = 10;
        this.base_Spd = 10;
        CalculateStat(lv);
    }

    private void CalculateStat (int lv) {
        this.level = lv;
        switch (type) {
            case "Sword":
                name = "Sword";
                atk = (int)Math.ceil(base_Atk * (1 + 0.1 * level));
                spd = (int)-Math.ceil(base_Spd * (0.1 + (0.04 * level)));
                break;
            case "Shield":
                name = "Shield";
                def = (int)Math.ceil(base_Def * (1 + 0.05 * level));
                spd = (int)-Math.ceil(base_Spd * (0.1 + (0.08 * level)));
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
    public double getSpeed () {return spd;}
    public double getHp () {return hp;}
    public double getMp () {return mp;}
}
