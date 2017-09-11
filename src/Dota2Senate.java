public class Dota2Senate {

    public String predictPartyVictory(String senate) {
        int rnum = 0;
        int dnum = 0;
        for (int i = 0; i < senate.length(); i++) {
            if ( senate.charAt( i ) == 'R' )    rnum++;
            else    dnum++;
        }
        StringBuilder temp = new StringBuilder( senate );
        int now = 0;                        //now>0代表权利在R方，<0代表权利在D方
        int index = 0;
        while ( !( rnum == 0 || dnum == 0 ) ){

//            System.out.println( temp );
            if ( temp.charAt(index) == 'R' ){
                if ( now < 0 ) {
                    rnum--;
                    temp.deleteCharAt( index );
                }   else    index++;
                now++;
            }   else    {
                if ( now > 0 ) {
                    dnum--;
                    temp.deleteCharAt( index );
                }   else    index++;
                now--;
            }
            if ( index == temp.length() ){ index = 0; }
        }

        if ( rnum > 0 ) return "Radiant";
        else    return "Dire";
    }


    public static void main(String[] args) {
        Dota2Senate d = new Dota2Senate();

        System.out.println( d.predictPartyVictory( "RDDRD" ) );
    }
}
