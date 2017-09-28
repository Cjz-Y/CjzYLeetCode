import java.util.Scanner;
import java.util.Stack;

public class XIAOMI_1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner( System.in );

        String text = scanner.next();
        String pattern = scanner.next();


        int ans = Integer.MAX_VALUE;
        int ansStart = -1, ansEnd = -1;

        int start1 = 0, current1 = 0;
        int start2 = 0, current2 = 0;

        for (int i = 0; i < text.length(); i++) {

            if ( text.charAt( i ) == pattern.charAt( current1 ) ){
                if ( current1 == 0 ) start1 =i;
                current1++;
            }

            if ( text.charAt( i ) == pattern.charAt( current2 ) ){
                if ( current2 == 0 ) start2 = i;
                current2++;
            }

            if ( current1 == current2 ){
                start1 = start2;
                current2 = 0;
                start2 = 0;
            }

            if ( current1 == pattern.length() ){
                if ( i - start1 < ans ){
                    ans = i - start1;
                    ansStart = start1;
                    ansEnd = i;
                }

                current1 = current2;
                start1 = start2;
                current2 = 0;
                start2 = 0;
            }
        }

        System.out.println( ansStart );
        System.out.println( ansEnd );



    }
}
