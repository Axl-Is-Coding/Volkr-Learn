package androidx.lifecycle;

/* JADX INFO: compiled from: LiveData.java */
/* JADX INFO: loaded from: classes.dex */
class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ LiveData f1606a;

    k(LiveData liveData) {
        this.f1606a = liveData;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        synchronized (this.f1606a.f1581b) {
            obj = this.f1606a.f1585f;
            this.f1606a.f1585f = LiveData.f1580a;
        }
        this.f1606a.b(obj);
    }
}
