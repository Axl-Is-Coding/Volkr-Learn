package com.sandboxol.vip.d.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ObservableField;
import com.sandboxol.center.entity.VipSubInfo;
import com.sandboxol.center.utils.VipDataManager;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.vip.R;
import com.sandboxol.vip.b.k;
import rx.functions.Action0;

/* JADX INFO: compiled from: SubscribeValidPeriodHelpDialog.java */
/* JADX INFO: loaded from: classes4.dex */
public class f extends FullScreenDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ObservableField<String> f19068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableField<String> f19069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableField<String> f19070c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<String> f19071d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObservableField<String> f19072e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ObservableField<String> f19073f;
    public ObservableField<String> g;
    public ObservableField<String> h;
    public ReplyCommand i;

    public f(Context context) {
        super(context);
        this.f19068a = new ObservableField<>("");
        this.f19069b = new ObservableField<>("");
        this.f19070c = new ObservableField<>("");
        this.f19071d = new ObservableField<>("");
        this.f19072e = new ObservableField<>("");
        this.f19073f = new ObservableField<>("");
        this.g = new ObservableField<>("");
        this.h = new ObservableField<>("");
        this.i = new ReplyCommand(new Action0() { // from class: com.sandboxol.vip.d.a.b
            @Override // rx.functions.Action0
            public final void call() {
                this.f19064a.dismiss();
            }
        });
        initView();
        initData();
    }

    private void initData() {
        VipSubInfo vipSubInfo = VipDataManager.getInstance().getVipSubInfo();
        if (vipSubInfo != null && vipSubInfo.getPlayerInfo() != null) {
            this.f19068a.set(vipSubInfo.getPlayerInfo().getVip1ExpiredAtStr());
            this.f19069b.set(vipSubInfo.getPlayerInfo().getVip2ExpiredAtStr());
            this.f19070c.set(vipSubInfo.getPlayerInfo().getVip3ExpiredAtStr());
            this.f19071d.set(vipSubInfo.getPlayerInfo().getVip4ExpiredAtStr());
        }
        this.f19072e.set(com.sandboxol.vip.c.a.c(1));
        this.f19073f.set(com.sandboxol.vip.c.a.c(2));
        this.g.set(com.sandboxol.vip.c.a.c(3));
        this.h.set(com.sandboxol.vip.c.a.c(4));
    }

    public void initView() {
        super.init(this.context);
        k kVar = (k) androidx.databinding.e.a(LayoutInflater.from(this.context), R.layout.vip_dialog_subscribe_valid_period_help, (ViewGroup) null, false);
        setContentView(kVar.getRoot());
        kVar.a(this);
    }
}
