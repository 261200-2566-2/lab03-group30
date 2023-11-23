import java.awt.desktop.AboutEvent;

public class Weapons {
    private String name, type;
    private double base_Atk, base_Def;
    public Weapons (String type, double base_Value) {
        this.type = type;
        switch (type) {
            case "sword":
                base_Atk = base_Value;
                break;
            case "shield":
                base_Def = base_Value;
                break;
            default:
                break;
        }
    }

    public String getType () {return type;}
    public double getBaseAtk () {return base_Atk;}
    public double getBase_Def () {return base_Def;}
}
