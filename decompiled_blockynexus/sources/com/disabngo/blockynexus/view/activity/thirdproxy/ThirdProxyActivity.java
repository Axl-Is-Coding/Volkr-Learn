package com.disabngo.blockynexus.view.activity.thirdproxy;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.A;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.LoginRegisterAccountForm;
import com.sandboxol.center.router.manager.ChannelManager;
import com.sandboxol.center.router.manager.LoginManager;
import com.sandboxol.center.router.moduleInfo.login.interfaces.ILoginListener;
import com.sandboxol.common.base.app.BaseActivity;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes2.dex */
public class ThirdProxyActivity extends BaseActivity<c, A> implements ILoginListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11124a;

    private void h() {
        Messenger.getDefault().register(this, MessageToken.TOKEN_THIRD_LOGIN_CANCEL, new Action0() { // from class: com.disabngo.blockynexus.view.activity.thirdproxy.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f11125a.g();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseActivity
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(A a2, c cVar) {
        a2.a(cVar);
    }

    public /* synthetic */ void g() {
        finish();
    }

    @Override // com.sandboxol.common.base.app.BaseActivity
    protected int getLayoutId() {
        return R.layout.activity_third_proxy_activity;
    }

    @Override // com.sandboxol.center.router.moduleInfo.login.interfaces.ILoginListener
    public void loginFailure() {
        AppToastUtils.showShortNegativeTipToast(this, R.string.account_register_failed);
        finish();
    }

    @Override // com.sandboxol.center.router.moduleInfo.login.interfaces.ILoginListener
    public void loginSuccessful(String str, String str2, String str3, String str4) {
        loginSuccessful(str, str2, "", str3, str4);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        try {
            ChannelManager.onActivityResult(i, i2, intent);
            if (i == 9002) {
                ChannelManager.handleSignInResult(intent, this, this);
            }
        } catch (Exception unused) {
            Log.e("ThirdPart", "third part login failed");
            finish();
        }
    }

    @Override // com.sandboxol.common.base.app.BaseActivity, com.sandboxol.common.base.rx.BaseRxAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        h();
        this.f11124a = getIntent().getStringExtra("platForm");
        if (TextUtils.isEmpty(this.f11124a)) {
            return;
        }
        if (this.f11124a.equals(StringConstant.THIRD_PART_LOGIN_FB)) {
            ChannelManager.facebookLogin(this, this);
        } else if (this.f11124a.equals(StringConstant.THIRD_PART_LOGIN_TW)) {
            ChannelManager.twitterLogin(this, this);
        } else if (this.f11124a.equals("gplus")) {
            ChannelManager.googleLogin(this);
        }
    }

    @Override // com.sandboxol.common.base.app.BaseActivity, com.sandboxol.common.base.rx.BaseRxAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        Messenger.getDefault().unregister(this);
        super.onDestroy();
    }

    @Override // com.sandboxol.common.base.app.BaseActivity, com.sandboxol.common.base.rx.BaseRxAppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // com.sandboxol.common.base.app.BaseActivity, com.sandboxol.common.base.rx.BaseRxAppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseActivity
    public c getViewModel() {
        return new c();
    }

    @Override // com.sandboxol.center.router.moduleInfo.login.interfaces.ILoginListener
    public void loginSuccessful(String str, String str2, String str3, String str4, String str5) {
        LoginRegisterAccountForm loginRegisterAccountForm = new LoginRegisterAccountForm();
        loginRegisterAccountForm.setUid(str);
        loginRegisterAccountForm.setPassword(str4);
        loginRegisterAccountForm.setPlatform(str5);
        LoginManager.login(this, loginRegisterAccountForm, new b(this));
    }
}
