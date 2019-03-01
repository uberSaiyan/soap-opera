import java.util.*;

public class LogSearch {
    private static int count = 0;

    public static void main(String[] args) {
        Random r = new Random();
        long answer = r.nextLong();
        answer /= 2;
        //long answer = -1000;
        System.out.println("Answer is " + answer);
        System.out.println("Guesses: " + noOfGuesses(answer));
    }

    static int noOfGuesses(long answer) {
        if (answer == 0) {
            return 1;
        }
        else {
            long temp = findSmallestSquareBiggerThan(answer);
            if (temp == answer) {
                return count + 1;
            }
            else {
                return temp > 0 ? count + 1 + findBetweenPositive(answer, temp / 2, temp)
                                : count + 1 + findBetweenNegative(answer, temp, temp / 2);
            }
        }
    }

    static int findBetweenPositive(long answer, long smaller, long larger) {
        long temp = (smaller + larger) / 2;
        //System.out.println(temp);
        assert smaller <= answer && larger >= answer : "bad bounds"; 
        if (temp == answer) {
            return 1;
        }
        else if (temp < answer) {
            return 1 + findBetweenPositive(answer, temp, larger);
        }
        else {
            return 1 + findBetweenPositive(answer, smaller, temp);
        }
    }

    static int findBetweenNegative(long answer, long smaller, long larger) {
        long temp = (smaller + larger) / 2;
        //System.out.println(temp);
        assert smaller <= answer && larger >= answer : "bad bounds"; 
        if (temp == answer) {
            return 1;
        }
        else if (temp < answer) {
            return 1 + findBetweenNegative(answer, temp, larger);
        }
        else {
            return 1 + findBetweenNegative(answer, smaller, temp);
        }
    }

    static long findSmallestSquareBiggerThan(long answer) {
        assert answer > Long.MIN_VALUE / 2 && answer < Long.MAX_VALUE / 2;
        long result;
        if (answer < 0) {
            result = -1;
            while (result > answer) {
                result *= 2;
                count++;
                //System.out.println(result);
            }
        }
        else {
            result = 1;
            while (result < answer) {
                result *= 2;
                count++;
                //System.out.println(result);
            }
        }
        return result;
    }
}
