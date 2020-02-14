
public class MainProgram {

    Number nim;

    public static void main(String[] args) throws Exception {

        Die die6 = new Die(6, new Number[]{1,1,1,1,1,2});
        die6.roll();

        Die die20 =  new Die(20);
        die20.roll();

//        SuperClass die20 = DiceFactory.makeDie(20);
//
//        SuperClass die6 = DiceFactory.makeDie(6);

        System.out.println(die6.value);
        System.out.println(die20.value);
    }
}
