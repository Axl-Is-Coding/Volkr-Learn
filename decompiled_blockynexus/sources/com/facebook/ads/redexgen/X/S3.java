package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import com.facebook.ads.internal.adquality.AdQualityRule;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class S3 implements LH<Bundle> {
    public static byte[] A04;
    public AnonymousClass21 A00;
    public final View A01;
    public final C2026Wb A02;
    public final List<S4> A03;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 49);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{126, 121, 108, 121, 100, 126, 121, 100, 110, 126, 106, 123, 109, 106, 109};
    }

    public S3(View view, List<AbstractC12901z> list, Bundle bundle, C2026Wb c2026Wb) {
        this.A02 = c2026Wb;
        this.A01 = view;
        List<AdQualityRule> rules = new ArrayList<>(list.size());
        this.A03 = rules;
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(A00(10, 5, 15));
        for (int i = 0; i < list.size(); i++) {
            this.A03.add(new S4(list.get(i), (Bundle) parcelableArrayList.get(i)));
        }
        this.A00 = (AnonymousClass21) LB.A00(bundle.getByteArray(A00(0, 10, 28)));
    }

    public S3(View view, List<AbstractC12901z> list, C2026Wb c2026Wb) {
        this.A02 = c2026Wb;
        this.A01 = view;
        this.A03 = new ArrayList(list.size());
        Iterator<AbstractC12901z> it = list.iterator();
        while (it.hasNext()) {
            this.A03.add(new S4(it.next()));
        }
        this.A00 = new AnonymousClass21();
    }

    public final Bundle A02() {
        Bundle bundle = new Bundle();
        bundle.putByteArray(A00(0, 10, 28), LB.A01(this.A00));
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>(this.A03.size());
        Iterator<S4> it = this.A03.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().A06());
        }
        bundle.putParcelableArrayList(A00(10, 5, 15), arrayList);
        return bundle;
    }

    public final AnonymousClass21 A03() {
        return this.A00;
    }

    public final void A04() {
        this.A00.A03();
        for (S4 test : this.A03) {
            test.A07();
        }
    }

    public final void A05() {
        this.A00.A02();
    }

    public final void A06(double viewableRatio, double d2) {
        if (d2 >= 0.0d) {
            this.A00.A05(viewableRatio, d2);
        }
        double dA00 = C1849Pe.A0E(this.A01, 0, this.A02).A00();
        this.A00.A04(viewableRatio, dA00);
        Iterator<S4> it = this.A03.iterator();
        while (it.hasNext()) {
            it.next().A08(viewableRatio, dA00);
        }
    }
}
