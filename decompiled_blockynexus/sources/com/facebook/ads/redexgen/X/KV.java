package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.facebook.ads.internal.shield.NoAutoExceptionHandling;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
@NoAutoExceptionHandling
@SuppressLint({"EmptyCatchBlock", "CatchGeneralException", "RethrownThrowableArgument"})
public final class KV extends ViewGroup {
    public static final AtomicBoolean A00 = new AtomicBoolean();

    private final void A00() {
        super.onAttachedToWindow();
    }

    private final void A01() {
        super.onDetachedFromWindow();
    }

    private final void A02() {
        super.onFinishInflate();
    }

    private final void A03(int i) {
        super.onWindowVisibilityChanged(i);
    }

    @SuppressLint({"WrongCall"})
    private final void A04(int i, int i2) {
        super.onMeasure(i, i2);
    }

    private final void A05(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    @SuppressLint({"WrongCall"})
    private final void A06(Canvas canvas) {
        super.onDraw(canvas);
    }

    private void A07(Throwable th) {
        C1719Ka.A00().A87(3304, th);
    }

    public static void A08(boolean z) {
        A00.set(z);
    }

    private final void A09(boolean z) {
        super.onWindowFocusChanged(z);
    }

    private final void A0A(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
    }

    private final boolean A0B() {
        return super.performClick();
    }

    private final boolean A0C(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    private final boolean A0D(int i, KeyEvent keyEvent) {
        return super.onKeyUp(i, keyEvent);
    }

    private final boolean A0E(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    private final boolean A0F(MotionEvent motionEvent) {
        return super.onTrackballEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        try {
            A00();
        } catch (Throwable th) {
            if (A00.get()) {
                A07(th);
                super.onAttachedToWindow();
                return;
            }
            throw th;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        try {
            A01();
        } catch (Throwable th) {
            if (A00.get()) {
                A07(th);
                super.onDetachedFromWindow();
                return;
            }
            throw th;
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        try {
            A06(canvas);
        } catch (Throwable th) {
            if (A00.get()) {
                A07(th);
                super.onDraw(canvas);
                return;
            }
            throw th;
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        try {
            A02();
        } catch (Throwable th) {
            if (A00.get()) {
                A07(th);
                super.onFinishInflate();
                return;
            }
            throw th;
        }
    }

    @Override // android.view.View
    public final void onFocusChanged(boolean z, int i, Rect rect) {
        try {
            A0A(z, i, rect);
        } catch (Throwable th) {
            if (A00.get()) {
                A07(th);
                super.onFocusChanged(z, i, rect);
                return;
            }
            throw th;
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        try {
            return A0C(i, keyEvent);
        } catch (Throwable th) {
            if (A00.get()) {
                A07(th);
                return super.onKeyDown(i, keyEvent);
            }
            throw th;
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        try {
            return A0D(i, keyEvent);
        } catch (Throwable th) {
            if (A00.get()) {
                A07(th);
                return super.onKeyUp(i, keyEvent);
            }
            throw th;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        try {
            A04(i, i2);
        } catch (Throwable th) {
            if (A00.get()) {
                A07(th);
                super.onMeasure(i, i2);
                return;
            }
            throw th;
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        try {
            A05(i, i2, i3, i4);
        } catch (Throwable th) {
            if (A00.get()) {
                A07(th);
                super.onSizeChanged(i, i2, i3, i4);
                return;
            }
            throw th;
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            return A0E(motionEvent);
        } catch (Throwable th) {
            if (A00.get()) {
                A07(th);
                return super.onTouchEvent(motionEvent);
            }
            throw th;
        }
    }

    @Override // android.view.View
    public final boolean onTrackballEvent(MotionEvent motionEvent) {
        try {
            return A0F(motionEvent);
        } catch (Throwable th) {
            if (A00.get()) {
                A07(th);
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
            if (A00.get()) {
                A07(th);
                super.onWindowFocusChanged(z);
                return;
            }
            throw th;
        }
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        try {
            A03(i);
        } catch (Throwable th) {
            if (A00.get()) {
                A07(th);
                super.onWindowVisibilityChanged(i);
                return;
            }
            throw th;
        }
    }

    @Override // android.view.View
    public final boolean performClick() {
        try {
            return A0B();
        } catch (Throwable th) {
            if (A00.get()) {
                A07(th);
                return super.performClick();
            }
            throw th;
        }
    }
}
