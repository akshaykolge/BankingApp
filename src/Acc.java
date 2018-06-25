public class Acc {
    private double balance;
    void Acc(){
        balance=0;
    }

    public double showBal(){
        return balance;
    }
    public void debit(double amt){
        if(balance<amt)
            System.out.println("Insufficient Balance");
        else
            balance-=amt;
    }

    public void credit(double amt){
        balance+=amt;
    }
}
