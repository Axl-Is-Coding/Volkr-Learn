package com.sandbox.login.f.a.d;

import android.os.Build;
import com.sandbox.login.R;
import com.sandbox.login.f.a.d.v;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.entity.AppInfoCenter;
import com.sandboxol.center.router.manager.NewSandboxReportManager;
import com.sandboxol.center.router.manager.SandboxReportManager;
import com.sandboxol.center.router.moduleInfo.report.NewReportEventType;
import com.sandboxol.center.router.moduleInfo.report.ReportEventType;
import com.sandboxol.common.messenger.Messenger;

/* JADX INFO: compiled from: MakeRoleViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class z implements v.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ E f15844a;

    z(E e2) {
        this.f15844a = e2;
    }

    @Override // com.sandbox.login.f.a.d.v.a
    public void onError(String str) {
        this.f15844a.d(str);
    }

    @Override // com.sandbox.login.f.a.d.v.a
    public void onSuccess() {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f15844a.f15805c.G.setHelperTextColor(this.f15844a.f15806d.getColorStateList(R.color.login_hint_2));
        }
        this.f15844a.f15805c.G.setHelperText(this.f15844a.f15806d.getString(R.string.login_name_fine_tips));
        if (this.f15844a.q.get().intValue() == 4) {
            this.f15844a.X();
        } else {
            if (this.f15844a.f15808f != null) {
                this.f15844a.f15808f.setPicUrl(com.sandbox.login.b.a.a(this.f15844a.g.getSex(), this.f15844a.q.get().intValue()));
            }
            this.f15844a.L();
        }
        SandboxReportManager.onEvent("new_useroage_suc", ReportEventType.NEW_USER_BEHAVIOR, "app");
        NewSandboxReportManager.onAppEvent(NewReportEventType.FUNNEL_NEW_APP_NUMBER, "new_useroage_suc");
        AppInfoCenter.newInstance().setAuthTokenSuccess(true);
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_LOGIN_FINISH);
    }
}
