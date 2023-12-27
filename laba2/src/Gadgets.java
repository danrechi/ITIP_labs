public abstract class Gadgets {
    private String company;
    private String model;
    private int price;
    public Gadgets(String company, String model, int price){
        this.company = company;
        this.model = model;
        this.price = price;
    }

    public String getCompany(){return company;}
    public void setCompany(String company){this.company = company;}
    public String getModel(){return model;}
    public void setModel(String model){this.model = model;}
    public int getPrice(){return price;}
    public void setPrice(int price){this.price = price;}
    public String GadgetsInfo(){
        return String.format("Company: %s, model: %s, price: %d",
                this.company,
                this.model,
                this.price);
    }
    public void on(){System.out.println("Устройство включено");}
    public void off(){System.out.println("Устройство выключено");}

}