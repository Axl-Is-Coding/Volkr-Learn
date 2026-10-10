package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.az;
import com.umeng.analytics.pro.bc;
import com.umeng.analytics.pro.bi;
import com.umeng.analytics.pro.bj;
import com.umeng.analytics.pro.bo;
import com.umeng.analytics.pro.bp;
import com.umeng.analytics.pro.br;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.bv;
import com.umeng.analytics.pro.bw;
import com.umeng.analytics.pro.by;
import com.umeng.analytics.pro.cb;
import com.umeng.analytics.pro.cc;
import com.umeng.analytics.pro.ce;
import com.umeng.analytics.pro.cg;
import com.umeng.analytics.pro.ch;
import com.umeng.analytics.pro.ci;
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

/* JADX INFO: compiled from: Imprint.java */
/* JADX INFO: loaded from: classes5.dex */
public class d implements bc<d, e>, Serializable, Cloneable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<e, bo> f21299d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final long f21300e = 2846460275012375038L;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final cg f21301f = new cg("Imprint");
    private static final bw g = new bw("property", ci.k, 1);
    private static final bw h = new bw("version", (byte) 8, 2);
    private static final bw i = new bw("checksum", (byte) 11, 3);
    private static final Map<Class<? extends cj>, ck> j = new HashMap();
    private static final int k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, com.umeng.commonsdk.statistics.proto.e> f21302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f21303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f21304c;
    private byte l;

    /* JADX INFO: compiled from: Imprint.java */
    private static class a extends cl<d> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cj
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(cb cbVar, d dVar) throws bi {
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
                        } else if (b2 == 11) {
                            dVar.f21304c = cbVar.z();
                            dVar.c(true);
                        } else {
                            ce.a(cbVar, b2);
                        }
                    } else if (b2 == 8) {
                        dVar.f21303b = cbVar.w();
                        dVar.b(true);
                    } else {
                        ce.a(cbVar, b2);
                    }
                } else if (b2 == 13) {
                    by byVarN = cbVar.n();
                    dVar.f21302a = new HashMap(byVarN.f20761c * 2);
                    for (int i = 0; i < byVarN.f20761c; i++) {
                        String strZ = cbVar.z();
                        com.umeng.commonsdk.statistics.proto.e eVar = new com.umeng.commonsdk.statistics.proto.e();
                        eVar.read(cbVar);
                        dVar.f21302a.put(strZ, eVar);
                    }
                    cbVar.o();
                    dVar.a(true);
                } else {
                    ce.a(cbVar, b2);
                }
                cbVar.m();
            }
            cbVar.k();
            if (dVar.h()) {
                dVar.l();
                return;
            }
            throw new cc("Required field 'version' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.cj
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(cb cbVar, d dVar) throws bi {
            dVar.l();
            cbVar.a(d.f21301f);
            if (dVar.f21302a != null) {
                cbVar.a(d.g);
                cbVar.a(new by((byte) 11, (byte) 12, dVar.f21302a.size()));
                for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.f21302a.entrySet()) {
                    cbVar.a(entry.getKey());
                    entry.getValue().write(cbVar);
                }
                cbVar.e();
                cbVar.c();
            }
            cbVar.a(d.h);
            cbVar.a(dVar.f21303b);
            cbVar.c();
            if (dVar.f21304c != null) {
                cbVar.a(d.i);
                cbVar.a(dVar.f21304c);
                cbVar.c();
            }
            cbVar.d();
            cbVar.b();
        }
    }

    /* JADX INFO: compiled from: Imprint.java */
    private static class b implements ck {
        private b() {
        }

        @Override // com.umeng.analytics.pro.ck
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    /* JADX INFO: compiled from: Imprint.java */
    private static class c extends cm<d> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cj
        public void a(cb cbVar, d dVar) throws bi {
            ch chVar = (ch) cbVar;
            chVar.a(dVar.f21302a.size());
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.f21302a.entrySet()) {
                chVar.a(entry.getKey());
                entry.getValue().write(chVar);
            }
            chVar.a(dVar.f21303b);
            chVar.a(dVar.f21304c);
        }

        @Override // com.umeng.analytics.pro.cj
        public void b(cb cbVar, d dVar) throws bi {
            ch chVar = (ch) cbVar;
            by byVar = new by((byte) 11, (byte) 12, chVar.w());
            dVar.f21302a = new HashMap(byVar.f20761c * 2);
            for (int i = 0; i < byVar.f20761c; i++) {
                String strZ = chVar.z();
                com.umeng.commonsdk.statistics.proto.e eVar = new com.umeng.commonsdk.statistics.proto.e();
                eVar.read(chVar);
                dVar.f21302a.put(strZ, eVar);
            }
            dVar.a(true);
            dVar.f21303b = chVar.w();
            dVar.b(true);
            dVar.f21304c = chVar.z();
            dVar.c(true);
        }
    }

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.proto.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Imprint.java */
    private static class C0189d implements ck {
        private C0189d() {
        }

        @Override // com.umeng.analytics.pro.ck
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c b() {
            return new c();
        }
    }

    static {
        j.put(cl.class, new b());
        j.put(cm.class, new C0189d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.PROPERTY, new bo("property", (byte) 1, new br(ci.k, new bp((byte) 11), new bt((byte) 12, com.umeng.commonsdk.statistics.proto.e.class))));
        enumMap.put(e.VERSION, new bo("version", (byte) 1, new bp((byte) 8)));
        enumMap.put(e.CHECKSUM, new bo("checksum", (byte) 1, new bp((byte) 11)));
        f21299d = Collections.unmodifiableMap(enumMap);
        bo.a(d.class, f21299d);
    }

    public d() {
        this.l = (byte) 0;
    }

    @Override // com.umeng.analytics.pro.bc
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public d deepCopy() {
        return new d(this);
    }

    public int b() {
        Map<String, com.umeng.commonsdk.statistics.proto.e> map = this.f21302a;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public Map<String, com.umeng.commonsdk.statistics.proto.e> c() {
        return this.f21302a;
    }

    @Override // com.umeng.analytics.pro.bc
    public void clear() {
        this.f21302a = null;
        b(false);
        this.f21303b = 0;
        this.f21304c = null;
    }

    public void d() {
        this.f21302a = null;
    }

    public boolean e() {
        return this.f21302a != null;
    }

    public int f() {
        return this.f21303b;
    }

    public void g() {
        this.l = az.b(this.l, 0);
    }

    public boolean h() {
        return az.a(this.l, 0);
    }

    public String i() {
        return this.f21304c;
    }

    public void j() {
        this.f21304c = null;
    }

    public boolean k() {
        return this.f21304c != null;
    }

    public void l() throws bi {
        if (this.f21302a == null) {
            throw new cc("Required field 'property' was not present! Struct: " + toString());
        }
        if (this.f21304c != null) {
            return;
        }
        throw new cc("Required field 'checksum' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.bc
    public void read(cb cbVar) throws bi {
        j.get(cbVar.D()).b().b(cbVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Imprint(");
        sb.append("property:");
        Map<String, com.umeng.commonsdk.statistics.proto.e> map = this.f21302a;
        if (map == null) {
            sb.append("null");
        } else {
            sb.append(map);
        }
        sb.append(", ");
        sb.append("version:");
        sb.append(this.f21303b);
        sb.append(", ");
        sb.append("checksum:");
        String str = this.f21304c;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.bc
    public void write(cb cbVar) throws bi {
        j.get(cbVar.D()).b().a(cbVar, this);
    }

    /* JADX INFO: compiled from: Imprint.java */
    public enum e implements bj {
        PROPERTY(1, "property"),
        VERSION(2, "version"),
        CHECKSUM(3, "checksum");


        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final Map<String, e> f21308d = new HashMap();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final short f21309e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final String f21310f;

        static {
            for (e eVar : EnumSet.allOf(e.class)) {
                f21308d.put(eVar.b(), eVar);
            }
        }

        e(short s, String str) {
            this.f21309e = s;
            this.f21310f = str;
        }

        public static e a(int i) {
            if (i == 1) {
                return PROPERTY;
            }
            if (i == 2) {
                return VERSION;
            }
            if (i != 3) {
                return null;
            }
            return CHECKSUM;
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
            return this.f21310f;
        }

        public static e a(String str) {
            return f21308d.get(str);
        }

        @Override // com.umeng.analytics.pro.bj
        public short a() {
            return this.f21309e;
        }
    }

    public void a(String str, com.umeng.commonsdk.statistics.proto.e eVar) {
        if (this.f21302a == null) {
            this.f21302a = new HashMap();
        }
        this.f21302a.put(str, eVar);
    }

    public void b(boolean z) {
        this.l = az.a(this.l, 0, z);
    }

    public void c(boolean z) {
        if (z) {
            return;
        }
        this.f21304c = null;
    }

    public d(Map<String, com.umeng.commonsdk.statistics.proto.e> map, int i2, String str) {
        this();
        this.f21302a = map;
        this.f21303b = i2;
        b(true);
        this.f21304c = str;
    }

    @Override // com.umeng.analytics.pro.bc
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    public d a(Map<String, com.umeng.commonsdk.statistics.proto.e> map) {
        this.f21302a = map;
        return this;
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.f21302a = null;
    }

    public d a(int i2) {
        this.f21303b = i2;
        b(true);
        return this;
    }

    public d(d dVar) {
        this.l = (byte) 0;
        this.l = dVar.l;
        if (dVar.e()) {
            HashMap map = new HashMap();
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.f21302a.entrySet()) {
                map.put(entry.getKey(), new com.umeng.commonsdk.statistics.proto.e(entry.getValue()));
            }
            this.f21302a = map;
        }
        this.f21303b = dVar.f21303b;
        if (dVar.k()) {
            this.f21304c = dVar.f21304c;
        }
    }

    public d a(String str) {
        this.f21304c = str;
        return this;
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new bv(new cn(objectOutputStream)));
        } catch (bi e2) {
            throw new IOException(e2.getMessage());
        }
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.l = (byte) 0;
            read(new bv(new cn(objectInputStream)));
        } catch (bi e2) {
            throw new IOException(e2.getMessage());
        }
    }
}
