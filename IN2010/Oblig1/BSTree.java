public class BSTree implements BSTOper {

    private Node root;
    
    
    private class Node {
	
	Node left, right;
	// verdier i venstre subtre er < verdien i noden selv
	// verdier i høyre subtre er > verdien i noden selv
	int value;

	// konstruktører, programmer disse
	Node( ) { }
	Node (int v) {
	    this.value = v;
	}

	//metoder for Node-klassen
	void add(int value) {
	    if (value < this.value) {
		if (left != null) {
		    left.add(value);
		} else {
		    left = new Node (value);
		}
	    } else if (value > this.value) {
		if (right != null) {
		    right.add(value);
		} else {
		    right = new Node (value);
		}
	    } else {
		this.value = value;
	    }
	}

	int size(int ret) {
	    if (left != null) {
		ret = left.size(ret);
	    }
	    ret = ret + 1;
	    if (right != null) {
		ret = right.size(ret);
	    }
	    return ret;
	}
		

	
    }

    // konstruktører til BSTree
    BSTree() {}
    BSTree(Node r) {
	this.root = r;
    }
    
    
    // metoder fra BSTOper
    public void add (int value) {
	if (root == null) {
	    root = new Node(value);
	} else {
	    root.add(value);
	} 
    }

    public boolean remove (int value) {  /// UNFINISHED!
	return true;
    }
    
    public int size() {
	if (root == null) {
	    return 0;
	} else {
	    return root.size(0);
	}
    }
    
    public boolean existsInTree( int value ) {
	
	return true;
    }
    public int findNearestSmallerThan( int value ) {
	return 0;
    }
    public void addAll( int[] integers ) {
    }
    // inorder
    public int[] sortedArray() {
	return null;
	}
    public int[] findInRange (int low, int high) {
	return null;
    }


    //private metoder 
    private Node findParent( Node n ){ return null; }
    private Node findGrandparent( Node n ){ return null; }
    private Node find( int value ){ return null; }



    
    // brukes til rød-svarte trær (tilleggsoppgave)
    private static byte BLACK = 1;
    private static byte RED = 2;

    
    private class RBNode extends Node {
	private byte colour = 0;
	
	boolean isRed( ) { return colour == RED; }
	boolean isBlack( ) { return colour == BLACK; }
	void setToRed( ) { colour = RED; }
	void setToBlack( ) { colour = BLACK; }
    }


    // test-metoder ------------------------------------------------------------------------


    public void printTre() {

    }

}
