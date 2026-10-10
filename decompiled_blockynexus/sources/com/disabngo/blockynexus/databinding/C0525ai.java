package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.widget.ScaleRelativeLayout;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.ai, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ItemLatelyPlayItemViewBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0525ai extends _h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ViewDataBinding.b f8176d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SparseIntArray f8177e = new SparseIntArray();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ScaleRelativeLayout f8178f;
    private final ImageView g;
    private final ProgressBar h;
    private final LinearLayout i;
    private final TextView j;
    private final ImageView k;
    private long l;

    static {
        f8177e.put(R.id.img, 7);
    }

    public C0525ai(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 8, f8176d, f8177e));
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

    private boolean c(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.l |= 16;
        }
        return true;
    }

    public void a(com.disabngo.blockynexus.e.b.N.c cVar) {
        updateRegistration(3, cVar);
        this.f8134c = cVar;
        synchronized (this) {
            this.l |= 8;
        }
        notifyPropertyChanged(368);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:119:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x013a  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 418
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0525ai.executeBindings():void");
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
            this.l = 64L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((ObservableList<String>) obj, i2);
        }
        if (i == 1) {
            return a((ObservableField<Boolean>) obj, i2);
        }
        if (i == 2) {
            return b((ObservableField) obj, i2);
        }
        if (i == 3) {
            return a((com.disabngo.blockynexus.e.b.N.c) obj, i2);
        }
        if (i != 4) {
            return false;
        }
        return c((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (368 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.N.c) obj);
        return true;
    }

    private C0525ai(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 5, (RelativeLayout) objArr[7], (TextView) objArr[2]);
        this.l = -1L;
        this.f8133b.setTag(null);
        this.f8178f = (ScaleRelativeLayout) objArr[0];
        this.f8178f.setTag(null);
        this.g = (ImageView) objArr[1];
        this.g.setTag(null);
        this.h = (ProgressBar) objArr[3];
        this.h.setTag(null);
        this.i = (LinearLayout) objArr[4];
        this.i.setTag(null);
        this.j = (TextView) objArr[5];
        this.j.setTag(null);
        this.k = (ImageView) objArr[6];
        this.k.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableList<String> observableList, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.l |= 1;
        }
        return true;
    }

    private boolean a(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.l |= 2;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.e.b.N.c cVar, int i) {
        if (i == 0) {
            synchronized (this) {
                this.l |= 8;
            }
            return true;
        }
        if (i != 244) {
            return false;
        }
        synchronized (this) {
            this.l |= 32;
        }
        return true;
    }
}
