public class Main {
    public static void main(String[] args) {
        Character a = new Character("AAAA", 50);
        a.printAllStat();

        Weapons s1 = new Weapons("sword", 50);
        Weapons s2 = new Weapons("shield", 50);
        a.equipWeapon(s1);
        a.printAllStat(); // check sword
        a.equipWeapon(s2);
        a.printAllStat(); // check shield

        Character b = new Character("BBBB", 30);
        b.printStat();

        a.attack(b); // attack test
        b.printStat();

        a.unEquipWeapon(s1); // unequip test
        a.printAllStat();
        a.unEquipWeapon(s2);
        a.printAllStat();
    }
}