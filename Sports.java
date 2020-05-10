/***************************************************************
* Last Name: Fahme
* First Name: Fabio
* Student ID: 30034797
* Course: CPSC 233
* Tutorial Section: 3
* Assignment: 4
*
*
* Child class of Car class, this class represents an Suv car, it
* displays it's options sets the car to one of the two possible
* modes and decides on the km travelled and fuel consumed.
****************************************************************/



/** 
 * Sport.java: The sport car can drive in two modes: regular and overheated <br>
 * @version CPSC 233
 * @author Fabio Fahme
 */

public class Sports extends Car
{
    public static final int CONSUMPTION_RATE = 2;
    public static final int OVERHEATED_RATE = 4;
    public static final int REGULAR_DISTANCE = 4;
    public static final int OVERHEATED_DISTANCE = 1;

    public static final int DEFAULT_FUELLEVEL = 60;
	private static char anApperance;
    private String name;
    private int fuelLevel;
    
    public enum carMode {NORMAL, OVERHEATED}; // two possible modes
	private carMode mode;
	
	
    /** Display the options for this car.
     */
    public void displayOptions()
    {
        System.out.println("=== Sportscar Driving Options ===");
         if (isOverheated())
             System.out.println("WARNING: car is overheated.");
         System.out.println("(c)ool off");
         System.out.println("(d)rive normally");
         System.out.println("(q)uit simulation");
         System.out.print("Enter selection: ");
    }
	
	
	
	
	/** Constructor for this class that calls the parents constructor
	* @param anAppearance the character to be shown on the track and 
	* to be used as argument for the parent constructor
	* @param carName the string with the name of the car and to be 
	* used as an argument for the parent constructor.
	*/
    public Sports(char anAppearance, String carName)
    {
    	super(anApperance,carName);
    }
    
	
	/** Checks if sports car is in overheated mode
	* @return true if the sports car is in overheated mode
	* else returns false
	*/
	public boolean isOverheated()
	{
		if (mode == carMode.OVERHEATED)
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
	
	
	/** Checks if the sports car is in normal mode
	* @return true if the sports car is in normal mode else returns false
	*/
	public boolean isNormal()
	{
		if (mode == carMode.NORMAL)
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
	
	
	
	/** 
	* Setter method that sets the sports car to overheated mode
	*/
	public void setOverheated()
	{
		mode = carMode.OVERHEATED;
	}
	
	
	
	/** 
	* Setter method, sets the sports car to normal mode
	*/
	public void setNormal()
	{
		mode = carMode.NORMAL;
	}
	
	
	/** Calculates the distance the sports car should
	* move depending on the mode it's in and consumes 
	* fuel accordinlgy
	* @return integer that represents the number of km traveled
	*/
	public int move ()
	{
		
		if((isEmpty()) || ((getFuelLevel()) < 4 && (isOverheated())))
		{
			return 0;
		}
		
		if (mode == carMode.OVERHEATED)
		{
			consumeFuel(OVERHEATED_RATE * OVERHEATED_DISTANCE);
			return OVERHEATED_DISTANCE;
		}
		
		else 
		{
			consumeFuel(CONSUMPTION_RATE * REGULAR_DISTANCE);
			return REGULAR_DISTANCE;
		}
	}
	
	
	
	/** Depending on the users choice it processes the option
	* and the move will have to make
	* @param option the character representing the user's choice
	* returns an integer that represents the number of km traveled
	*/
	public int processOption(char option)
	{
		if (option == 'c')
		{
			setNormal();
			return 0;
		}
		
		if ((option == 'd') && (!isOverheated()))
		{
			return move();
		}
		
		else 
		{
			consumeFuel(OVERHEATED_RATE * OVERHEATED_DISTANCE);
			return OVERHEATED_DISTANCE;
		}
	}
	
	 public int getFuelLevel()
	    {
	        return fuelLevel;
	    }
	 
	 public boolean isEmpty()
	    {
	        if (fuelLevel <= 0)
	            return true;
	        else
	            return false;
	    }
	 
	 public void consumeFuel(int amount)
	    {
	        if (amount > 0)
	            fuelLevel = fuelLevel - amount;
	    }
	 
	 public final char getAppearance()
	    {
	       return super.getAppearance();
	    }
	    
	    public final String toString() 
	    {
	        return name + ": " + fuelLevel;
	    }
	
	public static String getID() 
	{
		return "30034797"; 
	}
}