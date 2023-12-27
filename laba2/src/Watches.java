public abstract class Watches extends Gadgets {
    private int waterproof;
    public Watches(){
        super("Apple","Watch20",500);
        this.waterproof = 54;
    }
    public Watches(String company, String model, int price, int waterproof){
        super(company,model,price);
        this.waterproof = waterproof;
    }
    public int getWaterproof(){return waterproof;}
    public void setWaterproof(int waterproof){this.waterproof = waterproof;}
    @Override
    public String GadgetsInfo(){
        return super.GadgetsInfo() + String.format(", Waterproof: %d",
                this.waterproof);
    }

}
