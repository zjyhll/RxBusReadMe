package com.example.administrator.rxbusreadme;

import com.hwangjr.rxbus.Bus;

/**
 * Maintains a singleton instance for obtaining the bus. Ideally this would be replaced with a more efficient means
 * such as through injection directly into interested classes.
 */
public class BusProvider {
    /**
     * Check out the bus, like identifier or thread enforcer etc.
     */
    private static final Bus BUS = new Bus();

    private BusProvider() {
    }

    public static Bus getInstance() {
        return BUS;
    }
}
