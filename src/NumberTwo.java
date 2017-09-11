import java.util.Stack;

public class NumberTwo {

    int ans = 1;

    void dec( StringBuilder str ){
        int tempSum = 0;
        int stack = 0;
        int index = 0;
        str.deleteCharAt( 0 );
        for (int i = 0; i < str.length(); i++) {
            if ( str.charAt( i ) == '(' ){
                stack++;
            }   else    {
                stack--;
                tempSum++;
            }
            if ( stack == -1 ) {
                index = i;
                break;
            }
        }
        str.deleteCharAt( index );
        System.out.println( str );
        ans = ans*tempSum;

    }

    public int solution( StringBuilder str ){

        while ( !str.toString().equals( "" ) ){
            dec( str );
        }

        return ans;

    }

    public static void main(String[] args) {

        NumberTwo n = new NumberTwo();
        System.out.println( n.solution( new StringBuilder( "(((())))" ) ) );
    }
}
