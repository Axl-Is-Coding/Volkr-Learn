package freemarker.ext.beans;

import java.util.AbstractList;

/* JADX INFO: compiled from: NonPrimitiveArrayBackedReadOnlyList.java */
/* JADX INFO: loaded from: classes5.dex */
class T extends AbstractList {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object[] f21557a;

    T(Object[] objArr) {
        this.f21557a = objArr;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i) {
        return this.f21557a[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f21557a.length;
    }
}
