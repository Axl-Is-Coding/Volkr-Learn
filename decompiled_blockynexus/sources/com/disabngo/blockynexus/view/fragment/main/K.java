package com.disabngo.blockynexus.view.fragment.main;

import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.messenger.Messenger;
import java.util.TimerTask;

/* JADX INFO: compiled from: MainFragmentViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class K extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MainFragmentViewModel f11775a;

    K(MainFragmentViewModel mainFragmentViewModel) {
        this.f11775a = mainFragmentViewModel;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_REFRESH_FOLLOW_FRIENDS_LIST);
    }
}
