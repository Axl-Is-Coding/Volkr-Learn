package com.facebook.ads.redexgen.X;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Handler;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.umeng.analytics.pro.ci;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import okio.Utf8;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class NL extends WebViewClient {
    public static byte[] A0A;
    public Date A00;
    public boolean A01 = false;
    public final C2026Wb A02;
    public final WeakReference<C2044Wt> A03;
    public final WeakReference<NJ> A04;
    public final WeakReference<AtomicBoolean> A05;
    public final WeakReference<LQ> A06;
    public final WeakReference<C1849Pe> A07;
    public final AtomicInteger A08;
    public final AtomicReference<String> A09;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0A, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 74);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A0A = new byte[]{90, 103, 107, 109, 126, Utf8.REPLACEMENT_BYTE, 123, 126, 107, 126, 37, Utf8.REPLACEMENT_BYTE, 114, 101, 101, 120, 101, 72, 116, 120, 115, 114, 23, 0, 0, 29, 0, 45, 22, 23, 1, 17, 0, 27, 2, 6, 27, 29, 28, 107, 113, 93, 117, 103, 96, 93, 112, 103, 113, 109, 119, 112, 97, 103, 93, 103, 112, 112, 109, 112, 17, 18, 28, 25, 20, 19, 26, 34, 9, 20, ci.n, 24, 34, 20, 19, 34, ci.n, 20, 17, 17, 20, ci.l, ci.l, 5, 20, 90, 90, 37, 50, 50, Utf8.REPLACEMENT_BYTE, 37, 45, 48, 52, 57, Utf8.REPLACEMENT_BYTE, 50, 37, 51, 48, 47, 46, 51, 37, 22, 1, 21, 17, 1, 23, ci.n, 59, ci.k, 0, 113, 99, 100, 89, 112, 111, 99, 113};
    }

    public NL(C2026Wb c2026Wb, WeakReference<NJ> weakReference, WeakReference<C1849Pe> weakReference2, WeakReference<LQ> weakReference3, WeakReference<AtomicBoolean> weakReference4, WeakReference<C2044Wt> weakReference5, AtomicInteger atomicInteger, AtomicReference<String> atomicReference) {
        this.A02 = c2026Wb;
        this.A04 = weakReference;
        this.A07 = weakReference2;
        this.A06 = weakReference3;
        this.A05 = weakReference4;
        this.A03 = weakReference5;
        this.A08 = atomicInteger;
        this.A09 = atomicReference;
    }

    private void A02(int i, CharSequence charSequence, long j) {
        JSONObject jSONObject = new JSONObject();
        boolean z = charSequence != null;
        try {
            jSONObject.put(A00(12, 10, 93), i);
            jSONObject.put(A00(22, 17, 56), charSequence);
            jSONObject.put(A00(39, 21, 72), z);
            jSONObject.put(A00(60, 22, 55), j);
            jSONObject.put(A00(105, 10, 46), this.A09.get());
        } catch (JSONException unused) {
        }
        this.A02.A04().A8H(A00(115, 8, 76), C8Y.A2E, new C8Z(AdErrorType.WEB_VIEW_FAILED_TO_LOAD.getDefaultErrorMessage(), A00(0, 12, 85) + jSONObject.toString()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A03(int i, @Nullable String str) {
        if (A00(82, 23, 42).equals(str)) {
            this.A02.A0A().AE6();
            return;
        }
        this.A02.A0A().AE7(i, str);
        A02(i, str, new Date().getTime() - this.A00.getTime());
        if (this.A04.get() != null) {
            this.A04.get().A9t(i, str);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        this.A02.A0A().AE8(this.A03.get() != null);
        if (this.A03.get() != null && this.A05.get() != null && !this.A05.get().get()) {
            this.A03.get().A04();
        }
        this.A01 = true;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.A02.A0A().AE9();
        this.A00 = new Date();
        new Handler().postDelayed(new C2045Wu(this), this.A08.get());
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        this.A01 = true;
        A03(i, str);
    }

    @Override // android.webkit.WebViewClient
    @RequiresApi(api = 23)
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        boolean zA0n = C1693Iy.A0n(this.A02);
        String strA00 = A00(0, 0, 49);
        if (zA0n) {
            this.A01 = true;
            A03(webResourceError.getErrorCode(), strA00 + ((Object) webResourceError.getDescription()));
            return;
        }
        this.A02.A0A().AEA(L4.A01(webResourceError.getErrorCode(), strA00 + ((Object) webResourceError.getDescription()), strA00 + webResourceRequest.getUrl()));
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        this.A02.A0A().AEB();
        sslErrorHandler.cancel();
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (this.A04.get() != null) {
            this.A04.get().A9R(str, new NQ().A04(this.A07.get()).A03(this.A06.get()).A06());
            return true;
        }
        return true;
    }
}
