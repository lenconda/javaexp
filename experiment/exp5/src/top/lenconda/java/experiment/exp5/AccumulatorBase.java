package top.lenconda.java.experiment.exp5;

public abstract class AccumulatorBase {

    public static int maximum = 0;
    public static int x = 0;

    public abstract double calculate ();

    public boolean validate () {
        if (this.maximum <= 0)
            return false;
        return true;
    }

}
