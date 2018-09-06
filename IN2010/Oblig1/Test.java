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

	BSTree emptyTree = new BSTree();

	System.out.println("Testing existsInTree():");
	System.out.print(emptyTree.existsInTree(5) + " ");
	System.out.print(tree.existsInTree(14) + " ");
	System.out.print(tree.existsInTree(80) + " ");
	System.out.println(tree.existsInTree(24) + " ");

	System.out.println("Testing findNearestSmallerThan():");
	System.out.print(tree.findNearestSmallerThan(-40) + " ");
	System.out.print(tree.findNearestSmallerThan(76) + " ");
	System.out.print(tree.findNearestSmallerThan(64) + " ");
	System.out.println(tree.findNearestSmallerThan(80));

	System.out.println("Testing addAll() and sortedArray():");
	int[] elements = tree.sortedArray();
	for (int i = 0; i < elements.length; i++) {
	    System.out.print(elements[i] + " ");
	}
	System.out.println();
	int[] newElements = {17, 101, -12, 33};
	tree.addAll(newElements);
	int[] list = tree.sortedArray();
	for (int i = 0; i < list.length; i++) {
	    System.out.print(list[i] + " ");
	}
	System.out.println();

	System.out.println("Testing findInRange():");
	int[] range = tree.findInRange(17, 33);
	for (int i : range) {
	    System.out.print(i + " ");
	}
	System.out.println();

	System.out.println("Testing findParent():");

    }
}
