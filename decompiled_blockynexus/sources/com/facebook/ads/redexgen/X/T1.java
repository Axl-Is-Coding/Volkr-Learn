package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdScrollView;
import com.facebook.ads.NativeAdView;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class T1 extends AbstractC12952e {
    public static String[] A02;
    public List<NativeAd> A00 = new ArrayList();
    public final /* synthetic */ AnonymousClass57 A01;

    static {
        A00();
    }

    public static void A00() {
        A02 = new String[]{"f2MNSWDlL1YMuTPGOAjONPZtO", "cmMTh0pUaJ1RDNo0mFNR3IJYAK2Mf6gB", "4dFqjoT4qnH4w96CQtkjoCAuJyqtgp11", "6XB3g70NG5Gd02gyy8Ab40YcxuzvQEqb", "wwGHlt0jZwPrQfekoFOvLm8zPwbBrmxC", "1Rqxvwj8Vs8GuK5", "NKSqZWGd9qA279w", "7JvmemziLS26U2JKZlqSRSAl5nA0imSt"};
    }

    public T1(AnonymousClass57 anonymousClass57) {
        this.A01 = anonymousClass57;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC12952e
    public final int A05() {
        return this.A00.size();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC12952e
    public final int A06(Object obj) {
        int iIndexOf = this.A00.indexOf(obj);
        if (iIndexOf >= 0) {
            return iIndexOf;
        }
        return -2;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC12952e
    public final Object A08(ViewGroup viewGroup, int i) {
        View viewRender;
        if (this.A01.A01 != null) {
            NativeAdScrollView.AdViewProvider adViewProvider = this.A01.A01;
            List<NativeAd> list = this.A00;
            String[] strArr = A02;
            if (strArr[7].charAt(19) == strArr[4].charAt(19)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[2] = "d9x9bMDlXKa90r8XaToMTFuUxNqAoP43";
            strArr2[2] = "d9x9bMDlXKa90r8XaToMTFuUxNqAoP43";
            viewRender = adViewProvider.createView(list.get(i), i);
        } else {
            viewRender = this.A01.A02 != null ? NativeAdView.render(this.A01.A06, this.A00.get(i), this.A01.A02, this.A01.A03) : NativeAdView.render(this.A01.A06, this.A00.get(i), this.A01.A03);
        }
        viewGroup.addView(viewRender);
        return viewRender;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC12952e
    public final void A0B(ViewGroup viewGroup, int i, Object obj) {
        if (i < this.A00.size()) {
            if (this.A01.A01 != null) {
                this.A01.A01.destroyView(this.A00.get(i), (View) obj);
            } else {
                List<NativeAd> list = this.A00;
                if (A02[0].length() != 25) {
                    throw new RuntimeException();
                }
                String[] strArr = A02;
                strArr[0] = "BErMlyrXrYPfhoDWoAGZwiXdk";
                strArr[0] = "BErMlyrXrYPfhoDWoAGZwiXdk";
                list.get(i).unregisterView();
            }
        }
        viewGroup.removeView((View) obj);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC12952e
    public final boolean A0C(View view, Object obj) {
        return view == obj;
    }

    public final void A0D() {
        this.A00.clear();
        int iMin = Math.min(this.A01.A00, this.A01.A04.getUniqueNativeAdCount());
        for (int i = 0; i < iMin; i++) {
            NativeAd nativeAdNextNativeAd = this.A01.A04.nextNativeAd();
            C2213bT.A0J(nativeAdNextNativeAd.getInternalNativeAd()).A1S(true);
            this.A00.add(nativeAdNextNativeAd);
        }
        A09();
    }
}
