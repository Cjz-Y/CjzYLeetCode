import java.util.Iterator;
import java.util.Stack;

public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {

        int[] time = new int[ 27 ];
        boolean[] exist = new boolean[ 27 ];

        for (int i = 0; i < s.length(); i++) {
            time[ s.charAt( i ) - 'a' ]++;
            exist[ s.charAt( i ) - 'a' ] = false;
        }

        Stack stack = new Stack();

        for (int i = 0; i < s.length(); i++) {
            if ( exist[ s.charAt( i ) - 'a' ] ){
                time[ s.charAt( i ) - 'a' ]--;
                continue;
            }
            while ( !stack.isEmpty() &&                                                             //当栈是非空的时候
                    time[ ( char )stack.peek() - 'a' ] > 0 &&                                   //当栈顶的元素在队列中还有的时候
                    s.charAt( i ) < ( char )stack.peek() ){                                        //如果字典序小于现在的栈顶字典序就

                char j = ( char )stack.pop();
//                    System.out.println( j );
                exist[ j - 'a' ] = false;
            }
            if ( !exist[ s.charAt( i ) - 'a' ] ){
                stack.push( s.charAt( i ) );
                exist[ s.charAt( i ) - 'a' ] = true;
                time[ s.charAt( i ) - 'a' ]--;
            }
        }

        StringBuilder ss = new StringBuilder();
        Iterator iterator = stack.iterator();
        while ( iterator.hasNext() ){
            ss.append( iterator.next() );
        }

        return ss.toString();
    }

    public static void main(String[] args) {
        RemoveDuplicateLetters r = new RemoveDuplicateLetters();
        System.out.println( r.removeDuplicateLetters( "bcbac" ) );
    }
}
