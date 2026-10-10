package com.disabngo.blockynexus.view.fragment.main;

import com.sandboxol.common.widget.rv.helper.ItemEnterOrExitVisibleHelper;

/* JADX INFO: compiled from: MainFragmentViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class I implements ItemEnterOrExitVisibleHelper.OnScrollStatusListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MainFragmentViewModel f11773a;

    I(MainFragmentViewModel mainFragmentViewModel) {
        this.f11773a = mainFragmentViewModel;
    }

    @Override // com.sandboxol.common.widget.rv.helper.ItemEnterOrExitVisibleHelper.OnScrollStatusListener
    public void onSelectEnterPosition(int i) {
        if (i == 2) {
            com.disabngo.blockynexus.d.n.m(this.f11773a.context);
            this.f11773a.isShowMainFollowFriend = true;
            this.f11773a.startTimer();
        }
    }

    @Override // com.sandboxol.common.widget.rv.helper.ItemEnterOrExitVisibleHelper.OnScrollStatusListener
    public void onSelectExitPosition(int i) {
        if (i == 2) {
            this.f11773a.isShowMainFollowFriend = false;
            this.f11773a.stopTimer();
        }
    }
}
