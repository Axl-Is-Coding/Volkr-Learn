package com.google.android.material.chip;

import android.annotation.TargetApi;
import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: compiled from: Chip.java */
/* JADX INFO: loaded from: classes2.dex */
class b extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Chip f13258a;

    b(Chip chip) {
        this.f13258a = chip;
    }

    @Override // android.view.ViewOutlineProvider
    @TargetApi(21)
    public void getOutline(View view, Outline outline) {
        if (this.f13258a.chipDrawable != null) {
            this.f13258a.chipDrawable.getOutline(outline);
        } else {
            outline.setAlpha(WheelView.DividerConfig.FILL);
        }
    }
}
