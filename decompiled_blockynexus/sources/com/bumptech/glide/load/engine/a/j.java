package com.bumptech.glide.load.engine.a;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: LruArrayPool.java */
/* JADX INFO: loaded from: classes.dex */
public final class j implements com.bumptech.glide.load.engine.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h<a, Object> f4480a = new h<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f4481b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<Class<?>, NavigableMap<Integer, Integer>> f4482c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<Class<?>, com.bumptech.glide.load.engine.a.a<?>> f4483d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f4484e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f4485f;

    /* JADX INFO: compiled from: LruArrayPool.java */
    private static final class a implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b f4486a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f4487b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Class<?> f4488c;

        a(b bVar) {
            this.f4486a = bVar;
        }

        void a(int i, Class<?> cls) {
            this.f4487b = i;
            this.f4488c = cls;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f4487b == aVar.f4487b && this.f4488c == aVar.f4488c;
        }

        public int hashCode() {
            int i = this.f4487b * 31;
            Class<?> cls = this.f4488c;
            return i + (cls != null ? cls.hashCode() : 0);
        }

        @Override // com.bumptech.glide.load.engine.a.m
        public void offer() {
            this.f4486a.a(this);
        }

        public String toString() {
            return "Key{size=" + this.f4487b + "array=" + this.f4488c + '}';
        }
    }

    /* JADX INFO: compiled from: LruArrayPool.java */
    private static final class b extends d<a> {
        b() {
        }

        a a(int i, Class<?> cls) {
            a aVarB = b();
            aVarB.a(i, cls);
            return aVarB;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.engine.a.d
        public a a() {
            return new a(this);
        }
    }

    public j(int i) {
        this.f4484e = i;
    }

    private boolean c(int i) {
        return i <= this.f4484e / 2;
    }

    @Override // com.bumptech.glide.load.engine.a.b
    public synchronized <T> T a(int i, Class<T> cls) {
        Integer numCeilingKey;
        numCeilingKey = b((Class<?>) cls).ceilingKey(Integer.valueOf(i));
        return (T) a(a(i, numCeilingKey) ? this.f4481b.a(numCeilingKey.intValue(), cls) : this.f4481b.a(i, cls), cls);
    }

    @Override // com.bumptech.glide.load.engine.a.b
    public synchronized <T> T b(int i, Class<T> cls) {
        return (T) a(this.f4481b.a(i, cls), cls);
    }

    @Override // com.bumptech.glide.load.engine.a.b
    public synchronized <T> void put(T t) {
        Class<?> cls = t.getClass();
        com.bumptech.glide.load.engine.a.a<T> aVarA = a((Class) cls);
        int iA = aVarA.a(t);
        int iA2 = aVarA.a() * iA;
        if (c(iA2)) {
            a aVarA2 = this.f4481b.a(iA, cls);
            this.f4480a.a(aVarA2, t);
            NavigableMap<Integer, Integer> navigableMapB = b(cls);
            Integer num = (Integer) navigableMapB.get(Integer.valueOf(aVarA2.f4487b));
            Integer numValueOf = Integer.valueOf(aVarA2.f4487b);
            int iIntValue = 1;
            if (num != null) {
                iIntValue = 1 + num.intValue();
            }
            navigableMapB.put(numValueOf, Integer.valueOf(iIntValue));
            this.f4485f += iA2;
            b();
        }
    }

    private boolean c() {
        int i = this.f4485f;
        return i == 0 || this.f4484e / i >= 2;
    }

    private void b() {
        b(this.f4484e);
    }

    private void c(int i, Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMapB = b(cls);
        Integer num = (Integer) navigableMapB.get(Integer.valueOf(i));
        if (num != null) {
            if (num.intValue() == 1) {
                navigableMapB.remove(Integer.valueOf(i));
                return;
            } else {
                navigableMapB.put(Integer.valueOf(i), Integer.valueOf(num.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + i + ", this: " + this);
    }

    private void b(int i) {
        while (this.f4485f > i) {
            Object objA = this.f4480a.a();
            com.bumptech.glide.e.l.a(objA);
            com.bumptech.glide.load.engine.a.a aVarA = a(objA);
            this.f4485f -= aVarA.a(objA) * aVarA.a();
            c(aVarA.a(objA), objA.getClass());
            if (Log.isLoggable(aVarA.getTag(), 2)) {
                Log.v(aVarA.getTag(), "evicted: " + aVarA.a(objA));
            }
        }
    }

    private <T> T a(a aVar, Class<T> cls) {
        com.bumptech.glide.load.engine.a.a<T> aVarA = a((Class) cls);
        T t = (T) a(aVar);
        if (t != null) {
            this.f4485f -= aVarA.a(t) * aVarA.a();
            c(aVarA.a(t), cls);
        }
        if (t != null) {
            return t;
        }
        if (Log.isLoggable(aVarA.getTag(), 2)) {
            Log.v(aVarA.getTag(), "Allocated " + aVar.f4487b + " bytes");
        }
        return aVarA.newArray(aVar.f4487b);
    }

    private NavigableMap<Integer, Integer> b(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.f4482c.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f4482c.put(cls, treeMap);
        return treeMap;
    }

    private <T> T a(a aVar) {
        return (T) this.f4480a.a(aVar);
    }

    private boolean a(int i, Integer num) {
        return num != null && (c() || num.intValue() <= i * 8);
    }

    @Override // com.bumptech.glide.load.engine.a.b
    public synchronized void a() {
        b(0);
    }

    @Override // com.bumptech.glide.load.engine.a.b
    public synchronized void a(int i) {
        try {
            if (i >= 40) {
                a();
            } else if (i >= 20 || i == 15) {
                b(this.f4484e / 2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private <T> com.bumptech.glide.load.engine.a.a<T> a(T t) {
        return a((Class) t.getClass());
    }

    private <T> com.bumptech.glide.load.engine.a.a<T> a(Class<T> cls) {
        com.bumptech.glide.load.engine.a.a<T> gVar = (com.bumptech.glide.load.engine.a.a) this.f4483d.get(cls);
        if (gVar == null) {
            if (cls.equals(int[].class)) {
                gVar = new i();
            } else if (cls.equals(byte[].class)) {
                gVar = new g();
            } else {
                throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
            }
            this.f4483d.put(cls, gVar);
        }
        return gVar;
    }
}
