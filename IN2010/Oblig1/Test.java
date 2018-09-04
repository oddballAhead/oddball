public class Test {
    public static void main (String[] args) {

	/*This is a test-program for BSTree and everything used in Oblig1*/

	System.out.println("Starting tests:");

	BSTree tree = new BSTree();

	System.out.println(tree.size());
	tree.add(24);
	tree.add(14);
	tree.add(76);
	tree.add(1);
	System.out.println(tree.size());
	tree.add(64);
	System.out.println(tree.size());


    }
}
