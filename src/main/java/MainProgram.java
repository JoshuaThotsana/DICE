public class MainProgram {

    public static void main(String[] args) {

        Die die6 = new Die(6);
        die6.roll();

        System.out.println(die6.value);

        Die die20 = new Die(20);
        die20.roll();

        System.out.println(die20.value);

        Die dieDodgy6 = new Die (6, new Number[] {1,1,1,1,1,2});

        dieDodgy6.roll();
        System.out.println(dieDodgy6.value);
//
//        Dice die20 = DiceFactory.makeDie(20);
//        Dice anotherDie20 = DiceFactory.makeDie(20);
    }

}
