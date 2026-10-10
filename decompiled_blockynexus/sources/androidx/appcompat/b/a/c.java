package androidx.appcompat.b.a;

/* JADX INFO: compiled from: DrawableContainer.java */
/* JADX INFO: loaded from: classes.dex */
class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ d f340a;

    c(d dVar) {
        this.f340a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f340a.a(true);
        this.f340a.invalidateSelf();
    }
}
