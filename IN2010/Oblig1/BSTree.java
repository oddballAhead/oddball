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
        @Override
        public String toString() {
            return "This is node w/value: " + value + " ";
        }
        
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
                    Node ret = left.findParent(n);
                    if (ret != null) {
                        return ret;
                    }
                }
            }
            if (right != null) {
                if (right == n) {
                    return this;
                } else {
                    Node ret = right.findParent(n);
                    if (ret != null) {
                        return ret;
                    }
                }
            }
            return null;
        }

        // rekursiv metode for find()
        Node find(int value) {
            if (this.value == value) {
                return this;
            } else if (this.value > value) {
                if (left != null) {
                    return left.find(value);
                } else {
                    return null;
                }
            } else {
                if (right != null) {
                    return right.find(value);
                } else {
                    return null;
                }
            }
        }

        //rekrusiv metode for findGrandparent()
        Node findGrandparent (Node n) {
            if (left != null) {
                if (left.left == n) {
                    return this;
                } else if (left.right == n) {
                    return this;
                }
                Node ret = left.findGrandparent(n);
                if (ret != null) {
                    return ret;
                }
            }
            if (right != null) {
                if (right.right == n) {
                    return this;
                } else if (right.left == n) {
                    return this;
                }
                Node ret = right.findGrandparent(n);
                if (ret != null) {
                    return ret;
                }
            }
            return null;
        }

        // print-metode /// brukes til testing
        void printTree(int height) {
            System.out.println(this.toString() + " Height: " + height);
            height++;
            if (left != null) {
                left.printTree(height);
            }
            if (right != null) {
                right.printTree(height);
            }
            return;
        }

        // rekursiv metode for remove()
        boolean remove (int value, Node parent) {
            if (value < this.value) {
                if (left != null) {
                    return left.remove(value, this);
                } else {
                    return false;
                }
            } else if (value > this.value) {
                if (right != null) {
                    return right.remove(value, this);
                } else {
                    return false;
                }
            } else {
                if (left != null && right != null) {
                    this.value = right.findSmallest();
                    right.remove(this.value, this);
                } else if (parent.left == this) {
                    parent.left = (left != null) ? left : right;
                } else if (parent.right == this) {
                    parent.right = (left != null) ? left : right;
                }
                return true;
            }
        }

        


    }       
        
        

    

    // konstruktører til BSTree
    BSTree() {
        this.size = 0;
    }
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

    public boolean remove(int value) {
        if (root == null)
            return false;
        else {
            if (root.value == value) {
                Node auxRoot = new Node(0);
                auxRoot.left = root;
                boolean result = root.remove(value, auxRoot);
                root = auxRoot.left;
                return result;
            } else {
                return root.remove(value, null);
            }
        }
    }

    // public int size() {
    //     if (root == null) {
    //         return 0;
    //     } else {
    //         return size;
    //     }
    // }
    
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
    /* private */ Node findParent (Node n) {
        return root.findParent(n);
    }

    /* private */ Node findGrandparent (Node n){
        return root.findGrandparent(n);
    }
    
    /* private */ Node find (int value){
        return root.find (value);
    }




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


    public void printTree() {
        root.printTree(0);
    }

    public String getString(int value) {
        return root.find(value).toString();
    } 

    public String nodeToString(Node n) {
        return n.toString();
    }

    public String rootToString() {
        return root.toString();
    }

    public Node findNode(int value) {
        // if (root.value == value) {
        //     return root;
        // }
        return root.find(value);
    }


}
