public class BSTree implements BSTOper {

    private Node root;
    private int size;

    private class Node {

        Node left, right;
        // verdier i venstre subtre er < verdien i noden selv
        // verdier i høyre subtre er > verdien i noden selv
        int value;

        // konstruktører, programmer disse
	Node () {}
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

        //rekursiv metode for size()
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

        //rekursiv metode for existsInTree()
        boolean existsInTree(int value) {
            if (value == this.value) {
                return true;
            } else if (value < this.value) {
                if (left != null) {
                    return left.existsInTree(value);
                } else {
                    return false;
                }
            } else {
                if (right != null) {
                    return right.existsInTree(value);
                } else {
                    return false;
                }
            }
        }

        //rekursiv hjelpe-metode for aa finne den minste i et tree
        int findSmallest() {
            if (left != null) {
                return left.findSmallest();
            } else {
                return this.value;
            }
        }

        //rekursiv metode for findNearestSmallerThan()
        int findNearestSmallerThan(int value) {
            if (value <= this.value) {
                if (left != null) {
                    return left.findNearestSmallerThan(value);
                } else {
                    return this.value;
                }
            } else {
                if (right != null && right.findSmallest() < value) {
                    return right.findNearestSmallerThan(value);
                } else {
                    return this.value;
                }
            }
        }

        //rekursiv metode for sortedArray()
        int sortedArray(int[] array, int currSize) {
            if (left != null) {
                currSize = left.sortedArray(array, currSize);
            }
            array[currSize] = this.value;
            currSize++;
            if (right != null) {
                currSize = right.sortedArray(array, currSize);
            }
	    return currSize;
        }

	//rekursiv metode for findInRange()
	int findInRange(int[] array, int currSize, int low, int high) {
	    if (left!= null) {
		currSize = left.findInRange(array, currSize, low, high);
	    }
	    if (this.value >= low && this.value <= high) {
		array[currSize] = this.value;
		currSize++;
	    }
	    if (right != null) {
		currSize = right.findInRange(array, currSize, low, high);
	    }
	    return currSize;
	}

	//rekursiv metode for findParent()
	Node findParent (Node n) {
	    if (left != null) {
		if (left == n) {
		    return this;
		} else {
		    left.findParent(n);
		}
	    }
	    if (right != null) {
		if (right == n) {
		    return this;
		} else {
		    right.findParent(n);
		}
	    }
	    return null;
	}


    }




    // konstruktører til BSTree
    BSTree() {}
    BSTree(Node r) {
        this.root = r;
	this.size = 1;
    }


    // metoder fra BSTOper
    public void add (int value) {
        if (root == null) {
            root = new Node(value);
	    this.size++;
        } else {
            root.add(value);
	    this.size++;
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

    public boolean existsInTree (int value) {
        if (root == null) {
            return false;
        } else {
            return root.existsInTree(value);
        }
    }

    public int findNearestSmallerThan (int value) {
        if (root == null) {
            return 0;
        } else {
            return root.findNearestSmallerThan(value);
        }
    }


    public void addAll (int[] integers) {
        for (int i = 0; i < integers.length; i++) {
            this.add(integers[i]);
        }
    }

    // inorder
    public int[] sortedArray() {
        if (root == null) {
            return null;
        } else {
            int[] ret = new int[this.size];
            root.sortedArray(ret, 0);
	    return ret;
        }
    }

    public int[] findInRange (int low, int high) {
	if (root == null) {
	    return null;
	} else {
	    int[] ret = new int[this.size];
	    root.findInRange(ret, 0, low, high);
	    return ret;
	}
    }


    //private metoder
    private Node findParent (Node n) {
	return root.findParent(n);
    }

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

    public Node {}


}
