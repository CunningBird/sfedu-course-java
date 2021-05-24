package com.cunningbird;

import java.util.*;
import java.util.function.Consumer;
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
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean add(Character character) {
        if (size >= elementData.length) {
            elementData = Arrays.copyOf(elementData, size + 10);
        }

        elementData[size++] = character;

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends Character> c) {
        Object[] a = c.toArray();
        int numNew = a.length;
        if (numNew == 0)
            return false;
        Object[] elementData;
        final int s;
        if (numNew > (elementData = this.elementData).length - (s = size))
            elementData = grow(s + numNew);
        System.arraycopy(a, 0, elementData, s, numNew);
        size = s + numNew;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; ++i) {
            if (o.equals(elementData[i])) {
                fastRemove(i);
                return true;
            }
        }
        return false;
    }

    private void fastRemove(int i) {
        int length = size - i - 1;
        if (length > 0) {
            System.arraycopy(elementData, i + 1, elementData, i, length);
        }
        elementData[--size] = null;
    }

    boolean batchRemove(Collection<?> c, boolean complement, final int from, final int end) {
        Objects.requireNonNull(c);
        final Object[] es = elementData;
        int r;
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
    public boolean removeAll(Collection<?> c) {
        return batchRemove(c, false, 0, size);
    }

    @Override
    public boolean removeIf(Predicate<? super Character> filter) {
        return Collection.super.removeIf(filter);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return batchRemove(c, true, 0, size);
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
    public Spliterator<Character> spliterator() {
        return Collection.super.spliterator();
    }

    @Override
    public Iterator<Character> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<Character> {

        int cursor;
        int lastRet = -1;

        Itr() {
        }

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public Character next() {
            if (size == 0)
                return null;
            int i = cursor;
            if (i >= size)
                throw new NoSuchElementException();
            Object[] elementData = Letters.this.elementData;
            if (i >= elementData.length)
                throw new ConcurrentModificationException();
            cursor = i + 1;
            return (Character) elementData[lastRet = i];
        }

        @Override
        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();

            try {
                Letters.this.fastRemove(lastRet);
                cursor = lastRet;
                lastRet = -1;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }
    }

    private Object[] grow(int minCapacity) {
        return elementData = Arrays.copyOf(elementData, minCapacity + 10);
    }

    @Override
    public void clear() {
        final Character[] es = elementData;
        for (int to = size, i = size = 0; i < to; i++) {
            es[i] = null;
        }
    }

    @Override
    public Character[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size)
            // Make a new array of a's runtime type, but my contents:
            return (T[]) Arrays.copyOf(elementData, size, a.getClass());
        System.arraycopy(elementData, 0, a, 0, size);
        if (a.length > size)
            a[size] = null;
        return a;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Character c : this) {
            result.append(c);
        }
        return result.toString();
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(elementData);
        return result;
    }
}
