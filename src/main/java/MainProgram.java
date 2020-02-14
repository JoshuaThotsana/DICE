
public class MainProgram {

    private static DieFactory DiceFactory;
    Number nim;

    public static void main(String[] args) throws Exception {

        Die die6 = new Die(6, new Number[]{1,1,1,1,1,2});
        die6.roll();

        Die die20 =  new Die(20);
        die20.roll();

//        DieFactory die20 = DieFactory.makeDie(20);
//
//        DieFactory anotherDie6 = DieFactory.makeDie(6);

        System.out.println(die6.value);
        System.out.println(die20.value);
    }
}
