/**
 * Created by CJZ.Y on 2017/5/23 0023.
 */
public class DetectCapital {

    public boolean detectCapitalUse(String word) {

        if ( word.equals( word.toLowerCase() ) ) return true;
        if ( word.equals( word.toUpperCase() ) ) return true;

        for ( int i = 0; i < word.length(); i++ ){

            if ( i == 0 && (word.charAt( i ) >= 'a' && word.charAt( i ) <= 'z' )) return false;
            if ( i > 0 && (word.charAt( i ) >= 'A' && word.charAt( i ) <= 'Z' )) return false;
        }


        return true;

    }
}
