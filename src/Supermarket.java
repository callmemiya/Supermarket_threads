public class Supermarket {
    public volatile Cash[] cashes;
    public volatile boolean availableForService = false;
    public volatile boolean generationIsDone = false;

    public Supermarket(Cash[] cashes){
        this.cashes = cashes;
    }

    public void printCashes(){
        int maxCountQueue = this.cashes[0].getCountQueue();
        for (int i = 1; i < this.cashes.length; i++){
            if (this.cashes[i].getCountQueue() > maxCountQueue){
                maxCountQueue = this.cashes[i].getCountQueue();
            }
        }
        System.out.printf("%15s", "Cash №1[" + this.cashes[0].getSpeed() + "]");
        System.out.printf("%15s", "Cash №2[" + this.cashes[1].getSpeed() + "]");
        System.out.printf("%15s", "Cash №3[" + this.cashes[2].getSpeed() + "]");
        System.out.printf("%15s%n", "Cash №4[" + this.cashes[3].getSpeed() + "]");
        for (int i = 0; i < maxCountQueue; i++){
            for (Cash cash : this.cashes) {
                if (cash.getCountQueue() - 1 < i) {
                    System.out.printf("%15s", "");
                } else {
                    String name = cash.getQueue().get(i).getName();
                    int count = cash.getQueue().get(i).getRemains();
                    System.out.printf("%15s", name + "[" + count + "]");
                }
            }
            System.out.println();
        }
    }

    public void setGenerationIsDone(){
        this.generationIsDone = true;
    }

    public synchronized void serviceAll(){
        while (!availableForService && !this.generationIsDone){
            try {
                wait();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        this.printCashes();
        for (Cash cash: cashes){
            cash.service();
        }
        availableForService = false;
        notifyAll();
    }

    public synchronized void addCustomer(Customer customer, Cash cash){
        while (availableForService){
            try {
                wait();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        cash.addCustomer(customer);
        availableForService = true;
        notifyAll();
    }
}
