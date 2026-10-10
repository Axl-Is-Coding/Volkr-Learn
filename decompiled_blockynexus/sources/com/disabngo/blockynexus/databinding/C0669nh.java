package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.nh, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ItemFriendGoodsViewBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0669nh extends AbstractC0658mh {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f8625c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f8626d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RelativeLayout f8627e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextView f8628f;
    private final TextView g;
    private long h;

    public C0669nh(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 4, f8625c, f8626d));
    }

    public void a(com.disabngo.blockynexus.view.activity.friends.G g) {
        updateRegistration(0, g);
        this.f8594b = g;
        synchronized (this) {
            this.h |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00f1  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 399
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0669nh.executeBindings():void");
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

    private C0669nh(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2, (ImageView) objArr[1]);
        this.h = -1L;
        this.f8593a.setTag(null);
        this.f8627e = (RelativeLayout) objArr[0];
        this.f8627e.setTag(null);
        this.f8628f = (TextView) objArr[2];
        this.f8628f.setTag(null);
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
