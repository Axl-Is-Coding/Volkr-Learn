package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableMap;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.fragment.main.MainFragmentViewModel;
import com.disabngo.blockynexus.view.widget.ScaleFrameLayout;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.ka, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ContentHeader1BindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0629ka extends AbstractC0618ja {
    private static final ViewDataBinding.b g = null;
    private static final SparseIntArray h = new SparseIntArray();
    private final LinearLayout i;
    private final ImageView j;
    private final ImageView k;
    private final TextView l;
    private long m;

    static {
        h.put(R.id.layout_title, 8);
    }

    public C0629ka(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 9, g, h));
    }

    private boolean b(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 1;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0618ja
    public void a(MainFragmentViewModel mainFragmentViewModel) {
        updateRegistration(2, mainFragmentViewModel);
        this.f8465f = mainFragmentViewModel;
        synchronized (this) {
            this.m |= 4;
        }
        notifyPropertyChanged(370);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b3 A[PHI: r2
      0x00b3: PHI (r2v5 long) = (r2v4 long), (r2v6 long) binds: [B:42:0x0088, B:56:0x00ae] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0629ka.executeBindings():void");
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
            this.m = 16L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return b((ObservableField) obj, i2);
        }
        if (i == 1) {
            return a((ObservableMap<String, Integer>) obj, i2);
        }
        if (i == 2) {
            return a((MainFragmentViewModel) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return a((ObservableField<Boolean>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (370 != i) {
            return false;
        }
        a((MainFragmentViewModel) obj);
        return true;
    }

    private C0629ka(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 4, (ScaleFrameLayout) objArr[1], (ScaleFrameLayout) objArr[2], (ScaleFrameLayout) objArr[4], (ScaleFrameLayout) objArr[6], (ConstraintLayout) objArr[8]);
        this.m = -1L;
        this.f8460a.setTag(null);
        this.f8461b.setTag(null);
        this.f8462c.setTag(null);
        this.f8463d.setTag(null);
        this.i = (LinearLayout) objArr[0];
        this.i.setTag(null);
        this.j = (ImageView) objArr[3];
        this.j.setTag(null);
        this.k = (ImageView) objArr[5];
        this.k.setTag(null);
        this.l = (TextView) objArr[7];
        this.l.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableMap<String, Integer> observableMap, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 2;
        }
        return true;
    }

    private boolean a(MainFragmentViewModel mainFragmentViewModel, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 4;
        }
        return true;
    }

    private boolean a(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 8;
        }
        return true;
    }
}
