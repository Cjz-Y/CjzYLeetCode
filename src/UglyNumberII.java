/**
 * Created by CjzY on 2017/7/13.
 */
public class UglyNumberII {

    boolean[] f;
    public boolean isUgly(int num) {

        if ( num == 0 ) return false;

        while ( num % 2 == 0 ) {
            num = num / 2;
            if ( f[ num ] ) return false;
        }                                      //优化  num%2可以写成 num&1 加快速度
        while ( num % 3 == 0 ) {
            num = num / 3;
            if ( f[ num ] ) return false;
        }
        while ( num % 5 == 0 ) {
            num = num / 5;
            if ( f[ num ] ) return false;
        }
        if ( num == 1   )   return true;
        else    return false;
    }

    public int nthUglyNumber(int n) {

        int index = 0;
        int num = 0;
        f = new boolean[ 1222000000 ];

        while ( index != n ){

            num++;
            if ( isUgly( num ) ) {
                index++;
                //System.out.println( " index = " + index + " value = " +  num );
            }
            else    f[ num ] = true;
        }

        return num;
    }

    public static void main(String[] args) {
        UglyNumberII u = new UglyNumberII();
        u.nthUglyNumber( 1690 );
    }
}
