/*
Staci Tranquille
03/18/2024
Computer Program Design Section 002
The MowerWareHouse Object is an arraylist of different types of mowers. Within the MowerWareHouse class there are methods for
adding, removing, searching, and counting mowers within the MowerWareHouse object. Additionally, there are methods that
read and save mowerData to a file.
 */
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import javax.swing.JFileChooser;


public class MowerWareHouse {

    //Mowers & storeName aren't static because you need it to update with every instance it is called.
    private ArrayList<Mower> mowers = new ArrayList<Mower>(); //mowers is an arraylist of mowers and it works with the different
    //types of mower objects because you have addMower methods for each type, and they all come from Mower
    static MowerWareHouse wareHouse = new MowerWareHouse();
    private String storeName;

    //storeName is in the MowerWareHouse constructor because the name belongs to the warehouse
    public MowerWareHouse(ArrayList<Mower> mowers, String storeName) {
        this.mowers = mowers;
        this.storeName = storeName;

    }

    public MowerWareHouse(){

    }

    //Setters and Getters for storeName & Mowers
    public void setMowers(ArrayList<Mower> mowerList) {
        this.mowers = mowerList;
    }

    public ArrayList<Mower> getMowers() {
        return mowers;
    }

    public void setStoreName(String storeName){
        this.storeName = storeName;
    }
    public String getStoreName(){
        return storeName;
    }

    /*
    addMower methods for all types of mowers (since every type is a different object they need different addMower
    methods).
     */
    public void addMower(Mower mower){
        this.mowers.add(mower);
    }
    public void addMower(CommercialMower commercialMower) {
        this.mowers.add(commercialMower);
    }

    public void addMower(LawnTractor lawnTractor) {
        this.mowers.add(lawnTractor);
    }

    public void addMower(GasPoweredMower gasPoweredMower) {
        this.mowers.add(gasPoweredMower);
    }

    public void addMower(PushReelMower pushReelMower) {
        this.mowers.add(pushReelMower);
    }

    //Method for removing mower from mowers arraylist (when method was static this wouldn't remove anything)

    public void removeMower(int index) {
        this.mowers.remove(index);
    }

    //Mower setter and getter. The difference is that the method is setting and getting at a specific index.

    public void setMower(int index, Mower mower){
        this.mowers.add(index,mower);
    }

    public Mower getMower(int index){
        return this.mowers.get(index); //gets the object at the given index
    }


    //Method for getting the number of mowers
    public int getNumMowers(){

        return this.mowers.size(); //gets the size of the array
    }



