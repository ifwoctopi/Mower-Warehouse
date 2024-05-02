/*
Staci Tranquille
03/18/2024
Computer Program Design Section 002
The LawnTractor class is for defining the LawnTractor object. It holds the LawnTractor constructor &
Accessor & Mutator Methods (getters & setters).
 */

//"Extends" means the class is inherited from Mower. In this case LawnTractor is a type of Mower
public class LawnTractor extends Mower {
    private Engine engine; //engine parameter is engine object
    private String model;
    private double deckWidth;

    //LawnTractor Constructor (Defining LawnTractor Object)
    public LawnTractor(String manufacturer,int year, String serialNumber, Engine engine, String model, double deckWidth){
        super(manufacturer, year, serialNumber); //Uses parameters of parent class
        this.engine = engine;
        this.model = model;
        this.deckWidth = deckWidth;




    }


    public LawnTractor(){
        mowerType = " L"; //When a LawnTractor object is created mowerType is automatically associated with "L"
    }


    //LawnTractor Parameter Setters and Getters (For accessing and mutating LawnTractor data outside the class)
    public void setEngine(Engine engine){
        this.engine = engine;
    }

    public Engine getEngine(){
        return engine;
    }

    public void setModel(String model){
        this.model = model;
    }
    public String getModel(){
        return model;
    }

    public void setDeckWidth(double deckWidth){
        this.deckWidth = deckWidth;
    }

    public double getDeckWidth(){
        return deckWidth;
    }


    //Formats how LawnTractor objects are output
    @Override //Overrides toString() of parent class
    public String toString(){
        return super.toString() //returns toString() of parent class as well as current classes toString()
                + "\n" +
                engine + "\n" +
                model + "\n" +
                deckWidth;
    }


}
