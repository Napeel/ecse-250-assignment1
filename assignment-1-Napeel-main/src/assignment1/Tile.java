package assignment1;
public class Tile {
    private int food;
    private boolean isOnFire = false;
    private boolean isHive;
    private boolean isNest;
    private Tile next;
    private Tile previous;
    private SwarmOfHornets swarm;
    private HoneyBee bee;
    private boolean onThePath;



    public Tile() {
        this.isHive = false;
        this.isNest = false;
        this.onThePath = false;
        this.food = 0;
        this.bee = null;
        this.swarm = new SwarmOfHornets();
        this.isOnFire = false;
    }

    public Tile(int food, boolean isHive, boolean isNest, boolean onPath,
                Tile next, Tile previous, HoneyBee bee, SwarmOfHornets swarm) {
        this.food = food;
        this.isHive = isHive;
        this.isNest = isNest;
        this.onThePath = onPath;
        this.next = next;
        this.previous = previous;
        this.swarm = swarm;
        this.bee = bee;
    }

    public boolean isHive() {
        return isHive;
    }

    public boolean isNest() {
        return isNest;
    }

    public boolean isOnThePath() {
        return onThePath;
    }

    public void buildHive(){
        this.isHive = true;
    }
    public void buildNest(){
        this.isNest = true;
    }
    public Tile towardTheHive(){
        if (!onThePath || isHive){
            return null;
        }
        return next;
    }

    public Tile towardTheNest() {
        if (!onThePath || isNest){
            return null;
        }
        return previous;
    }
    public void createPath(Tile nextTileToHive, Tile nextTileToNest){
        if (((nextTileToHive == null)&&this.next != null) || (nextTileToNest == null)&&this.previous!=null){
            throw new IllegalArgumentException("error there is a nest or hive on one of the input tiles");
        }
        this.next = nextTileToHive;
        this.previous = nextTileToNest;
        this.onThePath = true;

    }
    public int collectFood(){
        int temp = food;
        this.food = 0;
        return temp;
    }
    public void storeFood(int i){
        this.food += i;
    }

    public int getNumOfHornets(){
        return swarm.sizeOfSwarm();
    }
    public HoneyBee getBee(){
        return bee;
    }

    public Hornet getHornet(){
        if (swarm != null) {
            return swarm.getFirstHornet();
        } else {
            return null;
        }
    }
    public SwarmOfHornets getSwarmofHornets(){
        return this.swarm;

    }

    public Hornet[] getHornets() {
        return swarm.getHornets();
    }

    public boolean addInsect(Insect insect) {
        if (insect instanceof HoneyBee) {
            if (this.getBee() == null) {
                if (!this.isNest) {
                    this.bee = (HoneyBee) insect;
                    insect.setPosition(this);
                    return true;
                }}}
        else if (insect instanceof Hornet) {
            if (onThePath) {
                if (swarm == null) {
                    swarm = new SwarmOfHornets();}
                swarm.addHornet((Hornet) insect);
                insect.setPosition(this);
                return true;
            }}
        return false;
    }




    public boolean removeInsect(Insect insect) {
        if (this.bee != null && insect instanceof HoneyBee) {
            this.bee = null;
            insect.setPosition(null);
            return true;
        }
        if (this.swarm != null && insect instanceof Hornet) {
            swarm.removeHornet((Hornet)insect);
            insect.setPosition(null);
            return true;
        }
        return false;
    }
    public void setOnFire(){
        this.isOnFire = true;
    }

    public boolean isOnFire() {
        return this.isOnFire;
    }
}
