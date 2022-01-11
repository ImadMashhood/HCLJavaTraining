public class Bank {
    double balance;
    Bank(){
        this.balance = 0.0;
    }
    Bank(double balance){
        this.balance = balance;
    }
    public void withdraw(double withdrawAmt){
        try{
            if(balance-withdrawAmt < 0)
                throw new insufficentBalanceException();
            balance-=withdrawAmt;
        }
        catch (insufficentBalanceException e){
            System.out.println(e);
        }
    }
    public void deposit(double depositAmt){
        balance+=depositAmt;
    }
    public double getBalance(){
        return balance;
    }
}

class insufficentBalanceException extends Exception{
    public insufficentBalanceException(){
        super("Invalid Balance");
    }
}