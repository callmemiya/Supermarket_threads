public class CustomerGenerator extends Thread{
    private final int countOfCustomers;
    private volatile Supermarket supermarket;

    public CustomerGenerator(int count, Supermarket supermarket){
        this.countOfCustomers = count;
        this.supermarket = supermarket;
    }
    @Override
    public void run(){
        CustomerFactory factory = new CustomerFactory();
        for (int i = 0; i < this.countOfCustomers; i++){
            Customer customer = factory.createCustomer();
            Cash chosenCash = customer.choosingCash(supermarket.cashes);
            this.supermarket.addCustomer(customer, chosenCash);
        }
        this.supermarket.setGenerationIsDone();
    }
}
