class P6 {
    public static void main(String[] args) {
	/*Compute the alternating sum of all elements in an array.*/

	int[] set = {1, 4, 9, 16, 9, 7, 4, 9, 11};
	System.out.println("Array:");
	for(int element : set) {
	    System.out.print(element + " ");
	}
	System.out.println("\n");
	
	int sum = 0;
	boolean alternate = false;
	for(int element : set) {
	    if(alternate) {
		sum = sum - element;
		alternate = false;
	    } else {
		sum = sum + element;
		alternate = true;
	    }
	}
	System.out.println("The sum is: " + sum);

	
    }
}
