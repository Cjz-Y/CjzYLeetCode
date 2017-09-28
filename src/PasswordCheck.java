import java.util.Scanner;

public class PasswordCheck {

    boolean check( String s ){

        if ( s.length() < 8 )   return false;
        if ( s.charAt( 0 ) <= '9' && s.charAt( 0 ) >= '0' ) return false;
        boolean large = false;
        boolean small = false;
        boolean num = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt( i );
            if ( !( ( c>='0' && c<='9') || ( c>='a' && c<='z' ) || ( c>='A' && c<='Z' ) ) ) return false;
            if ( ( c>='0' && c<='9') ) num = true;
            if ( ( c>='a' && c<='z' ) ) small = true;
            if ( ( c>='A' && c<='Z' ) ) large = true;
        }
        if ( large && small && num )    return true;
        if ( large && small )   return true;
        if ( small && num ) return true;
        if ( large && num ) return true;

        return false;
    }

    public static void main(String[] args) {
        PasswordCheck p = new PasswordCheck();
        Scanner scanner = new Scanner( System.in );
        int n = scanner.nextInt();
        String[] ss = new String[ n ];
        for (int i = 0; i < n; i++) {
            ss[ i ] = scanner.next();
        }

        for (int i = 0; i < n; i++) {
            System.out.println( p.check( ss[ i ] ) ? "YES" : "NO" );
        }

    }
}
