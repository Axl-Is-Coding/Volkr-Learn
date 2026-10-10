package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: compiled from: ItemInboxDetailAttachmentBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Ph extends Oh {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f7777b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f7778c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final RelativeLayout f7779d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ImageView f7780e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextView f7781f;
    private final View g;
    private final ImageView h;
    private long i;

    public Ph(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 5, f7777b, f7778c));
    }

    public void a(com.disabngo.blockynexus.view.fragment.inboxdetail.f fVar) {
        updateRegistration(1, fVar);
        this.f7750a = fVar;
        synchronized (this) {
            this.i |= 2;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0050 A[PHI: r2
      0x0050: PHI (r2v4 long) = (r2v0 long), (r2v8 long) binds: [B:9:0x001f, B:27:0x004a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 217
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.Ph.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.i != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.i = 8L;
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
        return a((com.disabngo.blockynexus.view.fragment.inboxdetail.f) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.fragment.inboxdetail.f) obj);
        return true;
    }

    private Ph(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2);
        this.i = -1L;
        this.f7779d = (RelativeLayout) objArr[0];
        this.f7779d.setTag(null);
        this.f7780e = (ImageView) objArr[1];
        this.f7780e.setTag(null);
        this.f7781f = (TextView) objArr[2];
        this.f7781f.setTag(null);
        this.g = (View) objArr[3];
        this.g.setTag(null);
        this.h = (ImageView) objArr[4];
        this.h.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.i |= 1;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.view.fragment.inboxdetail.f fVar, int i) {
        if (i == 0) {
            synchronized (this) {
                this.i |= 2;
            }
            return true;
        }
        if (i != 244) {
            return false;
        }
        synchronized (this) {
            this.i |= 4;
        }
        return true;
    }
}
