import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    private static Bank myBank = new Bank("PKO");

    public static void main(String[] args) {

        boolean quit = false;

        while(!quit){

            System.out.println("Choose action: ");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch(action){
                case 0:
                    showOptions();
                    break;
                case 1:
                    addCustomer();
                    break;
                case 2:
                    addBranch();
                    break;
                case 3:
                    showBranchList();
                    break;
                case 4:
                    addTrans();
                    break;
                case 5:
                    showList();
                    break;
                case 6:
                    System.out.println("Shouting down the system...");
                    quit = true;
            }

        }

    }

    private static void showOptions(){
        System.out.println("Options: ");
        System.out.println("0 - show options");
        System.out.println("1 - add customer");
        System.out.println("2 - add branch");
        System.out.println("3 - show branch list");
        System.out.println("4 - add transaction");
        System.out.println("5 - show list of customers");
        System.out.println("6 - shout down the system");
    }

    private static void addBranch(){
        System.out.println("Name of new branch: ");
        String newBranch = scanner.nextLine();

        Branch newBranchBank = Branch.createBranch(newBranch);

        if(myBank.addBranch(newBranchBank)){
            System.out.println("New branch added: " + newBranchBank.getBranchName());
        }
        else{
            System.out.println("Unsuccessful adding branch");
        }
    }

    private static void showBranchList(){
        System.out.println("List of branches: ");
        myBank.showBranchList();
    }

//    private static void addCustomer(){
//        System.out.println("Name of branch: ");
//        String branchName = scanner.nextLine();
//
//        Branch myBranch = myBank.passSelectedBranch(branchName);
//
//        if(myBranch == null){
//            System.out.println("This branch does not exist or have incorrect name");
//            return;
//        }
//
//        System.out.println("Name of new customer: ");
//        String newCustomer = scanner.nextLine();
//
//        Customer newCustomerBranch = Customer.createCustomer(newCustomer);
//
//        if(myBranch.addCustomer(newCustomerBranch)){
//            System.out.println("New customer: " + newCustomerBranch.getCustomerName() + " added to branch: " + myBranch.getBranchName());
//        }
//        else{
//            System.out.println("Unsuccessful adding new customer to selected branch");
//        }
//    }

    private static void addCustomer(){
        System.out.println("Name of branch: ");
        String branchName = scanner.nextLine();

        Branch myBranch = myBank.passSelectedBranch(branchName);

        if(myBranch == null){
            System.out.println("This branch does not exist or have incorrect name");
            return;
        }

        System.out.println("Name of new customer: ");
        String newCustomer = scanner.nextLine();
        System.out.println("Amount: ");
        double initTrans = scanner.nextDouble();

        Customer newCustomerBranch = Customer.createCustomer(newCustomer);

        if(myBranch.addCustomer(newCustomerBranch)){
            System.out.println("New customer: " + newCustomerBranch.getCustomerName() + " added to branch: " + myBranch.getBranchName());

            Double newTrans = new Double(initTrans);

            if(newCustomerBranch.addTrans(newTrans)){
                System.out.println("Transaction: " + newTrans.doubleValue() + "zł added to " + newCustomerBranch.getCustomerName() + " transaction list");
            }
            else{
                System.out.println("Unsuccessful adding new transaction to transaction list");
            }

        }
        else{
            System.out.println("Unsuccessful adding new customer to selected branch");
        }
    }

    private static void showList(){
        System.out.println("Select branch name: ");
        String searchBranchName = scanner.nextLine();

        Branch myBranch = myBank.passSelectedBranch(searchBranchName);

        if(myBranch == null){
            System.out.println("This branch does not exist or have incorrect name");
            return;
        }

        System.out.println("Selected branch: " + myBranch.getBranchName());

        myBranch.showCustomerList();

    }

    private static void addTrans(){

        System.out.println("Select branch: ");
        String branchName = scanner.nextLine();

        Branch selectedBranch = myBank.passSelectedBranch(branchName);

        if(selectedBranch == null){
            System.out.println("This branch does not exist");
            return;
        }

        System.out.println("Select customer: ");
        String customerName = scanner.nextLine();

        Customer customer = selectedBranch.passSelectedCustomer(customerName);

        if(customer == null){
            System.out.println("This customer does not exist");
            return;
        }

        System.out.println("Amount: ");
        double amount = scanner.nextDouble();

        Double additTrans = new Double(amount);

        if(customer.addTrans(additTrans)){
            System.out.println("New transaction: " + additTrans.doubleValue() + " for user: " + customer.getCustomerName());
        }
        else{
            System.out.println("Cannot add transaction to customers transaction list");
        }

    }

}
