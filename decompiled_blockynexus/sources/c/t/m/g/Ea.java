package c.t.m.g;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
class Ea extends Thread {
    Ea(String str) {
        super(str);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            Ga.a();
            Ja.a();
            Ha.a();
        } catch (Throwable unused) {
        }
    }
}
