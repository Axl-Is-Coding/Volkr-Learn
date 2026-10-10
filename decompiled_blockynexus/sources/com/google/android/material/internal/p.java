package com.google.android.material.internal;

import android.content.Context;
import android.text.TextPaint;
import cn.qqtheme.framework.widget.WheelView;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: TextDrawableHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public class p {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f13477c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.google.android.material.i.f f13480f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextPaint f13475a = new TextPaint(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.android.material.i.h f13476b = new o(this);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f13478d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private WeakReference<a> f13479e = new WeakReference<>(null);

    /* JADX INFO: compiled from: TextDrawableHelper.java */
    public interface a {
        void a();

        int[] getState();

        boolean onStateChange(int[] iArr);
    }

    public p(a aVar) {
        a(aVar);
    }

    public TextPaint b() {
        return this.f13475a;
    }

    public void a(a aVar) {
        this.f13479e = new WeakReference<>(aVar);
    }

    public void a(boolean z) {
        this.f13478d = z;
    }

    public float a(String str) {
        if (!this.f13478d) {
            return this.f13477c;
        }
        this.f13477c = a((CharSequence) str);
        this.f13478d = false;
        return this.f13477c;
    }

    private float a(CharSequence charSequence) {
        return charSequence == null ? WheelView.DividerConfig.FILL : this.f13475a.measureText(charSequence, 0, charSequence.length());
    }

    public com.google.android.material.i.f a() {
        return this.f13480f;
    }

    public void a(com.google.android.material.i.f fVar, Context context) {
        if (this.f13480f != fVar) {
            this.f13480f = fVar;
            if (fVar != null) {
                fVar.c(context, this.f13475a, this.f13476b);
                a aVar = this.f13479e.get();
                if (aVar != null) {
                    this.f13475a.drawableState = aVar.getState();
                }
                fVar.b(context, this.f13475a, this.f13476b);
                this.f13478d = true;
            }
            a aVar2 = this.f13479e.get();
            if (aVar2 != null) {
                aVar2.a();
                aVar2.onStateChange(aVar2.getState());
            }
        }
    }

    public void a(Context context) {
        this.f13480f.b(context, this.f13475a, this.f13476b);
    }
}
