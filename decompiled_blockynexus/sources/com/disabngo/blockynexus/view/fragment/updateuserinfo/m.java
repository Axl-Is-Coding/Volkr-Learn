package com.disabngo.blockynexus.view.fragment.updateuserinfo;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.utils.logic.N;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.greendao.entity.User;

/* JADX INFO: compiled from: UpdateUserInfoViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class m extends OnResponseListener<User> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UpdateUserInfoViewModel f12067a;

    m(UpdateUserInfoViewModel updateUserInfoViewModel) {
        this.f12067a = updateUserInfoViewModel;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(User user) {
        AccountCenter.newInstance().sex.set(Integer.valueOf(user.getSex()));
        AccountCenter.newInstance().birthday.set(user.getBirthday());
        AccountCenter.newInstance().picUrl.set(user.getPicUrl());
        AccountCenter.putAccountInfo();
        this.f12067a.l();
        N.p();
        AppToastUtils.showShortPositiveTipToast(this.f12067a.f12048a, R.string.modify_success);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        AppToastUtils.showShortNegativeTipToast(this.f12067a.f12048a, this.f12067a.f12048a.getString(R.string.connect_error_code, Integer.valueOf(i)));
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f12067a.f12048a, i);
    }
}
