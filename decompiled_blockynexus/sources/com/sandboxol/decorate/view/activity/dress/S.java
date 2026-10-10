package com.sandboxol.decorate.view.activity.dress;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.databinding.ObservableField;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.config.CommonEventConstant;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.decorate.R;
import com.sandboxol.decorate.entity.DressShopRecommendUnit;
import com.sandboxol.decorate.entity.ShopRecommendDecorationInfo;
import com.sandboxol.decorate.view.dialog.LeaveDressShopDialog;
import java.util.ArrayList;
import java.util.HashMap;
import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: DressShopRecommendPageItemViewModel.java */
/* JADX INFO: loaded from: classes3.dex */
public class S extends ListItemViewModel<DressShopRecommendUnit> {
    public ObservableField<Integer> A;
    public ObservableField<Drawable> B;
    public ObservableField<String> C;
    public ObservableField<Boolean> D;
    public ObservableField<String> E;
    public ObservableField<Integer> F;
    public ObservableField<Drawable> G;
    public ObservableField<String> H;
    public ObservableField<Boolean> I;
    public ObservableField<String> J;
    public ObservableField<Integer> K;
    public ObservableField<Drawable> L;
    public ObservableField<String> M;
    public ObservableField<Boolean> N;
    public ObservableField<String> O;
    public ObservableField<Integer> P;
    public ObservableField<Drawable> Q;
    public ObservableField<String> R;
    public ObservableField<Boolean> S;
    public ObservableField<String> T;
    public ObservableField<String> U;
    public ReplyCommand V;
    public ReplyCommand W;
    public ReplyCommand X;
    public ReplyCommand Y;
    public ReplyCommand Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f17249a;
    public ReplyCommand aa;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableField<Boolean> f17250b;
    public ReplyCommand ba;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableField<Boolean> f17251c;
    public ReplyCommand ca;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<Boolean> f17252d;
    public ReplyCommand da;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObservableField<Boolean> f17253e;
    public ReplyCommand ea;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ObservableField<Boolean> f17254f;
    public ReplyCommand fa;
    public ObservableField<Boolean> g;
    public ReplyCommand ga;
    public ObservableField<Boolean> h;
    public ReplyCommand ha;
    public ObservableField<Boolean> i;
    public ObservableField<Boolean> j;
    public ObservableField<Boolean> k;
    public ObservableField<Boolean> l;
    public ObservableField<Boolean> m;
    public ObservableField<Boolean> n;
    public ObservableField<Boolean> o;
    public ObservableField<Boolean> p;
    public ObservableField<Boolean> q;
    public ObservableField<String> r;
    public ObservableField<String> s;
    public ObservableField<String> t;
    public ObservableField<String> u;
    public ObservableField<Boolean> v;
    public ObservableField<Boolean> w;
    public ObservableField<Boolean> x;
    public ObservableField<Boolean> y;
    public ObservableField<String> z;

