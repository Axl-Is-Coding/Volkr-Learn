package com.scwang.smartrefresh.layout.a;

import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: compiled from: RefreshContent.java */
/* JADX INFO: loaded from: classes.dex */
public interface e {
    ValueAnimator.AnimatorUpdateListener a(int i);

    View a();

    void a(int i, int i2, int i3);

    void a(MotionEvent motionEvent);

    void a(i iVar, View view, View view2);

    void a(k kVar);

    void a(boolean z);

    boolean b();

    boolean c();

    View getView();
}
