package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    static Solution solution;

    int[][] matches;
    List<Integer> aux, aux2;
    List<List<Integer>> result;

    @BeforeAll
    static void setup(){

        solution = new Solution();
    }

    @Test
    public void NoPlayerHasLostOnlyOneMatch(){

        aux = new ArrayList<>();
        aux2 = new ArrayList<>();
        result = new ArrayList<>();

        aux.add(1);
        aux.add(2);
        aux.add(5);
        aux.add(6);

        result.add(aux);
        result.add(aux2);

        matches = new int[][] {{2,3},{1,3},{5,4},{6,4}};

        assertEquals(result.toString(), solution.findWinners(matches).toString());

    }

    @Test
    public void AllPlayersHaveLostAtLeastOneMatch(){

        aux = new ArrayList<>();
        aux2 = new ArrayList<>();
        result = new ArrayList<>();

        aux2.add(1);
        aux2.add(2);
        aux2.add(5);
        aux2.add(6);

        result.add(aux);
        result.add(aux2);

        matches = new int[][] {{2,3},{1,3},{5,2},{6,5}, {3,6}, {3,1}};

        assertEquals(result.toString(), solution.findWinners(matches).toString());

    }

    @Test
    public void SomePlayersDidntLoseMatchesAndSomePlayersLostOnlyOnceAndSOmePlayersLostMoreThanOnce(){

        aux = new ArrayList<>();
        aux2 = new ArrayList<>();
        result = new ArrayList<>();

        aux.add(1);
        aux.add(2);
        aux.add(10);

        aux2.add(4);
        aux2.add(5);
        aux2.add(7);
        aux2.add(8);

        result.add(aux);
        result.add(aux2);

        matches = new int[][] {{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}};

        assertEquals(result.toString(), solution.findWinners(matches).toString());

    }
}
