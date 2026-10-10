package com.bumptech.glide.manager;

import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: RequestTracker.java */
/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<com.bumptech.glide.request.d> f4764a = Collections.newSetFromMap(new WeakHashMap());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<com.bumptech.glide.request.d> f4765b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f4766c;

    public boolean a(com.bumptech.glide.request.d dVar) {
        boolean z = true;
        if (dVar == null) {
            return true;
        }
        boolean zRemove = this.f4764a.remove(dVar);
        if (!this.f4765b.remove(dVar) && !zRemove) {
            z = false;
        }
        if (z) {
            dVar.clear();
        }
        return z;
    }

    public void b(com.bumptech.glide.request.d dVar) {
        this.f4764a.add(dVar);
        if (!this.f4766c) {
            dVar.begin();
            return;
        }
        dVar.clear();
        if (Log.isLoggable("RequestTracker", 2)) {
            Log.v("RequestTracker", "Paused, delaying request");
        }
        this.f4765b.add(dVar);
    }

    public void c() {
        this.f4766c = true;
        for (com.bumptech.glide.request.d dVar : com.bumptech.glide.e.n.a(this.f4764a)) {
            if (dVar.isRunning() || dVar.isComplete()) {
                dVar.clear();
                this.f4765b.add(dVar);
            }
        }
    }

    public void d() {
        this.f4766c = true;
        for (com.bumptech.glide.request.d dVar : com.bumptech.glide.e.n.a(this.f4764a)) {
            if (dVar.isRunning()) {
                dVar.pause();
                this.f4765b.add(dVar);
            }
        }
    }

    public void e() {
        for (com.bumptech.glide.request.d dVar : com.bumptech.glide.e.n.a(this.f4764a)) {
            if (!dVar.isComplete() && !dVar.b()) {
                dVar.clear();
                if (this.f4766c) {
                    this.f4765b.add(dVar);
                } else {
                    dVar.begin();
                }
            }
        }
    }

    public void f() {
        this.f4766c = false;
        for (com.bumptech.glide.request.d dVar : com.bumptech.glide.e.n.a(this.f4764a)) {
            if (!dVar.isComplete() && !dVar.isRunning()) {
                dVar.begin();
            }
        }
        this.f4765b.clear();
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.f4764a.size() + ", isPaused=" + this.f4766c + "}";
    }

    public void a() {
        Iterator it = com.bumptech.glide.e.n.a(this.f4764a).iterator();
        while (it.hasNext()) {
            a((com.bumptech.glide.request.d) it.next());
        }
        this.f4765b.clear();
    }

    public boolean b() {
        return this.f4766c;
    }
}
