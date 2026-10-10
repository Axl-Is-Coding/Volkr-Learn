package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.e.b.s.C0921j;
import com.disabngo.blockynexus.view.widget.ItemView;
import com.sandboxol.center.entity.AccountCenter;

/* JADX INFO: compiled from: FragmentEmailBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Jd extends Id {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f7580b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f7581c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinearLayout f7582d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final LinearLayout f7583e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ItemView f7584f;
    private final Button g;
    private final LinearLayout h;
    private final TextView i;
    private final EditText j;
    private final TextView k;
    private final Button l;
    private long m;

    public Jd(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 9, f7580b, f7581c));
    }

    private boolean b(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 128;
        }
        return true;
    }

    private boolean c(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 64;
        }
        return true;
    }

    private boolean d(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 4;
        }
        return true;
    }

    private boolean e(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 16;
        }
        return true;
    }

    private boolean f(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 1;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.Id
    public void a(C0921j c0921j) {
        updateRegistration(5, c0921j);
        this.f7546a = c0921j;
        synchronized (this) {
            this.m |= 32;
        }
        notifyPropertyChanged(406);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0142  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 577
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.Jd.executeBindings():void");
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
            this.m = 256L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return f((ObservableField) obj, i2);
            case 1:
                return a((AccountCenter) obj, i2);
            case 2:
                return d((ObservableField) obj, i2);
            case 3:
                return a((ObservableField<String>) obj, i2);
            case 4:
                return e((ObservableField) obj, i2);
            case 5:
                return a((C0921j) obj, i2);
            case 6:
                return c((ObservableField) obj, i2);
            case 7:
                return b((ObservableField) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (406 != i) {
            return false;
        }
        a((C0921j) obj);
        return true;
    }

    private Jd(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 8);
        this.m = -1L;
        this.f7582d = (LinearLayout) objArr[0];
        this.f7582d.setTag(null);
        this.f7583e = (LinearLayout) objArr[1];
        this.f7583e.setTag(null);
        this.f7584f = (ItemView) objArr[2];
        this.f7584f.setTag(null);
        this.g = (Button) objArr[3];
        this.g.setTag(null);
        this.h = (LinearLayout) objArr[4];
        this.h.setTag(null);
        this.i = (TextView) objArr[5];
        this.i.setTag(null);
        this.j = (EditText) objArr[6];
        this.j.setTag(null);
        this.k = (TextView) objArr[7];
        this.k.setTag(null);
        this.l = (Button) objArr[8];
        this.l.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(AccountCenter accountCenter, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 2;
        }
        return true;
    }

    private boolean a(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 8;
        }
        return true;
    }

    private boolean a(C0921j c0921j, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 32;
        }
        return true;
    }
}
