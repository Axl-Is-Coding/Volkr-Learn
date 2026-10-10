package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.az;
import com.umeng.analytics.pro.bc;
import com.umeng.analytics.pro.bi;
import com.umeng.analytics.pro.bj;
import com.umeng.analytics.pro.bo;
import com.umeng.analytics.pro.bp;
import com.umeng.analytics.pro.bv;
import com.umeng.analytics.pro.bw;
import com.umeng.analytics.pro.cb;
import com.umeng.analytics.pro.cc;
import com.umeng.analytics.pro.ce;
import com.umeng.analytics.pro.cg;
import com.umeng.analytics.pro.ch;
import com.umeng.analytics.pro.cj;
import com.umeng.analytics.pro.ck;
import com.umeng.analytics.pro.cl;
import com.umeng.analytics.pro.cm;
import com.umeng.analytics.pro.cn;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: IdSnapshot.java */
/* JADX INFO: loaded from: classes5.dex */
public class b implements bc<b, e>, Serializable, Cloneable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<e, bo> f21275d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final long f21276e = -6496538196005191531L;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final cg f21277f = new cg("IdSnapshot");
    private static final bw g = new bw("identity", (byte) 11, 1);
    private static final bw h = new bw("ts", (byte) 10, 2);
    private static final bw i = new bw("version", (byte) 8, 3);
    private static final Map<Class<? extends cj>, ck> j = new HashMap();
    private static final int k = 0;
    private static final int l = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f21278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f21279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f21280c;
    private byte m;

    /* JADX INFO: compiled from: IdSnapshot.java */
    private static class a extends cl<b> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cj
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(cb cbVar, b bVar) throws bi {
            cbVar.j();
            while (true) {
                bw bwVarL = cbVar.l();
                byte b2 = bwVarL.f20755b;
                if (b2 == 0) {
                    break;
                }
                short s = bwVarL.f20756c;
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3) {
                            ce.a(cbVar, b2);
                        } else if (b2 == 8) {
                            bVar.f21280c = cbVar.w();
                            bVar.c(true);
                        } else {
                            ce.a(cbVar, b2);
                        }
                    } else if (b2 == 10) {
                        bVar.f21279b = cbVar.x();
                        bVar.b(true);
                    } else {
                        ce.a(cbVar, b2);
                    }
                } else if (b2 == 11) {
                    bVar.f21278a = cbVar.z();
                    bVar.a(true);
                } else {
                    ce.a(cbVar, b2);
                }
                cbVar.m();
            }
            cbVar.k();
            if (!bVar.g()) {
                throw new cc("Required field 'ts' was not found in serialized data! Struct: " + toString());
            }
            if (bVar.j()) {
                bVar.k();
                return;
            }
            throw new cc("Required field 'version' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.cj
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(cb cbVar, b bVar) throws bi {
            bVar.k();
            cbVar.a(b.f21277f);
            if (bVar.f21278a != null) {
                cbVar.a(b.g);
                cbVar.a(bVar.f21278a);
                cbVar.c();
            }
            cbVar.a(b.h);
            cbVar.a(bVar.f21279b);
            cbVar.c();
            cbVar.a(b.i);
            cbVar.a(bVar.f21280c);
            cbVar.c();
            cbVar.d();
            cbVar.b();
        }
    }

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.proto.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IdSnapshot.java */
    private static class C0187b implements ck {
        private C0187b() {
        }

        @Override // com.umeng.analytics.pro.ck
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    /* JADX INFO: compiled from: IdSnapshot.java */
    private static class c extends cm<b> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cj
        public void a(cb cbVar, b bVar) throws bi {
            ch chVar = (ch) cbVar;
            chVar.a(bVar.f21278a);
            chVar.a(bVar.f21279b);
            chVar.a(bVar.f21280c);
        }

        @Override // com.umeng.analytics.pro.cj
        public void b(cb cbVar, b bVar) throws bi {
            ch chVar = (ch) cbVar;
            bVar.f21278a = chVar.z();
            bVar.a(true);
            bVar.f21279b = chVar.x();
            bVar.b(true);
            bVar.f21280c = chVar.w();
            bVar.c(true);
        }
    }

    /* JADX INFO: compiled from: IdSnapshot.java */
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
        j.put(cl.class, new C0187b());
        j.put(cm.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.IDENTITY, new bo("identity", (byte) 1, new bp((byte) 11)));
        enumMap.put(e.TS, new bo("ts", (byte) 1, new bp((byte) 10)));
        enumMap.put(e.VERSION, new bo("version", (byte) 1, new bp((byte) 8)));
        f21275d = Collections.unmodifiableMap(enumMap);
        bo.a(b.class, f21275d);
    }

    public b() {
        this.m = (byte) 0;
    }

    @Override // com.umeng.analytics.pro.bc
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public b deepCopy() {
        return new b(this);
    }

    public String b() {
        return this.f21278a;
    }

    public void c() {
        this.f21278a = null;
    }

    @Override // com.umeng.analytics.pro.bc
    public void clear() {
        this.f21278a = null;
        b(false);
        this.f21279b = 0L;
        c(false);
        this.f21280c = 0;
    }

    public boolean d() {
        return this.f21278a != null;
    }

    public long e() {
        return this.f21279b;
    }

    public void f() {
        this.m = az.b(this.m, 0);
    }

    public boolean g() {
        return az.a(this.m, 0);
    }

    public int h() {
        return this.f21280c;
    }

    public void i() {
        this.m = az.b(this.m, 1);
    }

    public boolean j() {
        return az.a(this.m, 1);
    }

    public void k() throws bi {
        if (this.f21278a != null) {
            return;
        }
        throw new cc("Required field 'identity' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.bc
    public void read(cb cbVar) throws bi {
        j.get(cbVar.D()).b().b(cbVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdSnapshot(");
        sb.append("identity:");
        String str = this.f21278a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("ts:");
        sb.append(this.f21279b);
        sb.append(", ");
        sb.append("version:");
        sb.append(this.f21280c);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.bc
    public void write(cb cbVar) throws bi {
        j.get(cbVar.D()).b().a(cbVar, this);
    }

    /* JADX INFO: compiled from: IdSnapshot.java */
    public enum e implements bj {
        IDENTITY(1, "identity"),
        TS(2, "ts"),
        VERSION(3, "version");


        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final Map<String, e> f21284d = new HashMap();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final short f21285e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final String f21286f;

        static {
            for (e eVar : EnumSet.allOf(e.class)) {
                f21284d.put(eVar.b(), eVar);
            }
        }

        e(short s, String str) {
            this.f21285e = s;
            this.f21286f = str;
        }

        public static e a(int i) {
            if (i == 1) {
                return IDENTITY;
            }
            if (i == 2) {
                return TS;
            }
            if (i != 3) {
                return null;
            }
            return VERSION;
        }

        public static e b(int i) {
            e eVarA = a(i);
            if (eVarA != null) {
                return eVarA;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        @Override // com.umeng.analytics.pro.bj
        public String b() {
            return this.f21286f;
        }

        public static e a(String str) {
            return f21284d.get(str);
        }

        @Override // com.umeng.analytics.pro.bj
        public short a() {
            return this.f21285e;
        }
    }

    public b a(String str) {
        this.f21278a = str;
        return this;
    }

    public void b(boolean z) {
        this.m = az.a(this.m, 0, z);
    }

    public void c(boolean z) {
        this.m = az.a(this.m, 1, z);
    }

    public b(String str, long j2, int i2) {
        this();
        this.f21278a = str;
        this.f21279b = j2;
        b(true);
        this.f21280c = i2;
        c(true);
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.f21278a = null;
    }

    @Override // com.umeng.analytics.pro.bc
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    public b a(long j2) {
        this.f21279b = j2;
        b(true);
        return this;
    }

    public b a(int i2) {
        this.f21280c = i2;
        c(true);
        return this;
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new bv(new cn(objectOutputStream)));
        } catch (bi e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public b(b bVar) {
        this.m = (byte) 0;
        this.m = bVar.m;
        if (bVar.d()) {
            this.f21278a = bVar.f21278a;
        }
        this.f21279b = bVar.f21279b;
        this.f21280c = bVar.f21280c;
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.m = (byte) 0;
            read(new bv(new cn(objectInputStream)));
        } catch (bi e2) {
            throw new IOException(e2.getMessage());
        }
    }
}
