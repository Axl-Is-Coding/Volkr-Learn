package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;

/* JADX INFO: compiled from: DialogShareBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Cc extends Bc {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ViewDataBinding.b f7341e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final SparseIntArray f7342f = new SparseIntArray();
    private final LinearLayout g;
    private long h;

    static {
        f7342f.put(R.id.ivGoogle, 1);
        f7342f.put(R.id.ivTwitter, 2);
        f7342f.put(R.id.ivFacebook, 3);
        f7342f.put(R.id.tvCancel, 4);
    }

    public Cc(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 5, f7341e, f7342f));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            long j = this.h;
            this.h = 0L;
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
            this.h = 1L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        return true;
    }

    private Cc(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (ImageView) objArr[3], (ImageView) objArr[1], (ImageView) objArr[2], (TextView) objArr[4]);
        this.h = -1L;
        this.g = (LinearLayout) objArr[0];
        this.g.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
