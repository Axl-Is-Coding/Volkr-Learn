package com.disabngo.blockynexus.view.activity.videodetail;

import android.content.Intent;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0516a;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.common.base.app.BaseActivity;
import com.sandboxol.greendao.entity.VideoDetailInfo;

/* JADX INFO: loaded from: classes2.dex */
public class VideoDetailActivity extends BaseActivity<y, AbstractC0516a> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseActivity
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(AbstractC0516a abstractC0516a, y yVar) {
        abstractC0516a.a(yVar);
    }

    @Override // com.sandboxol.common.base.app.BaseActivity
    protected int getLayoutId() {
        return R.layout.activity_app_video_detail;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseActivity
    public y getViewModel() {
        VideoDetailInfo videoDetailInfo;
        Intent intent = getIntent();
        boolean booleanExtra = true;
        if (intent != null) {
            videoDetailInfo = (VideoDetailInfo) intent.getSerializableExtra(StringConstant.YOUTUBE_VIDEO_DETAIL_INFO);
            booleanExtra = intent.getBooleanExtra(StringConstant.YOUTUBE_VIDEO_DETAIL_IS_NEED_REFRESH, true);
        } else {
            videoDetailInfo = null;
        }
        AbstractC0516a abstractC0516a = (AbstractC0516a) this.binding;
        if (videoDetailInfo == null) {
            videoDetailInfo = new VideoDetailInfo();
        }
        return new y(this, abstractC0516a, videoDetailInfo, booleanExtra);
    }
}
