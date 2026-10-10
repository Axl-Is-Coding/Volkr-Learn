package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import com.facebook.ads.internal.exoplayer2.drm.DrmInitData;
import com.facebook.ads.redexgen.X.Bv;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
@TargetApi(18)
public final class C2073Xw<T extends Bv> implements InterfaceC1521Bu<T>, Bb<T> {
    public static byte[] A0D;
    public static String[] A0E;
    public int A00;
    public Looper A01;
    public byte[] A02;
    public final int A03;
    public final C1515Bh A04;
    public final C1<T> A05;
    public final C5 A06;
    public final HashMap<String, String> A07;
    public final List<C2070Xt<T>> A08;
    public final List<C2070Xt<T>> A09;
    public final UUID A0A;
    public final boolean A0B;

    /* JADX WARN: Incorrect inner types in field signature: Lcom/facebook/ads/redexgen/X/Xw<TT;>.MediaDrmHandler; */
    public volatile HandlerC1517Bk A0C;

    static {
        A04();
        A03();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0D, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 37);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A0D = new byte[]{74, 107, 104, 111, 123, 98, 122, 74, 124, 99, 93, 107, 125, 125, 103, 97, 96, 67, 105, 124, 9, Utf8.REPLACEMENT_BYTE, 32, 4, 35, 36, 57, 9, 44, 57, 44, 109, 34, 35, 33, 52, 109, 46, 34, 35, 57, 44, 36, 35, 62, 109, 46, 34, 32, 32, 34, 35, 109, 29, 30, 30, 5, 109, 30, 46, 37, 40, 32, 40, 9, 44, 57, 44, 99, 109, 12, 62, 62, 56, 32, 36, 35, 42, 109, 62, 56, 61, 61, 34, Utf8.REPLACEMENT_BYTE, 57, 109, 43, 34, Utf8.REPLACEMENT_BYTE, 119, 109, 109, 108, 109, Utf8.REPLACEMENT_BYTE, 120, 121, 120, 104, 10, 12, 7, 10, 49, 55, 60, 33};
    }

    public static void A04() {
        A0E = new String[]{"0jHq0iWGhsIySlQoDiDGup3biHh1u6", "i2l5O7Dt7qLUzCpPXTMvAA2Zo4KmgWR2", "WWWB5", "5af5rLtbMnzIwH5Nva3tIodv6", "N1ag4SyeR1bkHrLLU69ntDAZG70pDTMe", "aZncB9cokv9961OmHq", "gIBDsbvLQEgXIogWiAeZHaFgFZc1jweS", "Prja9buVBy0glhaqAx1SHba3MELDXzlR"};
    }

    public static DrmInitData.SchemeData A00(DrmInitData drmInitData, UUID uuid, boolean z) {
        ArrayList arrayList = new ArrayList(drmInitData.A01);
        int i = 0;
        while (true) {
            boolean z2 = false;
            if (i < drmInitData.A01) {
                DrmInitData.SchemeData schemeDataA02 = drmInitData.A02(i);
                boolean zA03 = schemeDataA02.A03(uuid);
                if (A0E[0].length() != 30) {
                    break;
                }
                String[] strArr = A0E;
                strArr[2] = "V0Q9eaLMfBF3CEdW";
                strArr[2] = "V0Q9eaLMfBF3CEdW";
                if (zA03 || (C14729o.A01.equals(uuid) && schemeDataA02.A03(C14729o.A02))) {
                    z2 = true;
                }
                if (z2 && (schemeDataA02.A04 != null || z)) {
                    arrayList.add(schemeDataA02);
                }
                i++;
            } else {
                if (arrayList.isEmpty()) {
                    return null;
                }
                if (C14729o.A05.equals(uuid)) {
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        DrmInitData.SchemeData schemeData = (DrmInitData.SchemeData) arrayList.get(i2);
                        int version = schemeData.A02() ? C1542Ct.A00(schemeData.A04) : -1;
                        if (IW.A02 < 23 && version == 0) {
                            return schemeData;
                        }
                        if (IW.A02 >= 23 && version == 1) {
                            return schemeData;
                        }
                    }
                }
                DrmInitData.SchemeData schemeData2 = (DrmInitData.SchemeData) arrayList.get(0);
                if (A0E[6].charAt(29) == 'w') {
                    String[] strArr2 = A0E;
                    strArr2[7] = "QMUEyZuv57oImxraVf5zIpun0ErJkPMX";
                    strArr2[7] = "QMUEyZuv57oImxraVf5zIpun0ErJkPMX";
                    return schemeData2;
                }
            }
        }
        throw new RuntimeException();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Xw != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSessionManager<T extends com.facebook.ads.redexgen.X.Bv> */
    public final void A05(Handler handler, Bi bi) {
        this.A04.A03(handler, bi);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Xt != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T extends com.facebook.ads.redexgen.X.Bv> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Xw != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSessionManager<T extends com.facebook.ads.redexgen.X.Bv> */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.facebook.ads.redexgen.X.InterfaceC1521Bu
    public final InterfaceC1520Bt<T> A2Q(Looper looper, DrmInitData drmInitData) {
        Looper looper2 = this.A01;
        C1662Hr.A04(looper2 == null || looper2 == looper);
        if (this.A09.isEmpty()) {
            this.A01 = looper;
            if (this.A0C == null) {
                this.A0C = new HandlerC1517Bk(this, looper);
            }
        }
        DrmInitData.SchemeData schemeDataA00 = null;
        C2070Xt<T> c2070Xt = null;
        if (this.A02 == null && (schemeDataA00 = A00(drmInitData, this.A0A, false)) == null) {
            Bl bl = new Bl(this.A0A);
            this.A04.A04(bl);
            return new C2074Xx(new C1519Br(bl));
        }
        if (this.A0B) {
            if (A0E[6].charAt(29) == 'w') {
                String[] strArr = A0E;
                strArr[7] = "2tfSkouS8gaRHNrU7OMeTyiBrWH6VnUA";
                strArr[7] = "2tfSkouS8gaRHNrU7OMeTyiBrWH6VnUA";
                byte[] bArr = schemeDataA00 != null ? schemeDataA00.A04 : null;
                Iterator<C2070Xt<T>> it = this.A09.iterator();
                while (true) {
                    if (it.hasNext()) {
                        C2070Xt<T> next = it.next();
                        if (next.A0N(bArr)) {
                            c2070Xt = next;
                            break;
                        }
                    } else {
                        c2070Xt = null;
                        break;
                    }
                }
            } else {
                throw new RuntimeException();
            }
        } else if (!this.A09.isEmpty()) {
            C2070Xt<T> c2070Xt2 = this.A09.get(0);
            if (A0E[0].length() != 30) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0E;
            strArr2[5] = "NYlDF58TVUPxDFfWvHrOlngI";
            strArr2[5] = "NYlDF58TVUPxDFfWvHrOlngI";
            c2070Xt = c2070Xt2;
        }
        if (c2070Xt == null) {
            c2070Xt = new C2070Xt<>(this.A0A, this.A05, this, schemeDataA00, this.A00, this.A02, this.A07, this.A06, looper, this.A04, this.A03);
            this.A09.add(c2070Xt);
        }
        c2070Xt.A0H();
        return c2070Xt;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Xw != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSessionManager<T extends com.facebook.ads.redexgen.X.Bv> */
    @Override // com.facebook.ads.redexgen.X.InterfaceC1521Bu
    public final boolean A3x(@NonNull DrmInitData drmInitData) {
        if (this.A02 != null) {
            return true;
        }
        DrmInitData.SchemeData schemeDataA00 = A00(drmInitData, this.A0A, true);
        if (A0E[2].length() == 25) {
            throw new RuntimeException();
        }
        String[] strArr = A0E;
        strArr[2] = "f9Fo7yPZ7tYjgWekbXY";
        strArr[2] = "f9Fo7yPZ7tYjgWekbXY";
        if (schemeDataA00 == null) {
            if (drmInitData.A01 != 1 || !drmInitData.A02(0).A03(C14729o.A02)) {
                return false;
            }
            Log.w(A01(0, 20, 43), A01(20, 72, 104) + this.A0A);
        }
        String str = drmInitData.A02;
        if (str == null || A01(100, 4, 76).equals(str)) {
            return true;
        }
        return !(A01(92, 4, 43).equals(str) || A01(96, 4, 62).equals(str) || A01(104, 4, 119).equals(str)) || IW.A02 >= 25;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Xt != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T extends com.facebook.ads.redexgen.X.Bv> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Xw != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSessionManager<T extends com.facebook.ads.redexgen.X.Bv> */
    @Override // com.facebook.ads.redexgen.X.Bb
    public final void AAx() {
        Iterator<C2070Xt<T>> it = this.A08.iterator();
        while (it.hasNext()) {
            it.next().A0I();
        }
        this.A08.clear();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Xt != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T extends com.facebook.ads.redexgen.X.Bv> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Xw != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSessionManager<T extends com.facebook.ads.redexgen.X.Bv> */
    @Override // com.facebook.ads.redexgen.X.Bb
    public final void AAy(Exception exc) {
        Iterator<C2070Xt<T>> it = this.A08.iterator();
        while (it.hasNext()) {
            it.next().A0L(exc);
        }
        List<C2070Xt<T>> list = this.A08;
        String[] strArr = A0E;
        if (strArr[4].charAt(7) == strArr[1].charAt(7)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0E;
        strArr2[3] = "LfmgySfdwng";
        strArr2[3] = "LfmgySfdwng";
        list.clear();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Xt != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T extends com.facebook.ads.redexgen.X.Bv> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Xw != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSessionManager<T extends com.facebook.ads.redexgen.X.Bv> */
    @Override // com.facebook.ads.redexgen.X.Bb
    public final void ACB(C2070Xt<T> c2070Xt) {
        this.A08.add(c2070Xt);
        if (this.A08.size() == 1) {
            c2070Xt.A0J();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Bt != com.facebook.ads.internal.exoplayer2.drm.DrmSession<T extends com.facebook.ads.redexgen.X.Bv> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Xt != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T extends com.facebook.ads.redexgen.X.Bv> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Xw != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSessionManager<T extends com.facebook.ads.redexgen.X.Bv> */
    @Override // com.facebook.ads.redexgen.X.InterfaceC1521Bu
    public final void ACc(InterfaceC1520Bt<T> interfaceC1520Bt) {
        if (interfaceC1520Bt instanceof C2074Xx) {
            return;
        }
        C2070Xt<T> c2070Xt = (C2070Xt) interfaceC1520Bt;
        if (c2070Xt.A0M()) {
            this.A09.remove(c2070Xt);
            if (this.A08.size() > 1 && this.A08.get(0) == c2070Xt) {
                this.A08.get(1).A0J();
            }
            this.A08.remove(c2070Xt);
        }
    }
}
