package com.sandbox.login.view.fragment.register;

import android.os.Bundle;
import com.sandbox.login.R;
import com.sandbox.login.c.C;
import com.sandboxol.center.router.manager.SandboxReportManager;
import com.sandboxol.center.router.moduleInfo.report.ReportEvent;
import com.sandboxol.center.router.moduleInfo.report.ReportEventType;
import com.sandboxol.common.base.app.BaseActivity;

/* JADX INFO: loaded from: classes2.dex */
public class RegisterActivity extends BaseActivity<e, C> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseActivity
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(C c2, e eVar) {
        c2.a(eVar);
    }

    @Override // com.sandboxol.common.base.app.BaseActivity
    protected int getLayoutId() {
        return R.layout.login_fragment_register;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (((e) this.viewModel).f()) {
            ((e) this.viewModel).i();
        } else {
            if (isFinishing()) {
                return;
            }
            finish();
        }
    }

    @Override // com.sandboxol.common.base.app.BaseActivity, com.sandboxol.common.base.rx.BaseRxAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        SandboxReportManager.onEvent(ReportEvent.NEW_ENTER_USEROAGE, ReportEventType.NEW_USER_BEHAVIOR, "app");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseActivity
    public e getViewModel() {
        return new e(this);
    }
}
