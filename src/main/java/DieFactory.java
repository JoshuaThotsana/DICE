public class DieFactory {

    private static int sides;

    public DieFactory(int sides) {
        DieFactory.sides = sides;
    }

    public static int getSides() {
        return sides;
    }

    public static void setSides(int sides) {
        DieFactory.sides = sides;
    }

    public static DieFactory makeDie(int sides){
        setSides(sides);
        System.out.println("A die with " + getSides() + " sides was created.");
        return null;
    }
}
