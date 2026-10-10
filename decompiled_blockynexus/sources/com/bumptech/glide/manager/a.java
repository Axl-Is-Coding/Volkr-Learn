package com.bumptech.glide.manager;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: ActivityFragmentLifecycle.java */
/* JADX INFO: loaded from: classes.dex */
class a implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<j> f4749a = Collections.newSetFromMap(new WeakHashMap());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f4750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f4751c;

    a() {
    }

    @Override // com.bumptech.glide.manager.i
    public void a(j jVar) {
        this.f4749a.remove(jVar);
    }

    @Override // com.bumptech.glide.manager.i
    public void b(j jVar) {
        this.f4749a.add(jVar);
        if (this.f4751c) {
            jVar.onDestroy();
        } else if (this.f4750b) {
            jVar.onStart();
        } else {
            jVar.onStop();
        }
    }

    void c() {
        this.f4750b = false;
        Iterator it = com.bumptech.glide.e.n.a(this.f4749a).iterator();
        while (it.hasNext()) {
            ((j) it.next()).onStop();
        }
    }

    void a() {
        this.f4751c = true;
        Iterator it = com.bumptech.glide.e.n.a(this.f4749a).iterator();
        while (it.hasNext()) {
            ((j) it.next()).onDestroy();
        }
    }

    void b() {
        this.f4750b = true;
        Iterator it = com.bumptech.glide.e.n.a(this.f4749a).iterator();
        while (it.hasNext()) {
            ((j) it.next()).onStart();
        }
    }
}
