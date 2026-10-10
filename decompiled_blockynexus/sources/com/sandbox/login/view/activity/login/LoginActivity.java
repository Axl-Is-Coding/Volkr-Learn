package com.sandbox.login.view.activity.login;

import com.sandbox.login.R;
import com.sandbox.login.c.AbstractC2441i;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.router.manager.SandboxReportManager;
import com.sandboxol.center.router.moduleInfo.report.ReportEvent;
import com.sandboxol.center.router.moduleInfo.report.ReportEventType;
import com.sandboxol.common.base.app.BaseActivity;
import com.sandboxol.common.interfaces.ReportDataAdapter;

/* JADX INFO: loaded from: classes2.dex */
public class LoginActivity extends BaseActivity<D, AbstractC2441i> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f15930a;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseActivity
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(AbstractC2441i abstractC2441i, D d2) {
        abstractC2441i.a(d2);
    }

    @Override // com.sandboxol.common.base.app.BaseActivity
    protected int getLayoutId() {
        SandboxReportManager.onEvent(ReportEvent.NEW_ENTER_LOGIN_PAGE, ReportEventType.NEW_USER_BEHAVIOR, "app");
        return R.layout.login_activity_login;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f15930a) {
            super.onBackPressed();
        }
    }

    public void a(boolean z) {
        this.f15930a = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseActivity
    public D getViewModel() {
        this.f15930a = getIntent().getBooleanExtra("key.is.with.back.btn", false);
        boolean booleanExtra = getIntent().getBooleanExtra("key.is.with.register", false);
        boolean booleanExtra2 = getIntent().getBooleanExtra("key.is.fill.default.account.info", true);
        if (!this.f15930a) {
            ReportDataAdapter.onEvent(this, EventConstant.LOGINPAGE_TIME);
        }
        return new D(this, this.f15930a, (AbstractC2441i) this.binding, booleanExtra, booleanExtra2);
    }
}
