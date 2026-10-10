package com.twitter.sdk.android.tweetui.internal;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: loaded from: classes5.dex */
public class SwipeToDismissTouchListener implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f20377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f20378b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f20379c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f20380d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private a f20381e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f20382f;
    private float g;
    private int h;
    private boolean i;

    public interface a {
        void a(float f2);

        void onDismiss();
    }

    public interface b {
        boolean canBeSwiped();
    }

    SwipeToDismissTouchListener(a aVar, int i, float f2) {
        this(aVar, i, f2, 0.2f * f2);
    }

    public static SwipeToDismissTouchListener a(View view, a aVar) {
        return new SwipeToDismissTouchListener(aVar, ViewConfiguration.get(view.getContext()).getScaledTouchSlop(), view.getContext().getResources().getDisplayMetrics().heightPixels * 0.5f);
    }

    void b(View view) {
        if (view.getTranslationY() != WheelView.DividerConfig.FILL) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_Y, WheelView.DividerConfig.FILL).setDuration(100L);
            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.twitter.sdk.android.tweetui.internal.c
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f20408a.a(valueAnimator);
                }
            });
            duration.start();
        }
    }

    boolean c(float f2) {
        return Math.abs(f2) > ((float) this.f20377a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return ((!(view instanceof b) || ((b) view).canBeSwiped() || a()) ? a(view, motionEvent) : false) || view.onTouchEvent(motionEvent);
    }

    public void setCallback(a aVar) {
        this.f20381e = aVar;
    }

    SwipeToDismissTouchListener(a aVar, int i, float f2, float f3) {
        setCallback(aVar);
        this.f20377a = i;
        this.f20379c = f2;
        this.f20380d = f3;
    }

    boolean a(View view, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    float rawX = motionEvent.getRawX();
                    float rawY = motionEvent.getRawY();
                    float f2 = rawY - this.f20378b;
                    float f3 = rawX - this.f20382f;
                    float f4 = rawY - this.g;
                    this.f20382f = rawX;
                    this.g = rawY;
                    if (a(motionEvent) && (this.i || (c(f2) && a(f3, f4)))) {
                        this.i = true;
                        a(view, f4);
                    }
                } else if (actionMasked != 3) {
                    if (actionMasked == 5) {
                        b(view);
                        this.i = false;
                        this.h = -1;
                    }
                }
            }
            boolean zA = (a(motionEvent) && this.i) ? a(view) : false;
            this.i = false;
            return zA;
        }
        this.f20382f = motionEvent.getRawX();
        float rawY2 = motionEvent.getRawY();
        this.g = rawY2;
        this.f20378b = rawY2;
        this.i = false;
        this.h = motionEvent.getPointerId(motionEvent.getPointerCount() - 1);
        return false;
    }

    double b(float f2) {
        return 1.0d - (Math.pow(Math.abs(f2), 2.0d) / Math.pow(this.f20380d * 2.0f, 2.0d));
    }

    boolean a(float f2, float f3) {
        return Math.abs(f3) > Math.abs(f2);
    }

    boolean a() {
        return this.i;
    }

    boolean a(MotionEvent motionEvent) {
        return this.h >= 0 && motionEvent.getPointerCount() == 1;
    }

    boolean a(View view) {
        float translationY = view.getTranslationY();
        float f2 = this.f20380d;
        if (translationY <= f2 && translationY >= (-f2)) {
            b(view);
            return false;
        }
        a aVar = this.f20381e;
        if (aVar == null) {
            return true;
        }
        aVar.onDismiss();
        return true;
    }

    public /* synthetic */ void a(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        a aVar = this.f20381e;
        if (aVar != null) {
            aVar.a(fFloatValue);
        }
    }

    void a(View view, float f2) {
        float translationY = view.getTranslationY();
        double d2 = f2;
        double dB = b(translationY);
        Double.isNaN(d2);
        float fA = a(translationY + ((float) (d2 * dB)));
        view.setTranslationY(fA);
        a aVar = this.f20381e;
        if (aVar != null) {
            aVar.a(fA);
        }
    }

    float a(float f2) {
        float f3 = this.f20379c;
        return f2 < (-f3) ? -f3 : f2 > f3 ? f3 : f2;
    }
}
