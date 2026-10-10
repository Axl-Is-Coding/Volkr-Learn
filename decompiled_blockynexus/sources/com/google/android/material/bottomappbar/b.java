package com.google.android.material.bottomappbar;

import cn.qqtheme.framework.widget.WheelView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* JADX INFO: compiled from: BottomAppBar.java */
/* JADX INFO: loaded from: classes2.dex */
class b implements com.google.android.material.a.k<FloatingActionButton> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ BottomAppBar f13174a;

    b(BottomAppBar bottomAppBar) {
        this.f13174a = bottomAppBar;
    }

    @Override // com.google.android.material.a.k
    public void a(FloatingActionButton floatingActionButton) {
        this.f13174a.materialShapeDrawable.c(floatingActionButton.getVisibility() == 0 ? floatingActionButton.getScaleY() : WheelView.DividerConfig.FILL);
    }

    @Override // com.google.android.material.a.k
    public void b(FloatingActionButton floatingActionButton) {
        float translationX = floatingActionButton.getTranslationX();
        if (this.f13174a.getTopEdgeTreatment().f() != translationX) {
            this.f13174a.getTopEdgeTreatment().e(translationX);
            this.f13174a.materialShapeDrawable.invalidateSelf();
        }
        float f2 = -floatingActionButton.getTranslationY();
        if (this.f13174a.getTopEdgeTreatment().b() != f2) {
            this.f13174a.getTopEdgeTreatment().a(f2);
            this.f13174a.materialShapeDrawable.invalidateSelf();
        }
        this.f13174a.materialShapeDrawable.c(floatingActionButton.getVisibility() == 0 ? floatingActionButton.getScaleY() : WheelView.DividerConfig.FILL);
    }
}
