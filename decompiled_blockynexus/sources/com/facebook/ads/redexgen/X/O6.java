package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.RequiresApi;
import java.util.Arrays;
import okio.Utf8;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class O6 extends WebViewClient {
    public static byte[] A01;
    public final /* synthetic */ C1872Qb A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 67);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{87, 86, 64, 80, 65, 90, 67, 71, 90, 92, 93, 62, 51, 62, 25, 40, 59, 41, 50, 10, 29, 29, 0, 29, 44, 0, 11, 10, 91, 71, 71, 67, 108, 86, 65, 65, 92, 65, 54, 52, 47, 41, 52, 47, 50, Utf8.REPLACEMENT_BYTE, 113, 118, 104};
    }

    public O6(C1872Qb c1872Qb) {
        this.A00 = c1872Qb;
    }

    public /* synthetic */ O6(C1872Qb c1872Qb, C1877Qg c1877Qg) {
        this(c1872Qb);
    }

    private void A02(int i, String str, String str2) {
        this.A00.A0Q();
        this.A00.A0A.A03(JB.A0Q, null);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(A00(19, 9, 44), i);
            jSONObject.put(A00(0, 11, 112), str);
            jSONObject.put(A00(46, 3, 71), str2);
        } catch (JSONException unused) {
        }
        String string = jSONObject.toString();
        this.A00.A08.A0A().A4w(string);
        this.A00.A0G.A05(C8Y.A0s, string);
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        this.A00.A0A.A03(JB.A0R, null);
        this.A00.A08.A0A().A4x(LP.A01(this.A00.A00));
        this.A00.A0Q();
        this.A00.A04 = true;
        this.A00.A0H();
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        if (Build.VERSION.SDK_INT < 23) {
            A02(i, str, str2);
        }
    }

    @Override // android.webkit.WebViewClient
    @RequiresApi(api = 23)
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        int errorCode = webResourceError.getErrorCode();
        StringBuilder sb = new StringBuilder();
        String strA00 = A00(0, 0, 70);
        sb.append(strA00);
        sb.append((Object) webResourceError.getDescription());
        A02(errorCode, sb.toString(), strA00 + webResourceRequest.getUrl());
    }

    @Override // android.webkit.WebViewClient
    @RequiresApi(api = 21)
    public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        int statusCode;
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        if (webResourceResponse != null) {
            statusCode = webResourceResponse.getStatusCode();
        } else {
            statusCode = -1;
        }
        A02(statusCode, A00(28, 10, 112), A00(0, 0, 70) + webResourceRequest.getUrl());
    }

    @Override // android.webkit.WebViewClient
    @RequiresApi(api = 26)
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(A00(11, 8, 25), renderProcessGoneDetail.didCrash());
            jSONObject.put(A00(38, 8, 5), renderProcessGoneDetail.rendererPriorityAtExit());
        } catch (JSONException unused) {
        }
        this.A00.A08.A0A().A4u(jSONObject.toString());
        if (this.A00.A02 == null) {
            return true;
        }
        this.A00.A02.finish(13);
        return true;
    }
}
