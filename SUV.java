/***************************************************************
* Last Name: Fahme
* First Name: Fabio
* Student ID: 30034797
* Course: CPSC 233
* Tutorial Section: 3
* Assignment: 4

****************************************************************/



/** 
 * SUV.java: The SUV can drive in two modes: regular and AWD <br>
 * @version CPSC 233
 * @author Fabio Fahme
 */
 
public class SUV extends Car
{
    public static final int CONSUMPTION_RATE = 2;
    public static final int AWD_RATE = 4;
    public static final int REGULAR_DISTANCE = 3;
    public static final int AWD_DISTANCE = 2;

    public static final int DEFAULT_FUELLEVEL = 60;
    private char appearance;
    private String name;
    private int fuelLevel;
    
    public enum carMode {NORMAL, AWD};
	private carMode mode;
	
	
    /** Display the options for this car.
     */
    public void displayOptions()
    {
        System.out.println("=== SUV driving options ===");
        System.out.println("(a)ll wheel drive mode");
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
    public SUV(char anAppearance, String carName)
    {
       super(anAppearance, carName);
    }
	
	
	/** 
	* Setter method, sets the suv to normal mode
	*/
	public void setNormal ()
	{
		mode = carMode.NORMAL;
	}

	
	
	/** 
	* Setter method, sets the suv to all wheel drive mode
	*/
	public void setAWD ()
	{
		mode = carMode.AWD;
	}
	
	
	
	/** Checks if the suv is in all wheel drive mode
	* @return true if the suv is in awd mode else returns false
	*/
	public boolean isAWD()
	{
		if (mode == carMode.AWD)
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
	
	
	
	/** Checks if the suv is in normal mode
	* @return true if the suv is in normal mode else returns false
	*/
	public boolean isNormal()
	{
		if(mode == carMode.NORMAL)
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
	
	
	
	/** Calculates the distance the suvshould
	* move depending on the mode it's in and consumes 
	* fuel accordinlgy
	* @return integer that represents the number of km traveled
	*/
	public int move ()
	{
		if((isEmpty()) || ((getFuelLevel()) < 4 && (mode == carMode.AWD))) // checks if fuel is finished
		{
			return 0;
		}
		
		else
		{
			if (mode == carMode.AWD) // checks if in aw mode
			{
				consumeFuel(AWD_RATE * AWD_DISTANCE);
				return AWD_DISTANCE;
			}
		
			if (mode == carMode.NORMAL) // checks if in normal mode
			{
				consumeFuel(CONSUMPTION_RATE * REGULAR_DISTANCE);
				return REGULAR_DISTANCE;
			}
		
		return 0;
		}
	}
	
	
	
	
	/** Depending on the users choice it processes the option
	* and the move will have to make
	* @param option the character representing the user's choice
	* returns an integer that represents the number of km traveled
	*/
	public int processOption(char option)
	{
		if (option == 'a')
		{
			setAWD();
			return move();
		}
		
		if (option == 'd')
		{
			setNormal();
			return move();
		}
		
		else
		{
			return 0;
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