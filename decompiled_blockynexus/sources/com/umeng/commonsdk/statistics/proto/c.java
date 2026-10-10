package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.bc;
import com.umeng.analytics.pro.bi;
import com.umeng.analytics.pro.bj;
import com.umeng.analytics.pro.bo;
import com.umeng.analytics.pro.bp;
import com.umeng.analytics.pro.bq;
import com.umeng.analytics.pro.br;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.bv;
import com.umeng.analytics.pro.bw;
import com.umeng.analytics.pro.bx;
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
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: IdTracking.java */
/* JADX INFO: loaded from: classes5.dex */
public class c implements bc<c, e>, Serializable, Cloneable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<e, bo> f21287d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final long f21288e = -5764118265293965743L;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final cg f21289f = new cg("IdTracking");
    private static final bw g = new bw("snapshots", ci.k, 1);
    private static final bw h = new bw("journals", ci.m, 2);
    private static final bw i = new bw("checksum", (byte) 11, 3);
    private static final Map<Class<? extends cj>, ck> j = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, com.umeng.commonsdk.statistics.proto.b> f21290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<com.umeng.commonsdk.statistics.proto.a> f21291b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f21292c;
    private e[] k;

    /* JADX INFO: compiled from: IdTracking.java */
    private static class a extends cl<c> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cj
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(cb cbVar, c cVar) throws bi {
            cbVar.j();
            while (true) {
                bw bwVarL = cbVar.l();
                byte b2 = bwVarL.f20755b;
                if (b2 == 0) {
                    cbVar.k();
                    cVar.n();
                    return;
                }
                short s = bwVarL.f20756c;
                int i = 0;
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3) {
                            ce.a(cbVar, b2);
                        } else if (b2 == 11) {
                            cVar.f21292c = cbVar.z();
                            cVar.c(true);
                        } else {
                            ce.a(cbVar, b2);
                        }
                    } else if (b2 == 15) {
                        bx bxVarP = cbVar.p();
                        cVar.f21291b = new ArrayList(bxVarP.f20758b);
                        while (i < bxVarP.f20758b) {
                            com.umeng.commonsdk.statistics.proto.a aVar = new com.umeng.commonsdk.statistics.proto.a();
                            aVar.read(cbVar);
                            cVar.f21291b.add(aVar);
                            i++;
                        }
                        cbVar.q();
                        cVar.b(true);
                    } else {
                        ce.a(cbVar, b2);
                    }
                } else if (b2 == 13) {
                    by byVarN = cbVar.n();
                    cVar.f21290a = new HashMap(byVarN.f20761c * 2);
                    while (i < byVarN.f20761c) {
                        String strZ = cbVar.z();
                        com.umeng.commonsdk.statistics.proto.b bVar = new com.umeng.commonsdk.statistics.proto.b();
                        bVar.read(cbVar);
                        cVar.f21290a.put(strZ, bVar);
                        i++;
                    }
                    cbVar.o();
                    cVar.a(true);
                } else {
                    ce.a(cbVar, b2);
                }
                cbVar.m();
            }
        }

        @Override // com.umeng.analytics.pro.cj
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(cb cbVar, c cVar) throws bi {
            cVar.n();
            cbVar.a(c.f21289f);
            if (cVar.f21290a != null) {
                cbVar.a(c.g);
                cbVar.a(new by((byte) 11, (byte) 12, cVar.f21290a.size()));
                for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.f21290a.entrySet()) {
                    cbVar.a(entry.getKey());
                    entry.getValue().write(cbVar);
                }
                cbVar.e();
                cbVar.c();
            }
            if (cVar.f21291b != null && cVar.j()) {
                cbVar.a(c.h);
                cbVar.a(new bx((byte) 12, cVar.f21291b.size()));
                Iterator<com.umeng.commonsdk.statistics.proto.a> it = cVar.f21291b.iterator();
                while (it.hasNext()) {
                    it.next().write(cbVar);
                }
                cbVar.f();
                cbVar.c();
            }
            if (cVar.f21292c != null && cVar.m()) {
                cbVar.a(c.i);
                cbVar.a(cVar.f21292c);
                cbVar.c();
            }
            cbVar.d();
            cbVar.b();
        }
    }

    /* JADX INFO: compiled from: IdTracking.java */
    private static class b implements ck {
        private b() {
        }

        @Override // com.umeng.analytics.pro.ck
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.proto.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IdTracking.java */
    private static class C0188c extends cm<c> {
        private C0188c() {
        }

        @Override // com.umeng.analytics.pro.cj
        public void a(cb cbVar, c cVar) throws bi {
            ch chVar = (ch) cbVar;
            chVar.a(cVar.f21290a.size());
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.f21290a.entrySet()) {
                chVar.a(entry.getKey());
                entry.getValue().write(chVar);
            }
            BitSet bitSet = new BitSet();
            if (cVar.j()) {
                bitSet.set(0);
            }
            if (cVar.m()) {
                bitSet.set(1);
            }
            chVar.a(bitSet, 2);
            if (cVar.j()) {
                chVar.a(cVar.f21291b.size());
                Iterator<com.umeng.commonsdk.statistics.proto.a> it = cVar.f21291b.iterator();
                while (it.hasNext()) {
                    it.next().write(chVar);
                }
            }
            if (cVar.m()) {
                chVar.a(cVar.f21292c);
            }
        }

        @Override // com.umeng.analytics.pro.cj
        public void b(cb cbVar, c cVar) throws bi {
            ch chVar = (ch) cbVar;
            by byVar = new by((byte) 11, (byte) 12, chVar.w());
            cVar.f21290a = new HashMap(byVar.f20761c * 2);
            for (int i = 0; i < byVar.f20761c; i++) {
                String strZ = chVar.z();
                com.umeng.commonsdk.statistics.proto.b bVar = new com.umeng.commonsdk.statistics.proto.b();
                bVar.read(chVar);
                cVar.f21290a.put(strZ, bVar);
            }
            cVar.a(true);
            BitSet bitSetB = chVar.b(2);
            if (bitSetB.get(0)) {
                bx bxVar = new bx((byte) 12, chVar.w());
                cVar.f21291b = new ArrayList(bxVar.f20758b);
                for (int i2 = 0; i2 < bxVar.f20758b; i2++) {
                    com.umeng.commonsdk.statistics.proto.a aVar = new com.umeng.commonsdk.statistics.proto.a();
                    aVar.read(chVar);
                    cVar.f21291b.add(aVar);
                }
                cVar.b(true);
            }
            if (bitSetB.get(1)) {
                cVar.f21292c = chVar.z();
                cVar.c(true);
            }
        }
    }

    /* JADX INFO: compiled from: IdTracking.java */
    private static class d implements ck {
        private d() {
        }

        @Override // com.umeng.analytics.pro.ck
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0188c b() {
            return new C0188c();
        }
    }

    static {
        j.put(cl.class, new b());
        j.put(cm.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.SNAPSHOTS, new bo("snapshots", (byte) 1, new br(ci.k, new bp((byte) 11), new bt((byte) 12, com.umeng.commonsdk.statistics.proto.b.class))));
        enumMap.put(e.JOURNALS, new bo("journals", (byte) 2, new bq(ci.m, new bt((byte) 12, com.umeng.commonsdk.statistics.proto.a.class))));
        enumMap.put(e.CHECKSUM, new bo("checksum", (byte) 2, new bp((byte) 11)));
        f21287d = Collections.unmodifiableMap(enumMap);
        bo.a(c.class, f21287d);
    }

    public c() {
        this.k = new e[]{e.JOURNALS, e.CHECKSUM};
    }

    @Override // com.umeng.analytics.pro.bc
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public c deepCopy() {
        return new c(this);
    }

    public int b() {
        Map<String, com.umeng.commonsdk.statistics.proto.b> map = this.f21290a;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public Map<String, com.umeng.commonsdk.statistics.proto.b> c() {
        return this.f21290a;
    }

    @Override // com.umeng.analytics.pro.bc
    public void clear() {
        this.f21290a = null;
        this.f21291b = null;
        this.f21292c = null;
    }

    public void d() {
        this.f21290a = null;
    }

    public boolean e() {
        return this.f21290a != null;
    }

    public int f() {
        List<com.umeng.commonsdk.statistics.proto.a> list = this.f21291b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public Iterator<com.umeng.commonsdk.statistics.proto.a> g() {
        List<com.umeng.commonsdk.statistics.proto.a> list = this.f21291b;
        if (list == null) {
            return null;
        }
        return list.iterator();
    }

    public List<com.umeng.commonsdk.statistics.proto.a> h() {
        return this.f21291b;
    }

    public void i() {
        this.f21291b = null;
    }

    public boolean j() {
        return this.f21291b != null;
    }

    public String k() {
        return this.f21292c;
    }

    public void l() {
        this.f21292c = null;
    }

    public boolean m() {
        return this.f21292c != null;
    }

    public void n() throws bi {
        if (this.f21290a != null) {
            return;
        }
        throw new cc("Required field 'snapshots' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.bc
    public void read(cb cbVar) throws bi {
        j.get(cbVar.D()).b().b(cbVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdTracking(");
        sb.append("snapshots:");
        Map<String, com.umeng.commonsdk.statistics.proto.b> map = this.f21290a;
        if (map == null) {
            sb.append("null");
        } else {
            sb.append(map);
        }
        if (j()) {
            sb.append(", ");
            sb.append("journals:");
            List<com.umeng.commonsdk.statistics.proto.a> list = this.f21291b;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("checksum:");
            String str = this.f21292c;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.bc
    public void write(cb cbVar) throws bi {
        j.get(cbVar.D()).b().a(cbVar, this);
    }

    /* JADX INFO: compiled from: IdTracking.java */
    public enum e implements bj {
        SNAPSHOTS(1, "snapshots"),
        JOURNALS(2, "journals"),
        CHECKSUM(3, "checksum");


        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final Map<String, e> f21296d = new HashMap();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final short f21297e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final String f21298f;

        static {
            for (e eVar : EnumSet.allOf(e.class)) {
                f21296d.put(eVar.b(), eVar);
            }
        }

        e(short s, String str) {
            this.f21297e = s;
            this.f21298f = str;
        }

        public static e a(int i) {
            if (i == 1) {
                return SNAPSHOTS;
            }
            if (i == 2) {
                return JOURNALS;
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
            return this.f21298f;
        }

        public static e a(String str) {
            return f21296d.get(str);
        }

        @Override // com.umeng.analytics.pro.bj
        public short a() {
            return this.f21297e;
        }
    }

    public void a(String str, com.umeng.commonsdk.statistics.proto.b bVar) {
        if (this.f21290a == null) {
            this.f21290a = new HashMap();
        }
        this.f21290a.put(str, bVar);
    }

    public void b(boolean z) {
        if (z) {
            return;
        }
        this.f21291b = null;
    }

    public void c(boolean z) {
        if (z) {
            return;
        }
        this.f21292c = null;
    }

    public c(Map<String, com.umeng.commonsdk.statistics.proto.b> map) {
        this();
        this.f21290a = map;
    }

    public c(c cVar) {
        this.k = new e[]{e.JOURNALS, e.CHECKSUM};
        if (cVar.e()) {
            HashMap map = new HashMap();
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.f21290a.entrySet()) {
                map.put(entry.getKey(), new com.umeng.commonsdk.statistics.proto.b(entry.getValue()));
            }
            this.f21290a = map;
        }
        if (cVar.j()) {
            ArrayList arrayList = new ArrayList();
            Iterator<com.umeng.commonsdk.statistics.proto.a> it = cVar.f21291b.iterator();
            while (it.hasNext()) {
                arrayList.add(new com.umeng.commonsdk.statistics.proto.a(it.next()));
            }
            this.f21291b = arrayList;
        }
        if (cVar.m()) {
            this.f21292c = cVar.f21292c;
        }
    }

    public c a(Map<String, com.umeng.commonsdk.statistics.proto.b> map) {
        this.f21290a = map;
        return this;
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.f21290a = null;
    }

    public void a(com.umeng.commonsdk.statistics.proto.a aVar) {
        if (this.f21291b == null) {
            this.f21291b = new ArrayList();
        }
        this.f21291b.add(aVar);
    }

    public c a(List<com.umeng.commonsdk.statistics.proto.a> list) {
        this.f21291b = list;
        return this;
    }

    public c a(String str) {
        this.f21292c = str;
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

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            read(new bv(new cn(objectInputStream)));
        } catch (bi e2) {
            throw new IOException(e2.getMessage());
        }
    }
}
