package com.disabngo.blockynexus.view.dialog;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ObservableField;
import cn.qqtheme.framework.widget.WheelView;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0751vc;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.ScrapInfo;
import com.sandboxol.center.entity.ScrapRewardComposeInfo;
import com.sandboxol.center.entity.ScrapRewardDetails;
import com.sandboxol.center.router.manager.VipManager;
import com.sandboxol.center.view.dialog.ScrapRewardDescriptionDialog;
import com.sandboxol.center.view.dialog.TwoButtonDialog;
import com.sandboxol.center.web.ScrapApi;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;
import java.util.Iterator;
import rx.functions.Action0;

/* JADX INFO: compiled from: ScrapRewardDetailsDialog.java */
/* JADX INFO: loaded from: classes2.dex */
public class Pa extends FullScreenDialog {
    public ReplyCommand A;
    public ReplyCommand B;
    public ReplyCommand C;
    public ReplyCommand D;
    public ReplyCommand E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AbstractC0751vc f11339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ScrapRewardDetails f11340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f11341c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f11342d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f11343e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f11344f;
    private int g;
    public ObservableField<Drawable> h;
    public ObservableField<Integer> i;
    public ObservableField<Integer> j;
    public ObservableField<Integer> k;
    public ObservableField<Boolean> l;
    public ObservableField<Integer> m;
    public ObservableField<Integer> n;
    public ObservableField<Integer> o;
    public ObservableField<Integer> p;
    public ObservableField<Integer> q;
    public ObservableField<String> r;
    public ObservableField<String> s;
    public ObservableField<String> t;
    public ObservableField<String> u;
    public ObservableField<String> v;
    public ReplyCommand w;
    public ReplyCommand x;
    public ReplyCommand y;
    public ReplyCommand z;

