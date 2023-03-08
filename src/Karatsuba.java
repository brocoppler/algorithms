public class Karatsuba {

    Karatsuba() {}

    // 10^n(ac) + 10^n/2(ad + bc) + bd
    public static long karatsuba(int first, int second) {
        if (first < 10 && second < 10)
            return first * second;

        if (first == 0 || second == 0)
            return 0;

        int firstLength = (int) Math.log10(first) + 1;
        int divideBy = 0;
        if (firstLength % 2 != 0) {
            first *= 10;
            firstLength++;
            divideBy++;
        }

        int secondLength = (int) Math.log10(second) + 1;
        if (secondLength % 2 != 0) {
            second *= 10;
            secondLength++;
            divideBy++;
        }

        if (firstLength > secondLength) {
            int difference = firstLength - secondLength;
            second *= Math.pow(10, difference);
            secondLength += difference;
            divideBy += difference;
        } else if (secondLength > firstLength) {
            int difference = secondLength - firstLength;
            first *= Math.pow(10, difference);
            firstLength += difference;
            divideBy += difference;
        }

        /*
         * Optimize by doing the bigger number first to get the length
         * Then match that length with the other number by padding zeros in the front? or multiplying then later dividing
         * also, make them both even length?
         */
        int[] firstSplit = getSplitNumber(first, firstLength);
        int[] secondSplit = getSplitNumber(second, secondLength);
        int n = firstLength; // both equal now
        int a = firstSplit[0];
        int b = firstSplit[1];
        int c = secondSplit[0];
        int d = secondSplit[1];

        long karatOne = karatsuba(a, c);
        long karatTwo = karatsuba(a + b, c + d);
        long karatThree = karatsuba(b, d);

        long karatProduct = (long) (
                Math.pow(10, n) * (karatOne)
                        + Math.pow(10, n/2) * (karatTwo - karatThree - karatOne)
                        + karatThree);

        return (long) (karatProduct / Math.pow(10, divideBy));
    }

    /*
     * Returns the number split (a & b or c & d)
     */
    private static int[] getSplitNumber(int number, int length) {
        int divisor = (int) Math.pow(10, length / 2);
        int[] numbers = new int[2];
        numbers[0] = number / divisor;
        numbers[1] = number % divisor;

        return numbers;
    }
}
