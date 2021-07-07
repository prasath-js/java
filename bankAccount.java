
import java.util.Scanner;

class account{
    String name ;
    String acNo;
    double balance;
    long phone;
    String eMail;
    String dob;
    String address;
   
    //get_methods
    public String getAccno(){
        return acNo;
    }
    public String getName(){
        return name;
    }
    public String geDob(){
        return dob;
    }
    public long getPhone(){
        return phone;
    }
    public String getMail(){
        return eMail;
    }
    public String getAddress(){
        return address;
    }
    public void setBal(){
        System.out.println("enter amount to add in your account");
        
        Scanner bal=new Scanner(System.in);
        balance=bal.nextDouble();
         System.out.println("Balance in your account "+balance);
        
    }
    //constor
    public account(String accno,String Cname,String date,String mail,long num,String add){
        acNo=accno;
        name=Cname;
        dob=date;
        eMail=mail;
        phone=num;
        address=add;
    }
}
class savingAccount extends account{ 
    double deposit;
    double withdraw;
    double FD;
 //methods
    public String getAccno(){
        return acNo;
    }
    public void setDeposite(){
        System.out.println("ente the amount to deposite");
        double depo;
        Scanner w=new Scanner(System.in);
        depo=w.nextDouble();
        System.out.println(" amount to deposited is "+depo);
    }
    public double getDeposit(){
        return balance;
        
    }
    public void  setFd(double rs){
        FD=rs;
     }
    public double getFD(){
        return FD;
    }
    public void getWithdraw(){
        System.out.println("ente the amount to withdraw");
        double wd;
        Scanner w=new Scanner(System.in);
        wd=w.nextDouble();
        if(wd<=balance){
        balance=balance - wd;
        System.out.println("cash withdrawed is "+ wd);
        System .out.println("your balance is "+ balance);
        }
        else
        {
            System.out.println("withdrawal amount is greater than balance amount");
        }
    }
    
}
class loanaccount extends account{
    double loanAmount;
    double emi;
    double tloan;
    double repayment;
    public double getLoan(){
        return loanAmount;
    }
   public double getEmi(){
       emi=loanAmount/12;
        return emi;
    }
    public boolean toploan(){
        return balance/2>loanAmount;
    }
     public double repay(){
        return repayment;
    }
   public void setLoan(double amt){
       loanAmount=amt;
       balance=loanAmount;
   }
   public void setEmi(double em){
       
       
       balance=balance-em;
       System.out.println("balence to pay"+balance);
   }
}
    


public class project2 {

    public static void main(String args[]){
        
        System.out.println("press 1 for creating an account\n press 2 for login saving account\n press 3 for loan account ");
       Scanner v=new Scanner(System.in);
       int press=v.nextInt();
       
       switch(press){
           case 1:
               String newname,dob,address,email;long phone;
               System.out.println("enter your name");
               newname=v.nextLine();
               v.nextLine();
               System.out.println("enter your email ID");
               email=v.nextLine();
               
                System.out.println("enter your date of birth");
              dob=v.nextLine();
               System.out.println("enter youe address");
               address=v.nextLine();
               System.out.println("enter youe phone number");
               phone=v.nextLong();
                account acc=new account("12qsw@sbi",newname,dob,email,phone,address);
                System.out.println(acc.getAddress()+"\nAccount created sucessfully--\n NAME: "+acc.getName()+"\nACCOUNT NUMBER: "+acc.getAccno() +
                "\nADDRESS: " + "\nDATE OF BIRTH: " + acc.geDob()+ "PHONE NUMBER: " +acc.getPhone()+"\nADDRESS: "+acc.getAddress());
                System.out.println("add some amount to maintain minium balance");
                acc.setBal();
                break;
           case 2:
               savingAccount a1= new savingAccount();
             
               String accno;
               System.out.println("enter account nnumber ");
               v.next();
               accno=v.nextLine();
               
               if (accno == a1.getAccno()){
                   int ch;
                   System.out.println(" 1=DEPOSITE\n 2=WITHDRWAL \n 3=CHESK BALANCE \n 4=ADD AMOUNT FD\n 5=CHKEK FD");
                   ch=v.nextInt();
                   
                   switch(ch){
                       case 1:
                           a1.getAccno();
                           a1.setDeposite();
                           a1.getDeposit();
                           break;
                       case 2:
                           a1.getAccno();
                           a1.getWithdraw();
                           break;
                       case 3:
                           a1.getDeposit();
                           break;
                       case 4:
                           System.out.println("enter amount to add in fd");
                           double df;
                           df=v.nextDouble();
                           a1.setFd(df);
                           System.out.println("amount sucessfully add to FD");
                           break;
                       case 5:
                           a1.getFD();
                           break;
                   }
               }else{
                   System.out.println("account not exist");
               }
               break;
           case 3:
               System.out.println("enter account nnumber ");
               v.next();
               accno=v.nextLine();
               loanaccount l1= new loanaccount();
               if (accno==l1.getAccno()){
                   int ch;
                   System.out.println(" 1= GET LOAN\n 2=CHECK EMI \n 3=EMI\n 4=CHECK TOPUP");
                   ch=v.nextInt();
                   switch(ch){
                       case 1:
                           if(l1.getLoan()==0||l1.getLoan()/2>l1.balance){
                               System.out.println("enter amount et loan");
                               double lon;
                               lon=v.nextDouble();
                               l1.setLoan(lon);
                               double em=lon/12;
                               System.out.println("your emi is "+em);
                               
                           }else{
                               System.out.println("not elegible");
                           }
                           break;
                       case 2:
                           l1.getEmi();
                           break;
                       case 3:
                           System.out.println("EMI amount IS "+l1.getEmi());
                           double ant=v.nextDouble();
                           l1.setEmi(ant);
                           break;
                       case 4:
                           if(l1.toploan()==true){
                               System.out.println("you r elegiable");
                           }
                           else{
                               System.out.println("not elegible");
                           }
                           break;
                   }
                   
               }else{
                   System.out.println("account not exist");
               }
               
               
           }
        }
    
}
