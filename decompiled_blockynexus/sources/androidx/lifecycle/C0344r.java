package androidx.lifecycle;

import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: renamed from: androidx.lifecycle.r, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ViewModelStore.java */
/* JADX INFO: loaded from: classes.dex */
public class C0344r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HashMap<String, p> f1612a = new HashMap<>();

    final void a(String str, p pVar) {
        p pVarPut = this.f1612a.put(str, pVar);
        if (pVarPut != null) {
            pVarPut.b();
        }
    }

    final p a(String str) {
        return this.f1612a.get(str);
    }

    public final void a() {
        Iterator<p> it = this.f1612a.values().iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.f1612a.clear();
    }
}
