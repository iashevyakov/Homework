public class Main {

    public static void main(String[] args) {

        FareySequenceGeneratorArrayImpl farey = new FareySequenceGeneratorArrayImpl();

		farey.generate(10);
		farey.out();
    }
}