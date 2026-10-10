package com.scwang.smartrefresh.layout;

/* JADX INFO: compiled from: SmartRefreshLayout.java */
/* JADX INFO: loaded from: classes.dex */
class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ SmartRefreshLayout f19157a;

    f(SmartRefreshLayout smartRefreshLayout) {
        this.f19157a = smartRefreshLayout;
    }

    @Override // java.lang.Runnable
    public void run() {
        SmartRefreshLayout smartRefreshLayout = this.f19157a;
        com.scwang.smartrefresh.layout.b.b bVar = smartRefreshLayout.mLoadMoreListener;
        if (bVar != null) {
            bVar.a(smartRefreshLayout);
        } else if (smartRefreshLayout.mOnMultiPurposeListener == null) {
            smartRefreshLayout.finishLoadMore(2000);
        }
        SmartRefreshLayout smartRefreshLayout2 = this.f19157a;
        com.scwang.smartrefresh.layout.b.c cVar = smartRefreshLayout2.mOnMultiPurposeListener;
        if (cVar != null) {
            cVar.a(smartRefreshLayout2);
        }
    }
}
