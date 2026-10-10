package com.facebook.ads.redexgen.X;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.2e, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC12952e {
    public static byte[] A02;
    public DataSetObserver A00;
    public final DataSetObservable A01 = new DataSetObservable();

    static {
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 20);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{110, 89, 77, 73, 85, 78, 89, 88, 28, 81, 89, 72, 84, 83, 88, 28, 88, 89, 79, 72, 78, 83, 69, 117, 72, 89, 81, 28, 75, 93, 79, 28, 82, 83, 72, 28, 83, 74, 89, 78, 78, 85, 88, 88, 89, 82, 125, 74, 94, 90, 70, 93, 74, 75, ci.m, 66, 74, 91, 71, 64, 75, ci.m, 70, 65, 92, 91, 78, 65, 91, 70, 78, 91, 74, 102, 91, 74, 66, ci.m, 88, 78, 92, ci.m, 65, 64, 91, ci.m, 64, 89, 74, 93, 93, 70, 75, 75, 74, 65};
    }

    public abstract int A05();

    public abstract boolean A0C(View view, Object obj);

    @Deprecated
    private final Object A00(View view, int i) {
        throw new UnsupportedOperationException(A01(46, 50, 59));
    }

    @Deprecated
    private final void A03(View view, int i, Object obj) {
        throw new UnsupportedOperationException(A01(0, 46, 40));
    }

    public final float A04(int i) {
        return 1.0f;
    }

    public int A06(Object obj) {
        return -1;
    }

    public final Parcelable A07() {
        return null;
    }

    public Object A08(ViewGroup viewGroup, int i) {
        return A00(viewGroup, i);
    }

    public final void A09() {
        synchronized (this) {
            if (this.A00 != null) {
                this.A00.onChanged();
            }
        }
        this.A01.notifyChanged();
    }

    public final void A0A(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.A00 = dataSetObserver;
        }
    }

    public void A0B(ViewGroup viewGroup, int i, Object obj) {
        A03(viewGroup, i, obj);
    }
}
