public class Vehicle {
    private static double load;
    private final double maxLoad = 10000;

    // public Vehicle(double max) {
    // this.maxLoad = max;
    // }

    public double getLoad() {
        return load;
    }

    public double getMaxLoad() {
        return maxLoad;
    }

    public boolean addBox(double weight) {
        double temp = 0.0d;
        temp = load + weight;
        if (temp <= maxLoad) {
            load = load + weight;
            return true;
        } else {
            return false;
        }
    }
}
