package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.entity.AccountCenter;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.zd, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentChatBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0796zd extends AbstractC0785yd {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ViewDataBinding.b f9040f = new ViewDataBinding.b(8);
    private static final SparseIntArray g;
    private final AbstractC0662na h;
    private final LinearLayout i;
    private final RadioGroup j;
    private final TextView k;
    private final TextView l;
    private long m;

    static {
        f9040f.a(0, new String[]{"content_header"}, new int[]{5}, new int[]{R.layout.content_header});
        g = new SparseIntArray();
        g.put(R.id.rbChat, 6);
        g.put(R.id.rbFriend, 7);
    }

    public C0796zd(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 8, f9040f, g));
    }

    private boolean b(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 128;
        }
        return true;
    }

    private boolean c(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 16;
        }
        return true;
    }

    private boolean d(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 32;
        }
        return true;
    }

    private boolean e(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 2;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0785yd
    public void a(com.disabngo.blockynexus.e.b.o.x xVar) {
        updateRegistration(2, xVar);
        this.f9012e = xVar;
        synchronized (this) {
            this.m |= 4;
        }
        notifyPropertyChanged(532);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0162 A[PHI: r2
      0x0162: PHI (r2v2 long) = (r2v1 long), (r2v13 long) binds: [B:95:0x0130, B:106:0x015c] A[DONT_GENERATE, DONT_INLINE]] */
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
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0796zd.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.m != 0) {
                return true;
            }
            return this.h.hasPendingBindings();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.m = 256L;
        }
        this.h.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return a((AccountCenter) obj, i2);
            case 1:
                return e((ObservableField) obj, i2);
            case 2:
                return a((com.disabngo.blockynexus.e.b.o.x) obj, i2);
            case 3:
                return a((com.disabngo.blockynexus.view.activity.main.nc) obj, i2);
            case 4:
                return c((ObservableField) obj, i2);
            case 5:
                return d((ObservableField) obj, i2);
            case 6:
                return a((ObservableField<Boolean>) obj, i2);
            case 7:
                return b((ObservableField) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(androidx.lifecycle.g gVar) {
        super.setLifecycleOwner(gVar);
        this.h.setLifecycleOwner(gVar);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (532 == i) {
            a((com.disabngo.blockynexus.e.b.o.x) obj);
        } else {
            if (301 != i) {
                return false;
            }
            a((com.disabngo.blockynexus.view.activity.main.nc) obj);
        }
        return true;
    }

    private C0796zd(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 8, (FrameLayout) objArr[4], (AppCompatRadioButton) objArr[6], (AppCompatRadioButton) objArr[7]);
        this.m = -1L;
        this.f9008a.setTag(null);
        this.h = (AbstractC0662na) objArr[5];
        setContainedBinding(this.h);
        this.i = (LinearLayout) objArr[0];
        this.i.setTag(null);
        this.j = (RadioGroup) objArr[1];
        this.j.setTag(null);
        this.k = (TextView) objArr[2];
        this.k.setTag(null);
        this.l = (TextView) objArr[3];
        this.l.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0785yd
    public void a(com.disabngo.blockynexus.view.activity.main.nc ncVar) {
        updateRegistration(3, ncVar);
        this.f9011d = ncVar;
        synchronized (this) {
            this.m |= 8;
        }
        notifyPropertyChanged(301);
        super.requestRebind();
    }

    private boolean a(AccountCenter accountCenter, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 1;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.e.b.o.x xVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 4;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.view.activity.main.nc ncVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 8;
        }
        return true;
    }

    private boolean a(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 64;
        }
        return true;
    }
}
