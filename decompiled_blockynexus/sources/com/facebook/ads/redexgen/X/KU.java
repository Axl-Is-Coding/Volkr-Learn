package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.ads.internal.shield.NoAutoExceptionHandling;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
@NoAutoExceptionHandling
@SuppressLint({"EmptyCatchBlock", "CatchGeneralException", "WrongCall", "RethrownThrowableArgument"})
public final class KU extends View {
    public static String[] A00;
    public static final AtomicBoolean A01;

    public static void A00() {
        A00 = new String[]{"kAVfBRgsuHAPyLthoP", "", "t17O26GbxI", "rw", "AAEx162laq7qeqX9thcQ", "HAXhrl7a7PCZ9u3oTFWkwwhVB4A5", "GFzV2eDHhD", "HOPUDh1leN9OTkJ3x1a"};
    }

    static {
        A00();
        A01 = new AtomicBoolean();
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
        C1719Ka.A00().A87(3303, th);
    }

    public static void A09(boolean z) {
        A01.set(z);
    }

    private final void A0A(boolean z) {
        super.onWindowFocusChanged(z);
    }

    private final void A0B(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    private final void A0C(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
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

    @Override // android.view.View
    public final void onAttachedToWindow() {
        try {
            A01();
        } catch (Throwable th) {
            String[] strArr = A00;
            if (strArr[6].length() == strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A00;
            strArr2[7] = "rnq1MXg";
            strArr2[7] = "rnq1MXg";
            if (A01.get()) {
                A08(th);
                super.onAttachedToWindow();
                return;
            }
            throw th;
        }
    }

    @Override // android.view.View
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
            A0C(z, i, rect);
        } catch (Throwable th) {
            if (A01.get()) {
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
                boolean zOnKeyDown = super.onKeyDown(i, keyEvent);
                String[] strArr = A00;
                if (strArr[6].length() == strArr[1].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A00;
                strArr2[6] = "5DVI70tdQk";
                strArr2[1] = "";
                return zOnKeyDown;
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

    @Override // android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        try {
            A0B(z, i, i2, i3, i4);
        } catch (Throwable th) {
            if (A01.get()) {
                A08(th);
                super.onLayout(z, i, i2, i3, i4);
                return;
            }
            throw th;
        }
    }

    @Override // android.view.View
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
            A0A(z);
        } catch (Throwable th) {
            if (A01.get()) {
                A08(th);
                if (A00[5].length() == 25) {
                    throw new RuntimeException();
                }
                String[] strArr = A00;
                strArr[0] = "0jBFwaBL8FA97JJQoE8VdUJeS";
                strArr[0] = "0jBFwaBL8FA97JJQoE8VdUJeS";
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
                if (A00[0].length() == 7) {
                    throw new RuntimeException();
                }
                String[] strArr = A00;
                strArr[5] = "8Ha1wZjMuo1MUnpr2KcgLPpAJB";
                strArr[5] = "8Ha1wZjMuo1MUnpr2KcgLPpAJB";
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
            AtomicBoolean atomicBoolean = A01;
            if (A00[7].length() == 24) {
                throw new RuntimeException();
            }
            String[] strArr = A00;
            strArr[7] = "LfZZ0wz91OrvOK";
            strArr[7] = "LfZZ0wz91OrvOK";
            if (atomicBoolean.get()) {
                A08(th);
                return super.performClick();
            }
            throw th;
        }
    }
}
