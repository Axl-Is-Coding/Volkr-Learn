package com.umeng.analytics.pro;

import com.tendcloud.tenddata.cp;
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

/* JADX INFO: compiled from: UMEnvelope.java */
/* JADX INFO: loaded from: classes5.dex */
public class av implements bc<av, e>, Serializable, Cloneable {
    private static final int A = 2;
    private static final int B = 3;
    public static final Map<e, bo> k;
    private static final long l = 420342210744516016L;
    private static final cg m = new cg("UMEnvelope");
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
    public String f20664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f20665b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f20666c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f20667d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f20668e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f20669f;
    public ByteBuffer g;
    public String h;
    public String i;
    public int j;

    /* JADX INFO: compiled from: UMEnvelope.java */
    private static class a extends cl<av> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cj
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(cb cbVar, av avVar) throws bi {
            cbVar.j();
            while (true) {
                bw bwVarL = cbVar.l();
                byte b2 = bwVarL.f20755b;
                if (b2 == 0) {
                    cbVar.k();
                    if (!avVar.m()) {
                        throw new cc("Required field 'serial_num' was not found in serialized data! Struct: " + toString());
                    }
                    if (!avVar.p()) {
                        throw new cc("Required field 'ts_secs' was not found in serialized data! Struct: " + toString());
                    }
                    if (avVar.s()) {
                        avVar.G();
                        return;
                    }
                    throw new cc("Required field 'length' was not found in serialized data! Struct: " + toString());
                }
                switch (bwVarL.f20756c) {
                    case 1:
                        if (b2 != 11) {
                            ce.a(cbVar, b2);
                        } else {
                            avVar.f20664a = cbVar.z();
                            avVar.a(true);
                        }
                        break;
                    case 2:
                        if (b2 != 11) {
                            ce.a(cbVar, b2);
                        } else {
                            avVar.f20665b = cbVar.z();
                            avVar.b(true);
                        }
                        break;
                    case 3:
                        if (b2 != 11) {
                            ce.a(cbVar, b2);
                        } else {
                            avVar.f20666c = cbVar.z();
                            avVar.c(true);
                        }
                        break;
                    case 4:
                        if (b2 != 8) {
                            ce.a(cbVar, b2);
                        } else {
                            avVar.f20667d = cbVar.w();
                            avVar.d(true);
                        }
                        break;
                    case 5:
                        if (b2 != 8) {
                            ce.a(cbVar, b2);
                        } else {
                            avVar.f20668e = cbVar.w();
                            avVar.e(true);
                        }
                        break;
                    case 6:
                        if (b2 != 8) {
                            ce.a(cbVar, b2);
                        } else {
                            avVar.f20669f = cbVar.w();
                            avVar.f(true);
                        }
                        break;
                    case 7:
                        if (b2 != 11) {
                            ce.a(cbVar, b2);
                        } else {
                            avVar.g = cbVar.A();
                            avVar.g(true);
                        }
                        break;
                    case 8:
                        if (b2 != 11) {
                            ce.a(cbVar, b2);
                        } else {
                            avVar.h = cbVar.z();
                            avVar.h(true);
                        }
                        break;
                    case 9:
                        if (b2 != 11) {
                            ce.a(cbVar, b2);
                        } else {
                            avVar.i = cbVar.z();
                            avVar.i(true);
                        }
                        break;
                    case 10:
                        if (b2 != 8) {
                            ce.a(cbVar, b2);
                        } else {
                            avVar.j = cbVar.w();
                            avVar.j(true);
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
        public void a(cb cbVar, av avVar) throws bi {
            avVar.G();
            cbVar.a(av.m);
            if (avVar.f20664a != null) {
                cbVar.a(av.n);
                cbVar.a(avVar.f20664a);
                cbVar.c();
            }
            if (avVar.f20665b != null) {
                cbVar.a(av.o);
                cbVar.a(avVar.f20665b);
                cbVar.c();
            }
            if (avVar.f20666c != null) {
                cbVar.a(av.p);
                cbVar.a(avVar.f20666c);
                cbVar.c();
            }
            cbVar.a(av.q);
            cbVar.a(avVar.f20667d);
            cbVar.c();
            cbVar.a(av.r);
            cbVar.a(avVar.f20668e);
            cbVar.c();
            cbVar.a(av.s);
            cbVar.a(avVar.f20669f);
            cbVar.c();
            if (avVar.g != null) {
                cbVar.a(av.t);
                cbVar.a(avVar.g);
                cbVar.c();
            }
            if (avVar.h != null) {
                cbVar.a(av.u);
                cbVar.a(avVar.h);
                cbVar.c();
            }
            if (avVar.i != null) {
                cbVar.a(av.v);
                cbVar.a(avVar.i);
                cbVar.c();
            }
            if (avVar.F()) {
                cbVar.a(av.w);
                cbVar.a(avVar.j);
                cbVar.c();
            }
            cbVar.d();
            cbVar.b();
        }
    }

    /* JADX INFO: compiled from: UMEnvelope.java */
    private static class b implements ck {
        private b() {
        }

        @Override // com.umeng.analytics.pro.ck
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    /* JADX INFO: compiled from: UMEnvelope.java */
    private static class c extends cm<av> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cj
        public void a(cb cbVar, av avVar) throws bi {
            ch chVar = (ch) cbVar;
            chVar.a(avVar.f20664a);
            chVar.a(avVar.f20665b);
            chVar.a(avVar.f20666c);
            chVar.a(avVar.f20667d);
            chVar.a(avVar.f20668e);
            chVar.a(avVar.f20669f);
            chVar.a(avVar.g);
            chVar.a(avVar.h);
            chVar.a(avVar.i);
            BitSet bitSet = new BitSet();
            if (avVar.F()) {
                bitSet.set(0);
            }
            chVar.a(bitSet, 1);
            if (avVar.F()) {
                chVar.a(avVar.j);
            }
        }

        @Override // com.umeng.analytics.pro.cj
        public void b(cb cbVar, av avVar) throws bi {
            ch chVar = (ch) cbVar;
            avVar.f20664a = chVar.z();
            avVar.a(true);
            avVar.f20665b = chVar.z();
            avVar.b(true);
            avVar.f20666c = chVar.z();
            avVar.c(true);
            avVar.f20667d = chVar.w();
            avVar.d(true);
            avVar.f20668e = chVar.w();
            avVar.e(true);
            avVar.f20669f = chVar.w();
            avVar.f(true);
            avVar.g = chVar.A();
            avVar.g(true);
            avVar.h = chVar.z();
            avVar.h(true);
            avVar.i = chVar.z();
            avVar.i(true);
            if (chVar.b(1).get(0)) {
                avVar.j = chVar.w();
                avVar.j(true);
            }
        }
    }

    /* JADX INFO: compiled from: UMEnvelope.java */
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
        x.put(cl.class, new b());
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
        bo.a(av.class, k);
    }

    public av() {
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
        if (this.f20664a == null) {
            throw new cc("Required field 'version' was not present! Struct: " + toString());
        }
        if (this.f20665b == null) {
            throw new cc("Required field 'address' was not present! Struct: " + toString());
        }
        if (this.f20666c == null) {
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
    public av deepCopy() {
        return new av(this);
    }

    public String b() {
        return this.f20664a;
    }

    public void c() {
        this.f20664a = null;
    }

    @Override // com.umeng.analytics.pro.bc
    public void clear() {
        this.f20664a = null;
        this.f20665b = null;
        this.f20666c = null;
        d(false);
        this.f20667d = 0;
        e(false);
        this.f20668e = 0;
        f(false);
        this.f20669f = 0;
        this.g = null;
        this.h = null;
        this.i = null;
        j(false);
        this.j = 0;
    }

    public boolean d() {
        return this.f20664a != null;
    }

    public String e() {
        return this.f20665b;
    }

    public void f() {
        this.f20665b = null;
    }

    public boolean g() {
        return this.f20665b != null;
    }

    public String h() {
        return this.f20666c;
    }

    public void i() {
        this.f20666c = null;
    }

    public boolean j() {
        return this.f20666c != null;
    }

    public int k() {
        return this.f20667d;
    }

    public void l() {
        this.C = az.b(this.C, 0);
    }

    public boolean m() {
        return az.a(this.C, 0);
    }

    public int n() {
        return this.f20668e;
    }

    public void o() {
        this.C = az.b(this.C, 1);
    }

    public boolean p() {
        return az.a(this.C, 1);
    }

    public int q() {
        return this.f20669f;
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
        StringBuilder sb = new StringBuilder("UMEnvelope(");
        sb.append("version:");
        String str = this.f20664a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("address:");
        String str2 = this.f20665b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("signature:");
        String str3 = this.f20666c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("serial_num:");
        sb.append(this.f20667d);
        sb.append(", ");
        sb.append("ts_secs:");
        sb.append(this.f20668e);
        sb.append(", ");
        sb.append("length:");
        sb.append(this.f20669f);
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

    /* JADX INFO: compiled from: UMEnvelope.java */
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

    public av a(String str) {
        this.f20664a = str;
        return this;
    }

    public av b(String str) {
        this.f20665b = str;
        return this;
    }

    public av c(String str) {
        this.f20666c = str;
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
        this.f20664a = null;
    }

    public void b(boolean z2) {
        if (z2) {
            return;
        }
        this.f20665b = null;
    }

    public void c(boolean z2) {
        if (z2) {
            return;
        }
        this.f20666c = null;
    }

    public av d(String str) {
        this.h = str;
        return this;
    }

    public av e(String str) {
        this.i = str;
        return this;
    }

    public av(String str, String str2, String str3, int i, int i2, int i3, ByteBuffer byteBuffer, String str4, String str5) {
        this();
        this.f20664a = str;
        this.f20665b = str2;
        this.f20666c = str3;
        this.f20667d = i;
        d(true);
        this.f20668e = i2;
        e(true);
        this.f20669f = i3;
        f(true);
        this.g = byteBuffer;
        this.h = str4;
        this.i = str5;
    }

    public av a(int i) {
        this.f20667d = i;
        d(true);
        return this;
    }

    public av b(int i) {
        this.f20668e = i;
        e(true);
        return this;
    }

    public av c(int i) {
        this.f20669f = i;
        f(true);
        return this;
    }

    public av d(int i) {
        this.j = i;
        j(true);
        return this;
    }

    @Override // com.umeng.analytics.pro.bc
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i) {
        return e.a(i);
    }

    public av a(byte[] bArr) {
        a(bArr == null ? null : ByteBuffer.wrap(bArr));
        return this;
    }

    public av a(ByteBuffer byteBuffer) {
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

    public av(av avVar) {
        this.C = (byte) 0;
        this.D = new e[]{e.CODEX};
        this.C = avVar.C;
        if (avVar.d()) {
            this.f20664a = avVar.f20664a;
        }
        if (avVar.g()) {
            this.f20665b = avVar.f20665b;
        }
        if (avVar.j()) {
            this.f20666c = avVar.f20666c;
        }
        this.f20667d = avVar.f20667d;
        this.f20668e = avVar.f20668e;
        this.f20669f = avVar.f20669f;
        if (avVar.w()) {
            this.g = bd.d(avVar.g);
        }
        if (avVar.z()) {
            this.h = avVar.h;
        }
        if (avVar.C()) {
            this.i = avVar.i;
        }
        this.j = avVar.j;
    }
}
