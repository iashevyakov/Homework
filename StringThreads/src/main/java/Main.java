import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static Stack<Character> stack = new Stack();

    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        int lengthOfString = s.length();

        Thread[] threads = new Thread[lengthOfString];

        CharThread[] ct = new CharThread[lengthOfString];


        for (int i = s.length() - 1; i >= 0; i--) {

            ct[i] = new CharThread(s.charAt(i));

            threads[i] = new Thread(ct[i]);

            threads[i].start();

            threads[i].join();

        }

        if (Main.stack.empty()) {

            System.out.println("Right");

        } else {

            System.out.println("NO");

        }

    }
}
