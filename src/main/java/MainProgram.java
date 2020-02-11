import java.util.Arrays;

public class MainProgram {

    public static void main(String[] args) throws Exception {

        int n = 0;

        do {
            Die die6 = new Die(10);
            die6.roll();

//        Die die20 =  new Die(20);
//        die20.roll();

            System.out.println(die6.value);
//        System.out.println(die20.value);
            n++;
        } while (n<100);


    }

}
