
public interface IAttackCharacter {

	/*-------------------------------------------------------
	attack allows character to attempt attack on opponent.  First, chance to hit
	is considered.  If a hit can occur, then the damage is calculated based on
	character's damage range.  This damage is then applied to the opponenet.
	
	Receives: opponent being attacked
	Returns: nothing
	
	This method calls: Math.random(), subtractHitPoints()
	This method is called by: overridden versions of the method in monster and
	hero classes and externally
	---------------------------------------------------------*/
	void attack(DungeonCharacter opponent);//end attack method

}