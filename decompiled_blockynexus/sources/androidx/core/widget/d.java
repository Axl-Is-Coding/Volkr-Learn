package androidx.core.widget;

/* JADX INFO: compiled from: ContentLoadingProgressBar.java */
/* JADX INFO: loaded from: classes.dex */
class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ContentLoadingProgressBar f1301a;

    d(ContentLoadingProgressBar contentLoadingProgressBar) {
        this.f1301a = contentLoadingProgressBar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ContentLoadingProgressBar contentLoadingProgressBar = this.f1301a;
        contentLoadingProgressBar.mPostedHide = false;
        contentLoadingProgressBar.mStartTime = -1L;
        contentLoadingProgressBar.setVisibility(8);
    }
}
