package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: compiled from: ItemTribeTaskBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Bj extends Aj {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f7324b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f7325c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinearLayout f7326d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ImageView f7327e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextView f7328f;
    private final ImageView g;
    private final TextView h;
    private final TextView i;
    private final Button j;
    private long k;

    public Bj(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 7, f7324b, f7325c));
    }

    public void a(com.disabngo.blockynexus.e.b.ua.m mVar) {
        updateRegistration(1, mVar);
        this.f7289a = mVar;
        synchronized (this) {
            this.k |= 2;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.Bj.executeBindings():void");
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
            return a((ObservableField<Integer>) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return a((com.disabngo.blockynexus.e.b.ua.m) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.ua.m) obj);
        return true;
    }

    private Bj(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2);
        this.k = -1L;
        this.f7326d = (LinearLayout) objArr[0];
        this.f7326d.setTag(null);
        this.f7327e = (ImageView) objArr[1];
        this.f7327e.setTag(null);
        this.f7328f = (TextView) objArr[2];
        this.f7328f.setTag(null);
        this.g = (ImageView) objArr[3];
        this.g.setTag(null);
        this.h = (TextView) objArr[4];
        this.h.setTag(null);
        this.i = (TextView) objArr[5];
        this.i.setTag(null);
        this.j = (Button) objArr[6];
        this.j.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 1;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.e.b.ua.m mVar, int i) {
        if (i == 0) {
            synchronized (this) {
                this.k |= 2;
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
}
