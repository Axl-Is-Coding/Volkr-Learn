package com.sandboxol.gamedetail.a;

import android.util.SparseIntArray;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.gamedetail.R;

/* JADX INFO: renamed from: com.sandboxol.gamedetail.a.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogGameDetailShopBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2683l extends AbstractC2682k {
    private static final ViewDataBinding.b i = null;
    private static final SparseIntArray j = new SparseIntArray();
    private final ConstraintLayout k;
    private long l;

    static {
        j.put(R.id.constraintLayout, 5);
        j.put(R.id.imageView4, 6);
        j.put(R.id.imageView5, 7);
    }

    public C2683l(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 8, i, j));
    }

    private boolean b(ObservableField<String> observableField, int i2) {
        if (i2 != com.sandboxol.gamedetail.a.f17768a) {
            return false;
        }
        synchronized (this) {
            this.l |= 1;
        }
        return true;
    }

    private boolean c(ObservableField<String> observableField, int i2) {
        if (i2 != com.sandboxol.gamedetail.a.f17768a) {
            return false;
        }
        synchronized (this) {
            this.l |= 4;
        }
        return true;
    }

    private boolean d(ObservableField<String> observableField, int i2) {
        if (i2 != com.sandboxol.gamedetail.a.f17768a) {
            return false;
        }
        synchronized (this) {
            this.l |= 8;
        }
        return true;
    }

    @Override // com.sandboxol.gamedetail.a.AbstractC2682k
    public void a(com.sandboxol.gamedetail.view.dialog.e eVar) {
        this.h = eVar;
        synchronized (this) {
            this.l |= 16;
        }
        notifyPropertyChanged(com.sandboxol.gamedetail.a.g);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0093  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 238
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.gamedetail.a.C2683l.executeBindings():void");
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
            this.l = 32L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return b((ObservableField) obj, i3);
        }
        if (i2 == 1) {
            return a((ObservableField) obj, i3);
        }
        if (i2 == 2) {
            return c((ObservableField) obj, i3);
        }
        if (i2 != 3) {
            return false;
        }
        return d((ObservableField) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, Object obj) {
        if (com.sandboxol.gamedetail.a.g != i2) {
            return false;
        }
        a((com.sandboxol.gamedetail.view.dialog.e) obj);
        return true;
    }

    private C2683l(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 4, (AppCompatTextView) objArr[1], (AppCompatTextView) objArr[3], (AppCompatTextView) objArr[2], (ConstraintLayout) objArr[5], (AppCompatImageView) objArr[4], (AppCompatImageView) objArr[6], (AppCompatImageView) objArr[7]);
        this.l = -1L;
        this.f17845a.setTag(null);
        this.f17846b.setTag(null);
        this.f17847c.setTag(null);
        this.f17849e.setTag(null);
        this.k = (ConstraintLayout) objArr[0];
        this.k.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<String> observableField, int i2) {
        if (i2 != com.sandboxol.gamedetail.a.f17768a) {
            return false;
        }
        synchronized (this) {
            this.l |= 2;
        }
        return true;
    }
}
