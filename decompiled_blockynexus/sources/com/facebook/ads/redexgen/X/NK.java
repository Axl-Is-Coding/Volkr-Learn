package com.facebook.ads.redexgen.X;

import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.facebook.ads.internal.api.BuildConfigApi;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class NK extends WebChromeClient {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 68);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{-91, -47, -48, -43, -47, -50, -57, -126, -49, -57, -43, -43, -61, -55, -57, -100, -126, -102, -67, -81, -78, -73, -68, -75, 110, -66, -64, -67, -75, -64, -77, -63, -63, -120, 110};
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (BuildConfigApi.isDebug()) {
            String str = A00(0, 17, 30) + consoleMessage.message();
            return true;
        }
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final void onProgressChanged(WebView webView, int i) {
        if (BuildConfigApi.isDebug()) {
            String str = A00(17, 18, 10) + i;
        }
    }
}
