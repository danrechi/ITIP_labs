public class Laptop extends Gadgets {
    private String OS;
    public Laptop(String company, String model, int price, String OS){
        super(company,model,price);
        this.OS = OS;
    }
    public String getOS(){return OS;}
    public void setOS(String OS){this.OS = OS;}
    @Override
    public String GadgetsInfo(){
        return super.GadgetsInfo() + String.format(", Screen diameter: %s",
                this.OS);
    }
}
