package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.entity.UserSignInResponse;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: compiled from: DialogActivitySignUpBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Qa extends Pa {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ViewDataBinding.b f7789d = new ViewDataBinding.b(9);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SparseIntArray f7790e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final LinearLayout f7791f;
    private final ImageView g;
    private final TextView h;
    private final LinearLayout i;
    private final Fg j;
    private final Hg k;
    private final Button l;
    private long m;

    static {
        f7789d.a(4, new String[]{"item_activity_sign_up", "item_activity_sign_up_plus"}, new int[]{6, 7}, new int[]{R.layout.item_activity_sign_up, R.layout.item_activity_sign_up_plus});
        f7790e = new SparseIntArray();
        f7790e.put(R.id.ivBanner, 8);
    }

    public Qa(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 9, f7789d, f7790e));
    }

    private boolean b(com.disabngo.blockynexus.view.dialog.a.e eVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 16;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.Pa
    public void a(com.disabngo.blockynexus.view.dialog.a.k kVar) {
        updateRegistration(0, kVar);
        this.f7761c = kVar;
        synchronized (this) {
            this.m |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00b3  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 311
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.Qa.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.m != 0) {
                return true;
            }
            return this.j.hasPendingBindings() || this.k.hasPendingBindings();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.m = 64L;
        }
        this.j.invalidateAll();
        this.k.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((com.disabngo.blockynexus.view.dialog.a.k) obj, i2);
        }
        if (i == 1) {
            return a((com.disabngo.blockynexus.view.dialog.a.e) obj, i2);
        }
        if (i == 2) {
            return a((ObservableField<String>) obj, i2);
        }
        if (i == 3) {
            return a((UserSignInResponse) obj, i2);
        }
        if (i != 4) {
            return false;
        }
        return b((com.disabngo.blockynexus.view.dialog.a.e) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(androidx.lifecycle.g gVar) {
        super.setLifecycleOwner(gVar);
        this.j.setLifecycleOwner(gVar);
        this.k.setLifecycleOwner(gVar);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.dialog.a.k) obj);
        return true;
    }

    private Qa(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 5, (DataRecyclerView) objArr[3], (ImageView) objArr[8]);
        this.m = -1L;
        this.f7759a.setTag(null);
        this.f7791f = (LinearLayout) objArr[0];
        this.f7791f.setTag(null);
        this.g = (ImageView) objArr[1];
        this.g.setTag(null);
        this.h = (TextView) objArr[2];
        this.h.setTag(null);
        this.i = (LinearLayout) objArr[4];
        this.i.setTag(null);
        this.j = (Fg) objArr[6];
        setContainedBinding(this.j);
        this.k = (Hg) objArr[7];
        setContainedBinding(this.k);
        this.l = (Button) objArr[5];
        this.l.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.view.dialog.a.k kVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 1;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.view.dialog.a.e eVar, int i) {
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
            this.m |= 4;
        }
        return true;
    }

    private boolean a(UserSignInResponse userSignInResponse, int i) {
        if (i == 0) {
            synchronized (this) {
                this.m |= 8;
            }
            return true;
        }
        if (i != 168) {
            return false;
        }
        synchronized (this) {
            this.m |= 32;
        }
        return true;
    }
}
