/***************************************************************
* Last Name: Fahme
* First Name: Fabio
* Student ID: 30034797
* Course: CPSC 233
* Tutorial Section: 3
* Assignment: 4
*
*
* This class manages the track, it manages the two cars inside 
* an array and their location it also decideson the track 
* condition and displays the game options and the track.
****************************************************************/


/** 
 * Track.java: The track for the car race <br>
 * @version CPSC 233
 * @Author Fabio Fahme
 */

public class Track
{
    public static final int TRACK_SIZE = 25;
    public static final int MAX_CARS = 2;
    public static enum TrackCondition {HEATWAVE, BLIZZARD, NORMAL};
    
    private Car[] cars;
    private int[] locations;
    private TrackCondition condition;
    private boolean finished;

    /** Create the track and place the car at the beginning of a track to start the race.
     * @param aCar The car to be placed.
     */
    public Track()
    {
        cars = new Car[MAX_CARS];
        locations = new int[MAX_CARS];
        for (int i = 0; i < MAX_CARS; i++)
        {
            cars[i] = null;
            locations[i] = -1;
        }
        condition = TrackCondition.NORMAL;
        finished = false;
    }
    
   
	/** Displays the track with a numbered grid.  The car will appeart in the grid reflecting its current location.
     */
    public void display()
    {
        // Display track condition
        System.out.print("Track condition: ");
        switch (condition)
        {
            case BLIZZARD:
                System.out.println ("blizzard");
                break;
            case HEATWAVE:
                System.out.println ("heatwave");
                break;
            case NORMAL:
                System.out.println ("normal");
                break;
            default:
                System.out.println ("unknown");
        }

        // Compile each part the track for display
        char label = 'A';
        String trackLabel = "";
        String separator = "";
        String grid = "";
        grid += "|";
        for (int i = 0; i < TRACK_SIZE; i++)
        {
            for (int j = 0; j < MAX_CARS; j++)
            {
                trackLabel += " ";
                separator += "-";
                if (i == locations[j])
                    grid += cars[j].getAppearance();
                else
                    grid += " ";
            }
            trackLabel += label;
            separator += "-";
            label += 1;  
            grid += "|";         
        }
        //grid += "|";
     
        // Display the track
        System.out.println(trackLabel);
        System.out.println(separator);
        System.out.println(grid);
        System.out.println(separator);
        
    }
	
	/** Adds the two cars to the array of type car
	* @param carSUV the car object to be added 
	* @param carSUV the car object to be added
	*/
	public void addCars (Car carSUV, Car carSports )
	{
		cars[0] = carSUV;
		cars[1] = carSports;
	}
	
	
	/** Initializes the array indication the location
	* of each car to 0, as a starting point.
	*/
	public void initializeLocation()
	{
		for (int i = 0; i < MAX_CARS; i++)
		{
			locations[i] = 0;
		}
	}


	
	/** Checks if the cars reached the end of the track
	* @return True if either both or only one of the two cars
	* has reached the end of the track, if not is returns false.
	*/
	public boolean carFinish()
	{
		if(locations[0] >= 24 && locations[1] >= 24) // checks if both cars have reached the end of the track
		{
			finished = true;
			return finished;
		}
		
			
		if (locations[0] >= 24 || locations[1] >=24) // checks if at least one of the cars has reched the end of the track
			{
				finished = true;
				return finished;
			}
			
		else
		{
			finished = false;
			return finished;		
		}
		
	}
	
	
	
	
	/** Get method that returns the condition of the track
	* @return returns the track condition
	*/
	public TrackCondition getTrackCondition()
	{
		return condition;
	}
	
	
	
	
	/** Depending on the random number passes in as argument it
	* sets the track condition accordingly
	* @param random the random number used to decide on the track condition
	*/
	public void trackCondition (int random)
	{
		if (random == 0)
		{
			condition = TrackCondition.BLIZZARD;
		}						
		else if (random == 1)
		{
			condition = TrackCondition.HEATWAVE;
		}					
		else
		{
			condition = TrackCondition.NORMAL;
		}	
	}
	
	
	
	
	/** Get method that returns the array representing 
	* the locations of th cars
	* @return locations which is the array representing
	* the car locations
	*/
	public int[] getLocations()
	{
		return locations;
	}

	
	
	
	/** Checks if the track condition is heatwave
	* @return true if the track is in heatwave condition
	* else returns false
	*/
	public boolean isHeatwave()
	{
		if(condition == TrackCondition.HEATWAVE)
		{
			return true;
		}
		
		else 
		{
			return false;
		}
	}



	/** Checks if the track condition is blizzard
	* @return true if the track condition is blizzard
	* else it returns false
	*/	
	public boolean isBlizzard()
	{
		if(condition == TrackCondition.BLIZZARD)
		{
			return true;
		}
		
		else 
		{
			return false;
		}
	}





	/** Updates the location of the suv inside the array
	* @param suvMove representing the moves the suv is making
	*/	
	public void updateSuvLocation (int suvMove)
	{
		int index = 0;
		index = locations[0];
		
		if(index + suvMove <= 24)
		{
			locations[0] = index + suvMove; // updates the location of the suv
		}
		else
		{
			locations[0] = 24;	// makes sure the car doesn't go out of bounds
		}
	}
	
	
	
	
	/** Updates the location of the sports car inside the array
	* @param sportsMove representing the moves the sports car is making
	*/	
	public void updateSportsLocation (int sportsMove)
	{
		int index = 0;
		index = locations[1];
		
		if(index + sportsMove <= 24) // updates the location of the sports car
		{
			locations[1] = index + sportsMove;
		}
		
		else
		{
			locations[1] = 24; // makes sure the car doesn't go out of bounds
		}
		
	}
	
	public static String getID() 
	{
		return "30034797"; 
	}
}