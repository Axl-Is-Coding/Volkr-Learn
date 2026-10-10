package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;

/* JADX INFO: compiled from: ItemWeekSignBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Dj extends Cj {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ViewDataBinding.b f7403d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SparseIntArray f7404e = new SparseIntArray();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final RelativeLayout f7405f;
    private final ImageView g;
    private final ImageView h;
    private final ImageView i;
    private final TextView j;
    private final ImageView k;
    private final TextView l;
    private final View m;
    private final TextView n;
    private long o;

    static {
        f7404e.put(R.id.rlReward, 10);
    }

    public Dj(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 11, f7403d, f7404e));
    }

    public void a(com.disabngo.blockynexus.view.dialog.j.h hVar) {
        updateRegistration(0, hVar);
        this.f7362c = hVar;
        synchronized (this) {
            this.o |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 356
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.Dj.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.o != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.o = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((com.disabngo.blockynexus.view.dialog.j.h) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return a((ObservableField<String>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.dialog.j.h) obj);
        return true;
    }

    private Dj(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2, (ImageView) objArr[8], (RelativeLayout) objArr[10]);
        this.o = -1L;
        this.f7360a.setTag(null);
        this.f7405f = (RelativeLayout) objArr[0];
        this.f7405f.setTag(null);
        this.g = (ImageView) objArr[1];
        this.g.setTag(null);
        this.h = (ImageView) objArr[2];
        this.h.setTag(null);
        this.i = (ImageView) objArr[3];
        this.i.setTag(null);
        this.j = (TextView) objArr[4];
        this.j.setTag(null);
        this.k = (ImageView) objArr[5];
        this.k.setTag(null);
        this.l = (TextView) objArr[6];
        this.l.setTag(null);
        this.m = (View) objArr[7];
        this.m.setTag(null);
        this.n = (TextView) objArr[9];
        this.n.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.view.dialog.j.h hVar, int i) {
        if (i == 0) {
            synchronized (this) {
                this.o |= 1;
            }
            return true;
        }
        if (i != 244) {
            return false;
        }
        synchronized (this) {
            this.o |= 4;
        }
        return true;
    }

    private boolean a(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.o |= 2;
        }
        return true;
    }
}
