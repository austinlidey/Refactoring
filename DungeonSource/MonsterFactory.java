public class MonsterFactory {
    public MonsterFactory() {}
	public Warrior createWarrior(String name) {
        Warrior warrior = new Warrior();
        warrior.setName(name);
        return warrior;
    }   
    public Sorceress createSorceress(String name) {
        Sorceress sorceress = new Sorceress();
        sorceress.setName(name);
        return sorceress;
    }  
	public Thief createThief(String name) {
        Thief thief = new Thief();
        thief.setName(name);
        return thief;
    }
}