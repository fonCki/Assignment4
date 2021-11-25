package mine;

import java.util.Random;

public abstract class Valuable {

    enum Valuables {
        Diamond,
        GoldNugget,
        Jewel,
        Ruby,
        WoodenCoin,
    }

    public abstract String getValuableType();
    public abstract double getValue();

    protected static Valuable getValuable() {
        switch (randomValue()) {
            case Diamond:  return (new Diamond());
            case GoldNugget:  return (new GoldNugget());
            case Jewel:  return (new Jewel());
            case Ruby: return (new Ruby());
            case WoodenCoin: return (new WoodenCoin());
        }
        return null;
    }

    private static Valuables randomValue() {
        Valuables[] values = Valuables.values();
        return values[new Random().nextInt(values.length)];
    }

    @Override
    public String toString() {
        return this.getValuableType() + ": " + this.getValue() + " $";
    }

}
