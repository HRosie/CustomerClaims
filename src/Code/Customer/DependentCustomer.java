package Code.Customer;

public class DependentCustomer extends Customer{
    private PolicyHolder holderName;
    public DependentCustomer(String id, String name, String card,PolicyHolder holderName) {
        super(id,name,card);
        this.holderName = holderName;
    }


    public void setHolderName(PolicyHolder holderName) {
        this.holderName = holderName;
    }

    public PolicyHolder getHolderName() {
        return holderName;
    }

    public String getName() {
        return super.getName();
    }

    public String getCustomerType() {
        return "Dependent";
    }

    //@Override
    public void display() {
        super.displayCustomer();
        System.out.println("Holder name: " + holderName.getName());
    }
}
