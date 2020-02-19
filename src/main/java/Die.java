import java.util.Arrays;
import java.util.stream.IntStream;

public class Die {

    int sides;
    int value;
    Number[] probabilities;

    public Die(int sides) {
        this.sides = sides;
    }

    public Die(int sides, Number[] probabilities) {

        this.sides = sides;
        this.probabilities = probabilities;

    }

    public void roll() throws Exception {

        isInteger();
        negativeNumbers();
        sumLessOne();


        if(probabilities == null) {
            this.probabilities = new Number[this.sides];
            Arrays.fill(probabilities,1);
        }
        int cumulativeSum = 0;

        for (Number probability : this.probabilities) {
            cumulativeSum += Integer.parseInt(probability.toString());
        }

        int randomNumber = (int) (Math.random() * cumulativeSum +1);

        for (int i = 0; i < this.sides; i++) {
            randomNumber -= Integer.parseInt(this.probabilities[i].toString());

            if(randomNumber <= 0) {
                setValue(i+1);
                return;
            }
        }
    }

    public void negativeNumbers() throws Exception {

        try {
            for (Number probability : this.probabilities) {
                if (Double.parseDouble(probability.toString()) < 0) {
                    throw new Exception();
                }
            }
        } catch (Exception e) {
            System.out.println("Negative probabilities not allowed.");
            System.exit(0);
        }
    }

    public void sumLessOne() throws Exception {

        int weightSum = 0;

        for (Number probability : this.probabilities) {
            weightSum += Double.parseDouble(probability.toString());
        }

        try {
            if (weightSum < 1) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Probability sum must be greater than 0.");
            System.exit(0);
        }
    }

    public void isInteger() {
        try {
            for (Number probability : probabilities) {
                if (!(probability instanceof Integer)) {
                    throw new Exception();
                }
            }
        } catch (Exception e) {
            System.out.println("Only integer values allowed.");
            System.exit(0);
        }
    }


    public void setValue(int value) {
        this.value = value;
    }
}
