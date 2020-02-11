import java.text.NumberFormat;
import java.util.Arrays;

public class Die {

    int sides;
    int value;
    int[] probabilities = {};

    public Die(int sides) {
        this.sides =sides;
    }
    public Die(int sides, int[] probabilities) throws Exception {

        for (int probability : probabilities) {
            if (probability < 0) {
                throw new NumberFormatException("Negative probabilities not allowed.");
            }
        }
        if (Arrays.stream(probabilities).sum() < 1) {
            throw new Exception("Probability sum must be greater than 0");
        }
        for (int probability : probabilities) {
            try {
                int number = Integer.parseInt(String.valueOf(probability));
            } catch (Exception e) {
                throw new Exception("Only integer values allowed.");
            }
        }
        for (int i = 1; i < probabilities.length; i++) {
            probabilities[i] += probabilities[i-1];
        }
        setProbabilities(probabilities);
        this.sides = sides;
    }

    public void roll() {

        if (this.probabilities.length == 0) {

            int random = (int) (Math.random()*sides +1);
            setValue(random);
        }
        else {
            double random = Math.random()*this.probabilities[this.probabilities.length-1];

            for (int i = 0; i < this.probabilities.length; i++) {
                if (random <= this.probabilities[i]) {
                    setValue(i+1);
                    return;
                }
            }
        }
    }
    public void setValue(int value) {
        this.value = value;
    }
    public void setProbabilities(int[] probabilities) {
        this.probabilities = probabilities;
    }
}
