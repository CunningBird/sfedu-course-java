package com.cunningbird;

import java.util.*;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Letters implements Collection<Character> {

    transient Character[] elementData;

    private int size;

    public Letters() {
        this.size = 0;
        this.elementData = new Character[]{};
    }

    public Letters(String string) {
        this.size = string.length();
        this.elementData = string.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public boolean contains(Object o) {
        Object[] es = elementData;
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (es[i] == null) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(es[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean add(Character character) {
        if (size >= elementData.length) {
            elementData = Arrays.copyOf(elementData, size + 10);
        }

        elementData[size++] = character;

        return true;
    }

    public boolean add(Letters letters) {
        size += letters.size();

        elementData = Stream.concat(Arrays.stream(elementData), Arrays.stream(letters.toArray()))
                .toArray(Character[]::new);

        return true;
    }

    @Override
    public boolean remove(Object o) {
        //if (o == null || getClass() != o.getClass()) return false;
        //Letters letters = (Letters) o;

        //return true;
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Character> c) {
        size += c.size();

        elementData = Stream.concat(Arrays.stream(elementData), Arrays.stream(c.toArray()))
                .toArray(Character[]::new);

        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeIf(Predicate<? super Character> filter) {
        return Collection.super.removeIf(filter);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return batchRemove(c, true, 0, size);
    }

    private boolean batchRemove(Collection<?> c, boolean complement, final int from, final int end) {
        Objects.requireNonNull(c);
        Collection<Character> collection = (Collection<Character>) c;
        final Object[] es = elementData;
        int r;
        // Optimize for initial run of survivors
        for (r = from;; r++) {
            if (r == end)
                return false;
            if (c.contains(es[r]) != complement)
                break;
        }
        int w = r++;
        try {
            for (Object e; r < end; r++)
                if (c.contains(e = es[r]) == complement)
                    es[w++] = e;
        } catch (Throwable ex) {
            // Preserve behavioral compatibility with AbstractCollection,
            // even if c.contains() throws.
            System.arraycopy(es, r, es, w, end - r);
            w += end - r;
            throw ex;
        } finally {
            shiftTailOverGap(es, w, end);
        }
        return true;
    }

    private void shiftTailOverGap(Object[] es, int lo, int hi) {
        System.arraycopy(es, hi, es, lo, size - hi);
        for (int to = size, i = (size -= hi - lo); i < to; i++)
            es[i] = null;
    }

    @Override
    public Character[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(elementData);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Character character : elementData) {
            sb.append(character);
        }

        return sb.toString();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public <T> T[] toArray(IntFunction<T[]> generator) {
        return Collection.super.toArray(generator);
    }

    @Override
    public Stream<Character> stream() {
        return Collection.super.stream();
    }

    @Override
    public Stream<Character> parallelStream() {
        return Collection.super.parallelStream();
    }

    @Override
    public void clear() {
        final Character[] es = elementData;
        for (int to = size, i = size = 0; i < to; i++) {
            es[i] = null;
        }
    }

    @Override
    public Spliterator<Character> spliterator() {
        return Collection.super.spliterator();
    }

    @Override
    public Iterator<Character> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<Character> {

        int cursor;       // index of next element to return
        int lastRet = -1; // index of last element returned; -1 if no such

        Itr() {}

        public boolean hasNext() {
            return cursor != size;
        }

        public Character next() {
            int i = cursor;
            if (i >= size)
                throw new NoSuchElementException();
            Object[] elementData = Letters.this.elementData;
            if (i >= elementData.length)
                throw new ConcurrentModificationException();
            cursor = i + 1;
            return (Character) elementData[lastRet = i];
        }

        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();

            try {
                Letters.this.remove(lastRet);
                cursor = lastRet;
                lastRet = -1;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }
    }
}
