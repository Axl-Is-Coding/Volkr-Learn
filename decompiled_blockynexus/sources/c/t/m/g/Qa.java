package c.t.m.g;

import java.util.Observable;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public abstract class Qa extends Observable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected volatile boolean f2992a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected byte[] f2993b = new byte[0];

    public abstract int a();

    public abstract void b();

    public abstract String c();

    public final boolean d() {
        boolean z;
        synchronized (this.f2993b) {
            z = this.f2992a;
        }
        return z;
    }
}
