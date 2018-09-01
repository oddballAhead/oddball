class P13 {
    public static void main(String[] args) {
	/*Write a program that generates a sequence of 20 random die
	  tossses in an array and that prints the die values, marking
	  only the longest run. If there is more than one run of 
	  maximum length, mark the first one.*/
	

	int[] set = new int[20];
	// formula: (int)(Math.random() * ((max - min) + 1)) + min
	for(int i = 0; i < set.length; i++) {
	    set[i] = (int) (Math.random() * ((6 - 1) + 1)) + 1;
	    System.out.print(set[i] + " ");
	}
	System.out.println();

	
	boolean inRun = false;
	for(int i = 0; i < set.length; i++) {
	    int currentRunLength = 0;
	    if(!inRun) {
		if((i+1) < set.length && set[i] == set[i+1]) {
		    inRun = true;
		    currentRunLenght++;
		    
    }
}
