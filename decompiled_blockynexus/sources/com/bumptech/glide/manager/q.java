package com.bumptech.glide.manager;

import com.bumptech.glide.request.target.Target;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: TargetTracker.java */
/* JADX INFO: loaded from: classes.dex */
public final class q implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<Target<?>> f4774a = Collections.newSetFromMap(new WeakHashMap());

    public void a(Target<?> target) {
        this.f4774a.add(target);
    }

    public void b(Target<?> target) {
        this.f4774a.remove(target);
    }

    @Override // com.bumptech.glide.manager.j
    public void onDestroy() {
        Iterator it = com.bumptech.glide.e.n.a(this.f4774a).iterator();
        while (it.hasNext()) {
            ((Target) it.next()).onDestroy();
        }
    }

    @Override // com.bumptech.glide.manager.j
    public void onStart() {
        Iterator it = com.bumptech.glide.e.n.a(this.f4774a).iterator();
        while (it.hasNext()) {
            ((Target) it.next()).onStart();
        }
    }

    @Override // com.bumptech.glide.manager.j
    public void onStop() {
        Iterator it = com.bumptech.glide.e.n.a(this.f4774a).iterator();
        while (it.hasNext()) {
            ((Target) it.next()).onStop();
        }
    }

    public void a() {
        this.f4774a.clear();
    }

    public List<Target<?>> b() {
        return com.bumptech.glide.e.n.a(this.f4774a);
    }
}
