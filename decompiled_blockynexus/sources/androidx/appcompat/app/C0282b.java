package androidx.appcompat.app;

import android.view.View;
import androidx.core.widget.NestedScrollView;

/* JADX INFO: renamed from: androidx.appcompat.app.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AlertController.java */
/* JADX INFO: loaded from: classes.dex */
class C0282b implements NestedScrollView.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ View f285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ AlertController f286c;

    C0282b(AlertController alertController, View view, View view2) {
        this.f286c = alertController;
        this.f284a = view;
        this.f285b = view2;
    }

    @Override // androidx.core.widget.NestedScrollView.b
    public void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
        AlertController.a(nestedScrollView, this.f284a, this.f285b);
    }
}
