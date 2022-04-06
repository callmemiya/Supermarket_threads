import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Write the number of customers");
        int countOfCustomers = in.nextInt();
        Cash[] cashes = new Cash[4];
        System.out.println("Write speeds of 4 cashes");
        for (int i = 0; i < cashes.length; i++){
            int speed = in.nextInt();
            while (speed < 1 || speed > 3){
                System.out.println("Please, write correct speed. It should be 1 <= speed <= 3");
                speed = in.nextInt();
            }
            cashes[i] = new Cash(speed);
        }
        Supermarket supermarket = new Supermarket(cashes);
        System.out.println("Write the number of cycles of the store");
        int countOfSteps = in.nextInt();
        CustomerGenerator customerGenerator = new CustomerGenerator(countOfCustomers, supermarket);
        customerGenerator.setDaemon(true);
        CashService cashService = new CashService(countOfSteps, supermarket);
        customerGenerator.start();
        cashService.start();
    }
}
