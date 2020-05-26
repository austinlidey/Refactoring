import java.util.InputMismatchException;
import java.util.Scanner;

public class DungeonUtils {



/*-------------------------------------------------------------------
chooseHero allows the user to select a hero, creates that hero, and
returns it.  It utilizes a polymorphic reference (Hero) to accomplish
this task
---------------------------------------------------------------------*/
	public Hero chooseHero(Scanner kb)
	{
		// REFACTOR: used HeroFactory to return Hero objects.	
		HeroFactory heroFac = new HeroFactory();
		int choice = 0; 
		String name, buffer;
		// REFACTOR: no longer necessary due to scanner
		// Hero theHero; 

		do {
			try {
				System.out.print("Choose a hero:\n" +
					       "1. Warrior\n" +
						   "2. Sorceress\n" +
						   "3. Thief\n" +
						   "--> ");
				choice = kb.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a number not equal to 0.");
			}
			kb.nextLine();
		} while (choice == 0); //forces user to input a number before instantiating a character (Nick)
		
		switch(choice)
		{
			case 1: 
				name = getInputName(kb);
				System.out.println("A warrior named " + name + " has been created.");
				return heroFac.createWarrior(name);

			case 2: 
				name = getInputName(kb);
				System.out.println("A sorceress named " + name + " has been created.");
				return heroFac.createSorceress(name);

			case 3:
				name = getInputName(kb); 
				System.out.println("A thief named " + name + " has been created.");
				return heroFac.createThief(name);

			default: 
				System.out.println("Invalid choice. Returning theif.");
				name = getInputName(kb);
				System.out.println("A thief named " + name + " has been created.");
				return heroFac.createThief(name);
		}//end switch
	}//end chooseHero method
/*-------------------------------------------------------------------
REFACTOR: created getInputName(Scanner kb) to reduce code 
duplication. This prints a prompt for user to enter a hero name,returns 
a String name which will be input into a HeroFactory create method to set the name of 
the Hero object. (by Mia Hunt) 05/22/2020
---------------------------------------------------------------------*/
	public String getInputName(Scanner kb) {
		System.out.print("Enter a character name: ");
		return kb.nextLine();
	}	
/*-------------------------------------------------------------------
generateMonster randomly selects a Monster and returns it.  It utilizes
a polymorphic reference (Monster) to accomplish this task.
---------------------------------------------------------------------*/
	public Monster generateMonster()
	{
		// REFACTOR: used MonsterFactory to return Monster objects.
		MonsterFactory monsterFac = new MonsterFactory();
		int choice;

		choice = (int)((Math.random() * 3) + 1);

		switch(choice)
		{
			case 1: return monsterFac.createOgre();

			case 2: return monsterFac.createGremlin();

			case 3: return monsterFac.createSkeleton();

			default: System.out.println("invalid choice, returning Skeleton");
				     return monsterFac.createSkeleton();
		}//end switch
	}//end generateMonster method

/*-------------------------------------------------------------------
playAgain allows gets choice from user to play another game.  It returns
true if the user chooses to continue, false otherwise.
---------------------------------------------------------------------*/
	public boolean playAgain(Scanner kb)
	{
		char again;

		System.out.print("If you would like to play again, please enter 'y'. Enter anything else to quit.\n-->");
		String input = kb.nextLine();
		if (input != null && !input.isBlank())
			again = input.charAt(0);
		else
			again = 'n'; //if invalid input is entered, force valid character to continue (Nick)

		return (again == 'Y' || again == 'y');
	}//end playAgain method


/*-------------------------------------------------------------------
battle is the actual combat portion of the game.  It requires a Hero
and a Monster to be passed in.  Battle occurs in rounds.  The Hero
goes first, then the Monster.  At the conclusion of each round, the
user has the option of quitting.
---------------------------------------------------------------------*/
/*--------------------------------------------------------------------
REFACTOR: deleted static (by Mia) 05/22/2020
--------------------------------------------------------------------*/
	public void battle(Scanner kb)
	{	
		/*---------------------------------------------------------
		REFACTOR: chose to create instances of Hero and monster in this 
		method instead of having it created in main method. (by Mia)
		05/22/2020
		---------------------------------------------------------*/
		Hero theHero = chooseHero(kb);
		Monster theMonster = generateMonster();

		char pause = 'p';
		System.out.println(theHero.getName() + " battles " +
							theMonster.getName());
		System.out.println("---------------------------------------------");

		//do battle
		while (theHero.isAlive() && theMonster.isAlive() && pause != 'q')
		{
		    //hero goes first
			theHero.battleChoices(theMonster, kb);

			//monster's turn (provided it's still alive!)
			if (theMonster.isAlive())
			    theMonster.attack(theHero);

			//let the player bail out if desired
			System.out.print("\n-->q to quit, anything else to continue: ");
			String input = kb.nextLine();
			if (input != null && !input.isBlank())
				pause = input.charAt(0);
			else
				pause = 'a'; //if invalid input is entered, force valid character to continue (Nick)

		}//end battle loop

		if (!theMonster.isAlive())
		    System.out.println(theHero.getName() + " was victorious!");
		else if (!theHero.isAlive())
			System.out.println(theHero.getName() + " was defeated :-(");
		else//both are alive so user quit the game
			System.out.println("Quitters never win ;-)");

	}//end battle method
	
}
