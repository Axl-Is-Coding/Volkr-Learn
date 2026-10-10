package com.alibaba.sdk.android.feedback.xblink.a;

import android.util.LruCache;

/* JADX INFO: loaded from: classes.dex */
class c extends LruCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f3759a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    c(b bVar, int i) {
        super(i);
        this.f3759a = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.util.LruCache
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int sizeOf(String str, d dVar) {
        return ((int) dVar.f3760b) / 1024;
    }
}
