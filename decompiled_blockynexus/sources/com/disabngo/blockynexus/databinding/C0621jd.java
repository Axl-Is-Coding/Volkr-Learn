package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.e.b.e.C0839k;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.jd, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentBindEmailBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0621jd extends AbstractC0611id {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f8472b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f8473c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinearLayout f8474d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final LinearLayout f8475e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final EditText f8476f;
    private final Button g;
    private final LinearLayout h;
    private final TextView i;
    private final EditText j;
    private final TextView k;
    private final Button l;
    private long m;

    public C0621jd(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 9, f8472b, f8473c));
    }

    private boolean b(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 4;
        }
        return true;
    }

    private boolean c(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 2;
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
            this.m |= 8;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0611id
    public void a(C0839k c0839k) {
        updateRegistration(6, c0839k);
        this.f8447a = c0839k;
        synchronized (this) {
            this.m |= 64;
        }
        notifyPropertyChanged(376);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0082 A[PHI: r2
      0x0082: PHI (r2v3 long) = (r2v0 long), (r2v11 long) binds: [B:23:0x0056, B:37:0x007c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0127  */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r13v2 */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 426
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0621jd.executeBindings():void");
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
            this.m = 128L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return d((ObservableField) obj, i2);
            case 1:
                return c((ObservableField) obj, i2);
            case 2:
                return b((ObservableField) obj, i2);
            case 3:
                return f((ObservableField) obj, i2);
            case 4:
                return e((ObservableField) obj, i2);
            case 5:
                return a((ObservableField<Boolean>) obj, i2);
            case 6:
                return a((C0839k) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (376 != i) {
            return false;
        }
        a((C0839k) obj);
        return true;
    }

    private C0621jd(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 7);
        this.m = -1L;
        this.f8474d = (LinearLayout) objArr[0];
        this.f8474d.setTag(null);
        this.f8475e = (LinearLayout) objArr[1];
        this.f8475e.setTag(null);
        this.f8476f = (EditText) objArr[2];
        this.f8476f.setTag(null);
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

    private boolean a(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 32;
        }
        return true;
    }

    private boolean a(C0839k c0839k, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 64;
        }
        return true;
    }
}
