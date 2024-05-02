/*
Staci Tranquille
03/18/2024
Computer Program Design Section 002
The WalkBehindMower class is for defining the WalkBehindMower object. It holds the WalkBehindMower constructor &
Accessor & Mutator Methods (getters & setters).
 */
public class WalkBehindMower extends Mower{
    private double cutWidth;
    private double wheelDiameter;

    //WalkBehindMower Constructor (Defining WalkBehindMower Object)
    public WalkBehindMower(String manufacturer,int year, String serialNumber, double cutWidth, double wheelDiameter){
        super(manufacturer, year, serialNumber);
        this.cutWidth = cutWidth;
        this.wheelDiameter = wheelDiameter;


    }


    public WalkBehindMower(){
        /*
        WalkBehindMower doesn't have a mower type as it is a (somewhat) abstract class & isn't one of the 4
        required types
         */
    }

    //WalkBehindMower Parameter Setters and Getters (For accessing and mutating walk behind mower data outside the class)
    public void setCutWidth(double cutWidth){
        this.cutWidth = cutWidth;
    }

    public double getCutWidth(){
        return cutWidth;
    }


    public void setWheelDiameter(double wheelDiameter){
        this.wheelDiameter = wheelDiameter;
    }

    public double getWheelDiameter(){
        return wheelDiameter;
    }


    //Formats how WalkBehindMower objects are output
    @Override
    public String toString(){
        return super.toString()
                + "\n" +
                cutWidth + "\n" +
                wheelDiameter;
    }

}

