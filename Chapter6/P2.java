class P2 {
    public static void main(String[] args) {
	/*This program contains methods for carrying out a number of tasks with
	  arrays*/

	int[] liste;
	liste = new int[10];
	for(int i = 0; i < 10; i++) {
	    liste[i] = i;
	}
	System.out.println("The original array:");
	for(int i = 0; i < 10; i++) {
	    System.out.print(liste[i] + " ");
	}
	System.out.println("\n");
	
	swap(liste);
	System.out.println("The array after swap-method:");
	for(int i = 0; i < 10; i++) {
	    System.out.print(liste[i] + " ");
	}
	System.out.println("\n");

	shift(liste);
	System.out.println("Then the array after shift-method:");
	for(int i = 0; i < 10; i++) {
	    System.out.print(liste[i] + " ");
	}
	System.out.println("\n");

	replace(liste);
	System.out.println("Then the array with all even elements replaced with 0:");
	for(int i = 0; i < 10; i++) {
	    System.out.print(liste[i] + " ");
	}
	System.out.println("\n");

	replaceLarger(liste);
	System.out.println("Replace all middle elements with largest neighbor:");
	for(int i = 0; i < liste.length; i++) {
	    System.out.print(liste[i] + " ");
	}
	System.out.println("\n");

	System.out.println("On another list:");
	int[] liste2 = {1, 0, 0, 2, 3, 1, 7, 5, 3};
	for(int i = 0; i < liste2.length; i++) {
	    System.out.print(liste2[i] + " ");
	}
	System.out.println("\n\\/");
	replaceLarger(liste2);
	for(int i = 0; i<liste2.length; i++) {
	    System.out.print(liste2[i] + " ");
	}
	System.out.println("\n");

	System.out.println("Remove middle elements:");
        remove(liste);
	remove(liste2);
	for(int i = 0; i < liste.length; i++) {
	    System.out.print(liste[i] + " ");
	}
	System.out.println("\n\\/");
	for(int i = 0; i < liste2.length; i++) {
	    System.out.print(liste2[i] + " ");
	}
	System.out.println("\n");

	System.out.println("Move all even elements to the front of the list, " +
			   "otherwise preserving the previous order of the list:");
	order(liste);
	order(liste2);
	for(int i = 0; i < liste.length; i++) {
	    System.out.print(liste[i] + " ");
	}
	System.out.println();
	for(int i = 0; i < liste2.length; i++) {
	    System.out.print(liste2[i] + " ");
	}
	System.out.println("\n");

	System.out.println("Return the second largest element:");
	System.out.println(second(liste));
	System.out.println(second(liste2) + "\n");

	System.out.println("New lists:");
	int[] liste3 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
	int[] liste4 = {5, 6, 8, 4, 4, 1, -6, 45, 2};
	int[] liste5 = {3, 2, 5, 3};
	for(int i = 0; i < liste3.length; i++) {
	    System.out.print(liste3[i] + " ");
	}
	System.out.println();
	for(int i = 0; i < liste4.length; i++) {
	    System.out.print(liste4[i] + " ");
	}
	System.out.println();
	for(int i = 0; i < liste5.length; i++) {
	    System.out.print(liste5[i] + " ");
	}
	System.out.println("\n\nReturn true if the list is sorted in ascending order:");
	System.out.println(increasing(liste3));
	System.out.println(increasing(liste4));
	System.out.println(increasing(liste5) + "\n");

	System.out.println("Return true if two adjacent duplicates exist:");
	System.out.println(adjacent(liste3));
	System.out.println(adjacent(liste4));
	System.out.println(adjacent(liste5) + "\n");

	System.out.println("Return true if duplicates exist, regardless of adjacency");
	System.out.println(duplicates(liste3));
	System.out.println(duplicates(liste4));
	System.out.println(duplicates(liste5));
    }

    //The methods:
    //---------------------------------------------------------------------------

    static void swap(int[] set) {
	int first = 0;
	int last = 0;

	for(int i = 0; i < set.length; i++) {
	    if(i == 0) {
		first = set[i];
	    }
	    if(i == (set.length - 1)) {
		last = set[i];
	    }
	}	
	//Then swap
	for(int i = 0; i < set.length; i++) {
	    if(i == 0) {
		set[i] = last;
	    }
	    if(i == (set.length - 1)) {
		set[i] = first;
	    }
	}
    }

    //Shifts all elements one position to the right
    static void shift(int[] set) {
	int[] helper = new int[set.length];
	for(int i = 0; i < set.length; i++) {
	    helper[i] = set[i];
	}
	set[0] = helper[helper.length - 1];
	for(int i = 1; i < set.length; i++) {
	    set[i] = helper[i-1];
	}		
    }
	
    //Replace all even elements with 0:
    static void replace(int[] set) {
	for(int i = 0; i < set.length; i++) {
	    if((set[i] % 2) == 0) {
		set[i] = 0;
	    }
	}
    }

    /*Replace each element, except the first and last, by the larger
      of its two neighbors*/
    static void replaceLarger(int[] set) {
	for(int i = 0; i < set.length; i++) {
	    if(i!=0 && i!=(set.length-1)) {
		int previous = set[i-1];
		int next = set[i+1];
		if(previous > set[i]) {
		    set[i] = previous;
		}
		if(next > set[i]) {
		    set[i] = next;
		}
	    }
	}
    }

    //Removes the middle element, or the two middle elements:
    static void remove(int[] set) {
	if((set.length % 2)==0) {
	    int middle = set.length/2;
	    set[middle] = 0;
	    set[middle-1] = 0;
	} else {
	    set[set.length/2] = 0;
	}
    }

    //Move all even elements to the front, otherwise preserving the order
    //of the elements:
    static void order(int[] set) {
	int[] helper = new int[set.length];
	int counter = 0;
	for(int i = 0; i < set.length; i++) {
	    if((set[i] % 2) == 0) {
		helper[counter] = set[i];
		counter++;
	    }
	}
	for(int i = 0; i < set.length; i++) {
	    if((set[i] % 2) != 0) {
		helper[counter] = set[i];
		counter++;
	    }
	}
	
	for(int i = 0; i < set.length; i++) {
	    set[i] = helper[i];
	}
    }

    //Return the second-largest element in the array:
    static int second(int[] set) {
	int largest = set[0];
	int smallest = set[0];
	for(int i = 0; i < set.length; i++) {
	    if(set[i] > largest) {
		largest = set[i];
	    }
	    if(set[i] < smallest) {
		smallest = set[i];
	    }
	}
	int ret = smallest;
	for(int i = 0; i < set.length; i++) {
	    if(set[i] > ret && set[i] < largest) {
		ret = set[i];
	    }
	}
	return ret;
    }

    //Return true if the array is currently sorted in increasing order:
    static boolean increasing(int[] set) {
	int previous = set[0];
	for(int i = 0; i<set.length; i++) {
	    if(set[i] < previous) {
		return false;
	    }
	    previous = set[i];
	}
	return true;
    }

    //Return true if the array contains two adjacent duplicates:
    static boolean adjacent(int[] set) {
	int previous = set[0];
	if(set[0] != 0) {
	    previous = 0;
	} else {
	    previous = 1;
	}
	
	for(int i = 0; i<set.length; i++) {
	    if(set[i] == previous) {
		return true;
	    }
	    previous = set[i];
	}
	return false;
    }

    //Return true if the array contains duplicate elements,(which need not be adjacent):
    static boolean duplicates(int[] set) {
	for(int i = 0; i < set.length; i++) {
	    for(int j = 0; j < i; j++) {
		if(set[j] == set[i]) {
		    return true;
		}
	    }
	}
	return false;
    }
	    
    

}
