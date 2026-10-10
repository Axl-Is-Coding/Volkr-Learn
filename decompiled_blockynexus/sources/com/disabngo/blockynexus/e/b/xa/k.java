package com.disabngo.blockynexus.e.b.xa;

import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.greendao.entity.VideoInfo;
import java.util.List;

/* JADX INFO: compiled from: VideoRecommendPageListModel.java */
/* JADX INFO: loaded from: classes.dex */
class k implements com.sandboxol.greendao.a.c<List<VideoInfo>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f10330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f10331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ n f10332c;

    k(n nVar, int i, OnResponseListener onResponseListener) {
        this.f10332c = nVar;
        this.f10330a = i;
        this.f10331b = onResponseListener;
    }

    @Override // com.sandboxol.greendao.a.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(List<VideoInfo> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f10332c.f10342d = true;
        PageData pageData = new PageData();
        pageData.setPageNo(this.f10330a);
        pageData.setPageSize(list.size());
        pageData.setData(list);
        this.f10331b.onSuccess(pageData);
    }

    @Override // com.sandboxol.greendao.a.c
    public void onError(int i, String str) {
    }
}
