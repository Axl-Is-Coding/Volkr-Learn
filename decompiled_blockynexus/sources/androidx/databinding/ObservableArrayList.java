package androidx.databinding;

import androidx.databinding.ObservableList;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public class ObservableArrayList<T> extends ArrayList<T> implements ObservableList<T> {
    private transient g mListeners = new g();

    private void notifyAdd(int i, int i2) {
        g gVar = this.mListeners;
        if (gVar != null) {
            gVar.b(this, i, i2);
        }
    }

    private void notifyRemove(int i, int i2) {
        g gVar = this.mListeners;
        if (gVar != null) {
            gVar.c(this, i, i2);
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(T t) {
        super.add(t);
        notifyAdd(size() - 1, 1);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends T> collection) {
        int size = size();
        boolean zAddAll = super.addAll(collection);
        if (zAddAll) {
            notifyAdd(size, size() - size);
        }
        return zAddAll;
    }

    @Override // androidx.databinding.ObservableList
    public void addOnListChangedCallback(ObservableList.a aVar) {
        if (this.mListeners == null) {
            this.mListeners = new g();
        }
        this.mListeners.a(aVar);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        int size = size();
        super.clear();
        if (size != 0) {
            notifyRemove(0, size);
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public T remove(int i) {
        T t = (T) super.remove(i);
        notifyRemove(i, 1);
        return t;
    }

    @Override // androidx.databinding.ObservableList
    public void removeOnListChangedCallback(ObservableList.a aVar) {
        g gVar = this.mListeners;
        if (gVar != null) {
            gVar.b(aVar);
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractList
    protected void removeRange(int i, int i2) {
        super.removeRange(i, i2);
        notifyRemove(i, i2 - i);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public T set(int i, T t) {
        T t2 = (T) super.set(i, t);
        g gVar = this.mListeners;
        if (gVar != null) {
            gVar.a(this, i, 1);
        }
        return t2;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public void add(int i, T t) {
        super.add(i, t);
        notifyAdd(i, 1);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf < 0) {
            return false;
        }
        remove(iIndexOf);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection<? extends T> collection) {
        boolean zAddAll = super.addAll(i, collection);
        if (zAddAll) {
            notifyAdd(i, collection.size());
        }
        return zAddAll;
    }
}