    public S(Context context, DressShopRecommendUnit dressShopRecommendUnit) {
        super(context, dressShopRecommendUnit);
        this.f17249a = true;
        this.f17250b = new ObservableField<>(false);
        this.f17251c = new ObservableField<>(false);
        this.f17252d = new ObservableField<>(false);
        this.f17253e = new ObservableField<>(false);
        this.f17254f = new ObservableField<>(false);
        this.g = new ObservableField<>(false);
        this.h = new ObservableField<>(false);
        this.i = new ObservableField<>(false);
        this.j = new ObservableField<>(false);
        this.k = new ObservableField<>(false);
        this.l = new ObservableField<>(false);
        this.m = new ObservableField<>(false);
        this.n = new ObservableField<>(false);
        this.o = new ObservableField<>(false);
        this.p = new ObservableField<>(false);
        this.q = new ObservableField<>(false);
        this.r = new ObservableField<>("");
        this.s = new ObservableField<>("");
        this.t = new ObservableField<>("");
        this.u = new ObservableField<>("");
        this.v = new ObservableField<>(false);
        this.w = new ObservableField<>(false);
        this.x = new ObservableField<>(false);
        this.y = new ObservableField<>(false);
        this.z = new ObservableField<>("");
        this.A = new ObservableField<>(1);
        this.B = new ObservableField<>();
        this.C = new ObservableField<>("");
        this.D = new ObservableField<>(false);
        this.E = new ObservableField<>("");
        this.F = new ObservableField<>(1);
        this.G = new ObservableField<>();
        this.H = new ObservableField<>("");
        this.I = new ObservableField<>(false);
        this.J = new ObservableField<>("");
        this.K = new ObservableField<>(1);
        this.L = new ObservableField<>();
        this.M = new ObservableField<>("");
        this.N = new ObservableField<>(false);
        this.O = new ObservableField<>("");
        this.P = new ObservableField<>(1);
        this.Q = new ObservableField<>();
        this.R = new ObservableField<>("");
        this.S = new ObservableField<>(false);
        this.T = new ObservableField<>();
        this.U = new ObservableField<>();
        this.V = new ReplyCommand(new Action0() { // from class: com.sandboxol.decorate.view.activity.dress.y
            @Override // rx.functions.Action0
            public final void call() {
                this.f17296a.f();
            }
        });
        this.W = new ReplyCommand(new Action0() { // from class: com.sandboxol.decorate.view.activity.dress.t
            @Override // rx.functions.Action0
            public final void call() {
                this.f17291a.h();
            }
        });
        this.X = new ReplyCommand(new Action0() { // from class: com.sandboxol.decorate.view.activity.dress.w
            @Override // rx.functions.Action0
            public final void call() {
                this.f17294a.l();
            }
        });
        this.Y = new ReplyCommand(new Action0() { // from class: com.sandboxol.decorate.view.activity.dress.u
            @Override // rx.functions.Action0
            public final void call() {
                this.f17292a.m();
            }
        });
        this.Z = new ReplyCommand(new Action0() { // from class: com.sandboxol.decorate.view.activity.dress.x
            @Override // rx.functions.Action0
            public final void call() {
                this.f17295a.p();
            }
        });
        this.aa = new ReplyCommand(new Action0() { // from class: com.sandboxol.decorate.view.activity.dress.m
            @Override // rx.functions.Action0
            public final void call() {
                this.f17284a.u();
            }
        });
        this.ba = new ReplyCommand(new Action0() { // from class: com.sandboxol.decorate.view.activity.dress.l
            @Override // rx.functions.Action0
            public final void call() {
                this.f17283a.D();
            }
        });
        this.ca = new ReplyCommand(new Action0() { // from class: com.sandboxol.decorate.view.activity.dress.s
            @Override // rx.functions.Action0
            public final void call() {
                this.f17290a.E();
            }
        });
        this.da = new ReplyCommand(new Action0() { // from class: com.sandboxol.decorate.view.activity.dress.o
            @Override // rx.functions.Action0
            public final void call() {
                this.f17286a.F();
            }
        });
        this.ea = new ReplyCommand(new Action0() { // from class: com.sandboxol.decorate.view.activity.dress.z
            @Override // rx.functions.Action0
            public final void call() {
                this.f17297a.G();
            }
        });
        this.fa = new ReplyCommand(new Action0() { // from class: com.sandboxol.decorate.view.activity.dress.q
            @Override // rx.functions.Action0
            public final void call() {
                this.f17288a.i();
            }
        });
        this.ga = new ReplyCommand(new Action0() { // from class: com.sandboxol.decorate.view.activity.dress.r
            @Override // rx.functions.Action0
            public final void call() {
                this.f17289a.j();
            }
        });
        this.ha = new ReplyCommand(new Action0() { // from class: com.sandboxol.decorate.view.activity.dress.v
            @Override // rx.functions.Action0
            public final void call() {
                this.f17293a.k();
            }
        });
        initView();
        com.sandboxol.decorate.manager.v.b().f17213b.addOnMapChangedCallback(new P(this));
        com.sandboxol.decorate.manager.v.b().f17215d.addOnListChangedCallback(new Q(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void I() {
        this.f17250b.set(Boolean.valueOf(b(((DressShopRecommendUnit) this.item).getBigItem())));
        this.f17251c.set(Boolean.valueOf(b(((DressShopRecommendUnit) this.item).getMidItem())));
        this.f17252d.set(Boolean.valueOf(b(((DressShopRecommendUnit) this.item).getSmallItemLeft())));
        this.f17253e.set(Boolean.valueOf(b(((DressShopRecommendUnit) this.item).getSmallItemRight())));
    }

    private void c(ShopRecommendDecorationInfo shopRecommendDecorationInfo) {
        final HashMap map = new HashMap();
        if (shopRecommendDecorationInfo.getShopDecorationInfo() == null) {
            if (shopRecommendDecorationInfo.getShopSuitDecorationInfo().getHasPurchase() == 0) {
                Observable.from(shopRecommendDecorationInfo.getShopSuitDecorationInfo().getShopDecorationInfos()).subscribe(new Action1() { // from class: com.sandboxol.decorate.view.activity.dress.p
                    @Override // rx.functions.Action1
                    public final void call(Object obj) {
                        S.a(map, (SingleDressInfo) obj);
                    }
                });
                new K().a(this.context, map);
                return;
            }
            return;
        }
        if (shopRecommendDecorationInfo.getShopDecorationInfo().getHasPurchase() == 0) {
            map.put(Long.valueOf(shopRecommendDecorationInfo.getShopDecorationInfo().getTypeId()), new ShopRecommendDecorationInfo(shopRecommendDecorationInfo.getShopDecorationInfo()));
            new K().a(this.context, map);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initView() {
        try {
            a(((DressShopRecommendUnit) this.item).getBigItem(), this.z, this.A, this.B, this.j, this.C, this.D, this.f17254f, this.n, this.r, this.v);
            a(((DressShopRecommendUnit) this.item).getMidItem(), this.E, this.F, this.G, this.k, this.H, this.I, this.g, this.o, this.s, this.w);
            a(((DressShopRecommendUnit) this.item).getSmallItemLeft(), this.J, this.K, this.L, this.l, this.M, this.N, this.h, this.p, this.t, this.x);
            a(((DressShopRecommendUnit) this.item).getSmallItemRight(), this.O, this.P, this.Q, this.m, this.R, this.S, this.i, this.q, this.u, this.y);
            this.f17250b.set(Boolean.valueOf(b(((DressShopRecommendUnit) this.item).getBigItem())));
            this.f17251c.set(Boolean.valueOf(b(((DressShopRecommendUnit) this.item).getMidItem())));
            this.f17252d.set(Boolean.valueOf(b(((DressShopRecommendUnit) this.item).getSmallItemLeft())));
            this.f17253e.set(Boolean.valueOf(b(((DressShopRecommendUnit) this.item).getSmallItemRight())));
            if (AccountCenter.newInstance().sex.get().intValue() == 1) {
                this.T.set("#9EDBDE");
                this.U.set("#BDF4F7");
            } else {
                this.T.set("#F4ACC0");
                this.U.set("#FFD5E1");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void D() {
        String activityFlag;
        if (((DressShopRecommendUnit) this.item).getSmallItemLeft().getShopDecorationInfo() == null) {
            activityFlag = ((DressShopRecommendUnit) this.item).getSmallItemLeft().getShopSuitDecorationInfo().getActivityFlag();
            ReportDataAdapter.onEvent(this.context, CommonEventConstant.CLICK_CARD_ENTRANCE, String.valueOf(((DressShopRecommendUnit) this.item).getSmallItemLeft().getShopSuitDecorationInfo().getSuitId()));
        } else {
            activityFlag = ((DressShopRecommendUnit) this.item).getSmallItemLeft().getShopDecorationInfo().getActivityFlag();
            ReportDataAdapter.onEvent(this.context, CommonEventConstant.CLICK_CARD_ENTRANCE, String.valueOf(((DressShopRecommendUnit) this.item).getSmallItemLeft().getShopDecorationInfo().getId()));
        }
        a(activityFlag);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void E() {
        String activityFlag;
        if (((DressShopRecommendUnit) this.item).getSmallItemRight().getShopDecorationInfo() == null) {
            activityFlag = ((DressShopRecommendUnit) this.item).getSmallItemRight().getShopSuitDecorationInfo().getActivityFlag();
            ReportDataAdapter.onEvent(this.context, CommonEventConstant.CLICK_CARD_ENTRANCE, String.valueOf(((DressShopRecommendUnit) this.item).getSmallItemRight().getShopSuitDecorationInfo().getSuitId()));
        } else {
            activityFlag = ((DressShopRecommendUnit) this.item).getSmallItemRight().getShopDecorationInfo().getActivityFlag();
            ReportDataAdapter.onEvent(this.context, CommonEventConstant.CLICK_CARD_ENTRANCE, String.valueOf(((DressShopRecommendUnit) this.item).getSmallItemRight().getShopDecorationInfo().getId()));
        }
        a(activityFlag);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void F() {
        a(((DressShopRecommendUnit) this.item).getBigItem());
        I();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void G() {
        a(((DressShopRecommendUnit) this.item).getMidItem());
        I();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void f() {
        c(((DressShopRecommendUnit) this.item).getBigItem());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void h() {
        c(((DressShopRecommendUnit) this.item).getMidItem());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void i() {
        a(((DressShopRecommendUnit) this.item).getSmallItemLeft());
        I();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void j() {
        a(((DressShopRecommendUnit) this.item).getSmallItemRight());
        I();
    }

    public /* synthetic */ void k() {
        AppToastUtils.showShortNegativeTipToast(this.context, R.string.decorate_dress_res_not_ready);
        ReportDataAdapter.onEvent(this.context, EventConstant.DRESS_LOADING_CLICK);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void l() {
        c(((DressShopRecommendUnit) this.item).getSmallItemLeft());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void m() {
        c(((DressShopRecommendUnit) this.item).getSmallItemRight());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void p() {
        String activityFlag;
        if (((DressShopRecommendUnit) this.item).getBigItem().getShopDecorationInfo() == null) {
            activityFlag = ((DressShopRecommendUnit) this.item).getBigItem().getShopSuitDecorationInfo().getActivityFlag();
            ReportDataAdapter.onEvent(this.context, CommonEventConstant.CLICK_CARD_ENTRANCE, String.valueOf(((DressShopRecommendUnit) this.item).getBigItem().getShopSuitDecorationInfo().getSuitId()));
        } else {
            activityFlag = ((DressShopRecommendUnit) this.item).getBigItem().getShopDecorationInfo().getActivityFlag();
            ReportDataAdapter.onEvent(this.context, CommonEventConstant.CLICK_CARD_ENTRANCE, String.valueOf(((DressShopRecommendUnit) this.item).getBigItem().getShopDecorationInfo().getId()));
        }
        a(activityFlag);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void u() {
        String activityFlag;
        if (((DressShopRecommendUnit) this.item).getMidItem().getShopDecorationInfo() == null) {
            activityFlag = ((DressShopRecommendUnit) this.item).getMidItem().getShopSuitDecorationInfo().getActivityFlag();
            ReportDataAdapter.onEvent(this.context, CommonEventConstant.CLICK_CARD_ENTRANCE, String.valueOf(((DressShopRecommendUnit) this.item).getMidItem().getShopSuitDecorationInfo().getSuitId()));
        } else {
            activityFlag = ((DressShopRecommendUnit) this.item).getMidItem().getShopDecorationInfo().getActivityFlag();
            ReportDataAdapter.onEvent(this.context, CommonEventConstant.CLICK_CARD_ENTRANCE, String.valueOf(((DressShopRecommendUnit) this.item).getMidItem().getShopDecorationInfo().getId()));
        }
        a(activityFlag);
    }

    private void a(ShopRecommendDecorationInfo shopRecommendDecorationInfo, ObservableField<String> observableField, ObservableField<Integer> observableField2, ObservableField<Drawable> observableField3, ObservableField<Boolean> observableField4, ObservableField<String> observableField5, ObservableField<Boolean> observableField6, ObservableField<Boolean> observableField7, ObservableField<Boolean> observableField8, ObservableField<String> observableField9, ObservableField<Boolean> observableField10) {
        if (shopRecommendDecorationInfo == null) {
            observableField10.set(true);
            return;
        }
        if (shopRecommendDecorationInfo.getShopSuitDecorationInfo() != null) {
            observableField.set(shopRecommendDecorationInfo.getIconUrl());
            observableField2.set(Integer.valueOf((shopRecommendDecorationInfo.getShopSuitDecorationInfo().getLimitedTimes() == null || shopRecommendDecorationInfo.getShopSuitDecorationInfo().getLimitedTimes().size() == 0) ? 0 : shopRecommendDecorationInfo.getShopSuitDecorationInfo().getLimitedTimes().get(0).getPrice()));
            a(this.context, shopRecommendDecorationInfo.getShopSuitDecorationInfo().getCurrency(), observableField3);
            observableField5.set(this.context.getString(R.string.decorate_new_dress_time_reminder, String.valueOf(shopRecommendDecorationInfo.getShopSuitDecorationInfo().getRemainingDays())));
            observableField7.set(Boolean.valueOf(shopRecommendDecorationInfo.getShopSuitDecorationInfo().getHasPurchase() == 1));
            observableField8.set(Boolean.valueOf(shopRecommendDecorationInfo.getShopSuitDecorationInfo().getIsActivity() != 0));
            observableField9.set(shopRecommendDecorationInfo.getShopSuitDecorationInfo().getActivityFlag());
            if (com.sandboxol.decorate.manager.o.a().a(shopRecommendDecorationInfo.getShopSuitDecorationInfo().getDecorationInfoList().get(0).getResourceId())) {
                observableField10.set(true);
            } else {
                com.sandboxol.decorate.manager.q.a(com.sandboxol.decorate.manager.q.b(), shopRecommendDecorationInfo.getShopSuitDecorationInfo().getDecorationInfoList().get(0).getResourceId(), observableField10);
                com.sandboxol.decorate.f.j.a(shopRecommendDecorationInfo.getShopSuitDecorationInfo().getDecorationInfoList().get(0));
            }
            if (shopRecommendDecorationInfo.getShopSuitDecorationInfo().getRemainingDays() > 0) {
                observableField6.set(true);
            }
            if (shopRecommendDecorationInfo.getShopSuitDecorationInfo().getStatus() == 1 && com.sandboxol.decorate.manager.v.b().f17215d.size() == 0 && !com.sandboxol.decorate.manager.j.d().e()) {
                ArrayList arrayList = new ArrayList();
                for (SingleDressInfo singleDressInfo : shopRecommendDecorationInfo.getShopSuitDecorationInfo().getShopDecorationInfos()) {
                    arrayList.add(Long.valueOf(singleDressInfo.getTypeId()));
                    if (com.sandboxol.decorate.manager.n.a(singleDressInfo)) {
                        arrayList.addAll(singleDressInfo.getOccupyPosition());
                    }
                }
                com.sandboxol.decorate.manager.v.b().f17215d.add(Long.valueOf(shopRecommendDecorationInfo.getShopSuitDecorationInfo().getSuitId()));
                com.sandboxol.decorate.manager.n.c().a(arrayList);
                com.sandboxol.decorate.manager.j.d().b(true);
            }
        } else {
            observableField.set(shopRecommendDecorationInfo.getIconUrl());
            observableField2.set(Integer.valueOf(shopRecommendDecorationInfo.getShopDecorationInfo().getSuitId() == 0 ? shopRecommendDecorationInfo.getShopDecorationInfo().getPrice() : (int) shopRecommendDecorationInfo.getShopDecorationInfo().getSuitPrice()));
            a(this.context, shopRecommendDecorationInfo.getShopDecorationInfo().getCurrency(), observableField3);
            observableField5.set(this.context.getString(R.string.decorate_new_dress_time_reminder, String.valueOf(shopRecommendDecorationInfo.getShopDecorationInfo().getRemainingDays())));
            observableField7.set(Boolean.valueOf(shopRecommendDecorationInfo.getShopDecorationInfo().getHasPurchase() == 1));
            observableField8.set(Boolean.valueOf(shopRecommendDecorationInfo.getShopDecorationInfo().getIsActivity() != 0));
            observableField9.set(shopRecommendDecorationInfo.getShopDecorationInfo().getActivityFlag());
            if (com.sandboxol.decorate.manager.o.a().a(shopRecommendDecorationInfo.getShopDecorationInfo().getResourceId())) {
                observableField10.set(true);
            } else {
                com.sandboxol.decorate.manager.q.a(com.sandboxol.decorate.manager.q.b(), shopRecommendDecorationInfo.getShopDecorationInfo().getResourceId(), observableField10);
                com.sandboxol.decorate.f.j.a(shopRecommendDecorationInfo.getShopDecorationInfo());
            }
            if (shopRecommendDecorationInfo.getShopDecorationInfo().getRemainingDays() > 0) {
                observableField6.set(true);
            }
        }
        observableField4.set(Boolean.valueOf(shopRecommendDecorationInfo.getIsNew() == 1));
    }

    private boolean b(ShopRecommendDecorationInfo shopRecommendDecorationInfo) {
        if (shopRecommendDecorationInfo != null) {
            return shopRecommendDecorationInfo.getShopSuitDecorationInfo() == null ? com.sandboxol.decorate.manager.v.b().f17213b.containsValue(shopRecommendDecorationInfo.getShopDecorationInfo().getResourceId()) : com.sandboxol.decorate.manager.v.b().f17215d.contains(Long.valueOf(shopRecommendDecorationInfo.getShopSuitDecorationInfo().getSuitId()));
        }
        return false;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public DressShopRecommendUnit getItem() {
        return (DressShopRecommendUnit) super.getItem();
    }

    private void a(ShopRecommendDecorationInfo shopRecommendDecorationInfo) {
        if (shopRecommendDecorationInfo != null) {
            this.f17249a = false;
            if (shopRecommendDecorationInfo.getShopSuitDecorationInfo() == null) {
                if (com.sandboxol.decorate.manager.v.b().f17213b.containsValue(shopRecommendDecorationInfo.getShopDecorationInfo().getResourceId())) {
                    com.sandboxol.decorate.manager.f.e().i().a(this.context, shopRecommendDecorationInfo.getShopDecorationInfo());
                } else {
                    com.sandboxol.decorate.manager.f.e().f().a(this.context, shopRecommendDecorationInfo.getShopDecorationInfo());
                }
            } else if (com.sandboxol.decorate.manager.v.b().f17215d.contains(Long.valueOf(shopRecommendDecorationInfo.getShopSuitDecorationInfo().getSuitId()))) {
                com.sandboxol.decorate.manager.f.e().h().a(this.context, shopRecommendDecorationInfo.getShopSuitDecorationInfo());
            } else {
                com.sandboxol.decorate.manager.f.e().g().a(this.context, shopRecommendDecorationInfo.getShopSuitDecorationInfo());
            }
            this.f17249a = true;
        }
    }

    static /* synthetic */ void a(HashMap map, SingleDressInfo singleDressInfo) {
    }

    private void a(String str) {
        new LeaveDressShopDialog(this.context, str).a(new LeaveDressShopDialog.OnTwoButtonDialogClickListener() { // from class: com.sandboxol.decorate.view.activity.dress.n
            @Override // com.sandboxol.decorate.view.dialog.LeaveDressShopDialog.OnTwoButtonDialogClickListener
            public final void onClick() {
                Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_CLOSE_DRESS_BUY_DIALOG);
            }
        }).show();
    }

    private void a(Context context, int i, ObservableField<Drawable> observableField) {
        if (i == 0) {
            observableField.set(androidx.core.content.b.c(context, R.mipmap.ic_gold));
        } else if (i != 2) {
            observableField.set(androidx.core.content.b.c(context, R.mipmap.ic_diamond_all));
        } else {
            observableField.set(androidx.core.content.b.c(context, R.mipmap.ic_gold));
        }
    }
}
