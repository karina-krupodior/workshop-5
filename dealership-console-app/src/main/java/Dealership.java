import java.util.ArrayList;

public class Dealership {
    private String name;
    private  String address;
    private String phone;
    private ArrayList <Vehicle> inventory;

   public Dealership(String name,String address,String phone,ArrayList <Vehicle> inventory) {
       this.name = name;
       this.address = address;
       this.phone = phone;
       this.inventory =  new ArrayList<Vehicle> ();


    }
    public String getName () {
       return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getAddress (){
       return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }
    public  void setPhone(String phone) {
       this.phone = phone;
    }
    public  ArrayList<Vehicle> getInventory () {
       return inventory;

    }
}
