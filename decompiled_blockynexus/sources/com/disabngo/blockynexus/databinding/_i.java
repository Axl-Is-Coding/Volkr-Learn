package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.greendao.entity.Friend;

/* JADX INFO: compiled from: ItemSearchFriendBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class _i extends Zi {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f8135b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f8136c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinearLayout f8137d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ImageView f8138e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextView f8139f;
    private final TextView g;
    private final TextView h;
    private final Button i;
    private long j;

    public _i(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 6, f8135b, f8136c));
    }

    private boolean onChangeViewModelItem(Friend friend, int i) {
        if (i == 0) {
            synchronized (this) {
                this.j |= 4;
            }
            return true;
        }
        if (i != 18) {
            return false;
        }
        synchronized (this) {
            this.j |= 8;
        }
        return true;
    }

    public void a(com.disabngo.blockynexus.view.activity.searchfriend.i iVar) {
        updateRegistration(0, iVar);
        this.f8110a = iVar;
        synchronized (this) {
            this.j |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00b3  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 293
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding._i.executeBindings():void");
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
            this.j = 16L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((com.disabngo.blockynexus.view.activity.searchfriend.i) obj, i2);
        }
        if (i == 1) {
            return a((ObservableField<Boolean>) obj, i2);
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
        a((com.disabngo.blockynexus.view.activity.searchfriend.i) obj);
        return true;
    }

    private _i(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 3);
        this.j = -1L;
        this.f8137d = (LinearLayout) objArr[0];
        this.f8137d.setTag(null);
        this.f8138e = (ImageView) objArr[1];
        this.f8138e.setTag(null);
        this.f8139f = (TextView) objArr[2];
        this.f8139f.setTag(null);
        this.g = (TextView) objArr[3];
        this.g.setTag(null);
        this.h = (TextView) objArr[4];
        this.h.setTag(null);
        this.i = (Button) objArr[5];
        this.i.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.view.activity.searchfriend.i iVar, int i) {
        if (i == 0) {
            synchronized (this) {
                this.j |= 1;
            }
            return true;
        }
        if (i != 244) {
            return false;
        }
        synchronized (this) {
            this.j |= 4;
        }
        return true;
    }

    private boolean a(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.j |= 2;
        }
        return true;
    }
}
