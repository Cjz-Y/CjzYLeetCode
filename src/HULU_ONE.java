import java.util.Scanner;
import java.util.Stack;

public class HULU_ONE {

    public static void main(String[] args) {
        Scanner scanner = new Scanner( System.in );
        String input = scanner.nextLine();
        String[] in = input.split( " " );
        int n = Integer.parseInt( in[0] );
        int s = Integer.parseInt( in[1] );

        int[][] funs = new int[ n ][];
        Stack< int[] > stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            input = scanner.nextLine();
            in = input.split( " ");
            int j = in.length + 2;                              //倒数第一位表明他的序号，第二位表明他当前操作的位置

        }


    }
}
