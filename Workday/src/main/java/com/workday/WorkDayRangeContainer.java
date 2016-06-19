package com.workday;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * rbandaru, 06/17/2016.
 */
public final class WorkDayRangeContainer implements RangeContainer {

    private final NavigableMap<Long, Short> rangeContainerIndex;

    public WorkDayRangeContainer(long[] data) {
        // fail-safe and uses for synchronized (because 2 threads on same ConcurrentSkipListMap object cannot access it
        // at same time)
        rangeContainerIndex = new ConcurrentSkipListMap<Long, Short>();
        for (short i = 0; i < data.length; i++) {
            rangeContainerIndex.put(data[i], i);
        }
    }

    @Override
    public Ids findIdsInRange(long fromValue, long toValue, boolean fromInclusive, boolean toInclusive) {
        NavigableMap<Long, Short> idsInRange = rangeContainerIndex.subMap(fromValue, fromInclusive, toValue, toInclusive);
        List<Short> idList = new ArrayList<Short>(idsInRange.values());
        Collections.sort(idList);
        return new WorkDayIds(Collections.enumeration(idList));
    }
}
