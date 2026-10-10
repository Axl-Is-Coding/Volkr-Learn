package com.google.android.material.f;

import android.content.Context;
import android.graphics.Color;
import cn.qqtheme.framework.widget.WheelView;
import com.google.android.material.R;
import com.google.android.material.i.b;

/* JADX INFO: compiled from: ElevationOverlayProvider.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f13357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f13358b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f13359c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f13360d;

    public a(Context context) {
        this.f13357a = b.a(context, R.attr.elevationOverlayEnabled, false);
        this.f13358b = com.google.android.material.d.a.a(context, R.attr.elevationOverlayColor, 0);
        this.f13359c = com.google.android.material.d.a.a(context, R.attr.colorSurface, 0);
        this.f13360d = context.getResources().getDisplayMetrics().density;
    }

    public int a(int i, float f2) {
        float fA = a(f2);
        return androidx.core.a.a.b(com.google.android.material.d.a.a(androidx.core.a.a.b(i, 255), this.f13358b, fA), Color.alpha(i));
    }

    public int b(int i, float f2) {
        return (this.f13357a && a(i)) ? a(i, f2) : i;
    }

    public float a(float f2) {
        return (this.f13360d <= WheelView.DividerConfig.FILL || f2 <= WheelView.DividerConfig.FILL) ? WheelView.DividerConfig.FILL : Math.min(((((float) Math.log1p(f2 / r0)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
    }

    public boolean a() {
        return this.f13357a;
    }

    private boolean a(int i) {
        return androidx.core.a.a.b(i, 255) == this.f13359c;
    }
}
