package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.nj, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ItemTribeMemberListBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0671nj extends AbstractC0660mj {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ViewDataBinding.b f8633e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final SparseIntArray f8634f = null;
    private final RelativeLayout g;
    private final TextView h;
    private final ImageView i;
    private final TextView j;
    private long k;

    public C0671nj(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 7, f8633e, f8634f));
    }

    public void a(com.disabngo.blockynexus.view.fragment.tribehas.J j) {
        updateRegistration(0, j);
        this.f8601d = j;
        synchronized (this) {
            this.k |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 373
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0671nj.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.k != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.k = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((com.disabngo.blockynexus.view.fragment.tribehas.J) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return a((ObservableField<String>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.fragment.tribehas.J) obj);
        return true;
    }

    private C0671nj(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2, (ImageView) objArr[1], (TextView) objArr[2], (TextView) objArr[6]);
        this.k = -1L;
        this.f8598a.setTag(null);
        this.f8599b.setTag(null);
        this.g = (RelativeLayout) objArr[0];
        this.g.setTag(null);
        this.h = (TextView) objArr[3];
        this.h.setTag(null);
        this.i = (ImageView) objArr[4];
        this.i.setTag(null);
        this.j = (TextView) objArr[5];
        this.j.setTag(null);
        this.f8600c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.view.fragment.tribehas.J j, int i) {
        if (i == 0) {
            synchronized (this) {
                this.k |= 1;
            }
            return true;
        }
        if (i != 244) {
            return false;
        }
        synchronized (this) {
            this.k |= 4;
        }
        return true;
    }

    private boolean a(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 2;
        }
        return true;
    }
}
