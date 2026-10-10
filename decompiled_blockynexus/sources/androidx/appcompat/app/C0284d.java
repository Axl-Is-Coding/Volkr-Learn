package androidx.appcompat.app;

import android.view.View;
import android.widget.AbsListView;

/* JADX INFO: renamed from: androidx.appcompat.app.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AlertController.java */
/* JADX INFO: loaded from: classes.dex */
class C0284d implements AbsListView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ View f291b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ AlertController f292c;

    C0284d(AlertController alertController, View view, View view2) {
        this.f292c = alertController;
        this.f290a = view;
        this.f291b = view2;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        AlertController.a(absListView, this.f290a, this.f291b);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
