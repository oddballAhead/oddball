class P4 {
    public static void main(String[] args) {
	double balance = 1000;
	balance += ((balance/100)*5);
	System.out.println("First year: " + balance);
	balance += ((balance/100)*5);
	System.out.println("Second year: " + balance);
	balance += ((balance/100)*5);
	System.out.println("Third year: " + balance);
    }
}
