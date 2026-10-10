package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.umeng.analytics.pro.ci;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
@SuppressLint({"ViewConstructor"})
public final class OV extends FrameLayout {
    public static byte[] A0C;
    public static String[] A0D;
    public static final float A0E;
    public static final RelativeLayout.LayoutParams A0F;
    public int A00;
    public long A01;
    public Map<String, String> A02;
    public final AnonymousClass15 A03;
    public final C1R A04;
    public final C2026Wb A05;
    public final J5 A06;
    public final NJ A07;
    public final C2044Wt A08;
    public final OT A09;
    public final AtomicBoolean A0A;
    public final AtomicBoolean A0B;

    public static String A06(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0C, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            int i5 = bArrCopyOfRange[i4] ^ i3;
            if (A0D[5].length() != 25) {
                throw new RuntimeException();
            }
            String[] strArr = A0D;
            strArr[4] = "2xsSJQdmJTzWNKbVkLPVv70adF3crTtp";
            strArr[4] = "2xsSJQdmJTzWNKbVkLPVv70adF3crTtp";
            bArrCopyOfRange[i4] = (byte) (i5 ^ 37);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A09() {
        A0C = new byte[]{11, 47, 29, 33, 44, 52, 44, 47, 33, 40, 12, 41, 52, 5, 22, 23, ci.k, 10, 3, 68, 1, 22, 22, 11, 22, 52, 8, 5, 29, 5, 6, 8, 1, 68, 0, 11, 39, ci.n, 5, 39, 8, ci.k, 7, ci.m, 68, ci.n, 22, ci.k, 3, 3, 1, 22, 1, 0, 68, 19, ci.k, ci.n, 12, 68, 20, 22, 1, 73, 1, 18, 1, 10, ci.n, 68, 7, 8, ci.k, 7, ci.m, 23, 68, 7, 11, 17, 10, ci.n, 68, 5, 10, 0, 68, 32, 1, 8, 5, 29, 106, 86, 91, 67, 91, 88, 86, 95, 123, 94, 73, 108, 83, 95, 77, 103, 104, 109, 103, 111, 119, 58, 59, 50, Utf8.REPLACEMENT_BYTE, 39, 100, 120, 117, 109, 117, 118, 120, 113, 89, 66, 70, 72, 67, 48, 34, 37, 24, 49, 46, 34, 48};
    }

    public static void A0A() {
        A0D = new String[]{"2LrpfYyae0azpeRldXrTpIs5j5WolZYJ", "aTWFoH17M5HvBaS06GyoTMgY8LK09kB1", "ZT9jJV1ne", "vwbwskwEgIVHj6V8wHV", "a8UIfMhCahgZVDol7QIaAFMNjSR7v8Rm", "pauq9xVSe1TSbn6Nh8iDWIypG", "tig0s2h3zWgeN1kA13N6tuAlrnUP1dby", "gu60Pcp0oAdbO9RcUpkXMIBgrMh0CW0V"};
    }

    static {
        A0A();
        A09();
        A0E = (int) (LX.A01 * 4.0f);
        A0F = new RelativeLayout.LayoutParams(-1, -1);
    }

    public OV(C2026Wb c2026Wb, AnonymousClass15 anonymousClass15, C1R c1r, J5 j5, OT ot, Map<String, String> map) {
        super(c2026Wb);
        this.A0A = new AtomicBoolean(false);
        this.A0B = new AtomicBoolean(false);
        this.A01 = -1L;
        this.A00 = 0;
        this.A07 = new XK() { // from class: com.facebook.ads.redexgen.X.7s
            @Override // com.facebook.ads.redexgen.X.NJ
            public final void A9A() {
            }

            @Override // com.facebook.ads.redexgen.X.XK, com.facebook.ads.redexgen.X.NJ
            public final void A9t(int i, @Nullable String str) {
                this.A00.A0B.set(true);
                this.A00.A09.AAL();
            }

            @Override // com.facebook.ads.redexgen.X.XK, com.facebook.ads.redexgen.X.NJ
            public final void AA1() {
                if (this.A00.A0B.get() || !this.A00.A0A.compareAndSet(false, true)) {
                    return;
                }
                this.A00.A09.AA1();
            }
        };
        this.A05 = c2026Wb;
        this.A03 = anonymousClass15;
        this.A04 = c1r;
        this.A06 = j5;
        this.A09 = ot;
        this.A02 = map;
        this.A08 = A04();
        addView(this.A08, A0F);
    }

    public static /* synthetic */ int A00(OV ov) {
        int i = ov.A00;
        ov.A00 = i + 1;
        return i;
    }

    @SuppressLint({"AddJavascriptInterface", "ClickableViewAccessibility"})
    private C2044Wt A04() {
        C2044Wt c2044Wt = new C2044Wt(this.A05, new WeakReference(this.A07), 10);
        c2044Wt.setCornerRadius(A0E);
        c2044Wt.setLogMultipleImpressions(false);
        c2044Wt.setCheckAssetsByJavascriptBridge(false);
        c2044Wt.setWebViewTimeoutInMillis(this.A04.A09());
        c2044Wt.setRequestId(this.A03.A0U());
        c2044Wt.setOnTouchListener(new OU(this));
        WebSettings settings = c2044Wt.getSettings();
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setAllowFileAccess(true);
        if (Build.VERSION.SDK_INT >= 16) {
            settings.setAllowFileAccessFromFileURLs(true);
        }
        if (Build.VERSION.SDK_INT > 16) {
            c2044Wt.addJavascriptInterface(new OW(this.A05, this, this.A06, this.A02, this.A03.A0Q()), A06(0, 12, 104));
        }
        return c2044Wt;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x00b4, code lost:
    
        if (r3 <= com.facebook.ads.redexgen.X.C1693Iy.A0F(r7)) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x00b6, code lost:
    
        r3 = r9.A09;
        r2 = com.facebook.ads.redexgen.X.OV.A0D;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x00ca, code lost:
    
        if (r2[0].charAt(14) == r2[7].charAt(14)) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00cc, code lost:
    
        r3.A9Y();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00cf, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00d0, code lost:
    
        r2 = com.facebook.ads.redexgen.X.OV.A0D;
        r2[0] = "1qrV4xG42mjJ5wR1PYF4mguO0xYm8sMw";
        r2[7] = "To2gWJFbGkwQ4PRGYAw3BZd3UXo54AHv";
        r3.A9Y();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00f3, code lost:
    
        if (r3 <= com.facebook.ads.redexgen.X.C1693Iy.A0F(r7)) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00f6, code lost:
    
        r9.A05.A04().A8H(r5, com.facebook.ads.redexgen.X.C8Y.A1t, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0B() {
        /*
            Method dump skipped, instruction units count: 270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.OV.A0B():void");
    }

    public final void A0C() {
        String strA0F;
        try {
            C2044Wt c2044Wt = this.A08;
            if (!TextUtils.isEmpty(this.A04.A0C())) {
                strA0F = this.A04.A0C();
            } else {
                strA0F = this.A04.A0F();
            }
            c2044Wt.loadUrl(strA0F);
        } catch (Exception e2) {
            this.A05.A04().A8H(A06(131, 8, 98), C8Y.A2E, new C8Z(e2));
        }
    }

    public final void A0D() {
        this.A08.removeJavascriptInterface(A06(0, 12, 104));
        this.A08.destroy();
    }

    public LQ getTouchDataRecorder() {
        return this.A08.getTouchDataRecorder();
    }

    @Nullable
    public C1849Pe getViewabilityChecker() {
        return this.A08.getViewabilityChecker();
    }
}
