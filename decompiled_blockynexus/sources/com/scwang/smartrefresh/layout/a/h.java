package com.scwang.smartrefresh.layout.a;

import android.view.View;

/* JADX INFO: compiled from: RefreshInternal.java */
/* JADX INFO: loaded from: classes.dex */
public interface h extends com.scwang.smartrefresh.layout.b.f {
    com.scwang.smartrefresh.layout.constant.b getSpinnerStyle();

    View getView();

    boolean isSupportHorizontalDrag();

    int onFinish(j jVar, boolean z);

    void onHorizontalDrag(float f2, int i, int i2);

    void onInitialized(i iVar, int i, int i2);

    void onMoving(boolean z, float f2, int i, int i2, int i3);

    void onReleased(j jVar, int i, int i2);

    void onStartAnimator(j jVar, int i, int i2);

    void setPrimaryColors(int... iArr);
}
