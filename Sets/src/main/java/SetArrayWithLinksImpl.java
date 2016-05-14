import java.util.Scanner;

public class SetArrayWithLinksImpl implements Sets{
    private int set[];

    private final int DEFAULT_SIZE=50;

    public SetArrayWithLinksImpl() {

        set=new int[DEFAULT_SIZE];

        for (int i=0; i<DEFAULT_SIZE;i++) {
            set[i]=i;
        }

    }
    public void readAndShow() {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int t = a;
            int j = b;

            while (t != set[t]) {
                t = findSet(t);
            }

            while (j != set[j]) {
                j = findSet(j);
            }

            if (t != j) {
                System.out.println(a + " " + b);
                union(j,t);
            }

        }
    }
    public int findSet(int element) {

        return set[element];

    }

    public void union(int j, int t) {

        set[t]=j;

    }
}
