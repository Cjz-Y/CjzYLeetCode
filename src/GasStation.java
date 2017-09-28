public class GasStation {

    /**
     * 思路：从某一个站开始到某一个站没法开下去，那说明即使从中间的某一个站开始也没法开下去，所以从下一个可以的站重新开始
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {

        if ( gas.length == 1 && gas[ 0 ] >= cost[ 0 ] ) return 0;

        int[] value = new int[ gas.length ];
        for (int i = 0; i < gas.length; i++) {
            value[ i ] = gas[ i ] - cost[ i ];
        }

        int ans = -1;
        int number = 0;
        int index = 0;
        int sum = 0;

        int time = 0;

        while ( number != gas.length ){
            time++;
            if ( time > gas.length * 3 ){
                ans = -1;
                break;
            }

            if ( sum + value[ index ] >= 0 ){
                if ( number == 0 ) ans = index;
                number++;
                sum += value[ index ];

            }   else    {
                number = 0;
                sum = 0;
            }
            System.out.println( "index = " + index +  " sum = " + sum + " number = " + number );
            index++;

            if ( index == gas.length ) index = 0;
        }

        return ans;
    }

    public static void main(String[] args) {
        GasStation g = new GasStation();
        int[] testGas = new int[] { 2, 4 };
        int[] testCost = new int[] { 3,4 };
        System.out.println( g.canCompleteCircuit( testGas, testCost ) );
    }
}
