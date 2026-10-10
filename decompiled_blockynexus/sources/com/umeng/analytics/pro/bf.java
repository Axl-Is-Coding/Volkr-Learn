package com.umeng.analytics.pro;

import com.umeng.analytics.pro.bv;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: TDeserializer.java */
/* JADX INFO: loaded from: classes5.dex */
public class bf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final cb f20706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final co f20707b;

    public bf() {
        this(new bv.a());
    }

    private bw j(byte[] bArr, bj bjVar, bj... bjVarArr) throws bi {
        this.f20707b.a(bArr);
        bj[] bjVarArr2 = new bj[bjVarArr.length + 1];
        int i = 0;
        bjVarArr2[0] = bjVar;
        int i2 = 0;
        while (i2 < bjVarArr.length) {
            int i3 = i2 + 1;
            bjVarArr2[i3] = bjVarArr[i2];
            i2 = i3;
        }
        this.f20706a.j();
        bw bwVarL = null;
        while (i < bjVarArr2.length) {
            bwVarL = this.f20706a.l();
            if (bwVarL.f20755b == 0 || bwVarL.f20756c > bjVarArr2[i].a()) {
                return null;
            }
            if (bwVarL.f20756c != bjVarArr2[i].a()) {
                ce.a(this.f20706a, bwVarL.f20755b);
                this.f20706a.m();
            } else {
                i++;
                if (i < bjVarArr2.length) {
                    this.f20706a.j();
                }
            }
        }
        return bwVarL;
    }

    public void a(bc bcVar, byte[] bArr) throws bi {
        try {
            this.f20707b.a(bArr);
            bcVar.read(this.f20706a);
        } finally {
            this.f20707b.e();
            this.f20706a.B();
        }
    }

    public Byte b(byte[] bArr, bj bjVar, bj... bjVarArr) throws bi {
        return (Byte) a((byte) 3, bArr, bjVar, bjVarArr);
    }

    public Double c(byte[] bArr, bj bjVar, bj... bjVarArr) throws bi {
        return (Double) a((byte) 4, bArr, bjVar, bjVarArr);
    }

    public Short d(byte[] bArr, bj bjVar, bj... bjVarArr) throws bi {
        return (Short) a((byte) 6, bArr, bjVar, bjVarArr);
    }

    public Integer e(byte[] bArr, bj bjVar, bj... bjVarArr) throws bi {
        return (Integer) a((byte) 8, bArr, bjVar, bjVarArr);
    }

    public Long f(byte[] bArr, bj bjVar, bj... bjVarArr) throws bi {
        return (Long) a((byte) 10, bArr, bjVar, bjVarArr);
    }

    public String g(byte[] bArr, bj bjVar, bj... bjVarArr) throws bi {
        return (String) a((byte) 11, bArr, bjVar, bjVarArr);
    }

    public ByteBuffer h(byte[] bArr, bj bjVar, bj... bjVarArr) throws bi {
        return (ByteBuffer) a((byte) 100, bArr, bjVar, bjVarArr);
    }

    public Short i(byte[] bArr, bj bjVar, bj... bjVarArr) throws bi {
        Short shValueOf;
        try {
            try {
                if (j(bArr, bjVar, bjVarArr) != null) {
                    this.f20706a.j();
                    shValueOf = Short.valueOf(this.f20706a.l().f20756c);
                } else {
                    shValueOf = null;
                }
                return shValueOf;
            } catch (Exception e2) {
                throw new bi(e2);
            }
        } finally {
            this.f20707b.e();
            this.f20706a.B();
        }
    }

    public bf(cd cdVar) {
        this.f20707b = new co();
        this.f20706a = cdVar.a(this.f20707b);
    }

    public void a(bc bcVar, String str, String str2) throws bi {
        try {
            try {
                a(bcVar, str.getBytes(str2));
            } catch (UnsupportedEncodingException unused) {
                throw new bi("JVM DOES NOT SUPPORT ENCODING: " + str2);
            }
        } finally {
            this.f20706a.B();
        }
    }

    public void a(bc bcVar, byte[] bArr, bj bjVar, bj... bjVarArr) throws bi {
        try {
            try {
                if (j(bArr, bjVar, bjVarArr) != null) {
                    bcVar.read(this.f20706a);
                }
            } catch (Exception e2) {
                throw new bi(e2);
            }
        } finally {
            this.f20707b.e();
            this.f20706a.B();
        }
    }

    public Boolean a(byte[] bArr, bj bjVar, bj... bjVarArr) throws bi {
        return (Boolean) a((byte) 2, bArr, bjVar, bjVarArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.Object a(byte r1, byte[] r2, com.umeng.analytics.pro.bj r3, com.umeng.analytics.pro.bj... r4) throws com.umeng.analytics.pro.bi {
        /*
            r0 = this;
            com.umeng.analytics.pro.bw r2 = r0.j(r2, r3, r4)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            if (r2 == 0) goto L9e
            r3 = 2
            if (r1 == r3) goto L8f
            r3 = 3
            if (r1 == r3) goto L80
            r3 = 4
            if (r1 == r3) goto L71
            r3 = 6
            if (r1 == r3) goto L62
            r3 = 8
            if (r1 == r3) goto L53
            r3 = 100
            r4 = 11
            if (r1 == r3) goto L48
            r3 = 10
            if (r1 == r3) goto L39
            if (r1 == r4) goto L24
            goto L9e
        L24:
            byte r1 = r2.f20755b     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            if (r1 != r4) goto L9e
            com.umeng.analytics.pro.cb r1 = r0.f20706a     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            java.lang.String r1 = r1.z()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
        L2e:
            com.umeng.analytics.pro.co r2 = r0.f20707b
            r2.e()
            com.umeng.analytics.pro.cb r2 = r0.f20706a
            r2.B()
            return r1
        L39:
            byte r1 = r2.f20755b     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            if (r1 != r3) goto L9e
            com.umeng.analytics.pro.cb r1 = r0.f20706a     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            long r1 = r1.x()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            goto L2e
        L48:
            byte r1 = r2.f20755b     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            if (r1 != r4) goto L9e
            com.umeng.analytics.pro.cb r1 = r0.f20706a     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            java.nio.ByteBuffer r1 = r1.A()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            goto L2e
        L53:
            byte r1 = r2.f20755b     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            if (r1 != r3) goto L9e
            com.umeng.analytics.pro.cb r1 = r0.f20706a     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            int r1 = r1.w()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            goto L2e
        L62:
            byte r1 = r2.f20755b     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            if (r1 != r3) goto L9e
            com.umeng.analytics.pro.cb r1 = r0.f20706a     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            short r1 = r1.v()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            java.lang.Short r1 = java.lang.Short.valueOf(r1)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            goto L2e
        L71:
            byte r1 = r2.f20755b     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            if (r1 != r3) goto L9e
            com.umeng.analytics.pro.cb r1 = r0.f20706a     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            double r1 = r1.y()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            java.lang.Double r1 = java.lang.Double.valueOf(r1)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            goto L2e
        L80:
            byte r1 = r2.f20755b     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            if (r1 != r3) goto L9e
            com.umeng.analytics.pro.cb r1 = r0.f20706a     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            byte r1 = r1.u()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            java.lang.Byte r1 = java.lang.Byte.valueOf(r1)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            goto L2e
        L8f:
            byte r1 = r2.f20755b     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            if (r1 != r3) goto L9e
            com.umeng.analytics.pro.cb r1 = r0.f20706a     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            boolean r1 = r1.t()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            goto L2e
        L9e:
            r1 = 0
            goto L2e
        La0:
            r1 = move-exception
            goto La9
        La2:
            r1 = move-exception
            com.umeng.analytics.pro.bi r2 = new com.umeng.analytics.pro.bi     // Catch: java.lang.Throwable -> La0
            r2.<init>(r1)     // Catch: java.lang.Throwable -> La0
            throw r2     // Catch: java.lang.Throwable -> La0
        La9:
            com.umeng.analytics.pro.co r2 = r0.f20707b
            r2.e()
            com.umeng.analytics.pro.cb r2 = r0.f20706a
            r2.B()
            goto Lb5
        Lb4:
            throw r1
        Lb5:
            goto Lb4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.bf.a(byte, byte[], com.umeng.analytics.pro.bj, com.umeng.analytics.pro.bj[]):java.lang.Object");
    }

    public void a(bc bcVar, String str) throws bi {
        a(bcVar, str.getBytes());
    }
}
