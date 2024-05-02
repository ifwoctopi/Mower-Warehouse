/*
Staci Tranquille
03/18/2024
Computer Program Design Section 002
The PushReelMower class is for defining the PushReelMower object. It holds the PushReelMower constructor &
Accessor & Mutator Methods (getters & setters).
 */
public class PushReelMower extends WalkBehindMower {
    private int numWheels;


    //PushReelMower Constructor (Defining PushReelMower Object)
    public PushReelMower(String manufacturer, int year, String serialNumber, double cutWidth, double wheelDiameter, int numWheels){
                super(manufacturer, year, serialNumber, cutWidth, wheelDiameter);
                this.numWheels = numWheels;
    }

    public PushReelMower(){
        mowerType = "P"; //When a PushReelMower object is created mowerType is automatically associated with "P"

    }

    //PushReelMower Parameter Setter and Getter (For accessing and mutating walk behind mower data outside the class)
    public void setNumWheels(int numWheels){
        this.numWheels = numWheels;
    }

    public int getNumWheels(){
        return numWheels;
    }

    //Formats how PushReelMower objects are output
    @Override
    public String toString(){
        return super.toString() //Returns parent class attributes & grandparent class attributes
                + "\n" + numWheels;
    }

}


