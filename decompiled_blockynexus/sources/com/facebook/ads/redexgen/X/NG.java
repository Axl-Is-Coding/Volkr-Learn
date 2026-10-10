package com.facebook.ads.redexgen.X;

import android.app.Activity;
import android.os.Build;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.ads.internal.api.BuildConfigApi;
import java.util.Arrays;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class NG extends WebView {
    public static byte[] A01;
    public static final String A02;
    public boolean A00;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 105);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{87, 112, 120, 125, 116, 117, 49, 101, 126, 49, 120, 127, 120, 101, 120, 112, 125, 120, 107, 116, 49, 82, 126, 126, 122, 120, 116, 92, 112, 127, 112, 118, 116, 99, Utf8.REPLACEMENT_BYTE};
    }

    static {
        A02();
        A02 = NG.class.getSimpleName();
    }

    public NG(Activity activity) {
        super(activity);
        A01();
    }

    public NG(C2026Wb c2026Wb) {
        super(c2026Wb);
        A01();
    }

    private void A01() {
        setWebChromeClient(A0C());
        setWebViewClient(A0D());
        NM.A05(this);
        getSettings().setJavaScriptEnabled(true);
        getSettings().setDomStorageEnabled(true);
        if (Build.VERSION.SDK_INT >= 17) {
            getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
        if (BuildConfigApi.isDebug() && Build.VERSION.SDK_INT >= 19) {
            setWebContentsDebuggingEnabled(true);
        }
        setHorizontalScrollBarEnabled(false);
        setHorizontalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                CookieManager.getInstance().setAcceptThirdPartyCookies(this, true);
            } catch (Exception unused) {
                Log.w(A02, A00(0, 35, 120));
            }
        }
    }

    public final boolean A03() {
        return this.A00;
    }

    public WebChromeClient A0C() {
        return new WebChromeClient();
    }

    public WebViewClient A0D() {
        return new WebViewClient();
    }

    @Override // android.webkit.WebView
    public void destroy() {
        this.A00 = true;
        super.destroy();
    }
}
