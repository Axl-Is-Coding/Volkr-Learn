package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.webkit.JavascriptInterface;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class NI {
    public static String[] A07;
    public final String A00 = NI.class.getSimpleName();
    public final WeakReference<AtomicBoolean> A01;
    public final WeakReference<AtomicBoolean> A02;
    public final WeakReference<C0R> A03;
    public final WeakReference<NJ> A04;
    public final WeakReference<C1849Pe> A05;
    public final WeakReference<C2044Wt> A06;

    static {
        A01();
    }

    public static void A01() {
        A07 = new String[]{"FOFLIt4izaDLaQDOMIXk8qYNT283z5pM", "oiToeohcscvINDKXEsytRf9HFldaqPXB", "4ipPd9h88IiL3d99rWL92oIsRR1k6HBA", "hPx", "0GhefH5NzI2ypbPnqUG75Cq8VmhNX1", "2b6", "snO0JYp8WiAdMwbOevXppfTs6iFhTSIS", "awSLBYFe7Md8cHgboMT9P3Pgh1wlsZGE"};
    }

    public NI(C2044Wt c2044Wt, NJ nj, C1849Pe c1849Pe, AtomicBoolean atomicBoolean, AtomicBoolean atomicBoolean2, C2026Wb c2026Wb) {
        this.A06 = new WeakReference<>(c2044Wt);
        this.A04 = new WeakReference<>(nj);
        this.A05 = new WeakReference<>(c1849Pe);
        this.A01 = new WeakReference<>(atomicBoolean);
        this.A02 = new WeakReference<>(atomicBoolean2);
        this.A03 = new WeakReference<>(c2026Wb.A0A());
    }

    private C0R A00() {
        C0R c0r = this.A03.get();
        if (c0r == null) {
            return new R1();
        }
        return c0r;
    }

    @JavascriptInterface
    public void alert(String str) {
        Log.e(this.A00, str);
    }

    @JavascriptInterface
    public String getAnalogInfo() {
        return L6.A01(C14408h.A02());
    }

    @JavascriptInterface
    public void onMainAssetLoaded() {
        A00().AE1();
        if (this.A06.get() == null || this.A01.get() == null || this.A02.get() == null) {
            return;
        }
        boolean z = this.A02.get().get();
        String[] strArr = A07;
        if (strArr[4].length() == strArr[5].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A07;
        strArr2[1] = "xXjDpbk5Vvc7CvrBd08NYXaJ46SIZN7q";
        strArr2[1] = "xXjDpbk5Vvc7CvrBd08NYXaJ46SIZN7q";
        if (z) {
            this.A01.get().set(true);
            A00().AE2();
            if (this.A06.get().isShown()) {
                A00().AE3();
                new Handler(Looper.getMainLooper()).post(new C2046Wv(this.A05));
            }
            NJ nj = this.A04.get();
            if (nj != null) {
                new Handler(Looper.getMainLooper()).post(new NH(this, nj));
            }
        }
    }

    @JavascriptInterface
    public void onPageInitialized() {
        C2044Wt c2044Wt = this.A06.get();
        if (c2044Wt == null || c2044Wt.A03()) {
            A00().AE4(true);
            return;
        }
        NJ nj = this.A04.get();
        if (nj == null) {
            A00().AE4(true);
        } else {
            A00().AE4(false);
            nj.AAf();
        }
    }
}
