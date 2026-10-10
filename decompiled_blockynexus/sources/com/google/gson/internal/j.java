package com.google.gson.internal;

import java.util.TreeSet;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: ConstructorConstructor.java */
/* JADX INFO: loaded from: classes2.dex */
class j<T> implements w<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ p f14222a;

    j(p pVar) {
        this.f14222a = pVar;
    }

    @Override // com.google.gson.internal.w
    public T a() {
        return (T) new TreeSet();
    }
}
