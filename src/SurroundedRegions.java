import java.util.ArrayList;
import java.util.List;

public class SurroundedRegions {

    //0代表没有查找过，1代表查找过
    //最后的优化就是因为边缘区域都会在最外面的循环中查找一遍，所以不要在dfs的时候把边缘计算进去，减少递归层数



    public void dfs( char[][] board, int i, int j ){

       board[ i ][ j ] = 'A';

        if ( i + 1 <= board.length - 2 && board[i+1][j] == 'O' ) dfs( board, i+1, j );
        if ( i - 1 >= 1 && board[i-1][j] == 'O' ) dfs( board, i-1, j );
        if ( j + 1 <= board[0].length - 2 && board[i][j+1] == 'O' ) dfs( board, i, j+1 );
        if ( j - 1 >= 1 && board[i][j-1] == 'O' ) dfs( board, i, j-1 );
    }

    public void solve1(char[][] board) {

        if ( board.length > 0 ){

            for ( int i = 0; i <board.length; i++ ) {
                if ( board[ i ][ 0 ] == 'O' ){
                    dfs( board, i, 0 );
                }

                if ( board[ i ][ board[ 0 ].length - 1 ] == 'O' ){
                    dfs( board, i, board[0].length - 1 );
                }
            }

            for (int i = 0; i < board[ 0 ].length; i++) {
                if ( board[ 0 ][ i ] == 'O' ){
                    dfs( board, 0, i );
                }

                if ( board[ board.length - 1 ][ i ] == 'O'  ){
                    dfs( board, board.length - 1, i );
                }

            }

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if ( board[ i ][ j ] == 'O' ) board[ i ][ j ] = 'X';
                    else if ( board[ i ][ j ] == 'A' )board[ i ][ j ] = 'O';
                }
            }


        }

    }

    int[][] status;

    List< pos > temp;

    boolean isOpend = false;            //代表这个块是否是开放的 默认是不开放的，只要找到边界上的点 就是开放的，整个部分就不必要修改

    class pos{
        int x, y;
        pos( int x, int y ){
            this.x = x;
            this.y = y;
        }
    }

    public void bfs( char[][] board, int x, int y ){

        ArrayList< pos > current = new ArrayList<>();
        ArrayList< pos > next = new ArrayList<>();

        current.add( new pos( x, y ) );

        while ( !current.isEmpty() ){

            for ( pos point : current ) {

                status[ point.x ][ point.y ] = 1;
                if ( point.x - 1 >= 0 && status[ point.x - 1 ][ point.y ] == 0 && board[ point.x - 1 ][ point.y ] == 'O' ){
                    next.add( new pos(point.x - 1, point.y ) );
                }
                if ( point.x + 1 < board.length && status[ point.x + 1 ][ point.y ] == 0 && board[ point.x + 1 ][ point.y ] == 'O' ){
                    next.add( new pos(point.x + 1, point.y ) );
                }
                if ( point.y - 1 >= 0 && status[ point.x ][ point.y - 1 ] == 0 && board[ point.x ][ point.y - 1 ] == 'O' ){
                    next.add( new pos( point.x, point.y - 1 ) );
                }
                if ( point.y + 1 < board[0].length && status[ point.x ][ point.y + 1 ] == 0 && board[ point.x ][ point.y + 1 ] == 'O' ){
                    next.add( new pos( point.x, point.y + 1 ) );
                }

            }

            current = next;
            next = new ArrayList<>();

        }

    }


    public void solve(char[][] board) {

        if ( board.length > 0 ){

            status = new int[ board.length ][ board[0].length ];

            for ( int i = 0; i <board.length; i++ ) {
                if ( board[ i ][ 0 ] == 'O' && status[ i ][ 0 ] == 0 ){
                    bfs( board, i, 0 );
                }

                if ( board[ i ][ board[ 0 ].length - 1 ] == 'O' && status[ i ][ board[0].length - 1 ] == 0 ){
                    bfs( board, i, board[0].length - 1 );
                }
            }

            for (int i = 0; i < board[ 0 ].length; i++) {
                if ( board[ 0 ][ i ] == 'O' && status[ 0 ][ i ] == 0 ){
                    bfs( board, 0, i );
                }

                if ( board[ board.length - 1 ][ i ] == 'O' && status[ board.length - 1 ][ i ] == 0 ){
                    bfs( board, board.length - 1, i );
                }

            }

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if ( board[ i ][ j ] == 'O' && status[ i ][ j ] == 0 ) board[ i ][ j ] = 'X';
                }
            }

        }



    }
}
