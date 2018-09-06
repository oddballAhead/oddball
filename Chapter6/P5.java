class P5 {

    static int size = 0;
    
    public static void main(String[] args) {
	/*Task:
	  Write a method that removes the minimum value from a partially filled
	  array without calling other methods.*/

	int[] set = new int[100];
	set[0] = 7;
	for(int i = 1; i < 10; i++) {
	    set[i] = i;
	}
	size = 10;
	
	System.out.println("Original array:");
	for(int i = 0; i < size; i++) {
	    System.out.print(set[i] + " ");
	}
	System.out.println("\n");

	System.out.println("After method:");
	removeMin(set);
	for(int i = 0; i < size; i++) {
	    System.out.print(set[i] + " ");
	}
	System.out.println();
	
    }

    public static void removeMin(int[] values) {
	int smallest = values[0];
	int index = 0;
	for(int i = 1; i < size; i++) {
	    if(values[i] < smallest) {
		smallest = values[i];
		index = i;
	    }
	}
	
	for(int i = index+1; i < size; i++) {
	    values[i-1] = values[i];
	    if(i == size - 1) {
		values[i] = 0;
	    }
	}
	size--;
    }
}
