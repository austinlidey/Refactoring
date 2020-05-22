public class MonsterFactory {

    public MonsterFactory() {
        // constructor
    }

	public Gremlin createGremlin() {
        return new Gremlin();
    }   

    public Skeleton createSkeleton() {
        return new Skeleton();
    }

    public Ogre createOgre() {
        return new Ogre();
    }
}