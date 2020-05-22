/**
 * Title: Dungeon.java
 *
 * Description: Driver file for Heroes and Monsters project
 *
 * Copyright:    Copyright (c) 2001
 * Company: Code Dogs Inc.
 * I.M. Knurdy
 *
 * History:
 *  11/4/2001: Wrote program
 *    --created DungeonCharacter class
 *    --created Hero class
 *    --created Monster class
 *    --had Hero battle Monster
 *    --fixed attack quirks (dead monster can no longer attack)
 *    --made Hero and Monster abstract
 *    --created Warrior
 *    --created Ogre
 *    --made Warrior and Ogre battle
 *    --added battleChoices to Hero
 *    --added special skill to Warrior
 *    --made Warrior and Ogre battle
 *    --created Sorceress
 *    --created Thief
 *    --created Skeleton
 *    --created Gremlin
 *    --added game play features to Dungeon.java (this file)
 *  11/27/2001: Finished documenting program
 * version 1.0
 * @RefactorAuthors: Mia Hunt, Nick Savoie, Austin Lidey
 * @since 05-17-2020
 */

import java.util.Scanner;

/*
  This class is the driver file for the Heroes and Monsters project.  It will
  do the following:

  1.  Allow the user to choose a hero
  2.  Randomly select a monster
  3.  Allow the hero to battle the monster

  Once a battle concludes, the user has the option of repeating the above

*/
public class Dungeon
{
    public static void main(String[] args)
	{

		/*--------------------------------------
		REFACTOR: removed instantiation of Hero 
		Monster into the DungeonUtils class to 
		create a cleaner looking and simpler
		implementation of the main class.
		(by Mia Hunt) 05/22/2020
		----------------------------------------*/

		// Hero theHero;
		// Monster theMonster;
		
		DungeonUtils dungeon = new DungeonUtils();
		/*--------------------------------------
		REFACTOR: replaced Keyboard class with 
		Scanner class which is more current.
		(by Nick Savoie) 05/22/2020
		----------------------------------------*/
		Scanner kb = new Scanner(System.in);

		/*--------------------------------------
		REFACTOR: consolidated Hero and Monster
		instantiation into DungeonUtils.battle().
		(by Mia Hunt) 05/22/2020
		----------------------------------------*/
		do
		{
		    // theHero = DungeonUtils.chooseHero(kb);
		    // theMonster = DungeonUtils.generateMonster();
			// DungeonUtils.battle(theHero, theMonster, kb);
		
		    dungeon.battle(kb);

		} while (dungeon.playAgain(kb));

		kb.close();
    }//end main method



}//end Dungeon class