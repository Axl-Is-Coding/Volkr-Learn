package androidx.appcompat.widget;

/* JADX INFO: compiled from: SearchView.java */
/* JADX INFO: loaded from: classes.dex */
class S implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ SearchView f572a;

    S(SearchView searchView) {
        this.f572a = searchView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f572a.updateFocusedState();
    }
}
