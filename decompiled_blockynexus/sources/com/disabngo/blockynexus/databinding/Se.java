package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.entity.GameWarmUpResponse;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;
import com.youth.banner.Banner;

/* JADX INFO: compiled from: FragmentPreheatBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Se extends Re {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f7871c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f7872d = new SparseIntArray();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RelativeLayout f7873e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ImageView f7874f;
    private final Button g;
    private final TextView h;
    private final Button i;
    private final Banner j;
    private final TextView k;
    private final DataRecyclerView l;
    private final RelativeLayout m;
    private final Button n;
    private final RelativeLayout o;
    private long p;

    static {
        f7872d.put(R.id.llTop, 11);
    }

    public Se(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 12, f7871c, f7872d));
    }

    @Override // com.disabngo.blockynexus.databinding.Re
    public void a(com.disabngo.blockynexus.e.b.U.g gVar) {
        updateRegistration(0, gVar);
        this.f7839b = gVar;
        synchronized (this) {
            this.p |= 1;
        }
        notifyPropertyChanged(443);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0082 A[PHI: r2
      0x0082: PHI (r2v4 long) = (r2v0 long), (r2v9 long) binds: [B:27:0x0064, B:37:0x007c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d8  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 401
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.Se.executeBindings():void");
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
            this.p = 128L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((com.disabngo.blockynexus.e.b.U.g) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return a((GameWarmUpResponse) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (443 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.U.g) obj);
        return true;
    }

    private Se(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2, (LinearLayout) objArr[11]);
        this.p = -1L;
        this.f7873e = (RelativeLayout) objArr[0];
        this.f7873e.setTag(null);
        this.f7874f = (ImageView) objArr[1];
        this.f7874f.setTag(null);
        this.g = (Button) objArr[10];
        this.g.setTag(null);
        this.h = (TextView) objArr[2];
        this.h.setTag(null);
        this.i = (Button) objArr[3];
        this.i.setTag(null);
        this.j = (Banner) objArr[4];
        this.j.setTag(null);
        this.k = (TextView) objArr[5];
        this.k.setTag(null);
        this.l = (DataRecyclerView) objArr[6];
        this.l.setTag(null);
        this.m = (RelativeLayout) objArr[7];
        this.m.setTag(null);
        this.n = (Button) objArr[8];
        this.n.setTag(null);
        this.o = (RelativeLayout) objArr[9];
        this.o.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.U.g gVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p |= 1;
        }
        return true;
    }

    private boolean a(GameWarmUpResponse gameWarmUpResponse, int i) {
        if (i == 0) {
            synchronized (this) {
                this.p |= 2;
            }
            return true;
        }
        if (i == 23) {
            synchronized (this) {
                this.p |= 4;
            }
            return true;
        }
        if (i == 4) {
            synchronized (this) {
                this.p |= 8;
            }
            return true;
        }
        if (i == 21) {
            synchronized (this) {
                this.p |= 16;
            }
            return true;
        }
        if (i == 17) {
            synchronized (this) {
                this.p |= 32;
            }
            return true;
        }
        if (i != 15) {
            return false;
        }
        synchronized (this) {
            this.p |= 64;
        }
        return true;
    }
}
