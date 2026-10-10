package me.tatarka.bindingcollectionadapter2.collections;

import androidx.databinding.ObservableList;
import androidx.databinding.g;
import java.util.AbstractList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class DiffObservableList<T> extends AbstractList<T> implements ObservableList<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<T> f22978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f22979b;

    @Override // androidx.databinding.ObservableList
    public void addOnListChangedCallback(ObservableList.a<? extends ObservableList<T>> aVar) {
        this.f22979b.a(aVar);
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i) {
        return this.f22978a.get(i);
    }

    @Override // androidx.databinding.ObservableList
    public void removeOnListChangedCallback(ObservableList.a<? extends ObservableList<T>> aVar) {
        this.f22979b.b(aVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f22978a.size();
    }
}
