package com.sandboxol.videosubmit.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import androidx.lifecycle.g;
import com.sandboxol.videosubmit.BR;
import com.sandboxol.videosubmit.R;
import com.sandboxol.videosubmit.entity.BGTubeInfoResponse;
import com.sandboxol.videosubmit.view.activity.VideoSubmitViewModel;

/* JADX INFO: loaded from: classes4.dex */
public class ActivityVideoSubmitBindingImpl extends ActivityVideoSubmitBinding {
    private static final ViewDataBinding.b sIncludes = new ViewDataBinding.b(49);
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final CoordinatorLayout mboundView0;
    private final ConstraintLayout mboundView1;
    private final ImageView mboundView10;
    private final ImageView mboundView11;
    private final Button mboundView12;
    private final Button mboundView13;
    private final TextView mboundView3;
    private final TextView mboundView5;
    private final ImageView mboundView9;

    static {
        sIncludes.a(1, new String[]{"videosubmit_event_rules", "videosubmit_rwards", "videosubmit_games", "videosubmit_video_themes", "videosubmit_tips", "videosubmit_winners"}, new int[]{14, 15, 16, 17, 18, 19}, new int[]{R.layout.videosubmit_event_rules, R.layout.videosubmit_rwards, R.layout.videosubmit_games, R.layout.videosubmit_video_themes, R.layout.videosubmit_tips, R.layout.videosubmit_winners});
        sViewsWithIds = new SparseIntArray();
        sViewsWithIds.put(R.id.ns_content, 20);
        sViewsWithIds.put(R.id.v_content, 21);
        sViewsWithIds.put(R.id.v_content_awards, 22);
        sViewsWithIds.put(R.id.tv_content_games, 23);
        sViewsWithIds.put(R.id.im_title_reward, 24);
        sViewsWithIds.put(R.id.tv_content_total_cubes, 25);
        sViewsWithIds.put(R.id.v_content_games, 26);
        sViewsWithIds.put(R.id.tv_content_award_in_game_title, 27);
        sViewsWithIds.put(R.id.tv_content_award_in_game_nickname, 28);
        sViewsWithIds.put(R.id.tv_content_award_in_game_effects, 29);
        sViewsWithIds.put(R.id.tv_content_award_in_game_badge, 30);
        sViewsWithIds.put(R.id.v_content_plan, 31);
        sViewsWithIds.put(R.id.tv_content_plan_title, 32);
        sViewsWithIds.put(R.id.v_content_plan_divide, 33);
        sViewsWithIds.put(R.id.v_content_process, 34);
        sViewsWithIds.put(R.id.tv_content_process_title, 35);
        sViewsWithIds.put(R.id.v_content_process_item_1, 36);
        sViewsWithIds.put(R.id.iv_content_process_item_1_left, 37);
        sViewsWithIds.put(R.id.tv_content_process_item_1_left, 38);
        sViewsWithIds.put(R.id.v_content_time_detail_arrow_1, 39);
        sViewsWithIds.put(R.id.v_content_process_item_2, 40);
        sViewsWithIds.put(R.id.iv_content_process_item_2_left, 41);
        sViewsWithIds.put(R.id.tv_content_process_item_2_left, 42);
        sViewsWithIds.put(R.id.v_content_time_detail_arrow_2, 43);
        sViewsWithIds.put(R.id.v_content_process_item_3, 44);
        sViewsWithIds.put(R.id.iv_content_process_item_3_left, 45);
        sViewsWithIds.put(R.id.tv_content_process_item_3_left, 46);
        sViewsWithIds.put(R.id.v_content_signup_tips, 47);
        sViewsWithIds.put(R.id.v_bottom, 48);
    }

