import java.util.Random;

public class Child extends Customer{

    public Child(){
        super();
    }

    public Child(int purchaseCount){
        super(purchaseCount);
    }

    public String getName(){
        return "Child";
    }

    public Cash choosingCash(Cash[] cash){
        Random rnd = new Random();
        return cash[rnd.nextInt(cash.length)];
    }
}
