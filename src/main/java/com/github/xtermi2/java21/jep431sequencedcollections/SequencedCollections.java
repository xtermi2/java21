package com.github.xtermi2.java21.jep431sequencedcollections;

import java.util.*;

public class SequencedCollections {
    public static void main(String[] args) {
        SequencedCollection<String> list = List.of("1st", "2nd", "3rd");
        list.reversed();
        list.getFirst();
        list.getLast();

        final SequencedMap<String, String> map = new LinkedHashMap<>(Map.of("k", "v"));
        map.reversed();
        map.firstEntry();
        map.lastEntry();

        final SequencedSet set = new LinkedHashSet(Set.of("1st", "2nd", "3rd"));
        set.reversed();
        set.getFirst();
        set.getLast();
    }
}
