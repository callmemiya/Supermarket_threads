public abstract class Customer {
    private final int purchaseCount;
    private boolean isJustCome;
    private int remainsOfPurchases;

    public Customer(){
        this.purchaseCount = 0;
        this.remainsOfPurchases = 0;
    }

    public Customer(int purchaseCount){
        this.purchaseCount = purchaseCount;
        this.remainsOfPurchases = purchaseCount;
    }

    abstract String getName();

    abstract Cash choosingCash(Cash[] cash);

    public int getRemains(){
        return this.remainsOfPurchases;
    }

    public void changeRemains(int rest){
        this.remainsOfPurchases = rest;
    }
}
