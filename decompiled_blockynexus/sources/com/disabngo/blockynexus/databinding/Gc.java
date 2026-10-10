package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.dialog.TribeContributionDialog;
import com.sandboxol.center.entity.AccountCenter;

/* JADX INFO: compiled from: DialogTribeContributionBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Gc extends Fc {
    private static final ViewDataBinding.b k = null;
    private static final SparseIntArray l = new SparseIntArray();
    private final TextView m;
    private final TextView n;
    private long o;

    static {
        l.put(R.id.ivReduce, 6);
        l.put(R.id.ivAdd, 7);
        l.put(R.id.tvToDayLimit, 8);
        l.put(R.id.btnCancel, 9);
        l.put(R.id.btnConfirm, 10);
    }

    public Gc(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 11, k, l));
    }

    private boolean b(ObservableField<Long> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.o |= 32;
        }
        return true;
    }

    private boolean c(ObservableField<Long> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.o |= 4;
        }
        return true;
    }

    private boolean d(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.o |= 16;
        }
        return true;
    }

    private boolean e(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.o |= 8;
        }
        return true;
    }

    private boolean f(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.o |= 64;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.Fc
    public void a(TribeContributionDialog tribeContributionDialog) {
        this.j = tribeContributionDialog;
        synchronized (this) {
            this.o |= 128;
        }
        notifyPropertyChanged(491);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ca  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 429
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.Gc.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.o != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.o = 256L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return a((AccountCenter) obj, i2);
            case 1:
                return a((ObservableField<Long>) obj, i2);
            case 2:
                return c((ObservableField) obj, i2);
            case 3:
                return e((ObservableField) obj, i2);
            case 4:
                return d((ObservableField) obj, i2);
            case 5:
                return b((ObservableField) obj, i2);
            case 6:
                return f((ObservableField) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (491 != i) {
            return false;
        }
        a((TribeContributionDialog) obj);
        return true;
    }

    private Gc(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 7, (Button) objArr[9], (Button) objArr[10], (EditText) objArr[5], (ImageView) objArr[7], (ImageView) objArr[6], (LinearLayout) objArr[0], (TextView) objArr[4], (TextView) objArr[3], (TextView) objArr[8]);
        this.o = -1L;
        this.f7441c.setTag(null);
        this.f7444f.setTag(null);
        this.m = (TextView) objArr[1];
        this.m.setTag(null);
        this.n = (TextView) objArr[2];
        this.n.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(AccountCenter accountCenter, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.o |= 1;
        }
        return true;
    }

    private boolean a(ObservableField<Long> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.o |= 2;
        }
        return true;
    }
}
