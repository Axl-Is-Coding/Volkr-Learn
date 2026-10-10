package com.sandboxol.decorate.view.dialog.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.BuyDecorationListBean;
import com.sandboxol.center.entity.BuyRequest;
import com.sandboxol.center.entity.BuySuitListBean;
import com.sandboxol.center.router.moduleInfo.decorate.LimitedTimes;
import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import com.sandboxol.center.router.moduleInfo.decorate.SuitDressInfo;
import com.sandboxol.center.router.moduleInfo.game.EngineEnv;
import com.sandboxol.center.utils.DialogUtils;
import com.sandboxol.center.view.dialog.PayGdiamondDialog;
import com.sandboxol.center.view.dialog.TwoButtonDialog;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.FirebaseUtils;
import com.sandboxol.decorate.R;
import com.sandboxol.decorate.c.AbstractC2590o;
import com.sandboxol.decorate.entity.ShopRecommendDecorationInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: DressBuyDialog.java */
/* JADX INFO: loaded from: classes3.dex */
public class E extends FullScreenDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AbstractC2590o f17309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<ShopRecommendDecorationInfo> f17310b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<BuyDecorationListBean> f17311c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<BuySuitListBean> f17312d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public H f17313e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public G f17314f;
    public ObservableField<Long> g;
    public ObservableField<Long> h;
    public ObservableField<Boolean> i;
    public ReplyCommand j;
    public ReplyCommand k;
    public ReplyCommand<String> l;
    public ReplyCommand<String> m;
    public ReplyCommand<String> n;

    public E(Context context, List<ShopRecommendDecorationInfo> list) {
        super(context);
        this.f17311c = new ArrayList();
        this.f17312d = new ArrayList();
        this.f17314f = new G();
        this.g = new ObservableField<>(0L);
        this.h = new ObservableField<>(0L);
        this.i = new ObservableField<>(true);
        this.j = new ReplyCommand(new Action0() { // from class: com.sandboxol.decorate.view.dialog.a.C
            @Override // rx.functions.Action0
            public final void call() {
                this.f17307a.c();
            }
        });
        this.k = new ReplyCommand(new Action0() { // from class: com.sandboxol.decorate.view.dialog.a.g
            @Override // rx.functions.Action0
            public final void call() {
                this.f17339a.j();
            }
        });
        this.l = new ReplyCommand<>(new Action1() { // from class: com.sandboxol.decorate.view.dialog.a.r
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f17350a.a((String) obj);
            }
        });
        this.m = new ReplyCommand<>(new Action1() { // from class: com.sandboxol.decorate.view.dialog.a.e
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f17337a.b((String) obj);
            }
        });
        this.n = new ReplyCommand<>(new Action1() { // from class: com.sandboxol.decorate.view.dialog.a.q
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f17349a.c((String) obj);
            }
        });
        this.f17310b = list;
        initView();
        initData();
    }

    private void initData() {
        h();
        this.f17313e = new H(this.context, R.string.no_data, this.f17310b, this.g, this.h, this.f17311c, this.f17312d);
        g();
        initMessenger();
    }

    private void initMessenger() {
        Messenger.getDefault().register(this, MessageToken.TOKEN_CLOSE_DRESS_BUY_DIALOG, new Action0() { // from class: com.sandboxol.decorate.view.dialog.a.h
            @Override // rx.functions.Action0
            public final void call() {
                this.f17340a.c();
            }
        });
    }

    private void initView() {
        this.f17309a = (AbstractC2590o) androidx.databinding.e.a(LayoutInflater.from(this.context), R.layout.dialog_dress_buy, (ViewGroup) null, false);
        this.f17309a.a(this);
        setContentView(this.f17309a.getRoot());
        l();
    }

    @Override // com.sandboxol.common.dialog.FullScreenDialog, android.app.Dialog, android.content.DialogInterface
    /* JADX INFO: renamed from: dismiss, reason: merged with bridge method [inline-methods] */
    public void c() {
        super.c();
        Messenger.getDefault().unregister(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (i()) {
            new TwoButtonDialog(this.context).setDetailText(R.string.decorate_good_buy_has_activity_dress_tip).setLeftButtonText(R.string.decorate_back).setRightButtonText(R.string.decorate_confirm).setListener(new TwoButtonDialog.OnTwoButtonDialogClickListener() { // from class: com.sandboxol.decorate.view.dialog.a.t
                @Override // com.sandboxol.center.view.dialog.TwoButtonDialog.OnTwoButtonDialogClickListener
                public final void onClick() {
                    this.f17352a.a();
                }
            }).setLeftListener(new TwoButtonDialog.OnTwoButtonDialogLeftClickListener() { // from class: com.sandboxol.decorate.view.dialog.a.i
                @Override // com.sandboxol.center.view.dialog.TwoButtonDialog.OnTwoButtonDialogLeftClickListener
                public final void onLeftClick() {
                    this.f17341a.b();
                }
            }).show();
        } else {
            f();
        }
    }

    private void f() {
        ReportDataAdapter.onEvent(this.context, EventConstant.CLICK_CONFIRM_PAYMENT);
        FirebaseUtils.onEvent(this.context, EventConstant.CLICK_CONFIRM_PAYMENT);
        BuyRequest buyRequest = new BuyRequest(Long.valueOf(EngineEnv.v1().getEngineVersion()));
        buyRequest.setBuySuitList(this.f17312d);
        buyRequest.setBuyDecorationList(this.f17311c);
        com.sandboxol.decorate.web.w.a(this.context, buyRequest, new D(this));
    }

    private void g() {
        Observable.from(this.f17310b).subscribe(new Action1() { // from class: com.sandboxol.decorate.view.dialog.a.f
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f17338a.a((ShopRecommendDecorationInfo) obj);
            }
        });
    }

    private void h() {
        Collections.sort(this.f17310b, new Comparator() { // from class: com.sandboxol.decorate.view.dialog.a.m
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return E.a((ShopRecommendDecorationInfo) obj, (ShopRecommendDecorationInfo) obj2);
            }
        });
        Observable.from(this.f17310b).subscribe(new Action1() { // from class: com.sandboxol.decorate.view.dialog.a.o
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                E.b((ShopRecommendDecorationInfo) obj);
            }
        });
    }

    private boolean i() {
        for (ShopRecommendDecorationInfo shopRecommendDecorationInfo : this.f17310b) {
            if (shopRecommendDecorationInfo.getShopDecorationInfo() != null && shopRecommendDecorationInfo.getShopDecorationInfo().getIsActivity() != 0) {
                return true;
            }
            if (shopRecommendDecorationInfo.getShopSuitDecorationInfo() != null && shopRecommendDecorationInfo.getShopSuitDecorationInfo().getIsActivity() != 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.g.get().longValue() == 0 && this.h.get().longValue() == 0) {
            AppToastUtils.showShortNegativeTipToast(this.context, R.string.decorate_new_dress_not_select_good);
            return;
        }
        long jA = a(0, a(this.h.get().longValue()));
        if (jA > 0) {
            DialogUtils.newsInstant().showPayGdiamondDialog(this.context, (int) jA, new PayGdiamondDialog.OnTwoButtonDialogClickListener() { // from class: com.sandboxol.decorate.view.dialog.a.n
                @Override // com.sandboxol.center.view.dialog.PayGdiamondDialog.OnTwoButtonDialogClickListener
                public final void onClick() {
                    this.f17346a.e();
                }
            }, null);
        } else {
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        List<BuyDecorationListBean> list = this.f17311c;
        if (list != null && list.size() > 0) {
            for (BuyDecorationListBean buyDecorationListBean : this.f17311c) {
                SingleDressInfo singleDressInfoB = b(buyDecorationListBean.getDecorationId());
                if (singleDressInfoB != null) {
                    com.sandboxol.decorate.manager.v.a(buyDecorationListBean.getDecorationId(), singleDressInfoB);
                }
            }
        }
        List<BuySuitListBean> list2 = this.f17312d;
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        Iterator<BuySuitListBean> it = this.f17312d.iterator();
        while (it.hasNext()) {
            SuitDressInfo suitDressInfoC = c(it.next().getSuitId());
            if (suitDressInfoC != null) {
                com.sandboxol.decorate.manager.v.a(suitDressInfoC.getSuitId(), suitDressInfoC);
            }
        }
    }

    private void l() {
        boolean z = false;
        for (ShopRecommendDecorationInfo shopRecommendDecorationInfo : this.f17310b) {
            if (shopRecommendDecorationInfo.getShopDecorationInfo() != null && shopRecommendDecorationInfo.getShopDecorationInfo().getIsActivity() == 0) {
                z = true;
            }
            if (shopRecommendDecorationInfo.getShopSuitDecorationInfo() != null && shopRecommendDecorationInfo.getShopSuitDecorationInfo().getIsActivity() == 0) {
                z = true;
            }
        }
        this.i.set(Boolean.valueOf(z));
    }

    public /* synthetic */ void a(String str) {
        AbstractC2590o abstractC2590o = this.f17309a;
        if (abstractC2590o != null) {
            a(abstractC2590o.l, AccountCenter.newInstance().golds.get().longValue(), str);
        }
    }

    public /* synthetic */ void b(String str) {
        AbstractC2590o abstractC2590o = this.f17309a;
        if (abstractC2590o != null) {
            a(abstractC2590o.j, AccountCenter.newInstance().diamonds.get().longValue(), str);
        }
    }

    public /* synthetic */ void c(String str) {
        AbstractC2590o abstractC2590o = this.f17309a;
        if (abstractC2590o != null) {
            a(abstractC2590o.k, AccountCenter.newInstance().gDiamonds.get().longValue(), str);
        }
    }

    public String d() {
        int iIntValue = AccountCenter.newInstance().vip.get().intValue();
        return iIntValue != 1 ? iIntValue != 2 ? iIntValue != 3 ? iIntValue != 4 ? "" : "MVP+  20%OFF: " : this.context.getString(R.string.decorate_new_dress_buy_total_mvp) : this.context.getString(R.string.decorate_new_dress_buy_total_vip) : "";
    }

    static /* synthetic */ int a(ShopRecommendDecorationInfo shopRecommendDecorationInfo, ShopRecommendDecorationInfo shopRecommendDecorationInfo2) {
        return shopRecommendDecorationInfo.getShopSuitDecorationInfo() != null ? 1 : 0;
    }

    static /* synthetic */ void b(ShopRecommendDecorationInfo shopRecommendDecorationInfo) {
        SingleDressInfo shopDecorationInfo = shopRecommendDecorationInfo.getShopDecorationInfo();
        SuitDressInfo shopSuitDecorationInfo = shopRecommendDecorationInfo.getShopSuitDecorationInfo();
        if (shopDecorationInfo != null) {
            List<LimitedTimes> limitedTimes = shopDecorationInfo.getLimitedTimes();
            if (limitedTimes != null) {
                Collections.sort(limitedTimes, new Comparator() { // from class: com.sandboxol.decorate.view.dialog.a.j
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return E.a((LimitedTimes) obj, (LimitedTimes) obj2);
                    }
                });
                return;
            }
            return;
        }
        if (shopSuitDecorationInfo != null) {
            List<LimitedTimes> limitedTimes2 = shopSuitDecorationInfo.getLimitedTimes();
            if (limitedTimes2 != null) {
                Collections.sort(limitedTimes2, new Comparator() { // from class: com.sandboxol.decorate.view.dialog.a.s
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return E.b((LimitedTimes) obj, (LimitedTimes) obj2);
                    }
                });
            }
            List<SingleDressInfo> shopDecorationInfos = shopSuitDecorationInfo.getShopDecorationInfos();
            if (shopDecorationInfos != null) {
                Observable.from(shopDecorationInfos).subscribe(new Action1() { // from class: com.sandboxol.decorate.view.dialog.a.k
                    @Override // rx.functions.Action1
                    public final void call(Object obj) {
                        E.a((SingleDressInfo) obj);
                    }
                });
            }
        }
    }

    static /* synthetic */ int c(LimitedTimes limitedTimes, LimitedTimes limitedTimes2) {
        return limitedTimes.getPrice() - limitedTimes2.getPrice();
    }

    static /* synthetic */ int a(LimitedTimes limitedTimes, LimitedTimes limitedTimes2) {
        return limitedTimes.getPrice() - limitedTimes2.getPrice();
    }

    private SuitDressInfo c(long j) {
        List<ShopRecommendDecorationInfo> list = this.f17310b;
        if (list == null || list.size() <= 0) {
            return null;
        }
        for (ShopRecommendDecorationInfo shopRecommendDecorationInfo : this.f17310b) {
            if (shopRecommendDecorationInfo.getShopSuitDecorationInfo() != null && shopRecommendDecorationInfo.getShopSuitDecorationInfo().getSuitId() == j) {
                return shopRecommendDecorationInfo.getShopSuitDecorationInfo();
            }
        }
        return null;
    }

    static /* synthetic */ void a(SingleDressInfo singleDressInfo) {
        List<LimitedTimes> limitedTimes = singleDressInfo.getLimitedTimes();
        if (limitedTimes != null) {
            Collections.sort(limitedTimes, new Comparator() { // from class: com.sandboxol.decorate.view.dialog.a.p
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return E.c((LimitedTimes) obj, (LimitedTimes) obj2);
                }
            });
        }
    }

    public /* synthetic */ void a(ShopRecommendDecorationInfo shopRecommendDecorationInfo) {
        SingleDressInfo shopDecorationInfo = shopRecommendDecorationInfo.getShopDecorationInfo();
        SuitDressInfo shopSuitDecorationInfo = shopRecommendDecorationInfo.getShopSuitDecorationInfo();
        if (shopDecorationInfo != null && shopDecorationInfo.getHasPurchase() == 0) {
            List<LimitedTimes> limitedTimes = shopDecorationInfo.getLimitedTimes();
            if (limitedTimes != null && !limitedTimes.isEmpty()) {
                if (shopDecorationInfo.getCurrency() == 2) {
                    ObservableField<Long> observableField = this.g;
                    observableField.set(Long.valueOf(observableField.get().longValue() + ((long) limitedTimes.get(limitedTimes.size() - 1).getPrice())));
                } else {
                    ObservableField<Long> observableField2 = this.h;
                    observableField2.set(Long.valueOf(observableField2.get().longValue() + ((long) limitedTimes.get(limitedTimes.size() - 1).getPrice())));
                }
            } else if (shopDecorationInfo.getCurrency() == 2) {
                ObservableField<Long> observableField3 = this.g;
                observableField3.set(Long.valueOf(observableField3.get().longValue() + ((long) shopDecorationInfo.getPrice())));
            } else {
                ObservableField<Long> observableField4 = this.h;
                observableField4.set(Long.valueOf(observableField4.get().longValue() + ((long) shopDecorationInfo.getPrice())));
            }
        }
        if (shopSuitDecorationInfo == null || shopSuitDecorationInfo.getHasPurchase() != 0) {
            return;
        }
        Observable.from(shopSuitDecorationInfo.getShopDecorationInfos()).subscribe(new Action1() { // from class: com.sandboxol.decorate.view.dialog.a.l
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f17344a.b((SingleDressInfo) obj);
            }
        });
    }

    static /* synthetic */ int b(LimitedTimes limitedTimes, LimitedTimes limitedTimes2) {
        return limitedTimes.getPrice() - limitedTimes2.getPrice();
    }

    public /* synthetic */ void b(SingleDressInfo singleDressInfo) {
        if (singleDressInfo.getHasPurchase() == 0) {
            List<LimitedTimes> limitedTimes = singleDressInfo.getLimitedTimes();
            if (limitedTimes != null && !limitedTimes.isEmpty()) {
                if (singleDressInfo.getCurrency() == 2) {
                    ObservableField<Long> observableField = this.g;
                    observableField.set(Long.valueOf(observableField.get().longValue() + ((long) limitedTimes.get(limitedTimes.size() - 1).getPrice())));
                    return;
                } else {
                    ObservableField<Long> observableField2 = this.h;
                    observableField2.set(Long.valueOf(observableField2.get().longValue() + ((long) limitedTimes.get(limitedTimes.size() - 1).getPrice())));
                    return;
                }
            }
            if (singleDressInfo.getCurrency() == 2) {
                ObservableField<Long> observableField3 = this.g;
                observableField3.set(Long.valueOf(observableField3.get().longValue() + ((long) singleDressInfo.getPrice())));
            } else {
                ObservableField<Long> observableField4 = this.h;
                observableField4.set(Long.valueOf(observableField4.get().longValue() + ((long) singleDressInfo.getPrice())));
            }
        }
    }

    public long a(long j) {
        double d2;
        double d3;
        int iIntValue = AccountCenter.newInstance().vip.get().intValue();
        if (iIntValue == 1) {
            return j;
        }
        if (iIntValue == 2) {
            d2 = 0.9d;
            d3 = j;
            Double.isNaN(d3);
        } else {
            if (iIntValue != 3 && iIntValue != 4) {
                return j;
            }
            d2 = 0.8d;
            d3 = j;
            Double.isNaN(d3);
        }
        return (long) (d3 * d2);
    }

    public /* synthetic */ void b() {
        if (isShowing()) {
            c();
        }
    }

    private SingleDressInfo b(long j) {
        List<ShopRecommendDecorationInfo> list = this.f17310b;
        if (list == null || list.size() <= 0) {
            return null;
        }
        for (ShopRecommendDecorationInfo shopRecommendDecorationInfo : this.f17310b) {
            if (shopRecommendDecorationInfo.getShopDecorationInfo() != null && shopRecommendDecorationInfo.getShopDecorationInfo().getId() == j) {
                return shopRecommendDecorationInfo.getShopDecorationInfo();
            }
        }
        return null;
    }

    public long a(int i, long j) {
        if (i == 1) {
            return AccountCenter.newInstance().diamonds.get().longValue() > j ? j : AccountCenter.newInstance().diamonds.get().longValue();
        }
        long jLongValue = (int) (AccountCenter.newInstance().diamonds.get().longValue() - j);
        if (jLongValue > 0) {
            return 0L;
        }
        return Math.abs(jLongValue);
    }

    private void a(TextView textView, long j, String str) {
        if (textView != null) {
            try {
                if (j >= Long.valueOf(str).longValue()) {
                    textView.setTextColor(this.context.getResources().getColor(R.color.NewDressDialogDelPriceTextColor));
                } else {
                    textView.setTextColor(this.context.getResources().getColor(R.color.DressBuyInsufficientTextColor));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public /* synthetic */ void a() {
        if (isShowing()) {
            c();
        }
        f();
    }
}
