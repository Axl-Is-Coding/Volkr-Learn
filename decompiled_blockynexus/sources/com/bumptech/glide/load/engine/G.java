package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.a.u;
import com.bumptech.glide.load.data.d;

/* JADX INFO: compiled from: SourceGenerator.java */
/* JADX INFO: loaded from: classes.dex */
class G implements d.a<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ u.a f4455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ H f4456b;

    G(H h, u.a aVar) {
        this.f4456b = h;
        this.f4455a = aVar;
    }

    @Override // com.bumptech.glide.load.data.d.a
    public void a(Object obj) {
        if (this.f4456b.a(this.f4455a)) {
            this.f4456b.a(this.f4455a, obj);
        }
    }

    @Override // com.bumptech.glide.load.data.d.a
    public void a(Exception exc) {
        if (this.f4456b.a(this.f4455a)) {
            this.f4456b.a(this.f4455a, exc);
        }
    }
}
