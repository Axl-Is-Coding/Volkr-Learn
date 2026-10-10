package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.shield.NoAutoExceptionHandling;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
@NoAutoExceptionHandling
@SuppressLint({"EmptyCatchBlock", "CatchGeneralException", "WrongCall"})
public final class KS extends RelativeLayout {
    public static String[] A00;
    public static final AtomicBoolean A01;
    public static final AtomicReference<KJ> A02;

    public static void A00() {
        A00 = new String[]{"rKALTBDYJCbaiFNXEtUJroCn52VpZZ", "JV6MiXKUyj6JCzF1u", "kCmdEzEHbLuzxIacOyabQp9NKin7bt2r", "jWcGCQZMqdkAqfRZe6", "nlkBBG2n0OIOkXKFHLw9fg1KFY8VWnLB", "EEOdRs0yxrMLewCcdlWj6UoX1OR7WiBI", "iBrckNfFoUM659sftuZ", "XnvO082n6pbwhWKAJ"};
    }

    static {
        A00();
        A01 = new AtomicBoolean();
        A02 = new AtomicReference<>();
    }

    private final void A01() {
        super.onAttachedToWindow();
    }

    private final void A02() {
        super.onDetachedFromWindow();
    }

    private final void A03() {
        super.onFinishInflate();
    }

    private final void A04(int i) {
        super.onWindowVisibilityChanged(i);
    }

    private final void A05(int i, int i2) {
        super.onMeasure(i, i2);
    }

    private final void A06(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    private final void A07(Canvas canvas) {
        super.onDraw(canvas);
    }

    private void A08(Throwable th) {
        C1719Ka.A00().A87(3305, th);
        KJ kj = A02.get();
        if (kj != null) {
            kj.ACk(th, this);
        }
    }

    private final void A09(boolean z) {
        super.onWindowFocusChanged(z);
    }

    private final void A0A(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    private final void A0B(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
    }

    public static void A0C(boolean z, KJ kj) {
        A01.set(z);
        A02.set(kj);
    }

    private final boolean A0D() {
        return super.performClick();
    }

    private final boolean A0E(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    private final boolean A0F(int i, KeyEvent keyEvent) {
        return super.onKeyUp(i, keyEvent);
    }

    private final boolean A0G(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    private final boolean A0H(MotionEvent motionEvent) {
        return super.onTrackballEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        try {
            A01();
        } catch (Throwable th) {
            if (A01.get()) {
                A08(th);
                super.onAttachedToWindow();
                return;
            }
            throw th;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        try {
            A02();
        } catch (Throwable th) {
            if (A01.get()) {
                A08(th);
                super.onDetachedFromWindow();
                return;
            }
            throw th;
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        try {
            A07(canvas);
        } catch (Throwable th) {
            if (A01.get()) {
                A08(th);
                super.onDraw(canvas);
                return;
            }
            throw th;
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        try {
            A03();
        } catch (Throwable th) {
            if (A01.get()) {
                A08(th);
                super.onFinishInflate();
                return;
            }
            throw th;
        }
    }

    @Override // android.view.View
    public final void onFocusChanged(boolean z, int i, Rect rect) {
        try {
            A0B(z, i, rect);
        } catch (Throwable th) {
            boolean z2 = A01.get();
            if (A00[4].charAt(9) == '8') {
                throw new RuntimeException();
            }
            String[] strArr = A00;
            strArr[0] = "cWID6xQloznFOrhLXGfxCs3XAeGgBa";
            strArr[0] = "cWID6xQloznFOrhLXGfxCs3XAeGgBa";
            if (z2) {
                A08(th);
                super.onFocusChanged(z, i, rect);
                return;
            }
            throw th;
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        try {
            return A0E(i, keyEvent);
        } catch (Throwable th) {
            if (A01.get()) {
                A08(th);
                return super.onKeyDown(i, keyEvent);
            }
            throw th;
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        try {
            return A0F(i, keyEvent);
        } catch (Throwable th) {
            if (A01.get()) {
                A08(th);
                return super.onKeyUp(i, keyEvent);
            }
            throw th;
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        try {
            A0A(z, i, i2, i3, i4);
        } catch (Throwable th) {
            if (A01.get()) {
                A08(th);
                super.onLayout(z, i, i2, i3, i4);
                return;
            }
            throw th;
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        try {
            A05(i, i2);
        } catch (Throwable th) {
            if (A01.get()) {
                A08(th);
                super.onMeasure(i, i2);
                return;
            }
            throw th;
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        try {
            A06(i, i2, i3, i4);
        } catch (Throwable th) {
            if (A01.get()) {
                A08(th);
                super.onSizeChanged(i, i2, i3, i4);
                return;
            }
            throw th;
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            return A0G(motionEvent);
        } catch (Throwable th) {
            if (A01.get()) {
                A08(th);
                return super.onTouchEvent(motionEvent);
            }
            throw th;
        }
    }

    @Override // android.view.View
    public final boolean onTrackballEvent(MotionEvent motionEvent) {
        try {
            return A0H(motionEvent);
        } catch (Throwable th) {
            if (A01.get()) {
                A08(th);
                return super.onTrackballEvent(motionEvent);
            }
            throw th;
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        try {
            A09(z);
        } catch (Throwable th) {
            if (A01.get()) {
                A08(th);
                super.onWindowFocusChanged(z);
                return;
            }
            throw th;
        }
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        try {
            A04(i);
        } catch (Throwable th) {
            if (A01.get()) {
                A08(th);
                super.onWindowVisibilityChanged(i);
                return;
            }
            throw th;
        }
    }

    @Override // android.view.View
    public final boolean performClick() {
        try {
            return A0D();
        } catch (Throwable th) {
            if (A01.get()) {
                A08(th);
                return super.performClick();
            }
            throw th;
        }
    }
}
