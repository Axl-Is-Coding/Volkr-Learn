package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import cn.qqtheme.framework.widget.WheelView;
import com.disabngo.blockynexus.entity.ActivityTaskActionReward;
import com.sandboxol.common.binding.adapter.ImageViewBindingAdapters;

/* JADX INFO: compiled from: ItemActivityTaskContentRewardBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Og extends Ng {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f7745b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f7746c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final RelativeLayout f7747d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ImageView f7748e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextView f7749f;
    private long g;

    public Og(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 3, f7745b, f7746c));
    }

    public void a(com.disabngo.blockynexus.view.dialog.activity.r rVar) {
        updateRegistration(0, rVar);
        this.f7718a = rVar;
        synchronized (this) {
            this.g |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        int i;
        String rewardPic;
        boolean zIsShowRewardName;
        synchronized (this) {
            j = this.g;
            this.g = 0L;
        }
        com.disabngo.blockynexus.view.dialog.activity.r rVar = this.f7718a;
        long j2 = j & 7;
        String rewardName = null;
        if (j2 != 0) {
            ActivityTaskActionReward item = rVar != null ? rVar.getItem() : null;
            if (item != null) {
                rewardName = item.getRewardName();
                rewardPic = item.getRewardPic();
                zIsShowRewardName = item.isShowRewardName();
            } else {
                rewardPic = null;
                zIsShowRewardName = false;
            }
            if (j2 != 0) {
                j |= zIsShowRewardName ? 16L : 8L;
            }
            int i2 = zIsShowRewardName ? 8 : 0;
            str = rewardName;
            i = i2;
            rewardName = rewardPic;
        } else {
            str = null;
            i = 0;
        }
        if ((j & 7) != 0) {
            ImageViewBindingAdapters.loadImage(this.f7748e, 0, rewardName, 0, 0, false, false, false, false, WheelView.DividerConfig.FILL, null);
            androidx.databinding.a.e.a(this.f7749f, str);
            this.f7749f.setVisibility(i);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.g != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.g = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.disabngo.blockynexus.view.dialog.activity.r) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.dialog.activity.r) obj);
        return true;
    }

    private Og(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.g = -1L;
        this.f7747d = (RelativeLayout) objArr[0];
        this.f7747d.setTag(null);
        this.f7748e = (ImageView) objArr[1];
        this.f7748e.setTag(null);
        this.f7749f = (TextView) objArr[2];
        this.f7749f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.view.dialog.activity.r rVar, int i) {
        if (i == 0) {
            synchronized (this) {
                this.g |= 1;
            }
            return true;
        }
        if (i != 244) {
            return false;
        }
        synchronized (this) {
            this.g |= 2;
        }
        return true;
    }
}
