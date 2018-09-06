class P12 {
    public static void main(String[] args) {
	/*Write a program that generates a sequence of 20 random die tosses
	  in an array and then prints them, marking the 'runs'.*/

	int[] set = new int[20];
	// formula: (int)(Math.random() * ((max - min) + 1)) + min
	for(int i = 0; i < set.length; i++) {
	    set[i] = (int) (Math.random() * ((6 - 1) + 1)) + 1;
	    System.out.print(set[i] + " ");
	}
	System.out.println();

	boolean inRun = false;
	for(int i = 0; i < set.length; i++) {
	    if(inRun) {
		if(i-1 >= 0) {
		    if(set[i] != set[i-1]) {
			System.out.print(") ");
			inRun = false;
		    }
		}
	    }
	    if(!inRun) {
		if(i+1 < set.length) {
		    if(set[i] == set[i+1]) {
			System.out.print("(");
			inRun = true;
		    }
		}
	    }
	    if(i+1 < set.length && inRun && set[i] != set[i+1]) {
		System.out.print(set[i]);
	    } else if(inRun && i == (set.length - 1)) {
		System.out.print(set[i]);
	    } else {
		System.out.print(set[i] + " ");
	    }
	}
	if(inRun) {
	    System.out.print(")");
	}
	System.out.println();

    }
}
