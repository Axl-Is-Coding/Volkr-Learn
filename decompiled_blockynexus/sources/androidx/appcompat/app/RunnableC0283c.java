package androidx.appcompat.app;

import android.view.View;

/* JADX INFO: renamed from: androidx.appcompat.app.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AlertController.java */
/* JADX INFO: loaded from: classes.dex */
class RunnableC0283c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ View f288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ AlertController f289c;

    RunnableC0283c(AlertController alertController, View view, View view2) {
        this.f289c = alertController;
        this.f287a = view;
        this.f288b = view2;
    }

    @Override // java.lang.Runnable
    public void run() {
        AlertController.a(this.f289c.A, this.f287a, this.f288b);
    }
}
