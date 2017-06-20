/**
 * Created by CJZ.Y on 2017/5/24 0024.
 */
public class SumOfTwoIntegers {

    public int getSum(int a, int b) {

        /**
         * 在位运算中a^b可以当作是不进位的加法，a&b可以当作是每次a+b所产生进位的位置，所以a&b<<1就可以当作是每次的进位的数值，只需要把a^b的结果跟a&b<<1的结果相加即可
         */

        while ( b != 0 ){

           int x = a ^ b;
           int y = ( a & b ) << 1;
           a = x; b = y;
       }

        return a;
    }

    public static void main( String[] args ){

        SumOfTwoIntegers s = new SumOfTwoIntegers();

        s.getSum( 1, 0 );
    }
}
