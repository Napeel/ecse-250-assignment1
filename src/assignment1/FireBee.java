package assignment1;
public class FireBee extends HoneyBee{
    public static int BASE_HEALTH;
    public static int BASE_COST;
    private int maxRange;
    public FireBee(Tile position, int maxRange) {
        super(position, BASE_HEALTH, BASE_COST);
        this.maxRange = maxRange;
    }
    public boolean takeAction() {
        if (this.getPosition().isOnThePath()) {
            Tile currentTile = this.getPosition().towardTheNest();
            int i = 1;
            while (i <= maxRange && currentTile != null) {
                if (currentTile.getHornets().length > 0 && !currentTile.isOnFire()) {
                    currentTile.setOnFire();
                    return true;
                }
                currentTile = currentTile.towardTheNest();
                i++;
            }
        }
        return false;
    }
}

