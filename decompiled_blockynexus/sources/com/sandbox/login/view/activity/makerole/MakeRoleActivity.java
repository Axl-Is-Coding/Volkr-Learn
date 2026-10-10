package com.sandbox.login.view.activity.makerole;

import com.sandbox.login.R;
import com.sandbox.login.c.AbstractC2444l;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.base.app.BaseActivity;
import com.sandboxol.common.messenger.Messenger;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes2.dex */
public class MakeRoleActivity extends BaseActivity<b, AbstractC2444l> {
    private void initMessenger() {
        Messenger.getDefault().register(this, MessageToken.TOKEN_LOGIN_FINISH, new Action0() { // from class: com.sandbox.login.view.activity.makerole.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f15968a.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseActivity
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(AbstractC2444l abstractC2444l, b bVar) {
        abstractC2444l.a(bVar);
    }

    @Override // com.sandboxol.common.base.app.BaseActivity
    protected int getLayoutId() {
        return R.layout.login_activity_role_make;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseActivity
    public b getViewModel() {
        initMessenger();
        return new b(this);
    }
}
