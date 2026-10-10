package com.sandboxol.decorate.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import cn.qqtheme.framework.widget.WheelView;
import com.sandboxol.common.binding.adapter.ImageViewBindingAdapters;
import com.sandboxol.decorate.R;
import com.sandboxol.decorate.entity.DressExpireInfo;

/* JADX INFO: compiled from: ItemDressExpiredBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class J extends I {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ViewDataBinding.b f17012d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SparseIntArray f17013e = new SparseIntArray();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ConstraintLayout f17014f;
    private long g;

    static {
        f17013e.put(R.id.view30, 2);
    }

    public J(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 3, f17012d, f17013e));
    }

    public void a(com.sandboxol.decorate.view.dialog.b.d dVar) {
        updateRegistration(0, dVar);
        this.f17011c = dVar;
        synchronized (this) {
            this.g |= 1;
        }
        notifyPropertyChanged(com.sandboxol.decorate.c.t);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.g;
            this.g = 0L;
        }
        com.sandboxol.decorate.view.dialog.b.d dVar = this.f17011c;
        long j2 = j & 7;
        String iconUrl = null;
        if (j2 != 0) {
            DressExpireInfo item = dVar != null ? dVar.getItem() : null;
            if (item != null) {
                iconUrl = item.getIconUrl();
            }
        }
        String str = iconUrl;
        if (j2 != 0) {
            ImageViewBindingAdapters.loadImage(this.f17009a, 0, str, 0, 0, false, false, false, false, WheelView.DividerConfig.FILL, null);
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
        if (i != 0) {
            return false;
        }
        return a((com.sandboxol.decorate.view.dialog.b.d) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.decorate.c.t != i) {
            return false;
        }
        a((com.sandboxol.decorate.view.dialog.b.d) obj);
        return true;
    }

    private J(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (ImageView) objArr[1], (View) objArr[2]);
        this.g = -1L;
        this.f17009a.setTag(null);
        this.f17014f = (ConstraintLayout) objArr[0];
        this.f17014f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.sandboxol.decorate.view.dialog.b.d dVar, int i) {
        if (i == com.sandboxol.decorate.c.f16979a) {
            synchronized (this) {
                this.g |= 1;
            }
            return true;
        }
        if (i != com.sandboxol.decorate.c.I) {
            return false;
        }
        synchronized (this) {
            this.g |= 2;
        }
        return true;
    }
}
