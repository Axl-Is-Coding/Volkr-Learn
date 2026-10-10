package com.facebook.ads.redexgen.X;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import cn.qqtheme.framework.widget.WheelView;
import com.facebook.proguard.annotations.DoNotStrip;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Wt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2044Wt extends NG {
    public static byte[] A0D;
    public static String[] A0E;
    public static final String A0F;
    public float A00;
    public LQ A01;

    @DoNotStrip
    public AbstractC1848Pd A02;

    @Nullable
    public C1849Pe A03;
    public boolean A04;
    public final Path A05;
    public final RectF A06;
    public final C2026Wb A07;
    public final WeakReference<NJ> A08;
    public final AtomicBoolean A09;
    public final AtomicBoolean A0A;
    public final AtomicInteger A0B;
    public final AtomicReference<String> A0C;

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0D, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A0E;
            if (strArr[7].length() != strArr[6].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0E;
            strArr2[1] = "qkBM5EbEKD4bLDmS2";
            strArr2[1] = "qkBM5EbEKD4bLDmS2";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 94);
            i4++;
        }
    }

    public static void A05() {
        A0D = new byte[]{-23, 12, -21, 23, 22, 28, 26, 23, 20};
    }

    public static void A06() {
        A0E = new String[]{"8gq0YClbFfezV7VWazRrkmUo5IqHlAe0", "DZEC2fF8R1zbFaxtc", "FhN1N87P5UC3PnJCVDWnxEC", "JmSzPmcyjiRof3lizahs2qZ", "A3Evrr3LcR4BJzz79LIh", "2a6NLKfKqYFtWGCWoigE8lnPrM", "Nz12Z6hGfXPsqa2uThDzH9TN", "eI6gTMB0yvKckA2LC3VZ0zYV"};
    }

    static {
        A06();
        A05();
        A0F = C2044Wt.class.getSimpleName();
    }

    public C2044Wt(C2026Wb c2026Wb, WeakReference<NJ> weakReference, int i) {
        super(c2026Wb);
        this.A09 = new AtomicBoolean();
        this.A0A = new AtomicBoolean(true);
        this.A05 = new Path();
        this.A06 = new RectF();
        this.A0B = new AtomicInteger(5000);
        this.A0C = new AtomicReference<>();
        this.A01 = new LQ();
        this.A04 = true;
        this.A07 = c2026Wb;
        this.A08 = weakReference;
        this.A02 = new XL(this);
        this.A03 = new C1849Pe(this, i, new WeakReference(this.A02), this.A07);
        setWebChromeClient(A0C());
        setWebViewClient(A0D());
        getSettings().setSupportZoom(false);
        getSettings().setCacheMode(1);
        if (Build.VERSION.SDK_INT > 16) {
            addJavascriptInterface(new NI(this, weakReference.get(), this.A03, this.A09, this.A0A, this.A07), A02(0, 9, 74));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A04() {
        this.A07.A0A().AE0();
        this.A09.set(true);
        new Handler(Looper.getMainLooper()).post(new C2046Wv(this.A03));
    }

    @VisibleForTesting
    private final boolean A08() {
        return this.A09.get();
    }

    @Override // com.facebook.ads.redexgen.X.NG
    public final WebChromeClient A0C() {
        return new NK();
    }

    @Override // com.facebook.ads.redexgen.X.NG
    public final WebViewClient A0D() {
        return new NL(this.A07, this.A08, new WeakReference(this.A03), new WeakReference(this.A01), new WeakReference(this.A0A), new WeakReference(this), this.A0B, this.A0C);
    }

    public final void A0E(int i, int i2) {
        C1849Pe c1849Pe = this.A03;
        if (c1849Pe != null) {
            c1849Pe.A0Y(i);
            this.A03.A0Z(i2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.NG, android.webkit.WebView
    public final void destroy() {
        C1849Pe c1849Pe = this.A03;
        if (c1849Pe != null) {
            c1849Pe.A0X();
            this.A03 = null;
        }
        LX.A0M(this);
        this.A02 = null;
        this.A01 = null;
        NM.A04(this);
        super.destroy();
    }

    public LQ getTouchDataRecorder() {
        return this.A01;
    }

    public C1849Pe getViewabilityChecker() {
        return this.A03;
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onDraw(Canvas canvas) {
        if (this.A00 > WheelView.DividerConfig.FILL) {
            this.A06.set(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, getWidth(), getHeight());
            this.A05.reset();
            Path path = this.A05;
            RectF rectF = this.A06;
            float f2 = this.A00;
            path.addRoundRect(rectF, f2, f2, Path.Direction.CW);
            canvas.clipPath(this.A05);
        }
        super.onDraw(canvas);
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        this.A01.A07(motionEvent, this, this);
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.A08.get() != null) {
            this.A08.get();
        }
        if (this.A03 == null) {
            return;
        }
        this.A07.A0A().AEC(i);
        if (A0E[1].length() != 17) {
            throw new RuntimeException();
        }
        String[] strArr = A0E;
        strArr[7] = "DtJWCHxLbH6gtxJRxIB1oyEG";
        strArr[6] = "cIpyg99BbIZ2paT5Gicx86FT";
        if (i == 0 && A08()) {
            this.A03.A0W();
        } else {
            if (i != 8) {
                return;
            }
            this.A03.A0X();
        }
    }

    public void setCheckAssetsByJavascriptBridge(boolean z) {
        this.A0A.set(z);
    }

    public void setCornerRadius(float f2) {
        this.A00 = f2;
        invalidate();
    }

    public void setLogMultipleImpressions(boolean z) {
        this.A04 = z;
    }

    public void setRequestId(String str) {
        this.A0C.set(str);
    }

    public void setWebViewTimeoutInMillis(int i) {
        if (i >= 0) {
            this.A0B.set(i);
        }
    }
}
