package mine;

public class Ruby extends Valuable {
    private final String NAME = "Ruby";
    private final int VALUE = 2;

    Ruby() {}

    @Override
    public String getValuableType() {
        return NAME;
    }

    @Override
    public double getValue() {
        return VALUE;
    }
}
