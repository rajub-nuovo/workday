package com.workday;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * rbandaru, 06/17/2016.
 */
public class WorkDayRangeContainer implements RangeContainer {

    private TreeMap<Long, Short> rangeContainerIndex = null;

    public WorkDayRangeContainer(long[] data) {
        rangeContainerIndex = new TreeMap<Long, Short>();
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
