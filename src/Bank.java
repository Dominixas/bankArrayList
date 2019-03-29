import java.util.ArrayList;

public class Bank {

    private String bankName;
    private ArrayList<Branch> branchList;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.branchList = new ArrayList<Branch>();
    }

//    public String getBankName() {
//        return bankName;
//    }
//
//    public void setBankName(String bankName) {
//        this.bankName = bankName;
//    }

    public boolean addBranch(Branch newBranch){
        if(findBranch(newBranch.getBranchName()) <= 0){
            System.out.println("Adding new branch: " + newBranch.getBranchName());
            branchList.add(newBranch);
            return true;
        }
        else{
            System.out.println("Cannot add a new branch");
            return false;
        }
    }

    public int findBranch(String branchName){
        for(int i=0; i<this.branchList.size(); i++){
            if(this.branchList.get(i).getBranchName().equals(branchName)) {
                return i;
            }
        }
        return -1;
    }

    public void showBranchList(){
        for(int i=0; i<this.branchList.size(); i++){
            System.out.println((i+1) + ". " + branchList.get(i).getBranchName());
        }
    }

    public Branch passSelectedBranch(String selectedBranchName){
        if(findBranch(selectedBranchName) < 0){
            System.out.println("Unknown branch");
            return null;
        }

        int position = findBranch(selectedBranchName);
        System.out.println("Name of selected branch: " + this.branchList.get(position).getBranchName());

        return this.branchList.get(position);
    }

}
