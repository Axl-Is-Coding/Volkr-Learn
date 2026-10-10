package com.disabngo.blockynexus.view.activity.videodetail;

import android.content.Context;
import com.disabngo.blockynexus.web.error.VideoOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.greendao.c.Aa;
import com.sandboxol.greendao.entity.VideoDetailInfo;

/* JADX INFO: compiled from: VideoDetailModel.java */
/* JADX INFO: loaded from: classes2.dex */
class s extends OnResponseListener<VideoDetailInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f11220a;

    s(Context context) {
        this.f11220a = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(VideoDetailInfo videoDetailInfo) {
        Aa.newInstance().a(videoDetailInfo);
        t.b(this.f11220a, videoDetailInfo, (Boolean) false);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        VideoOnError.showErrorTip(this.f11220a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        VideoOnError.showOnServerError(this.f11220a, i);
    }
}
