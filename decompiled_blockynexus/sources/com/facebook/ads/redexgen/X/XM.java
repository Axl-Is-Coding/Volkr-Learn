package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Build;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import androidx.annotation.Nullable;
import com.umeng.analytics.pro.ci;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
@TargetApi(19)
public final class XM extends NG {

    @Nullable
    public static ValueCallback A08;
    public static boolean A09;
    public static boolean A0A;
    public static byte[] A0B;
    public static final String A0C;
    public static final Set<String> A0D;
    public long A00;
    public long A01;
    public long A02;
    public long A03;
    public N9 A04;
    public NC A05;
    public final C2026Wb A06;
    public final NF A07;

    public static String A04(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0B, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 93);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A08() {
        A0B = new byte[]{83, 79, 79, 75, 49, 45, 45, 41, 42, 6, ci.k, 26, ci.k, 31, ci.m, 30, 5, 28, 24, 86};
    }

    static {
        A08();
        A0C = XM.class.getSimpleName();
        A0D = new HashSet(2);
        A09 = false;
        A0A = false;
        A0D.add(A04(0, 4, 102));
        A0D.add(A04(4, 5, 4));
    }

    public XM(C2026Wb c2026Wb, Activity activity, NC nc) {
        super(activity);
        this.A02 = -1L;
        this.A00 = -1L;
        this.A03 = -1L;
        this.A01 = -1L;
        this.A05 = nc;
        this.A06 = c2026Wb;
        setWebChromeClient(A0C());
        this.A07 = A0D();
        setWebViewClient(this.A07);
        A07();
    }

    public XM(C2026Wb c2026Wb, NC nc) {
        super(c2026Wb);
        this.A02 = -1L;
        this.A00 = -1L;
        this.A03 = -1L;
        this.A01 = -1L;
        this.A05 = nc;
        this.A06 = c2026Wb;
        setWebChromeClient(A0C());
        this.A07 = A0D();
        setWebViewClient(this.A07);
        A07();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.NG
    /* JADX INFO: renamed from: A03, reason: merged with bridge method [inline-methods] */
    public final NF A0D() {
        return new NF(new WeakReference(this.A05), new WeakReference(this.A06));
    }

    private void A06() {
        if (this.A00 > -1 && this.A03 > -1 && this.A01 > -1) {
            this.A04.A06(false);
        }
    }

    private void A07() {
        A09 = C1694Iz.A03(this.A06);
        A0A = C1694Iz.A04(this.A06);
        WebSettings settings = getSettings();
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setAllowContentAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setAllowFileAccess(false);
        this.A04 = new N9(this);
    }

    public static void A09(int i, int i2, Intent intent) {
        if (A08 != null && i == 1001) {
            if (Build.VERSION.SDK_INT >= 21) {
                A08.onReceiveValue(WebChromeClient.FileChooserParams.parseResult(i2, intent));
            } else {
                A08.onReceiveValue(intent.getData());
            }
            A08 = null;
        }
    }

    @Override // com.facebook.ads.redexgen.X.NG
    public final WebChromeClient A0C() {
        return new NE(new WeakReference(this.A06), new WeakReference(this.A05), new WeakReference(this.A04));
    }

    public final void A0E(long j) {
        if (this.A00 < 0) {
            this.A00 = j;
        }
        A06();
    }

    public final void A0F(long j) {
        if (this.A01 < 0) {
            this.A01 = j;
        }
        A06();
    }

    public final void A0G(long j) {
        if (this.A02 < 0) {
            this.A02 = j;
        }
    }

    public final void A0H(String str) {
        try {
            evaluateJavascript(str, null);
        } catch (IllegalStateException unused) {
            loadUrl(A04(9, 11, 49) + str);
        }
    }

    @Override // com.facebook.ads.redexgen.X.NG, android.webkit.WebView
    public final void destroy() {
        this.A05 = null;
        NM.A04(this);
        super.destroy();
    }

    public long getDomContentLoadedMs() {
        return this.A00;
    }

    public String getFirstUrl() {
        WebBackForwardList webBackForwardListCopyBackForwardList = copyBackForwardList();
        if (webBackForwardListCopyBackForwardList.getSize() > 0) {
            return webBackForwardListCopyBackForwardList.getItemAtIndex(0).getUrl();
        }
        return getUrl();
    }

    public long getLoadFinishMs() {
        return this.A01;
    }

    public long getResponseEndMs() {
        return this.A02;
    }

    public long getScrollReadyMs() {
        return this.A03;
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.A03 < 0 && computeVerticalScrollRange() > getHeight()) {
            this.A03 = System.currentTimeMillis();
            A06();
        }
    }

    public void setBrowserNavigationListener(ND nd) {
        this.A07.A03(new WeakReference<>(nd));
    }
}
