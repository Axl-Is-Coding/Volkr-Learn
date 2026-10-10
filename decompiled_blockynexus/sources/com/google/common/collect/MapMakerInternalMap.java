package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.collect.GenericMapMaker;
import com.google.common.collect.MapMaker;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
class MapMakerInternalMap<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable {
    static final long CLEANUP_EXECUTOR_DELAY_SECS = 60;
    static final int CONTAINS_VALUE_RETRIES = 3;
    static final int DRAIN_MAX = 16;
    static final int DRAIN_THRESHOLD = 63;
    static final int MAXIMUM_CAPACITY = 1073741824;
    static final int MAX_SEGMENTS = 65536;
    private static final long serialVersionUID = 5;
    final int concurrencyLevel;
    final transient EntryFactory entryFactory;
    transient Set<Map.Entry<K, V>> entrySet;
    final long expireAfterAccessNanos;
    final long expireAfterWriteNanos;
    final Equivalence<Object> keyEquivalence;
    transient Set<K> keySet;
    final Strength keyStrength;
    final int maximumSize;
    final MapMaker.a<K, V> removalListener;
    final Queue<MapMaker.RemovalNotification<K, V>> removalNotificationQueue;
    final transient int segmentMask;
    final transient int segmentShift;
    final transient Segment<K, V>[] segments;
    final com.google.common.base.x ticker;
    final Equivalence<Object> valueEquivalence;
    final Strength valueStrength;
    transient Collection<V> values;
    private static final Logger logger = Logger.getLogger(MapMakerInternalMap.class.getName());
    static final r<Object, Object> UNSET = new Y();
    static final Queue<? extends Object> DISCARDING_QUEUE = new Z();

