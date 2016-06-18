package com.workday;

/**
 * @author rbandaru on 06/17/2016.
 */
public final class WorkDayRangeContainerFactory implements RangeContainerFactory {

    @Override
    public RangeContainer createContainer(long[] data) {
        return new WorkDayRangeContainer(data);
    }
}
