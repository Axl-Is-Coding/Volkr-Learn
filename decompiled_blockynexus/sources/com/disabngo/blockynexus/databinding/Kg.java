package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import cn.qqtheme.framework.widget.WheelView;
import com.sandboxol.center.entity.SignInReward;
import com.sandboxol.common.binding.adapter.ImageViewBindingAdapters;

/* JADX INFO: compiled from: ItemActivitySignUpRewardBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Kg extends Jg {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f7616b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f7617c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final RelativeLayout f7618d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ImageView f7619e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f7620f;

    public Kg(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 2, f7616b, f7617c));
    }

    public void a(com.disabngo.blockynexus.view.dialog.a.i iVar) {
        updateRegistration(0, iVar);
        this.f7590a = iVar;
        synchronized (this) {
            this.f7620f |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f7620f;
            this.f7620f = 0L;
        }
        com.disabngo.blockynexus.view.dialog.a.i iVar = this.f7590a;
        long j2 = j & 7;
        String rewardPic = null;
        if (j2 != 0) {
            SignInReward item = iVar != null ? iVar.getItem() : null;
            if (item != null) {
                rewardPic = item.getRewardPic();
            }
        }
        String str = rewardPic;
        if (j2 != 0) {
            ImageViewBindingAdapters.loadImage(this.f7619e, 0, str, 0, 0, false, false, false, false, WheelView.DividerConfig.FILL, null);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7620f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7620f = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.disabngo.blockynexus.view.dialog.a.i) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.dialog.a.i) obj);
        return true;
    }

    private Kg(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.f7620f = -1L;
        this.f7618d = (RelativeLayout) objArr[0];
        this.f7618d.setTag(null);
        this.f7619e = (ImageView) objArr[1];
        this.f7619e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.view.dialog.a.i iVar, int i) {
        if (i == 0) {
            synchronized (this) {
                this.f7620f |= 1;
            }
            return true;
        }
        if (i != 244) {
            return false;
        }
        synchronized (this) {
            this.f7620f |= 2;
        }
        return true;
    }
}
