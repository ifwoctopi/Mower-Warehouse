/*
Staci Tranquille
03/18/2024
Computer Program Design Section 002
The Engine class is for defining the Engine object. It holds the Engine constructor &
Accessor & Mutator Methods (getters & setters). */
public class Engine { //Engine is not inherited from any class.
    private String manufacturer;
    private double horsepower;
    private int cylinders;

    //Engine Constructor (Defining Engine Object)
    public Engine(String manufacturer, double horsepower, int cylinders){
        this.manufacturer = manufacturer;
        this.horsepower = horsepower;
        this.cylinders = cylinders;

    }


    public Engine(){
        //Engine isn't inherited from mower, so it has no mowertype variable to access
    }

    //Engine Parameter Setters and Getters (For accessing and mutating Engine data outside the class)
    public void setManufacturer(String manufacturer){
        this.manufacturer = manufacturer;
    }

    public String getManufacturer(){
        return manufacturer;
    }

    public void setHoursePower(double horsepower){
        this.horsepower = horsepower;
    }

    public double getHoursePower(){
        return horsepower;
    }

    public void setCylinders(int cylinders){
        this.cylinders = cylinders;
    }

    public int getCylinders(){
        return cylinders;
    }

    //Formats how Engine objects are output
    public String toString(){
        return manufacturer + "\n" +
                horsepower + "\n" +
                cylinders;
    }

}
