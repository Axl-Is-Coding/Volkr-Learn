package androidx.transition;

import android.os.IBinder;

/* JADX INFO: compiled from: WindowIdApi14.java */
/* JADX INFO: loaded from: classes.dex */
class Ea implements Ga {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IBinder f2161a;

    Ea(IBinder iBinder) {
        this.f2161a = iBinder;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Ea) && ((Ea) obj).f2161a.equals(this.f2161a);
    }

    public int hashCode() {
        return this.f2161a.hashCode();
    }
}
