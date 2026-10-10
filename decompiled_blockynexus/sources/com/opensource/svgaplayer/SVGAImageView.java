package com.opensource.svgaplayer;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.media.SoundPool;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import cn.qqtheme.framework.widget.WheelView;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SVGAImageView.kt */
/* JADX INFO: loaded from: classes2.dex */
public class SVGAImageView extends ImageView {
    private HashMap _$_findViewCache;
    private ValueAnimator animator;
    private b callback;
    private boolean clearsAfterStop;
    private FillMode fillMode;
    private boolean isAnimating;
    private int loops;
    private SVGAClickAreaListener mItemClickAreaListener;
    private q mVideoItem;

    /* JADX INFO: compiled from: SVGAImageView.kt */
    public enum FillMode {
        Backward,
        Forward
    }

    public SVGAImageView(Context context) {
        super(context);
        this.clearsAfterStop = true;
        this.fillMode = FillMode.Forward;
        setSoftwareLayerType();
    }

    private final void clearAudio() {
        List<com.opensource.svgaplayer.entities.a> listB;
        SoundPool soundPoolF;
        q qVar = this.mVideoItem;
        if (qVar == null || (listB = qVar.b()) == null) {
            return;
        }
        for (com.opensource.svgaplayer.entities.a aVar : listB) {
            Integer numB = aVar.b();
            if (numB != null) {
                int iIntValue = numB.intValue();
                q qVar2 = this.mVideoItem;
                if (qVar2 != null && (soundPoolF = qVar2.f()) != null) {
                    soundPoolF.stop(iIntValue);
                }
            }
            aVar.a(null);
        }
    }

