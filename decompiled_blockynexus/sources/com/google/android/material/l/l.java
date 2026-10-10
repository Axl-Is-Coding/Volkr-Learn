package com.google.android.material.l;

import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: compiled from: RoundedCornerTreatment.java */
/* JADX INFO: loaded from: classes2.dex */
public class l extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    float f13528a = -1.0f;

    @Override // com.google.android.material.l.d
    public void a(q qVar, float f2, float f3, float f4) {
        qVar.a(WheelView.DividerConfig.FILL, f4 * f3, 180.0f, 180.0f - f2);
        float f5 = f4 * 2.0f * f3;
        qVar.a(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, f5, f5, 180.0f, f2);
    }
}
