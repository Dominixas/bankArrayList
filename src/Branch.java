import java.util.ArrayList;

public class Branch {

    private String branchName;
    private ArrayList<Customer> customerList;

    public Branch(String branchName) {
        this.branchName = branchName;
        this.customerList = new ArrayList<Customer>();
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public static Branch createBranch(String branchName){
        return new Branch(branchName);
    }

//    public boolean addCustomer(Customer newCustomer){
//        if(findCustomer(newCustomer.getCustomerName()) <= 0 ){
//            System.out.println("Adding new customer: " + newCustomer.getCustomerName() + ", to a branch: " + branchName);
//            this.customerList.add(newCustomer);
//            return true;
//        }
//        else{
//            System.out.println("Cannot add a new customer");
//            return false;
//        }
//    }

    public boolean addCustomer(Customer newCustomer){
        if(findCustomer(newCustomer.getCustomerName()) <= 0 ){
            System.out.println("Adding new customer: " + newCustomer.getCustomerName() + ", to a branch: " + branchName);
            this.customerList.add(newCustomer);

            return true;
        }
        else{
            System.out.println("Cannot add a new customer");
            return false;
        }
    }

    public int findCustomer(String customerName){
        for(int i=0; i<this.customerList.size(); i++){
            if(this.customerList.get(i).getCustomerName().equals(customerName)){
                return i;
            }
        }
        return -1;
    }

    public void showCustomerList(){
        System.out.println("Customer list: ");
        for(int i=0; i<this.customerList.size(); i++){
            System.out.println((i+1) + ". " + this.customerList.get(i).getCustomerName() + " -> transactions: ");

            this.customerList.get(i).showTrans();
        }
    }

    public Customer passSelectedCustomer(String customerName){

        if(findCustomer(customerName) < 0){
            System.out.println("Unknown customer");
            return null;
        }

        int position = findCustomer(customerName);
        System.out.println("Name of selected user: " + this.customerList.get(position).getCustomerName());

        return this.customerList.get(position);
    }

}