    private final void loadAttrs(AttributeSet attributeSet) {
        Context context = getContext();
        kotlin.jvm.internal.i.a((Object) context, com.umeng.analytics.pro.b.Q);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SVGAImageView, 0, 0);
        this.loops = typedArrayObtainStyledAttributes.getInt(R.styleable.SVGAImageView_loopCount, 0);
        this.clearsAfterStop = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_clearsAfterStop, true);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_antiAlias, true);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_autoPlay, true);
        String string = typedArrayObtainStyledAttributes.getString(R.styleable.SVGAImageView_fillMode);
        if (string != null) {
            if (kotlin.jvm.internal.i.a((Object) string, (Object) "0")) {
                this.fillMode = FillMode.Backward;
            } else if (kotlin.jvm.internal.i.a((Object) string, (Object) "1")) {
                this.fillMode = FillMode.Forward;
            }
        }
        String string2 = typedArrayObtainStyledAttributes.getString(R.styleable.SVGAImageView_source);
        if (string2 != null) {
            new Thread(new g(string2, new SVGAParser(getContext()), this, z, z2)).start();
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private final void setAnimating(boolean z) {
        this.isAnimating = z;
    }

    private final void setSoftwareLayerType() {
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
    }

    public static /* synthetic */ void startAnimation$default(SVGAImageView sVGAImageView, com.opensource.svgaplayer.b.b bVar, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startAnimation");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        sVGAImageView.startAnimation(bVar, z);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap map = this._$_findViewCache;
        if (map != null) {
            map.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    public final b getCallback() {
        return this.callback;
    }

    public final boolean getClearsAfterStop() {
        return this.clearsAfterStop;
    }

    public final FillMode getFillMode() {
        return this.fillMode;
    }

    public final int getLoops() {
        return this.loops;
    }

    public final boolean isAnimating() {
        return this.isAnimating;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        clearAudio();
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.animator;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        ValueAnimator valueAnimator3 = this.animator;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllUpdateListeners();
        }
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        SVGAClickAreaListener sVGAClickAreaListener;
        if (motionEvent != null && motionEvent.getAction() == 0) {
            Drawable drawable = getDrawable();
            if (!(drawable instanceof c)) {
                drawable = null;
            }
            c cVar = (c) drawable;
            if (cVar == null) {
                return false;
            }
            for (Map.Entry<String, int[]> entry : cVar.b().j().entrySet()) {
                String key = entry.getKey();
                int[] value = entry.getValue();
                if (motionEvent.getX() >= value[0] && motionEvent.getX() <= value[2] && motionEvent.getY() >= value[1] && motionEvent.getY() <= value[3] && (sVGAClickAreaListener = this.mItemClickAreaListener) != null) {
                    sVGAClickAreaListener.onClick(key);
                    return true;
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void pauseAnimation() {
        stopAnimation(false);
        b bVar = this.callback;
        if (bVar != null) {
            bVar.onPause();
        }
    }

    public final void setCallback(b bVar) {
        this.callback = bVar;
    }

    public final void setClearsAfterStop(boolean z) {
        this.clearsAfterStop = z;
    }

    public final void setFillMode(FillMode fillMode) {
        kotlin.jvm.internal.i.b(fillMode, "<set-?>");
        this.fillMode = fillMode;
    }

    public final void setLoops(int i) {
        this.loops = i;
    }

    public final void setOnAnimKeyClickListener(SVGAClickAreaListener sVGAClickAreaListener) {
        kotlin.jvm.internal.i.b(sVGAClickAreaListener, "clickListener");
        this.mItemClickAreaListener = sVGAClickAreaListener;
    }

    public final void setVideoItem(q qVar) {
        setVideoItem(qVar, new d());
    }

    public final void startAnimation() {
        startAnimation(null, false);
    }

    public final void stepToFrame(int i, boolean z) {
        pauseAnimation();
        Drawable drawable = getDrawable();
        if (!(drawable instanceof c)) {
            drawable = null;
        }
        c cVar = (c) drawable;
        if (cVar != null) {
            cVar.a(i);
            if (z) {
                startAnimation();
                ValueAnimator valueAnimator = this.animator;
                if (valueAnimator != null) {
                    valueAnimator.setCurrentPlayTime((long) (Math.max(WheelView.DividerConfig.FILL, Math.min(1.0f, i / cVar.c().d())) * valueAnimator.getDuration()));
                }
            }
        }
    }

    public final void stepToPercentage(double d2, boolean z) {
        Drawable drawable = getDrawable();
        if (!(drawable instanceof c)) {
            drawable = null;
        }
        c cVar = (c) drawable;
        if (cVar != null) {
            double d3 = cVar.c().d();
            Double.isNaN(d3);
            int iD = (int) (d3 * d2);
            if (iD >= cVar.c().d() && iD > 0) {
                iD = cVar.c().d() - 1;
            }
            stepToFrame(iD, z);
        }
    }

    public final void stopAnimation() {
        stopAnimation(this.clearsAfterStop);
    }

    public final void setVideoItem(q qVar, d dVar) {
        if (qVar == null) {
            setImageDrawable(null);
            return;
        }
        if (dVar == null) {
            dVar = new d();
        }
        c cVar = new c(qVar, dVar);
        cVar.a(this.clearsAfterStop);
        setImageDrawable(cVar);
        this.mVideoItem = qVar;
    }

    public final void startAnimation(com.opensource.svgaplayer.b.b bVar, boolean z) {
        Field declaredField;
        stopAnimation(false);
        Drawable drawable = getDrawable();
        if (!(drawable instanceof c)) {
            drawable = null;
        }
        c cVar = (c) drawable;
        if (cVar != null) {
            cVar.a(false);
            ImageView.ScaleType scaleType = getScaleType();
            kotlin.jvm.internal.i.a((Object) scaleType, "scaleType");
            cVar.a(scaleType);
            q qVarC = cVar.c();
            if (bVar != null) {
                bVar.b();
                throw null;
            }
            int iMax = Math.max(0, 0);
            int iD = qVarC.d() - 1;
            if (bVar != null) {
                bVar.b();
                throw null;
            }
            if (bVar != null) {
                bVar.a();
                throw null;
            }
            int iMin = Math.min(iD, (Integer.MAX_VALUE + 0) - 1);
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(iMax, iMin);
            double d2 = 1.0d;
            try {
                Class<?> cls = Class.forName("android.animation.ValueAnimator");
                if (cls != null && (declaredField = cls.getDeclaredField("sDurationScale")) != null) {
                    declaredField.setAccessible(true);
                    double d3 = declaredField.getFloat(cls);
                    if (d3 == 0.0d) {
                        try {
                            declaredField.setFloat(cls, 1.0f);
                            Log.e("SVGAPlayer", "The animation duration scale has been reset to 1.0x, because you closed it on developer options.");
                        } catch (Exception unused) {
                            d2 = d3;
                        }
                    } else {
                        d2 = d3;
                    }
                }
            } catch (Exception unused2) {
            }
            kotlin.jvm.internal.i.a((Object) valueAnimatorOfInt, "animator");
            valueAnimatorOfInt.setInterpolator(new LinearInterpolator());
            double dC = ((iMin - iMax) + 1) * (1000 / qVarC.c());
            Double.isNaN(dC);
            valueAnimatorOfInt.setDuration((long) (dC / d2));
            int i = this.loops;
            valueAnimatorOfInt.setRepeatCount(i <= 0 ? 99999 : i - 1);
            valueAnimatorOfInt.addUpdateListener(new h(valueAnimatorOfInt, this, bVar, cVar, z));
            valueAnimatorOfInt.addListener(new i(iMax, iMin, this, bVar, cVar, z));
            if (z) {
                valueAnimatorOfInt.reverse();
            } else {
                valueAnimatorOfInt.start();
            }
            this.animator = valueAnimatorOfInt;
        }
    }

    public final void stopAnimation(boolean z) {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.animator;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        ValueAnimator valueAnimator3 = this.animator;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllUpdateListeners();
        }
        Drawable drawable = getDrawable();
        if (!(drawable instanceof c)) {
            drawable = null;
        }
        c cVar = (c) drawable;
        if (cVar != null) {
            cVar.a(z);
        }
    }

    public SVGAImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.clearsAfterStop = true;
        this.fillMode = FillMode.Forward;
        setSoftwareLayerType();
        if (attributeSet != null) {
            loadAttrs(attributeSet);
        }
    }

    public SVGAImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.clearsAfterStop = true;
        this.fillMode = FillMode.Forward;
        setSoftwareLayerType();
        if (attributeSet != null) {
            loadAttrs(attributeSet);
        }
    }

    public SVGAImageView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.clearsAfterStop = true;
        this.fillMode = FillMode.Forward;
        setSoftwareLayerType();
        if (attributeSet != null) {
            loadAttrs(attributeSet);
        }
    }
}
