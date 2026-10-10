package com.sandboxol.videosubmit.view.activity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sandboxol.center.router.path.RouterActivityPath;
import com.sandboxol.common.base.app.BaseActivity;
import com.sandboxol.videosubmit.R;
import com.sandboxol.videosubmit.constant.VideoSubmitStringConstant;
import com.sandboxol.videosubmit.databinding.ActivityVideoSubmitBinding;

/* JADX INFO: loaded from: classes4.dex */
@Route(path = RouterActivityPath.VideoSubmit.MAIN_ACTIVITY)
public class VideoSubmitActivity extends BaseActivity<VideoSubmitViewModel, ActivityVideoSubmitBinding> {
    @Override // com.sandboxol.common.base.app.BaseActivity
    protected int getLayoutId() {
        return R.layout.activity_video_submit;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseActivity
    public void bindViewModel(ActivityVideoSubmitBinding activityVideoSubmitBinding, VideoSubmitViewModel videoSubmitViewModel) {
        activityVideoSubmitBinding.setVideoSubmitViewModel(videoSubmitViewModel);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseActivity
    public VideoSubmitViewModel getViewModel() {
        return new VideoSubmitViewModel(this, getIntent() != null ? getIntent().getBooleanExtra(VideoSubmitStringConstant.IS_SHOW_VIDEO_SUBMIT_LINK_DIALOG, false) : false, (ActivityVideoSubmitBinding) this.binding);
    }
}
