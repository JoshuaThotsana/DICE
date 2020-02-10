public class Die {

    int sides;
    int value;
    int[] probabilities;

    public Die(int sides) {
        this.sides =sides;
    }
    public Die(int sides,int[] probabilities){
        this.probabilities = new int[sides];
        this.sides = sides;
        this.probabilities = probabilities;
    }
    public void roll() {

        int prop = (int) (Math.random() * 7) +1;
        if (prop == 6 || prop == 7) {
            setValue(6);
        }
        else {
            setValue(prop);
        }
    }

    public void setValue(int value) {
        this.value = value;
    }
}
