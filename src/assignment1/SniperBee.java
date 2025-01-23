package assignment1;
public class SniperBee extends HoneyBee{
    private int attackDamage;
    private int piercingPower;
    public static int BASE_HEALTH;
    public static int BASE_COST;
    public SniperBee(Tile position, int attackDamage, int piercingPower) {
        super(position, BASE_HEALTH, BASE_COST);
        this.attackDamage = attackDamage;
        this.piercingPower = piercingPower;
    }
    public boolean takeAction() {
        if (!this.getPosition().isOnThePath() || this.getPosition().isNest()) {
            return false;
        } else {
            int alternate = 1;
            Tile hornetCheck = this.getPosition();
            while (!hornetCheck.isNest()) {
                if ((hornetCheck.getSwarmofHornets() != null) && ((alternate % 2) != 0)) {
                    int shotsTaken = 0;
                    Hornet[] hornets = hornetCheck.getSwarmofHornets().getHornets();
                    for (Hornet hornet : hornets) {
                        if (hornet == null || shotsTaken >= piercingPower) {
                            break;
                        }
                        hornet.takeDamage(attackDamage);
                        shotsTaken++;
                    }
                }
                alternate++;
                hornetCheck = hornetCheck.towardTheNest();
            }
            return true;
        }
    }


}
