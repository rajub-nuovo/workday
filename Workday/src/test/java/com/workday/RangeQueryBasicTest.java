package com.workday;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * @author rbandaru
 */
public class RangeQueryBasicTest {
    private RangeContainer rangeContainer;

    @Before
    public void setUp() {
        RangeContainerFactory rangeContainerFactory = new WorkDayRangeContainerFactory();
        rangeContainer = rangeContainerFactory.createContainer(new long[] { 10, 12, 17, 21, 2, 15, 16 });
    }

    @Test
    public void runARangeQuery() {
        Ids ids = rangeContainer.findIdsInRange(14, 17, true, true);
        assertEquals(2, ids.nextId());
        assertEquals(5, ids.nextId());
        assertEquals(6, ids.nextId());
        assertEquals(Ids.END_OF_IDS, ids.nextId());
        ids = rangeContainer.findIdsInRange(14, 17, true, false);
        assertEquals(5, ids.nextId());
        assertEquals(6, ids.nextId());
        assertEquals(Ids.END_OF_IDS, ids.nextId());
        ids = rangeContainer.findIdsInRange(20, Long.MAX_VALUE, false, true);
        assertEquals(3, ids.nextId());
        assertEquals(Ids.END_OF_IDS, ids.nextId());
    }
}
