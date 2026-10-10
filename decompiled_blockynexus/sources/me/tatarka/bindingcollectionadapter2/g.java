package me.tatarka.bindingcollectionadapter2;

import android.util.SparseArray;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: compiled from: ItemBinding.java */
/* JADX INFO: loaded from: classes5.dex */
public final class g<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l<T> f22991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f22992b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f22993c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private SparseArray<Object> f22994d;

    private g(l<T> lVar) {
        this.f22991a = lVar;
    }

    public static <T> g<T> a(l<T> lVar) {
        if (lVar != null) {
            return new g<>(lVar);
        }
        throw new NullPointerException("onItemBind == null");
    }

    public final int b() {
        return this.f22992b;
    }

    public final g<T> a(int i, int i2) {
        this.f22992b = i;
        this.f22993c = i2;
        return this;
    }

    public final int a() {
        return this.f22993c;
    }

    public void a(int i, T t) {
        l<T> lVar = this.f22991a;
        if (lVar != null) {
            this.f22992b = -1;
            this.f22993c = 0;
            lVar.a(this, i, t);
            if (this.f22992b != -1) {
                if (this.f22993c == 0) {
                    throw new IllegalStateException("layoutRes not set in onItemBind()");
                }
                return;
            }
            throw new IllegalStateException("variableId not set in onItemBind()");
        }
    }

    public boolean a(ViewDataBinding viewDataBinding, T t) {
        int i = this.f22992b;
        if (i == 0) {
            return false;
        }
        if (viewDataBinding.setVariable(i, t)) {
            SparseArray<Object> sparseArray = this.f22994d;
            if (sparseArray == null) {
                return true;
            }
            int size = sparseArray.size();
            for (int i2 = 0; i2 < size; i2++) {
                int iKeyAt = this.f22994d.keyAt(i2);
                Object objValueAt = this.f22994d.valueAt(i2);
                if (iKeyAt != 0) {
                    viewDataBinding.setVariable(iKeyAt, objValueAt);
                }
            }
            return true;
        }
        m.a(viewDataBinding, this.f22992b, this.f22993c);
        throw null;
    }
}
