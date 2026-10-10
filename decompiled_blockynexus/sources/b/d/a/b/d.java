package b.d.a.b;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: JuliLogger.java */
/* JADX INFO: loaded from: classes2.dex */
public class d extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Logger f2523a;

    public d(String str) {
        this.f2523a = Logger.getLogger(str);
    }

    @Override // b.d.a.b.g
    public void a(String str) {
        this.f2523a.log(Level.FINE, str);
    }
}
