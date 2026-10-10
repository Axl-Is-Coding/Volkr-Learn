package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.Nullable;
import com.umeng.analytics.pro.ci;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Qp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
@SuppressLint({"BadMethodUse-java.lang.String.length"})
public final class C1886Qp implements AnonymousClass00 {
    public static byte[] A09;
    public static String[] A0A;
    public static final String A0B;
    public final int A00;
    public final int A01;
    public final AnonymousClass08 A02;
    public final C0L A04;
    public final AnonymousClass87 A05;
    public final boolean A08;
    public final Map<String, File> A06 = Collections.synchronizedMap(new HashMap());
    public final Map<String, Semaphore> A07 = new HashMap();
    public final C0A A03 = new C0A();

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A09, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            int i5 = bArrCopyOfRange[i4] - i3;
            String[] strArr = A0A;
            if (strArr[5].length() == strArr[7].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0A;
            strArr2[5] = "m9U6X0moZlc";
            strArr2[7] = "IfCNkNm6kG";
            bArrCopyOfRange[i4] = (byte) (i5 - 76);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A09 = new byte[]{-105, -33, -40, -22, -105, -39, -36, -36, -27, -105, -32, -27, -21, -36, -23, -23, -20, -25, -21, -36, -37, -91, -63, -75, -5, -2, 1, -6, -75, -8, 1, -6, -10, 3, -6, -7, -49, -75, -125, 117, -106, -55, -55, -70, -62, -59, -55, -113, 117, -7, 23, 25, 30, 31, 36, 29, -42, 28, 31, 34, 27, -42, 25, 37, 35, 38, 34, 27, 42, 27, 4, 34, 36, 41, 42, 47, 40, -31, 39, 42, 45, 38, -31, 47, 48, 53, -31, 36, 48, 46, 49, 45, 38, 53, 38, -31, -91, -61, -59, -54, -53, -48, -55, -126, -47, -56, -126, -32, -2, 11, -60, 17, -67, 0, 9, 12, ci.n, 2, -67, 0, -2, 0, 5, 2, -67, 3, 6, 9, 2, -53, -80, -50, -37, -108, -31, -115, -33, -46, -50, -47, -115, -50, -32, -32, -46, -31, -32, -101, -69, -39, -26, -97, -20, -104, -22, -35, -39, -36, -104, -28, -35, -26, -33, -20, -32, -104, -25, -34, -104, -72, -39, -32, -39, -24, -35, -30, -37, -108, -41, -43, -41, -36, -39, -108, -38, -35, -32, -39, -108, -43, -38, -24, -39, -26, -108, -39, -20, -41, -39, -39, -40, -35, -30, -37, -108, -26, -39, -24, -26, -19, -108, -43, -24, -24, -39, -31, -28, -24, -25, -82, -108, -43, 2, 2, -1, 2, -80, -13, -15, -13, -8, -7, -2, -9, -80, 4, -8, -11, -80, -10, -7, -4, -11, -54, -9, -9, -12, -9, -91, -24, -15, -22, -26, -13, -18, -13, -20, -91, -21, -18, -15, -22, -72, -27, -27, -30, -27, -109, -42, -33, -30, -26, -36, -31, -38, -109, -26, -30, -24, -27, -42, -40, -72, -35, -46, -34, -36, -33, -37, -44, -29, -44, -113, -31, -44, -30, -33, -34, -35, -30, -44, -99, -65, -35, -28, -44, -39, -46, -117, -33, -38, -117, -35, -48, -52, -49, -117, -73, -70, -60, -51, -125, -68, -65, -62, -69, -125, -71, -73, -71, -66, -69, -18, 0, 0, -14, 1, -57, -68, -68, -68, 5, 8, 11, 4, -39, -50, -50, -50, 0, ci.k, 3, 17, ci.l, 8, 3, -2, 0, 18, 18, 4, 19, -50};
        String[] strArr = A0A;
        if (strArr[1].charAt(5) == strArr[3].charAt(5)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0A;
        strArr2[6] = "1YrvosXM8zHw8wsMUb3ulJ8Xgx5scBHO";
        strArr2[6] = "1YrvosXM8zHw8wsMUb3ulJ8Xgx5scBHO";
    }

    public static void A05() {
        A0A = new String[]{"2hmAfzTadn", "1uDqsMr9wv4o5ZghfCOZg4FuDp7sllqp", "nT1KYDstdBBAZ5nN", "UVqk4rMzzgqbiyaJgpoGMOUy0jQCoEBq", "ewXxsmpHr", "rT44HeCpkJQ", "C3kiv90mrVS0BL1BSM5Dfu9lHf0n3Csl", "grgxNBq6hb"};
    }

    static {
        A05();
        A04();
        A0B = C1886Qp.class.getSimpleName();
    }

    public C1886Qp(AnonymousClass87 anonymousClass87, AnonymousClass08 anonymousClass08, C0L c0l) {
        this.A05 = anonymousClass87;
        this.A08 = anonymousClass08.A02();
        this.A00 = anonymousClass08.A00();
        this.A04 = c0l;
        this.A01 = anonymousClass08.A01();
        this.A02 = anonymousClass08;
    }

    public static C0K A00(Context context, String str) throws C0H {
        try {
            InputStream inputStreamOpen = context.getAssets().open(str);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStreamOpen.read(bArr, 0, bArr.length);
                if (i != -1) {
                    byteArrayOutputStream.write(bArr, 0, i);
                } else {
                    return new C1888Qr(byteArrayOutputStream.toByteArray());
                }
            }
        } catch (IOException e2) {
            throw new C0H(A03(130, 18, 33), e2);
        }
    }

