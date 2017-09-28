import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

public class RemoveKDigits {

    int[] nums;
    int[] pos;


    public void qsort( int head, int tail, int[] nums, int[] pos ){

        if ( head > tail ) return;

        int i = head;
        int j = tail;
        int temp = nums[ head ];
        int temppos = pos[ head ];

        while ( i < j ){

            while ( ( nums[ j ] < temp || ( nums[ j ] == temp && pos[ j ] >= temppos ) ) && i < j ) j--;
            while ( ( nums[ i ] > temp || ( nums[ i ] == temp && pos[ i ] <= temppos ) ) && i < j ) i++;

            if ( i < j ){
                int a = nums[ i ];
                nums[ i ] = nums[ j ];
                nums[ j ] = a;
                int b = pos[ i ];
                pos[ i ] = pos[ j ];
                pos[ j ] = b;
            }

        }

        nums[ head ] = nums[ i ];
        nums[ i ] = temp;
        pos[ head ] = pos[ i ];
        pos[ i ] = temppos;

        qsort( head, i - 1, nums, pos );
        qsort( i + 1, tail, nums, pos );


    }

    public String removeKdigits1(String num, int k) {

        StringBuilder ans = new StringBuilder( num );

        if ( k >= num.length() || num.equals( "" ) )    return "0";
        nums = new int[ num.length() ];
        pos = new int[ num.length() ];

        for (int i = 0; i < num.length(); i++) {
            nums[ i ] = num.charAt( i ) - '0';
            pos[ i ] = i;
        }

        qsort( 0, num.length() - 1, nums, pos );

        qsort( 0, k-1, pos, nums );


        for (int i = 0; i < k; i++) {
            ans.deleteCharAt( pos[ i ] );
        }

        return ans.toString();
    }

    //对于在每次需要考虑当前一个最值的情况下，可以使用栈来存储最值，不断pop出
    public String removeKdigits(String num, int k) {

        if ( num.length() == k )    return "0";
        Stack< Character > stack = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            if ( stack.empty() ){
                stack.push( num.charAt( i ) );
            }   else    {

                while( k > 0 && !stack.empty() && stack.peek() > num.charAt( i ) ){
                    stack.pop();
                    k--;
                }
                stack.push( num.charAt( i ) );

            }
        }

        while ( k > 0 && !stack.empty() ){ stack.pop(); k--; }
        StringBuilder ans = new StringBuilder();
        Iterator iterator = stack.iterator();
        while ( iterator.hasNext() ) {
            ans.append( iterator.next() );
        }

        while ( ans.length() > 1 && ans.charAt( 0 ) == '0' ) ans.deleteCharAt( 0 );
        return ans.toString();
    }

    public static void main(String[] args) {
        RemoveKDigits r = new RemoveKDigits();
        System.out.println( r.removeKdigits( "1432219", 3 ) );
    }
}
