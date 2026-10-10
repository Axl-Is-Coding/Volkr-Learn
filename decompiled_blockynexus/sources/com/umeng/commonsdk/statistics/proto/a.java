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
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: IdJournal.java */
/* JADX INFO: loaded from: classes5.dex */
public class a implements bc<a, e>, Serializable, Cloneable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<e, bo> f21263e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final long f21264f = 9132678615281394583L;
    private static final cg g = new cg("IdJournal");
    private static final bw h = new bw("domain", (byte) 11, 1);
    private static final bw i = new bw("old_id", (byte) 11, 2);
    private static final bw j = new bw("new_id", (byte) 11, 3);
    private static final bw k = new bw("ts", (byte) 10, 4);
    private static final Map<Class<? extends cj>, ck> l = new HashMap();
    private static final int m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f21265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f21266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f21267c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f21268d;
    private byte n;
    private e[] o;

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.proto.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IdJournal.java */
    private static class C0186a extends cl<a> {
        private C0186a() {
        }

        @Override // com.umeng.analytics.pro.cj
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(cb cbVar, a aVar) throws bi {
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
                            if (s != 4) {
                                ce.a(cbVar, b2);
                            } else if (b2 == 10) {
                                aVar.f21268d = cbVar.x();
                                aVar.d(true);
                            } else {
                                ce.a(cbVar, b2);
                            }
                        } else if (b2 == 11) {
                            aVar.f21267c = cbVar.z();
                            aVar.c(true);
                        } else {
                            ce.a(cbVar, b2);
                        }
                    } else if (b2 == 11) {
                        aVar.f21266b = cbVar.z();
                        aVar.b(true);
                    } else {
                        ce.a(cbVar, b2);
                    }
                } else if (b2 == 11) {
                    aVar.f21265a = cbVar.z();
                    aVar.a(true);
                } else {
                    ce.a(cbVar, b2);
                }
                cbVar.m();
            }
            cbVar.k();
            if (aVar.m()) {
                aVar.n();
                return;
            }
            throw new cc("Required field 'ts' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.cj
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(cb cbVar, a aVar) throws bi {
            aVar.n();
            cbVar.a(a.g);
            if (aVar.f21265a != null) {
                cbVar.a(a.h);
                cbVar.a(aVar.f21265a);
                cbVar.c();
            }
            if (aVar.f21266b != null && aVar.g()) {
                cbVar.a(a.i);
                cbVar.a(aVar.f21266b);
                cbVar.c();
            }
            if (aVar.f21267c != null) {
                cbVar.a(a.j);
                cbVar.a(aVar.f21267c);
                cbVar.c();
            }
            cbVar.a(a.k);
            cbVar.a(aVar.f21268d);
            cbVar.c();
            cbVar.d();
            cbVar.b();
        }
    }

    /* JADX INFO: compiled from: IdJournal.java */
    private static class b implements ck {
        private b() {
        }

        @Override // com.umeng.analytics.pro.ck
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0186a b() {
            return new C0186a();
        }
    }

    /* JADX INFO: compiled from: IdJournal.java */
    private static class c extends cm<a> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cj
        public void a(cb cbVar, a aVar) throws bi {
            ch chVar = (ch) cbVar;
            chVar.a(aVar.f21265a);
            chVar.a(aVar.f21267c);
            chVar.a(aVar.f21268d);
            BitSet bitSet = new BitSet();
            if (aVar.g()) {
                bitSet.set(0);
            }
            chVar.a(bitSet, 1);
            if (aVar.g()) {
                chVar.a(aVar.f21266b);
            }
        }

        @Override // com.umeng.analytics.pro.cj
        public void b(cb cbVar, a aVar) throws bi {
            ch chVar = (ch) cbVar;
            aVar.f21265a = chVar.z();
            aVar.a(true);
            aVar.f21267c = chVar.z();
            aVar.c(true);
            aVar.f21268d = chVar.x();
            aVar.d(true);
            if (chVar.b(1).get(0)) {
                aVar.f21266b = chVar.z();
                aVar.b(true);
            }
        }
    }

    /* JADX INFO: compiled from: IdJournal.java */
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
        l.put(cl.class, new b());
        l.put(cm.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.DOMAIN, new bo("domain", (byte) 1, new bp((byte) 11)));
        enumMap.put(e.OLD_ID, new bo("old_id", (byte) 2, new bp((byte) 11)));
        enumMap.put(e.NEW_ID, new bo("new_id", (byte) 1, new bp((byte) 11)));
        enumMap.put(e.TS, new bo("ts", (byte) 1, new bp((byte) 10)));
        f21263e = Collections.unmodifiableMap(enumMap);
        bo.a(a.class, f21263e);
    }

    public a() {
        this.n = (byte) 0;
        this.o = new e[]{e.OLD_ID};
    }

    @Override // com.umeng.analytics.pro.bc
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a deepCopy() {
        return new a(this);
    }

    public String b() {
        return this.f21265a;
    }

    public void c() {
        this.f21265a = null;
    }

    @Override // com.umeng.analytics.pro.bc
    public void clear() {
        this.f21265a = null;
        this.f21266b = null;
        this.f21267c = null;
        d(false);
        this.f21268d = 0L;
    }

    public boolean d() {
        return this.f21265a != null;
    }

    public String e() {
        return this.f21266b;
    }

    public void f() {
        this.f21266b = null;
    }

    public boolean g() {
        return this.f21266b != null;
    }

    public String h() {
        return this.f21267c;
    }

    public void i() {
        this.f21267c = null;
    }

    public boolean j() {
        return this.f21267c != null;
    }

    public long k() {
        return this.f21268d;
    }

    public void l() {
        this.n = az.b(this.n, 0);
    }

    public boolean m() {
        return az.a(this.n, 0);
    }

    public void n() throws bi {
        if (this.f21265a == null) {
            throw new cc("Required field 'domain' was not present! Struct: " + toString());
        }
        if (this.f21267c != null) {
            return;
        }
        throw new cc("Required field 'new_id' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.bc
    public void read(cb cbVar) throws bi {
        l.get(cbVar.D()).b().b(cbVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdJournal(");
        sb.append("domain:");
        String str = this.f21265a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        if (g()) {
            sb.append(", ");
            sb.append("old_id:");
            String str2 = this.f21266b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("new_id:");
        String str3 = this.f21267c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("ts:");
        sb.append(this.f21268d);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.bc
    public void write(cb cbVar) throws bi {
        l.get(cbVar.D()).b().a(cbVar, this);
    }

    /* JADX INFO: compiled from: IdJournal.java */
    public enum e implements bj {
        DOMAIN(1, "domain"),
        OLD_ID(2, "old_id"),
        NEW_ID(3, "new_id"),
        TS(4, "ts");


        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final Map<String, e> f21273e = new HashMap();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final short f21274f;
        private final String g;

        static {
            for (e eVar : EnumSet.allOf(e.class)) {
                f21273e.put(eVar.b(), eVar);
            }
        }

        e(short s, String str) {
            this.f21274f = s;
            this.g = str;
        }

        public static e a(int i) {
            if (i == 1) {
                return DOMAIN;
            }
            if (i == 2) {
                return OLD_ID;
            }
            if (i == 3) {
                return NEW_ID;
            }
            if (i != 4) {
                return null;
            }
            return TS;
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
            return this.g;
        }

        public static e a(String str) {
            return f21273e.get(str);
        }

        @Override // com.umeng.analytics.pro.bj
        public short a() {
            return this.f21274f;
        }
    }

    public a a(String str) {
        this.f21265a = str;
        return this;
    }

    public a b(String str) {
        this.f21266b = str;
        return this;
    }

    public a c(String str) {
        this.f21267c = str;
        return this;
    }

    public void d(boolean z) {
        this.n = az.a(this.n, 0, z);
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.f21265a = null;
    }

    public void b(boolean z) {
        if (z) {
            return;
        }
        this.f21266b = null;
    }

    public void c(boolean z) {
        if (z) {
            return;
        }
        this.f21267c = null;
    }

    public a(String str, String str2, long j2) {
        this();
        this.f21265a = str;
        this.f21267c = str2;
        this.f21268d = j2;
        d(true);
    }

    public a a(long j2) {
        this.f21268d = j2;
        d(true);
        return this;
    }

    @Override // com.umeng.analytics.pro.bc
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new bv(new cn(objectOutputStream)));
        } catch (bi e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public a(a aVar) {
        this.n = (byte) 0;
        this.o = new e[]{e.OLD_ID};
        this.n = aVar.n;
        if (aVar.d()) {
            this.f21265a = aVar.f21265a;
        }
        if (aVar.g()) {
            this.f21266b = aVar.f21266b;
        }
        if (aVar.j()) {
            this.f21267c = aVar.f21267c;
        }
        this.f21268d = aVar.f21268d;
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.n = (byte) 0;
            read(new bv(new cn(objectInputStream)));
        } catch (bi e2) {
            throw new IOException(e2.getMessage());
        }
    }
}
