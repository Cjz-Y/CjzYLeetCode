class FindAnagramMappings {
    fun anagramMappings(A: IntArray, B: IntArray): IntArray {


        var used= kotlin.BooleanArray( A.size )
        for( i in 0..used.size - 1 ){ used[ i ] = false }
        var ans = IntArray( A.size )
        for( i in 0.. A.size - 1  ){
            for( j in 0.. B.size-1 ){
                if ( !used[ j ] && A[ i ] == B[ j ] ){
                    ans[ i ] = j
                    used[ j ] = true
                    break
                }
            }
        }

        return ans



    }
}