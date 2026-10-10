package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.binding.adapter.RecyclerViewBindingAdapters;
import com.sandboxol.greendao.entity.Game;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.ga, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ContentCategoryLatelyPlayBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0586ga extends AbstractC0575fa {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ViewDataBinding.b f8354d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SparseIntArray f8355e = new SparseIntArray();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final LinearLayout f8356f;
    private final View g;
    private final RelativeLayout h;
    private long i;

    static {
        f8355e.put(R.id.img, 4);
    }

    public C0586ga(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 5, f8354d, f8355e));
    }

    public void a(com.disabngo.blockynexus.view.fragment.main.W w) {
        updateRegistration(1, w);
        this.f8323c = w;
        synchronized (this) {
            this.i |= 2;
        }
        notifyPropertyChanged(529);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        int i2;
        me.tatarka.bindingcollectionadapter2.g<ListItemViewModel<Game>> gVar;
        ObservableList observableList;
        ObservableList observableList2;
        me.tatarka.bindingcollectionadapter2.g<ListItemViewModel<Game>> gVar2;
        long j2;
        long j3;
        synchronized (this) {
            j = this.i;
            this.i = 0L;
        }
        com.disabngo.blockynexus.view.fragment.main.W w = this.f8323c;
        if ((15 & j) != 0) {
            if ((j & 11) != 0) {
                if (w != null) {
                    observableList2 = w.f11766a;
                    gVar2 = w.f11767b;
                } else {
                    observableList2 = null;
                    gVar2 = null;
                }
                updateRegistration(0, observableList2);
            } else {
                observableList2 = null;
                gVar2 = null;
            }
            long j4 = j & 14;
            if (j4 != 0) {
                ObservableField<Boolean> observableField = w != null ? w.f11768c : null;
                updateRegistration(2, observableField);
                boolean zSafeUnbox = ViewDataBinding.safeUnbox(observableField != null ? observableField.get() : null);
                if (j4 != 0) {
                    if (zSafeUnbox) {
                        j2 = j | 32;
                        j3 = 128;
                    } else {
                        j2 = j | 16;
                        j3 = 64;
                    }
                    j = j2 | j3;
                }
                i2 = zSafeUnbox ? 8 : 0;
                i = zSafeUnbox ? 0 : 8;
                observableList = observableList2;
                gVar = gVar2;
            } else {
                observableList = observableList2;
                gVar = gVar2;
                i = 0;
                i2 = 0;
            }
        } else {
            i = 0;
            i2 = 0;
            gVar = null;
            observableList = null;
        }
        if ((j & 14) != 0) {
            this.g.setVisibility(i2);
            this.h.setVisibility(i);
            this.f8322b.setVisibility(i);
        }
        if ((8 & j) != 0) {
            me.tatarka.bindingcollectionadapter2.e.a(this.f8322b, me.tatarka.bindingcollectionadapter2.k.a(0, false));
            RecyclerViewBindingAdapters.nestedScrollingEnabled(this.f8322b, false);
        }
        if ((j & 11) != 0) {
            me.tatarka.bindingcollectionadapter2.e.a(this.f8322b, gVar, observableList, null, null, null);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.i != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.i = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((ObservableList<ListItemViewModel<Game>>) obj, i2);
        }
        if (i == 1) {
            return a((com.disabngo.blockynexus.view.fragment.main.W) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return a((ObservableField<Boolean>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (529 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.fragment.main.W) obj);
        return true;
    }

    private C0586ga(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 3, (ImageView) objArr[4], (RecyclerView) objArr[3]);
        this.i = -1L;
        this.f8356f = (LinearLayout) objArr[0];
        this.f8356f.setTag(null);
        this.g = (View) objArr[1];
        this.g.setTag(null);
        this.h = (RelativeLayout) objArr[2];
        this.h.setTag(null);
        this.f8322b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableList<ListItemViewModel<Game>> observableList, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.i |= 1;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.view.fragment.main.W w, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.i |= 2;
        }
        return true;
    }

    private boolean a(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.i |= 4;
        }
        return true;
    }
}
