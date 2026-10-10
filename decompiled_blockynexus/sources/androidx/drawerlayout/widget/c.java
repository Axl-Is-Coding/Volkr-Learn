package androidx.drawerlayout.widget;

import androidx.drawerlayout.widget.DrawerLayout;

/* JADX INFO: compiled from: DrawerLayout.java */
/* JADX INFO: loaded from: classes.dex */
class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ DrawerLayout.e f1382a;

    c(DrawerLayout.e eVar) {
        this.f1382a = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1382a.a();
    }
}
