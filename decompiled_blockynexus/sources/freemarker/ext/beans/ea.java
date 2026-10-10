package freemarker.ext.beans;

import java.lang.reflect.Array;
import java.util.AbstractList;

/* JADX INFO: compiled from: PrimtiveArrayBackedReadOnlyList.java */
/* JADX INFO: loaded from: classes5.dex */
class ea extends AbstractList {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f21583a;

    ea(Object obj) {
        this.f21583a = obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i) {
        return Array.get(this.f21583a, i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return Array.getLength(this.f21583a);
    }
}
