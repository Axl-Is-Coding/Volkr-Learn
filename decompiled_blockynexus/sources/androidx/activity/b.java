package androidx.activity;

/* JADX INFO: compiled from: ComponentActivity.java */
/* JADX INFO: loaded from: classes.dex */
class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ComponentActivity f187a;

    b(ComponentActivity componentActivity) {
        this.f187a = componentActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        super/*android.app.Activity*/.onBackPressed();
    }
}
