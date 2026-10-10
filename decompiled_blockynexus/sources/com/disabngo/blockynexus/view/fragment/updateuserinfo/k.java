package com.disabngo.blockynexus.view.fragment.updateuserinfo;

import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.SharedUtils;

/* JADX INFO: compiled from: UpdateUserInfoViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class k extends OnResponseListener<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UpdateUserInfoViewModel f12065a;

    k(UpdateUserInfoViewModel updateUserInfoViewModel) {
        this.f12065a = updateUserInfoViewModel;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Boolean bool) {
        if (bool.booleanValue()) {
            SharedUtils.putLong(this.f12065a.f12048a, SharedConstant.IS_REWARD_UPDATE_USER_INFO_GIFT, AccountCenter.newInstance().userId.get().longValue());
            this.f12065a.f12053f.set(false);
        } else {
            this.f12065a.l();
            this.f12065a.f12053f.set(true);
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f12065a.f12053f.set(false);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f12065a.f12053f.set(false);
    }
}
