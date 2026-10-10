package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.GroupMember;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: compiled from: FragmentGroupAdmiBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Zd extends Yd {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ViewDataBinding.b f8089e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final SparseIntArray f8090f = new SparseIntArray();
    private final NestedScrollView g;
    private final TextView h;
    private final DataRecyclerView i;
    private final RelativeLayout j;
    private final LinearLayout k;
    private long l;

    static {
        f8090f.put(R.id.iv_head, 6);
        f8090f.put(R.id.vLine, 7);
    }

    public Zd(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 8, f8089e, f8090f));
    }

    private boolean b(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.l |= 4;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.Yd
    public void a(com.disabngo.blockynexus.e.b.E.r rVar) {
        updateRegistration(0, rVar);
        this.f8059d = rVar;
        synchronized (this) {
            this.l |= 1;
        }
        notifyPropertyChanged(334);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0090  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.Zd.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.l != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.l = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((com.disabngo.blockynexus.e.b.E.r) obj, i2);
        }
        if (i == 1) {
            return a((ObservableField<GroupMember>) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return b((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (334 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.E.r) obj);
        return true;
    }

    private Zd(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 3, (ImageView) objArr[1], (ImageView) objArr[6], (View) objArr[7]);
        this.l = -1L;
        this.f8056a.setTag(null);
        this.g = (NestedScrollView) objArr[0];
        this.g.setTag(null);
        this.h = (TextView) objArr[2];
        this.h.setTag(null);
        this.i = (DataRecyclerView) objArr[3];
        this.i.setTag(null);
        this.j = (RelativeLayout) objArr[4];
        this.j.setTag(null);
        this.k = (LinearLayout) objArr[5];
        this.k.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.E.r rVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.l |= 1;
        }
        return true;
    }

    private boolean a(ObservableField<GroupMember> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.l |= 2;
        }
        return true;
    }
}
