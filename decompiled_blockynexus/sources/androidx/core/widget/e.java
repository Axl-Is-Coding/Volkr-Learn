package androidx.core.widget;

/* JADX INFO: compiled from: ContentLoadingProgressBar.java */
/* JADX INFO: loaded from: classes.dex */
class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ContentLoadingProgressBar f1302a;

    e(ContentLoadingProgressBar contentLoadingProgressBar) {
        this.f1302a = contentLoadingProgressBar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ContentLoadingProgressBar contentLoadingProgressBar = this.f1302a;
        contentLoadingProgressBar.mPostedShow = false;
        if (contentLoadingProgressBar.mDismissed) {
            return;
        }
        contentLoadingProgressBar.mStartTime = System.currentTimeMillis();
        this.f1302a.setVisibility(0);
    }
}
