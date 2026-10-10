package com.disabngo.blockynexus.e.b.xa;

import com.disabngo.blockynexus.web.error.VideoOnError;
import com.sandboxol.common.base.model.DefaultListModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.greendao.c.F;
import com.sandboxol.greendao.entity.VideoInfo;

/* JADX INFO: compiled from: VideoRecommendPageListModel.java */
/* JADX INFO: loaded from: classes.dex */
class l extends OnResponseListener<PageData<VideoInfo>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f10333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f10334b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ n f10335c;

    l(n nVar, int i, OnResponseListener onResponseListener) {
        this.f10335c = nVar;
        this.f10333a = i;
        this.f10334b = onResponseListener;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f10334b.onError(i, str);
        VideoOnError.showErrorTip(((DefaultListModel) this.f10335c).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f10334b.onServerError(i);
        VideoOnError.showOnServerError(((DefaultListModel) this.f10335c).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(PageData<VideoInfo> pageData) {
        if (this.f10335c.f10341c != null && pageData != null) {
            if (pageData.getTotalPage() - 1 > this.f10333a) {
                this.f10335c.f10341c.set(true);
            } else {
                this.f10335c.f10341c.set(false);
            }
            if (this.f10333a == 0) {
                this.f10335c.a((PageData<VideoInfo>) pageData);
            }
        }
        if (this.f10333a != 0 || !this.f10335c.f10342d) {
            this.f10334b.onSuccess(pageData);
        }
        n nVar = this.f10335c;
        F fB = nVar.b(nVar.f10339a);
        fB.getClass();
        fB.a(pageData.getData());
    }
}
