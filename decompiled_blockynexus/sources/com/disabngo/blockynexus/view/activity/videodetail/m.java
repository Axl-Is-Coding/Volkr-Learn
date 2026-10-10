package com.disabngo.blockynexus.view.activity.videodetail;

import android.content.Context;
import com.disabngo.blockynexus.web.error.VideoOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.greendao.entity.VideoDetailInfo;

/* JADX INFO: compiled from: VideoDetailModel.java */
/* JADX INFO: loaded from: classes2.dex */
class m extends OnResponseListener<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoDetailInfo f11202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f11203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ t f11204c;

    m(t tVar, VideoDetailInfo videoDetailInfo, Context context) {
        this.f11204c = tVar;
        this.f11202a = videoDetailInfo;
        this.f11203b = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        VideoOnError.showErrorTip(this.f11203b, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        VideoOnError.showOnServerError(this.f11203b, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Integer num) {
        this.f11202a.setDislikeNumber(num.intValue());
    }
}
