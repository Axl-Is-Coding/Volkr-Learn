package com.umeng.commonsdk.stateless;

import com.tendcloud.tenddata.cp;
import com.umeng.analytics.pro.az;
import com.umeng.analytics.pro.bc;
import com.umeng.analytics.pro.bd;
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
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: UMSLEnvelope.java */
/* JADX INFO: loaded from: classes5.dex */
public class b implements bc<b, e>, Serializable, Cloneable {
    private static final int A = 2;
    private static final int B = 3;
    public static final Map<e, bo> k;
    private static final long l = 420342210744516016L;
    private static final cg m = new cg("UMSLEnvelope");
    private static final bw n = new bw("version", (byte) 11, 1);
    private static final bw o = new bw("address", (byte) 11, 2);
    private static final bw p = new bw(InAppPurchaseMetaData.KEY_SIGNATURE, (byte) 11, 3);
    private static final bw q = new bw("serial_num", (byte) 8, 4);
    private static final bw r = new bw("ts_secs", (byte) 8, 5);
    private static final bw s = new bw(cp.a.LENGTH, (byte) 8, 6);
    private static final bw t = new bw("entity", (byte) 11, 7);
    private static final bw u = new bw("guid", (byte) 11, 8);
    private static final bw v = new bw("checksum", (byte) 11, 9);
    private static final bw w = new bw("codex", (byte) 8, 10);
    private static final Map<Class<? extends cj>, ck> x = new HashMap();
    private static final int y = 0;
    private static final int z = 1;
    private byte C;
    private e[] D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f21108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f21109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f21110c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f21111d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f21112e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f21113f;
    public ByteBuffer g;
    public String h;
    public String i;
    public int j;