    public ActivityVideoSubmitBindingImpl(d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 49, sIncludes, sViewsWithIds));
    }

    private boolean onChangeVAward(VideosubmitRwardsBinding videosubmitRwardsBinding, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeVEventRules(VideosubmitEventRulesBinding videosubmitEventRulesBinding, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
        }
        return true;
    }

    private boolean onChangeVGames(VideosubmitGamesBinding videosubmitGamesBinding, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeVThemes(VideosubmitVideoThemesBinding videosubmitVideoThemesBinding, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeVTips(VideosubmitTipsBinding videosubmitTipsBinding, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        return true;
    }

    private boolean onChangeVWinners(VideosubmitWinnersBinding videosubmitWinnersBinding, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeVideoSubmitViewModel(VideoSubmitViewModel videoSubmitViewModel, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    private boolean onChangeVideoSubmitViewModelAwardDate(ObservableField<String> observableField, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeVideoSubmitViewModelConfigInfo(ObservableField<BGTubeInfoResponse> observableField, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        return true;
    }

    private boolean onChangeVideoSubmitViewModelHeadUri(ObservableField<String> observableField, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeVideoSubmitViewModelProfitRules(ObservableField<String> observableField, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeVideoSubmitViewModelSignUpStatus(ObservableField<Integer> observableField, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1024;
        }
        return true;
    }

    private boolean onChangeVideoSubmitViewModelSubmissionEndTime(ObservableField<String> observableField, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        return true;
    }

    private boolean onChangeVideoSubmitViewModelSubmissionStartTime(ObservableField<String> observableField, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00fe  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 806
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.videosubmit.databinding.ActivityVideoSubmitBindingImpl.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
            return this.vEventRules.hasPendingBindings() || this.vAward.hasPendingBindings() || this.vGames.hasPendingBindings() || this.vThemes.hasPendingBindings() || this.vTips.hasPendingBindings() || this.vWinners.hasPendingBindings();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_PREPARE;
        }
        this.vEventRules.invalidateAll();
        this.vAward.invalidateAll();
        this.vGames.invalidateAll();
        this.vThemes.invalidateAll();
        this.vTips.invalidateAll();
        this.vWinners.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeVWinners((VideosubmitWinnersBinding) obj, i2);
            case 1:
                return onChangeVAward((VideosubmitRwardsBinding) obj, i2);
            case 2:
                return onChangeVideoSubmitViewModelHeadUri((ObservableField) obj, i2);
            case 3:
                return onChangeVThemes((VideosubmitVideoThemesBinding) obj, i2);
            case 4:
                return onChangeVGames((VideosubmitGamesBinding) obj, i2);
            case 5:
                return onChangeVideoSubmitViewModelAwardDate((ObservableField) obj, i2);
            case 6:
                return onChangeVideoSubmitViewModelProfitRules((ObservableField) obj, i2);
            case 7:
                return onChangeVideoSubmitViewModel((VideoSubmitViewModel) obj, i2);
            case 8:
                return onChangeVideoSubmitViewModelSubmissionStartTime((ObservableField) obj, i2);
            case 9:
                return onChangeVideoSubmitViewModelConfigInfo((ObservableField) obj, i2);
            case 10:
                return onChangeVideoSubmitViewModelSignUpStatus((ObservableField) obj, i2);
            case 11:
                return onChangeVTips((VideosubmitTipsBinding) obj, i2);
            case 12:
                return onChangeVideoSubmitViewModelSubmissionEndTime((ObservableField) obj, i2);
            case 13:
                return onChangeVEventRules((VideosubmitEventRulesBinding) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(g gVar) {
        super.setLifecycleOwner(gVar);
        this.vEventRules.setLifecycleOwner(gVar);
        this.vAward.setLifecycleOwner(gVar);
        this.vGames.setLifecycleOwner(gVar);
        this.vThemes.setLifecycleOwner(gVar);
        this.vTips.setLifecycleOwner(gVar);
        this.vWinners.setLifecycleOwner(gVar);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (BR.VideoSubmitViewModel != i) {
            return false;
        }
        setVideoSubmitViewModel((VideoSubmitViewModel) obj);
        return true;
    }

    @Override // com.sandboxol.videosubmit.databinding.ActivityVideoSubmitBinding
    public void setVideoSubmitViewModel(VideoSubmitViewModel videoSubmitViewModel) {
        updateRegistration(7, videoSubmitViewModel);
        this.mVideoSubmitViewModel = videoSubmitViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        notifyPropertyChanged(BR.VideoSubmitViewModel);
        super.requestRebind();
    }

    private ActivityVideoSubmitBindingImpl(d dVar, View view, Object[] objArr) {
        super(dVar, view, 14, (ImageView) objArr[24], (ImageView) objArr[37], (ImageView) objArr[41], (ImageView) objArr[45], (ImageView) objArr[2], (NestedScrollView) objArr[20], (TextView) objArr[6], (TextView) objArr[7], (TextView) objArr[30], (TextView) objArr[29], (TextView) objArr[28], (TextView) objArr[27], (TextView) objArr[23], (TextView) objArr[4], (TextView) objArr[32], (TextView) objArr[38], (TextView) objArr[42], (TextView) objArr[46], (TextView) objArr[35], (TextView) objArr[8], (TextView) objArr[25], (VideosubmitRwardsBinding) objArr[15], (View) objArr[48], (View) objArr[21], (View) objArr[22], (View) objArr[26], (View) objArr[31], (View) objArr[33], (View) objArr[34], (View) objArr[36], (View) objArr[40], (View) objArr[44], (View) objArr[47], (View) objArr[39], (View) objArr[43], (VideosubmitEventRulesBinding) objArr[14], (VideosubmitGamesBinding) objArr[16], (VideosubmitVideoThemesBinding) objArr[17], (VideosubmitTipsBinding) objArr[18], (VideosubmitWinnersBinding) objArr[19]);
        this.mDirtyFlags = -1L;
        this.ivTitle.setTag(null);
        this.mboundView0 = (CoordinatorLayout) objArr[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (ConstraintLayout) objArr[1];
        this.mboundView1.setTag(null);
        this.mboundView10 = (ImageView) objArr[10];
        this.mboundView10.setTag(null);
        this.mboundView11 = (ImageView) objArr[11];
        this.mboundView11.setTag(null);
        this.mboundView12 = (Button) objArr[12];
        this.mboundView12.setTag(null);
        this.mboundView13 = (Button) objArr[13];
        this.mboundView13.setTag(null);
        this.mboundView3 = (TextView) objArr[3];
        this.mboundView3.setTag(null);
        this.mboundView5 = (TextView) objArr[5];
        this.mboundView5.setTag(null);
        this.mboundView9 = (ImageView) objArr[9];
        this.mboundView9.setTag(null);
        this.textView4.setTag(null);
        this.textView5.setTag(null);
        this.tvContentPlanDetail.setTag(null);
        this.tvContentSignupTips.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
