package mine;

import javax.xml.namespace.QName;
import java.rmi.Naming;

public class WoodenCoin extends Valuable {
    private final String NAME = "WoodenCoin";
    private final int VALUE = 1;

    WoodenCoin() {
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
