package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.e.b.q.C0906g;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.hh, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ItemDiskGameManageBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0604hh extends AbstractC0593gh {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ViewDataBinding.b f8414f = null;
    private static final SparseIntArray g = null;
    private final ConstraintLayout h;
    private final TextView i;
    private long j;

    public C0604hh(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 6, f8414f, g));
    }

    private boolean b(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.j |= 8;
        }
        return true;
    }

    public void a(C0906g c0906g) {
        updateRegistration(1, c0906g);
        this.f8382e = c0906g;
        synchronized (this) {
            this.j |= 2;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x010e  */
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
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0604hh.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.j != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.j = 32L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((ObservableField<Boolean>) obj, i2);
        }
        if (i == 1) {
            return a((C0906g) obj, i2);
        }
        if (i == 2) {
            return a((ObservableList<String>) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return b((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((C0906g) obj);
        return true;
    }

    private C0604hh(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 4, (CheckBox) objArr[1], (ImageView) objArr[2], (TextView) objArr[3], (TextView) objArr[4]);
        this.j = -1L;
        this.f8378a.setTag(null);
        this.f8379b.setTag(null);
        this.h = (ConstraintLayout) objArr[0];
        this.h.setTag(null);
        this.i = (TextView) objArr[5];
        this.i.setTag(null);
        this.f8380c.setTag(null);
        this.f8381d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.j |= 1;
        }
        return true;
    }

    private boolean a(C0906g c0906g, int i) {
        if (i == 0) {
            synchronized (this) {
                this.j |= 2;
            }
            return true;
        }
        if (i != 244) {
            return false;
        }
        synchronized (this) {
            this.j |= 16;
        }
        return true;
    }

    private boolean a(ObservableList<String> observableList, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.j |= 4;
        }
        return true;
    }
}
