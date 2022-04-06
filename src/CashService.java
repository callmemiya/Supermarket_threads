public class CashService extends Thread{
    private final int countOfTacts;
    private volatile Supermarket supermarket;
    public CashService(int tacts, Supermarket supermarket){
        this.countOfTacts = tacts;
        this.supermarket = supermarket;
    }
    public void run(){
        for (int i = 0; i < this.countOfTacts; i++) {
            this.supermarket.serviceAll();
        }
        System.out.println("State of cashes before closing the store");
        this.supermarket.printCashes();
    }
}
