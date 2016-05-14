import ru.itis.inform.Iterator;
import ru.itis.inform.LinkedList;

import java.util.Scanner;


public class SetsArrayImpl implements Sets {

    private int[] set;

    private final static int DEFAULT_SIZE = 50;


    public SetsArrayImpl()
    {
        set = new int [DEFAULT_SIZE];

        for (int i=0; i<DEFAULT_SIZE;i++)
        {
            set[i]=i;

        }

    }

    public void readAndShow()
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i=0; i<n;i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (findSet(a) != findSet(b)) {
                union(findSet(a), findSet(b));
                System.out.println(a + " " + b);
            } else {
               for (int j = 0; j < DEFAULT_SIZE; j++) {
                    if (set[j] == findSet(a)) {
                        System.out.print(j+" ");
                    }
               }
                System.out.println(" ");
            }

        }
    }


    public int findSet(int element) {
        return set[element];
    }

    public void union(int A, int B) {

        for (int i=0; i<set.length;i++)
        {
            if (set[i]==B)
            {
                set[i]=A;

            }
        }

    }
}
