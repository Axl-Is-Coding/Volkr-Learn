package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.oi, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ItemNewRecommandFriendBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0681oi extends AbstractC0670ni {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ViewDataBinding.b f8668e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final SparseIntArray f8669f = null;
    private final RelativeLayout g;
    private final ImageView h;
    private final ImageView i;
    private final TextView j;
    private final ImageView k;
    private final TextView l;
    private final ImageView m;
    private long n;

    public C0681oi(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 10, f8668e, f8669f));
    }

    private boolean b(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.n |= 8;
        }
        return true;
    }

    private boolean c(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.n |= 2;
        }
        return true;
    }

    private boolean d(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.n |= 16;
        }
        return true;
    }

    public void a(com.disabngo.blockynexus.view.activity.newsearch.p pVar) {
        updateRegistration(0, pVar);
        this.f8632d = pVar;
        synchronized (this) {
            this.n |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x013d  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 465
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0681oi.executeBindings():void");
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
            this.n = 64L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((com.disabngo.blockynexus.view.activity.newsearch.p) obj, i2);
        }
        if (i == 1) {
            return c((ObservableField) obj, i2);
        }
        if (i == 2) {
            return a((ObservableField<Boolean>) obj, i2);
        }
        if (i == 3) {
            return b((ObservableField) obj, i2);
        }
        if (i != 4) {
            return false;
        }
        return d((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.activity.newsearch.p) obj);
        return true;
    }

    private C0681oi(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 5, (RelativeLayout) objArr[1], (TextView) objArr[5], (TextView) objArr[4]);
        this.n = -1L;
        this.g = (RelativeLayout) objArr[0];
        this.g.setTag(null);
        this.h = (ImageView) objArr[2];
        this.h.setTag(null);
        this.i = (ImageView) objArr[3];
        this.i.setTag(null);
        this.j = (TextView) objArr[6];
        this.j.setTag(null);
        this.k = (ImageView) objArr[7];
        this.k.setTag(null);
        this.l = (TextView) objArr[8];
        this.l.setTag(null);
        this.m = (ImageView) objArr[9];
        this.m.setTag(null);
        this.f8629a.setTag(null);
        this.f8630b.setTag(null);
        this.f8631c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.view.activity.newsearch.p pVar, int i) {
        if (i == 0) {
            synchronized (this) {
                this.n |= 1;
            }
            return true;
        }
        if (i != 244) {
            return false;
        }
        synchronized (this) {
            this.n |= 32;
        }
        return true;
    }

    private boolean a(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.n |= 4;
        }
        return true;
    }
}
