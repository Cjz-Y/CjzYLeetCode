class JudgeRouteCircle {
    fun judgeCircle( moves: String ): Boolean {
        var x: Int = 0
        var y: Int = 0

        for( c in moves ){

            when( c ){
                'U' -> y++
                'D' -> y--
                'L' -> x--
                'R' -> x++
            }
        }

        return ( x==0 && y==0 )

    }

    fun main( args: Array< String > ){
         println( judgeCircle("UD" ) )
    }
}