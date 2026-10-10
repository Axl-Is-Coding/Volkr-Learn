package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.TribeRank;
import com.sandboxol.common.widget.rv.pagerv.PageRecyclerView;
import java.util.List;

/* JADX INFO: compiled from: ContentTribeRankPageBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Ea extends Da {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ViewDataBinding.b f7412d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SparseIntArray f7413e = new SparseIntArray();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final LinearLayout f7414f;
    private final TextView g;
    private final TextView h;
    private final PageRecyclerView i;
    private final ImageView j;
    private final TextView k;
    private final TextView l;
    private final TextView m;
    private final TextView n;
    private final ImageView o;
    private final TextView p;
    private long q;

    static {
        f7413e.put(R.id.llFirst, 12);
    }

    public Ea(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 13, f7412d, f7413e));
    }

    private boolean b(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.q |= 2;
        }
        return true;
    }

    public void a(com.disabngo.blockynexus.e.b.ra.l lVar) {
        updateRegistration(0, lVar);
        this.f7371c = lVar;
        synchronized (this) {
            this.q |= 1;
        }
        notifyPropertyChanged(354);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x010d  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 772
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.Ea.executeBindings():void");
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
            this.q = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((com.disabngo.blockynexus.e.b.ra.l) obj, i2);
        }
        if (i == 1) {
            return b((ObservableField) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return a((ObservableField<List<TribeRank>>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (354 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.ra.l) obj);
        return true;
    }

    private Ea(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 3, (ImageView) objArr[5], (LinearLayout) objArr[12]);
        this.q = -1L;
        this.f7369a.setTag(null);
        this.f7414f = (LinearLayout) objArr[0];
        this.f7414f.setTag(null);
        this.g = (TextView) objArr[1];
        this.g.setTag(null);
        this.h = (TextView) objArr[10];
        this.h.setTag(null);
        this.i = (PageRecyclerView) objArr[11];
        this.i.setTag(null);
        this.j = (ImageView) objArr[2];
        this.j.setTag(null);
        this.k = (TextView) objArr[3];
        this.k.setTag(null);
        this.l = (TextView) objArr[4];
        this.l.setTag(null);
        this.m = (TextView) objArr[6];
        this.m.setTag(null);
        this.n = (TextView) objArr[7];
        this.n.setTag(null);
        this.o = (ImageView) objArr[8];
        this.o.setTag(null);
        this.p = (TextView) objArr[9];
        this.p.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.ra.l lVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.q |= 1;
        }
        return true;
    }

    private boolean a(ObservableField<List<TribeRank>> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.q |= 4;
        }
        return true;
    }
}
