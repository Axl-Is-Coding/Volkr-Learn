package com.bumptech.glide.load.engine;

import com.bumptech.glide.e.a.d;
import com.bumptech.glide.load.engine.r;

/* JADX INFO: compiled from: Engine.java */
/* JADX INFO: loaded from: classes.dex */
class q implements d.a<DecodeJob<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ r.a f4586a;

    q(r.a aVar) {
        this.f4586a = aVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.e.a.d.a
    public DecodeJob<?> create() {
        r.a aVar = this.f4586a;
        return new DecodeJob<>(aVar.f4593a, aVar.f4594b);
    }
}
