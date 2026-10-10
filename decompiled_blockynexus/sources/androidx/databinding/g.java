package androidx.databinding;

import androidx.databinding.CallbackRegistry;
import androidx.databinding.ObservableList;
import androidx.databinding.g;

/* JADX INFO: compiled from: ListChangeRegistry.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends CallbackRegistry<ObservableList.a, ObservableList, a> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final androidx.core.f.g<a> f1353f = new androidx.core.f.g<>(10);
    private static final CallbackRegistry.NotifierCallback<ObservableList.a, ObservableList, a> g = new CallbackRegistry.NotifierCallback<ObservableList.a, ObservableList, a>() { // from class: androidx.databinding.ListChangeRegistry$1
        @Override // androidx.databinding.CallbackRegistry.NotifierCallback
        public void onNotifyCallback(ObservableList.a aVar, ObservableList observableList, int i, g.a aVar2) {
            if (i == 1) {
                aVar.a(observableList, aVar2.f1354a, aVar2.f1355b);
                return;
            }
            if (i == 2) {
                aVar.b(observableList, aVar2.f1354a, aVar2.f1355b);
                return;
            }
            if (i == 3) {
                aVar.a(observableList, aVar2.f1354a, aVar2.f1356c, aVar2.f1355b);
            } else if (i != 4) {
                aVar.a(observableList);
            } else {
                aVar.c(observableList, aVar2.f1354a, aVar2.f1355b);
            }
        }
    };

    /* JADX INFO: compiled from: ListChangeRegistry.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1354a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1355b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1356c;

        a() {
        }
    }

    public g() {
        super(g);
    }

    public void b(ObservableList observableList, int i, int i2) {
        a(observableList, 2, a(i, 0, i2));
    }

    public void c(ObservableList observableList, int i, int i2) {
        a(observableList, 4, a(i, 0, i2));
    }

    public void a(ObservableList observableList) {
        a(observableList, 0, (a) null);
    }

    public void a(ObservableList observableList, int i, int i2) {
        a(observableList, 1, a(i, 0, i2));
    }

    public void a(ObservableList observableList, int i, int i2, int i3) {
        a(observableList, 3, a(i, i2, i3));
    }

    private static a a(int i, int i2, int i3) {
        a aVarA = f1353f.a();
        if (aVarA == null) {
            aVarA = new a();
        }
        aVarA.f1354a = i;
        aVarA.f1356c = i2;
        aVarA.f1355b = i3;
        return aVarA;
    }

    @Override // androidx.databinding.CallbackRegistry
    public synchronized void a(ObservableList observableList, int i, a aVar) {
        super.a(observableList, i, aVar);
        if (aVar != null) {
            f1353f.a(aVar);
        }
    }
}
