/*
Staci Tranquille
03/18/2024
Computer Program Design Section 002
The GasPoweredMower class is for defining the GasPoweredMower object. It holds the GasPoweredMower constructor &
Accessor & Mutator Methods (getters & setters).
 */
public class GasPoweredMower extends WalkBehindMower{
    private Engine engine;
    private boolean isSelfPropelled;

    //GasPoweredMower Constructor (Defining GasPoweredMower Object)
    public GasPoweredMower(String manufacturer,int year, String serialNumber, double cutWidth, double wheelDiameter, Engine engine, boolean isSelfPropelled){
        super(manufacturer, year, serialNumber, cutWidth, wheelDiameter);
        this.engine = engine;
        this.isSelfPropelled = isSelfPropelled;




    }

    public GasPoweredMower(){
        mowerType = "G"; //When a GasPoweredMower object is created mowerType is automatically associated with "G"
    }

    //GasPoweredMower Parameter Setters and Getters (For accessing and mutating GasPoweredMower data outside the class)
    public void setEngine(Engine engine){
        this.engine = engine;
    }

    public Engine getEngine(){
        return engine;
    }

    public void setSelfPropelled(boolean selfPropelled){
        this.isSelfPropelled = selfPropelled;
    }

    public boolean isSelfPropelled(){
        return isSelfPropelled;
    }

    @Override

    //Formats how GasPoweredMower objects are output
    public String toString(){
        return super.toString()
                + "\n" +
                engine + "\n" +
                isSelfPropelled;
    }

}
