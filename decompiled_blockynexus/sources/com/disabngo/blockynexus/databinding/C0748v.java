package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;
import com.sandboxol.common.widget.rv.pagerv.PageRecyclerView;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.v, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ActivitySearchFriendBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0748v extends AbstractC0737u {
    private static final ViewDataBinding.b g = null;
    private static final SparseIntArray h = new SparseIntArray();
    private final CoordinatorLayout i;
    private final Button j;
    private final PageRecyclerView k;
    private final RelativeLayout l;
    private final DataRecyclerView m;
    private long n;

    static {
        h.put(R.id.tbTemplateBar, 8);
        h.put(R.id.rlBlank, 9);
    }

    public C0748v(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 10, g, h));
    }

    private boolean b(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.n |= 4;
        }
        return true;
    }

    private boolean c(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.n |= 1;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0737u
    public void a(com.disabngo.blockynexus.view.activity.searchfriend.q qVar) {
        updateRegistration(3, qVar);
        this.f8861f = qVar;
        synchronized (this) {
            this.n |= 8;
        }
        notifyPropertyChanged(350);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00af  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 315
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0748v.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.n != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.n = 16L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return c((ObservableField) obj, i2);
        }
        if (i == 1) {
            return a((ObservableField<Boolean>) obj, i2);
        }
        if (i == 2) {
            return b((ObservableField) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return a((com.disabngo.blockynexus.view.activity.searchfriend.q) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (350 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.activity.searchfriend.q) obj);
        return true;
    }

    private C0748v(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 4, (ImageButton) objArr[1], (ImageButton) objArr[6], (RelativeLayout) objArr[9], (Toolbar) objArr[8], (EditText) objArr[2]);
        this.n = -1L;
        this.f8856a.setTag(null);
        this.f8857b.setTag(null);
        this.i = (CoordinatorLayout) objArr[0];
        this.i.setTag(null);
        this.j = (Button) objArr[3];
        this.j.setTag(null);
        this.k = (PageRecyclerView) objArr[4];
        this.k.setTag(null);
        this.l = (RelativeLayout) objArr[5];
        this.l.setTag(null);
        this.m = (DataRecyclerView) objArr[7];
        this.m.setTag(null);
        this.f8860e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.n |= 2;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.view.activity.searchfriend.q qVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.n |= 8;
        }
        return true;
    }
}
