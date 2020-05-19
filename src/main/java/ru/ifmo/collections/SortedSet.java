package ru.ifmo.collections;

import java.util.*;

/**
 * Represents sorted set of unique values.
 * create() returns a SortedSet instance with natural ordering. (i.e. from smallest to largest in case of integer numbers)
 * from() is used to create a SortedSet instance with given Comparator.
 * Instances of a class can be created using only these two methods above.
 * <p>
 * This class should not be abstract and should be capable of adding/removing single/multiple elements.
 * It has two more methods: getSorted() and getReversed() which return an array of set contents in forward and reverse order respectively.
 * <p>
 * NB! This class must have only map(s) as an internal data structure(s).
 *
 * @param <T> set contents type
 */
public class SortedSet<T> extends AbstractSet<T> {
    private final Map<T, Boolean> contents;

    public SortedSet(TreeMap<T, Boolean> contents) {
        this.contents = contents;
    }

    public static <T> SortedSet<T> create() {
        return new SortedSet<T>(new TreeMap<>());
    }

    public static <T> SortedSet<T> from(Comparator<T> comparator) {
        return new SortedSet<>(new TreeMap<>(comparator));
    }

    public List<T> getSorted() {
        return new ArrayList<>(contents.keySet());
    }

    public List<T> getReversed() {
        List<T> reversed = getSorted();
        Collections.reverse(reversed);
        return reversed;
    }

    public boolean add(T t) {
        return contents.put(t, true) == null;
    }

    public boolean addAll(Collection<? extends T> ts) {
        boolean flag = true;
        for (T t : ts) {
            flag &= add(t);
        }
        return flag;
    }

    public boolean remove(Object t) {
        return contents.remove(t) == null;
    }

    public boolean removeAll(Collection<?> ts) {
        boolean flag = true;
        for (Object t : ts) {
            flag &= remove(t);
        }
        return flag;
    }

    @Override
    public Iterator<T> iterator() {
        return contents.keySet().iterator();
    }

    @Override
    public int size() {
        return contents.size();
    }
}
