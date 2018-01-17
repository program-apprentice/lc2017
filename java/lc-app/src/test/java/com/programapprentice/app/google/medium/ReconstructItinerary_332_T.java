package com.programapprentice.app.google.medium;

import com.programapprentice.app.util.TestUtil;
import org.junit.Test;

import java.util.List;

public class ReconstructItinerary_332_T {
    ReconstructItinerary_332 solution = new ReconstructItinerary_332();

    @Test
    public void test1() {
        String[][] tickets = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
        List<String> result = solution.findItinerary(tickets);
        TestUtil.printStringArrayList(result);

//        Expected: JFK   ATL   JFK   SFO   ATL   SFO
    }

    @Test
    public void test2() {
        String[][] tickets = {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
        List<String> result = solution.findItinerary(tickets);
        TestUtil.printStringArrayList(result);
        // Expected: ["JFK","NRT","JFK","KUL"]
    }

}
