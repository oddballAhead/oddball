

class P4 {
    public static void main(String[] args) {

	// Task:
	// Write a method sumWithoutSmallest that computes
	// the sum of an array, except the smallest value

	int[] values = {10, 10, 5, -3, 5, 20};
	System.out.println("Original array:");
	for(int element : values) {
	    System.out.print(element + " ");
	}
	System.out.println("\nResult of method:");
	System.out.println(sumWithoutSmallest(values));
	

    }


    static int sumWithoutSmallest(int[] values) {
	int smallest = values[0];
	int sum = values[0];
	for(int i = 1; i < values.length; i++) {
	    if(values[i] < smallest) {
		smallest = values[i];
	    }
	    sum = sum + values[i];
	}
	return (sum - smallest);
    }
}
