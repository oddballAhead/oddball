class P7 {
    public static void main(String[] args) {
	//Write a method that reverses the sequence of elements in an array.
	
	int[] set = { 1, 4, 9, 16, 9, 7, 4, 9, 11 };

	for(int element : set) {
	    System.out.print(element + " ");
	}
	System.out.println("\n");
	reverse(set);
	for(int element : set) {
	    System.out.print(element + " ");
	}
	System.out.println();
	
    }    
		 
    

    

    static void reverse(int[] values) {
	int[] temp = new int[values.length];
	int counter = values.length-1;
	for(int i = 0; i < values.length; i++) {
	    temp[counter] = values[i];
	    counter--;
	}
	for(int i = 0; i < values.length; i++) {
	    values[i] = temp[i];
	}
    }

}
