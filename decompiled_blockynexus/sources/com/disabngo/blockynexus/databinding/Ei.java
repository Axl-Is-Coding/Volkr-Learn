package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;

/* JADX INFO: compiled from: ItemRankDetailTitleBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Ei extends Di {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ViewDataBinding.b f7434d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SparseIntArray f7435e = new SparseIntArray();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ConstraintLayout f7436f;
    private final TextView g;
    private long h;

    static {
        f7435e.put(R.id.ll_item, 2);
    }

    public Ei(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 3, f7434d, f7435e));
    }

    public void a(com.disabngo.blockynexus.e.b.W.b bVar) {
        this.f7402c = bVar;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.h;
            this.h = 0L;
        }
        long j2 = j & 6;
        String strA = j2 != 0 ? com.disabngo.blockynexus.d.G.a(this.f7401b) : null;
        if (j2 != 0) {
            androidx.databinding.a.e.a(this.g, strA);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.h != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.h = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.disabngo.blockynexus.e.b.W.b) obj, i2);
    }

    @Override // com.disabngo.blockynexus.databinding.Di
    public void setType(String str) {
        this.f7401b = str;
        synchronized (this) {
            this.h |= 2;
        }
        notifyPropertyChanged(382);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (382 == i) {
            setType((String) obj);
        } else {
            if (361 != i) {
                return false;
            }
            a((com.disabngo.blockynexus.e.b.W.b) obj);
        }
        return true;
    }

    private Ei(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (LinearLayout) objArr[2]);
        this.h = -1L;
        this.f7436f = (ConstraintLayout) objArr[0];
        this.f7436f.setTag(null);
        this.g = (TextView) objArr[1];
        this.g.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.W.b bVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.h |= 1;
        }
        return true;
    }
}
