package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.FriendRequests;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: compiled from: FragmentFriendBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Vd extends Ud {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ViewDataBinding.b f7960f = null;
    private static final SparseIntArray g = new SparseIntArray();
    private final LinearLayout h;
    private final RelativeLayout i;
    private final TextView j;
    private final LinearLayout k;
    private final TextView l;
    private long m;

    static {
        g.put(R.id.ivAdd, 7);
        g.put(R.id.tvFriend, 8);
    }

    public Vd(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 9, f7960f, g));
    }

    private boolean b(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 16;
        }
        return true;
    }

    private boolean c(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 2;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.Ud
    public void a(com.disabngo.blockynexus.e.b.x.M m) {
        updateRegistration(0, m);
        this.f7934e = m;
        synchronized (this) {
            this.m |= 1;
        }
        notifyPropertyChanged(437);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00e7 A[PHI: r2
      0x00e7: PHI (r2v2 long) = (r2v1 long), (r2v5 long) binds: [B:60:0x00d0, B:69:0x00e1] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 308
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.Vd.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.m != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.m = 32L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((com.disabngo.blockynexus.e.b.x.M) obj, i2);
        }
        if (i == 1) {
            return c((ObservableField) obj, i2);
        }
        if (i == 2) {
            return a((ObservableField<String>) obj, i2);
        }
        if (i == 3) {
            return a((ObservableArrayList<FriendRequests>) obj, i2);
        }
        if (i != 4) {
            return false;
        }
        return b((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (437 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.x.M) obj);
        return true;
    }

    private Vd(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 5, (DataRecyclerView) objArr[6], (ImageView) objArr[7], (RelativeLayout) objArr[2], (TextView) objArr[8]);
        this.m = -1L;
        this.f7930a.setTag(null);
        this.h = (LinearLayout) objArr[0];
        this.h.setTag(null);
        this.i = (RelativeLayout) objArr[1];
        this.i.setTag(null);
        this.j = (TextView) objArr[3];
        this.j.setTag(null);
        this.k = (LinearLayout) objArr[4];
        this.k.setTag(null);
        this.l = (TextView) objArr[5];
        this.l.setTag(null);
        this.f7932c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.x.M m, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 1;
        }
        return true;
    }

    private boolean a(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 4;
        }
        return true;
    }

    private boolean a(ObservableArrayList<FriendRequests> observableArrayList, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 8;
        }
        return true;
    }
}
