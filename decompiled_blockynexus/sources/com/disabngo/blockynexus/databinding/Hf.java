package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.view.widget.LabelsView;

/* JADX INFO: compiled from: FragmentTribeCreateBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Hf extends Gf {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ViewDataBinding.b f7524d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SparseIntArray f7525e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ScrollView f7526f;
    private final Button g;
    private final LabelsView h;
    private final EditText i;
    private final TextView j;
    private final Button k;
    private final RelativeLayout l;
    private long m;

    public Hf(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 9, f7524d, f7525e));
    }

    private boolean b(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 16;
        }
        return true;
    }

    private boolean c(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 8;
        }
        return true;
    }

    private boolean d(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 1;
        }
        return true;
    }

    private boolean e(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 32;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.Gf
    public void a(com.disabngo.blockynexus.e.b.la.n nVar) {
        updateRegistration(2, nVar);
        this.f7496c = nVar;
        synchronized (this) {
            this.m |= 4;
        }
        notifyPropertyChanged(271);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0111  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 480
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.Hf.executeBindings():void");
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
            this.m = 64L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return d((ObservableField) obj, i2);
        }
        if (i == 1) {
            return a((ObservableField<String>) obj, i2);
        }
        if (i == 2) {
            return a((com.disabngo.blockynexus.e.b.la.n) obj, i2);
        }
        if (i == 3) {
            return c((ObservableField) obj, i2);
        }
        if (i == 4) {
            return b((ObservableField) obj, i2);
        }
        if (i != 5) {
            return false;
        }
        return e((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (271 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.la.n) obj);
        return true;
    }

    private Hf(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 6, (EditText) objArr[3], (ImageView) objArr[1]);
        this.m = -1L;
        this.f7494a.setTag(null);
        this.f7495b.setTag(null);
        this.f7526f = (ScrollView) objArr[0];
        this.f7526f.setTag(null);
        this.g = (Button) objArr[2];
        this.g.setTag(null);
        this.h = (LabelsView) objArr[4];
        this.h.setTag(null);
        this.i = (EditText) objArr[5];
        this.i.setTag(null);
        this.j = (TextView) objArr[6];
        this.j.setTag(null);
        this.k = (Button) objArr[7];
        this.k.setTag(null);
        this.l = (RelativeLayout) objArr[8];
        this.l.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 2;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.e.b.la.n nVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 4;
        }
        return true;
    }
}
