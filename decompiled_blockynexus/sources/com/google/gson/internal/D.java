package com.google.gson.internal;

/* JADX INFO: compiled from: UnsafeAllocator.java */
/* JADX INFO: loaded from: classes2.dex */
class D extends E {
    D() {
    }

    @Override // com.google.gson.internal.E
    public <T> T b(Class<T> cls) {
        throw new UnsupportedOperationException("Cannot allocate " + cls);
    }
}
