package com.sandboxol.halloween.view.fragment.exchange;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.router.manager.DressManager;
import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.halloween.R;
import com.sandboxol.halloween.entity.ExchangeResponse;
import com.sandboxol.halloween.entity.HalloweenReward;
import com.sandboxol.halloween.view.dialog.HalloweenTipsDialog;
import com.sandboxol.halloween.view.fragment.exchange.r;
import java.util.Iterator;
import java.util.List;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes4.dex */
public class ExchangeViewModel extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f18703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HalloweenReward f18704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<SingleDressInfo> f18705c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<Integer> f18706d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObservableField<Integer> f18707e = new ObservableField<>(0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ObservableField<Integer> f18708f = new ObservableField<>(0);
    public ObservableField<String> g = new ObservableField<>("");
    public ObservableField<Integer> h = new ObservableField<>(0);
    public ObservableField<Integer> i = new ObservableField<>(0);
    public ObservableField<Integer> j = new ObservableField<>(0);
    public ObservableField<Integer> k = new ObservableField<>(0);
    public ObservableField<Integer> l = new ObservableField<>(0);
    public ObservableField<Integer> m = new ObservableField<>(0);
    public ObservableField<Integer> n = new ObservableField<>(0);
    public ReplyCommand o = new ReplyCommand(new Action0() { // from class: com.sandboxol.halloween.view.fragment.exchange.m
        @Override // rx.functions.Action0
        public final void call() {
            this.f18725a.h();
        }
    });
    public ReplyCommand p = new ReplyCommand(new Action0() { // from class: com.sandboxol.halloween.view.fragment.exchange.a
        @Override // rx.functions.Action0
        public final void call() {
            this.f18709a.i();
        }
    });
    public ReplyCommand q = new ReplyCommand(new Action0() { // from class: com.sandboxol.halloween.view.fragment.exchange.d
        @Override // rx.functions.Action0
        public final void call() {
            this.f18712a.j();
        }
    });
    public ReplyCommand r = new ReplyCommand(new Action0() { // from class: com.sandboxol.halloween.view.fragment.exchange.i
        @Override // rx.functions.Action0
        public final void call() {
            this.f18719a.k();
        }
    });
    public ReplyCommand s = new ReplyCommand(new Action0() { // from class: com.sandboxol.halloween.view.fragment.exchange.l
        @Override // rx.functions.Action0
        public final void call() {
            this.f18724a.l();
        }
    });
    public ReplyCommand t = new ReplyCommand(new Action0() { // from class: com.sandboxol.halloween.view.fragment.exchange.k
        @Override // rx.functions.Action0
        public final void call() {
            this.f18723a.m();
        }
    });
    public ReplyCommand u = new ReplyCommand(new Action0() { // from class: com.sandboxol.halloween.view.fragment.exchange.f
        @Override // rx.functions.Action0
        public final void call() {
            this.f18714a.p();
        }
    });
    public ReplyCommand v = new ReplyCommand(new Action0() { // from class: com.sandboxol.halloween.view.fragment.exchange.b
        @Override // rx.functions.Action0
        public final void call() {
            this.f18710a.D();
        }
    });

    public ExchangeViewModel(Context context, ObservableField<Integer> observableField) {
        this.f18703a = context;
        this.f18706d = observableField;
        initData();
        initMessenger();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        final HalloweenReward halloweenReward;
        if (!u() || this.f18708f.get().intValue() >= com.sandboxol.halloween.c.b.b().a().getRewardList().size() || com.sandboxol.halloween.c.b.b().a().getCandyRate() <= 0 || (halloweenReward = com.sandboxol.halloween.c.b.b().a().getRewardList().get(this.f18708f.get().intValue())) == null) {
            return;
        }
        if (halloweenReward.getExchange() == 0) {
            AppToastUtils.showShortPositiveTipToast(this.f18703a, R.string.halloween_finish_tips);
            return;
        }
        if (this.f18706d.get().intValue() >= halloweenReward.getCandy()) {
            Context context = this.f18703a;
            new HalloweenTipsDialog(context, context.getString(R.string.halloween_tips), this.f18703a.getString(R.string.halloween_exchange_make_sure_tips, halloweenReward.getRewardName()), this.f18703a.getString(R.string.halloween_sure), new HalloweenTipsDialog.OnClickListener() { // from class: com.sandboxol.halloween.view.fragment.exchange.h
                @Override // com.sandboxol.halloween.view.dialog.HalloweenTipsDialog.OnClickListener
                public final void onClick() {
                    this.f18717a.a(halloweenReward);
                }
            }).show();
            return;
        }
        final int candy = halloweenReward.getCandy() - this.f18706d.get().intValue();
        int candyRate = com.sandboxol.halloween.c.b.b().a().getCandyRate() * candy;
        if (candyRate > AccountCenter.newInstance().gDiamonds.get().longValue()) {
            Messenger.getDefault().sendNoMsg("token.open.exchange.candy");
        } else {
            Context context2 = this.f18703a;
            new HalloweenTipsDialog(context2, context2.getString(R.string.halloween_tips), this.f18703a.getString(R.string.halloween_not_enough_tips, String.valueOf(candyRate), String.valueOf(candy)), this.f18703a.getString(R.string.halloween_sure), new HalloweenTipsDialog.OnClickListener() { // from class: com.sandboxol.halloween.view.fragment.exchange.j
                @Override // com.sandboxol.halloween.view.dialog.HalloweenTipsDialog.OnClickListener
                public final void onClick() {
                    this.f18720a.a(candy, halloweenReward);
                }
            }).show();
        }
    }

    private void E() {
        for (int i = 1; i < 17; i++) {
            String strA = a(i);
            if (!strA.equals("")) {
                DressManager.clothTypes(strA);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        a(this.h, 0);
        a(this.i, 1);
        a(this.j, 2);
        a(this.k, 3);
        a(this.l, 4);
        a(this.m, 5);
        a(this.n, 6);
    }

    public static String a(long j) {
        switch ((int) j) {
            case 2:
                return StringConstant.CUSTOM_HAIR_1;
            case 3:
            case 7:
            default:
                return "";
            case 4:
                return StringConstant.CUSTOM_FACE_1;
            case 5:
                return StringConstant.CUSTOM_ACTION_0;
            case 6:
                return StringConstant.CUSTOM_SKIN_0;
            case 8:
                return StringConstant.CLOTHES_TOPS_1;
            case 9:
                return StringConstant.CLOTHES_PANTS_1;
            case 10:
                return StringConstant.CUSTOM_SHOES_1;
            case 11:
                return StringConstant.CUSTOM_HAT_0;
            case 12:
                return StringConstant.CUSTOM_GLASSES_0;
            case 13:
                return StringConstant.CUSTOM_SCARF_0;
            case 14:
                return StringConstant.CUSTOM_WING_0;
            case 15:
                return StringConstant.CUSTOM_CROWN_0;
            case 16:
                return StringConstant.CUSTOM_SUITS_0;
        }
    }

    private String c(long j) {
        int i = (int) j;
        if (i == 2) {
            return StringConstant.CUSTOM_HAIR_0;
        }
        if (i == 4) {
            return StringConstant.CUSTOM_FACE_0;
        }
        switch (i) {
            case 8:
                return StringConstant.CLOTHES_TOPS_0;
            case 9:
                return StringConstant.CLOTHES_PANTS_0;
            case 10:
                return StringConstant.CUSTOM_SHOES_0;
            default:
                return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void a(HalloweenReward halloweenReward) {
        r.a(this.f18703a, halloweenReward.getRewardId(), new r.b() { // from class: com.sandboxol.halloween.view.fragment.exchange.c
            @Override // com.sandboxol.halloween.view.fragment.exchange.r.b
            public final void a(ExchangeResponse exchangeResponse) {
                this.f18711a.a(exchangeResponse);
            }
        });
    }

    private void initData() {
        if (u()) {
            int i = SharedUtils.getInt(this.f18703a, "token.choose.reward.index", 0);
            if (i >= com.sandboxol.halloween.c.b.b().a().getRewardList().size()) {
                i = 0;
            }
            this.f18708f.set(Integer.valueOf(i));
            HalloweenReward halloweenReward = com.sandboxol.halloween.c.b.b().a().getRewardList().get(i);
            if (halloweenReward != null) {
                this.g.set(halloweenReward.getRewardDesc());
                this.f18707e.set(Integer.valueOf(halloweenReward.getCandy()));
                if (halloweenReward.getRewardType().equals("decoration") || halloweenReward.getRewardType().equals("suit")) {
                    this.f18704b = halloweenReward;
                } else {
                    this.f18704b = com.sandboxol.halloween.c.b.b().a().getRewardList().get(0);
                }
            }
            F();
        }
    }

    private void initMessenger() {
        Messenger.getDefault().register(this, "token.begin.clothe", new Action0() { // from class: com.sandboxol.halloween.view.fragment.exchange.n
            @Override // rx.functions.Action0
            public final void call() {
                this.f18726a.f();
            }
        });
        Messenger.getDefault().register(this, "token.refresh.status", new Action0() { // from class: com.sandboxol.halloween.view.fragment.exchange.e
            @Override // rx.functions.Action0
            public final void call() {
                this.f18713a.F();
            }
        });
    }

    private boolean u() {
        return (com.sandboxol.halloween.c.b.b().a() == null || com.sandboxol.halloween.c.b.b().a().getRewardList() == null || com.sandboxol.halloween.c.b.b().a().getRewardList().size() <= 0) ? false : true;
    }

    public /* synthetic */ void f() {
        if (this.f18704b == null) {
            initData();
        }
        HalloweenReward halloweenReward = this.f18704b;
        if (halloweenReward != null) {
            b(halloweenReward);
        }
    }

    public /* synthetic */ void h() {
        onClickReward(0);
    }

    public /* synthetic */ void i() {
        onClickReward(1);
    }

    public /* synthetic */ void j() {
        onClickReward(2);
    }

    public /* synthetic */ void k() {
        onClickReward(3);
    }

    public /* synthetic */ void l() {
        onClickReward(4);
    }

    public /* synthetic */ void m() {
        onClickReward(5);
    }

    public void onClickReward(int i) {
        List<HalloweenReward> rewardList;
        if (com.sandboxol.halloween.c.b.b().a() != null && (rewardList = com.sandboxol.halloween.c.b.b().a().getRewardList()) != null && rewardList.size() >= 1 && i < rewardList.size()) {
            HalloweenReward halloweenReward = rewardList.get(i);
            this.f18708f.set(Integer.valueOf(i));
            SharedUtils.putInt(this.f18703a, "token.choose.reward.index", i);
            if (halloweenReward != null) {
                this.g.set(halloweenReward.getRewardDesc());
                this.f18707e.set(Integer.valueOf(halloweenReward.getCandy()));
                b(halloweenReward);
                this.f18704b = halloweenReward;
            }
        }
    }

    public /* synthetic */ void p() {
        onClickReward(6);
    }

    private void b(HalloweenReward halloweenReward) {
        if (halloweenReward.getResourceIdList() == null) {
            return;
        }
        if ("decoration".equals(halloweenReward.getRewardType()) && halloweenReward.getResourceIdList().size() > 0) {
            E();
            a(halloweenReward.getResourceIdList().get(0));
        } else if ("suit".equals(halloweenReward.getRewardType()) && halloweenReward.getResourceIdList().size() > 0) {
            E();
            Iterator<String> it = halloweenReward.getResourceIdList().iterator();
            while (it.hasNext()) {
                DressManager.clothTypes(it.next());
            }
        }
        if (halloweenReward.getTypeIdList() == null || halloweenReward.getTypeIdList().size() <= 0) {
            return;
        }
        Iterator<Integer> it2 = halloweenReward.getTypeIdList().iterator();
        while (it2.hasNext()) {
            DressManager.clothTypes(c(it2.next().intValue()));
        }
    }

    public /* synthetic */ void a(HalloweenReward halloweenReward, int i) {
        a(halloweenReward);
    }

    public /* synthetic */ void a(int i, final HalloweenReward halloweenReward) {
        r.a(this.f18703a, i, new r.a() { // from class: com.sandboxol.halloween.view.fragment.exchange.g
            @Override // com.sandboxol.halloween.view.fragment.exchange.r.a
            public final void a(int i2) {
                this.f18715a.a(halloweenReward, i2);
            }
        });
    }

    public /* synthetic */ void a(ExchangeResponse exchangeResponse) {
        Messenger.getDefault().sendNoMsg("token.refresh.data");
        new com.sandboxol.halloween.view.dialog.a.b(this.f18703a, exchangeResponse.getRewardList()).show();
        ReportDataAdapter.onEvent(this.f18703a, EventConstant.EXCHANGE_SUC);
    }

    private void a(ObservableField<Integer> observableField, int i) {
        HalloweenReward halloweenReward;
        if (!u() || i >= com.sandboxol.halloween.c.b.b().a().getRewardList().size() || (halloweenReward = com.sandboxol.halloween.c.b.b().a().getRewardList().get(i)) == null) {
            return;
        }
        observableField.set(Integer.valueOf(halloweenReward.getExchange() == 0 ? 1 : 0));
    }

    private void a(String str) {
        List<SingleDressInfo> list = this.f18705c;
        if (list != null) {
            a(list);
            b(str);
        } else {
            com.sandboxol.halloween.web.g.c(this.f18703a, new s(this, str));
        }
    }

    public String b(int i) {
        HalloweenReward halloweenReward;
        return (!u() || i >= com.sandboxol.halloween.c.b.b().a().getRewardList().size() || (halloweenReward = com.sandboxol.halloween.c.b.b().a().getRewardList().get(i)) == null) ? "" : halloweenReward.getRewardIcon();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<SingleDressInfo> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (SingleDressInfo singleDressInfo : list) {
            if (singleDressInfo.getTypeId() != 7) {
                DressManager.clothTypes(singleDressInfo.getResourceId());
            }
            if (singleDressInfo.getTypeId() == 16 && singleDressInfo.getOccupyPosition() != null && singleDressInfo.getOccupyPosition().size() > 0) {
                Iterator<Long> it = singleDressInfo.getOccupyPosition().iterator();
                while (it.hasNext()) {
                    DressManager.clothTypes(c(it.next().longValue()));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        DressManager.clothTypes(str);
    }
}
