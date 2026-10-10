package com.sandboxol.videosubmit.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.e;
import androidx.databinding.d;
import cn.qqtheme.framework.widget.WheelView;
import com.sandboxol.common.binding.adapter.ImageViewBindingAdapters;
import com.sandboxol.videosubmit.BR;
import com.sandboxol.videosubmit.R;
import com.sandboxol.videosubmit.entity.BGTubeInfoResponse;
import com.sandboxol.videosubmit.view.activity.VideoSubmitViewModel;

/* JADX INFO: loaded from: classes4.dex */
public class VideosubmitRwardsBindingImpl extends VideosubmitRwardsBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final TextView mboundView2;
    private final TextView mboundView3;
    private final TextView mboundView4;
    private final TextView mboundView5;

    static {
        sViewsWithIds.put(R.id.v_content_reward, 6);
        sViewsWithIds.put(R.id.tv_content_reward_tips, 7);
        sViewsWithIds.put(R.id.v_content_reward_detail_1, 8);
        sViewsWithIds.put(R.id.v_content_reward_detail_1_title, 9);
        sViewsWithIds.put(R.id.tv_content_reward_detail_1_title, 10);
        sViewsWithIds.put(R.id.tv_content_reward_detail_1_title_count, 11);
        sViewsWithIds.put(R.id.tv_content_reward_detail_1_badge, 12);
        sViewsWithIds.put(R.id.iv_add, 13);
        sViewsWithIds.put(R.id.v_content_reward_detail_2, 14);
        sViewsWithIds.put(R.id.v_content_reward_detail_2_title, 15);
        sViewsWithIds.put(R.id.tv_content_reward_detail_2_title, 16);
        sViewsWithIds.put(R.id.tv_content_reward_detail_2_title_count, 17);
        sViewsWithIds.put(R.id.tv_content_reward_detail_2_nickname, 18);
        sViewsWithIds.put(R.id.iv_add_2, 19);
        sViewsWithIds.put(R.id.v_content_reward_detail_3, 20);
        sViewsWithIds.put(R.id.v_content_reward_detail_3_title, 21);
        sViewsWithIds.put(R.id.tv_content_reward_detail_3_title, 22);
        sViewsWithIds.put(R.id.tv_content_reward_detail_3_title_count, 23);
        sViewsWithIds.put(R.id.tv_content_reward_detail_3_nickname, 24);
        sViewsWithIds.put(R.id.iv_add_3, 25);
        sViewsWithIds.put(R.id.v_content_reward_detail_4, 26);
        sViewsWithIds.put(R.id.v_content_reward_detail_4_title, 27);
        sViewsWithIds.put(R.id.tv_content_reward_detail_4_title, 28);
        sViewsWithIds.put(R.id.tv_content_reward_detail_4_title_count, 29);
        sViewsWithIds.put(R.id.tv_content_reward_detail_4_nickname, 30);
        sViewsWithIds.put(R.id.iv_add_4, 31);
    }

    public VideosubmitRwardsBindingImpl(d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 32, sIncludes, sViewsWithIds));
    }

    private boolean onChangeVideoSubmitViewModel(VideoSubmitViewModel videoSubmitViewModel, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeVideoSubmitViewModelConfigInfo(ObservableField<BGTubeInfoResponse> observableField, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String strValueOf;
        String strValueOf2;
        String str2;
        int i;
        String winnerAwardTopicUrl;
        int mostCreativeAward;
        int mostPopularAward;
        int excellentPotentialAward;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        VideoSubmitViewModel videoSubmitViewModel = this.mVideoSubmitViewModel;
        long j2 = j & 7;
        int bestEditingAward = 0;
        String str3 = null;
        if (j2 != 0) {
            int i2 = R.mipmap.videosubmit_bg_reward_person;
            updateRegistration(1, videoSubmitViewModel);
            ObservableField<BGTubeInfoResponse> observableField = videoSubmitViewModel != null ? videoSubmitViewModel.configInfo : null;
            updateRegistration(0, observableField);
            BGTubeInfoResponse bGTubeInfoResponse = observableField != null ? observableField.get() : null;
            if (bGTubeInfoResponse != null) {
                bestEditingAward = bGTubeInfoResponse.getBestEditingAward();
                mostCreativeAward = bGTubeInfoResponse.getMostCreativeAward();
                mostPopularAward = bGTubeInfoResponse.getMostPopularAward();
                excellentPotentialAward = bGTubeInfoResponse.getExcellentPotentialAward();
                winnerAwardTopicUrl = bGTubeInfoResponse.getWinnerAwardTopicUrl();
            } else {
                winnerAwardTopicUrl = null;
                mostCreativeAward = 0;
                mostPopularAward = 0;
                excellentPotentialAward = 0;
            }
            strValueOf = String.valueOf(bestEditingAward);
            String strValueOf3 = String.valueOf(mostCreativeAward);
            String strValueOf4 = String.valueOf(mostPopularAward);
            strValueOf2 = String.valueOf(excellentPotentialAward);
            str2 = winnerAwardTopicUrl;
            str = strValueOf3;
            i = i2;
            str3 = strValueOf4;
        } else {
            str = null;
            strValueOf = null;
            strValueOf2 = null;
            str2 = null;
            i = 0;
        }
        if (j2 != 0) {
            e.a(this.mboundView2, str3);
            e.a(this.mboundView3, str);
            e.a(this.mboundView4, strValueOf);
            e.a(this.mboundView5, strValueOf2);
            ImageViewBindingAdapters.loadImage(this.tvContentRewardPerson, 0, str2, i, i, false, false, false, false, WheelView.DividerConfig.FILL, null);
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
            this.mDirtyFlags = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeVideoSubmitViewModelConfigInfo((ObservableField) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return onChangeVideoSubmitViewModel((VideoSubmitViewModel) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (BR.videoSubmitViewModel != i) {
            return false;
        }
        setVideoSubmitViewModel((VideoSubmitViewModel) obj);
        return true;
    }

    @Override // com.sandboxol.videosubmit.databinding.VideosubmitRwardsBinding
    public void setVideoSubmitViewModel(VideoSubmitViewModel videoSubmitViewModel) {
        updateRegistration(1, videoSubmitViewModel);
        this.mVideoSubmitViewModel = videoSubmitViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.videoSubmitViewModel);
        super.requestRebind();
    }

    private VideosubmitRwardsBindingImpl(d dVar, View view, Object[] objArr) {
        super(dVar, view, 2, (ImageView) objArr[13], (ImageView) objArr[19], (ImageView) objArr[25], (ImageView) objArr[31], (TextView) objArr[12], (TextView) objArr[10], (TextView) objArr[11], (TextView) objArr[18], (TextView) objArr[16], (TextView) objArr[17], (TextView) objArr[24], (TextView) objArr[22], (TextView) objArr[23], (TextView) objArr[30], (TextView) objArr[28], (TextView) objArr[29], (ImageView) objArr[1], (TextView) objArr[7], (View) objArr[6], (View) objArr[8], (View) objArr[9], (View) objArr[14], (View) objArr[15], (View) objArr[20], (View) objArr[21], (View) objArr[26], (View) objArr[27]);
        this.mDirtyFlags = -1L;
        this.mboundView0 = (ConstraintLayout) objArr[0];
        this.mboundView0.setTag(null);
        this.mboundView2 = (TextView) objArr[2];
        this.mboundView2.setTag(null);
        this.mboundView3 = (TextView) objArr[3];
        this.mboundView3.setTag(null);
        this.mboundView4 = (TextView) objArr[4];
        this.mboundView4.setTag(null);
        this.mboundView5 = (TextView) objArr[5];
        this.mboundView5.setTag(null);
        this.tvContentRewardPerson.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
