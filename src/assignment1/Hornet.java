package assignment1;
public class Hornet extends Insect{
    private int attackDamage;
    private int numofQueens;
    private boolean isQueen;
    public static int BASE_FIRE_DMG;

    public Hornet(Tile position, int health, int attackDamage) {
        super(position, health);
        this.attackDamage = attackDamage;
        this.isQueen = false;
        this.numofQueens = 0;
    }
    public boolean takeAction() {
        if (this.isQueen) {
            if (this.getPosition() == null){
                return false;
            }
            int queenActions = 0;
            while (queenActions <= 2) {
                if (queenActions == 2){
                    return true;
                }
                if (this.getPosition().isOnFire()) {
                    this.takeDamage(BASE_FIRE_DMG);
                }
                if (this.getPosition().getBee() != null) {
                    this.getPosition().getBee().takeDamage(this.attackDamage);
                    queenActions++;
                }
                else { this.setPosition(this.getPosition().towardTheHive());
                    queenActions++;

                }
            }
        } else {
            if (this.getPosition() == null){
                return false;}
            if (this.getPosition() != null) {
            if (this.getPosition().isOnFire()) {
                this.takeDamage(BASE_FIRE_DMG);
            }
            if (this.getPosition().getBee() != null) {
                this.getPosition().getBee().takeDamage(this.attackDamage);
                return true;
            }
            else if (this.getPosition().isHive()) {
                return false;
            } else {
                this.setPosition(this.getPosition().towardTheHive());
                return true;
            }
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Hornet)) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }
        Hornet comparison = (Hornet) obj;
        return this.attackDamage == comparison.attackDamage;
    }

    public boolean isTheQueen() {
        return isQueen;
    }
    public void promote(){
        if (numofQueens == 0){
            this.isQueen = true;
        }
    }
}