    enum EntryFactory {
        STRONG { // from class: com.google.common.collect.MapMakerInternalMap.EntryFactory.1
            @Override // com.google.common.collect.MapMakerInternalMap.EntryFactory
            <K, V> i<K, V> newEntry(Segment<K, V> segment, K k, int i, i<K, V> iVar) {
                return new l(k, i, iVar);
            }
        },
        STRONG_EXPIRABLE { // from class: com.google.common.collect.MapMakerInternalMap.EntryFactory.2
            @Override // com.google.common.collect.MapMakerInternalMap.EntryFactory
            <K, V> i<K, V> copyEntry(Segment<K, V> segment, i<K, V> iVar, i<K, V> iVar2) {
                i<K, V> iVarCopyEntry = super.copyEntry(segment, iVar, iVar2);
                copyExpirableEntry(iVar, iVarCopyEntry);
                return iVarCopyEntry;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.EntryFactory
            <K, V> i<K, V> newEntry(Segment<K, V> segment, K k, int i, i<K, V> iVar) {
                return new n(k, i, iVar);
            }
        },
        STRONG_EVICTABLE { // from class: com.google.common.collect.MapMakerInternalMap.EntryFactory.3
            @Override // com.google.common.collect.MapMakerInternalMap.EntryFactory
            <K, V> i<K, V> copyEntry(Segment<K, V> segment, i<K, V> iVar, i<K, V> iVar2) {
                i<K, V> iVarCopyEntry = super.copyEntry(segment, iVar, iVar2);
                copyEvictableEntry(iVar, iVarCopyEntry);
                return iVarCopyEntry;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.EntryFactory
            <K, V> i<K, V> newEntry(Segment<K, V> segment, K k, int i, i<K, V> iVar) {
                return new m(k, i, iVar);
            }
        },
        STRONG_EXPIRABLE_EVICTABLE { // from class: com.google.common.collect.MapMakerInternalMap.EntryFactory.4
            @Override // com.google.common.collect.MapMakerInternalMap.EntryFactory
            <K, V> i<K, V> copyEntry(Segment<K, V> segment, i<K, V> iVar, i<K, V> iVar2) {
                i<K, V> iVarCopyEntry = super.copyEntry(segment, iVar, iVar2);
                copyExpirableEntry(iVar, iVarCopyEntry);
                copyEvictableEntry(iVar, iVarCopyEntry);
                return iVarCopyEntry;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.EntryFactory
            <K, V> i<K, V> newEntry(Segment<K, V> segment, K k, int i, i<K, V> iVar) {
                return new o(k, i, iVar);
            }
        },
        WEAK { // from class: com.google.common.collect.MapMakerInternalMap.EntryFactory.5
            @Override // com.google.common.collect.MapMakerInternalMap.EntryFactory
            <K, V> i<K, V> newEntry(Segment<K, V> segment, K k, int i, i<K, V> iVar) {
                return new t(segment.keyReferenceQueue, k, i, iVar);
            }
        },
        WEAK_EXPIRABLE { // from class: com.google.common.collect.MapMakerInternalMap.EntryFactory.6
            @Override // com.google.common.collect.MapMakerInternalMap.EntryFactory
            <K, V> i<K, V> copyEntry(Segment<K, V> segment, i<K, V> iVar, i<K, V> iVar2) {
                i<K, V> iVarCopyEntry = super.copyEntry(segment, iVar, iVar2);
                copyExpirableEntry(iVar, iVarCopyEntry);
                return iVarCopyEntry;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.EntryFactory
            <K, V> i<K, V> newEntry(Segment<K, V> segment, K k, int i, i<K, V> iVar) {
                return new v(segment.keyReferenceQueue, k, i, iVar);
            }
        },
        WEAK_EVICTABLE { // from class: com.google.common.collect.MapMakerInternalMap.EntryFactory.7
            @Override // com.google.common.collect.MapMakerInternalMap.EntryFactory
            <K, V> i<K, V> copyEntry(Segment<K, V> segment, i<K, V> iVar, i<K, V> iVar2) {
                i<K, V> iVarCopyEntry = super.copyEntry(segment, iVar, iVar2);
                copyEvictableEntry(iVar, iVarCopyEntry);
                return iVarCopyEntry;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.EntryFactory
            <K, V> i<K, V> newEntry(Segment<K, V> segment, K k, int i, i<K, V> iVar) {
                return new u(segment.keyReferenceQueue, k, i, iVar);
            }
        },
        WEAK_EXPIRABLE_EVICTABLE { // from class: com.google.common.collect.MapMakerInternalMap.EntryFactory.8
            @Override // com.google.common.collect.MapMakerInternalMap.EntryFactory
            <K, V> i<K, V> copyEntry(Segment<K, V> segment, i<K, V> iVar, i<K, V> iVar2) {
                i<K, V> iVarCopyEntry = super.copyEntry(segment, iVar, iVar2);
                copyExpirableEntry(iVar, iVarCopyEntry);
                copyEvictableEntry(iVar, iVarCopyEntry);
                return iVarCopyEntry;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.EntryFactory
            <K, V> i<K, V> newEntry(Segment<K, V> segment, K k, int i, i<K, V> iVar) {
                return new w(segment.keyReferenceQueue, k, i, iVar);
            }
        };

        static final int EVICTABLE_MASK = 2;
        static final int EXPIRABLE_MASK = 1;
        static final EntryFactory[][] factories = {new EntryFactory[]{STRONG, STRONG_EXPIRABLE, STRONG_EVICTABLE, STRONG_EXPIRABLE_EVICTABLE}, new EntryFactory[0], new EntryFactory[]{WEAK, WEAK_EXPIRABLE, WEAK_EVICTABLE, WEAK_EXPIRABLE_EVICTABLE}};

        static EntryFactory getFactory(Strength strength, boolean z, boolean z2) {
            return factories[strength.ordinal()][(z ? 1 : 0) | (z2 ? 2 : 0)];
        }

        <K, V> i<K, V> copyEntry(Segment<K, V> segment, i<K, V> iVar, i<K, V> iVar2) {
            return newEntry(segment, iVar.getKey(), iVar.getHash(), iVar2);
        }

        <K, V> void copyEvictableEntry(i<K, V> iVar, i<K, V> iVar2) {
            MapMakerInternalMap.connectEvictables(iVar.getPreviousEvictable(), iVar2);
            MapMakerInternalMap.connectEvictables(iVar2, iVar.getNextEvictable());
            MapMakerInternalMap.nullifyEvictable(iVar);
        }

        <K, V> void copyExpirableEntry(i<K, V> iVar, i<K, V> iVar2) {
            iVar2.setExpirationTime(iVar.getExpirationTime());
            MapMakerInternalMap.connectExpirables(iVar.getPreviousExpirable(), iVar2);
            MapMakerInternalMap.connectExpirables(iVar2, iVar.getNextExpirable());
            MapMakerInternalMap.nullifyExpirable(iVar);
        }

        abstract <K, V> i<K, V> newEntry(Segment<K, V> segment, K k, int i, i<K, V> iVar);

        /* synthetic */ EntryFactory(Y y) {
            this();
        }
    }

    private enum NullEntry implements i<Object, Object> {
        INSTANCE;

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public long getExpirationTime() {
            return 0L;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public int getHash() {
            return 0;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public Object getKey() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public i<Object, Object> getNext() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public i<Object, Object> getNextEvictable() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public i<Object, Object> getNextExpirable() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public i<Object, Object> getPreviousEvictable() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public i<Object, Object> getPreviousExpirable() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public r<Object, Object> getValueReference() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public void setExpirationTime(long j) {
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public void setNextEvictable(i<Object, Object> iVar) {
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public void setNextExpirable(i<Object, Object> iVar) {
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public void setPreviousEvictable(i<Object, Object> iVar) {
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public void setPreviousExpirable(i<Object, Object> iVar) {
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public void setValueReference(r<Object, Object> rVar) {
        }
    }

    static class Segment<K, V> extends ReentrantLock {
        volatile int count;
        final Queue<i<K, V>> evictionQueue;
        final Queue<i<K, V>> expirationQueue;
        final ReferenceQueue<K> keyReferenceQueue;
        final MapMakerInternalMap<K, V> map;
        final int maxSegmentSize;
        int modCount;
        final AtomicInteger readCount = new AtomicInteger();
        final Queue<i<K, V>> recencyQueue;
        volatile AtomicReferenceArray<i<K, V>> table;
        int threshold;
        final ReferenceQueue<V> valueReferenceQueue;

        Segment(MapMakerInternalMap<K, V> mapMakerInternalMap, int i, int i2) {
            this.map = mapMakerInternalMap;
            this.maxSegmentSize = i2;
            initTable(newEntryArray(i));
            this.keyReferenceQueue = mapMakerInternalMap.usesKeyReferences() ? new ReferenceQueue<>() : null;
            this.valueReferenceQueue = mapMakerInternalMap.usesValueReferences() ? new ReferenceQueue<>() : null;
            this.recencyQueue = (mapMakerInternalMap.evictsBySize() || mapMakerInternalMap.expiresAfterAccess()) ? new ConcurrentLinkedQueue<>() : MapMakerInternalMap.discardingQueue();
            this.evictionQueue = mapMakerInternalMap.evictsBySize() ? new d<>() : MapMakerInternalMap.discardingQueue();
            this.expirationQueue = mapMakerInternalMap.expires() ? new e<>() : MapMakerInternalMap.discardingQueue();
        }

        void clear() {
            if (this.count != 0) {
                lock();
                try {
                    AtomicReferenceArray<i<K, V>> atomicReferenceArray = this.table;
                    if (this.map.removalNotificationQueue != MapMakerInternalMap.DISCARDING_QUEUE) {
                        for (int i = 0; i < atomicReferenceArray.length(); i++) {
                            for (i<K, V> next = atomicReferenceArray.get(i); next != null; next = next.getNext()) {
                                if (!next.getValueReference().b()) {
                                    enqueueNotification(next, MapMaker.RemovalCause.EXPLICIT);
                                }
                            }
                        }
                    }
                    for (int i2 = 0; i2 < atomicReferenceArray.length(); i2++) {
                        atomicReferenceArray.set(i2, null);
                    }
                    clearReferenceQueues();
                    this.evictionQueue.clear();
                    this.expirationQueue.clear();
                    this.readCount.set(0);
                    this.modCount++;
                    this.count = 0;
                } finally {
                    unlock();
                    postWriteCleanup();
                }
            }
        }

        void clearKeyReferenceQueue() {
            while (this.keyReferenceQueue.poll() != null) {
            }
        }

        void clearReferenceQueues() {
            if (this.map.usesKeyReferences()) {
                clearKeyReferenceQueue();
            }
            if (this.map.usesValueReferences()) {
                clearValueReferenceQueue();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0030, code lost:
        
            if (r4.getValueReference() != r11) goto L16;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0032, code lost:
        
            r0.set(r1, removeFromChain(r3, r4));
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x003f, code lost:
        
            return true;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        boolean clearValue(K r9, int r10, com.google.common.collect.MapMakerInternalMap.r<K, V> r11) {
            /*
                r8 = this;
                r8.lock()
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.collect.MapMakerInternalMap$i<K, V>> r0 = r8.table     // Catch: java.lang.Throwable -> L4c
                int r1 = r0.length()     // Catch: java.lang.Throwable -> L4c
                r2 = 1
                int r1 = r1 - r2
                r1 = r1 & r10
                java.lang.Object r3 = r0.get(r1)     // Catch: java.lang.Throwable -> L4c
                com.google.common.collect.MapMakerInternalMap$i r3 = (com.google.common.collect.MapMakerInternalMap.i) r3     // Catch: java.lang.Throwable -> L4c
                r4 = r3
            L13:
                r5 = 0
                if (r4 == 0) goto L40
                java.lang.Object r6 = r4.getKey()     // Catch: java.lang.Throwable -> L4c
                int r7 = r4.getHash()     // Catch: java.lang.Throwable -> L4c
                if (r7 != r10) goto L47
                if (r6 == 0) goto L47
                com.google.common.collect.MapMakerInternalMap<K, V> r7 = r8.map     // Catch: java.lang.Throwable -> L4c
                com.google.common.base.Equivalence<java.lang.Object> r7 = r7.keyEquivalence     // Catch: java.lang.Throwable -> L4c
                boolean r6 = r7.equivalent(r9, r6)     // Catch: java.lang.Throwable -> L4c
                if (r6 == 0) goto L47
                com.google.common.collect.MapMakerInternalMap$r r9 = r4.getValueReference()     // Catch: java.lang.Throwable -> L4c
                if (r9 != r11) goto L40
                com.google.common.collect.MapMakerInternalMap$i r9 = r8.removeFromChain(r3, r4)     // Catch: java.lang.Throwable -> L4c
                r0.set(r1, r9)     // Catch: java.lang.Throwable -> L4c
                r8.unlock()
                r8.postWriteCleanup()
                return r2
            L40:
                r8.unlock()
                r8.postWriteCleanup()
                return r5
            L47:
                com.google.common.collect.MapMakerInternalMap$i r4 = r4.getNext()     // Catch: java.lang.Throwable -> L4c
                goto L13
            L4c:
                r9 = move-exception
                r8.unlock()
                r8.postWriteCleanup()
                goto L55
            L54:
                throw r9
            L55:
                goto L54
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.MapMakerInternalMap.Segment.clearValue(java.lang.Object, int, com.google.common.collect.MapMakerInternalMap$r):boolean");
        }

        void clearValueReferenceQueue() {
            while (this.valueReferenceQueue.poll() != null) {
            }
        }

        boolean containsKey(Object obj, int i) {
            try {
                if (this.count == 0) {
                    return false;
                }
                i<K, V> liveEntry = getLiveEntry(obj, i);
                if (liveEntry == null) {
                    return false;
                }
                return liveEntry.getValueReference().get() != null;
            } finally {
                postReadCleanup();
            }
        }

        boolean containsValue(Object obj) {
            try {
                if (this.count != 0) {
                    AtomicReferenceArray<i<K, V>> atomicReferenceArray = this.table;
                    int length = atomicReferenceArray.length();
                    for (int i = 0; i < length; i++) {
                        for (i<K, V> next = atomicReferenceArray.get(i); next != null; next = next.getNext()) {
                            V liveValue = getLiveValue(next);
                            if (liveValue != null && this.map.valueEquivalence.equivalent(obj, liveValue)) {
                                postReadCleanup();
                                return true;
                            }
                        }
                    }
                }
                return false;
            } finally {
                postReadCleanup();
            }
        }

        i<K, V> copyEntry(i<K, V> iVar, i<K, V> iVar2) {
            if (iVar.getKey() == null) {
                return null;
            }
            r<K, V> valueReference = iVar.getValueReference();
            V v = valueReference.get();
            if (v == null && !valueReference.b()) {
                return null;
            }
            i<K, V> iVarCopyEntry = this.map.entryFactory.copyEntry(this, iVar, iVar2);
            iVarCopyEntry.setValueReference(valueReference.a(this.valueReferenceQueue, v, iVarCopyEntry));
            return iVarCopyEntry;
        }

        void drainKeyReferenceQueue() {
            int i = 0;
            do {
                Reference<? extends K> referencePoll = this.keyReferenceQueue.poll();
                if (referencePoll == null) {
                    return;
                }
                this.map.reclaimKey((i) referencePoll);
                i++;
            } while (i != 16);
        }

        void drainRecencyQueue() {
            while (true) {
                i<K, V> iVarPoll = this.recencyQueue.poll();
                if (iVarPoll == null) {
                    return;
                }
                if (this.evictionQueue.contains(iVarPoll)) {
                    this.evictionQueue.add(iVarPoll);
                }
                if (this.map.expiresAfterAccess() && this.expirationQueue.contains(iVarPoll)) {
                    this.expirationQueue.add(iVarPoll);
                }
            }
        }

        void drainReferenceQueues() {
            if (this.map.usesKeyReferences()) {
                drainKeyReferenceQueue();
            }
            if (this.map.usesValueReferences()) {
                drainValueReferenceQueue();
            }
        }

        void drainValueReferenceQueue() {
            int i = 0;
            do {
                Reference<? extends V> referencePoll = this.valueReferenceQueue.poll();
                if (referencePoll == null) {
                    return;
                }
                this.map.reclaimValue((r) referencePoll);
                i++;
            } while (i != 16);
        }

        void enqueueNotification(i<K, V> iVar, MapMaker.RemovalCause removalCause) {
            enqueueNotification(iVar.getKey(), iVar.getHash(), iVar.getValueReference().get(), removalCause);
        }

        boolean evictEntries() {
            if (!this.map.evictsBySize() || this.count < this.maxSegmentSize) {
                return false;
            }
            drainRecencyQueue();
            i<K, V> iVarRemove = this.evictionQueue.remove();
            if (removeEntry(iVarRemove, iVarRemove.getHash(), MapMaker.RemovalCause.SIZE)) {
                return true;
            }
            throw new AssertionError();
        }

        void expand() {
            AtomicReferenceArray<i<K, V>> atomicReferenceArray = this.table;
            int length = atomicReferenceArray.length();
            if (length >= 1073741824) {
                return;
            }
            int i = this.count;
            AtomicReferenceArray<i<K, V>> atomicReferenceArrayNewEntryArray = newEntryArray(length << 1);
            this.threshold = (atomicReferenceArrayNewEntryArray.length() * 3) / 4;
            int length2 = atomicReferenceArrayNewEntryArray.length() - 1;
            for (int i2 = 0; i2 < length; i2++) {
                i<K, V> next = atomicReferenceArray.get(i2);
                if (next != null) {
                    i<K, V> next2 = next.getNext();
                    int hash = next.getHash() & length2;
                    if (next2 == null) {
                        atomicReferenceArrayNewEntryArray.set(hash, next);
                    } else {
                        i<K, V> iVar = next;
                        while (next2 != null) {
                            int hash2 = next2.getHash() & length2;
                            if (hash2 != hash) {
                                iVar = next2;
                                hash = hash2;
                            }
                            next2 = next2.getNext();
                        }
                        atomicReferenceArrayNewEntryArray.set(hash, iVar);
                        while (next != iVar) {
                            int hash3 = next.getHash() & length2;
                            i<K, V> iVarCopyEntry = copyEntry(next, atomicReferenceArrayNewEntryArray.get(hash3));
                            if (iVarCopyEntry != null) {
                                atomicReferenceArrayNewEntryArray.set(hash3, iVarCopyEntry);
                            } else {
                                removeCollectedEntry(next);
                                i--;
                            }
                            next = next.getNext();
                        }
                    }
                }
            }
            this.table = atomicReferenceArrayNewEntryArray;
            this.count = i;
        }

        void expireEntries() {
            i<K, V> iVarPeek;
            drainRecencyQueue();
            if (this.expirationQueue.isEmpty()) {
                return;
            }
            long jA = this.map.ticker.a();
            do {
                iVarPeek = this.expirationQueue.peek();
                if (iVarPeek == null || !this.map.isExpired(iVarPeek, jA)) {
                    return;
                }
            } while (removeEntry(iVarPeek, iVarPeek.getHash(), MapMaker.RemovalCause.EXPIRED));
            throw new AssertionError();
        }

        V get(Object obj, int i) {
            try {
                i<K, V> liveEntry = getLiveEntry(obj, i);
                if (liveEntry == null) {
                    return null;
                }
                V v = liveEntry.getValueReference().get();
                if (v != null) {
                    recordRead(liveEntry);
                } else {
                    tryDrainReferenceQueues();
                }
                return v;
            } finally {
                postReadCleanup();
            }
        }

        i<K, V> getEntry(Object obj, int i) {
            if (this.count == 0) {
                return null;
            }
            for (i<K, V> first = getFirst(i); first != null; first = first.getNext()) {
                if (first.getHash() == i) {
                    K key = first.getKey();
                    if (key == null) {
                        tryDrainReferenceQueues();
                    } else if (this.map.keyEquivalence.equivalent(obj, key)) {
                        return first;
                    }
                }
            }
            return null;
        }

        i<K, V> getFirst(int i) {
            return this.table.get(i & (r0.length() - 1));
        }

        i<K, V> getLiveEntry(Object obj, int i) {
            i<K, V> entry = getEntry(obj, i);
            if (entry == null) {
                return null;
            }
            if (!this.map.expires() || !this.map.isExpired(entry)) {
                return entry;
            }
            tryExpireEntries();
            return null;
        }

        V getLiveValue(i<K, V> iVar) {
            if (iVar.getKey() == null) {
                tryDrainReferenceQueues();
                return null;
            }
            V v = iVar.getValueReference().get();
            if (v == null) {
                tryDrainReferenceQueues();
                return null;
            }
            if (!this.map.expires() || !this.map.isExpired(iVar)) {
                return v;
            }
            tryExpireEntries();
            return null;
        }

        void initTable(AtomicReferenceArray<i<K, V>> atomicReferenceArray) {
            this.threshold = (atomicReferenceArray.length() * 3) / 4;
            int i = this.threshold;
            if (i == this.maxSegmentSize) {
                this.threshold = i + 1;
            }
            this.table = atomicReferenceArray;
        }

        boolean isCollected(r<K, V> rVar) {
            return !rVar.b() && rVar.get() == null;
        }

        i<K, V> newEntry(K k, int i, i<K, V> iVar) {
            return this.map.entryFactory.newEntry(this, k, i, iVar);
        }

        AtomicReferenceArray<i<K, V>> newEntryArray(int i) {
            return new AtomicReferenceArray<>(i);
        }

        void postReadCleanup() {
            if ((this.readCount.incrementAndGet() & 63) == 0) {
                runCleanup();
            }
        }

        void postWriteCleanup() {
            runUnlockedCleanup();
        }

        void preWriteCleanup() {
            runLockedCleanup();
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x0071, code lost:
        
            return null;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        V put(K r9, int r10, V r11, boolean r12) {
            /*
                r8 = this;
                r8.lock()
                r8.preWriteCleanup()     // Catch: java.lang.Throwable -> Laf
                int r0 = r8.count     // Catch: java.lang.Throwable -> Laf
                int r0 = r0 + 1
                int r1 = r8.threshold     // Catch: java.lang.Throwable -> Laf
                if (r0 <= r1) goto L15
                r8.expand()     // Catch: java.lang.Throwable -> Laf
                int r0 = r8.count     // Catch: java.lang.Throwable -> Laf
                int r0 = r0 + 1
            L15:
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.collect.MapMakerInternalMap$i<K, V>> r1 = r8.table     // Catch: java.lang.Throwable -> Laf
                int r2 = r1.length()     // Catch: java.lang.Throwable -> Laf
                int r2 = r2 + (-1)
                r2 = r2 & r10
                java.lang.Object r3 = r1.get(r2)     // Catch: java.lang.Throwable -> Laf
                com.google.common.collect.MapMakerInternalMap$i r3 = (com.google.common.collect.MapMakerInternalMap.i) r3     // Catch: java.lang.Throwable -> Laf
                r4 = r3
            L25:
                r5 = 0
                if (r4 == 0) goto L92
                java.lang.Object r6 = r4.getKey()     // Catch: java.lang.Throwable -> Laf
                int r7 = r4.getHash()     // Catch: java.lang.Throwable -> Laf
                if (r7 != r10) goto L8d
                if (r6 == 0) goto L8d
                com.google.common.collect.MapMakerInternalMap<K, V> r7 = r8.map     // Catch: java.lang.Throwable -> Laf
                com.google.common.base.Equivalence<java.lang.Object> r7 = r7.keyEquivalence     // Catch: java.lang.Throwable -> Laf
                boolean r6 = r7.equivalent(r9, r6)     // Catch: java.lang.Throwable -> Laf
                if (r6 == 0) goto L8d
                com.google.common.collect.MapMakerInternalMap$r r1 = r4.getValueReference()     // Catch: java.lang.Throwable -> Laf
                java.lang.Object r2 = r1.get()     // Catch: java.lang.Throwable -> Laf
                if (r2 != 0) goto L72
                int r12 = r8.modCount     // Catch: java.lang.Throwable -> Laf
                int r12 = r12 + 1
                r8.modCount = r12     // Catch: java.lang.Throwable -> Laf
                r8.setValue(r4, r11)     // Catch: java.lang.Throwable -> Laf
                boolean r11 = r1.b()     // Catch: java.lang.Throwable -> Laf
                if (r11 != 0) goto L5f
                com.google.common.collect.MapMaker$RemovalCause r11 = com.google.common.collect.MapMaker.RemovalCause.COLLECTED     // Catch: java.lang.Throwable -> Laf
                r8.enqueueNotification(r9, r10, r2, r11)     // Catch: java.lang.Throwable -> Laf
                int r0 = r8.count     // Catch: java.lang.Throwable -> Laf
                goto L69
            L5f:
                boolean r9 = r8.evictEntries()     // Catch: java.lang.Throwable -> Laf
                if (r9 == 0) goto L69
                int r9 = r8.count     // Catch: java.lang.Throwable -> Laf
                int r0 = r9 + 1
            L69:
                r8.count = r0     // Catch: java.lang.Throwable -> Laf
            L6b:
                r8.unlock()
                r8.postWriteCleanup()
                return r5
            L72:
                if (r12 == 0) goto L7e
                r8.recordLockedRead(r4)     // Catch: java.lang.Throwable -> Laf
            L77:
                r8.unlock()
                r8.postWriteCleanup()
                return r2
            L7e:
                int r12 = r8.modCount     // Catch: java.lang.Throwable -> Laf
                int r12 = r12 + 1
                r8.modCount = r12     // Catch: java.lang.Throwable -> Laf
                com.google.common.collect.MapMaker$RemovalCause r12 = com.google.common.collect.MapMaker.RemovalCause.REPLACED     // Catch: java.lang.Throwable -> Laf
                r8.enqueueNotification(r9, r10, r2, r12)     // Catch: java.lang.Throwable -> Laf
                r8.setValue(r4, r11)     // Catch: java.lang.Throwable -> Laf
                goto L77
            L8d:
                com.google.common.collect.MapMakerInternalMap$i r4 = r4.getNext()     // Catch: java.lang.Throwable -> Laf
                goto L25
            L92:
                int r12 = r8.modCount     // Catch: java.lang.Throwable -> Laf
                int r12 = r12 + 1
                r8.modCount = r12     // Catch: java.lang.Throwable -> Laf
                com.google.common.collect.MapMakerInternalMap$i r9 = r8.newEntry(r9, r10, r3)     // Catch: java.lang.Throwable -> Laf
                r8.setValue(r9, r11)     // Catch: java.lang.Throwable -> Laf
                r1.set(r2, r9)     // Catch: java.lang.Throwable -> Laf
                boolean r9 = r8.evictEntries()     // Catch: java.lang.Throwable -> Laf
                if (r9 == 0) goto Lac
                int r9 = r8.count     // Catch: java.lang.Throwable -> Laf
                int r0 = r9 + 1
            Lac:
                r8.count = r0     // Catch: java.lang.Throwable -> Laf
                goto L6b
            Laf:
                r9 = move-exception
                r8.unlock()
                r8.postWriteCleanup()
                goto Lb8
            Lb7:
                throw r9
            Lb8:
                goto Lb7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.MapMakerInternalMap.Segment.put(java.lang.Object, int, java.lang.Object, boolean):java.lang.Object");
        }

        boolean reclaimKey(i<K, V> iVar, int i) {
            lock();
            try {
                int i2 = this.count;
                AtomicReferenceArray<i<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                i<K, V> iVar2 = atomicReferenceArray.get(length);
                for (i<K, V> next = iVar2; next != null; next = next.getNext()) {
                    if (next == iVar) {
                        this.modCount++;
                        enqueueNotification(next.getKey(), i, next.getValueReference().get(), MapMaker.RemovalCause.COLLECTED);
                        i<K, V> iVarRemoveFromChain = removeFromChain(iVar2, next);
                        int i3 = this.count - 1;
                        atomicReferenceArray.set(length, iVarRemoveFromChain);
                        this.count = i3;
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        boolean reclaimValue(K k, int i, r<K, V> rVar) {
            lock();
            try {
                int i2 = this.count;
                AtomicReferenceArray<i<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                i<K, V> iVar = atomicReferenceArray.get(length);
                for (i<K, V> next = iVar; next != null; next = next.getNext()) {
                    K key = next.getKey();
                    if (next.getHash() == i && key != null && this.map.keyEquivalence.equivalent(k, key)) {
                        if (next.getValueReference() != rVar) {
                            unlock();
                            if (!isHeldByCurrentThread()) {
                                postWriteCleanup();
                            }
                            return false;
                        }
                        this.modCount++;
                        enqueueNotification(k, i, rVar.get(), MapMaker.RemovalCause.COLLECTED);
                        i<K, V> iVarRemoveFromChain = removeFromChain(iVar, next);
                        int i3 = this.count - 1;
                        atomicReferenceArray.set(length, iVarRemoveFromChain);
                        this.count = i3;
                        return true;
                    }
                }
                unlock();
                if (!isHeldByCurrentThread()) {
                    postWriteCleanup();
                }
                return false;
            } finally {
                unlock();
                if (!isHeldByCurrentThread()) {
                    postWriteCleanup();
                }
            }
        }

        void recordExpirationTime(i<K, V> iVar, long j) {
            iVar.setExpirationTime(this.map.ticker.a() + j);
        }

        void recordLockedRead(i<K, V> iVar) {
            this.evictionQueue.add(iVar);
            if (this.map.expiresAfterAccess()) {
                recordExpirationTime(iVar, this.map.expireAfterAccessNanos);
                this.expirationQueue.add(iVar);
            }
        }

        void recordRead(i<K, V> iVar) {
            if (this.map.expiresAfterAccess()) {
                recordExpirationTime(iVar, this.map.expireAfterAccessNanos);
            }
            this.recencyQueue.add(iVar);
        }

        void recordWrite(i<K, V> iVar) {
            drainRecencyQueue();
            this.evictionQueue.add(iVar);
            if (this.map.expires()) {
                recordExpirationTime(iVar, this.map.expiresAfterAccess() ? this.map.expireAfterAccessNanos : this.map.expireAfterWriteNanos);
                this.expirationQueue.add(iVar);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0031, code lost:
        
            r8 = r3.getValueReference();
            r6 = r8.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0039, code lost:
        
            if (r6 == null) goto L14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x003b, code lost:
        
            r8 = com.google.common.collect.MapMaker.RemovalCause.EXPLICIT;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0042, code lost:
        
            if (isCollected(r8) == false) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0044, code lost:
        
            r8 = com.google.common.collect.MapMaker.RemovalCause.COLLECTED;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0046, code lost:
        
            r7.modCount++;
            enqueueNotification(r5, r9, r6, r8);
            r8 = removeFromChain(r2, r3);
            r9 = r7.count - 1;
            r0.set(r1, r8);
            r7.count = r9;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0062, code lost:
        
            return r6;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        V remove(java.lang.Object r8, int r9) {
            /*
                r7 = this;
                r7.lock()
                r7.preWriteCleanup()     // Catch: java.lang.Throwable -> L6f
                int r0 = r7.count     // Catch: java.lang.Throwable -> L6f
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.collect.MapMakerInternalMap$i<K, V>> r0 = r7.table     // Catch: java.lang.Throwable -> L6f
                int r1 = r0.length()     // Catch: java.lang.Throwable -> L6f
                int r1 = r1 + (-1)
                r1 = r1 & r9
                java.lang.Object r2 = r0.get(r1)     // Catch: java.lang.Throwable -> L6f
                com.google.common.collect.MapMakerInternalMap$i r2 = (com.google.common.collect.MapMakerInternalMap.i) r2     // Catch: java.lang.Throwable -> L6f
                r3 = r2
            L18:
                r4 = 0
                if (r3 == 0) goto L63
                java.lang.Object r5 = r3.getKey()     // Catch: java.lang.Throwable -> L6f
                int r6 = r3.getHash()     // Catch: java.lang.Throwable -> L6f
                if (r6 != r9) goto L6a
                if (r5 == 0) goto L6a
                com.google.common.collect.MapMakerInternalMap<K, V> r6 = r7.map     // Catch: java.lang.Throwable -> L6f
                com.google.common.base.Equivalence<java.lang.Object> r6 = r6.keyEquivalence     // Catch: java.lang.Throwable -> L6f
                boolean r6 = r6.equivalent(r8, r5)     // Catch: java.lang.Throwable -> L6f
                if (r6 == 0) goto L6a
                com.google.common.collect.MapMakerInternalMap$r r8 = r3.getValueReference()     // Catch: java.lang.Throwable -> L6f
                java.lang.Object r6 = r8.get()     // Catch: java.lang.Throwable -> L6f
                if (r6 == 0) goto L3e
                com.google.common.collect.MapMaker$RemovalCause r8 = com.google.common.collect.MapMaker.RemovalCause.EXPLICIT     // Catch: java.lang.Throwable -> L6f
                goto L46
            L3e:
                boolean r8 = r7.isCollected(r8)     // Catch: java.lang.Throwable -> L6f
                if (r8 == 0) goto L63
                com.google.common.collect.MapMaker$RemovalCause r8 = com.google.common.collect.MapMaker.RemovalCause.COLLECTED     // Catch: java.lang.Throwable -> L6f
            L46:
                int r4 = r7.modCount     // Catch: java.lang.Throwable -> L6f
                int r4 = r4 + 1
                r7.modCount = r4     // Catch: java.lang.Throwable -> L6f
                r7.enqueueNotification(r5, r9, r6, r8)     // Catch: java.lang.Throwable -> L6f
                com.google.common.collect.MapMakerInternalMap$i r8 = r7.removeFromChain(r2, r3)     // Catch: java.lang.Throwable -> L6f
                int r9 = r7.count     // Catch: java.lang.Throwable -> L6f
                int r9 = r9 + (-1)
                r0.set(r1, r8)     // Catch: java.lang.Throwable -> L6f
                r7.count = r9     // Catch: java.lang.Throwable -> L6f
                r7.unlock()
                r7.postWriteCleanup()
                return r6
            L63:
                r7.unlock()
                r7.postWriteCleanup()
                return r4
            L6a:
                com.google.common.collect.MapMakerInternalMap$i r3 = r3.getNext()     // Catch: java.lang.Throwable -> L6f
                goto L18
            L6f:
                r8 = move-exception
                r7.unlock()
                r7.postWriteCleanup()
                goto L78
            L77:
                throw r8
            L78:
                goto L77
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.MapMakerInternalMap.Segment.remove(java.lang.Object, int):java.lang.Object");
        }

        void removeCollectedEntry(i<K, V> iVar) {
            enqueueNotification(iVar, MapMaker.RemovalCause.COLLECTED);
            this.evictionQueue.remove(iVar);
            this.expirationQueue.remove(iVar);
        }

        boolean removeEntry(i<K, V> iVar, int i, MapMaker.RemovalCause removalCause) {
            int i2 = this.count;
            AtomicReferenceArray<i<K, V>> atomicReferenceArray = this.table;
            int length = (atomicReferenceArray.length() - 1) & i;
            i<K, V> iVar2 = atomicReferenceArray.get(length);
            for (i<K, V> next = iVar2; next != null; next = next.getNext()) {
                if (next == iVar) {
                    this.modCount++;
                    enqueueNotification(next.getKey(), i, next.getValueReference().get(), removalCause);
                    i<K, V> iVarRemoveFromChain = removeFromChain(iVar2, next);
                    int i3 = this.count - 1;
                    atomicReferenceArray.set(length, iVarRemoveFromChain);
                    this.count = i3;
                    return true;
                }
            }
            return false;
        }

        i<K, V> removeFromChain(i<K, V> iVar, i<K, V> iVar2) {
            this.evictionQueue.remove(iVar2);
            this.expirationQueue.remove(iVar2);
            int i = this.count;
            i<K, V> next = iVar2.getNext();
            while (iVar != iVar2) {
                i<K, V> iVarCopyEntry = copyEntry(iVar, next);
                if (iVarCopyEntry != null) {
                    next = iVarCopyEntry;
                } else {
                    removeCollectedEntry(iVar);
                    i--;
                }
                iVar = iVar.getNext();
            }
            this.count = i;
            return next;
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x005d, code lost:
        
            return false;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        boolean replace(K r10, int r11, V r12, V r13) {
            /*
                r9 = this;
                r9.lock()
                r9.preWriteCleanup()     // Catch: java.lang.Throwable -> L85
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.collect.MapMakerInternalMap$i<K, V>> r0 = r9.table     // Catch: java.lang.Throwable -> L85
                int r1 = r0.length()     // Catch: java.lang.Throwable -> L85
                r2 = 1
                int r1 = r1 - r2
                r1 = r1 & r11
                java.lang.Object r3 = r0.get(r1)     // Catch: java.lang.Throwable -> L85
                com.google.common.collect.MapMakerInternalMap$i r3 = (com.google.common.collect.MapMakerInternalMap.i) r3     // Catch: java.lang.Throwable -> L85
                r4 = r3
            L16:
                r5 = 0
                if (r4 == 0) goto L57
                java.lang.Object r6 = r4.getKey()     // Catch: java.lang.Throwable -> L85
                int r7 = r4.getHash()     // Catch: java.lang.Throwable -> L85
                if (r7 != r11) goto L80
                if (r6 == 0) goto L80
                com.google.common.collect.MapMakerInternalMap<K, V> r7 = r9.map     // Catch: java.lang.Throwable -> L85
                com.google.common.base.Equivalence<java.lang.Object> r7 = r7.keyEquivalence     // Catch: java.lang.Throwable -> L85
                boolean r7 = r7.equivalent(r10, r6)     // Catch: java.lang.Throwable -> L85
                if (r7 == 0) goto L80
                com.google.common.collect.MapMakerInternalMap$r r7 = r4.getValueReference()     // Catch: java.lang.Throwable -> L85
                java.lang.Object r8 = r7.get()     // Catch: java.lang.Throwable -> L85
                if (r8 != 0) goto L5e
                boolean r10 = r9.isCollected(r7)     // Catch: java.lang.Throwable -> L85
                if (r10 == 0) goto L57
                int r10 = r9.count     // Catch: java.lang.Throwable -> L85
                int r10 = r9.modCount     // Catch: java.lang.Throwable -> L85
                int r10 = r10 + r2
                r9.modCount = r10     // Catch: java.lang.Throwable -> L85
                com.google.common.collect.MapMaker$RemovalCause r10 = com.google.common.collect.MapMaker.RemovalCause.COLLECTED     // Catch: java.lang.Throwable -> L85
                r9.enqueueNotification(r6, r11, r8, r10)     // Catch: java.lang.Throwable -> L85
                com.google.common.collect.MapMakerInternalMap$i r10 = r9.removeFromChain(r3, r4)     // Catch: java.lang.Throwable -> L85
                int r11 = r9.count     // Catch: java.lang.Throwable -> L85
                int r11 = r11 - r2
                r0.set(r1, r10)     // Catch: java.lang.Throwable -> L85
                r9.count = r11     // Catch: java.lang.Throwable -> L85
            L57:
                r9.unlock()
                r9.postWriteCleanup()
                return r5
            L5e:
                com.google.common.collect.MapMakerInternalMap<K, V> r0 = r9.map     // Catch: java.lang.Throwable -> L85
                com.google.common.base.Equivalence<java.lang.Object> r0 = r0.valueEquivalence     // Catch: java.lang.Throwable -> L85
                boolean r12 = r0.equivalent(r12, r8)     // Catch: java.lang.Throwable -> L85
                if (r12 == 0) goto L7c
                int r12 = r9.modCount     // Catch: java.lang.Throwable -> L85
                int r12 = r12 + r2
                r9.modCount = r12     // Catch: java.lang.Throwable -> L85
                com.google.common.collect.MapMaker$RemovalCause r12 = com.google.common.collect.MapMaker.RemovalCause.REPLACED     // Catch: java.lang.Throwable -> L85
                r9.enqueueNotification(r10, r11, r8, r12)     // Catch: java.lang.Throwable -> L85
                r9.setValue(r4, r13)     // Catch: java.lang.Throwable -> L85
                r9.unlock()
                r9.postWriteCleanup()
                return r2
            L7c:
                r9.recordLockedRead(r4)     // Catch: java.lang.Throwable -> L85
                goto L57
            L80:
                com.google.common.collect.MapMakerInternalMap$i r4 = r4.getNext()     // Catch: java.lang.Throwable -> L85
                goto L16
            L85:
                r10 = move-exception
                r9.unlock()
                r9.postWriteCleanup()
                goto L8e
            L8d:
                throw r10
            L8e:
                goto L8d
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.MapMakerInternalMap.Segment.replace(java.lang.Object, int, java.lang.Object, java.lang.Object):boolean");
        }

        void runCleanup() {
            runLockedCleanup();
            runUnlockedCleanup();
        }

        void runLockedCleanup() {
            if (tryLock()) {
                try {
                    drainReferenceQueues();
                    expireEntries();
                    this.readCount.set(0);
                } finally {
                    unlock();
                }
            }
        }

        void runUnlockedCleanup() {
            if (isHeldByCurrentThread()) {
                return;
            }
            this.map.processPendingNotifications();
        }

        void setValue(i<K, V> iVar, V v) {
            iVar.setValueReference(this.map.valueStrength.referenceValue(this, iVar, v));
            recordWrite(iVar);
        }

        void tryDrainReferenceQueues() {
            if (tryLock()) {
                try {
                    drainReferenceQueues();
                } finally {
                    unlock();
                }
            }
        }

        void tryExpireEntries() {
            if (tryLock()) {
                try {
                    expireEntries();
                } finally {
                    unlock();
                }
            }
        }

        void enqueueNotification(K k, int i, V v, MapMaker.RemovalCause removalCause) {
            if (this.map.removalNotificationQueue != MapMakerInternalMap.DISCARDING_QUEUE) {
                this.map.removalNotificationQueue.offer(new MapMaker.RemovalNotification<>(k, v, removalCause));
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0031, code lost:
        
            r10 = r4.getValueReference();
            r7 = r10.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0041, code lost:
        
            if (r9.map.valueEquivalence.equivalent(r12, r7) == false) goto L14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0043, code lost:
        
            r10 = com.google.common.collect.MapMaker.RemovalCause.EXPLICIT;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x004a, code lost:
        
            if (isCollected(r10) == false) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x004c, code lost:
        
            r10 = com.google.common.collect.MapMaker.RemovalCause.COLLECTED;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x004e, code lost:
        
            r9.modCount++;
            enqueueNotification(r6, r11, r7, r10);
            r11 = removeFromChain(r3, r4);
            r12 = r9.count - 1;
            r0.set(r1, r11);
            r9.count = r12;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0064, code lost:
        
            if (r10 != com.google.common.collect.MapMaker.RemovalCause.EXPLICIT) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0067, code lost:
        
            r2 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x006e, code lost:
        
            return r2;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        boolean remove(java.lang.Object r10, int r11, java.lang.Object r12) {
            /*
                r9 = this;
                r9.lock()
                r9.preWriteCleanup()     // Catch: java.lang.Throwable -> L7b
                int r0 = r9.count     // Catch: java.lang.Throwable -> L7b
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.collect.MapMakerInternalMap$i<K, V>> r0 = r9.table     // Catch: java.lang.Throwable -> L7b
                int r1 = r0.length()     // Catch: java.lang.Throwable -> L7b
                r2 = 1
                int r1 = r1 - r2
                r1 = r1 & r11
                java.lang.Object r3 = r0.get(r1)     // Catch: java.lang.Throwable -> L7b
                com.google.common.collect.MapMakerInternalMap$i r3 = (com.google.common.collect.MapMakerInternalMap.i) r3     // Catch: java.lang.Throwable -> L7b
                r4 = r3
            L18:
                r5 = 0
                if (r4 == 0) goto L6f
                java.lang.Object r6 = r4.getKey()     // Catch: java.lang.Throwable -> L7b
                int r7 = r4.getHash()     // Catch: java.lang.Throwable -> L7b
                if (r7 != r11) goto L76
                if (r6 == 0) goto L76
                com.google.common.collect.MapMakerInternalMap<K, V> r7 = r9.map     // Catch: java.lang.Throwable -> L7b
                com.google.common.base.Equivalence<java.lang.Object> r7 = r7.keyEquivalence     // Catch: java.lang.Throwable -> L7b
                boolean r7 = r7.equivalent(r10, r6)     // Catch: java.lang.Throwable -> L7b
                if (r7 == 0) goto L76
                com.google.common.collect.MapMakerInternalMap$r r10 = r4.getValueReference()     // Catch: java.lang.Throwable -> L7b
                java.lang.Object r7 = r10.get()     // Catch: java.lang.Throwable -> L7b
                com.google.common.collect.MapMakerInternalMap<K, V> r8 = r9.map     // Catch: java.lang.Throwable -> L7b
                com.google.common.base.Equivalence<java.lang.Object> r8 = r8.valueEquivalence     // Catch: java.lang.Throwable -> L7b
                boolean r12 = r8.equivalent(r12, r7)     // Catch: java.lang.Throwable -> L7b
                if (r12 == 0) goto L46
                com.google.common.collect.MapMaker$RemovalCause r10 = com.google.common.collect.MapMaker.RemovalCause.EXPLICIT     // Catch: java.lang.Throwable -> L7b
                goto L4e
            L46:
                boolean r10 = r9.isCollected(r10)     // Catch: java.lang.Throwable -> L7b
                if (r10 == 0) goto L6f
                com.google.common.collect.MapMaker$RemovalCause r10 = com.google.common.collect.MapMaker.RemovalCause.COLLECTED     // Catch: java.lang.Throwable -> L7b
            L4e:
                int r12 = r9.modCount     // Catch: java.lang.Throwable -> L7b
                int r12 = r12 + r2
                r9.modCount = r12     // Catch: java.lang.Throwable -> L7b
                r9.enqueueNotification(r6, r11, r7, r10)     // Catch: java.lang.Throwable -> L7b
                com.google.common.collect.MapMakerInternalMap$i r11 = r9.removeFromChain(r3, r4)     // Catch: java.lang.Throwable -> L7b
                int r12 = r9.count     // Catch: java.lang.Throwable -> L7b
                int r12 = r12 - r2
                r0.set(r1, r11)     // Catch: java.lang.Throwable -> L7b
                r9.count = r12     // Catch: java.lang.Throwable -> L7b
                com.google.common.collect.MapMaker$RemovalCause r11 = com.google.common.collect.MapMaker.RemovalCause.EXPLICIT     // Catch: java.lang.Throwable -> L7b
                if (r10 != r11) goto L67
                goto L68
            L67:
                r2 = 0
            L68:
                r9.unlock()
                r9.postWriteCleanup()
                return r2
            L6f:
                r9.unlock()
                r9.postWriteCleanup()
                return r5
            L76:
                com.google.common.collect.MapMakerInternalMap$i r4 = r4.getNext()     // Catch: java.lang.Throwable -> L7b
                goto L18
            L7b:
                r10 = move-exception
                r9.unlock()
                r9.postWriteCleanup()
                goto L84
            L83:
                throw r10
            L84:
                goto L83
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.MapMakerInternalMap.Segment.remove(java.lang.Object, int, java.lang.Object):boolean");
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x005f, code lost:
        
            return null;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        V replace(K r9, int r10, V r11) {
            /*
                r8 = this;
                r8.lock()
                r8.preWriteCleanup()     // Catch: java.lang.Throwable -> L7a
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.collect.MapMakerInternalMap$i<K, V>> r0 = r8.table     // Catch: java.lang.Throwable -> L7a
                int r1 = r0.length()     // Catch: java.lang.Throwable -> L7a
                int r1 = r1 + (-1)
                r1 = r1 & r10
                java.lang.Object r2 = r0.get(r1)     // Catch: java.lang.Throwable -> L7a
                com.google.common.collect.MapMakerInternalMap$i r2 = (com.google.common.collect.MapMakerInternalMap.i) r2     // Catch: java.lang.Throwable -> L7a
                r3 = r2
            L16:
                r4 = 0
                if (r3 == 0) goto L59
                java.lang.Object r5 = r3.getKey()     // Catch: java.lang.Throwable -> L7a
                int r6 = r3.getHash()     // Catch: java.lang.Throwable -> L7a
                if (r6 != r10) goto L75
                if (r5 == 0) goto L75
                com.google.common.collect.MapMakerInternalMap<K, V> r6 = r8.map     // Catch: java.lang.Throwable -> L7a
                com.google.common.base.Equivalence<java.lang.Object> r6 = r6.keyEquivalence     // Catch: java.lang.Throwable -> L7a
                boolean r6 = r6.equivalent(r9, r5)     // Catch: java.lang.Throwable -> L7a
                if (r6 == 0) goto L75
                com.google.common.collect.MapMakerInternalMap$r r6 = r3.getValueReference()     // Catch: java.lang.Throwable -> L7a
                java.lang.Object r7 = r6.get()     // Catch: java.lang.Throwable -> L7a
                if (r7 != 0) goto L60
                boolean r9 = r8.isCollected(r6)     // Catch: java.lang.Throwable -> L7a
                if (r9 == 0) goto L59
                int r9 = r8.count     // Catch: java.lang.Throwable -> L7a
                int r9 = r8.modCount     // Catch: java.lang.Throwable -> L7a
                int r9 = r9 + 1
                r8.modCount = r9     // Catch: java.lang.Throwable -> L7a
                com.google.common.collect.MapMaker$RemovalCause r9 = com.google.common.collect.MapMaker.RemovalCause.COLLECTED     // Catch: java.lang.Throwable -> L7a
                r8.enqueueNotification(r5, r10, r7, r9)     // Catch: java.lang.Throwable -> L7a
                com.google.common.collect.MapMakerInternalMap$i r9 = r8.removeFromChain(r2, r3)     // Catch: java.lang.Throwable -> L7a
                int r10 = r8.count     // Catch: java.lang.Throwable -> L7a
                int r10 = r10 + (-1)
                r0.set(r1, r9)     // Catch: java.lang.Throwable -> L7a
                r8.count = r10     // Catch: java.lang.Throwable -> L7a
            L59:
                r8.unlock()
                r8.postWriteCleanup()
                return r4
            L60:
                int r0 = r8.modCount     // Catch: java.lang.Throwable -> L7a
                int r0 = r0 + 1
                r8.modCount = r0     // Catch: java.lang.Throwable -> L7a
                com.google.common.collect.MapMaker$RemovalCause r0 = com.google.common.collect.MapMaker.RemovalCause.REPLACED     // Catch: java.lang.Throwable -> L7a
                r8.enqueueNotification(r9, r10, r7, r0)     // Catch: java.lang.Throwable -> L7a
                r8.setValue(r3, r11)     // Catch: java.lang.Throwable -> L7a
                r8.unlock()
                r8.postWriteCleanup()
                return r7
            L75:
                com.google.common.collect.MapMakerInternalMap$i r3 = r3.getNext()     // Catch: java.lang.Throwable -> L7a
                goto L16
            L7a:
                r9 = move-exception
                r8.unlock()
                r8.postWriteCleanup()
                goto L83
            L82:
                throw r9
            L83:
                goto L82
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.MapMakerInternalMap.Segment.replace(java.lang.Object, int, java.lang.Object):java.lang.Object");
        }
    }

    private static final class SerializationProxy<K, V> extends AbstractSerializationProxy<K, V> {
        private static final long serialVersionUID = 3;

        SerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, long j, long j2, int i, int i2, MapMaker.a<? super K, ? super V> aVar, ConcurrentMap<K, V> concurrentMap) {
            super(strength, strength2, equivalence, equivalence2, j, j2, i, i2, aVar, concurrentMap);
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            this.delegate = readMapMaker(objectInputStream).j();
            readEntries(objectInputStream);
        }

        private Object readResolve() {
            return this.delegate;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            writeMapTo(objectOutputStream);
        }
    }

    enum Strength {
        STRONG { // from class: com.google.common.collect.MapMakerInternalMap.Strength.1
            @Override // com.google.common.collect.MapMakerInternalMap.Strength
            Equivalence<Object> defaultEquivalence() {
                return Equivalence.equals();
            }

            @Override // com.google.common.collect.MapMakerInternalMap.Strength
            <K, V> r<K, V> referenceValue(Segment<K, V> segment, i<K, V> iVar, V v) {
                return new p(v);
            }
        },
        SOFT { // from class: com.google.common.collect.MapMakerInternalMap.Strength.2
            @Override // com.google.common.collect.MapMakerInternalMap.Strength
            Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }

            @Override // com.google.common.collect.MapMakerInternalMap.Strength
            <K, V> r<K, V> referenceValue(Segment<K, V> segment, i<K, V> iVar, V v) {
                return new k(segment.valueReferenceQueue, v, iVar);
            }
        },
        WEAK { // from class: com.google.common.collect.MapMakerInternalMap.Strength.3
            @Override // com.google.common.collect.MapMakerInternalMap.Strength
            Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }

            @Override // com.google.common.collect.MapMakerInternalMap.Strength
            <K, V> r<K, V> referenceValue(Segment<K, V> segment, i<K, V> iVar, V v) {
                return new x(segment.valueReferenceQueue, v, iVar);
            }
        };

        abstract Equivalence<Object> defaultEquivalence();

        abstract <K, V> r<K, V> referenceValue(Segment<K, V> segment, i<K, V> iVar, V v);

        /* synthetic */ Strength(Y y) {
            this();
        }
    }

    static abstract class a<K, V> implements i<K, V> {
        a() {
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public long getExpirationTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public int getHash() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public K getKey() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getNext() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getNextEvictable() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getNextExpirable() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getPreviousEvictable() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getPreviousExpirable() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public r<K, V> getValueReference() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public void setExpirationTime(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public void setNextEvictable(i<K, V> iVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public void setNextExpirable(i<K, V> iVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public void setPreviousEvictable(i<K, V> iVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public void setPreviousExpirable(i<K, V> iVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public void setValueReference(r<K, V> rVar) {
            throw new UnsupportedOperationException();
        }
    }

    final class b extends MapMakerInternalMap<K, V>.f<Map.Entry<K, V>> {
        b() {
            super();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            return b();
        }
    }

    final class c extends j<Map.Entry<K, V>> {
        c() {
            super(null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            Object obj2;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (obj2 = MapMakerInternalMap.this.get(key)) != null && MapMakerInternalMap.this.valueEquivalence.equivalent(entry.getValue(), obj2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new b();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && MapMakerInternalMap.this.remove(key, entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return MapMakerInternalMap.this.size();
        }
    }

    static final class d<K, V> extends AbstractQueue<i<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final i<K, V> f13862a = new C2240aa(this);

        d() {
        }

        @Override // java.util.Queue
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean offer(i<K, V> iVar) {
            MapMakerInternalMap.connectEvictables(iVar.getPreviousEvictable(), iVar.getNextEvictable());
            MapMakerInternalMap.connectEvictables(this.f13862a.getPreviousEvictable(), iVar);
            MapMakerInternalMap.connectEvictables(iVar, this.f13862a);
            return true;
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            i<K, V> nextEvictable = this.f13862a.getNextEvictable();
            while (true) {
                i<K, V> iVar = this.f13862a;
                if (nextEvictable == iVar) {
                    iVar.setNextEvictable(iVar);
                    i<K, V> iVar2 = this.f13862a;
                    iVar2.setPreviousEvictable(iVar2);
                    return;
                } else {
                    i<K, V> nextEvictable2 = nextEvictable.getNextEvictable();
                    MapMakerInternalMap.nullifyEvictable(nextEvictable);
                    nextEvictable = nextEvictable2;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return ((i) obj).getNextEvictable() != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f13862a.getNextEvictable() == this.f13862a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<i<K, V>> iterator() {
            return new C2242ba(this, peek());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            i iVar = (i) obj;
            i<K, V> previousEvictable = iVar.getPreviousEvictable();
            i<K, V> nextEvictable = iVar.getNextEvictable();
            MapMakerInternalMap.connectEvictables(previousEvictable, nextEvictable);
            MapMakerInternalMap.nullifyEvictable(iVar);
            return nextEvictable != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            int i = 0;
            for (i<K, V> nextEvictable = this.f13862a.getNextEvictable(); nextEvictable != this.f13862a; nextEvictable = nextEvictable.getNextEvictable()) {
                i++;
            }
            return i;
        }

        @Override // java.util.Queue
        public i<K, V> peek() {
            i<K, V> nextEvictable = this.f13862a.getNextEvictable();
            if (nextEvictable == this.f13862a) {
                return null;
            }
            return nextEvictable;
        }

        @Override // java.util.Queue
        public i<K, V> poll() {
            i<K, V> nextEvictable = this.f13862a.getNextEvictable();
            if (nextEvictable == this.f13862a) {
                return null;
            }
            remove(nextEvictable);
            return nextEvictable;
        }
    }

    static final class e<K, V> extends AbstractQueue<i<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final i<K, V> f13863a = new C2244ca(this);

        e() {
        }

        @Override // java.util.Queue
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean offer(i<K, V> iVar) {
            MapMakerInternalMap.connectExpirables(iVar.getPreviousExpirable(), iVar.getNextExpirable());
            MapMakerInternalMap.connectExpirables(this.f13863a.getPreviousExpirable(), iVar);
            MapMakerInternalMap.connectExpirables(iVar, this.f13863a);
            return true;
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            i<K, V> nextExpirable = this.f13863a.getNextExpirable();
            while (true) {
                i<K, V> iVar = this.f13863a;
                if (nextExpirable == iVar) {
                    iVar.setNextExpirable(iVar);
                    i<K, V> iVar2 = this.f13863a;
                    iVar2.setPreviousExpirable(iVar2);
                    return;
                } else {
                    i<K, V> nextExpirable2 = nextExpirable.getNextExpirable();
                    MapMakerInternalMap.nullifyExpirable(nextExpirable);
                    nextExpirable = nextExpirable2;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return ((i) obj).getNextExpirable() != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f13863a.getNextExpirable() == this.f13863a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<i<K, V>> iterator() {
            return new C2246da(this, peek());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            i iVar = (i) obj;
            i<K, V> previousExpirable = iVar.getPreviousExpirable();
            i<K, V> nextExpirable = iVar.getNextExpirable();
            MapMakerInternalMap.connectExpirables(previousExpirable, nextExpirable);
            MapMakerInternalMap.nullifyExpirable(iVar);
            return nextExpirable != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            int i = 0;
            for (i<K, V> nextExpirable = this.f13863a.getNextExpirable(); nextExpirable != this.f13863a; nextExpirable = nextExpirable.getNextExpirable()) {
                i++;
            }
            return i;
        }

        @Override // java.util.Queue
        public i<K, V> peek() {
            i<K, V> nextExpirable = this.f13863a.getNextExpirable();
            if (nextExpirable == this.f13863a) {
                return null;
            }
            return nextExpirable;
        }

        @Override // java.util.Queue
        public i<K, V> poll() {
            i<K, V> nextExpirable = this.f13863a.getNextExpirable();
            if (nextExpirable == this.f13863a) {
                return null;
            }
            remove(nextExpirable);
            return nextExpirable;
        }
    }

    final class g extends MapMakerInternalMap<K, V>.f<K> {
        g() {
            super();
        }

        @Override // java.util.Iterator
        public K next() {
            return b().getKey();
        }
    }

    final class h extends j<K> {
        h() {
            super(null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return MapMakerInternalMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new g();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return MapMakerInternalMap.this.remove(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return MapMakerInternalMap.this.size();
        }
    }

    interface i<K, V> {
        long getExpirationTime();

        int getHash();

        K getKey();

        i<K, V> getNext();

        i<K, V> getNextEvictable();

        i<K, V> getNextExpirable();

        i<K, V> getPreviousEvictable();

        i<K, V> getPreviousExpirable();

        r<K, V> getValueReference();

        void setExpirationTime(long j);

        void setNextEvictable(i<K, V> iVar);

        void setNextExpirable(i<K, V> iVar);

        void setPreviousEvictable(i<K, V> iVar);

        void setPreviousExpirable(i<K, V> iVar);

        void setValueReference(r<K, V> rVar);
    }

    private static abstract class j<E> extends AbstractSet<E> {
        private j() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return MapMakerInternalMap.toArrayList(this).toArray();
        }

        /* synthetic */ j(Y y) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <E> E[] toArray(E[] eArr) {
            return (E[]) MapMakerInternalMap.toArrayList(this).toArray(eArr);
        }
    }

    static final class k<K, V> extends SoftReference<V> implements r<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final i<K, V> f13871a;

        k(ReferenceQueue<V> referenceQueue, V v, i<K, V> iVar) {
            super(v, referenceQueue);
            this.f13871a = iVar;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.r
        public i<K, V> a() {
            return this.f13871a;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.r
        public boolean b() {
            return false;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.r
        public V c() {
            return get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.r
        public void a(r<K, V> rVar) {
            clear();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.r
        public r<K, V> a(ReferenceQueue<V> referenceQueue, V v, i<K, V> iVar) {
            return new k(referenceQueue, v, iVar);
        }
    }

    static class l<K, V> implements i<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final K f13872a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f13873b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final i<K, V> f13874c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        volatile r<K, V> f13875d = MapMakerInternalMap.unset();

        l(K k, int i, i<K, V> iVar) {
            this.f13872a = k;
            this.f13873b = i;
            this.f13874c = iVar;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public long getExpirationTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public int getHash() {
            return this.f13873b;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public K getKey() {
            return this.f13872a;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getNext() {
            return this.f13874c;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getNextEvictable() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getNextExpirable() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getPreviousEvictable() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getPreviousExpirable() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public r<K, V> getValueReference() {
            return this.f13875d;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public void setExpirationTime(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public void setNextEvictable(i<K, V> iVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public void setNextExpirable(i<K, V> iVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public void setPreviousEvictable(i<K, V> iVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public void setPreviousExpirable(i<K, V> iVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public void setValueReference(r<K, V> rVar) {
            r<K, V> rVar2 = this.f13875d;
            this.f13875d = rVar;
            rVar2.a(rVar);
        }
    }

    static final class m<K, V> extends l<K, V> implements i<K, V> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        i<K, V> f13876e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        i<K, V> f13877f;

        m(K k, int i, i<K, V> iVar) {
            super(k, i, iVar);
            this.f13876e = MapMakerInternalMap.nullEntry();
            this.f13877f = MapMakerInternalMap.nullEntry();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.l, com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getNextEvictable() {
            return this.f13876e;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.l, com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getPreviousEvictable() {
            return this.f13877f;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.l, com.google.common.collect.MapMakerInternalMap.i
        public void setNextEvictable(i<K, V> iVar) {
            this.f13876e = iVar;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.l, com.google.common.collect.MapMakerInternalMap.i
        public void setPreviousEvictable(i<K, V> iVar) {
            this.f13877f = iVar;
        }
    }

    static final class n<K, V> extends l<K, V> implements i<K, V> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        volatile long f13878e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        i<K, V> f13879f;
        i<K, V> g;

        n(K k, int i, i<K, V> iVar) {
            super(k, i, iVar);
            this.f13878e = Long.MAX_VALUE;
            this.f13879f = MapMakerInternalMap.nullEntry();
            this.g = MapMakerInternalMap.nullEntry();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.l, com.google.common.collect.MapMakerInternalMap.i
        public long getExpirationTime() {
            return this.f13878e;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.l, com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getNextExpirable() {
            return this.f13879f;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.l, com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getPreviousExpirable() {
            return this.g;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.l, com.google.common.collect.MapMakerInternalMap.i
        public void setExpirationTime(long j) {
            this.f13878e = j;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.l, com.google.common.collect.MapMakerInternalMap.i
        public void setNextExpirable(i<K, V> iVar) {
            this.f13879f = iVar;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.l, com.google.common.collect.MapMakerInternalMap.i
        public void setPreviousExpirable(i<K, V> iVar) {
            this.g = iVar;
        }
    }

    static final class o<K, V> extends l<K, V> implements i<K, V> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        volatile long f13880e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        i<K, V> f13881f;
        i<K, V> g;
        i<K, V> h;
        i<K, V> i;

        o(K k, int i, i<K, V> iVar) {
            super(k, i, iVar);
            this.f13880e = Long.MAX_VALUE;
            this.f13881f = MapMakerInternalMap.nullEntry();
            this.g = MapMakerInternalMap.nullEntry();
            this.h = MapMakerInternalMap.nullEntry();
            this.i = MapMakerInternalMap.nullEntry();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.l, com.google.common.collect.MapMakerInternalMap.i
        public long getExpirationTime() {
            return this.f13880e;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.l, com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getNextEvictable() {
            return this.h;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.l, com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getNextExpirable() {
            return this.f13881f;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.l, com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getPreviousEvictable() {
            return this.i;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.l, com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getPreviousExpirable() {
            return this.g;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.l, com.google.common.collect.MapMakerInternalMap.i
        public void setExpirationTime(long j) {
            this.f13880e = j;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.l, com.google.common.collect.MapMakerInternalMap.i
        public void setNextEvictable(i<K, V> iVar) {
            this.h = iVar;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.l, com.google.common.collect.MapMakerInternalMap.i
        public void setNextExpirable(i<K, V> iVar) {
            this.f13881f = iVar;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.l, com.google.common.collect.MapMakerInternalMap.i
        public void setPreviousEvictable(i<K, V> iVar) {
            this.i = iVar;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.l, com.google.common.collect.MapMakerInternalMap.i
        public void setPreviousExpirable(i<K, V> iVar) {
            this.g = iVar;
        }
    }

    static final class p<K, V> implements r<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final V f13882a;

        p(V v) {
            this.f13882a = v;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.r
        public i<K, V> a() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.r
        public r<K, V> a(ReferenceQueue<V> referenceQueue, V v, i<K, V> iVar) {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.r
        public void a(r<K, V> rVar) {
        }

        @Override // com.google.common.collect.MapMakerInternalMap.r
        public boolean b() {
            return false;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.r
        public V c() {
            return get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.r
        public V get() {
            return this.f13882a;
        }
    }

    final class q extends MapMakerInternalMap<K, V>.f<V> {
        q() {
            super();
        }

        @Override // java.util.Iterator
        public V next() {
            return b().getValue();
        }
    }

    interface r<K, V> {
        i<K, V> a();

        r<K, V> a(ReferenceQueue<V> referenceQueue, V v, i<K, V> iVar);

        void a(r<K, V> rVar);

        boolean b();

        V c() throws ExecutionException;

        V get();
    }

    final class s extends AbstractCollection<V> {
        s() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return MapMakerInternalMap.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new q();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return MapMakerInternalMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return MapMakerInternalMap.toArrayList(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <E> E[] toArray(E[] eArr) {
            return (E[]) MapMakerInternalMap.toArrayList(this).toArray(eArr);
        }
    }

    static class t<K, V> extends WeakReference<K> implements i<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f13884a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final i<K, V> f13885b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        volatile r<K, V> f13886c;

        t(ReferenceQueue<K> referenceQueue, K k, int i, i<K, V> iVar) {
            super(k, referenceQueue);
            this.f13886c = MapMakerInternalMap.unset();
            this.f13884a = i;
            this.f13885b = iVar;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public long getExpirationTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public int getHash() {
            return this.f13884a;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public K getKey() {
            return get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getNext() {
            return this.f13885b;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getNextEvictable() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getNextExpirable() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getPreviousEvictable() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getPreviousExpirable() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public r<K, V> getValueReference() {
            return this.f13886c;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public void setExpirationTime(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public void setNextEvictable(i<K, V> iVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public void setNextExpirable(i<K, V> iVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public void setPreviousEvictable(i<K, V> iVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public void setPreviousExpirable(i<K, V> iVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public void setValueReference(r<K, V> rVar) {
            r<K, V> rVar2 = this.f13886c;
            this.f13886c = rVar;
            rVar2.a(rVar);
        }
    }

    static final class u<K, V> extends t<K, V> implements i<K, V> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        i<K, V> f13887d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        i<K, V> f13888e;

        u(ReferenceQueue<K> referenceQueue, K k, int i, i<K, V> iVar) {
            super(referenceQueue, k, i, iVar);
            this.f13887d = MapMakerInternalMap.nullEntry();
            this.f13888e = MapMakerInternalMap.nullEntry();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.t, com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getNextEvictable() {
            return this.f13887d;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.t, com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getPreviousEvictable() {
            return this.f13888e;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.t, com.google.common.collect.MapMakerInternalMap.i
        public void setNextEvictable(i<K, V> iVar) {
            this.f13887d = iVar;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.t, com.google.common.collect.MapMakerInternalMap.i
        public void setPreviousEvictable(i<K, V> iVar) {
            this.f13888e = iVar;
        }
    }

    static final class v<K, V> extends t<K, V> implements i<K, V> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        volatile long f13889d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        i<K, V> f13890e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        i<K, V> f13891f;

        v(ReferenceQueue<K> referenceQueue, K k, int i, i<K, V> iVar) {
            super(referenceQueue, k, i, iVar);
            this.f13889d = Long.MAX_VALUE;
            this.f13890e = MapMakerInternalMap.nullEntry();
            this.f13891f = MapMakerInternalMap.nullEntry();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.t, com.google.common.collect.MapMakerInternalMap.i
        public long getExpirationTime() {
            return this.f13889d;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.t, com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getNextExpirable() {
            return this.f13890e;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.t, com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getPreviousExpirable() {
            return this.f13891f;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.t, com.google.common.collect.MapMakerInternalMap.i
        public void setExpirationTime(long j) {
            this.f13889d = j;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.t, com.google.common.collect.MapMakerInternalMap.i
        public void setNextExpirable(i<K, V> iVar) {
            this.f13890e = iVar;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.t, com.google.common.collect.MapMakerInternalMap.i
        public void setPreviousExpirable(i<K, V> iVar) {
            this.f13891f = iVar;
        }
    }

    static final class w<K, V> extends t<K, V> implements i<K, V> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        volatile long f13892d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        i<K, V> f13893e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        i<K, V> f13894f;
        i<K, V> g;
        i<K, V> h;

        w(ReferenceQueue<K> referenceQueue, K k, int i, i<K, V> iVar) {
            super(referenceQueue, k, i, iVar);
            this.f13892d = Long.MAX_VALUE;
            this.f13893e = MapMakerInternalMap.nullEntry();
            this.f13894f = MapMakerInternalMap.nullEntry();
            this.g = MapMakerInternalMap.nullEntry();
            this.h = MapMakerInternalMap.nullEntry();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.t, com.google.common.collect.MapMakerInternalMap.i
        public long getExpirationTime() {
            return this.f13892d;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.t, com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getNextEvictable() {
            return this.g;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.t, com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getNextExpirable() {
            return this.f13893e;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.t, com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getPreviousEvictable() {
            return this.h;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.t, com.google.common.collect.MapMakerInternalMap.i
        public i<K, V> getPreviousExpirable() {
            return this.f13894f;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.t, com.google.common.collect.MapMakerInternalMap.i
        public void setExpirationTime(long j) {
            this.f13892d = j;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.t, com.google.common.collect.MapMakerInternalMap.i
        public void setNextEvictable(i<K, V> iVar) {
            this.g = iVar;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.t, com.google.common.collect.MapMakerInternalMap.i
        public void setNextExpirable(i<K, V> iVar) {
            this.f13893e = iVar;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.t, com.google.common.collect.MapMakerInternalMap.i
        public void setPreviousEvictable(i<K, V> iVar) {
            this.h = iVar;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.t, com.google.common.collect.MapMakerInternalMap.i
        public void setPreviousExpirable(i<K, V> iVar) {
            this.f13894f = iVar;
        }
    }

    static final class x<K, V> extends WeakReference<V> implements r<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final i<K, V> f13895a;

        x(ReferenceQueue<V> referenceQueue, V v, i<K, V> iVar) {
            super(v, referenceQueue);
            this.f13895a = iVar;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.r
        public i<K, V> a() {
            return this.f13895a;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.r
        public boolean b() {
            return false;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.r
        public V c() {
            return get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.r
        public void a(r<K, V> rVar) {
            clear();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.r
        public r<K, V> a(ReferenceQueue<V> referenceQueue, V v, i<K, V> iVar) {
            return new x(referenceQueue, v, iVar);
        }
    }

    final class y extends AbstractC2253h<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final K f13896a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        V f13897b;

        y(K k, V v) {
            this.f13896a = k;
            this.f13897b = v;
        }

        @Override // com.google.common.collect.AbstractC2253h, java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.f13896a.equals(entry.getKey()) && this.f13897b.equals(entry.getValue());
        }

        @Override // com.google.common.collect.AbstractC2253h, java.util.Map.Entry
        public K getKey() {
            return this.f13896a;
        }

        @Override // com.google.common.collect.AbstractC2253h, java.util.Map.Entry
        public V getValue() {
            return this.f13897b;
        }

        @Override // com.google.common.collect.AbstractC2253h, java.util.Map.Entry
        public int hashCode() {
            return this.f13896a.hashCode() ^ this.f13897b.hashCode();
        }

        @Override // com.google.common.collect.AbstractC2253h, java.util.Map.Entry
        public V setValue(V v) {
            V v2 = (V) MapMakerInternalMap.this.put(this.f13896a, v);
            this.f13897b = v;
            return v2;
        }
    }

    MapMakerInternalMap(MapMaker mapMaker) {
        this.concurrencyLevel = Math.min(mapMaker.b(), 65536);
        this.keyStrength = mapMaker.g();
        this.valueStrength = mapMaker.i();
        this.keyEquivalence = mapMaker.f();
        this.valueEquivalence = this.valueStrength.defaultEquivalence();
        this.maximumSize = mapMaker.f13859e;
        this.expireAfterAccessNanos = mapMaker.c();
        this.expireAfterWriteNanos = mapMaker.d();
        this.entryFactory = EntryFactory.getFactory(this.keyStrength, expires(), evictsBySize());
        this.ticker = mapMaker.h();
        this.removalListener = mapMaker.a();
        this.removalNotificationQueue = this.removalListener == GenericMapMaker.NullListener.INSTANCE ? discardingQueue() : new ConcurrentLinkedQueue<>();
        int iMin = Math.min(mapMaker.e(), 1073741824);
        iMin = evictsBySize() ? Math.min(iMin, this.maximumSize) : iMin;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i3 < this.concurrencyLevel && (!evictsBySize() || i3 * 2 <= this.maximumSize)) {
            i4++;
            i3 <<= 1;
        }
        this.segmentShift = 32 - i4;
        this.segmentMask = i3 - 1;
        this.segments = newSegmentArray(i3);
        int i5 = iMin / i3;
        i5 = i5 * i3 < iMin ? i5 + 1 : i5;
        int i6 = 1;
        while (i6 < i5) {
            i6 <<= 1;
        }
        if (evictsBySize()) {
            int i7 = this.maximumSize;
            int i8 = (i7 / i3) + 1;
            int i9 = i7 % i3;
            while (i2 < this.segments.length) {
                if (i2 == i9) {
                    i8--;
                }
                this.segments[i2] = createSegment(i6, i8);
                i2++;
            }
            return;
        }
        while (true) {
            Segment<K, V>[] segmentArr = this.segments;
            if (i2 >= segmentArr.length) {
                return;
            }
            segmentArr[i2] = createSegment(i6, -1);
            i2++;
        }
    }

    static <K, V> void connectEvictables(i<K, V> iVar, i<K, V> iVar2) {
        iVar.setNextEvictable(iVar2);
        iVar2.setPreviousEvictable(iVar);
    }

    static <K, V> void connectExpirables(i<K, V> iVar, i<K, V> iVar2) {
        iVar.setNextExpirable(iVar2);
        iVar2.setPreviousExpirable(iVar);
    }

    static <E> Queue<E> discardingQueue() {
        return (Queue<E>) DISCARDING_QUEUE;
    }

    static <K, V> i<K, V> nullEntry() {
        return NullEntry.INSTANCE;
    }

    static <K, V> void nullifyEvictable(i<K, V> iVar) {
        i<K, V> iVarNullEntry = nullEntry();
        iVar.setNextEvictable(iVarNullEntry);
        iVar.setPreviousEvictable(iVarNullEntry);
    }

    static <K, V> void nullifyExpirable(i<K, V> iVar) {
        i<K, V> iVarNullEntry = nullEntry();
        iVar.setNextExpirable(iVarNullEntry);
        iVar.setPreviousExpirable(iVarNullEntry);
    }

    static int rehash(int i2) {
        int i3 = i2 + ((i2 << 15) ^ (-12931));
        int i4 = i3 ^ (i3 >>> 10);
        int i5 = i4 + (i4 << 3);
        int i6 = i5 ^ (i5 >>> 6);
        int i7 = i6 + (i6 << 2) + (i6 << 14);
        return i7 ^ (i7 >>> 16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> ArrayList<E> toArrayList(Collection<E> collection) {
        ArrayList<E> arrayList = new ArrayList<>(collection.size());
        V.a(arrayList, collection.iterator());
        return arrayList;
    }

    static <K, V> r<K, V> unset() {
        return (r<K, V>) UNSET;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (Segment<K, V> segment : this.segments) {
            segment.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (obj == null) {
            return false;
        }
        int iHash = hash(obj);
        return segmentFor(iHash).containsKey(obj, iHash);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        if (obj == null) {
            return false;
        }
        Segment<K, V>[] segmentArr = this.segments;
        long j2 = -1;
        int i2 = 0;
        while (i2 < 3) {
            long j3 = 0;
            for (Segment<K, V> segment : segmentArr) {
                int i3 = segment.count;
                AtomicReferenceArray<i<K, V>> atomicReferenceArray = segment.table;
                for (int i4 = 0; i4 < atomicReferenceArray.length(); i4++) {
                    for (i<K, V> next = atomicReferenceArray.get(i4); next != null; next = next.getNext()) {
                        V liveValue = segment.getLiveValue(next);
                        if (liveValue != null && this.valueEquivalence.equivalent(obj, liveValue)) {
                            return true;
                        }
                    }
                }
                j3 += (long) segment.modCount;
            }
            if (j3 == j2) {
                return false;
            }
            i2++;
            j2 = j3;
        }
        return false;
    }

    i<K, V> copyEntry(i<K, V> iVar, i<K, V> iVar2) {
        return segmentFor(iVar.getHash()).copyEntry(iVar, iVar2);
    }

    Segment<K, V> createSegment(int i2, int i3) {
        return new Segment<>(this, i2, i3);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        c cVar = new c();
        this.entrySet = cVar;
        return cVar;
    }

    boolean evictsBySize() {
        return this.maximumSize != -1;
    }

    boolean expires() {
        return expiresAfterWrite() || expiresAfterAccess();
    }

    boolean expiresAfterAccess() {
        return this.expireAfterAccessNanos > 0;
    }

    boolean expiresAfterWrite() {
        return this.expireAfterWriteNanos > 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        if (obj == null) {
            return null;
        }
        int iHash = hash(obj);
        return segmentFor(iHash).get(obj, iHash);
    }

    i<K, V> getEntry(Object obj) {
        if (obj == null) {
            return null;
        }
        int iHash = hash(obj);
        return segmentFor(iHash).getEntry(obj, iHash);
    }

    V getLiveValue(i<K, V> iVar) {
        V v2;
        if (iVar.getKey() == null || (v2 = iVar.getValueReference().get()) == null) {
            return null;
        }
        if (expires() && isExpired(iVar)) {
            return null;
        }
        return v2;
    }

    int hash(Object obj) {
        return rehash(this.keyEquivalence.hash(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        Segment<K, V>[] segmentArr = this.segments;
        long j2 = 0;
        for (int i2 = 0; i2 < segmentArr.length; i2++) {
            if (segmentArr[i2].count != 0) {
                return false;
            }
            j2 += (long) segmentArr[i2].modCount;
        }
        if (j2 == 0) {
            return true;
        }
        for (int i3 = 0; i3 < segmentArr.length; i3++) {
            if (segmentArr[i3].count != 0) {
                return false;
            }
            j2 -= (long) segmentArr[i3].modCount;
        }
        return j2 == 0;
    }

    boolean isExpired(i<K, V> iVar) {
        return isExpired(iVar, this.ticker.a());
    }

    boolean isLive(i<K, V> iVar) {
        return segmentFor(iVar.getHash()).getLiveValue(iVar) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        h hVar = new h();
        this.keySet = hVar;
        return hVar;
    }

    i<K, V> newEntry(K k2, int i2, i<K, V> iVar) {
        return segmentFor(i2).newEntry(k2, i2, iVar);
    }

    final Segment<K, V>[] newSegmentArray(int i2) {
        return new Segment[i2];
    }

    r<K, V> newValueReference(i<K, V> iVar, V v2) {
        return this.valueStrength.referenceValue(segmentFor(iVar.getHash()), iVar, v2);
    }

    void processPendingNotifications() {
        while (true) {
            MapMaker.RemovalNotification<K, V> removalNotificationPoll = this.removalNotificationQueue.poll();
            if (removalNotificationPoll == null) {
                return;
            }
            try {
                this.removalListener.onRemoval(removalNotificationPoll);
            } catch (Exception e2) {
                logger.log(Level.WARNING, "Exception thrown by removal listener", (Throwable) e2);
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k2, V v2) {
        com.google.common.base.m.a(k2);
        com.google.common.base.m.a(v2);
        int iHash = hash(k2);
        return segmentFor(iHash).put(k2, iHash, v2, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V putIfAbsent(K k2, V v2) {
        com.google.common.base.m.a(k2);
        com.google.common.base.m.a(v2);
        int iHash = hash(k2);
        return segmentFor(iHash).put(k2, iHash, v2, true);
    }

    void reclaimKey(i<K, V> iVar) {
        int hash = iVar.getHash();
        segmentFor(hash).reclaimKey(iVar, hash);
    }

    void reclaimValue(r<K, V> rVar) {
        i<K, V> iVarA = rVar.a();
        int hash = iVarA.getHash();
        segmentFor(hash).reclaimValue(iVarA.getKey(), hash, rVar);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        if (obj == null) {
            return null;
        }
        int iHash = hash(obj);
        return segmentFor(iHash).remove(obj, iHash);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K k2, V v2, V v3) {
        com.google.common.base.m.a(k2);
        com.google.common.base.m.a(v3);
        if (v2 == null) {
            return false;
        }
        int iHash = hash(k2);
        return segmentFor(iHash).replace(k2, iHash, v2, v3);
    }

    Segment<K, V> segmentFor(int i2) {
        return this.segments[(i2 >>> this.segmentShift) & this.segmentMask];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        long j2 = 0;
        for (Segment<K, V> segment : this.segments) {
            j2 += (long) segment.count;
        }
        return b.c.b.b.a.a(j2);
    }

    boolean usesKeyReferences() {
        return this.keyStrength != Strength.STRONG;
    }

    boolean usesValueReferences() {
        return this.valueStrength != Strength.STRONG;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.values;
        if (collection != null) {
            return collection;
        }
        s sVar = new s();
        this.values = sVar;
        return sVar;
    }

    Object writeReplace() {
        return new SerializationProxy(this.keyStrength, this.valueStrength, this.keyEquivalence, this.valueEquivalence, this.expireAfterWriteNanos, this.expireAfterAccessNanos, this.maximumSize, this.concurrencyLevel, this.removalListener, this);
    }

    static abstract class AbstractSerializationProxy<K, V> extends AbstractConcurrentMapC2264t<K, V> implements Serializable {
        private static final long serialVersionUID = 3;
        final int concurrencyLevel;
        transient ConcurrentMap<K, V> delegate;
        final long expireAfterAccessNanos;
        final long expireAfterWriteNanos;
        final Equivalence<Object> keyEquivalence;
        final Strength keyStrength;
        final int maximumSize;
        final MapMaker.a<? super K, ? super V> removalListener;
        final Equivalence<Object> valueEquivalence;
        final Strength valueStrength;

        AbstractSerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, long j, long j2, int i, int i2, MapMaker.a<? super K, ? super V> aVar, ConcurrentMap<K, V> concurrentMap) {
            this.keyStrength = strength;
            this.valueStrength = strength2;
            this.keyEquivalence = equivalence;
            this.valueEquivalence = equivalence2;
            this.expireAfterWriteNanos = j;
            this.expireAfterAccessNanos = j2;
            this.maximumSize = i;
            this.concurrencyLevel = i2;
            this.removalListener = aVar;
            this.delegate = concurrentMap;
        }

        void readEntries(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            while (true) {
                Object object = objectInputStream.readObject();
                if (object == null) {
                    return;
                }
                this.delegate.put((K) object, (V) objectInputStream.readObject());
            }
        }

        MapMaker readMapMaker(ObjectInputStream objectInputStream) throws IOException {
            int i = objectInputStream.readInt();
            MapMaker mapMaker = new MapMaker();
            mapMaker.b(i);
            mapMaker.a(this.keyStrength);
            mapMaker.b(this.valueStrength);
            mapMaker.a(this.keyEquivalence);
            mapMaker.a(this.concurrencyLevel);
            mapMaker.a(this.removalListener);
            long j = this.expireAfterWriteNanos;
            if (j > 0) {
                mapMaker.b(j, TimeUnit.NANOSECONDS);
            }
            long j2 = this.expireAfterAccessNanos;
            if (j2 > 0) {
                mapMaker.a(j2, TimeUnit.NANOSECONDS);
            }
            int i2 = this.maximumSize;
            if (i2 != -1) {
                mapMaker.c(i2);
            }
            return mapMaker;
        }

        void writeMapTo(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeInt(this.delegate.size());
            for (Map.Entry<K, V> entry : this.delegate.entrySet()) {
                objectOutputStream.writeObject(entry.getKey());
                objectOutputStream.writeObject(entry.getValue());
            }
            objectOutputStream.writeObject(null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.AbstractConcurrentMapC2264t, com.google.common.collect.AbstractC2265u, com.google.common.collect.AbstractC2266v
        public ConcurrentMap<K, V> delegate() {
            return this.delegate;
        }
    }

    boolean isExpired(i<K, V> iVar, long j2) {
        return j2 - iVar.getExpirationTime() > 0;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int iHash = hash(obj);
        return segmentFor(iHash).remove(obj, iHash, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V replace(K k2, V v2) {
        com.google.common.base.m.a(k2);
        com.google.common.base.m.a(v2);
        int iHash = hash(k2);
        return segmentFor(iHash).replace(k2, iHash, v2);
    }

    abstract class f<E> implements Iterator<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f13864a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f13865b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Segment<K, V> f13866c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        AtomicReferenceArray<i<K, V>> f13867d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        i<K, V> f13868e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        MapMakerInternalMap<K, V>.y f13869f;
        MapMakerInternalMap<K, V>.y g;

        f() {
            this.f13864a = MapMakerInternalMap.this.segments.length - 1;
            a();
        }

        final void a() {
            this.f13869f = null;
            if (c() || d()) {
                return;
            }
            while (true) {
                int i = this.f13864a;
                if (i < 0) {
                    return;
                }
                Segment<K, V>[] segmentArr = MapMakerInternalMap.this.segments;
                this.f13864a = i - 1;
                this.f13866c = segmentArr[i];
                if (this.f13866c.count != 0) {
                    this.f13867d = this.f13866c.table;
                    this.f13865b = this.f13867d.length() - 1;
                    if (d()) {
                        return;
                    }
                }
            }
        }

        MapMakerInternalMap<K, V>.y b() {
            MapMakerInternalMap<K, V>.y yVar = this.f13869f;
            if (yVar == null) {
                throw new NoSuchElementException();
            }
            this.g = yVar;
            a();
            return this.g;
        }

        boolean c() {
            i<K, V> iVar = this.f13868e;
            if (iVar == null) {
                return false;
            }
            while (true) {
                this.f13868e = iVar.getNext();
                i<K, V> iVar2 = this.f13868e;
                if (iVar2 == null) {
                    return false;
                }
                if (a(iVar2)) {
                    return true;
                }
                iVar = this.f13868e;
            }
        }

        boolean d() {
            while (true) {
                int i = this.f13865b;
                if (i < 0) {
                    return false;
                }
                AtomicReferenceArray<i<K, V>> atomicReferenceArray = this.f13867d;
                this.f13865b = i - 1;
                i<K, V> iVar = atomicReferenceArray.get(i);
                this.f13868e = iVar;
                if (iVar != null && (a(this.f13868e) || c())) {
                    return true;
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f13869f != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            C2259n.a(this.g != null);
            MapMakerInternalMap.this.remove(this.g.getKey());
            this.g = null;
        }

        boolean a(i<K, V> iVar) {
            boolean z;
            try {
                K key = iVar.getKey();
                Object liveValue = MapMakerInternalMap.this.getLiveValue(iVar);
                if (liveValue != null) {
                    this.f13869f = new y(key, liveValue);
                    z = true;
                } else {
                    z = false;
                }
                return z;
            } finally {
                this.f13866c.postReadCleanup();
            }
        }
    }
}
