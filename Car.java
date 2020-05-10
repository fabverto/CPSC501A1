/***************************************************************
* Last Name: Fahme
* First Name: Fabio
* Student ID: 30034797
* Course: CPSC 233
* Tutorial Section: 3
* Assignment: 4

****************************************************************/


/** 
 * Car.java: The parent class for all car models. <br>
 * @version CPSC 233
 * @author Fabio Fahme
 */

public abstract class Car
{
    public static final int DEFAULT_FUELLEVEL = 60;
    private char appearance;
    private String name;
    private int fuelLevel;
    
    /** Constructor: initilize the appearance and fuel level
     * @param letter The symbol representing the car
     * @param fuel The intial fuel level
     */
    public Car(char anAppearance, String carName)
    {
        appearance = anAppearance;
        name = carName;
        
        fuelLevel = DEFAULT_FUELLEVEL;
    }
    
 
    public char getAppearance()
    {
        return appearance;
    }

	
	public static String getID() 
	{
		return "30034797"; 
	}
}