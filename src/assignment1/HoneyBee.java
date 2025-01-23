package assignment1;
abstract class HoneyBee extends Insect{
    private int cost;
    public static double HIVE_DMG_REDUCTION;

    public HoneyBee(Tile position, int health, int cost) {
        super(position, health);
        this.cost = cost;
    }


    public int getCost() {
        return cost;
    }
    public void takeDamage(int damage) {
        if (this.getPosition().isHive()) {
            double damageDouble = damage;
            damageDouble -= HIVE_DMG_REDUCTION;
            damage = (int) damageDouble;
        }
        super.takeDamage(damage);
    }
}
