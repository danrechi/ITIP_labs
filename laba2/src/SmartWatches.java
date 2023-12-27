public class SmartWatches extends Watches {
    private String strapColor;
    public SmartWatches(String company, String model, int price, int waterproof,String strapColor){
        super(company, model, price,waterproof);
        this.strapColor = strapColor;
    }
    public String getStrapColor(){return strapColor;}
    public void setStrapColor(String strapColor){this.strapColor=strapColor;}
    @Override
    public String GadgetsInfo(){
        return super.GadgetsInfo() + String.format(", Strap color: %s",
                this.strapColor);
    }
}
