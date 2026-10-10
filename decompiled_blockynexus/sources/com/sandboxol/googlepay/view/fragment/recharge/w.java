package com.sandboxol.googlepay.view.fragment.recharge;

import android.content.Context;
import android.text.TextUtils;
import androidx.databinding.ObservableField;
import com.sandboxol.adsoversea.config.SharedConstant;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.StarCodeUser;
import com.sandboxol.center.router.manager.BillingManager;
import com.sandboxol.center.utils.Helper;
import com.sandboxol.center.view.dialog.OneButtonDialog;
import com.sandboxol.center.web.UserApi;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.common.widget.rv.msg.RemoveMsg;
import com.sandboxol.googlepay.R;
import com.sandboxol.googlepay.entity.RechargeInfo;
import com.sandboxol.googlepay.view.widget.StarCodeHelpPopupWindow;
import java.util.List;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: RechargeViewModel.java */
/* JADX INFO: loaded from: classes3.dex */
public class w extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f18390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.sandboxol.googlepay.a.c f18391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public o f18392c;
    private String g;
    private t o;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObservableField<Boolean> f18394e = new ObservableField<>(false);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ObservableField<Boolean> f18395f = new ObservableField<>();
    public ReplyCommand i = new ReplyCommand(new Action0() { // from class: com.sandboxol.googlepay.view.fragment.recharge.g
        @Override // rx.functions.Action0
        public final void call() {
            this.f18370a.m();
        }
    });
    public ReplyCommand j = new ReplyCommand(new Action0() { // from class: com.sandboxol.googlepay.view.fragment.recharge.j
        @Override // rx.functions.Action0
        public final void call() {
            this.f18373a.l();
        }
    });
    public ReplyCommand k = new ReplyCommand(new Action0() { // from class: com.sandboxol.googlepay.view.fragment.recharge.e
        @Override // rx.functions.Action0
        public final void call() {
            this.f18368a.i();
        }
    });
    public ReplyCommand l = new ReplyCommand(new Action0() { // from class: com.sandboxol.googlepay.view.fragment.recharge.d
        @Override // rx.functions.Action0
        public final void call() {
            this.f18367a.j();
        }
    });
    public ReplyCommand m = new ReplyCommand(new Action0() { // from class: com.sandboxol.googlepay.view.fragment.recharge.f
        @Override // rx.functions.Action0
        public final void call() {
            this.f18369a.k();
        }
    });
    public ReplyCommand<String> n = new ReplyCommand<>(new Action1() { // from class: com.sandboxol.googlepay.view.fragment.recharge.h
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f18371a.a((String) obj);
        }
    });
    public ObservableField<StarCodeUser> h = new ObservableField<>(new StarCodeUser());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public p f18393d = new p();

    public w(Context context, com.sandboxol.googlepay.a.c cVar, boolean z, String str, String str2, String str3, Boolean bool) {
        this.f18390a = context;
        this.f18391b = cVar;
        this.f18392c = new o(context, this.h, R.string.no_data);
        this.f18394e.set(bool);
        initMessenger();
        initData();
        if (z) {
            m();
        }
        if (str != null) {
            new OneButtonDialog(context).setDetailText(Helper.payResult(context, str, false)).show();
            if (str2 != null) {
                if (str.equals("failed")) {
                    ReportDataAdapter.onEvent(context, EventConstant.TOPUP_DIA_FAIL_THIRD, str2);
                } else if (str.equals("completed")) {
                    ReportDataAdapter.onEvent(context, EventConstant.TOPUP_DIA_SUC_THIRD, str2);
                }
            }
            if (str3 != null) {
                if (str.equals("failed")) {
                    ReportDataAdapter.onEvent(context, EventConstant.TOPUP_DIA_FAIL_THIRD_PM, str3);
                } else if (str.equals("completed")) {
                    ReportDataAdapter.onEvent(context, EventConstant.TOPUP_DIA_SUC_THIRD_PM, str3);
                }
            }
        }
        if (AccountCenter.newInstance().login.get().booleanValue()) {
            BillingManager.getInstance().updateUserMoney(context);
            h();
        }
    }

    private void h() {
        new t().a(this.f18390a, this.f18395f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        ReportDataAdapter.onEvent(this.f18390a, EventConstant.STAR_CLICK_PLFTOUIP_CLICKHERE);
    }

    private void initData() {
        this.o = new t();
        p();
    }

    private void initMessenger() {
        Messenger.getDefault().register(this, MessageToken.ADS_RECHARGE_GET_REWARD, new Action0() { // from class: com.sandboxol.googlepay.view.fragment.recharge.i
            @Override // rx.functions.Action0
            public final void call() {
                this.f18372a.f();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (TextUtils.isEmpty(this.g)) {
            AppToastUtils.showLongNegativeTipToast(this.f18390a, R.string.googleplay_input_et_not_empty);
        } else if (AccountCenter.newInstance().starCode.get().equals(this.g)) {
            AppToastUtils.showLongNegativeTipToast(this.f18390a, R.string.recharge_add_self);
        } else {
            ReportDataAdapter.onEvent(this.f18390a, EventConstant.STAR_CLICK_CODE_ADD);
            this.o.a(this.f18390a, this.g, new v(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        ReportDataAdapter.onEvent(this.f18390a, EventConstant.STAR_CLICK_CODE_DELETE);
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        ReportDataAdapter.onEvent(this.f18390a, EventConstant.STAR_CLICK_CODE_QMARK);
        UserApi.getStarCodeConfig(this.f18390a, new u(this));
        new StarCodeHelpPopupWindow(this.f18390a).showLocation(this.f18391b.f18186c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        ReportDataAdapter.onEvent(this.f18390a, EventConstant.CLICK_THIRDPAY);
        t tVar = this.o;
        if (tVar != null) {
            tVar.a(this.f18390a);
        }
    }

    private void p() {
        this.h.set(new StarCodeUser());
        this.f18391b.i.setText(this.f18390a.getString(R.string.googleplay_recharge_tv_star_tip));
        this.f18391b.i.setEnabled(false);
        this.f18391b.f18185b.setVisibility(0);
        this.f18391b.f18184a.setVisibility(0);
        this.f18391b.f18187d.setVisibility(8);
        this.f18391b.j.setVisibility(8);
    }

    public /* synthetic */ void f() {
        new t().a(this.f18390a, 3);
        List<RechargeInfo> data = this.f18392c.getData();
        if (!data.isEmpty() && data.get(0).isFree() && 2 == SharedUtils.getInt(this.f18390a, SharedConstant.SHOW_ADS_TIMES)) {
            Messenger.getDefault().send(RemoveMsg.createIndex(0), MessageToken.TOKEN_REMOVE_PRODUCT_LIST);
        }
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        super.onDestroy();
        Messenger.getDefault().unregister(this);
    }

    public /* synthetic */ void a(String str) {
        this.g = str;
        this.f18391b.k.setVisibility(8);
        this.f18391b.f18185b.getBackground().setLevel(0);
    }
}
