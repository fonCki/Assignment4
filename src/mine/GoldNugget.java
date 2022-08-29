package mine;

public class GoldNugget extends Valuable {
    private final String NAME = "GoldNugget";
    private final int VALUE = 7;

    GoldNugget() {}

    @Override
    public String getValuableType() {
        return NAME;
    }

    @Override
    public double getValue() {
        return VALUE;
    }
}
