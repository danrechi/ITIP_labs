public class Smartphone extends Gadgets {
    private float sizeScreen;
    private static int cntSmartphone = 0;
    public Smartphone(String company, String model, int price, float sizeScreen){
        super(company,model,price);
        this.sizeScreen = sizeScreen;
        cntSmartphone++;
    }
    public float getSizeScreen(){return sizeScreen;}
    public void setSizeScreen(float sizeScreen){this.sizeScreen = sizeScreen;}
    public static int getCntSmartphone(){return cntSmartphone;}
    @Override
    public String GadgetsInfo(){
        return super.GadgetsInfo() + String.format(", Size Screen:%f",
                this.sizeScreen);
    }
}
