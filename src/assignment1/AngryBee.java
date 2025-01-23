package assignment1;
public class AngryBee extends HoneyBee{
    private int attackDamage;
    public static int BASE_HEALTH;
    public static int BASE_COST;
    public AngryBee(Tile position, int attackDamage) {
        super(position, BASE_HEALTH, BASE_COST);
        this.attackDamage = attackDamage;
    }

    public boolean takeAction(){
        if (this.getPosition().isOnThePath()){
            // checking if there is a hornet on the tile and the tile is not the nest
            if ((this.getPosition().getHornets().length != 0) && (!this.getPosition().isNest())){
                this.getPosition().getHornet().takeDamage(this.attackDamage);
                return true;
            } else if ((this.getPosition().towardTheNest().getHornets().length != 0) &&
                    (!this.getPosition().towardTheNest().isNest())){
                this.getPosition().towardTheNest().getHornet().takeDamage(this.attackDamage);
                return true;
            }
        }
        return false;
    }
}
