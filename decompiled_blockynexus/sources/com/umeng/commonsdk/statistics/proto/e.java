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

/* JADX INFO: compiled from: ImprintValue.java */
/* JADX INFO: loaded from: classes5.dex */
public class e implements bc<e, EnumC0190e>, Serializable, Cloneable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<EnumC0190e, bo> f21311d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final long f21312e = 7501688097813630241L;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final cg f21313f = new cg("ImprintValue");
    private static final bw g = new bw("value", (byte) 11, 1);
    private static final bw h = new bw("ts", (byte) 10, 2);
    private static final bw i = new bw("guid", (byte) 11, 3);
    private static final Map<Class<? extends cj>, ck> j = new HashMap();
    private static final int k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f21314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f21315b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f21316c;
    private byte l;
    private EnumC0190e[] m;

    /* JADX INFO: compiled from: ImprintValue.java */
    private static class a extends cl<e> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cj
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(cb cbVar, e eVar) throws bi {
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
                            eVar.f21316c = cbVar.z();
                            eVar.c(true);
                        } else {
                            ce.a(cbVar, b2);
                        }
                    } else if (b2 == 10) {
                        eVar.f21315b = cbVar.x();
                        eVar.b(true);
                    } else {
                        ce.a(cbVar, b2);
                    }
                } else if (b2 == 11) {
                    eVar.f21314a = cbVar.z();
                    eVar.a(true);
                } else {
                    ce.a(cbVar, b2);
                }
                cbVar.m();
            }
            cbVar.k();
            if (eVar.g()) {
                eVar.k();
                return;
            }
            throw new cc("Required field 'ts' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.cj
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(cb cbVar, e eVar) throws bi {
            eVar.k();
            cbVar.a(e.f21313f);
            if (eVar.f21314a != null && eVar.d()) {
                cbVar.a(e.g);
                cbVar.a(eVar.f21314a);
                cbVar.c();
            }
            cbVar.a(e.h);
            cbVar.a(eVar.f21315b);
            cbVar.c();
            if (eVar.f21316c != null) {
                cbVar.a(e.i);
                cbVar.a(eVar.f21316c);
                cbVar.c();
            }
            cbVar.d();
            cbVar.b();
        }
    }

    /* JADX INFO: compiled from: ImprintValue.java */
    private static class b implements ck {
        private b() {
        }

        @Override // com.umeng.analytics.pro.ck
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    /* JADX INFO: compiled from: ImprintValue.java */
    private static class c extends cm<e> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cj
        public void a(cb cbVar, e eVar) throws bi {
            ch chVar = (ch) cbVar;
            chVar.a(eVar.f21315b);
            chVar.a(eVar.f21316c);
            BitSet bitSet = new BitSet();
            if (eVar.d()) {
                bitSet.set(0);
            }
            chVar.a(bitSet, 1);
            if (eVar.d()) {
                chVar.a(eVar.f21314a);
            }
        }

        @Override // com.umeng.analytics.pro.cj
        public void b(cb cbVar, e eVar) throws bi {
            ch chVar = (ch) cbVar;
            eVar.f21315b = chVar.x();
            eVar.b(true);
            eVar.f21316c = chVar.z();
            eVar.c(true);
            if (chVar.b(1).get(0)) {
                eVar.f21314a = chVar.z();
                eVar.a(true);
            }
        }
    }

    /* JADX INFO: compiled from: ImprintValue.java */
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
        j.put(cl.class, new b());
        j.put(cm.class, new d());
        EnumMap enumMap = new EnumMap(EnumC0190e.class);
        enumMap.put(EnumC0190e.VALUE, new bo("value", (byte) 2, new bp((byte) 11)));
        enumMap.put(EnumC0190e.TS, new bo("ts", (byte) 1, new bp((byte) 10)));
        enumMap.put(EnumC0190e.GUID, new bo("guid", (byte) 1, new bp((byte) 11)));
        f21311d = Collections.unmodifiableMap(enumMap);
        bo.a(e.class, f21311d);
    }

    public e() {
        this.l = (byte) 0;
        this.m = new EnumC0190e[]{EnumC0190e.VALUE};
    }

    @Override // com.umeng.analytics.pro.bc
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public e deepCopy() {
        return new e(this);
    }

    public String b() {
        return this.f21314a;
    }

    public void c() {
        this.f21314a = null;
    }

    @Override // com.umeng.analytics.pro.bc
    public void clear() {
        this.f21314a = null;
        b(false);
        this.f21315b = 0L;
        this.f21316c = null;
    }

    public boolean d() {
        return this.f21314a != null;
    }

    public long e() {
        return this.f21315b;
    }

    public void f() {
        this.l = az.b(this.l, 0);
    }

    public boolean g() {
        return az.a(this.l, 0);
    }

    public String h() {
        return this.f21316c;
    }

    public void i() {
        this.f21316c = null;
    }

    public boolean j() {
        return this.f21316c != null;
    }

    public void k() throws bi {
        if (this.f21316c != null) {
            return;
        }
        throw new cc("Required field 'guid' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.bc
    public void read(cb cbVar) throws bi {
        j.get(cbVar.D()).b().b(cbVar, this);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("ImprintValue(");
        if (d()) {
            sb.append("value:");
            String str = this.f21314a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("ts:");
        sb.append(this.f21315b);
        sb.append(", ");
        sb.append("guid:");
        String str2 = this.f21316c;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.bc
    public void write(cb cbVar) throws bi {
        j.get(cbVar.D()).b().a(cbVar, this);
    }

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.proto.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ImprintValue.java */
    public enum EnumC0190e implements bj {
        VALUE(1, "value"),
        TS(2, "ts"),
        GUID(3, "guid");


        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final Map<String, EnumC0190e> f21320d = new HashMap();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final short f21321e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final String f21322f;

        static {
            for (EnumC0190e enumC0190e : EnumSet.allOf(EnumC0190e.class)) {
                f21320d.put(enumC0190e.b(), enumC0190e);
            }
        }

        EnumC0190e(short s, String str) {
            this.f21321e = s;
            this.f21322f = str;
        }

        public static EnumC0190e a(int i) {
            if (i == 1) {
                return VALUE;
            }
            if (i == 2) {
                return TS;
            }
            if (i != 3) {
                return null;
            }
            return GUID;
        }

        public static EnumC0190e b(int i) {
            EnumC0190e enumC0190eA = a(i);
            if (enumC0190eA != null) {
                return enumC0190eA;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        @Override // com.umeng.analytics.pro.bj
        public String b() {
            return this.f21322f;
        }

        public static EnumC0190e a(String str) {
            return f21320d.get(str);
        }

        @Override // com.umeng.analytics.pro.bj
        public short a() {
            return this.f21321e;
        }
    }

    public e a(String str) {
        this.f21314a = str;
        return this;
    }

    public void b(boolean z) {
        this.l = az.a(this.l, 0, z);
    }

    public void c(boolean z) {
        if (z) {
            return;
        }
        this.f21316c = null;
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.f21314a = null;
    }

    public e b(String str) {
        this.f21316c = str;
        return this;
    }

    public e(long j2, String str) {
        this();
        this.f21315b = j2;
        b(true);
        this.f21316c = str;
    }

    public e a(long j2) {
        this.f21315b = j2;
        b(true);
        return this;
    }

    @Override // com.umeng.analytics.pro.bc
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public EnumC0190e fieldForId(int i2) {
        return EnumC0190e.a(i2);
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new bv(new cn(objectOutputStream)));
        } catch (bi e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public e(e eVar) {
        this.l = (byte) 0;
        this.m = new EnumC0190e[]{EnumC0190e.VALUE};
        this.l = eVar.l;
        if (eVar.d()) {
            this.f21314a = eVar.f21314a;
        }
        this.f21315b = eVar.f21315b;
        if (eVar.j()) {
            this.f21316c = eVar.f21316c;
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
