package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.wi, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ItemPartyFriendInfoGoodsViewBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0768wi extends AbstractC0757vi {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f8943c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f8944d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RelativeLayout f8945e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextView f8946f;
    private final TextView g;
    private long h;

    public C0768wi(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 4, f8943c, f8944d));
    }

    public void a(com.disabngo.blockynexus.view.activity.friends.G g) {
        updateRegistration(0, g);
        this.f8917b = g;
        synchronized (this) {
            this.h |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00e3  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 372
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0768wi.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.h != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.h = 128L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((com.disabngo.blockynexus.view.activity.friends.G) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return a((SingleDressInfo) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.activity.friends.G) obj);
        return true;
    }

    private C0768wi(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2, (ImageView) objArr[1]);
        this.h = -1L;
        this.f8916a.setTag(null);
        this.f8945e = (RelativeLayout) objArr[0];
        this.f8945e.setTag(null);
        this.f8946f = (TextView) objArr[2];
        this.f8946f.setTag(null);
        this.g = (TextView) objArr[3];
        this.g.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.view.activity.friends.G g, int i) {
        if (i == 0) {
            synchronized (this) {
                this.h |= 1;
            }
            return true;
        }
        if (i != 244) {
            return false;
        }
        synchronized (this) {
            this.h |= 2;
        }
        return true;
    }

    private boolean a(SingleDressInfo singleDressInfo, int i) {
        if (i == 0) {
            synchronized (this) {
                this.h |= 2;
            }
            return true;
        }
        if (i == 157) {
            synchronized (this) {
                this.h |= 4;
            }
            return true;
        }
        if (i == 130) {
            synchronized (this) {
                this.h |= 8;
            }
            return true;
        }
        if (i == 114) {
            synchronized (this) {
                this.h |= 16;
            }
            return true;
        }
        if (i == 131) {
            synchronized (this) {
                this.h |= 32;
            }
            return true;
        }
        if (i != 112) {
            return false;
        }
        synchronized (this) {
            this.h |= 64;
        }
        return true;
    }
}
