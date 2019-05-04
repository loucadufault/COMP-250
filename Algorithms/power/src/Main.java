import java.util.Random;

public class Main {
    public static int iterativePower(int base, int power) {
        int product = 1;
        for (int i = 0; i < power; i++) {
            product = base * product;
        }
        return product;
    }

    public static int recursivePower(int base, int power) {
        if (power == 0) { //base case
            return 1;
        } else { //recursive case
            return base * recursivePower(base, power-1);
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        final int RANGE = 10;
        int testBase = random.nextInt(RANGE);
        int testPower = random.nextInt(RANGE);

        int iterativeResult = iterativePower(testBase, testPower);
        int recursiveResult = recursivePower(testBase, testPower);

        assert (iterativeResult == recursiveResult);
        int result = iterativeResult;
        
        System.out.println("Calculating " + testBase + "^" + testPower);
        System.out.println("= " + result);
    }
}
