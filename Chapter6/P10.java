class P10 {
    public static void main(String[] args) {
	/*Write a method that checks whether two arrays have the 
	  same elements in some order*/
	int[] a = {1, 4, 9, 16, 9, 7, 4, 9, 11};
	int[] b = {11, 11, 7, 9, 16, 4, 1};
	int[] c = {1, 4, 9, 7, 16, 11, 5, 0};

	System.out.print(sameSet(a, b) + " ");
	System.out.println(sameSet(b, c) + " ");
    }

    public static boolean sameSet(int[] a, int[] b) {		
	for(int i = 0; i < a.length; i++) {
	    if(!exists(a[i], b)) {
		return false;
	    }
	}
	for(int i = 0; i < b.length; i++) {
	    if(!exists(b[i], a)) {
		return false;
	    }
	}
	return true;

    }


    //Checks whether an element exists in the given array
    public static boolean exists(int a, int[] b) {
	for(int i = 0; i < b.length; i++) {
	    if(b[i] == a) {
		return true;
	    }
	}
	return false;
    }
}
