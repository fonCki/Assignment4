package mine;

public class Jewel extends Valuable {
    private final String NAME = "Jewel";
    private final int VALUE = 5;

    Jewel(){

    }

    @Override
    public String getValuableType() {
        return NAME;
    }

    @Override
    public double getValue() {
        return VALUE;
    }
}
