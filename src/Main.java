public class Main {
    public static void main(String[] args) {
        Character a = new Character("AAAA", 50);
        a.printAllStat();

        Equipments s1 = new Equipments("Sword", 20);
        Equipments s2 = new Equipments("Shield", 20);
        a.equip(s1);
        a.printAllStat(); // equiped sword
        a.equip(s2);
        a.printAllStat(); // equiped shield

        Character b = new Character("BBBB", 30);
        b.printStat();

        a.attack(b); // attack test
        b.printStat();

        Equipments s3 = new Equipments("Sword", 50);
        a.printAllStat(); // before swap equipment
        a.equip(s3);
        a.printAllStat(); // after swap equipment

        b.equip(s2);
        b.printStat(); // equiped shield

        a.attack(b); // attack test 2
        b.printStat();

        a.setLevel(100); // set new level for AAAA
        a.printAllStat();

        a.unEquip(0); // unequip test
        a.printAllStat();
        a.unEquip(1);
        a.printAllStat();
    }
}