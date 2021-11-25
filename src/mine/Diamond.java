package mine;

public class Diamond extends Valuable {
    private final String NAME = "Diamond";
    private final int VALUE = 10;

    Diamond(){
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
