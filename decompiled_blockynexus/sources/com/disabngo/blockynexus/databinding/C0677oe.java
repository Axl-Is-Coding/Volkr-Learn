package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.widget.GroupNoticeEditText;
import com.disabngo.blockynexus.view.widget.XEditText;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.oe, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentGroupNameBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0677oe extends AbstractC0666ne {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ViewDataBinding.b f8661f = null;
    private static final SparseIntArray g = new SparseIntArray();
    private final FrameLayout h;
    private final LinearLayout i;
    private final XEditText j;
    private final LinearLayout k;
    private long l;

    static {
        g.put(R.id.recyclerView, 7);
    }

    public C0677oe(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 8, f8661f, g));
    }

    private boolean b(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.l |= 2;
        }
        return true;
    }

    private boolean c(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.l |= 16;
        }
        return true;
    }

    private boolean d(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.l |= 1;
        }
        return true;
    }

    private boolean e(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.l |= 32;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0666ne
    public void a(com.disabngo.blockynexus.e.b.C.l lVar) {
        updateRegistration(3, lVar);
        this.f8622e = lVar;
        synchronized (this) {
            this.l |= 8;
        }
        notifyPropertyChanged(430);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00ff  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 367
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0677oe.executeBindings():void");
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
            return d((ObservableField) obj, i2);
        }
        if (i == 1) {
            return b((ObservableField) obj, i2);
        }
        if (i == 2) {
            return a((ObservableField<Boolean>) obj, i2);
        }
        if (i == 3) {
            return a((com.disabngo.blockynexus.e.b.C.l) obj, i2);
        }
        if (i == 4) {
            return c((ObservableField) obj, i2);
        }
        if (i != 5) {
            return false;
        }
        return e((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (430 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.C.l) obj);
        return true;
    }

    private C0677oe(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 6, (Button) objArr[3], (Button) objArr[6], (GroupNoticeEditText) objArr[5], (RecyclerView) objArr[7]);
        this.l = -1L;
        this.f8618a.setTag(null);
        this.f8619b.setTag(null);
        this.f8620c.setTag(null);
        this.h = (FrameLayout) objArr[0];
        this.h.setTag(null);
        this.i = (LinearLayout) objArr[1];
        this.i.setTag(null);
        this.j = (XEditText) objArr[2];
        this.j.setTag(null);
        this.k = (LinearLayout) objArr[4];
        this.k.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.l |= 4;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.e.b.C.l lVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.l |= 8;
        }
        return true;
    }
}
