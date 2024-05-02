/*
Staci Tranquille
03/18/2024
Computer Program Design Section 002
The CommercialMower class is for defining the CommercialMower object. It holds the CommercialMower constructor &
Accessor & Mutator Methods (getters & setters).
 */
public class CommercialMower extends LawnTractor{
    private double operatingHours;
    private boolean isZeroTurnRadius;

    //CommercialMower Constructor (Defining CommercialMower Object)
    public CommercialMower(String manufacturer,int year, String serialNumber, Engine engine, String model, double deckWidth, double operatingHours, boolean isZeroTurnRadius){
        super(manufacturer, year, serialNumber, engine, model, deckWidth);
        this.operatingHours = operatingHours;
        this.isZeroTurnRadius = isZeroTurnRadius;


    }


    public CommercialMower(){
        mowerType = "C";
    } //When a CommercialMower object is created mowerType is automatically associated with "C"

    //CommercialMower Parameter Setters and Getters (For accessing and mutating CommercialMower data outside the class)
    public void setOperatingHours(double operatingHours){
        this.operatingHours = operatingHours;
    }

    public double getOperatingHours(){
        return operatingHours;
    }

    public void setZeroTurnRadius(boolean isZeroTurnRadius){
        this.isZeroTurnRadius = isZeroTurnRadius;
    }

    public boolean isZeroTurnRadius(){
        return isZeroTurnRadius;
    }


    @Override
    //Formats how CommercialMower objects are output
    public String toString(){
        return super.toString()
                + "\n" +
                operatingHours + "\n" +
                isZeroTurnRadius;
    }

}
