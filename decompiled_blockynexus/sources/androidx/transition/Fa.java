package androidx.transition;

import android.view.View;
import android.view.WindowId;

/* JADX INFO: compiled from: WindowIdApi18.java */
/* JADX INFO: loaded from: classes.dex */
class Fa implements Ga {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WindowId f2168a;

    Fa(View view) {
        this.f2168a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof Fa) && ((Fa) obj).f2168a.equals(this.f2168a);
    }

    public int hashCode() {
        return this.f2168a.hashCode();
    }
}
