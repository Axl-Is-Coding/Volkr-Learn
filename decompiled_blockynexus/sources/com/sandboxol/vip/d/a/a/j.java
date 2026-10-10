package com.sandboxol.vip.d.a.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ObservableField;
import com.android.billingclient.api.BillingClient;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.AppInfoCenter;
import com.sandboxol.center.router.manager.BillingManager;
import com.sandboxol.center.router.moduleInfo.pay.VipProductEntity;
import com.sandboxol.center.utils.IntentUtils;
import com.sandboxol.center.utils.VipDataManager;
import com.sandboxol.center.web.VipApi;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.vip.R;
import com.sandboxol.vip.entity.VipProductType;
import java.util.List;
import rx.functions.Action0;

/* JADX INFO: compiled from: SubscribeBottomDialog.java */
/* JADX INFO: loaded from: classes4.dex */
public class j extends FullScreenDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f19053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableField<VipProductEntity> f19054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f19055c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<Boolean> f19056d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public l f19057e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public n f19058f;
    public ReplyCommand g;
    public ReplyCommand h;
    public ReplyCommand i;
    public ReplyCommand j;

    public j(Context context, boolean z, int i, boolean z2) {
        super(context);
        this.f19054b = new ObservableField<>(new VipProductEntity());
        this.f19056d = new ObservableField<>(false);
        this.f19057e = new l();
        this.g = new ReplyCommand(new Action0() { // from class: com.sandboxol.vip.d.a.a.g
            @Override // rx.functions.Action0
            public final void call() {
                this.f19050a.dismiss();
            }
        });
        this.h = new ReplyCommand(new Action0() { // from class: com.sandboxol.vip.d.a.a.e
            @Override // rx.functions.Action0
            public final void call() {
                this.f19048a.c();
            }
        });
        this.i = new ReplyCommand(new Action0() { // from class: com.sandboxol.vip.d.a.a.d
            @Override // rx.functions.Action0
            public final void call() {
                this.f19047a.b();
            }
        });
        this.j = new ReplyCommand(new Action0() { // from class: com.sandboxol.vip.d.a.a.c
            @Override // rx.functions.Action0
            public final void call() {
                this.f19046a.d();
            }
        });
        this.f19056d.set(Boolean.valueOf(z));
        this.f19053a = i;
        this.f19055c = z2;
        initView();
        initData();
        initMessenger();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        new com.sandboxol.vip.d.a.f(this.context).show();
    }

    private void initData() {
        if (this.f19055c && VipDataManager.getInstance().getVipProductResponse() == null) {
            BillingManager.getInstance().vipSubsProductsList(this.context, new h(this));
        } else {
            this.f19056d.set(Boolean.valueOf(com.sandboxol.vip.c.a.d(this.f19053a)));
            this.f19054b.set(com.sandboxol.vip.c.a.a(this.f19056d.get().booleanValue(), this.f19053a));
        }
        this.f19058f = new n(this.context, this.f19054b);
    }

    private void initMessenger() {
        if (this.f19055c) {
            return;
        }
        Messenger.getDefault().register(this, MessageToken.TOKEN_BUY_VIP_SUBS_SUCCESS, new Action0() { // from class: com.sandboxol.vip.d.a.a.b
            @Override // rx.functions.Action0
            public final void call() {
                this.f19045a.a();
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_BUY_VIP_SUCCESS, new Action0() { // from class: com.sandboxol.vip.d.a.a.b
            @Override // rx.functions.Action0
            public final void call() {
                this.f19045a.a();
            }
        });
    }

    @Override // com.sandboxol.common.dialog.FullScreenDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        Messenger.getDefault().unregister(this);
    }

    public void initView() {
        super.init(this.context);
        com.sandboxol.vip.b.e eVar = (com.sandboxol.vip.b.e) androidx.databinding.e.a(LayoutInflater.from(this.context), R.layout.vip_dialog_subscribe_bottom, (ViewGroup) null, false);
        setContentView(eVar.getRoot());
        eVar.a(this);
        slideToUp(eVar.f18979b);
        a(eVar);
        ReportDataAdapter.onEvent(this.context, EventConstant.OPENVIPPAGE_TIMES);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        dismiss();
    }

    private void a(final com.sandboxol.vip.b.e eVar) {
        final List<Integer> vipList;
        if (this.f19053a != 4 || (vipList = AppInfoCenter.newInstance().getAppConfig().getVipList()) == null || vipList.size() <= 3) {
            return;
        }
        try {
            eVar.g.post(new Runnable() { // from class: com.sandboxol.vip.d.a.a.a
                @Override // java.lang.Runnable
                public final void run() {
                    com.sandboxol.vip.b.e eVar2 = eVar;
                    List list = vipList;
                    eVar2.g.scrollToPosition(list.size() - 1);
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        new com.sandboxol.vip.d.a.d(this.context).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (TextUtils.isEmpty(this.f19054b.get().getProductId()) || TextUtils.isEmpty(this.f19054b.get().getType())) {
            AppToastUtils.showShortNegativeTipToast(this.context, R.string.vip_subscribe_bottom_dialog_error_tip);
            return;
        }
        String str = "userId=" + AccountCenter.newInstance().userId.get();
        if (VipProductType.SUB.equals(this.f19054b.get().getType())) {
            IntentUtils.startSubsGooglePayActivity(this.context, this.f19054b.get().getProductId(), BillingClient.SkuType.SUBS, MessageToken.TOKEN_RECHARGE_PAY, str);
        } else {
            IntentUtils.startGooglePayActivity(this.context, this.f19054b.get().getProductId(), MessageToken.TOKEN_RECHARGE_PAY, str);
        }
        if (this.f19055c) {
            dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.f19056d.set(true);
        VipApi.getSubscribeInfo(this.context, new i(this));
    }
}
