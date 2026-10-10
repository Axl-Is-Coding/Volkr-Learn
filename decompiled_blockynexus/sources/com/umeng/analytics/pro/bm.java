package com.umeng.analytics.pro;

import com.umeng.analytics.pro.bj;
import com.umeng.analytics.pro.bm;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: TUnion.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class bm<T extends bm<?, ?>, F extends bj> implements bc<T, F> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<Class<? extends cj>, ck> f20715c = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Object f20716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected F f20717b;

    /* JADX INFO: compiled from: TUnion.java */
    private static class a extends cl<bm> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cj
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(cb cbVar, bm bmVar) throws bi {
            bmVar.f20717b = null;
            bmVar.f20716a = null;
            cbVar.j();
            bw bwVarL = cbVar.l();
            bmVar.f20716a = bmVar.a(cbVar, bwVarL);
            if (bmVar.f20716a != null) {
                bmVar.f20717b = (F) bmVar.a(bwVarL.f20756c);
            }
            cbVar.m();
            cbVar.l();
            cbVar.k();
        }

        @Override // com.umeng.analytics.pro.cj
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(cb cbVar, bm bmVar) throws bi {
            if (bmVar.a() == null || bmVar.b() == null) {
                throw new cc("Cannot write a TUnion with no set value!");
            }
            cbVar.a(bmVar.d());
            cbVar.a(bmVar.c(bmVar.f20717b));
            bmVar.a(cbVar);
            cbVar.c();
            cbVar.d();
            cbVar.b();
        }
    }

    /* JADX INFO: compiled from: TUnion.java */
    private static class b implements ck {
        private b() {
        }

        @Override // com.umeng.analytics.pro.ck
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    /* JADX INFO: compiled from: TUnion.java */
    private static class c extends cm<bm> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cj
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(cb cbVar, bm bmVar) throws bi {
            bmVar.f20717b = null;
            bmVar.f20716a = null;
            short sV = cbVar.v();
            bmVar.f20716a = bmVar.a(cbVar, sV);
            if (bmVar.f20716a != null) {
                bmVar.f20717b = (F) bmVar.a(sV);
            }
        }

        @Override // com.umeng.analytics.pro.cj
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(cb cbVar, bm bmVar) throws bi {
            if (bmVar.a() == null || bmVar.b() == null) {
                throw new cc("Cannot write a TUnion with no set value!");
            }
            cbVar.a(bmVar.f20717b.a());
            bmVar.b(cbVar);
        }
    }

    /* JADX INFO: compiled from: TUnion.java */
    private static class d implements ck {
        private d() {
        }

        @Override // com.umeng.analytics.pro.ck
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c b() {
            return new c();
        }
    }

    static {
        f20715c.put(cl.class, new b());
        f20715c.put(cm.class, new d());
    }

    protected bm() {
        this.f20717b = null;
        this.f20716a = null;
    }

    private static Object a(Object obj) {
        return obj instanceof bc ? ((bc) obj).deepCopy() : obj instanceof ByteBuffer ? bd.d((ByteBuffer) obj) : obj instanceof List ? a((List) obj) : obj instanceof Set ? a((Set) obj) : obj instanceof Map ? a((Map<Object, Object>) obj) : obj;
    }

    protected abstract F a(short s);

    protected abstract Object a(cb cbVar, bw bwVar) throws bi;

    protected abstract Object a(cb cbVar, short s) throws bi;

    protected abstract void a(cb cbVar) throws bi;

    public Object b() {
        return this.f20716a;
    }

    protected abstract void b(F f2, Object obj) throws ClassCastException;

    protected abstract void b(cb cbVar) throws bi;

    protected abstract bw c(F f2);

    public boolean c() {
        return this.f20717b != null;
    }

    @Override // com.umeng.analytics.pro.bc
    public final void clear() {
        this.f20717b = null;
        this.f20716a = null;
    }

    protected abstract cg d();

    @Override // com.umeng.analytics.pro.bc
    public void read(cb cbVar) throws bi {
        f20715c.get(cbVar.D()).b().b(cbVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(bm.class.getSimpleName());
        sb.append(" ");
        if (a() != null) {
            Object objB = b();
            sb.append(c(a()).f20754a);
            sb.append(":");
            if (objB instanceof ByteBuffer) {
                bd.a((ByteBuffer) objB, sb);
            } else {
                sb.append(objB.toString());
            }
        }
        sb.append(">");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.bc
    public void write(cb cbVar) throws bi {
        f20715c.get(cbVar.D()).b().a(cbVar, this);
    }

    public boolean b(F f2) {
        return this.f20717b == f2;
    }

    public boolean b(int i) {
        return b(a((short) i));
    }

    protected bm(F f2, Object obj) {
        a(f2, obj);
    }

    protected bm(bm<T, F> bmVar) {
        if (bmVar.getClass().equals(bm.class)) {
            this.f20717b = bmVar.f20717b;
            this.f20716a = a(bmVar.f20716a);
            return;
        }
        throw new ClassCastException();
    }

    private static Map a(Map<Object, Object> map) {
        HashMap map2 = new HashMap();
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            map2.put(a(entry.getKey()), a(entry.getValue()));
        }
        return map2;
    }

    private static Set a(Set set) {
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            hashSet.add(a(it.next()));
        }
        return hashSet;
    }

    private static List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next()));
        }
        return arrayList;
    }

    public F a() {
        return this.f20717b;
    }

    public Object a(F f2) {
        if (f2 == this.f20717b) {
            return b();
        }
        throw new IllegalArgumentException("Cannot get the value of field " + f2 + " because union's set field is " + this.f20717b);
    }

    public Object a(int i) {
        return a(a((short) i));
    }

    public void a(F f2, Object obj) {
        b(f2, obj);
        this.f20717b = f2;
        this.f20716a = obj;
    }

    public void a(int i, Object obj) {
        a(a((short) i), obj);
    }
}