    public static File A01(Context context) {
        return new File(context.getCacheDir(), A03(317, 15, 10));
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00c8, code lost:
    
        r8 = r6.A04();
        r6.A07();
        r6 = java.lang.System.currentTimeMillis() - r13;
        r21.A00().A4B(r4, r16.A04);
        r16.A06.put(r10, r4);
        r16.A04.ACP(r10, 2112, null, java.lang.Integer.valueOf(r8), java.lang.Long.valueOf(r6), r17);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00f3, code lost:
    
        return r4;
     */
    /* JADX WARN: Not initialized variable reg: 10, insn: 0x0100: INVOKE 
      (r9v0 ?? I:com.facebook.ads.redexgen.X.0L)
      (r10 I:java.lang.String)
      (r11 I:int)
      (r12 I:java.lang.String)
      (r13 I:java.lang.Integer)
      (r14 I:java.lang.Long)
      (r15 I:com.facebook.ads.redexgen.X.06)
     INTERFACE call: com.facebook.ads.redexgen.X.0L.ACP(java.lang.String, int, java.lang.String, java.lang.Integer, java.lang.Long, com.facebook.ads.redexgen.X.06):void A[MD:(java.lang.String, int, java.lang.String, java.lang.Integer, java.lang.Long, com.facebook.ads.redexgen.X.06):void (m)], block:B:40:0x00f5 */
    /* JADX WARN: Not initialized variable reg: 10, insn: 0x011a: INVOKE 
      (r9v1 ?? I:com.facebook.ads.redexgen.X.0L)
      (r10 I:java.lang.String)
      (r11 I:int)
      (r12 I:java.lang.String)
      (r13 I:java.lang.Integer)
      (r14 I:java.lang.Long)
      (r15 I:com.facebook.ads.redexgen.X.06)
     INTERFACE call: com.facebook.ads.redexgen.X.0L.ACP(java.lang.String, int, java.lang.String, java.lang.Integer, java.lang.Long, com.facebook.ads.redexgen.X.06):void A[MD:(java.lang.String, int, java.lang.String, java.lang.Integer, java.lang.Long, com.facebook.ads.redexgen.X.06):void (m)], block:B:46:0x010f */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x00ff: MOVE (r15 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]) (LINE:49411), block:B:40:0x00f5 */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0119: MOVE (r15 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]) (LINE:49418), block:B:46:0x010f */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.io.File A02(com.facebook.ads.redexgen.X.AnonymousClass06 r17, java.lang.String r18, java.lang.String r19, int r20, com.facebook.ads.redexgen.X.AnonymousClass09 r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 296
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1886Qp.A02(com.facebook.ads.redexgen.X.06, java.lang.String, java.lang.String, int, com.facebook.ads.redexgen.X.09):java.io.File");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0111 A[Catch: all -> 0x0142, 0H -> 0x0144, TRY_ENTER, TRY_LEAVE, TryCatch #15 {0H -> 0x0144, all -> 0x0142, blocks: (B:12:0x0079, B:36:0x00fe, B:42:0x0111, B:34:0x00f8, B:26:0x00b6, B:28:0x00be), top: B:98:0x0079 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x016c A[Catch: all -> 0x0185, PHI: r21
      0x016c: PHI (r21v2 int) = (r21v0 int), (r21v1 int) binds: [B:70:0x0163, B:71:0x0165] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #6 {all -> 0x0185, blocks: (B:69:0x0161, B:72:0x016c), top: B:96:0x0161 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0165 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A06(android.content.Context r24, com.facebook.ads.redexgen.X.C1890Qt r25, java.lang.String r26, int r27, int r28, long r29) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 440
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1886Qp.A06(android.content.Context, com.facebook.ads.redexgen.X.Qt, java.lang.String, int, int, long):void");
    }

    @SuppressLint({"CatchGeneralException"})
    private void A07(C1890Qt c1890Qt) {
        try {
            File fileA05 = c1890Qt.A05();
            if (fileA05.exists()) {
                c1890Qt.A07();
                boolean zDelete = fileA05.delete();
                if (this.A08) {
                    Log.i(A0B, A03(169, 52, 40) + zDelete);
                }
            }
        } catch (Exception e2) {
            if (this.A08) {
                Log.e(A0B, A03(107, 23, 81), e2);
            }
        }
    }

    private boolean A08(C1890Qt c1890Qt) {
        try {
            c1890Qt.A06();
            return true;
        } catch (C1892Qv e2) {
            boolean z = this.A08;
            if (A0A[6].charAt(7) == 'U') {
                throw new RuntimeException();
            }
            String[] strArr = A0A;
            strArr[6] = "AEs2mSbxTVyMZvMH4XlDgcN9VznTkYzp";
            strArr[6] = "AEs2mSbxTVyMZvMH4XlDgcN9VznTkYzp";
            if (z) {
                Log.e(A0B, A03(243, 19, 57), e2);
                return false;
            }
            return false;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.09 != com.facebook.ads.cache.config.CacheRequestConfig<T> */
    public final <T> AnonymousClass02<T> A09(AnonymousClass06 anonymousClass06, AnonymousClass09<T> anonymousClass09) {
        Semaphore semaphore;
        if (anonymousClass09.A03()) {
            File file = this.A06.get(anonymousClass06.A09);
            if (file != null) {
                C0L c0l = this.A04;
                String str = anonymousClass06.A09;
                if (A0A[6].charAt(7) == 'U') {
                    throw new RuntimeException();
                }
                String[] strArr = A0A;
                strArr[0] = "ARXa8ML4Mz";
                strArr[4] = "7SNAJeIyn";
                c0l.ACQ(str, true, anonymousClass06);
                return anonymousClass09.A00().A3E(file, this.A04);
            }
            this.A04.ACQ(anonymousClass06.A09, false, anonymousClass06);
            return new AnonymousClass02<>(false, null);
        }
        String str2 = anonymousClass06.A09;
        String str3 = this.A03.A03(str2) + anonymousClass06.A04;
        synchronized (this.A07) {
            semaphore = this.A07.get(str3);
            if (semaphore == null) {
                semaphore = new Semaphore(1);
                this.A07.put(str3, semaphore);
            }
            try {
            } catch (Throwable th) {
                semaphore.release();
                synchronized (this.A07) {
                    this.A07.remove(str3);
                    throw th;
                }
            }
        }
        try {
            semaphore.acquire();
            File fileA02 = A02(anonymousClass06, str2, str3, this.A01, anonymousClass09);
            if (fileA02 != null) {
                AnonymousClass02<T> anonymousClass02A3E = anonymousClass09.A00().A3E(fileA02, this.A04);
                semaphore.release();
                synchronized (this.A07) {
                    this.A07.remove(str3);
                }
                return anonymousClass02A3E;
            }
            AnonymousClass02<T> anonymousClass02 = new AnonymousClass02<>(false, null);
            semaphore.release();
            synchronized (this.A07) {
                this.A07.remove(str3);
            }
            return anonymousClass02;
        } catch (InterruptedException unused) {
            if (this.A08) {
                String str4 = A03(96, 11, 22) + str2 + A03(0, 22, 43);
            }
            AnonymousClass02<T> anonymousClass022 = new AnonymousClass02<>(false, null);
            semaphore.release();
            synchronized (this.A07) {
                this.A07.remove(str3);
                return anonymousClass022;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass00
    public final AnonymousClass02<Bitmap> ACq(AnonymousClass06 anonymousClass06, boolean z) {
        return A09(anonymousClass06, new AnonymousClass09(new C1884Qn(anonymousClass06.A01, anonymousClass06.A00, this.A02.A04(), this.A02.A03(), z)));
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass00
    @Nullable
    public final String ACr(AnonymousClass06 anonymousClass06) {
        return (String) A09(anonymousClass06, new AnonymousClass09(new C1885Qo())).A00();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.09 != com.facebook.ads.cache.config.CacheRequestConfig<java.lang.String> */
    @Override // com.facebook.ads.redexgen.X.AnonymousClass00
    @Nullable
    public final String ACs(AnonymousClass06 anonymousClass06) {
        AnonymousClass09 anonymousClass09 = new AnonymousClass09(new C1885Qo());
        anonymousClass09.A01(true);
        anonymousClass09.A02(false);
        return (String) A09(anonymousClass06, anonymousClass09).A00();
    }
}
