class P9 {
    public static void main(String[] args) {

	//Write a method that checks whether two arrays have the
	//same elements in the same order

	int[] a = {1, 2, 3, 4, 5, 6};
	int[] b = {2, 1, 3, 4, 5, 6};
	int[] c = {4, 3};
	int[] d = {4, 3};

	System.out.print(sameSet(a, b) + " ");
	System.out.print(sameSet(b, b) + " ");
	System.out.println(sameSet(c, d));
	
    }

    public static boolean sameSet(int[] a, int[] b) {
	if(a.length != b.length) {
	    return false;
	}
	for(int i = 0; i < a.length; i++) {
	    if(a[i] != b[i]) {
		return false;
	    }
	}
	return true;
    }
}
