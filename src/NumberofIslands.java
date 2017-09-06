public class NumberofIslands {


    public int numIslands(char[][] grid) {
        int ans = 0;

        if ( grid.length >= 0 && grid[ 0 ].length > 0 ){

            int[][] prex = new int[ grid.length ][ grid[ 0 ].length ];
            int[][] prey = new int[ grid.length ][ grid[ 0 ].length ];

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {

                    if ( grid[ i ][ j ] == '1' ){

                        prex[ i ][ j ] = i;
                        prey[ i ][ j ] = j;

                        if ( i - 1 >= 0 && grid[ i - 1 ][ j ] == '1' && j - 1 >= 0 && grid[ i ][ j - 1 ] == '1' ){

                            int onex = prex[ i-1 ][ j ];
                            int oney = prey[ i-1 ][ j ];
                            while( !( onex==prex[onex][oney] && oney==prey[onex][oney] ) ){
                                onex = prex[ onex ][ oney ];
                                oney = prey[ onex ][ oney ];
                            }

                            int twox = prex[ i ][ j - 1 ];
                            int twoy = prey[ i ][ j - 1 ];
                            while ( !( twox==prex[ twox ][ twoy ] && twoy==prey[ twox ][ twoy ] ) ){
                                twox = prex[ twox ][ twoy ];
                                twoy = prey[ twox ][ twoy ];
                            }

                            if ( onex==twox && oney==twoy ){

                            }   else    {
                                ans--;
                                prex[ twox ][ twoy ] = onex;
                                prey[ twox ][ twoy ] = oney;
                            }
                            prex[ i ][ j ] = onex;
                            prey[ i ][ j ] = oney;

                        }   else if ( i - 1 >= 0 && grid[ i - 1 ][ j ] == '1' ){

                            int onex = prex[ i-1 ][ j ];
                            int oney = prey[ i-1 ][ j ];
                            while( !( onex==prex[onex][oney] && oney==prey[onex][oney] ) ){
                                onex = prex[ onex ][ oney ];
                                oney = prey[ onex ][ oney ];
                            }
                            prex[ i ][ j ] = onex;
                            prey[ i ][ j ] = oney;

                        } else if ( j - 1 >= 0 && grid[ i ][ j - 1 ] == '1' ){

                            int twox = prex[ i ][ j - 1 ];
                            int twoy = prey[ i ][ j - 1 ];
                            while ( !( twox==prex[ twox ][ twoy ] && twoy==prey[ twox ][ twoy ] ) ){
                                twox = prex[ twox ][ twoy ];
                                twoy = prey[ twox ][ twoy ];
                            }
                            prex[ i ][ j ] = twox;
                            prey[ i ][ j ] = twoy;

                        } else  {
                            ans++;
                        }
                    }
                }
            }

        }

        return ans;
    }
}
