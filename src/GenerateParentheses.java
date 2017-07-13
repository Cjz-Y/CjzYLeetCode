import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 括号摆放规律：在上一个括号中，在上上个括号中，在。。。最初的括号中
 * 所以 其实并不是字符串的操作，整体的规律应该是给n个不同的东西，求他们所有的进出栈的顺序
 * Created by CjzY on 2017/7/10.
 */
public class GenerateParentheses {

    List< String > ans = new ArrayList<>();


    public void dp( int n, Stack< Integer > stack, List< Integer > temp ){


        System.out.println( stack );
        System.out.println( temp );


        if ( n == 0 ){

            Stack< Integer > stack1 = (Stack<Integer>) stack.clone();
            List< Integer > temp1 = temp.subList( 0, temp.size() );

            while ( !stack1.isEmpty() ){

                int a = stack1.pop();
                temp1.add( -a );

            }
            System.out.println( temp1 );
            return;
        }

        stack.push( n );
        temp.add( n );
        dp( n - 1, stack, temp );
        stack.pop();
        temp.remove( n );

        while ( !stack.isEmpty() ){

            int a = stack.pop();
            temp.add( -a );

            stack.push( n );
            temp.add( n );
            dp( n - 1, stack, temp );
            stack.pop();
            temp.remove( n );

        }
    }

    public List<String> generateParenthesis(int n) {

        Stack< Integer > stack = new Stack<>();

        List< Integer > temp = new ArrayList<>();

        dp( n, stack, temp );
        return ans;
    }


    public static void main(String[] args) {
        GenerateParentheses g = new GenerateParentheses();
        g.generateParenthesis( 3 );
    }
}
