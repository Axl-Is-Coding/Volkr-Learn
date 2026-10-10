package androidx.appcompat.app;

import android.view.View;

/* JADX INFO: renamed from: androidx.appcompat.app.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AlertController.java */
/* JADX INFO: loaded from: classes.dex */
class RunnableC0285e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ View f294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ AlertController f295c;

    RunnableC0285e(AlertController alertController, View view, View view2) {
        this.f295c = alertController;
        this.f293a = view;
        this.f294b = view2;
    }

    @Override // java.lang.Runnable
    public void run() {
        AlertController.a(this.f295c.g, this.f293a, this.f294b);
    }
}
