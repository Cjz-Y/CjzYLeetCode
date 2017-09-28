public class JumpGame {
    public boolean canJump(int[] nums) {

        boolean can = true;

        int bound = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if ( i > bound ){
                can = false;
                break;
            }   else    {
                bound = Math.max( bound, i+nums[ i ] );
            }

        }

        return can;
    }

}
