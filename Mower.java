/*
Staci Tranquille
03/18/2024
Computer Program Design Section 002
The Mower class is for defining the Mower object. It holds the Mower constructor &
Accessor & Mutator Methods (getters & setters).
 */
public class Mower {
    private String manufacturer;
    private int year;
    private String serialNumber;
    protected String mowerType = "#"; //"protected" ensures that mowerType can only be modified by subclasses
    //When a Mower is created mowerType defaults to "#"

    //Mower Constructor (Defining Mower Object)
    public Mower(String manufacturer, int year, String serialNumber){
        this.manufacturer = manufacturer;
        this.year = year;
        this.serialNumber = serialNumber;

    }

    public Mower(){

    }
    //Mower Parameter Setters and Getters (For accessing and mutating mower data outside the class)
    public void setManufacturer(String manufacturer){
        this.manufacturer = manufacturer;
    }

    public String getManufacturer(){
        return manufacturer;
    }
    public void setYear(int year){
        this.year = year;
    }

    public int getYear(){
        return year;
    }

    public void setSerialNumber(String serialNumber){
        this.serialNumber = serialNumber;
    }
    public String getSerialNumber(){
        return serialNumber;
    }




    //Formats how mower objects are output
    public String toString(){
        return manufacturer + "\n" +
                year + "\n" +
                serialNumber + "\n" +
                mowerType; //Mower type isn't a parameter but is still updated and returned
    }

}

