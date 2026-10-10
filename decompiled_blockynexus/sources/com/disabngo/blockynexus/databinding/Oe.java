package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* JADX INFO: compiled from: FragmentPartyHallBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Oe extends Ne {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ViewDataBinding.b f7742e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final SparseIntArray f7743f = new SparseIntArray();
    private final ConstraintLayout g;
    private final TextView h;
    private final TextView i;
    private final SmartRefreshLayout j;
    private final DataRecyclerView k;
    private final Button l;
    private final Button m;
    private long n;

    static {
        f7743f.put(R.id.vTopBg, 9);
    }

    public Oe(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 10, f7742e, f7743f));
    }

    private boolean b(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.n |= 4;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.Ne
    public void a(com.disabngo.blockynexus.view.fragment.partyhall.G g) {
        updateRegistration(0, g);
        this.f7712d = g;
        synchronized (this) {
            this.n |= 1;
        }
        notifyPropertyChanged(436);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0073  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 225
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.Oe.executeBindings():void");
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
            this.n = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((com.disabngo.blockynexus.view.fragment.partyhall.G) obj, i2);
        }
        if (i == 1) {
            return a((ObservableField<String>) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return b((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (436 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.fragment.partyhall.G) obj);
        return true;
    }

    private Oe(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 3, (LinearLayout) objArr[1], (LinearLayout) objArr[3], (View) objArr[9]);
        this.n = -1L;
        this.f7709a.setTag(null);
        this.f7710b.setTag(null);
        this.g = (ConstraintLayout) objArr[0];
        this.g.setTag(null);
        this.h = (TextView) objArr[2];
        this.h.setTag(null);
        this.i = (TextView) objArr[4];
        this.i.setTag(null);
        this.j = (SmartRefreshLayout) objArr[5];
        this.j.setTag(null);
        this.k = (DataRecyclerView) objArr[6];
        this.k.setTag(null);
        this.l = (Button) objArr[7];
        this.l.setTag(null);
        this.m = (Button) objArr[8];
        this.m.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.view.fragment.partyhall.G g, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.n |= 1;
        }
        return true;
    }

    private boolean a(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.n |= 2;
        }
        return true;
    }
}
