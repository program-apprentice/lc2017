package com.programapprentice.app.google.medium;

import org.junit.Test;

public class QueueReconstructionByHeight_406_T {
    QueueReconstructionByHeight_406 solution = new QueueReconstructionByHeight_406();

    @Test
    public void test1() {
        int[][] input = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        int[][] result = solution.reconstructQueue(input);
    }
}
