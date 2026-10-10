package com.google.android.datatransport.runtime.backends;

import android.content.Context;

/* JADX INFO: compiled from: CreationContextFactory.java */
/* JADX INFO: loaded from: classes.dex */
class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f12824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.android.datatransport.runtime.e.a f12825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.google.android.datatransport.runtime.e.a f12826c;

    i(Context context, com.google.android.datatransport.runtime.e.a aVar, com.google.android.datatransport.runtime.e.a aVar2) {
        this.f12824a = context;
        this.f12825b = aVar;
        this.f12826c = aVar2;
    }

    h a(String str) {
        return h.a(this.f12824a, this.f12825b, this.f12826c, str);
    }
}
