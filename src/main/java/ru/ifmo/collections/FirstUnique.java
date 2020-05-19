package ru.ifmo.collections;

import java.util.*;

/**
 * Design a class which contains integers and returns first unique integer (in order of addition).
 * FirstUniqueTest can be used as an example.
 */
public class FirstUnique {
    private final HashMap<Integer, Boolean> uniqueness;
    private final Queue<Integer> order;

    public FirstUnique(int[] numbers) {
        if (numbers == null) {
            throw new NullPointerException();
        }
        uniqueness = new HashMap<>();
        order = new LinkedList<>();
        for (int e : numbers) {
            add(e);
        }
    }

    public int showFirstUnique() {
        while (!order.isEmpty() && !uniqueness.get(order.peek())) {
            order.poll();
        }
        return order.peek() == null ? -1 : order.peek();
    }

    public void add(int value) throws NullPointerException {
        uniqueness.put(value, !uniqueness.containsKey(value));
        order.add(value);
    }
}
