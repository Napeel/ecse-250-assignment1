package assignment1;
abstract class Insect {
    Tile position;
    int health;

    public Insect(Tile position, int health) {
        if (position == null){
            throw new IllegalArgumentException("null Tile");
        }
        this.position = position;
        this.health = health;
        if ((this instanceof HoneyBee) && (position.getBee() != null)){
            throw new IllegalArgumentException("There is already a bee on this tile!");}
        this.position.addInsect(this);
    }

    public final Tile getPosition() {
        return position;
    }

    public final int getHealth() {
        return health;
    }

    public void setPosition(Tile position) {
        this.position = position;
    }

    public void takeDamage(int damage){
        this.health -= damage;
        if (this.health <= 0){
            this.position.removeInsect(this);
            this.position = null;
        }
    }
    abstract boolean takeAction();

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() == obj.getClass()){
            Insect insect = (Insect) obj;
            return (this.getHealth() == insect.getHealth())
                    && (this.getPosition() == insect.getPosition());
        }
        return false;}
    public void regenerateHealth(double healthRegen){
        double healthDouble = this.getHealth();
        double newHealth = healthDouble + (healthRegen*healthDouble);
        this.health = (int) newHealth;}
}
