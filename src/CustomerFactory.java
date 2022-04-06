import java.util.Random;

public class CustomerFactory{

    public Customer createCustomer(){
        Random rnd = new Random();
        int custNum = rnd.nextInt(3);
        Customer customer;
        Random random = new Random();
        int purchaseCount = random.nextInt(5) + 1;
        switch (custNum) {
            case 0:
                customer = new Child(purchaseCount);
                break;
            case 1:
                customer = new Women(purchaseCount);
                break;
            default:
                customer = new Man(purchaseCount);
                break;
        }
        return customer;
    }
}
