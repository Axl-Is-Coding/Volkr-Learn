package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.qa, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ContentMainNewUserGuideBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0695qa extends AbstractC0684pa {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ViewDataBinding.b f8715f = null;
    private static final SparseIntArray g = new SparseIntArray();
    private final ConstraintLayout h;
    private long i;

    static {
        g.put(R.id.v, 1);
        g.put(R.id.v1, 2);
        g.put(R.id.ll_guide, 3);
        g.put(R.id.v_guide, 4);
        g.put(R.id.iv_hand, 5);
    }

    public C0695qa(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 6, f8715f, g));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            long j = this.i;
            this.i = 0L;
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
            this.i = 1L;
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

    private C0695qa(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (ImageView) objArr[5], (LinearLayout) objArr[3], (View) objArr[1], (View) objArr[2], (View) objArr[4]);
        this.i = -1L;
        this.h = (ConstraintLayout) objArr[0];
        this.h.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
