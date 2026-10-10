package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.widget.DisScrollRecylerView;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.greendao.entity.Game;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.ea, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ContentCategoryGuessYouLikeBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0564ea extends AbstractC0553da {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ViewDataBinding.b f8285d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SparseIntArray f8286e = new SparseIntArray();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final LinearLayout f8287f;
    private long g;

    static {
        f8286e.put(R.id.img, 2);
    }

    public C0564ea(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 3, f8285d, f8286e));
    }

    public void a(com.disabngo.blockynexus.view.fragment.main.V v) {
        updateRegistration(1, v);
        this.f8252c = v;
        synchronized (this) {
            this.g |= 2;
        }
        notifyPropertyChanged(505);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        me.tatarka.bindingcollectionadapter2.g<ListItemViewModel<Game>> gVar;
        ObservableList<ListItemViewModel<Game>> observableList;
        me.tatarka.bindingcollectionadapter2.g<ListItemViewModel<Game>> gVar2;
        synchronized (this) {
            j = this.g;
            this.g = 0L;
        }
        com.disabngo.blockynexus.view.fragment.main.V v = this.f8252c;
        long j2 = 7 & j;
        ObservableList<ListItemViewModel<Game>> observableList2 = null;
        if (j2 != 0) {
            if (v != null) {
                me.tatarka.bindingcollectionadapter2.g<ListItemViewModel<Game>> gVar3 = v.f11767b;
                observableList2 = v.f11766a;
                gVar2 = gVar3;
            } else {
                gVar2 = null;
            }
            updateRegistration(0, observableList2);
            gVar = gVar2;
            observableList = observableList2;
        } else {
            gVar = null;
            observableList = null;
        }
        if ((j & 4) != 0) {
            me.tatarka.bindingcollectionadapter2.e.a(this.f8251b, me.tatarka.bindingcollectionadapter2.k.a(3));
        }
        if (j2 != 0) {
            me.tatarka.bindingcollectionadapter2.e.a(this.f8251b, gVar, observableList, null, null, null);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.g != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.g = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((ObservableList<ListItemViewModel<Game>>) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return a((com.disabngo.blockynexus.view.fragment.main.V) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (505 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.fragment.main.V) obj);
        return true;
    }

    private C0564ea(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2, (ImageView) objArr[2], (DisScrollRecylerView) objArr[1]);
        this.g = -1L;
        this.f8287f = (LinearLayout) objArr[0];
        this.f8287f.setTag(null);
        this.f8251b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableList<ListItemViewModel<Game>> observableList, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.g |= 1;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.view.fragment.main.V v, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.g |= 2;
        }
        return true;
    }
}
