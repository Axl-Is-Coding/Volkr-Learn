package com.bumptech.glide.load.engine.b;

import android.annotation.SuppressLint;
import com.bumptech.glide.load.engine.C;
import com.bumptech.glide.load.engine.b.i;

/* JADX INFO: compiled from: LruResourceCache.java */
/* JADX INFO: loaded from: classes.dex */
public class h extends com.bumptech.glide.e.i<com.bumptech.glide.load.h, C<?>> implements i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private i.a f4519e;

    public h(long j) {
        super(j);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.engine.b.i
    public /* bridge */ /* synthetic */ C a(com.bumptech.glide.load.h hVar, C c2) {
        return (C) super.b(hVar, c2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.e.i
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(com.bumptech.glide.load.h hVar, C<?> c2) {
        i.a aVar = this.f4519e;
        if (aVar == null || c2 == null) {
            return;
        }
        aVar.a(c2);
    }

    @Override // com.bumptech.glide.load.engine.b.i
    public /* bridge */ /* synthetic */ C a(com.bumptech.glide.load.h hVar) {
        return (C) super.c(hVar);
    }

    @Override // com.bumptech.glide.load.engine.b.i
    public void a(i.a aVar) {
        this.f4519e = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.e.i
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int b(C<?> c2) {
        if (c2 == null) {
            return super.b(null);
        }
        return c2.getSize();
    }

    @Override // com.bumptech.glide.load.engine.b.i
    @SuppressLint({"InlinedApi"})
    public void a(int i) {
        if (i >= 40) {
            a();
        } else if (i >= 20 || i == 15) {
            a(b() / 2);
        }
    }
}
