import java.text.NumberFormat;
import java.util.Arrays;

public class Die {

    int sides;
    int value;
    Number[] probabilities = {};

    public Die(int sides) {
        this.sides =sides;
    }
    public Die(int sides, Number[] probabilities) throws Exception {
        if (negatives(probabilities)) {
            throw new Exception("Negative probabilities are not allowed.");
        }
        if (sumLessOne(probabilities)) {
            throw new Exception("Probability sum must be greater than 0.");
        }
        if (!isInteger(probabilities)) {
            throw new Exception("Only integer values are allowed.");
        }
        probabilities = cumulativeSum(probabilities);
        this.sides = sides;
        this.probabilities = probabilities;
    }

    public void roll() {

        if (this.probabilities.length == 0) {

            int random = (int) (Math.random()*sides +1);
            setValue(random);
        }
        else {
            double random = Math.random()*this.probabilities[this.probabilities.length-1].intValue();

            for (int i = 0; i < this.probabilities.length; i++) {
                if (random <= this.probabilities[i].intValue()) {
                    setValue(i+1);
                    return;
                }
            }
        }
    }
    void setValue(int value) {
        this.value = value;
    }
    void setProbabilities(Number[] probabilities) {
        this.probabilities = probabilities;
    }

    Number[] cumulativeSum(Number[] probabilities) {
        for (int i = 1; i < probabilities.length; i++) {
            probabilities[i] = probabilities[i].intValue() + probabilities[i-1].intValue();
        }
        return probabilities;
    }

    boolean negatives(Number[] probabilities){
        for (Number probability : probabilities) {
            if(probability.intValue() < 0 ) {
                return true;
            }
        }
        return false;
    }

    boolean sumLessOne(Number[] probabilities) {
        double sum = 0.00;
        for (Number probability : probabilities) {
            sum = sum + probability.doubleValue();
        }
        return sum < 1;
    }

    boolean isInteger(Number[] probabilities) {
        for (Number probability : probabilities) {
            if (!(probability instanceof Integer)) {
                return false;
            }
        }
        return true;
    }
}
