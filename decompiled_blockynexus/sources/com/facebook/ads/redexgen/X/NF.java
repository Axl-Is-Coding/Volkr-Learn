package com.facebook.ads.redexgen.X;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.umeng.analytics.pro.ci;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class NF extends WebViewClient {
    public static byte[] A03;

    @Nullable
    public WeakReference<ND> A00;
    public final WeakReference<C2026Wb> A01;
    public final WeakReference<NC> A02;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 97);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{54, 55, 68, 74, 73, ci.m, 55, 65, 54, 67, 64, 39, 52, 42, 56, 53, 47, 42, -12, 47, 52, 58, 43, 52, 58, -12, 39, 41, 58, 47, 53, 52, -12, 28, ci.m, 11, 29, 59, 64, 70, 55, 64, 70, 31, ci.k, 10, 7, 30, 17, ci.k, 31};
    }

    public NF(WeakReference<NC> weakReference, WeakReference<C2026Wb> weakReference2) {
        this.A02 = weakReference;
        this.A01 = weakReference2;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x006e A[Catch: Exception -> 0x00a0, TryCatch #0 {Exception -> 0x00a0, blocks: (B:13:0x002f, B:15:0x0035, B:17:0x0044, B:19:0x005c, B:21:0x006a, B:23:0x006e, B:25:0x0074, B:29:0x0084, B:27:0x007a), top: B:34:0x002f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A02(android.webkit.WebView r9, java.lang.String r10) {
        /*
            Method dump skipped, instruction units count: 213
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.NF.A02(android.webkit.WebView, java.lang.String):boolean");
    }

    public final void A03(WeakReference<ND> weakReference) {
        this.A00 = weakReference;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (this.A02.get() != null) {
            this.A02.get().AAe(str);
        }
        WeakReference<ND> weakReference = this.A00;
        if (weakReference != null && weakReference.get() != null) {
            this.A00.get().A9H(webView.canGoBack());
            this.A00.get().A9v(webView.canGoForward());
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        if (this.A02.get() != null) {
            this.A02.get().AAg(str);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        if (this.A01.get() != null) {
            StringBuilder sb = new StringBuilder();
            String strA00 = A00(0, 0, 27);
            sb.append(strA00);
            sb.append(str);
            this.A01.get().A0A().A7X(L4.A01(i, sb.toString(), strA00 + str2));
        }
    }

    @Override // android.webkit.WebViewClient
    @RequiresApi(api = 23)
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        if (this.A01.get() != null) {
            int errorCode = webResourceError.getErrorCode();
            StringBuilder sb = new StringBuilder();
            String strA00 = A00(0, 0, 27);
            sb.append(strA00);
            sb.append((Object) webResourceError.getDescription());
            this.A01.get().A0A().A7X(L4.A01(errorCode, sb.toString(), strA00 + webResourceRequest.getUrl()));
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        if (this.A01.get() != null) {
            this.A01.get().A0A().A7Y();
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        if (this.A01.get() != null) {
            this.A01.get().A0A().A7Z();
        }
    }

    @Override // android.webkit.WebViewClient
    @RequiresApi(api = 21)
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return A02(webView, webResourceRequest.getUrl().toString());
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return A02(webView, str);
    }
}
