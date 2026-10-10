package com.sandbox.login.view.activity.makerole;

import androidx.fragment.app.AbstractC0336n;
import androidx.fragment.app.F;
import com.sandbox.login.R;
import com.sandbox.login.f.a.d.s;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.router.manager.ChannelManager;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.messenger.Messenger;

/* JADX INFO: compiled from: MakeRoleViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class b extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MakeRoleActivity f15969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private s f15970b;

    public b(MakeRoleActivity makeRoleActivity) {
        this.f15969a = makeRoleActivity;
        f();
    }

    private void f() {
        AbstractC0336n supportFragmentManager = this.f15969a.getSupportFragmentManager();
        F fA = supportFragmentManager.a();
        if (this.f15970b == null) {
            this.f15970b = new s();
            if (supportFragmentManager.a("MakeRoleFragment") == null) {
                fA.a(R.id.role_frg_con, this.f15970b, "MakeRoleFragment");
                fA.e(this.f15970b);
            }
        }
        fA.b();
        if (ChannelManager.isBeta() || AccountCenter.newInstance().hasPassword.get().booleanValue()) {
            return;
        }
        Messenger.getDefault().send(true, MessageToken.TOKEN_MAKE_ROLE_ACTIVITY_IS_EXIST);
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        super.onDestroy();
    }
}
