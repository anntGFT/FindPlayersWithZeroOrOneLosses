package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public Solution(){

    }

    public List<List<Integer>> findWinners(int[][] matches){

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> players = Arrays.stream(matches)
                .flatMap(x -> Arrays.stream(x).boxed())
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        Map<Integer, Long> losers = Arrays.stream(matches)
                .map(x -> x[1]).
                collect(Collectors.groupingBy(x -> x, Collectors.counting()));

        List<Integer> lostOnce = losers.entrySet().stream()
                .filter(x -> x.getValue() == 1)
                .map(Map.Entry::getKey)
                .sorted()
                .collect(Collectors.toList());

        List<Integer> didntLost = players.stream()
                .filter(x -> !losers.containsKey(x))
                .collect(Collectors.toList());

        result.add(didntLost);
        result.add(lostOnce);

        return result;
    }
}