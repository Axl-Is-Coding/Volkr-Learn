package com.bumptech.glide.e.a;

import com.bumptech.glide.e.a.d;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: FactoryPools.java */
/* JADX INFO: loaded from: classes.dex */
class b<T> implements d.a<List<T>> {
    b() {
    }

    @Override // com.bumptech.glide.e.a.d.a
    public List<T> create() {
        return new ArrayList();
    }
}
