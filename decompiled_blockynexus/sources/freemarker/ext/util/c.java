package freemarker.ext.util;

import freemarker.ext.util.IdentityHashMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: IdentityHashMap.java */
/* JADX INFO: loaded from: classes5.dex */
class c extends AbstractSet {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ IdentityHashMap f21701a;

    c(IdentityHashMap identityHashMap) {
        this.f21701a = identityHashMap;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f21701a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        IdentityHashMap.b[] bVarArr = this.f21701a.table;
        int iIdentityHashCode = key == null ? 0 : System.identityHashCode(key);
        for (IdentityHashMap.b bVar = bVarArr[(Integer.MAX_VALUE & iIdentityHashCode) % bVarArr.length]; bVar != null; bVar = bVar.f21692d) {
            if (bVar.f21689a == iIdentityHashCode && bVar.equals(entry)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return this.f21701a.getHashIterator(2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        IdentityHashMap.b[] bVarArr = this.f21701a.table;
        int iIdentityHashCode = key == null ? 0 : System.identityHashCode(key);
        int length = (Integer.MAX_VALUE & iIdentityHashCode) % bVarArr.length;
        IdentityHashMap.b bVar = null;
        for (IdentityHashMap.b bVar2 = bVarArr[length]; bVar2 != null; bVar2 = bVar2.f21692d) {
            if (bVar2.f21689a == iIdentityHashCode && bVar2.equals(entry)) {
                IdentityHashMap.access$308(this.f21701a);
                if (bVar != null) {
                    bVar.f21692d = bVar2.f21692d;
                } else {
                    bVarArr[length] = bVar2.f21692d;
                }
                IdentityHashMap.access$110(this.f21701a);
                bVar2.f21691c = null;
                return true;
            }
            bVar = bVar2;
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f21701a.count;
    }
}
