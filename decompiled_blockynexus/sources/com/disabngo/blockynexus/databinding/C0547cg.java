package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.disabngo.blockynexus.R;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.cg, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentTribeTaskBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0547cg extends AbstractC0535bg {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ViewDataBinding.b f8233d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SparseIntArray f8234e = new SparseIntArray();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final LinearLayout f8235f;
    private final TextView g;
    private final RadioGroup h;
    private final ViewPager i;
    private long j;

    static {
        f8234e.put(R.id.tbTribe, 4);
        f8234e.put(R.id.tbPersonal, 5);
    }

    public C0547cg(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 6, f8233d, f8234e));
    }

    private boolean b(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.j |= 2;
        }
        return true;
    }

    private boolean c(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.j |= 1;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0535bg
    public void a(com.disabngo.blockynexus.e.b.ua.s sVar) {
        updateRegistration(2, sVar);
        this.f8199c = sVar;
        synchronized (this) {
            this.j |= 4;
        }
        notifyPropertyChanged(425);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x009c  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 232
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0547cg.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.j != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.j = 32L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return c((ObservableField) obj, i2);
        }
        if (i == 1) {
            return b((ObservableField) obj, i2);
        }
        if (i == 2) {
            return a((com.disabngo.blockynexus.e.b.ua.s) obj, i2);
        }
        if (i == 3) {
            return a((ObservableField<Integer>) obj, i2);
        }
        if (i != 4) {
            return false;
        }
        return a((ObservableList<com.disabngo.blockynexus.e.b.ua.r>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (425 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.ua.s) obj);
        return true;
    }

    private C0547cg(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 5, (AppCompatRadioButton) objArr[5], (AppCompatRadioButton) objArr[4]);
        this.j = -1L;
        this.f8235f = (LinearLayout) objArr[0];
        this.f8235f.setTag(null);
        this.g = (TextView) objArr[1];
        this.g.setTag(null);
        this.h = (RadioGroup) objArr[2];
        this.h.setTag(null);
        this.i = (ViewPager) objArr[3];
        this.i.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.ua.s sVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.j |= 4;
        }
        return true;
    }

    private boolean a(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.j |= 8;
        }
        return true;
    }

    private boolean a(ObservableList<com.disabngo.blockynexus.e.b.ua.r> observableList, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.j |= 16;
        }
        return true;
    }
}
