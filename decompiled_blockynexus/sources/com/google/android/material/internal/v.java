package com.google.android.material.internal;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;
import androidx.core.view.J;
import androidx.core.view.ViewCompat;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: compiled from: ViewUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class v {

    /* JADX INFO: compiled from: ViewUtils.java */
    public interface a {
        J a(View view, J j, b bVar);
    }

    public static PorterDuff.Mode a(int i, PorterDuff.Mode mode) {
        if (i == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    public static boolean b(View view) {
        return ViewCompat.m(view) == 1;
    }

    public static void c(View view) {
        if (ViewCompat.B(view)) {
            ViewCompat.H(view);
        } else {
            view.addOnAttachStateChangeListener(new u());
        }
    }

    /* JADX INFO: compiled from: ViewUtils.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f13489a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f13490b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f13491c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f13492d;

        public b(int i, int i2, int i3, int i4) {
            this.f13489a = i;
            this.f13490b = i2;
            this.f13491c = i3;
            this.f13492d = i4;
        }

        public void a(View view) {
            ViewCompat.b(view, this.f13489a, this.f13490b, this.f13491c, this.f13492d);
        }

        public b(b bVar) {
            this.f13489a = bVar.f13489a;
            this.f13490b = bVar.f13490b;
            this.f13491c = bVar.f13491c;
            this.f13492d = bVar.f13492d;
        }
    }

    public static float a(Context context, int i) {
        return TypedValue.applyDimension(1, i, context.getResources().getDisplayMetrics());
    }

    public static void a(View view, a aVar) {
        ViewCompat.a(view, new t(aVar, new b(ViewCompat.r(view), view.getPaddingTop(), ViewCompat.q(view), view.getPaddingBottom())));
        c(view);
    }

    public static float a(View view) {
        float fI = WheelView.DividerConfig.FILL;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            fI += ViewCompat.i((View) parent);
        }
        return fI;
    }
}
