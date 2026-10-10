package me.tatarka.bindingcollectionadapter2.collections;

import androidx.databinding.ObservableList;
import androidx.databinding.g;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class MergeObservableList<T> extends AbstractList<T> implements ObservableList<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<List<? extends T>> f22980a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MergeObservableList<T>.a f22981b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final g f22982c = new g();

    @Override // androidx.databinding.ObservableList
    public void addOnListChangedCallback(ObservableList.a<? extends ObservableList<T>> aVar) {
        this.f22982c.a(aVar);
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException();
        }
        int size = this.f22980a.size();
        int size2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            List<? extends T> list = this.f22980a.get(i2);
            int i3 = i - size2;
            if (i3 < list.size()) {
                return list.get(i3);
            }
            size2 += list.size();
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // androidx.databinding.ObservableList
    public void removeOnListChangedCallback(ObservableList.a<? extends ObservableList<T>> aVar) {
        this.f22982c.b(aVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        int size = this.f22980a.size();
        int size2 = 0;
        for (int i = 0; i < size; i++) {
            size2 += this.f22980a.get(i).size();
        }
        return size2;
    }

    class a extends ObservableList.a {
        a() {
        }

        @Override // androidx.databinding.ObservableList.a
        public void a(ObservableList observableList) {
            ((AbstractList) MergeObservableList.this).modCount++;
            MergeObservableList.this.f22982c.a((ObservableList) MergeObservableList.this);
        }

        @Override // androidx.databinding.ObservableList.a
        public void b(ObservableList observableList, int i, int i2) {
            ((AbstractList) MergeObservableList.this).modCount++;
            int size = MergeObservableList.this.f22980a.size();
            int size2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                List list = (List) MergeObservableList.this.f22980a.get(i3);
                if (list == observableList) {
                    MergeObservableList.this.f22982c.b(MergeObservableList.this, size2 + i, i2);
                    return;
                }
                size2 += list.size();
            }
        }

        @Override // androidx.databinding.ObservableList.a
        public void c(ObservableList observableList, int i, int i2) {
            ((AbstractList) MergeObservableList.this).modCount++;
            int size = MergeObservableList.this.f22980a.size();
            int size2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                List list = (List) MergeObservableList.this.f22980a.get(i3);
                if (list == observableList) {
                    MergeObservableList.this.f22982c.c(MergeObservableList.this, size2 + i, i2);
                    return;
                }
                size2 += list.size();
            }
        }

        @Override // androidx.databinding.ObservableList.a
        public void a(ObservableList observableList, int i, int i2) {
            int size = MergeObservableList.this.f22980a.size();
            int size2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                List list = (List) MergeObservableList.this.f22980a.get(i3);
                if (list == observableList) {
                    MergeObservableList.this.f22982c.a(MergeObservableList.this, size2 + i, i2);
                    return;
                }
                size2 += list.size();
            }
        }

        @Override // androidx.databinding.ObservableList.a
        public void a(ObservableList observableList, int i, int i2, int i3) {
            int size = MergeObservableList.this.f22980a.size();
            int size2 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                List list = (List) MergeObservableList.this.f22980a.get(i4);
                if (list == observableList) {
                    MergeObservableList.this.f22982c.a(MergeObservableList.this, i + size2, size2 + i2, i3);
                    return;
                }
                size2 += list.size();
            }
        }
    }
}
