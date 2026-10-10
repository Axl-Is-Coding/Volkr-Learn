package c.t.m.g;

import java.io.File;

/* JADX INFO: renamed from: c.t.m.g.ta, reason: case insensitive filesystem */
/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
final class RunnableC0466ta implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ File f3399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ String f3400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private /* synthetic */ C0469ua f3401c;

    RunnableC0466ta(C0469ua c0469ua, File file, String str) {
        this.f3401c = c0469ua;
        this.f3399a = file;
        this.f3400b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            byte[] bArrA = C0458qa.a(this.f3399a);
            if (!C0458qa.c(bArrA)) {
                C0481ya.i.a(this.f3400b, bArrA, new C0463sa(this));
                return;
            }
            this.f3399a.delete();
            StringBuilder sb = new StringBuilder("file ");
            sb.append(this.f3399a.getName());
            sb.append(" is empty, then delete.");
        } catch (Throwable th) {
            C0458qa.a("upload error,url=" + this.f3400b, th);
        }
    }
}
