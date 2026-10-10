package androidx.appcompat.widget;

import android.view.View;

/* JADX INFO: renamed from: androidx.appcompat.widget.n, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ActivityChooserView.java */
/* JADX INFO: loaded from: classes.dex */
class C0301n extends I {
    final /* synthetic */ ActivityChooserView j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0301n(ActivityChooserView activityChooserView, View view) {
        super(view);
        this.j = activityChooserView;
    }

    @Override // androidx.appcompat.widget.I
    public androidx.appcompat.view.menu.m a() {
        return this.j.getListPopupWindow();
    }

    @Override // androidx.appcompat.widget.I
    protected boolean b() {
        this.j.showPopup();
        return true;
    }

    @Override // androidx.appcompat.widget.I
    protected boolean c() {
        this.j.dismissPopup();
        return true;
    }
}