    //Method for reading data from file
    public static void readMowerData(String inputFileName) {
        try {

            /*
            I used myReader to scan all the lines in the file and split them into two elements of an array Dataset
            if one of the elements in the array was "L", "G,", "C" or "P" (types of mowers) then I start a new
            scanner MowerType that will read the according amount of elements and store it in the object associated
            with the given type of mower
             */
            File fileName = new File(inputFileName);
           Scanner myReader = new Scanner(fileName); //Scanner for accessing each line in the file

            /*
        Scanner for re-accessing each line in the file from the beginning while sorting the lines into objects
        */
            Scanner mowerType = new Scanner(fileName);

            mowerType.nextLine(); //doesn't include name of store when sorting

             wareHouse.setStoreName(myReader.nextLine()); //first line of file is the name of the store

            String[] dataSet = new String[2];

            while (myReader.hasNextLine()) {

            //Puts every two lines into an arraylist dataSet
                for (int i = 0; i < dataSet.length; i++) {
                    String data = myReader.nextLine();
                    dataSet[i] = data;

                }


                for (String sort : dataSet) { //for each string in dataSet
                        // LawnTractor Comments apply for all cases in the entire switch
                    switch (sort) {
                        case "L" -> { //if "L" is an element in dataSet
                            LawnTractor lawn = new LawnTractor(); //Creates new LawnTractor object
                            Engine lawnEngine = new Engine();      //Creates new Engine object (LawnTractor has an engine)
                            String[] lawnTractor = new String[9]; //Size of stringList == number of parameters of for object

                            for (int i = 0; i < lawnTractor.length; i++) {
                                lawnTractor[i] =  mowerType.nextLine(); //Starts the second scanner to put mower details into a string list
                            }

                            //Sets parameters with according data at specific indexes
                            lawn.setManufacturer(lawnTractor[0]);
                            lawn.setYear(Integer.parseInt(lawnTractor[1]));
                            lawn.setSerialNumber(lawnTractor[2]);
                            lawnEngine.setManufacturer(lawnTractor[4]);
                            lawnEngine.setHoursePower(Double.valueOf(lawnTractor[5]));
                            lawnEngine.setCylinders(Integer.valueOf(lawnTractor[6]));
                            //Lines 4-6 are engine parameters. I set the engine's parameters before setting the mower's engine
                            lawn.setEngine(lawnEngine); //Setting mower's engine
                            lawn.setModel(lawnTractor[7]);
                            lawn.setDeckWidth(Double.valueOf(lawnTractor[8]));
                            wareHouse.addMower(lawn); //adds the mower to the MowerWareHouse object


                        }
                        case "C" -> {
                            CommercialMower commercial = new CommercialMower();
                            Engine commEngine = new Engine();
                            String[] commercialMower = new String[11];

                            for (int i = 0; i < commercialMower.length; i++) {
                                String commercialData = mowerType.nextLine();
                                commercialMower[i] = commercialData;
                            }
                            commercial.setManufacturer(commercialMower[0]);
                            commercial.setYear(Integer.parseInt(commercialMower[1]));
                            commercial.setSerialNumber(commercialMower[2]);
                            commEngine.setManufacturer(commercialMower[4]);
                            commEngine.setHoursePower(Double.valueOf(commercialMower[5]));
                            commEngine.setCylinders(Integer.valueOf(commercialMower[6]));
                            commercial.setEngine(commEngine);
                            commercial.setModel(commercialMower[7]);
                            commercial.setDeckWidth(Double.valueOf(commercialMower[8]));
                            commercial.setOperatingHours(Double.valueOf(commercialMower[9]));
                            commercial.setZeroTurnRadius(Boolean.valueOf(commercialMower[10]));
                            wareHouse.addMower(commercial);

                        }
                        case "G" -> {
                            GasPoweredMower gas = new GasPoweredMower();
                            Engine gasEngine = new Engine();
                            String[] gasPowered = new String[10];

                            for (int i = 0; i < gasPowered.length; i++) {
                                String gasPoweredData = mowerType.nextLine();
                                gasPowered[i] = gasPoweredData;
                            }
                            gas.setManufacturer(gasPowered[0]);
                            gas.setYear(Integer.parseInt(gasPowered[1]));
                            gas.setSerialNumber(gasPowered[2]);
                            gas.setCutWidth(Double.valueOf(gasPowered[4]));
                            gas.setWheelDiameter(Double.valueOf(gasPowered[5]));
                            gasEngine.setManufacturer(gasPowered[6]);
                            gasEngine.setHoursePower(Double.valueOf(gasPowered[7]));
                            gasEngine.setCylinders(Integer.valueOf(gasPowered[8]));
                            gas.setEngine(gasEngine);
                            gas.setSelfPropelled(Boolean.valueOf(gasPowered[9]));


                            wareHouse.addMower(gas);

                        }
                        case "P" -> {
                            PushReelMower push = new PushReelMower();
                            //Push Reel Mower has no engine so there is no engine object
                            String[] pushReel = new String[7];

                            for (int i = 0; i < pushReel.length; i++) {
                                String pushReelData = mowerType.nextLine();
                                pushReel[i] = pushReelData;
                            }

                            push.setManufacturer(pushReel[0]);
                            push.setYear(Integer.parseInt(pushReel[1]));
                            push.setSerialNumber(pushReel[2]);
                            push.setCutWidth(Double.valueOf(pushReel[4]));
                            push.setWheelDiameter(Double.valueOf(pushReel[5]));
                            push.setNumWheels(Integer.valueOf(pushReel[6]));

                            wareHouse.addMower(push);

                        }
                    }
                }


            }
            

            myReader.close(); //Closes the scanner
            mowerType.close(); //Closes the 2nd scanner


            //If file can't be found this error is thrown
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();

        }


    }
    //Method for searching for mower type according to the input (L,C,P,G)
   public static void search(String input) {
        switch (input) {
            case "L" -> { //In the case of L being the input
                for (Mower mower : wareHouse.getMowers()) { //Iterates through the mowers in the mower warehouse
                    if (mower instanceof LawnTractor & !(mower instanceof CommercialMower)) {
                        //if the mower is an instance of LawnTractor (mower associated with L)
                        System.out.println(mower); // print the mower
                    }
                }

            }
            case "C" -> { //In the case of C being the input
                for (Mower mower : wareHouse.getMowers()) { //Iterates through the mowers in the mower warehouse
                    if (mower instanceof CommercialMower) { //if the mower is an instance of Commercial Mower
                        System.out.println(mower); //print the mower
                    }
                }
            }
            case "G" -> {
                for (Mower mower : wareHouse.getMowers()) {
                    if (mower instanceof GasPoweredMower) { //if the mower is an instance of GasPoweredMower
                        System.out.println(mower); //print the mower
                    }
                }
            }
            case "P" -> {
                for (Mower mower : wareHouse.getMowers()) {
                    if (mower instanceof PushReelMower) { //if the mower is an instance of PushReelMower
                        System.out.println(mower); //print the mower
                    }
                }
            }

        }
    }

