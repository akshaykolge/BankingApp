import java.io.InputStreamReader;
import java.io.*;
import java.util.HashMap;

public class SimulateAccount {
    public static void printOptions(){
        System.out.println("\n\n=================================================================");
        System.out.println("<Banking System>");
        System.out.println("1.Create Account");
        System.out.println("2.Debit");
        System.out.println("3.Credit");
        System.out.println("4.Exit\n");
        System.out.println("Please select an option..");
        System.out.println("=================================================================");
    }

    static int accNo=0;
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int opt=0;
        HashMap<Integer,Acc> map=new HashMap<>();
        do{
            printOptions();
            opt=Integer.parseInt(br.readLine());
            if(opt==4)
                System.exit(0);
            else if(opt==1){
                System.out.println("Account created : "+ ++accNo);
                Acc a=new Acc();
                map.put(accNo,a);
            }
            else if(opt==2 || opt==3){
                Acc a;
                int limit=3;
                int number;
                do{
                    if(limit==3)
                        System.out.println("Enter Account Number");
                    else
                        System.out.println("Enter Correct Account Number  !!!! ");
                    number=Integer.parseInt(br.readLine());
                } while((a=map.containsKey(number) ? map.get(number) : null )==null   && --limit >0);
                if(limit<=0){
                    System.out.println("Too Many Attempts , Exiting ...");
                    System.exit(0);
                }
                if(opt==2){
                    System.out.println("Enter amount to be debited");
                    a.debit(Double.parseDouble(br.readLine()));
                }
                else{
                    System.out.println("Enter amount to be credited");
                    a.credit(Double.parseDouble(br.readLine()));
                }
                System.out.println("Balance : " + a.showBal());
            }
            else
                System.out.println("Please Enter correct choice");
        }while(true);
    }
}
