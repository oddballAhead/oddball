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
        System.out.println(tree.getString(24));
        System.out.println(tree.getString(17));
                
        System.out.println(tree.rootToString());
        System.out.println(tree.find(24) + " " + tree.find(14) + " " + tree.find(76) + " " + tree.find(1));

        System.out.println("Expected: 24, 24");
        System.out.println(tree.nodeToString(tree.findParent(tree.find(14))));
        System.out.println(tree.nodeToString(tree.findParent(tree.find(76))));

        System.out.println();
        tree.printTree();
        System.out.println();
        
        System.out.println("Expected: 24, 76, 24");
        System.out.println(tree.nodeToString(tree.findGrandparent(tree.find(1))));
        System.out.println(tree.nodeToString(tree.findGrandparent(tree.find(33))));
        System.out.println(tree.nodeToString(tree.findGrandparent(tree.find(64))));

        System.out.println();
        tree.remove(24);
        tree.printTree();
        System.out.println();
        
        tree.remove(14);
        tree.printTree();
    }
}
