package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.view.widget.ItemView;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.pf, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentSecretQuestionUnbindBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0689pf extends AbstractC0678of {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f8689b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f8690c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinearLayout f8691d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ItemView f8692e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final LinearLayout f8693f;
    private final TextView g;
    private final EditText h;
    private final TextView i;
    private final Button j;
    private long k;

    public C0689pf(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 7, f8689b, f8690c));
    }

    private boolean b(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 4;
        }
        return true;
    }

    private boolean c(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 2;
        }
        return true;
    }

    private boolean d(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 1;
        }
        return true;
    }

    private boolean e(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 32;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0678of
    public void a(com.disabngo.blockynexus.e.b.ga.j jVar) {
        updateRegistration(4, jVar);
        this.f8662a = jVar;
        synchronized (this) {
            this.k |= 16;
        }
        notifyPropertyChanged(428);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0108  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 376
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0689pf.executeBindings():void");
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
            this.k = 64L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return d((ObservableField) obj, i2);
        }
        if (i == 1) {
            return c((ObservableField) obj, i2);
        }
        if (i == 2) {
            return b((ObservableField) obj, i2);
        }
        if (i == 3) {
            return a((ObservableField<Boolean>) obj, i2);
        }
        if (i == 4) {
            return a((com.disabngo.blockynexus.e.b.ga.j) obj, i2);
        }
        if (i != 5) {
            return false;
        }
        return e((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (428 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.ga.j) obj);
        return true;
    }

    private C0689pf(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 6);
        this.k = -1L;
        this.f8691d = (LinearLayout) objArr[0];
        this.f8691d.setTag(null);
        this.f8692e = (ItemView) objArr[1];
        this.f8692e.setTag(null);
        this.f8693f = (LinearLayout) objArr[2];
        this.f8693f.setTag(null);
        this.g = (TextView) objArr[3];
        this.g.setTag(null);
        this.h = (EditText) objArr[4];
        this.h.setTag(null);
        this.i = (TextView) objArr[5];
        this.i.setTag(null);
        this.j = (Button) objArr[6];
        this.j.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 8;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.e.b.ga.j jVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 16;
        }
        return true;
    }
}
