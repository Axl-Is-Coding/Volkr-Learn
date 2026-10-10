package androidx.coordinatorlayout.widget;

import a.a.i;
import androidx.core.f.e;
import androidx.core.f.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: DirectedAcyclicGraph.java */
/* JADX INFO: loaded from: classes.dex */
public final class c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e<ArrayList<T>> f907a = new f(10);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final i<T, ArrayList<T>> f908b = new i<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayList<T> f909c = new ArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashSet<T> f910d = new HashSet<>();

    public void a(T t) {
        if (this.f908b.containsKey(t)) {
            return;
        }
        this.f908b.put(t, null);
    }

    public boolean b(T t) {
        return this.f908b.containsKey(t);
    }

    public List c(T t) {
        return this.f908b.get(t);
    }

    public List<T> d(T t) {
        int size = this.f908b.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            ArrayList<T> arrayListD = this.f908b.d(i);
            if (arrayListD != null && arrayListD.contains(t)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f908b.b(i));
            }
        }
        return arrayList;
    }

    public boolean e(T t) {
        int size = this.f908b.size();
        for (int i = 0; i < size; i++) {
            ArrayList<T> arrayListD = this.f908b.d(i);
            if (arrayListD != null && arrayListD.contains(t)) {
                return true;
            }
        }
        return false;
    }

    private ArrayList<T> c() {
        ArrayList<T> arrayListA = this.f907a.a();
        return arrayListA == null ? new ArrayList<>() : arrayListA;
    }

    public ArrayList<T> b() {
        this.f909c.clear();
        this.f910d.clear();
        int size = this.f908b.size();
        for (int i = 0; i < size; i++) {
            a(this.f908b.b(i), this.f909c, this.f910d);
        }
        return this.f909c;
    }

    public void a(T t, T t2) {
        if (this.f908b.containsKey(t) && this.f908b.containsKey(t2)) {
            ArrayList<T> arrayListC = this.f908b.get(t);
            if (arrayListC == null) {
                arrayListC = c();
                this.f908b.put(t, arrayListC);
            }
            arrayListC.add(t2);
            return;
        }
        throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
    }

    public void a() {
        int size = this.f908b.size();
        for (int i = 0; i < size; i++) {
            ArrayList<T> arrayListD = this.f908b.d(i);
            if (arrayListD != null) {
                a((ArrayList) arrayListD);
            }
        }
        this.f908b.clear();
    }

    private void a(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (arrayList.contains(t)) {
            return;
        }
        if (!hashSet.contains(t)) {
            hashSet.add(t);
            ArrayList<T> arrayList2 = this.f908b.get(t);
            if (arrayList2 != null) {
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    a(arrayList2.get(i), arrayList, hashSet);
                }
            }
            hashSet.remove(t);
            arrayList.add(t);
            return;
        }
        throw new RuntimeException("This graph contains cyclic dependencies");
    }

    private void a(ArrayList<T> arrayList) {
        arrayList.clear();
        this.f907a.a(arrayList);
    }
}
