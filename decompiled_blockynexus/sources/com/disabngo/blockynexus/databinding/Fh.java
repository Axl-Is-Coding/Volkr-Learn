package com.disabngo.blockynexus.databinding;

import android.text.Spanned;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: compiled from: ItemGroupVerificationBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Fh extends Eh {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f7457c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f7458d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final LinearLayout f7459e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ImageView f7460f;
    private final TextView g;
    private final RelativeLayout h;
    private final Button i;
    private final Button j;
    private final TextView k;
    private long l;

    public Fh(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 8, f7457c, f7458d));
    }

    private boolean b(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.l |= 1;
        }
        return true;
    }

    private boolean c(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.l |= 16;
        }
        return true;
    }

    private boolean d(ObservableField<Spanned> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.l |= 8;
        }
        return true;
    }

    public void a(com.disabngo.blockynexus.e.b.H.h hVar) {
        updateRegistration(1, hVar);
        this.f7433b = hVar;
        synchronized (this) {
            this.l |= 2;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x004c A[PHI: r2
      0x004c: PHI (r2v3 long) = (r2v0 long), (r2v5 long) binds: [B:9:0x0022, B:23:0x0047] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00da  */
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
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.Fh.executeBindings():void");
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
            return b((ObservableField) obj, i2);
        }
        if (i == 1) {
            return a((com.disabngo.blockynexus.e.b.H.h) obj, i2);
        }
        if (i == 2) {
            return a((ObservableField<String>) obj, i2);
        }
        if (i == 3) {
            return d((ObservableField) obj, i2);
        }
        if (i != 4) {
            return false;
        }
        return c((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.H.h) obj);
        return true;
    }

    private Fh(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 5, (TextView) objArr[2]);
        this.l = -1L;
        this.f7459e = (LinearLayout) objArr[0];
        this.f7459e.setTag(null);
        this.f7460f = (ImageView) objArr[1];
        this.f7460f.setTag(null);
        this.g = (TextView) objArr[3];
        this.g.setTag(null);
        this.h = (RelativeLayout) objArr[4];
        this.h.setTag(null);
        this.i = (Button) objArr[5];
        this.i.setTag(null);
        this.j = (Button) objArr[6];
        this.j.setTag(null);
        this.k = (TextView) objArr[7];
        this.k.setTag(null);
        this.f7432a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.H.h hVar, int i) {
        if (i == 0) {
            synchronized (this) {
                this.l |= 2;
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

    private boolean a(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.l |= 4;
        }
        return true;
    }
}
