package io.rong.imlib.common;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public class WeakValueHashMap extends AbstractMap implements Map {
    private Map hash;
    private ReferenceQueue queue;

    private static class WeakValueRef extends WeakReference {
        public Object key;

        private WeakValueRef(Object obj, Object obj2, ReferenceQueue referenceQueue) {
            super(obj2, referenceQueue);
            this.key = obj;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static WeakValueRef create(Object obj, Object obj2, ReferenceQueue referenceQueue) {
            if (obj2 == null) {
                return null;
            }
            return new WeakValueRef(obj, obj2, referenceQueue);
        }
    }

    public WeakValueHashMap(int i, float f2) {
        this.queue = new ReferenceQueue();
        this.hash = new HashMap(i, f2);
    }

    private void processQueue() {
        while (true) {
            WeakValueRef weakValueRef = (WeakValueRef) this.queue.poll();
            if (weakValueRef == null) {
                return;
            }
            if (weakValueRef == ((WeakValueRef) this.hash.get(weakValueRef.key))) {
                this.hash.remove(weakValueRef.key);
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        processQueue();
        this.hash.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        processQueue();
        return this.hash.containsKey(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        processQueue();
        return this.hash.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        processQueue();
        WeakReference weakReference = (WeakReference) this.hash.get(obj);
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        processQueue();
        return this.hash.isEmpty();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        processQueue();
        Object objPut = this.hash.put(obj, WeakValueRef.create(obj, obj2, this.queue));
        return objPut != null ? ((WeakReference) objPut).get() : objPut;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        processQueue();
        return this.hash.remove(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        processQueue();
        return this.hash.size();
    }

    public WeakValueHashMap(int i) {
        this.queue = new ReferenceQueue();
        this.hash = new HashMap(i);
    }

    public WeakValueHashMap() {
        this.queue = new ReferenceQueue();
        this.hash = new HashMap();
    }

    public WeakValueHashMap(Map map) {
        this(Math.max(map.size() * 2, 11), 0.75f);
        putAll(map);
    }
}
