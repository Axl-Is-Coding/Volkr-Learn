package com.sandboxol.videosubmit.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.e;
import androidx.databinding.d;
import cn.qqtheme.framework.widget.WheelView;
import com.sandboxol.common.binding.adapter.ImageViewBindingAdapters;
import com.sandboxol.videosubmit.BR;
import com.sandboxol.videosubmit.R;
import com.sandboxol.videosubmit.entity.Winner;

/* JADX INFO: loaded from: classes4.dex */
public class VideosubmitItemWinnerBindingImpl extends VideosubmitItemWinnerBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        sViewsWithIds.put(R.id.tv_content_1st_content, 5);
        sViewsWithIds.put(R.id.tv_content_1st_content_up, 6);
        sViewsWithIds.put(R.id.iv_content_1st_content_up_pic, 7);
    }

    public VideosubmitItemWinnerBindingImpl(d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 8, sIncludes, sViewsWithIds));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String winnerName;
        String winnerHeadUrl;
        int i;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        Winner winner = this.mWinner;
        long j2 = j & 3;
        String str2 = null;
        if (j2 != 0) {
            int i2 = R.mipmap.videosubmit_ic_1st_pic;
            if (winner != null) {
                String totalFans = winner.getTotalFans();
                String growingFans = winner.getGrowingFans();
                winnerName = winner.getWinnerName();
                winnerHeadUrl = winner.getWinnerHeadUrl();
                i = i2;
                str = totalFans;
                str2 = growingFans;
            } else {
                i = i2;
                str = null;
                winnerName = null;
                winnerHeadUrl = null;
            }
        } else {
            str = null;
            winnerName = null;
            winnerHeadUrl = null;
            i = 0;
        }
        if (j2 != 0) {
            ImageViewBindingAdapters.loadImage(this.ivContent1stContentLeft, 0, winnerHeadUrl, i, i, false, false, false, false, WheelView.DividerConfig.FILL, null);
            e.a(this.tvContent1stContentGrow, str2);
            e.a(this.tvContent1stContentName, winnerName);
            e.a(this.tvContent1stContentUpCount, str);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.mDirtyFlags != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (BR.winner != i) {
            return false;
        }
        setWinner((Winner) obj);
        return true;
    }

    @Override // com.sandboxol.videosubmit.databinding.VideosubmitItemWinnerBinding
    public void setWinner(Winner winner) {
        this.mWinner = winner;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.winner);
        super.requestRebind();
    }

    private VideosubmitItemWinnerBindingImpl(d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (ImageView) objArr[1], (ImageView) objArr[7], (TextView) objArr[5], (TextView) objArr[3], (TextView) objArr[2], (TextView) objArr[6], (TextView) objArr[4]);
        this.mDirtyFlags = -1L;
        this.ivContent1stContentLeft.setTag(null);
        this.mboundView0 = (ConstraintLayout) objArr[0];
        this.mboundView0.setTag(null);
        this.tvContent1stContentGrow.setTag(null);
        this.tvContent1stContentName.setTag(null);
        this.tvContent1stContentUpCount.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
