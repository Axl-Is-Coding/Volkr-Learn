package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.greendao.entity.Friend;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.jj, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ItemTribeInviteFriendBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0627jj extends AbstractC0616ij {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f8496c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f8497d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RelativeLayout f8498e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextView f8499f;
    private final CheckBox g;
    private long h;

    public C0627jj(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 4, f8496c, f8497d));
    }

    private boolean onChangeViewModelItem(Friend friend, int i) {
        if (i == 0) {
            synchronized (this) {
                this.h |= 4;
            }
            return true;
        }
        if (i != 18) {
            return false;
        }
        synchronized (this) {
            this.h |= 8;
        }
        return true;
    }

    public void a(com.disabngo.blockynexus.e.b.na.d dVar) {
        updateRegistration(0, dVar);
        this.f8455b = dVar;
        synchronized (this) {
            this.h |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x007a  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0627jj.executeBindings():void");
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
            this.h = 16L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((com.disabngo.blockynexus.e.b.na.d) obj, i2);
        }
        if (i == 1) {
            return a((ObservableArrayList<String>) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return onChangeViewModelItem((Friend) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.na.d) obj);
        return true;
    }

    private C0627jj(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 3, (ImageView) objArr[1]);
        this.h = -1L;
        this.f8454a.setTag(null);
        this.f8498e = (RelativeLayout) objArr[0];
        this.f8498e.setTag(null);
        this.f8499f = (TextView) objArr[2];
        this.f8499f.setTag(null);
        this.g = (CheckBox) objArr[3];
        this.g.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.na.d dVar, int i) {
        if (i == 0) {
            synchronized (this) {
                this.h |= 1;
            }
            return true;
        }
        if (i != 244) {
            return false;
        }
        synchronized (this) {
            this.h |= 4;
        }
        return true;
    }

    private boolean a(ObservableArrayList<String> observableArrayList, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.h |= 2;
        }
        return true;
    }
}
