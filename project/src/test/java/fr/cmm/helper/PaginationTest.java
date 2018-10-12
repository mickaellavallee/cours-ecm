package fr.cmm.helper;

import org.junit.Test;

import static org.junit.Assert.*;

public class PaginationTest {
    private int pageSize;
    private Pagination pagination = new Pagination();
    private long count;

    @Test
    public void getPageCount() {
        pagination.setCount(20);
        pagination.setPageSize(50);
        assertEquals(1, pagination.getPageCount());
        pagination.setCount(20);
        pagination.setPageSize(50);
        assertEquals(1, pagination.getPageCount());
        pagination.setCount(0);
        pagination.setPageSize(50);
        assertEquals(0, pagination.getPageCount());

    }
}