    public void saveMowerData(String outputFileName) {
        try (FileWriter writer = new FileWriter(outputFileName)) {
            // Write store name
            if (this.storeName != null && !this.storeName.isEmpty()) {
                writer.write(this.storeName + "\n");
            }

            // Write mower details
            for (Mower mower : this.mowers) {
                writer.write(mower.toString() + "\n");
            }
        } catch (IOException e) { //Exception for if data could not be output to file
            System.out.println("An error occurred while saving data to file: " + e.getMessage());
        }

    }
    @Override
    public String toString(){ //Formats how the warehouse is output
            StringBuilder mowerList = new StringBuilder();
            for (Mower mower : this.mowers) {
                    if(mower.getManufacturer() != null){ //does not print null mowers
                        mowerList.append(mower).append("\n"); //adds mower to string builder
                    }

                }


            return getStoreName() + "\n" + mowerList; //prints store name and string builder (list of mowers)
        }


    public static void main(String[] args) throws IOException {
        Scanner scnr = new Scanner(System.in); // Scanner for scanning input
        if (args.length > 0) { //if commandline has arguments
            String filePath = args[0]; //assume it is the filepath
            File file = new File(filePath); //open file with the filepath

            if (file.exists()) { // if the file exists
                System.out.print("File exists");
                readMowerData(filePath); //call the readMowerData function
            } else {
                System.out.print("Error: File does not exist"); //if file does not exist print the following error
            }
        } else { //if file path was not given in commandline
            JFileChooser fileChooser = new JFileChooser(); //new JFileChooser Object

            //Displays the file chooser and stores what user decides to do in result
            int result = fileChooser.showOpenDialog(null);


            if (result == JFileChooser.APPROVE_OPTION) { //if user selects a file (Approve Option)
                File selectedFile = fileChooser.getSelectedFile(); //file chooser gets the selected file
                String fileAsString = selectedFile.toString(); //makes into String
                readMowerData(fileAsString); //gives the file as a parameter to readMowerData
            } else {
                // if user doesn't select a file (CANCEL_OPTION) or an error occurs system prints following prompt
                System.out.println("No file selected");

            }
        }

        System.out.println("Enter your choice of Mower to get information.");
        String input;
        while (true) { //Makes the program keep running until condition for while loop breaking
            System.out.print("Type C for Commercial Mower, G for Gas Powered Mower, P for Push Reel Mower, L for Lawn Tractor, and S to stop: ");
            input = scnr.next();

            if (input.equals("S")){
                break; //Program stops when S is input
            }
            else if(!input.equals("C") && !input.equals("G") && !input.equals("P") && !input.equals("L")){
                //If input is none of the letter options following prompt is output
                System.out.print("Invalid input. Please try again.");
            }
            else {
                /*
                If the input is one of the letters search() method is called and program searches mower warehouse for
                mowers of that type.
                 */
                search(input);
            }


        }


    }
}