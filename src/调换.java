import java.util.Scanner;

public class 调换 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner( System.in );
        int n = scanner.nextInt();
        int[] num = new int[ n ];
        for (int i = 0; i < n; i++) {
            num[ i ] = scanner.nextInt();
        }

        int index = 1;
        for (int i = 0; i < n; i++) {
            if ( num[ i ] != index ){

                int j = i;
                while ( num[ j ] != index ) j++;
                int temp = num[ i ];
                num[ i ] = num[ j ];
                num[ j ] = temp;
                break;
            }   else    {
                index++;
            }
        }

        if ( index == n ){
            int temp = num[ num.length - 1 ];
            num[ num.length - 2 ] = num[ num.length -1 ];
            num[ num.length - 1 ] = temp;
        }

        for (int i = 0; i < n; i++) {
            System.out.print( num[ i ] );
        }
    }
}
