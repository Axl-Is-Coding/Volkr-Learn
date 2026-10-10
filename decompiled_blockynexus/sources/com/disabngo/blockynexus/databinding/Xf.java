package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.TribeRank;
import com.sandboxol.center.entity.TribeCenter;

/* JADX INFO: compiled from: FragmentTribeRankBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Xf extends Wf {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ViewDataBinding.b f8033e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final SparseIntArray f8034f = new SparseIntArray();
    private final LinearLayout g;
    private final RadioGroup h;
    private final ViewPager i;
    private final LinearLayout j;
    private final TextView k;
    private final ImageView l;
    private final TextView m;
    private final TextView n;
    private long o;

    static {
        f8034f.put(R.id.rbWeek, 8);
        f8034f.put(R.id.rbMonth, 9);
        f8034f.put(R.id.rbAll, 10);
    }

    public Xf(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 11, f8033e, f8034f));
    }

    private boolean b(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.o |= 4;
        }
        return true;
    }

    private boolean c(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.o |= 64;
        }
        return true;
    }

    private boolean d(ObservableField<TribeRank> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.o |= 2;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.Wf
    public void a(com.disabngo.blockynexus.e.b.ra.n nVar) {
        updateRegistration(3, nVar);
        this.f8008d = nVar;
        synchronized (this) {
            this.o |= 8;
        }
        notifyPropertyChanged(319);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c1  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 394
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.Xf.executeBindings():void");
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
            this.o = 128L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return a((TribeCenter) obj, i2);
            case 1:
                return d((ObservableField) obj, i2);
            case 2:
                return b((ObservableField) obj, i2);
            case 3:
                return a((com.disabngo.blockynexus.e.b.ra.n) obj, i2);
            case 4:
                return a((ObservableList<com.disabngo.blockynexus.e.b.ra.l>) obj, i2);
            case 5:
                return a((ObservableField<Long>) obj, i2);
            case 6:
                return c((ObservableField) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (319 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.ra.n) obj);
        return true;
    }

    private Xf(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 7, (AppCompatRadioButton) objArr[10], (AppCompatRadioButton) objArr[9], (AppCompatRadioButton) objArr[8]);
        this.o = -1L;
        this.g = (LinearLayout) objArr[0];
        this.g.setTag(null);
        this.h = (RadioGroup) objArr[1];
        this.h.setTag(null);
        this.i = (ViewPager) objArr[2];
        this.i.setTag(null);
        this.j = (LinearLayout) objArr[3];
        this.j.setTag(null);
        this.k = (TextView) objArr[4];
        this.k.setTag(null);
        this.l = (ImageView) objArr[5];
        this.l.setTag(null);
        this.m = (TextView) objArr[6];
        this.m.setTag(null);
        this.n = (TextView) objArr[7];
        this.n.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(TribeCenter tribeCenter, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.o |= 1;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.e.b.ra.n nVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.o |= 8;
        }
        return true;
    }

    private boolean a(ObservableList<com.disabngo.blockynexus.e.b.ra.l> observableList, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.o |= 16;
        }
        return true;
    }

    private boolean a(ObservableField<Long> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.o |= 32;
        }
        return true;
    }
}
