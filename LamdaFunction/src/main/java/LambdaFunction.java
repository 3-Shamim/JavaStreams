public class LambdaFunction {
    public static void main(String[] args) {

        //Arithmetic arithmetic = (int i, int j) -> i + j;
        Arithmetic arithmetic = new Arith();
        System.out.println(arithmetic.operation(4, 5));

        // prime or not
        System.out.println("\nPrime Or Not");
        CheckPrime checkPrime = (int i) -> i % 2 == 0;
        if(checkPrime.isPrime(10))
        {
            System.out.println("Prime Number !");
        }
        else
        {
            System.out.println("Not Prime !");
        }

        System.out.println("\nArithmetic Check");

        Arithmetic sum = (int i, int j) -> i + j;
        Arithmetic sub = (int i, int j) -> i - j;
        Arithmetic mult = (int i, int j) -> i * j;
        Arithmetic div = (int i, int j) -> i / j;

        System.out.println(sum.operation(10,5));
        System.out.println(sub.operation(10,5));
        System.out.println(mult.operation(10,5));
        System.out.println(div.operation(10,5));

        // Sum of a number
        System.out.println("\nSum of a number");
        SumOfANumber sumOfANumber = (int i) -> {

            int rem, add = 0;
            int temp = i;

            while(temp != 0)
            {
                rem = temp % 10;
                add += rem;
                temp /= 10;
            }
            return add;
        };

        System.out.println(sumOfANumber.sumOfNumber(123));


    }

    interface CheckPrime {
        boolean isPrime(int i);
    }

    interface SumOfANumber{
        int sumOfNumber(int i);
    }

    static class Arith implements Arithmetic {

        @Override
        public double operation(int i, int j) {
            return i + j;
        }
    }
}
