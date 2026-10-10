package androidx.appcompat.widget;

/* JADX INFO: renamed from: androidx.appcompat.widget.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AbsActionBarView.java */
/* JADX INFO: loaded from: classes.dex */
class RunnableC0288a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AbstractC0289b f628a;

    RunnableC0288a(AbstractC0289b abstractC0289b) {
        this.f628a = abstractC0289b;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f628a.showOverflowMenu();
    }
}
