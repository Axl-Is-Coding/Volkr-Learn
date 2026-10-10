package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.yh, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ItemGroupBannedBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0789yh extends AbstractC0778xh {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ViewDataBinding.b f9022f = null;
    private static final SparseIntArray g = new SparseIntArray();
    private final RelativeLayout h;
    private final ImageView i;
    private final TextView j;
    private long k;

    static {
        g.put(R.id.ivEnter, 6);
    }

    public C0789yh(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 7, f9022f, g));
    }

    public void a(com.disabngo.blockynexus.e.b.A.h hVar) {
        updateRegistration(0, hVar);
        this.f8983e = hVar;
        synchronized (this) {
            this.k |= 1;
        }
        notifyPropertyChanged(248);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 314
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0789yh.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.k != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.k = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((com.disabngo.blockynexus.e.b.A.h) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return a((ObservableField<Boolean>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (248 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.A.h) obj);
        return true;
    }

    private C0789yh(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2, (ImageView) objArr[6], (ImageView) objArr[1], (TextView) objArr[3], (TextView) objArr[2]);
        this.k = -1L;
        this.f8980b.setTag(null);
        this.h = (RelativeLayout) objArr[0];
        this.h.setTag(null);
        this.i = (ImageView) objArr[4];
        this.i.setTag(null);
        this.j = (TextView) objArr[5];
        this.j.setTag(null);
        this.f8981c.setTag(null);
        this.f8982d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.A.h hVar, int i) {
        if (i == 0) {
            synchronized (this) {
                this.k |= 1;
            }
            return true;
        }
        if (i != 244) {
            return false;
        }
        synchronized (this) {
            this.k |= 4;
        }
        return true;
    }

    private boolean a(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 2;
        }
        return true;
    }
}
