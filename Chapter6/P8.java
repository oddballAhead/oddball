class P8 {
    public static void main(String[] args) {
	//Write a program that switches the first half of an array with the second.
	//Warning! This method can only be used with arrays of even length.

	int[] set = {4, 5, 4, 5, 6, 2, 6, 2};
	for(int element : set) {
	    System.out.print(element + " ");
	}
	System.out.println("\n");

	switcher(set);
	for(int element : set) {
	    System.out.print(element + " ");
	}
	System.out.println();
    }

    
    static void switcher(int[] values) {
	int i = 0;
	int j = values.length/2;
	while(i<values.length/2) {
	    int temp = values[i];
	    values[i] = values[j];
	    values[j] = temp;
	    i++;
	    j++;
	}
    }
}
