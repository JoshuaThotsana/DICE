public class DiceFactory {

    public static SuperClass makeDie(int sides) {
        if(sides == 6) {
            return new Die6();
        } else {
            return new Die20();
        }
    }
}
