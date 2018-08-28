import java.util.Random;

class P1 {
    public static void main(String[] args) {
	//something with arrays

	Random random = new Random();
	
	int[] liste = new int[10];
	for(int i = 0; i < 10; i++) {
	    liste[i] = random.nextInt();
	}
	System.out.println("All elements:");
	for(int i = 0; i < 10; i++) {
	    System.out.println(liste[i]);
	}
	System.out.println();
	//Prints every element at even
	//index:
	System.out.println("Every element at even index:");
	for(int i = 0; i < 10; i = i+2) {
	    System.out.println(liste[i]);
	}
	System.out.println();
	//Prints every even element in
	//the array:
	System.out.println("Every even element:");
	for(int i = 0; i < 10; i++) {
	    if((liste[i] % 2)==0) {
		System.out.println(liste[i]);
	    }
	}
	System.out.println();

	System.out.println("All elements in reverse order:");
	for(int i = 9; i > -1; i--) {
	    System.out.println(liste[i]);
	}
	System.out.println();

	System.out.println("Only the first and last element:");
	System.out.println(liste[0]);
	System.out.println(liste[9]);
        
    }
}
