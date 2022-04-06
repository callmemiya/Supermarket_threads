public class Women extends Customer {

    public Women(){
        super();
    }

    public Women(int purchaseCount){
        super(purchaseCount);
    }

    public String getName(){
        return "Woman";
    }

    public Cash choosingCash(Cash[] cash) {
        int minQueue = cash[0].getCountQueue();
        Cash chosenCash = cash[0];
        for (Cash value : cash) {
            if (minQueue > value.getCountQueue()) {
                minQueue = value.getCountQueue();
                chosenCash = value;
            }
        }
        return chosenCash;
    }
}