    public Pa(Context context, ScrapRewardDetails scrapRewardDetails, String str, int i, int i2, int i3) {
        super(context);
        this.f11342d = "x";
        this.f11343e = false;
        this.h = new ObservableField<>();
        this.i = new ObservableField<>(1);
        this.j = new ObservableField<>(1);
        this.k = new ObservableField<>(0);
        this.l = new ObservableField<>(false);
        this.m = new ObservableField<>(0);
        this.n = new ObservableField<>(0);
        this.o = new ObservableField<>(0);
        this.p = new ObservableField<>(0);
        this.q = new ObservableField<>(0);
        this.r = new ObservableField<>();
        this.s = new ObservableField<>();
        this.t = new ObservableField<>();
        this.u = new ObservableField<>();
        this.v = new ObservableField<>();
        this.w = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.L
            @Override // rx.functions.Action0
            public final void call() {
                this.f11317a.b();
            }
        });
        this.x = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.P
            @Override // rx.functions.Action0
            public final void call() {
                this.f11338a.c();
            }
        });
        this.y = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.O
            @Override // rx.functions.Action0
            public final void call() {
                this.f11329a.d();
            }
        });
        this.z = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.S
            @Override // rx.functions.Action0
            public final void call() {
                this.f11368a.k();
            }
        });
        this.A = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.T
            @Override // rx.functions.Action0
            public final void call() {
                this.f11381a.e();
            }
        });
        this.B = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.K
            @Override // rx.functions.Action0
            public final void call() {
                this.f11315a.f();
            }
        });
        this.C = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.M
            @Override // rx.functions.Action0
            public final void call() {
                this.f11319a.g();
            }
        });
        this.D = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.N
            @Override // rx.functions.Action0
            public final void call() {
                this.f11321a.h();
            }
        });
        this.E = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.dialog.Q
            @Override // rx.functions.Action0
            public final void call() {
                this.f11347a.i();
            }
        });
        this.f11340b = scrapRewardDetails;
        this.f11341c = str;
        this.j.set(Integer.valueOf(i));
        this.f11344f = i2;
        this.g = i3;
        initView();
        initData();
        ReportDataAdapter.onEvent(context, EventConstant.ENTER_ITEM_PAGE);
    }

    private void initData() {
        ScrapRewardDetails scrapRewardDetails = this.f11340b;
        if (scrapRewardDetails == null || scrapRewardDetails.getScrapResponses() == null || this.f11340b.getScrapResponses().size() == 0) {
            return;
        }
        this.i.set(Integer.valueOf(this.f11340b.getScrapResponses().size()));
        ScrapRewardDetails scrapRewardDetails2 = this.f11340b;
        if (scrapRewardDetails2 != null && scrapRewardDetails2.getScrapResponses() != null) {
            for (int i = 0; i < this.f11340b.getScrapResponses().size(); i++) {
                if (i == 0) {
                    this.r.set(this.f11340b.getScrapResponses().get(i).getScrapPic());
                } else if (i == 1) {
                    this.s.set(this.f11340b.getScrapResponses().get(i).getScrapPic());
                } else if (i == 2) {
                    this.t.set(this.f11340b.getScrapResponses().get(i).getScrapPic());
                } else if (i == 3) {
                    this.u.set(this.f11340b.getScrapResponses().get(i).getScrapPic());
                } else if (i == 4) {
                    this.v.set(this.f11340b.getScrapResponses().get(i).getScrapPic());
                }
            }
            j();
        }
        int size = this.f11340b.getScrapResponses().size();
        if (size == 1) {
            this.n.set(-1);
            this.o.set(-1);
            this.p.set(-1);
            this.q.set(-1);
        } else if (size == 2) {
            this.o.set(-1);
            this.p.set(-1);
            this.q.set(-1);
        } else if (size == 3) {
            this.p.set(-1);
            this.q.set(-1);
        } else if (size == 4) {
            this.q.set(-1);
        }
        n();
        m();
        l();
    }

    private void initView() {
        this.f11339a = (AbstractC0751vc) androidx.databinding.e.a(LayoutInflater.from(this.context), R.layout.dialog_scrap_reward_details, (ViewGroup) null, false);
        this.f11339a.a(this);
        setContentView(this.f11339a.getRoot());
        AbstractC0751vc abstractC0751vc = this.f11339a;
        setInnerViews(abstractC0751vc.f8897b, abstractC0751vc.h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        ScrapRewardDetails scrapRewardDetails = this.f11340b;
        if (scrapRewardDetails != null) {
            new ScrapRewardDescriptionDialog(this.context, scrapRewardDetails.getCardName(), this.f11340b.getCardDesc(), this.f11340b.getCardValue(), false).show();
        }
    }

    private void l() {
        if (SharedUtils.getBoolean(this.context, AccountCenter.newInstance().userId.get() + StringConstant.KEY_HAS_SHOW_SCRAP_DETAILS_GUIDE, false)) {
            return;
        }
        this.l.set(true);
    }

    private void m() {
        ScrapRewardDetails scrapRewardDetails = this.f11340b;
        if (scrapRewardDetails == null || scrapRewardDetails.getScrapResponses() == null) {
            return;
        }
        for (int i = 0; i < this.f11340b.getScrapResponses().size(); i++) {
            if (i == 0) {
                this.m.set(Integer.valueOf(this.f11340b.getScrapResponses().get(i).getScrapNum()));
            } else if (i == 1) {
                this.n.set(Integer.valueOf(this.f11340b.getScrapResponses().get(i).getScrapNum()));
            } else if (i == 2) {
                this.o.set(Integer.valueOf(this.f11340b.getScrapResponses().get(i).getScrapNum()));
            } else if (i == 3) {
                this.p.set(Integer.valueOf(this.f11340b.getScrapResponses().get(i).getScrapNum()));
            } else if (i == 4) {
                this.q.set(Integer.valueOf(this.f11340b.getScrapResponses().get(i).getScrapNum()));
            }
        }
        j();
    }

    private void n() {
        int iIntValue = this.i.get().intValue();
        if (iIntValue == 1) {
            this.h.set(androidx.core.content.b.c(this.context, R.mipmap.app_bg_scrap_path_1));
            return;
        }
        if (iIntValue == 2) {
            this.h.set(androidx.core.content.b.c(this.context, R.mipmap.app_bg_scrap_path_2));
            return;
        }
        if (iIntValue == 3) {
            this.h.set(androidx.core.content.b.c(this.context, R.mipmap.app_bg_scrap_path_3));
        } else if (iIntValue == 4) {
            this.h.set(androidx.core.content.b.c(this.context, R.mipmap.app_bg_scrap_path_4));
        } else {
            if (iIntValue != 5) {
                return;
            }
            this.h.set(androidx.core.content.b.c(this.context, R.mipmap.app_bg_scrap_path));
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.f11339a.y.clearAnimation();
        this.f11339a.j.clearAnimation();
        super.onDetachedFromWindow();
    }

    private void j() {
        ScrapRewardDetails scrapRewardDetails = this.f11340b;
        if (scrapRewardDetails == null || scrapRewardDetails.getScrapResponses() == null) {
            return;
        }
        int scrapNum = this.f11340b.getScrapResponses().get(0).getScrapNum();
        for (ScrapInfo scrapInfo : this.f11340b.getScrapResponses()) {
            if (scrapInfo.getScrapNum() < scrapNum) {
                scrapNum = scrapInfo.getScrapNum();
            }
        }
        this.k.set(Integer.valueOf(scrapNum));
    }

    public /* synthetic */ void c() {
        b(true);
    }

    public /* synthetic */ void d() {
        b(false);
    }

    public /* synthetic */ void e() {
        a(0);
    }

    public /* synthetic */ void f() {
        a(1);
    }

    public /* synthetic */ void g() {
        a(2);
    }

    public /* synthetic */ void h() {
        a(3);
    }

    public /* synthetic */ void i() {
        a(4);
    }

    private void c(boolean z) {
        this.f11343e = true;
        ScrapApi.combineScrap(this.context, this.f11341c, z ? 1 : this.k.get().intValue(), new Ja(this, z));
    }

    public /* synthetic */ void b() {
        dismiss();
    }

    private void b(boolean z) {
        if (this.j.get().intValue() >= 5 && AccountCenter.newInstance().vip.get().intValue() < 1) {
            new TwoButtonDialog(this.context).setDetailText(R.string.base_scrap_reward_compose_tip).setRightButtonText(R.string.vip_buy).setListener(new TwoButtonDialog.OnTwoButtonDialogClickListener() { // from class: com.disabngo.blockynexus.view.dialog.U
                @Override // com.sandboxol.center.view.dialog.TwoButtonDialog.OnTwoButtonDialogClickListener
                public final void onClick() {
                    this.f11397a.a();
                }
            }).show();
            VipManager.reportVipSubWin(this.context);
        } else {
            if (this.f11343e) {
                return;
            }
            ReportDataAdapter.onEvent(this.context, EventConstant.CLICK_REDEEM_ITEM);
            if (this.f11344f == 2) {
                Context context = this.context;
                AppToastUtils.showShortNegativeTipToast(context, context.getString(R.string.app_scrap_status_tips_2));
            } else {
                c(z);
            }
        }
    }

    public /* synthetic */ void a() {
        VipManager.showSubscribeDialog(this.context);
    }

    private void a(int i) {
        ScrapRewardDetails scrapRewardDetails = this.f11340b;
        if (scrapRewardDetails == null || scrapRewardDetails.getScrapResponses() == null) {
            return;
        }
        ReportDataAdapter.onEvent(this.context, EventConstant.CLICK_ITEM_PART);
        if (TextUtils.isEmpty(this.f11340b.getScrapResponses().get(i).getScrapId())) {
            ReportDataAdapter.onEvent(this.context, "RewardDetails");
        }
        new com.disabngo.blockynexus.view.dialog.g.e(this.context, i + 1, this.j.get().intValue(), this.f11340b.getScrapResponses().get(i), this.f11340b.getScrapResponses().get(i).getScrapId(), this.f11340b.getScrapResponses().get(i).getScrapDesc()).show();
        this.l.set(false);
        SharedUtils.putBoolean(this.context, AccountCenter.newInstance().userId.get() + StringConstant.KEY_HAS_SHOW_SCRAP_DETAILS_GUIDE, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, ScrapRewardComposeInfo scrapRewardComposeInfo) {
        this.f11339a.y.animate().scaleY(WheelView.DividerConfig.FILL).setListener(new Oa(this, scrapRewardComposeInfo, z)).setDuration(10L).start();
    }

    private void b(int i) {
        ScrapRewardDetails scrapRewardDetails = this.f11340b;
        if (scrapRewardDetails == null || scrapRewardDetails.getScrapResponses() == null) {
            return;
        }
        for (int i2 = 0; i2 < i; i2++) {
            Iterator<ScrapInfo> it = this.f11340b.getScrapResponses().iterator();
            while (it.hasNext()) {
                it.next().setScrapNum(r3.getScrapNum() - 1);
            }
        }
        m();
        for (int i3 = 0; i3 < 5; i3++) {
            Messenger.getDefault().send(RefreshMsg.create(), MessageToken.TOKEN_REFRESH_SCRAP_LIST + i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        this.f11339a.y.setVisibility(4);
        this.f11339a.f8900e.setVisibility(0);
        b(z ? 1 : this.k.get().intValue());
    }
}
