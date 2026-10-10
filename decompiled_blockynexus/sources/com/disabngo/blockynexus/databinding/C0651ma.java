package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableMap;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.fragment.main.MainFragmentViewModel;
import com.disabngo.blockynexus.view.widget.ScaleRelativeLayout;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.ma, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ContentHeader2BindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0651ma extends AbstractC0640la {
    private static final ViewDataBinding.b k = null;
    private static final SparseIntArray l = new SparseIntArray();
    private final LinearLayout m;
    private final ImageButton n;
    private final ImageView o;
    private final ImageView p;
    private final TextView q;
    private final LinearLayout r;
    private final TextView s;
    private long t;

    static {
        l.put(R.id.img0, 11);
        l.put(R.id.img1, 12);
        l.put(R.id.img2, 13);
        l.put(R.id.img3, 14);
    }

    public C0651ma(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 15, k, l));
    }

    private boolean b(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.t |= 64;
        }
        return true;
    }

    private boolean c(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.t |= 4;
        }
        return true;
    }

    private boolean d(ObservableField<Long> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.t |= 2;
        }
        return true;
    }

    private boolean e(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.t |= 16;
        }
        return true;
    }

    private boolean f(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.t |= 1;
        }
        return true;
    }

    private boolean g(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.t |= 512;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0640la
    public void a(MainFragmentViewModel mainFragmentViewModel) {
        updateRegistration(3, mainFragmentViewModel);
        this.i = mainFragmentViewModel;
        synchronized (this) {
            this.t |= 8;
        }
        notifyPropertyChanged(370);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:200:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0138  */
    /* JADX WARN: Type inference failed for: r7v10, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v9 */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 696
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0651ma.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.t != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.t = 1024L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return f((ObservableField) obj, i2);
            case 1:
                return d((ObservableField) obj, i2);
            case 2:
                return c((ObservableField) obj, i2);
            case 3:
                return a((MainFragmentViewModel) obj, i2);
            case 4:
                return e((ObservableField) obj, i2);
            case 5:
                return a((com.disabngo.blockynexus.view.activity.main.nc) obj, i2);
            case 6:
                return b((ObservableField) obj, i2);
            case 7:
                return a((ObservableField<Boolean>) obj, i2);
            case 8:
                return a((ObservableMap<String, Integer>) obj, i2);
            case 9:
                return g((ObservableField) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (370 == i) {
            a((MainFragmentViewModel) obj);
        } else {
            if (301 != i) {
                return false;
            }
            a((com.disabngo.blockynexus.view.activity.main.nc) obj);
        }
        return true;
    }

    private C0651ma(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 10, (ImageView) objArr[11], (ImageView) objArr[12], (ImageView) objArr[13], (ImageView) objArr[14], (ScaleRelativeLayout) objArr[1], (ScaleRelativeLayout) objArr[2], (ScaleRelativeLayout) objArr[4], (ScaleRelativeLayout) objArr[6]);
        this.t = -1L;
        this.f8542e.setTag(null);
        this.f8543f.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        this.m = (LinearLayout) objArr[0];
        this.m.setTag(null);
        this.n = (ImageButton) objArr[10];
        this.n.setTag(null);
        this.o = (ImageView) objArr[3];
        this.o.setTag(null);
        this.p = (ImageView) objArr[5];
        this.p.setTag(null);
        this.q = (TextView) objArr[7];
        this.q.setTag(null);
        this.r = (LinearLayout) objArr[8];
        this.r.setTag(null);
        this.s = (TextView) objArr[9];
        this.s.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0640la
    public void a(com.disabngo.blockynexus.view.activity.main.nc ncVar) {
        updateRegistration(5, ncVar);
        this.j = ncVar;
        synchronized (this) {
            this.t |= 32;
        }
        notifyPropertyChanged(301);
        super.requestRebind();
    }

    private boolean a(MainFragmentViewModel mainFragmentViewModel, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.t |= 8;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.view.activity.main.nc ncVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.t |= 32;
        }
        return true;
    }

    private boolean a(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.t |= 128;
        }
        return true;
    }

    private boolean a(ObservableMap<String, Integer> observableMap, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.t |= 256;
        }
        return true;
    }
}
