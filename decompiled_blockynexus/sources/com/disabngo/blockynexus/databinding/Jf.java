package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.widget.LabelsView;
import com.sandboxol.center.entity.TribeDetail;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: compiled from: FragmentTribeDetailBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Jf extends If {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f7586c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f7587d = new SparseIntArray();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ScrollView f7588e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ImageView f7589f;
    private final Button g;
    private final ImageView h;
    private final TextView i;
    private final TextView j;
    private final TextView k;
    private final ImageView l;
    private final LabelsView m;
    private final DataRecyclerView n;
    private final TextView o;
    private long p;

    static {
        f7587d.put(R.id.rl_donate, 11);
    }

    public Jf(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 12, f7586c, f7587d));
    }

    private boolean b(ObservableField<TribeDetail> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p |= 2;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.If
    public void a(com.disabngo.blockynexus.e.b.ma.m mVar) {
        updateRegistration(2, mVar);
        this.f7548b = mVar;
        synchronized (this) {
            this.p |= 4;
        }
        notifyPropertyChanged(391);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00cc  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 399
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.Jf.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.p != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.p = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((ObservableField<String>) obj, i2);
        }
        if (i == 1) {
            return b((ObservableField) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return a((com.disabngo.blockynexus.e.b.ma.m) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (391 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.ma.m) obj);
        return true;
    }

    private Jf(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 3, (LinearLayout) objArr[11]);
        this.p = -1L;
        this.f7588e = (ScrollView) objArr[0];
        this.f7588e.setTag(null);
        this.f7589f = (ImageView) objArr[1];
        this.f7589f.setTag(null);
        this.g = (Button) objArr[10];
        this.g.setTag(null);
        this.h = (ImageView) objArr[2];
        this.h.setTag(null);
        this.i = (TextView) objArr[3];
        this.i.setTag(null);
        this.j = (TextView) objArr[4];
        this.j.setTag(null);
        this.k = (TextView) objArr[5];
        this.k.setTag(null);
        this.l = (ImageView) objArr[6];
        this.l.setTag(null);
        this.m = (LabelsView) objArr[7];
        this.m.setTag(null);
        this.n = (DataRecyclerView) objArr[8];
        this.n.setTag(null);
        this.o = (TextView) objArr[9];
        this.o.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p |= 1;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.e.b.ma.m mVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p |= 4;
        }
        return true;
    }
}
