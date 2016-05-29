
public class CharThread implements Runnable {

    private char c;

    private int codeOfChar;

    public CharThread(char c) {

        this.c = c;

        codeOfChar = (int) c;

    }

    public void run() {

        int codeOfTop;

        if (!Main.stack.empty()) {

            codeOfTop = (int) Main.stack.peek();

        } else {

            codeOfTop = -1;

        }

        boolean checkRoundBrackets = (!Main.stack.empty()) && (Math.abs(codeOfChar - codeOfTop) == 1);

        boolean checkBracesAndSquare = (!Main.stack.empty()) && (Math.abs(codeOfChar - codeOfTop) == 2);

        if (checkRoundBrackets || checkBracesAndSquare) {

            Main.stack.pop();

        } else {

            Main.stack.push(c);

        }

    }
}
