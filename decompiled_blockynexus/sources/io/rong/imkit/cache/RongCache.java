package io.rong.imkit.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class RongCache<K, V> {
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final LinkedHashMap<K, V> map;
    private int maxSize;
    private int missCount;
    private int putCount;
    private int size;

    public RongCache(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.maxSize = i;
        this.map = new LinkedHashMap<>(0, 0.75f, true);
    }

    private int safeSizeOf(K k, V v) {
        int iSizeOf = sizeOf(k, v);
        if (iSizeOf >= 0) {
            return iSizeOf;
        }
        throw new IllegalStateException("Negative size: " + k + "=" + v);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0078, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results! size = " + r5.size);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void trimToSize(int r6) {
        /*
            r5 = this;
        L0:
            monitor-enter(r5)
            int r0 = r5.size     // Catch: java.lang.Throwable -> L79
            if (r0 < 0) goto L55
            java.util.LinkedHashMap<K, V> r0 = r5.map     // Catch: java.lang.Throwable -> L79
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L79
            if (r0 == 0) goto L11
            int r0 = r5.size     // Catch: java.lang.Throwable -> L79
            if (r0 != 0) goto L55
        L11:
            int r0 = r5.size     // Catch: java.lang.Throwable -> L79
            if (r0 > r6) goto L17
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L79
            goto L33
        L17:
            java.util.LinkedHashMap<K, V> r0 = r5.map     // Catch: java.lang.Throwable -> L79
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L79
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L79
            boolean r1 = r0.hasNext()     // Catch: java.lang.Throwable -> L79
            r2 = 0
            if (r1 == 0) goto L2f
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L79
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L79
            goto L30
        L2f:
            r0 = r2
        L30:
            if (r0 != 0) goto L34
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L79
        L33:
            return
        L34:
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L79
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L79
            java.util.LinkedHashMap<K, V> r3 = r5.map     // Catch: java.lang.Throwable -> L79
            r3.remove(r1)     // Catch: java.lang.Throwable -> L79
            int r3 = r5.size     // Catch: java.lang.Throwable -> L79
            int r4 = r5.safeSizeOf(r1, r0)     // Catch: java.lang.Throwable -> L79
            int r3 = r3 - r4
            r5.size = r3     // Catch: java.lang.Throwable -> L79
            int r3 = r5.evictionCount     // Catch: java.lang.Throwable -> L79
            r4 = 1
            int r3 = r3 + r4
            r5.evictionCount = r3     // Catch: java.lang.Throwable -> L79
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L79
            r5.entryRemoved(r4, r1, r0, r2)
            goto L0
        L55:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L79
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L79
            r0.<init>()     // Catch: java.lang.Throwable -> L79
            java.lang.Class r1 = r5.getClass()     // Catch: java.lang.Throwable -> L79
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L79
            r0.append(r1)     // Catch: java.lang.Throwable -> L79
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results! size = "
            r0.append(r1)     // Catch: java.lang.Throwable -> L79
            int r1 = r5.size     // Catch: java.lang.Throwable -> L79
            r0.append(r1)     // Catch: java.lang.Throwable -> L79
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L79
            r6.<init>(r0)     // Catch: java.lang.Throwable -> L79
            throw r6     // Catch: java.lang.Throwable -> L79
        L79:
            r6 = move-exception
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L79
            goto L7d
        L7c:
            throw r6
        L7d:
            goto L7c
        */
        throw new UnsupportedOperationException("Method not decompiled: io.rong.imkit.cache.RongCache.trimToSize(int):void");
    }

    public void clear() {
        synchronized (this) {
            this.map.clear();
            this.size = 0;
        }
        this.putCount = 0;
        this.createCount = 0;
        this.evictionCount = 0;
        this.hitCount = 0;
        this.missCount = 0;
    }

    protected V create(K k) {
        return null;
    }

    public final synchronized int createCount() {
        return this.createCount;
    }

    protected void entryRemoved(boolean z, K k, V v, V v2) {
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final synchronized int evictionCount() {
        return this.evictionCount;
    }

    public final V get(K k) {
        V vPut;
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            V v = this.map.get(k);
            if (v != null) {
                this.hitCount++;
                return v;
            }
            this.missCount++;
            V vCreate = create(k);
            if (vCreate == null) {
                return null;
            }
            synchronized (this) {
                this.createCount++;
                vPut = this.map.put(k, vCreate);
                if (vPut != null) {
                    this.map.put(k, vPut);
                } else {
                    this.size += safeSizeOf(k, vCreate);
                }
            }
            if (vPut != null) {
                entryRemoved(false, k, vCreate, vPut);
                return vPut;
            }
            trimToSize(this.maxSize);
            return vCreate;
        }
    }

    public final synchronized int hitCount() {
        return this.hitCount;
    }

    public final synchronized int maxSize() {
        return this.maxSize;
    }

    public final synchronized int missCount() {
        return this.missCount;
    }

    public final V put(K k, V v) {
        V vPut;
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.putCount++;
            this.size += safeSizeOf(k, v);
            vPut = this.map.put(k, v);
            if (vPut != null) {
                this.size -= safeSizeOf(k, vPut);
            }
        }
        if (vPut != null) {
            entryRemoved(false, k, vPut, v);
        }
        trimToSize(this.maxSize);
        return vPut;
    }

    public final synchronized int putCount() {
        return this.putCount;
    }

    public final V remove(K k) {
        V vRemove;
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            vRemove = this.map.remove(k);
            if (vRemove != null) {
                this.size -= safeSizeOf(k, vRemove);
            }
        }
        if (vRemove != null) {
            entryRemoved(false, k, vRemove, null);
        }
        return vRemove;
    }

    public void resize(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        synchronized (this) {
            this.maxSize = i;
        }
        trimToSize(i);
    }

    public final synchronized int size() {
        return this.size;
    }

    protected int sizeOf(K k, V v) {
        return 1;
    }

    public final synchronized Map<K, V> snapshot() {
        return new LinkedHashMap(this.map);
    }

    public final synchronized String toString() {
        int i;
        i = this.hitCount + this.missCount;
        return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.maxSize), Integer.valueOf(this.hitCount), Integer.valueOf(this.missCount), Integer.valueOf(i != 0 ? (this.hitCount * 100) / i : 0));
    }
}
