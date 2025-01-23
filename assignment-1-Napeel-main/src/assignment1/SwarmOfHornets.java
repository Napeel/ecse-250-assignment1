package assignment1;
public class SwarmOfHornets {
    private Hornet[] hornets;
    private int numOfHornets;
    public static double QUEEN_BOOST;

    public SwarmOfHornets() {
        this.hornets = new Hornet[0];
    }

    public int sizeOfSwarm() {
        return numOfHornets;
    }

    public Hornet[] getHornets() {
        if (hornets == null) {
            return new Hornet[0];
        }
        int count = 0;
        for (Hornet hornet : hornets) {
            if (hornet != null) {
                count++;
            }}
        Hornet[] hornetsNoNull = new Hornet[count];
        int index = 0;
        for (Hornet hornet : hornets) {
            if (hornet != null) {
                hornetsNoNull[index++] = hornet;
            }}
        return hornetsNoNull;
    }


    public Hornet getFirstHornet() {
        if (this.hornets.length == 0) {
            return null;
        } else {
            return this.hornets[0];
        }
    }
    public void addHornet(Hornet hornet) {
        Hornet[] newHornets = new Hornet[this.hornets.length + 1];
        int i = 0;
        while (i < this.hornets.length) {
            newHornets[i] = this.hornets[i];
            i++;}
        newHornets[i] = hornet;
        this.hornets = newHornets;
        numOfHornets = newHornets.length;
        if (hornet.isTheQueen()) {
            for (Hornet h : this.hornets) {
                if (h != hornet) {
                    h.regenerateHealth(QUEEN_BOOST);
                }}}
    }


    public boolean removeHornet(Hornet hornet) {
        int i = 0;
        while (i < this.hornets.length) {
            if (this.hornets[i] == hornet) {
                int j = i;
                while (j < this.hornets.length - 1) {
                    this.hornets[j] = this.hornets[j + 1];
                    j++;
                }
                this.hornets[this.hornets.length - 1] = null;
                return true;
            }
            i++;
        }
        return false;
    }


}
