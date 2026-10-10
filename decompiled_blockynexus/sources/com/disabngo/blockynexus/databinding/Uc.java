package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.e.b.a.C0813b;

/* JADX INFO: compiled from: FragmentAboutBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Uc extends Tc {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ViewDataBinding.b f7929f = null;
    private static final SparseIntArray g = new SparseIntArray();
    private final LinearLayout h;
    private final TextView i;
    private final TextView j;
    private final TextView k;
    private final TextView l;
    private long m;

    static {
        g.put(R.id.aboutusiv, 5);
        g.put(R.id.textView8, 6);
        g.put(R.id.tv_about_all, 7);
        g.put(R.id.tv_about_bottom, 8);
    }

    public Uc(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 9, f7929f, g));
    }

    private boolean b(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 2;
        }
        return true;
    }

    private boolean c(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 4;
        }
        return true;
    }

    private boolean d(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 8;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.Tc
    public void a(C0813b c0813b) {
        updateRegistration(0, c0813b);
        this.f7900e = c0813b;
        synchronized (this) {
            this.m |= 1;
        }
        notifyPropertyChanged(442);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0090  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 227
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.Uc.executeBindings():void");
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
            return a((C0813b) obj, i2);
        }
        if (i == 1) {
            return b((ObservableField) obj, i2);
        }
        if (i == 2) {
            return c((ObservableField) obj, i2);
        }
        if (i == 3) {
            return d((ObservableField) obj, i2);
        }
        if (i != 4) {
            return false;
        }
        return a((ObservableField<String>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (442 != i) {
            return false;
        }
        a((C0813b) obj);
        return true;
    }

    private Uc(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 5, (ImageView) objArr[5], (TextView) objArr[6], (TextView) objArr[7], (TextView) objArr[8]);
        this.m = -1L;
        this.h = (LinearLayout) objArr[0];
        this.h.setTag(null);
        this.i = (TextView) objArr[1];
        this.i.setTag(null);
        this.j = (TextView) objArr[2];
        this.j.setTag(null);
        this.k = (TextView) objArr[3];
        this.k.setTag(null);
        this.l = (TextView) objArr[4];
        this.l.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(C0813b c0813b, int i) {
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
            this.m |= 16;
        }
        return true;
    }
}
