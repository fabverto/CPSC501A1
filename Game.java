/*******************************************************************************
* Last Name: Fahme
* First Name: Fabio
* Student ID: 30034797
* Course: CPSC 233
* Tutorial Section: 3
* Assignment: 4
*
*
* This program is a simple car game, it involves two cars: one suv car
* and one sports car. They race on a 25km track and each one of them has
* two possible driving modes each driving mode has different effects and 
* can be switched base on the track condition, which can have three 
* possible choices.
* The game ends when either the player chooses to quit the game or one of
* the two cars wind or both cars are out of fuel.
******************************************************************************/

/** 
* Game.java:  main method, it's the game controller, it controls the game	
* @version CPSC 233
* @Author Fabio Fahme
*/

import java.util.Scanner;
import java.util.Random;


public class Game
{
    public static void main(String [] args)
    {
		Random randomNumber = new Random(Long.parseLong(args[0])); // instanciation of the Random object
		
		
		char appearanceSUV = 'V';
		char appearanceSport = 'P';
		String nameSport = "Sports Car";
		String nameSUV = "SUV Car";
		String choice;
		char choice1;
		int randomNum; // the random number
		int loc1; // moves of the suv
		int loc2; // moves of the sports car
		int round = 1; // stores the round number
		
		Scanner keyboard = new Scanner(System.in);
		
		Track newTrack = new Track (); // new object of type track
		
		Sports sportCar = new Sports (appearanceSport, nameSport); // sports object
		SUV suvCar = new SUV (appearanceSUV, nameSUV); // suv object
		
		newTrack.initializeLocation(); //initializes the locations of the cars to the starting position
		newTrack.addCars(suvCar, sportCar); // adds the cars to the array in track
		
		// keeps looping until the cars are out of fuel or they reached the end of the track
		while((newTrack.carFinish() == false) && ((suvCar.isEmpty() == false) && (sportCar.isEmpty() == false))) 
		{
			if((sportCar.isEmpty()) && (suvCar.isEmpty())) // if both cars have no more fuel the program ends
			{
				System.out.println("========== GAME OVER ==========");
				break;
			}
			
			else
			{
		
				randomNum = randomNumber.nextInt(3); // generates the random number
				newTrack.trackCondition(randomNum); // initializes the condition of the track
				
				if(newTrack.isHeatwave())
				{
					sportCar.setOverheated(); // sets the sport car in overheated mode if the track condition is heatwave
				}
				
				System.out.println();
				System.out.println();
				System.out.println("========== ROUND " + round + " ==========");
				newTrack.display();
				
				System.out.println();
				
				// checks if suv has enough fuel
				if (suvCar.isEmpty() || ((suvCar.isNormal()) && (suvCar.getFuelLevel() < 6)) || ((suvCar.isAWD()) && (suvCar.getFuelLevel() < 8))) 
				{
					System.out.println("=== Skipping SUV (out of fuel) ===");
				}
				
				else
				{
					suvCar.displayOptions();
					choice = keyboard.next();
					choice1 = choice.charAt(0); // convert the string into a character
					
					if((choice1 == 'q') || (choice1 == 'a') || (choice1 == 'd')) // checks if the input is valid
					{
					
						if(choice1 == 'q') // quits the program if the option quit is choosed by the user
						{
							break;
						}
						
						if(newTrack.isBlizzard() && choice1 == 'd') // decides what to do if the condition is blizzard
						{
							System.out.println("Move: " + 0);
							suvCar.consumeFuel(6);
							System.out.println("SUV: " + suvCar.getFuelLevel());
						}
						else
						{
							loc1 = suvCar.processOption(choice1);
							System.out.println("Move: " + loc1);
							System.out.println("SUV: " + suvCar.getFuelLevel());
							newTrack.updateSuvLocation(loc1); 
						}
					}
					
					else
					{
						System.out.println();
						System.out.println("Invalid Input"); // exits the program if the input was not valid
						break;
					}
				}
				System.out.println();
				
				// checks if sports car has enough fuel
				if (sportCar.isEmpty() || ((sportCar.isNormal()) && (sportCar.getFuelLevel() < 8)) || ((sportCar.isOverheated()) && (sportCar.getFuelLevel() < 4))) 
				{
					System.out.println("=== Skipping Sport Car (out of fuel) ===");
				}
				
				else
				{
					sportCar.displayOptions();
					choice = keyboard.next();
					choice1 = choice.charAt(0);
					
					if(!(choice1 == 'q') || !(choice1 == 'c') || !(choice1 == 'd')) // checks if the input is valid
					{
					
						if (choice1 == 'q') // exits the program if the user's choice is q
						{
							break;
						}
						
						loc2 = sportCar.processOption(choice1);
						System.out.println("Move: " + loc2);
						System.out.println("Sports: " + sportCar.getFuelLevel());
						newTrack.updateSportsLocation(loc2);
					}
					
					else
					{
						System.out.println();
						System.out.println("Invalid Input");
						break;
					}
				
				}
				round++; // increments the round number
			}
		}
		
		
		System.out.println();
		
		
		System.out.println("========== GAME OVER ==========");
		
		newTrack.display();
		keyboard.close();
	}
    
	public static String getID() 
	{
		return "30034797"; 
	}
}