import java.util.LinkedList;

public class Cash {
    private final int speed;
    private LinkedList<Customer> queue;

    public Cash(int speed){
        this.speed = speed;
        this.queue = new LinkedList<>();
    }

    public void addCustomer(Customer customer){
        this.queue.add(customer);
    }

    public int getSpeed(){
        return this.speed;
    }

    public LinkedList<Customer> getQueue(){
        return this.queue;
    }

    public int getCountQueue(){
        return queue.size();
    }

    public void service(){
        int rest = this.speed;
        int countOfServiced = 0;
        for (Customer customer : this.queue){
            rest -= customer.getRemains();
            if (rest < 0){
                customer.changeRemains(-rest);
                break;
            } else if (rest > 0){
                countOfServiced += 1;
            } else {
                countOfServiced += 1;
                break;
            }
        }
        for (int i = 0; i < countOfServiced; i++){
            this.queue.remove();
        }
    }
}
