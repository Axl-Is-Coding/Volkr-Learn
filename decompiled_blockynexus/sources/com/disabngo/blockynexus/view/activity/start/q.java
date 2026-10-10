package com.disabngo.blockynexus.view.activity.start;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.AbstractC0336n;
import androidx.fragment.app.F;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.activity.main.bc;
import com.disabngo.blockynexus.view.activity.thirdproxy.ThirdProxyActivity;
import com.disabngo.blockynexus.view.dialog.ReportDialog;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.AppInfoCenter;
import com.sandboxol.center.entity.BlockAccountResult;
import com.sandboxol.center.entity.ReportInfo;
import com.sandboxol.center.router.manager.DressManager;
import com.sandboxol.center.router.manager.LoginManager;
import com.sandboxol.center.utils.PermissionsManager;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.common.utils.TemplateHelper;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: StartViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class q extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private StartActivity f11122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.disabngo.blockynexus.e.b.p.l f11123b;

    public q(StartActivity startActivity) {
        this.f11122a = startActivity;
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        BlockAccountResult blockAccount = AppInfoCenter.newInstance().getBlockAccount();
        if (blockAccount != null) {
            new ReportDialog(this.f11122a, blockAccount).show();
        }
    }

    private void initData() {
        new p().a(this.f11122a);
        bc bcVar = new bc();
        StartActivity startActivity = this.f11122a;
        bcVar.a(startActivity, "android", CommonHelper.getAndroidId(startActivity));
        DressManager.onCreate(BaseApplication.getContext());
    }

    private void initMessage() {
        Messenger.getDefault().register(this, MessageToken.SHOW_BLOCK_ACCOUNT_DIALOG, new Action0() { // from class: com.disabngo.blockynexus.view.activity.start.g
            @Override // rx.functions.Action0
            public final void call() {
                this.f11108a.D();
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_SEND_LOGIN_REPORT, ReportInfo.class, new Action1() { // from class: com.disabngo.blockynexus.view.activity.start.k
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f11112a.a((ReportInfo) obj);
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_GO_TO_FORGET_FRAGMENT, String.class, new Action1() { // from class: com.disabngo.blockynexus.view.activity.start.f
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f11107a.a((String) obj);
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_LOGIN_BY_GPLUS, new Action0() { // from class: com.disabngo.blockynexus.view.activity.start.h
            @Override // rx.functions.Action0
            public final void call() {
                this.f11109a.h();
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_LOGIN_BY_FACEBOOK, new Action0() { // from class: com.disabngo.blockynexus.view.activity.start.b
            @Override // rx.functions.Action0
            public final void call() {
                this.f11103a.i();
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_LOGIN_BY_TWITTER, new Action0() { // from class: com.disabngo.blockynexus.view.activity.start.i
            @Override // rx.functions.Action0
            public final void call() {
                this.f11110a.j();
            }
        });
        Messenger.getDefault().register(this, MessageToken.CLOSE_START_ACTIVITY, new Action0() { // from class: com.disabngo.blockynexus.view.activity.start.d
            @Override // rx.functions.Action0
            public final void call() {
                this.f11105a.k();
            }
        });
    }

    private void p() {
        new PermissionsManager(new io.reactivex.b.a() { // from class: com.disabngo.blockynexus.view.activity.start.j
            @Override // io.reactivex.b.a
            public final void run() throws Exception {
                this.f11111a.f();
            }
        }).a(this.f11122a);
    }

    private void u() {
        AbstractC0336n supportFragmentManager = this.f11122a.getSupportFragmentManager();
        F fA = supportFragmentManager.a();
        if (this.f11123b == null) {
            this.f11123b = new com.disabngo.blockynexus.e.b.p.l();
            if (supportFragmentManager.a("CheckUpdateFragment") == null) {
                fA.a(R.id.rlStart, this.f11123b, "CheckUpdateFragment");
                fA.e(this.f11123b);
            }
        }
        fA.b();
    }

    public /* synthetic */ void a(ReportInfo reportInfo) {
        new ReportDialog(this.f11122a, reportInfo).a(new ReportDialog.OnTwoButtonDialogClickListener() { // from class: com.disabngo.blockynexus.view.activity.start.c
            @Override // com.disabngo.blockynexus.view.dialog.ReportDialog.OnTwoButtonDialogClickListener
            public final void onClick() {
                this.f11104a.m();
            }
        }).show();
    }

    public /* synthetic */ void f() throws Exception {
        AccountCenter.getAccountInfo(new Action0() { // from class: com.disabngo.blockynexus.view.activity.start.e
            @Override // rx.functions.Action0
            public final void call() {
                this.f11106a.l();
            }
        });
    }

    public /* synthetic */ void h() {
        Intent intent = new Intent(this.f11122a, (Class<?>) ThirdProxyActivity.class);
        intent.putExtra("platForm", "gplus");
        this.f11122a.startActivity(intent);
    }

    public /* synthetic */ void i() {
        Intent intent = new Intent(this.f11122a, (Class<?>) ThirdProxyActivity.class);
        intent.putExtra("platForm", StringConstant.THIRD_PART_LOGIN_FB);
        this.f11122a.startActivity(intent);
    }

    public /* synthetic */ void j() {
        Intent intent = new Intent(this.f11122a, (Class<?>) ThirdProxyActivity.class);
        intent.putExtra("platForm", StringConstant.THIRD_PART_LOGIN_TW);
        this.f11122a.startActivity(intent);
    }

    public /* synthetic */ void k() {
        if (this.f11122a.isFinishing()) {
            return;
        }
        this.f11122a.finish();
    }

    public /* synthetic */ void l() {
        initData();
        u();
        initMessage();
    }

    public /* synthetic */ void m() {
        LoginManager.forceReLogin(this.f11122a);
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        super.onDestroy();
        Messenger.getDefault().unregister(this);
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onResume() {
        super.onResume();
        ReportDataAdapter.onEvent(this.f11122a, EventConstant.ON_RESUME_EXCEPTION, "StartViewModel");
    }

    public /* synthetic */ void a(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(StringConstant.UID, str);
        StartActivity startActivity = this.f11122a;
        TemplateHelper.startTemplate(startActivity, com.disabngo.blockynexus.e.b.w.e.class, startActivity.getString(R.string.item_view_forget_password), bundle);
    }
}
