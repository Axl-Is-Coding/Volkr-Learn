package com.sandboxol.recharge.dialog.rechargeshop;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ObservableField;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.StarCodeUser;
import com.sandboxol.center.router.moduleInfo.game.GameBroadcastType;
import com.sandboxol.center.web.UserApi;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.dialog.HideNavigationBarDialog;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.game.R;
import com.sandboxol.game.a.AbstractC2670i;
import com.sandboxol.messager.MessagerClient;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: RechargeShopDialog.java */
/* JADX INFO: loaded from: classes4.dex */
public class k extends HideNavigationBarDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ReplyCommand f18871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public o f18872b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AbstractC2670i f18873c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f18874d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObservableField<StarCodeUser> f18875e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ReplyCommand f18876f;
    public ReplyCommand g;
    public ReplyCommand h;
    public ReplyCommand i;
    public ReplyCommand<String> j;

    public k(Context context) {
        super(context);
        this.f18871a = new ReplyCommand(new Action0() { // from class: com.sandboxol.recharge.dialog.rechargeshop.b
            @Override // rx.functions.Action0
            public final void call() {
                this.f18862a.onClose();
            }
        });
        this.f18876f = new ReplyCommand(new Action0() { // from class: com.sandboxol.recharge.dialog.rechargeshop.d
            @Override // rx.functions.Action0
            public final void call() {
                this.f18864a.d();
            }
        });
        this.g = new ReplyCommand(new Action0() { // from class: com.sandboxol.recharge.dialog.rechargeshop.e
            @Override // rx.functions.Action0
            public final void call() {
                this.f18865a.a();
            }
        });
        this.h = new ReplyCommand(new Action0() { // from class: com.sandboxol.recharge.dialog.rechargeshop.f
            @Override // rx.functions.Action0
            public final void call() {
                this.f18866a.b();
            }
        });
        this.i = new ReplyCommand(new Action0() { // from class: com.sandboxol.recharge.dialog.rechargeshop.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f18861a.c();
            }
        });
        this.j = new ReplyCommand<>(new Action1() { // from class: com.sandboxol.recharge.dialog.rechargeshop.c
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f18863a.a((String) obj);
            }
        });
        initView();
        this.f18875e = new ObservableField<>(new StarCodeUser());
        this.f18872b = new o(context, this.f18875e, R.string.no_data, "");
        MessagerClient.getIns().sendMsg0(GameBroadcastType.ENTER_RECHARGE_PAGE_GAME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClose() {
        if (isShowing()) {
            ReportDataAdapter.onEvent(this.context, EventConstant.STAR_CLICK_GAMETP_CLOSE);
            cancel();
        }
    }

    public void initView() {
        this.f18873c = (AbstractC2670i) androidx.databinding.e.a(LayoutInflater.from(this.context), R.layout.dialog_recharge_shop, (ViewGroup) null, false);
        this.f18873c.a(this);
        setContentView(this.f18873c.getRoot());
        ReportDataAdapter.onEvent(this.context, EventConstant.STAR_GAMESHOW_TOPUP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (TextUtils.isEmpty(this.f18874d)) {
            AppToastUtils.showLongNegativeTipToast(this.context, R.string.dialog_recharge_input_et_not_empty);
        } else if (AccountCenter.newInstance().starCode.get().equals(this.f18874d)) {
            AppToastUtils.showLongNegativeTipToast(this.context, R.string.recharge_add_self);
        } else {
            ReportDataAdapter.onEvent(this.context, EventConstant.STAR_CLICK_GAMETP_ADD);
            UserApi.getStarCodeUserInfo(this.context, this.f18874d, new j(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        e();
        ReportDataAdapter.onEvent(this.context, EventConstant.STAR_CLICK_GAMETP_DELETE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        UserApi.getStarCodeConfig(this.context, new i(this));
        new StarCodeHelpPopupWindow(this.context).showLocation(this.f18873c.f17684a.f17693d);
        ReportDataAdapter.onEvent(this.context, EventConstant.STAR_CLICK_GAMETP_QMARK);
    }

    private void e() {
        this.f18875e.set(new StarCodeUser());
        this.f18873c.f17684a.g.setText(this.context.getString(R.string.dialog_recharge_tv_star_tip));
        this.f18873c.f17684a.g.setEnabled(false);
        this.f18873c.f17684a.f17691b.setVisibility(0);
        this.f18873c.f17684a.f17690a.setVisibility(0);
        this.f18873c.f17684a.f17694e.setVisibility(8);
        this.f18873c.f17684a.h.setVisibility(8);
    }

    public /* synthetic */ void a(String str) {
        this.f18874d = str;
        this.f18873c.f17684a.i.setVisibility(8);
        this.f18873c.f17684a.f17691b.getBackground().setLevel(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        e();
        ReportDataAdapter.onEvent(this.context, EventConstant.STAR_CLICK_GAMETP_HERE);
    }

    public k(Context context, String str) {
        super(context);
        this.f18871a = new ReplyCommand(new Action0() { // from class: com.sandboxol.recharge.dialog.rechargeshop.b
            @Override // rx.functions.Action0
            public final void call() {
                this.f18862a.onClose();
            }
        });
        this.f18876f = new ReplyCommand(new Action0() { // from class: com.sandboxol.recharge.dialog.rechargeshop.d
            @Override // rx.functions.Action0
            public final void call() {
                this.f18864a.d();
            }
        });
        this.g = new ReplyCommand(new Action0() { // from class: com.sandboxol.recharge.dialog.rechargeshop.e
            @Override // rx.functions.Action0
            public final void call() {
                this.f18865a.a();
            }
        });
        this.h = new ReplyCommand(new Action0() { // from class: com.sandboxol.recharge.dialog.rechargeshop.f
            @Override // rx.functions.Action0
            public final void call() {
                this.f18866a.b();
            }
        });
        this.i = new ReplyCommand(new Action0() { // from class: com.sandboxol.recharge.dialog.rechargeshop.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f18861a.c();
            }
        });
        this.j = new ReplyCommand<>(new Action1() { // from class: com.sandboxol.recharge.dialog.rechargeshop.c
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f18863a.a((String) obj);
            }
        });
        initView();
        this.f18875e = new ObservableField<>(new StarCodeUser());
        this.f18872b = new o(context, this.f18875e, R.string.no_data, str);
        MessagerClient.getIns().sendMsg0(GameBroadcastType.ENTER_RECHARGE_PAGE_GAME);
    }
}
