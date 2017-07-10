import java.util.ArrayList;
import java.util.List;

/**
 * 括号摆放规律：在上一个括号中，在上上个括号中，在。。。最初的括号中
 * Created by CjzY on 2017/7/10.
 */
public class GenerateParentheses {

    List< String > ans = new ArrayList<>();

    public void dp( int n, StringBuilder s ){

    }

    public List<String> generateParenthesis(int n) {

        dp( n, new StringBuilder( "") );



        return ans;
    }
}
