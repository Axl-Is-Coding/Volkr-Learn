package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import androidx.annotation.RequiresApi;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class NE extends WebChromeClient {
    public static byte[] A03;
    public static String[] A04;
    public final WeakReference<C2026Wb> A00;
    public final WeakReference<NC> A01;
    public final WeakReference<N9> A02;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            int i5 = (bArrCopyOfRange[i4] - i3) - 79;
            if (A04[5].charAt(31) != 'G') {
                throw new RuntimeException();
            }
            String[] strArr = A04;
            strArr[4] = "SJN5rebrF3WLAsOm1fkdotQMSgQRMUzH";
            strArr[4] = "SJN5rebrF3WLAsOm1fkdotQMSgQRMUzH";
            bArrCopyOfRange[i4] = (byte) i5;
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{-108, -103, -108, 5, 40, 43, 36, -33, 2, 39, 46, 46, 50, 36, 49, -21, -8, -18, -4, -7, -13, -18, -72, -13, -8, -2, -17, -8, -2, -72, -21, -19, -2, -13, -7, -8, -72, -47, -49, -34, -23, -51, -39, -40, -34, -49, -40, -34, -53, -40, -50, -36, -39, -45, -50, -104, -45, -40, -34, -49, -40, -34, -104, -51, -53, -34, -49, -47, -39, -36, -29, -104, -71, -70, -81, -72, -85, -84, -74, -81, 12, -6, -9, -12, 11, -2, -6, 12};
    }

    public static void A02() {
        A04 = new String[]{"YcV2lPdb1GD", "n5DgX5QSw4FQX59vcvxBmCs4C4mD4", "EksZFw55Ld98qazTViJtw6pSuONG6", "FQxvmp8vruM", "8OOSEuFQ7OrFhHkYKSo1UtYVyasxVGnA", "3ltH6wFp1GB97FT9l8RHOrWs4kHkX0iG", "Qgk2ZsNAH7VHvpqjGWkwA7olVBMIpezg", "lYuGhUBeP576iz9ihjd4qaMvDoX6gejl"};
    }

    public NE(WeakReference<C2026Wb> weakReference, WeakReference<NC> weakReference2, WeakReference<N9> weakReference3) {
        this.A00 = weakReference;
        this.A01 = weakReference2;
        this.A02 = weakReference3;
    }

    private boolean A03(ValueCallback valueCallback) {
        if (this.A00.get() == null || this.A00.get().A09() == null || !XM.A09) {
            return false;
        }
        if (XM.A08 != null) {
            XM.A08.onReceiveValue(null);
            ValueCallback unused = XM.A08 = null;
        }
        ValueCallback unused2 = XM.A08 = valueCallback;
        try {
            Intent intent = new Intent(A00(15, 33, 59));
            intent.addCategory(A00(48, 32, 27));
            intent.setType(A00(0, 3, 27));
            this.A00.get().A09().startActivityForResult(Intent.createChooser(intent, A00(3, 12, 112)), 1001);
            return true;
        } catch (Exception e2) {
            this.A00.get().A04().A8I(A00(80, 8, 70), C8Y.A2D, new C8Z(e2));
            ValueCallback unused3 = XM.A08 = null;
            return false;
        }
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String strMessage = consoleMessage.message();
        if (!TextUtils.isEmpty(strMessage) && consoleMessage.messageLevel() == ConsoleMessage.MessageLevel.LOG) {
            N9 n9 = this.A02.get();
            String[] strArr = A04;
            if (strArr[1].length() != strArr[2].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A04;
            strArr2[5] = "G67BWScyobP0YXfVqACryJUIpKzfHuOG";
            strArr2[5] = "G67BWScyobP0YXfVqACryJUIpKzfHuOG";
            if (n9 != null) {
                this.A02.get().A05(strMessage);
                return true;
            }
            return true;
        }
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        if (this.A02.get() != null) {
            this.A02.get().A04();
        }
        if (this.A01.get() != null) {
            this.A01.get().AAw(i);
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
        if (this.A01.get() != null) {
            this.A01.get().AB1(str);
        }
    }

    @Override // android.webkit.WebChromeClient
    @RequiresApi(api = 21)
    public final boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        return A03(valueCallback);
    }
}
