package io.rong.imageloader.core.assist.deque;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes5.dex */
public class LinkedBlockingDeque<E> extends AbstractQueue<E> implements BlockingDeque<E>, Serializable {
    private static final long serialVersionUID = -387911632671998426L;
    private final int capacity;
    private transient int count;
    transient Node<E> first;
    transient Node<E> last;
    final ReentrantLock lock;
    private final Condition notEmpty;
    private final Condition notFull;

    private abstract class AbstractItr implements Iterator<E> {
        private Node<E> lastRet;
        Node<E> next;
        E nextItem;

        AbstractItr() {
            ReentrantLock reentrantLock = LinkedBlockingDeque.this.lock;
            reentrantLock.lock();
            try {
                this.next = firstNode();
                this.nextItem = this.next == null ? null : this.next.item;
            } finally {
                reentrantLock.unlock();
            }
        }

        private Node<E> succ(Node<E> node) {
            while (true) {
                Node<E> nodeNextNode = nextNode(node);
                if (nodeNextNode == null) {
                    return null;
                }
                if (nodeNextNode.item != null) {
                    return nodeNextNode;
                }
                if (nodeNextNode == node) {
                    return firstNode();
                }
                node = nodeNextNode;
            }
        }

        void advance() {
            ReentrantLock reentrantLock = LinkedBlockingDeque.this.lock;
            reentrantLock.lock();
            try {
                this.next = succ(this.next);
                this.nextItem = this.next == null ? null : this.next.item;
            } finally {
                reentrantLock.unlock();
            }
        }

        abstract Node<E> firstNode();

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.next != null;
        }

        @Override // java.util.Iterator
        public E next() {
            Node<E> node = this.next;
            if (node == null) {
                throw new NoSuchElementException();
            }
            this.lastRet = node;
            E e2 = this.nextItem;
            advance();
            return e2;
        }

        abstract Node<E> nextNode(Node<E> node);

