public class FriendCircles {

    int[] pre;

    int findPre( int root ){
        while( pre[ root ] != root ){ root = pre[ root ];   }
        return root;
    }

    public int findCircleNum(int[][] M) {

        int ans = M.length;

        pre = new int[ M.length ];
        for (int i = 0; i < M.length; i++) {
            pre[ i ] = i;
        }

        for (int i = 0; i < M.length; i++) {

            for (int j = 0; j < M[i].length; j++) {
                if ( i != j && M[ i ][ j ] == 1 ){

                    int preOne = findPre( i );
                    int preTwo = findPre( j );
                    if ( preOne != preTwo ){
                        pre[ preTwo ] = preOne;
                        ans--;
                    }

                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        FriendCircles f = new FriendCircles();
    }
}
