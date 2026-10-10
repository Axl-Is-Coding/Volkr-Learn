package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.collect.MapMaker;
import com.google.common.collect.MapMakerInternalMap;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes2.dex */
class ComputingConcurrentHashMap<K, V> extends MapMakerInternalMap<K, V> {
    private static final long serialVersionUID = 4;
    final com.google.common.base.f<? super K, ? extends V> computingFunction;

    static final class ComputingSegment<K, V> extends MapMakerInternalMap.Segment<K, V> {
        ComputingSegment(MapMakerInternalMap<K, V> mapMakerInternalMap, int i, int i2) {
            super(mapMakerInternalMap, i, i2);
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x0039  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x003e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        V compute(K r7, int r8, com.google.common.collect.MapMakerInternalMap.i<K, V> r9, com.google.common.collect.ComputingConcurrentHashMap.c<K, V> r10) throws java.lang.Throwable {
            /*
                r6 = this;
                java.lang.System.nanoTime()
                r0 = 0
                r2 = 0
                monitor-enter(r9)     // Catch: java.lang.Throwable -> L33
                java.lang.Object r2 = r10.a(r7, r8)     // Catch: java.lang.Throwable -> L2b
                long r3 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L2b
                monitor-exit(r9)     // Catch: java.lang.Throwable -> L31
                if (r2 == 0) goto L1e
                r9 = 1
                java.lang.Object r9 = r6.put(r7, r8, r2, r9)     // Catch: java.lang.Throwable -> L2f
                if (r9 == 0) goto L1e
                com.google.common.collect.MapMaker$RemovalCause r9 = com.google.common.collect.MapMaker.RemovalCause.REPLACED     // Catch: java.lang.Throwable -> L2f
                r6.enqueueNotification(r7, r8, r2, r9)     // Catch: java.lang.Throwable -> L2f
            L1e:
                int r9 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
                if (r9 != 0) goto L25
                java.lang.System.nanoTime()
            L25:
                if (r2 != 0) goto L2a
                r6.clearValue(r7, r8, r10)
            L2a:
                return r2
            L2b:
                r5 = move-exception
                r3 = r0
            L2d:
                monitor-exit(r9)     // Catch: java.lang.Throwable -> L31
                throw r5     // Catch: java.lang.Throwable -> L2f
            L2f:
                r9 = move-exception
                goto L35
            L31:
                r5 = move-exception
                goto L2d
            L33:
                r9 = move-exception
                r3 = r0
            L35:
                int r5 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
                if (r5 != 0) goto L3c
                java.lang.System.nanoTime()
            L3c:
                if (r2 != 0) goto L41
                r6.clearValue(r7, r8, r10)
            L41:
                goto L43
            L42:
                throw r9
            L43:
                goto L42
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.ComputingConcurrentHashMap.ComputingSegment.compute(java.lang.Object, int, com.google.common.collect.MapMakerInternalMap$i, com.google.common.collect.ComputingConcurrentHashMap$c):java.lang.Object");
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x005a, code lost:
        
            if (r7.getValueReference().b() == false) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x005c, code lost:
        
            r3 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x005e, code lost:
        
            r9 = r7.getValueReference().get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0066, code lost:
        
            if (r9 != null) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0068, code lost:
        
            enqueueNotification(r8, r13, r9, com.google.common.collect.MapMaker.RemovalCause.COLLECTED);
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0074, code lost:
        
            if (r11.map.expires() == false) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x007c, code lost:
        
            if (r11.map.isExpired(r7) == false) goto L70;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x007e, code lost:
        
            enqueueNotification(r8, r13, r9, com.google.common.collect.MapMaker.RemovalCause.EXPIRED);
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0083, code lost:
        
            r11.evictionQueue.remove(r7);
            r11.expirationQueue.remove(r7);
            r11.count = r3;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0090, code lost:
        
            recordLockedRead(r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x009c, code lost:
        
            return r9;
         */
        /* JADX WARN: Removed duplicated region for block: B:71:0x00c6 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        V getOrCompute(K r12, int r13, com.google.common.base.f<? super K, ? extends V> r14) throws java.util.concurrent.ExecutionException {
            /*
                Method dump skipped, instruction units count: 250
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.ComputingConcurrentHashMap.ComputingSegment.getOrCompute(java.lang.Object, int, com.google.common.base.f):java.lang.Object");
        }
    }

    static final class ComputingSerializationProxy<K, V> extends MapMakerInternalMap.AbstractSerializationProxy<K, V> {
        private static final long serialVersionUID = 4;
        final com.google.common.base.f<? super K, ? extends V> computingFunction;

        ComputingSerializationProxy(MapMakerInternalMap.Strength strength, MapMakerInternalMap.Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, long j, long j2, int i, int i2, MapMaker.a<? super K, ? super V> aVar, ConcurrentMap<K, V> concurrentMap, com.google.common.base.f<? super K, ? extends V> fVar) {
            super(strength, strength2, equivalence, equivalence2, j, j2, i, i2, aVar, concurrentMap);
            this.computingFunction = fVar;
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            this.delegate = readMapMaker(objectInputStream).a(this.computingFunction);
            readEntries(objectInputStream);
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            writeMapTo(objectOutputStream);
        }

        Object readResolve() {
            return this.delegate;
        }
    }

    private static final class a<K, V> implements MapMakerInternalMap.r<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Throwable f13814a;

        a(Throwable th) {
            this.f13814a = th;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.r
        public MapMakerInternalMap.i<K, V> a() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.r
        public MapMakerInternalMap.r<K, V> a(ReferenceQueue<V> referenceQueue, V v, MapMakerInternalMap.i<K, V> iVar) {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.r
        public void a(MapMakerInternalMap.r<K, V> rVar) {
        }

        @Override // com.google.common.collect.MapMakerInternalMap.r
        public boolean b() {
            return false;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.r
        public V c() throws ExecutionException {
            throw new ExecutionException(this.f13814a);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.r
        public V get() {
            return null;
        }
    }

    private static final class b<K, V> implements MapMakerInternalMap.r<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final V f13815a;

        b(V v) {
            this.f13815a = v;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.r
        public MapMakerInternalMap.i<K, V> a() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.r
        public MapMakerInternalMap.r<K, V> a(ReferenceQueue<V> referenceQueue, V v, MapMakerInternalMap.i<K, V> iVar) {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.r
        public void a(MapMakerInternalMap.r<K, V> rVar) {
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
            return this.f13815a;
        }
    }

    private static final class c<K, V> implements MapMakerInternalMap.r<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final com.google.common.base.f<? super K, ? extends V> f13816a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        volatile MapMakerInternalMap.r<K, V> f13817b = MapMakerInternalMap.unset();

        public c(com.google.common.base.f<? super K, ? extends V> fVar) {
            this.f13816a = fVar;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.r
        public MapMakerInternalMap.i<K, V> a() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.r
        public MapMakerInternalMap.r<K, V> a(ReferenceQueue<V> referenceQueue, V v, MapMakerInternalMap.i<K, V> iVar) {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.r
        public void a(MapMakerInternalMap.r<K, V> rVar) {
            b(rVar);
        }

        void b(MapMakerInternalMap.r<K, V> rVar) {
            synchronized (this) {
                if (this.f13817b == MapMakerInternalMap.UNSET) {
                    this.f13817b = rVar;
                    notifyAll();
                }
            }
        }

        @Override // com.google.common.collect.MapMakerInternalMap.r
        public boolean b() {
            return true;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.r
        public V c() throws Throwable {
            Throwable th;
            boolean z;
            if (this.f13817b == MapMakerInternalMap.UNSET) {
                try {
                    synchronized (this) {
                        z = false;
                        while (this.f13817b == MapMakerInternalMap.UNSET) {
                            try {
                                try {
                                    wait();
                                } catch (InterruptedException unused) {
                                    z = true;
                                }
                            } catch (Throwable th2) {
                                try {
                                    throw th2;
                                } catch (Throwable th3) {
                                    th = th3;
                                    if (z) {
                                        Thread.currentThread().interrupt();
                                    }
                                    throw th;
                                }
                            }
                        }
                    }
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                } catch (Throwable th4) {
                    th = th4;
                    z = false;
                }
            }
            return this.f13817b.c();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.r
        public V get() {
            return null;
        }

        V a(K k, int i) throws ExecutionException {
            try {
                V vApply = this.f13816a.apply(k);
                b(new b(vApply));
                return vApply;
            } catch (Throwable th) {
                b(new a(th));
                throw new ExecutionException(th);
            }
        }
    }

    ComputingConcurrentHashMap(MapMaker mapMaker, com.google.common.base.f<? super K, ? extends V> fVar) {
        super(mapMaker);
        com.google.common.base.m.a(fVar);
        this.computingFunction = fVar;
    }

    @Override // com.google.common.collect.MapMakerInternalMap
    MapMakerInternalMap.Segment<K, V> createSegment(int i, int i2) {
        return new ComputingSegment(this, i, i2);
    }

    V getOrCompute(K k) throws ExecutionException {
        com.google.common.base.m.a(k);
        int iHash = hash(k);
        return segmentFor(iHash).getOrCompute(k, iHash, this.computingFunction);
    }

    @Override // com.google.common.collect.MapMakerInternalMap
    Object writeReplace() {
        return new ComputingSerializationProxy(this.keyStrength, this.valueStrength, this.keyEquivalence, this.valueEquivalence, this.expireAfterWriteNanos, this.expireAfterAccessNanos, this.maximumSize, this.concurrencyLevel, this.removalListener, this, this.computingFunction);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.MapMakerInternalMap
    public ComputingSegment<K, V> segmentFor(int i) {
        return (ComputingSegment) super.segmentFor(i);
    }
}
