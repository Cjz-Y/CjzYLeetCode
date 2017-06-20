/**
 * Created by CJZ.Y on 2017/6/19 0019.
 */
public class AddTwoNumbersII {

    //先预处理了，对短了的进行加长，实际上更优化的做法是stack

  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }



  public int length( ListNode l ){

      if ( l == null ) return 0;

      return length( l.next ) + 1;
  }

  public ListNode preDeal( ListNode l, int x ){

      ListNode pre = l;

      for (int i = 0; i < x; i++) {

          ListNode temp = new ListNode( 0 );
          temp.next = pre;
          pre = temp;

      }

      return pre;
  }

  public ListNode ans( ListNode l1, ListNode l2, boolean head ){

      System.out.println( l1.val +  " " + l2.val );

      if ( l1 == null && l2 == null ) return null;

      ListNode tempNext = ans( l1.next, l2.next, false );

      int index = ( l1.next == null ) ? 0 : ( l1.next.val + l2.next.val + ( ( ( l1.next.val + l2.next.val ) == tempNext.val ) ? 0 : 1 ) ) / 10;

      ListNode temp = new ListNode( ( l1.val + l2.val + index ) % 10 );
      temp.next = tempNext;

      if ( head ){
          if ( ( ( ( l1.val + l2.val ) == temp.val ) ? 0 : 1 ) + l1.val + l2.val > 9 ){

              ListNode tempHead = new ListNode( 1 );
              tempHead.next = temp;

              return tempHead;

          }
      }

      return temp;

  }


  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

      if ( l1 == null ) return l2;
      if ( l2 == null ) return l1;

      int a = length( l1 );
      int b = length( l2 );

      if ( a>b ) return ans( l1, preDeal( l2, a-b ), true );
        else    return ans( preDeal( l1, b-a ), l2, true );
  }
}