        @Override // java.util.Iterator
        public void remove() {
            Node<E> node = this.lastRet;
            if (node == null) {
                throw new IllegalStateException();
            }
            this.lastRet = null;
            ReentrantLock reentrantLock = LinkedBlockingDeque.this.lock;
            reentrantLock.lock();
            try {
                if (node.item != null) {
                    LinkedBlockingDeque.this.unlink(node);
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    private class DescendingItr extends LinkedBlockingDeque<E>.AbstractItr {
        private DescendingItr() {
            super();
        }

        @Override // io.rong.imageloader.core.assist.deque.LinkedBlockingDeque.AbstractItr
        Node<E> firstNode() {
            return LinkedBlockingDeque.this.last;
        }

        @Override // io.rong.imageloader.core.assist.deque.LinkedBlockingDeque.AbstractItr
        Node<E> nextNode(Node<E> node) {
            return node.prev;
        }
    }

    private class Itr extends LinkedBlockingDeque<E>.AbstractItr {
        private Itr() {
            super();
        }

        @Override // io.rong.imageloader.core.assist.deque.LinkedBlockingDeque.AbstractItr
        Node<E> firstNode() {
            return LinkedBlockingDeque.this.first;
        }

        @Override // io.rong.imageloader.core.assist.deque.LinkedBlockingDeque.AbstractItr
        Node<E> nextNode(Node<E> node) {
            return node.next;
        }
    }

    static final class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(E e2) {
            this.item = e2;
        }
    }

    public LinkedBlockingDeque() {
        this(Integer.MAX_VALUE);
    }

    private boolean linkFirst(Node<E> node) {
        if (this.count >= this.capacity) {
            return false;
        }
        Node<E> node2 = this.first;
        node.next = node2;
        this.first = node;
        if (this.last == null) {
            this.last = node;
        } else {
            node2.prev = node;
        }
        this.count++;
        this.notEmpty.signal();
        return true;
    }

    private boolean linkLast(Node<E> node) {
        if (this.count >= this.capacity) {
            return false;
        }
        Node<E> node2 = this.last;
        node.prev = node2;
        this.last = node;
        if (this.first == null) {
            this.first = node;
        } else {
            node2.next = node;
        }
        this.count++;
        this.notEmpty.signal();
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.count = 0;
        this.first = null;
        this.last = null;
        while (true) {
            Object object = objectInputStream.readObject();
            if (object == null) {
                return;
            } else {
                add(object);
            }
        }
    }

    private E unlinkFirst() {
        Node<E> node = this.first;
        if (node == null) {
            return null;
        }
        Node<E> node2 = node.next;
        E e2 = node.item;
        node.item = null;
        node.next = node;
        this.first = node2;
        if (node2 == null) {
            this.last = null;
        } else {
            node2.prev = null;
        }
        this.count--;
        this.notFull.signal();
        return e2;
    }

    private E unlinkLast() {
        Node<E> node = this.last;
        if (node == null) {
            return null;
        }
        Node<E> node2 = node.prev;
        E e2 = node.item;
        node.item = null;
        node.prev = node;
        this.last = node2;
        if (node2 == null) {
            this.first = null;
        } else {
            node2.next = null;
        }
        this.count--;
        this.notFull.signal();
        return e2;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            objectOutputStream.defaultWriteObject();
            for (Node<E> node = this.first; node != null; node = node.next) {
                objectOutputStream.writeObject(node.item);
            }
            objectOutputStream.writeObject(null);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue, io.rong.imageloader.core.assist.deque.BlockingDeque, java.util.concurrent.BlockingQueue, io.rong.imageloader.core.assist.deque.Deque
    public boolean add(E e2) {
        addLast(e2);
        return true;
    }

    @Override // io.rong.imageloader.core.assist.deque.BlockingDeque, io.rong.imageloader.core.assist.deque.Deque
    public void addFirst(E e2) {
        if (!offerFirst(e2)) {
            throw new IllegalStateException("Deque full");
        }
    }

    @Override // io.rong.imageloader.core.assist.deque.BlockingDeque, io.rong.imageloader.core.assist.deque.Deque
    public void addLast(E e2) {
        if (!offerLast(e2)) {
            throw new IllegalStateException("Deque full");
        }
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Node<E> node = this.first;
            while (node != null) {
                node.item = null;
                Node<E> node2 = node.next;
                node.prev = null;
                node.next = null;
                node = node2;
            }
            this.last = null;
            this.first = null;
            this.count = 0;
            this.notFull.signalAll();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, io.rong.imageloader.core.assist.deque.BlockingDeque, java.util.concurrent.BlockingQueue, io.rong.imageloader.core.assist.deque.Deque
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (Node<E> node = this.first; node != null; node = node.next) {
                if (obj.equals(node.item)) {
                    return true;
                }
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // io.rong.imageloader.core.assist.deque.Deque
    public Iterator<E> descendingIterator() {
        return new DescendingItr();
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection) {
        return drainTo(collection, Integer.MAX_VALUE);
    }

    @Override // java.util.AbstractQueue, java.util.Queue, io.rong.imageloader.core.assist.deque.BlockingDeque, io.rong.imageloader.core.assist.deque.Deque
    public E element() {
        return getFirst();
    }

    @Override // io.rong.imageloader.core.assist.deque.Deque
    public E getFirst() {
        E ePeekFirst = peekFirst();
        if (ePeekFirst != null) {
            return ePeekFirst;
        }
        throw new NoSuchElementException();
    }

    @Override // io.rong.imageloader.core.assist.deque.Deque
    public E getLast() {
        E ePeekLast = peekLast();
        if (ePeekLast != null) {
            return ePeekLast;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, io.rong.imageloader.core.assist.deque.BlockingDeque, io.rong.imageloader.core.assist.deque.Deque
    public Iterator<E> iterator() {
        return new Itr();
    }

    public boolean offer(E e2) {
        return offerLast(e2);
    }

    @Override // io.rong.imageloader.core.assist.deque.BlockingDeque, io.rong.imageloader.core.assist.deque.Deque
    public boolean offerFirst(E e2) {
        if (e2 == null) {
            throw new NullPointerException();
        }
        Node<E> node = new Node<>(e2);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return linkFirst(node);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // io.rong.imageloader.core.assist.deque.BlockingDeque, io.rong.imageloader.core.assist.deque.Deque
    public boolean offerLast(E e2) {
        if (e2 == null) {
            throw new NullPointerException();
        }
        Node<E> node = new Node<>(e2);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return linkLast(node);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.Queue, io.rong.imageloader.core.assist.deque.BlockingDeque, io.rong.imageloader.core.assist.deque.Deque
    public E peek() {
        return peekFirst();
    }

    @Override // io.rong.imageloader.core.assist.deque.Deque
    public E peekFirst() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.first == null ? null : this.first.item;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // io.rong.imageloader.core.assist.deque.Deque
    public E peekLast() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.last == null ? null : this.last.item;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.Queue, io.rong.imageloader.core.assist.deque.BlockingDeque, io.rong.imageloader.core.assist.deque.Deque
    public E poll() {
        return pollFirst();
    }

    @Override // io.rong.imageloader.core.assist.deque.Deque
    public E pollFirst() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return unlinkFirst();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // io.rong.imageloader.core.assist.deque.Deque
    public E pollLast() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return unlinkLast();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // io.rong.imageloader.core.assist.deque.Deque
    public E pop() {
        return removeFirst();
    }

    @Override // io.rong.imageloader.core.assist.deque.BlockingDeque, io.rong.imageloader.core.assist.deque.Deque
    public void push(E e2) {
        addFirst(e2);
    }

    @Override // io.rong.imageloader.core.assist.deque.BlockingDeque, java.util.concurrent.BlockingQueue
    public void put(E e2) throws InterruptedException {
        putLast(e2);
    }

    @Override // io.rong.imageloader.core.assist.deque.BlockingDeque
    public void putFirst(E e2) throws InterruptedException {
        if (e2 == null) {
            throw new NullPointerException();
        }
        Node<E> node = new Node<>(e2);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (!linkFirst(node)) {
            try {
                this.notFull.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Override // io.rong.imageloader.core.assist.deque.BlockingDeque
    public void putLast(E e2) throws InterruptedException {
        if (e2 == null) {
            throw new NullPointerException();
        }
        Node<E> node = new Node<>(e2);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (!linkLast(node)) {
            try {
                this.notFull.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.capacity - this.count;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractQueue, java.util.Queue, io.rong.imageloader.core.assist.deque.BlockingDeque, io.rong.imageloader.core.assist.deque.Deque
    public E remove() {
        return removeFirst();
    }

    @Override // io.rong.imageloader.core.assist.deque.Deque
    public E removeFirst() {
        E ePollFirst = pollFirst();
        if (ePollFirst != null) {
            return ePollFirst;
        }
        throw new NoSuchElementException();
    }

    @Override // io.rong.imageloader.core.assist.deque.BlockingDeque, io.rong.imageloader.core.assist.deque.Deque
    public boolean removeFirstOccurrence(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (Node<E> node = this.first; node != null; node = node.next) {
                if (obj.equals(node.item)) {
                    unlink(node);
                    return true;
                }
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // io.rong.imageloader.core.assist.deque.Deque
    public E removeLast() {
        E ePollLast = pollLast();
        if (ePollLast != null) {
            return ePollLast;
        }
        throw new NoSuchElementException();
    }

    @Override // io.rong.imageloader.core.assist.deque.BlockingDeque, io.rong.imageloader.core.assist.deque.Deque
    public boolean removeLastOccurrence(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (Node<E> node = this.last; node != null; node = node.prev) {
                if (obj.equals(node.item)) {
                    unlink(node);
                    return true;
                }
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, io.rong.imageloader.core.assist.deque.BlockingDeque, io.rong.imageloader.core.assist.deque.Deque
    public int size() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.count;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // io.rong.imageloader.core.assist.deque.BlockingDeque, java.util.concurrent.BlockingQueue
    public E take() throws InterruptedException {
        return takeFirst();
    }

    @Override // io.rong.imageloader.core.assist.deque.BlockingDeque
    public E takeFirst() throws InterruptedException {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (true) {
            try {
                E eUnlinkFirst = unlinkFirst();
                if (eUnlinkFirst != null) {
                    return eUnlinkFirst;
                }
                this.notEmpty.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Override // io.rong.imageloader.core.assist.deque.BlockingDeque
    public E takeLast() throws InterruptedException {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (true) {
            try {
                E eUnlinkLast = unlinkLast();
                if (eUnlinkLast != null) {
                    return eUnlinkLast;
                }
                this.notEmpty.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Object[] objArr = new Object[this.count];
            int i = 0;
            Node<E> node = this.first;
            while (node != null) {
                int i2 = i + 1;
                objArr[i] = node.item;
                node = node.next;
                i = i2;
            }
            return objArr;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Node<E> node = this.first;
            if (node == null) {
                return "[]";
            }
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            while (true) {
                Object obj = node.item;
                if (obj == this) {
                    obj = "(this Collection)";
                }
                sb.append(obj);
                node = node.next;
                if (node == null) {
                    sb.append(']');
                    return sb.toString();
                }
                sb.append(',');
                sb.append(' ');
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    void unlink(Node<E> node) {
        Node<E> node2 = node.prev;
        Node<E> node3 = node.next;
        if (node2 == null) {
            unlinkFirst();
            return;
        }
        if (node3 == null) {
            unlinkLast();
            return;
        }
        node2.next = node3;
        node3.prev = node2;
        node.item = null;
        this.count--;
        this.notFull.signal();
    }

    public LinkedBlockingDeque(int i) {
        this.lock = new ReentrantLock();
        this.notEmpty = this.lock.newCondition();
        this.notFull = this.lock.newCondition();
        if (i <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = i;
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection, int i) {
        if (collection == null) {
            throw new NullPointerException();
        }
        if (collection == this) {
            throw new IllegalArgumentException();
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int iMin = Math.min(i, this.count);
            for (int i2 = 0; i2 < iMin; i2++) {
                collection.add(this.first.item);
                unlinkFirst();
            }
            return iMin;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // io.rong.imageloader.core.assist.deque.BlockingDeque, java.util.concurrent.BlockingQueue
    public boolean offer(E e2, long j, TimeUnit timeUnit) throws InterruptedException {
        return offerLast(e2, j, timeUnit);
    }

    @Override // io.rong.imageloader.core.assist.deque.BlockingDeque, java.util.concurrent.BlockingQueue
    public E poll(long j, TimeUnit timeUnit) throws InterruptedException {
        return pollFirst(j, timeUnit);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, io.rong.imageloader.core.assist.deque.BlockingDeque, java.util.concurrent.BlockingQueue, io.rong.imageloader.core.assist.deque.Deque
    public boolean remove(Object obj) {
        return removeFirstOccurrence(obj);
    }

    @Override // io.rong.imageloader.core.assist.deque.BlockingDeque
    public E pollFirst(long j, TimeUnit timeUnit) throws InterruptedException {
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                E eUnlinkFirst = unlinkFirst();
                if (eUnlinkFirst != null) {
                    return eUnlinkFirst;
                }
                if (nanos <= 0) {
                    return null;
                }
                nanos = this.notEmpty.awaitNanos(nanos);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Override // io.rong.imageloader.core.assist.deque.BlockingDeque
    public E pollLast(long j, TimeUnit timeUnit) throws InterruptedException {
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                E eUnlinkLast = unlinkLast();
                if (eUnlinkLast != null) {
                    return eUnlinkLast;
                }
                if (nanos <= 0) {
                    return null;
                }
                nanos = this.notEmpty.awaitNanos(nanos);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Override // io.rong.imageloader.core.assist.deque.BlockingDeque
    public boolean offerFirst(E e2, long j, TimeUnit timeUnit) throws InterruptedException {
        boolean z;
        if (e2 != null) {
            Node<E> node = new Node<>(e2);
            long nanos = timeUnit.toNanos(j);
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lockInterruptibly();
            while (true) {
                try {
                    if (linkFirst(node)) {
                        z = true;
                        break;
                    }
                    if (nanos <= 0) {
                        z = false;
                        break;
                    }
                    nanos = this.notFull.awaitNanos(nanos);
                } finally {
                    reentrantLock.unlock();
                }
            }
            return z;
        }
        throw new NullPointerException();
    }

    @Override // io.rong.imageloader.core.assist.deque.BlockingDeque
    public boolean offerLast(E e2, long j, TimeUnit timeUnit) throws InterruptedException {
        boolean z;
        if (e2 != null) {
            Node<E> node = new Node<>(e2);
            long nanos = timeUnit.toNanos(j);
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lockInterruptibly();
            while (true) {
                try {
                    if (linkLast(node)) {
                        z = true;
                        break;
                    }
                    if (nanos <= 0) {
                        z = false;
                        break;
                    }
                    nanos = this.notFull.awaitNanos(nanos);
                } finally {
                    reentrantLock.unlock();
                }
            }
            return z;
        }
        throw new NullPointerException();
    }

    public LinkedBlockingDeque(Collection<? extends E> collection) {
        this(Integer.MAX_VALUE);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (E e2 : collection) {
                if (e2 != null) {
                    if (!linkLast(new Node<>(e2))) {
                        throw new IllegalStateException("Deque full");
                    }
                } else {
                    throw new NullPointerException();
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (tArr.length < this.count) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.count));
            }
            int i = 0;
            Node<E> node = this.first;
            while (node != null) {
                tArr[i] = node.item;
                node = node.next;
                i++;
            }
            if (tArr.length > i) {
                tArr[i] = null;
            }
            return tArr;
        } finally {
            reentrantLock.unlock();
        }
    }
}
