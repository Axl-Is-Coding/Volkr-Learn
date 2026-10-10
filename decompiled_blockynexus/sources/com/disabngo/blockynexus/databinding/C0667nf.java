package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.nf, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentSecretQuestionBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0667nf extends AbstractC0634kf {
    private static final ViewDataBinding.b h = null;
    private static final SparseIntArray i = new SparseIntArray();
    private final LinearLayout j;
    private final LinearLayout k;
    private final AppCompatTextView l;
    private final AppCompatEditText m;
    private final LinearLayout n;
    private final AppCompatTextView o;
    private final AppCompatEditText p;
    private androidx.databinding.f q;
    private androidx.databinding.f r;
    private long s;

    static {
        i.put(R.id.iv_one, 11);
        i.put(R.id.iv_two, 12);
    }

    public C0667nf(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 13, h, i));
    }

    private boolean c(ObservableField<Boolean> observableField, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.s |= 4;
        }
        return true;
    }

    private boolean d(ObservableField<String> observableField, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.s |= 16;
        }
        return true;
    }

    private boolean e(ObservableField<String> observableField, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.s |= 32;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00de  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 366
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0667nf.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.s != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.s = 64L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return b((ObservableField) obj, i3);
        }
        if (i2 == 1) {
            return a((com.disabngo.blockynexus.e.b.fa.l) obj, i3);
        }
        if (i2 == 2) {
            return c((ObservableField) obj, i3);
        }
        if (i2 == 3) {
            return a((ObservableField<String>) obj, i3);
        }
        if (i2 == 4) {
            return d((ObservableField) obj, i3);
        }
        if (i2 != 5) {
            return false;
        }
        return e((ObservableField) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, Object obj) {
        if (523 != i2) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.fa.l) obj);
        return true;
    }

    private C0667nf(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 6, (Button) objArr[10], (Button) objArr[5], (AppCompatImageView) objArr[11], (AppCompatImageView) objArr[12], (LinearLayout) objArr[2], (LinearLayout) objArr[7]);
        this.q = new C0645lf(this);
        this.r = new C0656mf(this);
        this.s = -1L;
        this.f8517a.setTag(null);
        this.f8518b.setTag(null);
        this.f8521e.setTag(null);
        this.f8522f.setTag(null);
        this.j = (LinearLayout) objArr[0];
        this.j.setTag(null);
        this.k = (LinearLayout) objArr[1];
        this.k.setTag(null);
        this.l = (AppCompatTextView) objArr[3];
        this.l.setTag(null);
        this.m = (AppCompatEditText) objArr[4];
        this.m.setTag(null);
        this.n = (LinearLayout) objArr[6];
        this.n.setTag(null);
        this.o = (AppCompatTextView) objArr[8];
        this.o.setTag(null);
        this.p = (AppCompatEditText) objArr[9];
        this.p.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean b(ObservableField<String> observableField, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.s |= 1;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0634kf
    public void a(com.disabngo.blockynexus.e.b.fa.l lVar) {
        updateRegistration(1, lVar);
        this.g = lVar;
        synchronized (this) {
            this.s |= 2;
        }
        notifyPropertyChanged(523);
        super.requestRebind();
    }

    private boolean a(com.disabngo.blockynexus.e.b.fa.l lVar, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.s |= 2;
        }
        return true;
    }

    private boolean a(ObservableField<String> observableField, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.s |= 8;
        }
        return true;
    }
}
