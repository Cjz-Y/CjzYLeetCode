import java.util.ArrayList;
import java.util.List;

/**
 * Created by CjzY on 2017/7/24.
 */
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {

        Object[] a = triangle.toArray();

        System.out.println(triangle);

        if (triangle.size() == 1) return triangle.get(0).get(0);

        int ans = Integer.MAX_VALUE;

        int[] f = new int[triangle.size()];
        int[] g = new int[triangle.size()];

        g[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) f[j] = g[j] + triangle.get(i).get(j);
                else if (j == i) f[j] = g[j - 1] + triangle.get(i).get(j);
                else {
                    f[j] = g[ j ] < g[ j -1 ] ? g[ j ] + triangle.get(i).get(j) : g[ j -1 ] + triangle.get( i ).get( j );
                }
                if (i == triangle.size() - 1 && f[j] < ans) ans = f[j];

            }

            g = f.clone();                                                                                              //注意数组之间直接赋值是引用的传递，所以会导致f,g指向同一个对象

        }

        return ans;

    }

    public static void main(String[] args) {
        Triangle t = new Triangle();
        List<Integer> b = new ArrayList<Integer>();
        b.add(-1);

        List<Integer> c = new ArrayList<Integer>();
        c.add(2);
        c.add(3);

        List<Integer> d = new ArrayList<Integer>();
        d.add(1);
        d.add(-1);
        d.add(-3);


        List<List<Integer>> a = new ArrayList<>();
        a.add(b);
        a.add(c);
        a.add(d);

        t.minimumTotal(a);
    }
}
