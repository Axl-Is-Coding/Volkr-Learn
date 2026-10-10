package com.bumptech.glide.load.engine;

import com.bumptech.glide.e.a.d;
import com.bumptech.glide.load.engine.r;

/* JADX INFO: compiled from: Engine.java */
/* JADX INFO: loaded from: classes.dex */
class s implements d.a<EngineJob<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ r.b f4607a;

    s(r.b bVar) {
        this.f4607a = bVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.e.a.d.a
    public EngineJob<?> create() {
        r.b bVar = this.f4607a;
        return new EngineJob<>(bVar.f4596a, bVar.f4597b, bVar.f4598c, bVar.f4599d, bVar.f4600e, bVar.f4601f, bVar.g);
    }
}
