/**
 * Created by CjzY on 2017/7/13.
 */
public class UglyNumber {

    public boolean isUgly(int num) {

        if ( num == 0 ) return false;

        while ( num % 2 == 0 ) num = num / 2;                                               //优化  num%2可以写成 num&1 加快速度
        while ( num % 3 == 0 ) num = num / 3;
        while ( num % 5 == 0 ) num = num / 5;
        if ( num == 1   )   return true;
        else    return false;
    }
}
