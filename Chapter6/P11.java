import java.util.Arrays;

class P11 {
    public static void main(String[] args) {

	/*Write a method public static boolean sameElements(int[] a, int[] b)
	  that checks whether two arrays have the same elements in some order, with
	  the same multiplicities.*/

	int[] a = {1, 4, 9, 16, 9, 7, 4, 9, 11};
	int[] b = {11, 11, 7, 9, 16, 4, 1};
	int[] c = {1, 4, 9, 7, 16, 11, 5, 0};
	int[] d = {1, 4, 9, 16, 9, 7, 4, 9, 11};
	int[] e = {11, 1, 4, 9, 16, 9, 7, 4, 9};
	int[] f = {11, 11, 7, 9, 16, 4, 1, 4, 9};

	System.out.print(sameElements(a, b) + " ");
	System.out.println(sameElements(b, c) + " ");
	System.out.print(sameElements(d, e) + " " + sameElements(d, f) + "\n");

    }


    public static boolean sameElements(int[] a, int[] b) {
	if(!sameSet(a, b)) {
	    return false;
	} 
	
	int[] temp1 = new int[a.length];
	int[] temp2 = new int[b.length];
	for(int i = 0; i < a.length; i++) {
	    temp1[i] = a[i];
	}
	for(int i = 0; i < b.length; i++) {
	    temp2[i] = b[i];
	}
	Arrays.sort(temp1);
	Arrays.sort(temp2);
	if(identicalSet(temp1, temp2)) {
	    return true;
	}
	return false;
	
    }

    //Checks whether two elements contain the same elements,
    //regardless of multiplicity
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

    public static boolean identicalSet(int[] a, int[] b) {
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
