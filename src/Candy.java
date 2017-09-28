public class Candy {

    public int candy(int[] ratings) {

        int[] max = new int[ ratings.length ];
        for (int i = ratings.length - 2; i >= 0; i--) {
            if ( ratings[ i ] > ratings[ i + 1 ] ) max[ i ] += max[ i + 1 ] + 1;
        }

        int ans = max[ 0 ] + 1;
        int now = max[ 0 ] + 1;
        for (int i = 1; i < ratings.length; i++) {

            if ( ratings[ i  ] > ratings[ i - 1 ] ){
                now = Math.max( now + 1, max[ i ] + 1 );
            }   else    {
                now = max[ i ] + 1;
            }
            ans+=now;
//            System.out.println( now );
        }

        return ans;
    }

    public static void main(String[] args) {
        Candy c = new Candy();
        int[] test = new int[]{ 1,3,4,3,2,1 };
        System.out.println( c.candy( test ) );
    }
}
