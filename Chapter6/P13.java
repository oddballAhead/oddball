class P13 {
    public static void main (String[] args) {
	/*Write a program that generates a sequence of 20 random die
	  tossses in an array and that prints the die values, marking
	  only the longest run. If there is more than one run of 
	  maximum length, mark the first one.*/
	

	int[] set = new int[20];
	// formula: (int)(Math.random() * ((max - min) + 1)) + min
	for (int i = 0; i < set.length; i++) {
	    set[i] = (int) (Math.random() * ((6 - 1) + 1)) + 1;
	    System.out.print(set[i] + " ");
	}
	System.out.println();


	// General logic:
	/* -Run through the entire array
	   -Check for runs
	   -Count the length of the runs
	   -save the start-index of the longest run
	   
	   -then loop through the array again
	   -this time printing the elements
	   -but also marking the longest run with '(' + ')'
	 */
	
	boolean inRun = false;
	int longest = 0;
	int lRunIStart = 0;
	int currentRunLength = 0;
	int cRunI = 0;
       	for (int i = 0; i < set.length; i++) {
	    if (!inRun) {
		if ((i+1) < set.length && set[i] == set[i+1]) {
		    inRun = true;
		    cRunI = i;
		}
	    }
	    if (inRun) {
		currentRunLength++;
		if (i > 1 && set[i] != set[i-1]) {
		    inRun = false;
		    if (currentRunLength > longest) {
			longest = currentRunLength;
			lRunIStart = cRunI;
		    }
		    currentRunLength = 0;
		}
	    }
	}

	inRun = false;
	for (int i = 0; i < set.length; i++) {
	    if (i == 0 && i == lRunIStart) {
 		System.out.print("(" + set[i] + " ");
		inRun = true;
	    }
	    if ((i+1) < set.length && (i+1) == lRunIStart) {
		System.out.print(set[i] + " (");
		inRun = true;
	    } else if (inRun) {
		if ((i+1) < set.length && (set[i+1]) != set[i] || i == set.length) {
		    System.out.print(set[i] + ") ");
		    inRun = false;
		} else {
		    System.out.print(set[i] + " ");
		}
	    } else {
		System.out.print(set[i] + " ");
	    }
	}
	if (inRun) {
	    System.out.println(")");
	}
	System.out.println();
	System.out.println("Longest run: " + longest);
	
    }
}

//WARNING! NOT WORKING. Will sometimes mark a run even though there is a longer one
//later in the array. Also, will not always mark the first run when there are several
//runs of max length, it seems to mark the one consisting of the highest ints.
