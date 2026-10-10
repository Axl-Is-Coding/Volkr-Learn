package com.disabngo.blockynexus.view.activity.videodetail;

import com.disabngo.blockynexus.web.error.VideoOnError;
import com.sandboxol.common.base.model.DefaultListModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.greendao.entity.VideoInfo;

/* JADX INFO: compiled from: VideoDetailMoreListModel.java */
/* JADX INFO: loaded from: classes2.dex */
class v extends OnResponseListener<PageData<VideoInfo>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f11222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f11223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ w f11224c;

    v(w wVar, int i, OnResponseListener onResponseListener) {
        this.f11224c = wVar;
        this.f11222a = i;
        this.f11223b = onResponseListener;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f11223b.onError(i, str);
        VideoOnError.showErrorTip(((DefaultListModel) this.f11224c).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f11223b.onServerError(i);
        VideoOnError.showOnServerError(((DefaultListModel) this.f11224c).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(PageData<VideoInfo> pageData) {
        if (this.f11222a == 0 || this.f11224c.getData().isEmpty()) {
            pageData.getData().add(0, new VideoInfo(true));
        }
        this.f11223b.onSuccess(pageData);
    }
}
