package com.sandboxol.gamedetail.a;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.gamedetail.c.a.a.ba;

/* JADX INFO: renamed from: com.sandboxol.gamedetail.a.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ContentGameHallBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2677f extends AbstractC2676e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ViewDataBinding.b f17830d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SparseIntArray f17831e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ConstraintLayout f17832f;
    private final ImageButton g;
    private final ImageView h;
    private final ImageButton i;
    private final View j;
    private long k;

    public C2677f(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 7, f17830d, f17831e));
    }

    private boolean b(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.gamedetail.a.f17768a) {
            return false;
        }
        synchronized (this) {
            this.k |= 2;
        }
        return true;
    }

    @Override // com.sandboxol.gamedetail.a.AbstractC2676e
    public void a(ba baVar) {
        updateRegistration(2, baVar);
        this.f17829c = baVar;
        synchronized (this) {
            this.k |= 4;
        }
        notifyPropertyChanged(com.sandboxol.gamedetail.a.k);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b3  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 348
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.gamedetail.a.C2677f.executeBindings():void");
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
        if (i == 1) {
            return b((ObservableField) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return a((ba) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.gamedetail.a.k != i) {
            return false;
        }
        a((ba) obj);
        return true;
    }

    private C2677f(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 3, (RelativeLayout) objArr[1], (RelativeLayout) objArr[4]);
        this.k = -1L;
        this.f17832f = (ConstraintLayout) objArr[0];
        this.f17832f.setTag(null);
        this.g = (ImageButton) objArr[2];
        this.g.setTag(null);
        this.h = (ImageView) objArr[3];
        this.h.setTag(null);
        this.i = (ImageButton) objArr[5];
        this.i.setTag(null);
        this.j = (View) objArr[6];
        this.j.setTag(null);
        this.f17827a.setTag(null);
        this.f17828b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<Integer> observableField, int i) {
        if (i != com.sandboxol.gamedetail.a.f17768a) {
            return false;
        }
        synchronized (this) {
            this.k |= 1;
        }
        return true;
    }

    private boolean a(ba baVar, int i) {
        if (i != com.sandboxol.gamedetail.a.f17768a) {
            return false;
        }
        synchronized (this) {
            this.k |= 4;
        }
        return true;
    }
}
