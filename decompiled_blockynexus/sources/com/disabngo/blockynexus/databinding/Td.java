package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.sandboxol.center.entity.SecretQuestionInfo;

/* JADX INFO: compiled from: FragmentForgetPasswordByEmailOrQuestionBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Td extends Rd {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ViewDataBinding.b f7901f = null;
    private static final SparseIntArray g = new SparseIntArray();
    private final LinearLayout h;
    private final LinearLayout i;
    private final Button j;
    private final LinearLayout k;
    private final ImageView l;
    private final LinearLayout m;
    private final ImageView n;
    private androidx.databinding.f o;
    private long p;

    static {
        g.put(R.id.til_name, 8);
        g.put(R.id.tv_email, 9);
        g.put(R.id.tv_question, 10);
    }

    public Td(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 11, f7901f, g));
    }

    private boolean b(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p |= 4;
        }
        return true;
    }

    private boolean c(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p |= 2;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.Rd
    public void a(com.disabngo.blockynexus.e.b.w.h hVar) {
        updateRegistration(3, hVar);
        this.f7837e = hVar;
        synchronized (this) {
            this.p |= 8;
        }
        notifyPropertyChanged(290);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ae A[PHI: r2
      0x00ae: PHI (r2v5 long) = (r2v4 long), (r2v9 long) binds: [B:42:0x0082, B:56:0x00a8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e7  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 373
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.Td.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.p != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.p = 32L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((ObservableField<Boolean>) obj, i2);
        }
        if (i == 1) {
            return c((ObservableField) obj, i2);
        }
        if (i == 2) {
            return b((ObservableField) obj, i2);
        }
        if (i == 3) {
            return a((com.disabngo.blockynexus.e.b.w.h) obj, i2);
        }
        if (i != 4) {
            return false;
        }
        return a((ObservableList<SecretQuestionInfo>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (290 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.w.h) obj);
        return true;
    }

    private Td(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 5, (TextInputEditText) objArr[2], (TextInputLayout) objArr[8], (TextView) objArr[9], (TextView) objArr[10]);
        this.o = new Sd(this);
        this.p = -1L;
        this.f7833a.setTag(null);
        this.h = (LinearLayout) objArr[0];
        this.h.setTag(null);
        this.i = (LinearLayout) objArr[1];
        this.i.setTag(null);
        this.j = (Button) objArr[3];
        this.j.setTag(null);
        this.k = (LinearLayout) objArr[4];
        this.k.setTag(null);
        this.l = (ImageView) objArr[5];
        this.l.setTag(null);
        this.m = (LinearLayout) objArr[6];
        this.m.setTag(null);
        this.n = (ImageView) objArr[7];
        this.n.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p |= 1;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.e.b.w.h hVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p |= 8;
        }
        return true;
    }

    private boolean a(ObservableList<SecretQuestionInfo> observableList, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p |= 16;
        }
        return true;
    }
}
