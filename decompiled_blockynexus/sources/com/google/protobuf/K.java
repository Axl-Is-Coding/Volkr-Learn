package com.google.protobuf;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: UnknownFieldSetLite.java */
/* JADX INFO: loaded from: classes2.dex */
public final class K {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final K f14314a = new K(0, new int[0], new Object[0], false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f14315b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int[] f14316c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object[] f14317d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f14318e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f14319f;

    private K() {
        this(0, new int[8], new Object[8], true);
    }

    static K a(K k, K k2) {
        int i = k.f14315b + k2.f14315b;
        int[] iArrCopyOf = Arrays.copyOf(k.f14316c, i);
        System.arraycopy(k2.f14316c, 0, iArrCopyOf, k.f14315b, k2.f14315b);
        Object[] objArrCopyOf = Arrays.copyOf(k.f14317d, i);
        System.arraycopy(k2.f14317d, 0, objArrCopyOf, k.f14315b, k2.f14315b);
        return new K(i, iArrCopyOf, objArrCopyOf, true);
    }

    public static K b() {
        return f14314a;
    }

    static K d() {
        return new K();
    }

    private void e() {
        int i = this.f14315b;
        if (i == this.f14316c.length) {
            int i2 = this.f14315b + (i < 4 ? 8 : i >> 1);
            this.f14316c = Arrays.copyOf(this.f14316c, i2);
            this.f14317d = Arrays.copyOf(this.f14317d, i2);
        }
    }

    public void c() {
        this.f14319f = false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof K)) {
            return false;
        }
        K k = (K) obj;
        return this.f14315b == k.f14315b && Arrays.equals(this.f14316c, k.f14316c) && Arrays.deepEquals(this.f14317d, k.f14317d);
    }

    public int hashCode() {
        return ((((527 + this.f14315b) * 31) + Arrays.hashCode(this.f14316c)) * 31) + Arrays.deepHashCode(this.f14317d);
    }

    private K(int i, int[] iArr, Object[] objArr, boolean z) {
        this.f14318e = -1;
        this.f14315b = i;
        this.f14316c = iArr;
        this.f14317d = objArr;
        this.f14319f = z;
    }

    void a() {
        if (!this.f14319f) {
            throw new UnsupportedOperationException();
        }
    }

    final void a(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.f14315b; i2++) {
            z.a(sb, i, String.valueOf(WireFormat.a(this.f14316c[i2])), this.f14317d[i2]);
        }
    }

    private void a(int i, Object obj) {
        e();
        int[] iArr = this.f14316c;
        int i2 = this.f14315b;
        iArr[i2] = i;
        this.f14317d[i2] = obj;
        this.f14315b = i2 + 1;
    }

    boolean a(int i, C2301g c2301g) throws IOException {
        a();
        int iA = WireFormat.a(i);
        int iB = WireFormat.b(i);
        if (iB == 0) {
            a(i, Long.valueOf(c2301g.i()));
            return true;
        }
        if (iB == 1) {
            a(i, Long.valueOf(c2301g.g()));
            return true;
        }
        if (iB == 2) {
            a(i, c2301g.d());
            return true;
        }
        if (iB == 3) {
            K k = new K();
            k.a(c2301g);
            c2301g.a(WireFormat.a(iA, 4));
            a(i, k);
            return true;
        }
        if (iB == 4) {
            return false;
        }
        if (iB == 5) {
            a(i, Integer.valueOf(c2301g.f()));
            return true;
        }
        throw InvalidProtocolBufferException.invalidWireType();
    }

    K a(int i, int i2) {
        a();
        if (i != 0) {
            a(WireFormat.a(i, 0), Long.valueOf(i2));
            return this;
        }
        throw new IllegalArgumentException("Zero is not a valid field number.");
    }

    K a(int i, ByteString byteString) {
        a();
        if (i != 0) {
            a(WireFormat.a(i, 2), (Object) byteString);
            return this;
        }
        throw new IllegalArgumentException("Zero is not a valid field number.");
    }

    private K a(C2301g c2301g) throws IOException {
        int iQ;
        do {
            iQ = c2301g.q();
            if (iQ == 0) {
                break;
            }
        } while (a(iQ, c2301g));
        return this;
    }
}
