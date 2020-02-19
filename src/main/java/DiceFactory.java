public class DiceFactory {


    public static Dice makeDie(int sides){

        if(sides == Dice.Die6) {
            return new Die6(6);
        }

        else if (sides == Dice.Die10) {
            return new Die10(10);
        }

        else if (sides == Dice.Die20) {
            return new Die20(20);
        }

        else {
            return null;
        }
    }
}
