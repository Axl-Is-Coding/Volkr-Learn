package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import com.localapi.Tribe;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aT, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2153aT implements H7, HX<Object> {
    public static String[] A0A;
    public int A00;
    public long A01;
    public long A02;
    public long A03;
    public long A04;
    public long A05;

    @Nullable
    public final Handler A06;

    @Nullable
    public final H6 A07;
    public final InterfaceC1665Hu A08;
    public final IR A09;

    static {
        A01();
    }

    public static void A01() {
        A0A = new String[]{"8v43OWLt8X4Ft8FSsUnUJEljk6O9jZtl", "gqJU9rJqtCXP9nVsCJhzhjWr3OTUONn5", "evi8lnvhIGFpGwxvrEQ2HxpF9HfAYNb4", "XM9iQGBoaLQIRrKYvs1BFwTGSVuWakLP", "oYKHkHYzGvwdV8VAJO5FvOndhShHo3uL", "GsOQXWL80Wqi8CBj4PFxcrgidstVbv5Z", "TfEJwESWFeUjyASkqvscuoRhiyKsiSGj", "R3GeLkF45fmp7DtCtFYf0NMS1ko1sZ3Y"};
    }

    public C2153aT() {
        this(null, null, 1000000L, 2000, InterfaceC1665Hu.A00);
    }

    public C2153aT(@Nullable Handler handler, @Nullable H6 h6, long j, int i, InterfaceC1665Hu interfaceC1665Hu) {
        this.A06 = handler;
        this.A07 = h6;
        this.A09 = new IR(i);
        this.A08 = interfaceC1665Hu;
        this.A01 = j;
    }

    private void A02(int i, long j, long j2) {
        Handler handler = this.A06;
        if (handler != null) {
            H6 h6 = this.A07;
            String[] strArr = A0A;
            if (strArr[3].charAt(14) == strArr[2].charAt(14)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0A;
            strArr2[3] = "mcMhHiKL1Hs40ZODL70g4thjgDTU4mJQ";
            strArr2[2] = "gdrxxP25NVrEqdTm0xFGwMteDAr0ERpE";
            if (h6 != null) {
                handler.post(new HH(this, i, j, j2));
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.H7
    public final synchronized long A5Z() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.X.HX
    public final synchronized void A9N(Object obj, int i) {
        this.A02 += (long) i;
    }

    @Override // com.facebook.ads.redexgen.X.HX
    public final synchronized void ABS(Object obj) {
        C1662Hr.A04(this.A00 > 0);
        long jA4z = this.A08.A4z();
        long nowMs = jA4z - this.A03;
        int i = (int) nowMs;
        long nowMs2 = i;
        this.A05 += nowMs2;
        long j = this.A04;
        long nowMs3 = this.A02;
        this.A04 = j + nowMs3;
        if (i > 0) {
            long nowMs4 = i;
            this.A09.A04((int) Math.sqrt(this.A02), (this.A02 * Tribe.CREATE_FEE_GOLDS) / nowMs4);
            long j2 = this.A05;
            String[] strArr = A0A;
            if (strArr[6].charAt(30) == strArr[5].charAt(30)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0A;
            strArr2[3] = "ZGZYZVMOjrgZsL4omJYgF6CzP4kXRh7Y";
            strArr2[2] = "w8y5sfHjCRRFpoxn3MnbYbSKFexwF0nZ";
            if (j2 >= 2000 || this.A04 >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                float bitsPerSecond = this.A09.A03(0.5f);
                this.A01 = (long) bitsPerSecond;
            }
        }
        A02(i, this.A02, this.A01);
        int i2 = this.A00 - 1;
        this.A00 = i2;
        if (i2 > 0) {
            this.A03 = jA4z;
        }
        this.A02 = 0L;
    }

    @Override // com.facebook.ads.redexgen.X.HX
    public final synchronized void ABT(Object obj, HG hg) {
        if (this.A00 == 0) {
            this.A03 = this.A08.A4z();
        }
        this.A00++;
    }
}
