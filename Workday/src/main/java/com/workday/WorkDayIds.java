package com.workday;

import java.util.Enumeration;

/**
 * rbandaru - Enumeration returned by the RangeContainer with the sorted list of Ids.
 */
public final class WorkDayIds implements Ids {

    private final Enumeration<Short> idEnumerations;

    public WorkDayIds(Enumeration<Short> enumeration) {
        this.idEnumerations = enumeration;
    }

    @Override
    public short nextId() {
        if (idEnumerations.hasMoreElements()) {
            return idEnumerations.nextElement();
        } else {
            return END_OF_IDS;
        }
    }
}
