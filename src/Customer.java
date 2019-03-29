import java.util.ArrayList;

public class Customer {

    private String customerName;
    private ArrayList<Double> transactionList;

    public Customer(String customerName) {
        this.customerName = customerName;
        this.transactionList = new ArrayList<Double>();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public static Customer createCustomer(String newCustomerName){
        return new Customer(newCustomerName);
    }

    public boolean addTrans(Double newTrans){
        this.transactionList.add(newTrans);
        return true;
    }

    public void showTrans(){
        for(int i=0; i<this.transactionList.size(); i++){
            System.out.println("*" + (i+1) + " " + this.transactionList.get(i).doubleValue());
        }
    }

}
