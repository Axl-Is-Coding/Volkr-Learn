package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;

/* JADX INFO: compiled from: DialogFriendBottomMenuBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Bb extends Ab {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ViewDataBinding.b f7300f = null;
    private static final SparseIntArray g = new SparseIntArray();
    private final LinearLayout h;
    private long i;

    static {
        g.put(R.id.vClick, 1);
        g.put(R.id.ll_dialog, 2);
        g.put(R.id.tv_modify_remarks, 3);
        g.put(R.id.tv_delete_friend, 4);
        g.put(R.id.tv_cancel, 5);
    }

    public Bb(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 6, f7300f, g));
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

    private Bb(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (LinearLayout) objArr[2], (TextView) objArr[5], (TextView) objArr[4], (TextView) objArr[3], (View) objArr[1]);
        this.i = -1L;
        this.h = (LinearLayout) objArr[0];
        this.h.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