    /* JADX INFO: compiled from: UMSLEnvelope.java */
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
                    cbVar.k();
                    if (!bVar.m()) {
                        throw new cc("Required field 'serial_num' was not found in serialized data! Struct: " + toString());
                    }
                    if (!bVar.p()) {
                        throw new cc("Required field 'ts_secs' was not found in serialized data! Struct: " + toString());
                    }
                    if (bVar.s()) {
                        bVar.G();
                        return;
                    }
                    throw new cc("Required field 'length' was not found in serialized data! Struct: " + toString());
                }
                switch (bwVarL.f20756c) {
                    case 1:
                        if (b2 != 11) {
                            ce.a(cbVar, b2);
                        } else {
                            bVar.f21108a = cbVar.z();
                            bVar.a(true);
                        }
                        break;
                    case 2:
                        if (b2 != 11) {
                            ce.a(cbVar, b2);
                        } else {
                            bVar.f21109b = cbVar.z();
                            bVar.b(true);
                        }
                        break;
                    case 3:
                        if (b2 != 11) {
                            ce.a(cbVar, b2);
                        } else {
                            bVar.f21110c = cbVar.z();
                            bVar.c(true);
                        }
                        break;
                    case 4:
                        if (b2 != 8) {
                            ce.a(cbVar, b2);
                        } else {
                            bVar.f21111d = cbVar.w();
                            bVar.d(true);
                        }
                        break;
                    case 5:
                        if (b2 != 8) {
                            ce.a(cbVar, b2);
                        } else {
                            bVar.f21112e = cbVar.w();
                            bVar.e(true);
                        }
                        break;
                    case 6:
                        if (b2 != 8) {
                            ce.a(cbVar, b2);
                        } else {
                            bVar.f21113f = cbVar.w();
                            bVar.f(true);
                        }
                        break;
                    case 7:
                        if (b2 != 11) {
                            ce.a(cbVar, b2);
                        } else {
                            bVar.g = cbVar.A();
                            bVar.g(true);
                        }
                        break;
                    case 8:
                        if (b2 != 11) {
                            ce.a(cbVar, b2);
                        } else {
                            bVar.h = cbVar.z();
                            bVar.h(true);
                        }
                        break;
                    case 9:
                        if (b2 != 11) {
                            ce.a(cbVar, b2);
                        } else {
                            bVar.i = cbVar.z();
                            bVar.i(true);
                        }
                        break;
                    case 10:
                        if (b2 != 8) {
                            ce.a(cbVar, b2);
                        } else {
                            bVar.j = cbVar.w();
                            bVar.j(true);
                        }
                        break;
                    default:
                        ce.a(cbVar, b2);
                        break;
                }
                cbVar.m();
            }
        }

        @Override // com.umeng.analytics.pro.cj
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(cb cbVar, b bVar) throws bi {
            bVar.G();
            cbVar.a(b.m);
            if (bVar.f21108a != null) {
                cbVar.a(b.n);
                cbVar.a(bVar.f21108a);
                cbVar.c();
            }
            if (bVar.f21109b != null) {
                cbVar.a(b.o);
                cbVar.a(bVar.f21109b);
                cbVar.c();
            }
            if (bVar.f21110c != null) {
                cbVar.a(b.p);
                cbVar.a(bVar.f21110c);
                cbVar.c();
            }
            cbVar.a(b.q);
            cbVar.a(bVar.f21111d);
            cbVar.c();
            cbVar.a(b.r);
            cbVar.a(bVar.f21112e);
            cbVar.c();
            cbVar.a(b.s);
            cbVar.a(bVar.f21113f);
            cbVar.c();
            if (bVar.g != null) {
                cbVar.a(b.t);
                cbVar.a(bVar.g);
                cbVar.c();
            }
            if (bVar.h != null) {
                cbVar.a(b.u);
                cbVar.a(bVar.h);
                cbVar.c();
            }
            if (bVar.i != null) {
                cbVar.a(b.v);
                cbVar.a(bVar.i);
                cbVar.c();
            }
            if (bVar.F()) {
                cbVar.a(b.w);
                cbVar.a(bVar.j);
                cbVar.c();
            }
            cbVar.d();
            cbVar.b();
        }
    }

    /* JADX INFO: renamed from: com.umeng.commonsdk.stateless.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: UMSLEnvelope.java */
    private static class C0183b implements ck {
        private C0183b() {
        }

        @Override // com.umeng.analytics.pro.ck
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    /* JADX INFO: compiled from: UMSLEnvelope.java */
    private static class c extends cm<b> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cj
        public void a(cb cbVar, b bVar) throws bi {
            ch chVar = (ch) cbVar;
            chVar.a(bVar.f21108a);
            chVar.a(bVar.f21109b);
            chVar.a(bVar.f21110c);
            chVar.a(bVar.f21111d);
            chVar.a(bVar.f21112e);
            chVar.a(bVar.f21113f);
            chVar.a(bVar.g);
            chVar.a(bVar.h);
            chVar.a(bVar.i);
            BitSet bitSet = new BitSet();
            if (bVar.F()) {
                bitSet.set(0);
            }
            chVar.a(bitSet, 1);
            if (bVar.F()) {
                chVar.a(bVar.j);
            }
        }

        @Override // com.umeng.analytics.pro.cj
        public void b(cb cbVar, b bVar) throws bi {
            ch chVar = (ch) cbVar;
            bVar.f21108a = chVar.z();
            bVar.a(true);
            bVar.f21109b = chVar.z();
            bVar.b(true);
            bVar.f21110c = chVar.z();
            bVar.c(true);
            bVar.f21111d = chVar.w();
            bVar.d(true);
            bVar.f21112e = chVar.w();
            bVar.e(true);
            bVar.f21113f = chVar.w();
            bVar.f(true);
            bVar.g = chVar.A();
            bVar.g(true);
            bVar.h = chVar.z();
            bVar.h(true);
            bVar.i = chVar.z();
            bVar.i(true);
            if (chVar.b(1).get(0)) {
                bVar.j = chVar.w();
                bVar.j(true);
            }
        }
    }

    /* JADX INFO: compiled from: UMSLEnvelope.java */
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
        x.put(cl.class, new C0183b());
        x.put(cm.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.VERSION, new bo("version", (byte) 1, new bp((byte) 11)));
        enumMap.put(e.ADDRESS, new bo("address", (byte) 1, new bp((byte) 11)));
        enumMap.put(e.SIGNATURE, new bo(InAppPurchaseMetaData.KEY_SIGNATURE, (byte) 1, new bp((byte) 11)));
        enumMap.put(e.SERIAL_NUM, new bo("serial_num", (byte) 1, new bp((byte) 8)));
        enumMap.put(e.TS_SECS, new bo("ts_secs", (byte) 1, new bp((byte) 8)));
        enumMap.put(e.LENGTH, new bo(cp.a.LENGTH, (byte) 1, new bp((byte) 8)));
        enumMap.put(e.ENTITY, new bo("entity", (byte) 1, new bp((byte) 11, true)));
        enumMap.put(e.GUID, new bo("guid", (byte) 1, new bp((byte) 11)));
        enumMap.put(e.CHECKSUM, new bo("checksum", (byte) 1, new bp((byte) 11)));
        enumMap.put(e.CODEX, new bo("codex", (byte) 2, new bp((byte) 8)));
        k = Collections.unmodifiableMap(enumMap);
        bo.a(b.class, k);
    }

    public b() {
        this.C = (byte) 0;
        this.D = new e[]{e.CODEX};
    }

    public String A() {
        return this.i;
    }

    public void B() {
        this.i = null;
    }

    public boolean C() {
        return this.i != null;
    }

    public int D() {
        return this.j;
    }

    public void E() {
        this.C = az.b(this.C, 3);
    }

    public boolean F() {
        return az.a(this.C, 3);
    }

    public void G() throws bi {
        if (this.f21108a == null) {
            throw new cc("Required field 'version' was not present! Struct: " + toString());
        }
        if (this.f21109b == null) {
            throw new cc("Required field 'address' was not present! Struct: " + toString());
        }
        if (this.f21110c == null) {
            throw new cc("Required field 'signature' was not present! Struct: " + toString());
        }
        if (this.g == null) {
            throw new cc("Required field 'entity' was not present! Struct: " + toString());
        }
        if (this.h == null) {
            throw new cc("Required field 'guid' was not present! Struct: " + toString());
        }
        if (this.i != null) {
            return;
        }
        throw new cc("Required field 'checksum' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.bc
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public b deepCopy() {
        return new b(this);
    }

    public String b() {
        return this.f21108a;
    }

    public void c() {
        this.f21108a = null;
    }

    @Override // com.umeng.analytics.pro.bc
    public void clear() {
        this.f21108a = null;
        this.f21109b = null;
        this.f21110c = null;
        d(false);
        this.f21111d = 0;
        e(false);
        this.f21112e = 0;
        f(false);
        this.f21113f = 0;
        this.g = null;
        this.h = null;
        this.i = null;
        j(false);
        this.j = 0;
    }

    public boolean d() {
        return this.f21108a != null;
    }

    public String e() {
        return this.f21109b;
    }

    public void f() {
        this.f21109b = null;
    }

    public boolean g() {
        return this.f21109b != null;
    }

    public String h() {
        return this.f21110c;
    }

    public void i() {
        this.f21110c = null;
    }

    public boolean j() {
        return this.f21110c != null;
    }

    public int k() {
        return this.f21111d;
    }

    public void l() {
        this.C = az.b(this.C, 0);
    }

    public boolean m() {
        return az.a(this.C, 0);
    }

    public int n() {
        return this.f21112e;
    }

    public void o() {
        this.C = az.b(this.C, 1);
    }

    public boolean p() {
        return az.a(this.C, 1);
    }

    public int q() {
        return this.f21113f;
    }

    public void r() {
        this.C = az.b(this.C, 2);
    }

    @Override // com.umeng.analytics.pro.bc
    public void read(cb cbVar) throws bi {
        x.get(cbVar.D()).b().b(cbVar, this);
    }

    public boolean s() {
        return az.a(this.C, 2);
    }

    public byte[] t() {
        a(bd.c(this.g));
        ByteBuffer byteBuffer = this.g;
        if (byteBuffer == null) {
            return null;
        }
        return byteBuffer.array();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UMSLEnvelope(");
        sb.append("version:");
        String str = this.f21108a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("address:");
        String str2 = this.f21109b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("signature:");
        String str3 = this.f21110c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("serial_num:");
        sb.append(this.f21111d);
        sb.append(", ");
        sb.append("ts_secs:");
        sb.append(this.f21112e);
        sb.append(", ");
        sb.append("length:");
        sb.append(this.f21113f);
        sb.append(", ");
        sb.append("entity:");
        ByteBuffer byteBuffer = this.g;
        if (byteBuffer == null) {
            sb.append("null");
        } else {
            bd.a(byteBuffer, sb);
        }
        sb.append(", ");
        sb.append("guid:");
        String str4 = this.h;
        if (str4 == null) {
            sb.append("null");
        } else {
            sb.append(str4);
        }
        sb.append(", ");
        sb.append("checksum:");
        String str5 = this.i;
        if (str5 == null) {
            sb.append("null");
        } else {
            sb.append(str5);
        }
        if (F()) {
            sb.append(", ");
            sb.append("codex:");
            sb.append(this.j);
        }
        sb.append(")");
        return sb.toString();
    }

    public ByteBuffer u() {
        return this.g;
    }

    public void v() {
        this.g = null;
    }

    public boolean w() {
        return this.g != null;
    }

    @Override // com.umeng.analytics.pro.bc
    public void write(cb cbVar) throws bi {
        x.get(cbVar.D()).b().a(cbVar, this);
    }

    public String x() {
        return this.h;
    }

    public void y() {
        this.h = null;
    }

    public boolean z() {
        return this.h != null;
    }

    /* JADX INFO: compiled from: UMSLEnvelope.java */
    public enum e implements bj {
        VERSION(1, "version"),
        ADDRESS(2, "address"),
        SIGNATURE(3, InAppPurchaseMetaData.KEY_SIGNATURE),
        SERIAL_NUM(4, "serial_num"),
        TS_SECS(5, "ts_secs"),
        LENGTH(6, cp.a.LENGTH),
        ENTITY(7, "entity"),
        GUID(8, "guid"),
        CHECKSUM(9, "checksum"),
        CODEX(10, "codex");

        private static final Map<String, e> k = new HashMap();
        private final short l;
        private final String m;

        static {
            for (e eVar : EnumSet.allOf(e.class)) {
                k.put(eVar.b(), eVar);
            }
        }

        e(short s, String str) {
            this.l = s;
            this.m = str;
        }

        public static e a(int i) {
            switch (i) {
                case 1:
                    return VERSION;
                case 2:
                    return ADDRESS;
                case 3:
                    return SIGNATURE;
                case 4:
                    return SERIAL_NUM;
                case 5:
                    return TS_SECS;
                case 6:
                    return LENGTH;
                case 7:
                    return ENTITY;
                case 8:
                    return GUID;
                case 9:
                    return CHECKSUM;
                case 10:
                    return CODEX;
                default:
                    return null;
            }
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
            return this.m;
        }

        public static e a(String str) {
            return k.get(str);
        }

        @Override // com.umeng.analytics.pro.bj
        public short a() {
            return this.l;
        }
    }

    public b a(String str) {
        this.f21108a = str;
        return this;
    }

    public b b(String str) {
        this.f21109b = str;
        return this;
    }

    public b c(String str) {
        this.f21110c = str;
        return this;
    }

    public void d(boolean z2) {
        this.C = az.a(this.C, 0, z2);
    }

    public void e(boolean z2) {
        this.C = az.a(this.C, 1, z2);
    }

    public void f(boolean z2) {
        this.C = az.a(this.C, 2, z2);
    }

    public void g(boolean z2) {
        if (z2) {
            return;
        }
        this.g = null;
    }

    public void h(boolean z2) {
        if (z2) {
            return;
        }
        this.h = null;
    }

    public void i(boolean z2) {
        if (z2) {
            return;
        }
        this.i = null;
    }

    public void j(boolean z2) {
        this.C = az.a(this.C, 3, z2);
    }

    public void a(boolean z2) {
        if (z2) {
            return;
        }
        this.f21108a = null;
    }

    public void b(boolean z2) {
        if (z2) {
            return;
        }
        this.f21109b = null;
    }

    public void c(boolean z2) {
        if (z2) {
            return;
        }
        this.f21110c = null;
    }

    public b d(String str) {
        this.h = str;
        return this;
    }

    public b e(String str) {
        this.i = str;
        return this;
    }

    public b(String str, String str2, String str3, int i, int i2, int i3, ByteBuffer byteBuffer, String str4, String str5) {
        this();
        this.f21108a = str;
        this.f21109b = str2;
        this.f21110c = str3;
        this.f21111d = i;
        d(true);
        this.f21112e = i2;
        e(true);
        this.f21113f = i3;
        f(true);
        this.g = byteBuffer;
        this.h = str4;
        this.i = str5;
    }

    public b a(int i) {
        this.f21111d = i;
        d(true);
        return this;
    }

    public b b(int i) {
        this.f21112e = i;
        e(true);
        return this;
    }

    public b c(int i) {
        this.f21113f = i;
        f(true);
        return this;
    }

    public b d(int i) {
        this.j = i;
        j(true);
        return this;
    }

    @Override // com.umeng.analytics.pro.bc
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i) {
        return e.a(i);
    }

    public b a(byte[] bArr) {
        a(bArr == null ? null : ByteBuffer.wrap(bArr));
        return this;
    }

    public b a(ByteBuffer byteBuffer) {
        this.g = byteBuffer;
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
            this.C = (byte) 0;
            read(new bv(new cn(objectInputStream)));
        } catch (bi e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public b(b bVar) {
        this.C = (byte) 0;
        this.D = new e[]{e.CODEX};
        this.C = bVar.C;
        if (bVar.d()) {
            this.f21108a = bVar.f21108a;
        }
        if (bVar.g()) {
            this.f21109b = bVar.f21109b;
        }
        if (bVar.j()) {
            this.f21110c = bVar.f21110c;
        }
        this.f21111d = bVar.f21111d;
        this.f21112e = bVar.f21112e;
        this.f21113f = bVar.f21113f;
        if (bVar.w()) {
            this.g = bd.d(bVar.g);
        }
        if (bVar.z()) {
            this.h = bVar.h;
        }
        if (bVar.C()) {
            this.i = bVar.i;
        }
        this.j = bVar.j;
    }
}
