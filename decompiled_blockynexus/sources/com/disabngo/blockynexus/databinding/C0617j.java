package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.activity.friendmatch.FriendMatchViewModel;
import com.disabngo.blockynexus.view.widget.MapLayout;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.common.widget.RoundImageView;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ActivityFriendMatchBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0617j extends AbstractC0607i {
    private static final ViewDataBinding.b n = null;
    private static final SparseIntArray o = new SparseIntArray();
    private final CoordinatorLayout p;
    private long q;

    static {
        o.put(R.id.rlTotal, 8);
        o.put(R.id.mapLayout, 9);
        o.put(R.id.rlMy, 10);
        o.put(R.id.tvTip, 11);
        o.put(R.id.clRadar, 12);
    }

    public C0617j(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 13, n, o));
    }

    private boolean b(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.q |= 2;
        }
        return true;
    }

    private boolean c(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.q |= 16;
        }
        return true;
    }

    private boolean d(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.q |= 4;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0607i
    public void a(FriendMatchViewModel friendMatchViewModel) {
        updateRegistration(3, friendMatchViewModel);
        this.m = friendMatchViewModel;
        synchronized (this) {
            this.q |= 8;
        }
        notifyPropertyChanged(482);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:92:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 375
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0617j.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.q != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.q = 64L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((AccountCenter) obj, i2);
        }
        if (i == 1) {
            return b((ObservableField) obj, i2);
        }
        if (i == 2) {
            return d((ObservableField) obj, i2);
        }
        if (i == 3) {
            return a((FriendMatchViewModel) obj, i2);
        }
        if (i == 4) {
            return c((ObservableField) obj, i2);
        }
        if (i != 5) {
            return false;
        }
        return a((ObservableField<String>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (482 != i) {
            return false;
        }
        a((FriendMatchViewModel) obj);
        return true;
    }

    private C0617j(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 6, (Button) objArr[5], (ConstraintLayout) objArr[12], (RoundImageView) objArr[3], (ImageView) objArr[7], (ImageView) objArr[6], (LinearLayout) objArr[4], (MapLayout) objArr[9], (RelativeLayout) objArr[10], (RelativeLayout) objArr[8], (TextView) objArr[11], (View) objArr[1], (View) objArr[2]);
        this.q = -1L;
        this.f8428a.setTag(null);
        this.f8430c.setTag(null);
        this.f8431d.setTag(null);
        this.f8432e.setTag(null);
        this.f8433f.setTag(null);
        this.p = (CoordinatorLayout) objArr[0];
        this.p.setTag(null);
        this.k.setTag(null);
        this.l.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(AccountCenter accountCenter, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.q |= 1;
        }
        return true;
    }

    private boolean a(FriendMatchViewModel friendMatchViewModel, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.q |= 8;
        }
        return true;
    }

    private boolean a(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.q |= 32;
        }
        return true;
    }
}
