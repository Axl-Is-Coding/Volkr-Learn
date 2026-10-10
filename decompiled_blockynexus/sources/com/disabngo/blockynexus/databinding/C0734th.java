package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.view.widget.AutoSizeView;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.th, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ItemGameViewBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0734th extends AbstractC0723sh {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f8843b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f8844c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AutoSizeView f8845d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ImageView f8846e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextView f8847f;
    private final TextView g;
    private final TextView h;
    private final TextView i;
    private final ImageView j;
    private long k;

    public C0734th(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 7, f8843b, f8844c));
    }

    public void a(com.disabngo.blockynexus.e.b.X.b bVar) {
        updateRegistration(1, bVar);
        this.f8804a = bVar;
        synchronized (this) {
            this.k |= 2;
        }
        notifyPropertyChanged(347);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a1  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 262
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0734th.executeBindings():void");
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
            return a((ObservableField<Boolean>) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return a((com.disabngo.blockynexus.e.b.X.b) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (347 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.X.b) obj);
        return true;
    }

    private C0734th(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2);
        this.k = -1L;
        this.f8845d = (AutoSizeView) objArr[0];
        this.f8845d.setTag(null);
        this.f8846e = (ImageView) objArr[1];
        this.f8846e.setTag(null);
        this.f8847f = (TextView) objArr[2];
        this.f8847f.setTag(null);
        this.g = (TextView) objArr[3];
        this.g.setTag(null);
        this.h = (TextView) objArr[4];
        this.h.setTag(null);
        this.i = (TextView) objArr[5];
        this.i.setTag(null);
        this.j = (ImageView) objArr[6];
        this.j.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 1;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.e.b.X.b bVar, int i) {
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
