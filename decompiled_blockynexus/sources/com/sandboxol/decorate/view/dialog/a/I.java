package com.sandboxol.decorate.view.dialog.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.databinding.ObservableField;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.entity.BuySuitListBean;
import com.sandboxol.center.router.moduleInfo.decorate.LimitedTimes;
import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.binding.adapter.RadioGroupBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.config.CommonEventConstant;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.decorate.R;
import com.sandboxol.decorate.entity.ShopRecommendDecorationInfo;
import com.sandboxol.decorate.view.dialog.LeaveDressShopDialog;
import java.util.List;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: DressBuySuitItemViewModel.java */
/* JADX INFO: loaded from: classes3.dex */
public class I extends ListItemViewModel<ShopRecommendDecorationInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public K f17326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<BuySuitListBean> f17327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private BuySuitListBean f17328c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<Integer> f17329d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObservableField<Integer> f17330e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ObservableField<Boolean> f17331f;
    public ObservableField<Boolean> g;
    private ObservableField<Long> h;
    private ObservableField<Long> i;
    public ReplyCommand<RadioGroupBindingAdapters.CheckedDataWrapper> j;
    public ReplyCommand k;
    public ReplyCommand l;

    public I(Context context, ShopRecommendDecorationInfo shopRecommendDecorationInfo, ObservableField<Long> observableField, ObservableField<Long> observableField2, List<BuySuitListBean> list) {
        super(context, shopRecommendDecorationInfo);
        this.f17329d = new ObservableField<>(0);
        this.f17330e = new ObservableField<>(0);
        this.f17331f = new ObservableField<>(true);
        this.g = new ObservableField<>(true);
        this.j = new ReplyCommand<>(new Action1() { // from class: com.sandboxol.decorate.view.dialog.a.y
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f17357a.a((RadioGroupBindingAdapters.CheckedDataWrapper) obj);
            }
        });
        this.k = new ReplyCommand(new Action0() { // from class: com.sandboxol.decorate.view.dialog.a.B
            @Override // rx.functions.Action0
            public final void call() {
                this.f17306a.i();
            }
        });
        this.l = new ReplyCommand(new Action0() { // from class: com.sandboxol.decorate.view.dialog.a.A
            @Override // rx.functions.Action0
            public final void call() {
                this.f17305a.h();
            }
        });
        this.h = observableField;
        this.i = observableField2;
        this.f17327b = list;
        initData();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int c(int i) {
        int price = 0;
        for (SingleDressInfo singleDressInfo : ((ShopRecommendDecorationInfo) this.item).getShopSuitDecorationInfo().getShopDecorationInfos()) {
            List<LimitedTimes> limitedTimes = singleDressInfo.getLimitedTimes();
            price += (singleDressInfo.getHasPurchase() != 0 || limitedTimes == null || i >= limitedTimes.size()) ? singleDressInfo.getPrice() : limitedTimes.get(i).getPrice();
        }
        return price;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void d(int i) {
        try {
            List<LimitedTimes> limitedTimes = ((ShopRecommendDecorationInfo) this.item).getShopSuitDecorationInfo().getLimitedTimes();
            if (limitedTimes != null && !limitedTimes.isEmpty()) {
                if (i == R.id.rb7) {
                    int iC = c(0);
                    e(iC);
                    this.f17329d.set(Integer.valueOf(iC));
                    if (this.f17328c != null) {
                        this.f17328c.setDay(limitedTimes.get(0).getDay());
                    }
                } else if (i == R.id.rb30) {
                    int iC2 = c(1);
                    e(iC2);
                    this.f17329d.set(Integer.valueOf(iC2));
                    if (this.f17328c != null) {
                        this.f17328c.setDay(limitedTimes.get(1).getDay());
                    }
                } else if (i == R.id.rbForever) {
                    int iC3 = c(2);
                    e(iC3);
                    this.f17329d.set(Integer.valueOf(iC3));
                    if (this.f17328c != null) {
                        this.f17328c.setDay(limitedTimes.get(2).getDay());
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void e(int i) {
        if (!this.f17331f.get().booleanValue() || this.f17329d.get().intValue() == 0) {
            return;
        }
        if (((ShopRecommendDecorationInfo) this.item).getShopSuitDecorationInfo().getCurrency() == 2) {
            ObservableField<Long> observableField = this.h;
            observableField.set(Long.valueOf((observableField.get().longValue() - ((long) this.f17329d.get().intValue())) + ((long) i)));
        } else {
            ObservableField<Long> observableField2 = this.i;
            observableField2.set(Long.valueOf((observableField2.get().longValue() - ((long) this.f17329d.get().intValue())) + ((long) i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void h() {
        ReportDataAdapter.onEvent(this.context, CommonEventConstant.CLICK_CART_ENTRANCE, String.valueOf(((ShopRecommendDecorationInfo) this.item).getShopSuitDecorationInfo().getSuitId()));
        new LeaveDressShopDialog(this.context, ((ShopRecommendDecorationInfo) this.item).getShopSuitDecorationInfo().getActivityFlag()).a(new LeaveDressShopDialog.OnTwoButtonDialogClickListener() { // from class: com.sandboxol.decorate.view.dialog.a.z
            @Override // com.sandboxol.decorate.view.dialog.LeaveDressShopDialog.OnTwoButtonDialogClickListener
            public final void onClick() {
                Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_CLOSE_DRESS_BUY_DIALOG);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void i() {
        if (this.f17331f.get().booleanValue()) {
            if (((ShopRecommendDecorationInfo) this.item).getShopSuitDecorationInfo().getCurrency() == 2) {
                ObservableField<Long> observableField = this.h;
                observableField.set(Long.valueOf(observableField.get().longValue() - ((long) this.f17329d.get().intValue())));
            } else {
                ObservableField<Long> observableField2 = this.i;
                observableField2.set(Long.valueOf(observableField2.get().longValue() - ((long) this.f17329d.get().intValue())));
            }
            this.f17327b.remove(this.f17328c);
        } else {
            if (((ShopRecommendDecorationInfo) this.item).getShopSuitDecorationInfo().getCurrency() == 2) {
                ObservableField<Long> observableField3 = this.h;
                observableField3.set(Long.valueOf(observableField3.get().longValue() + ((long) this.f17329d.get().intValue())));
            } else {
                ObservableField<Long> observableField4 = this.i;
                observableField4.set(Long.valueOf(observableField4.get().longValue() + ((long) this.f17329d.get().intValue())));
            }
            this.f17327b.add(this.f17328c);
        }
        this.f17331f.set(Boolean.valueOf(!r0.get().booleanValue()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initData() {
        this.g.set(true);
        this.f17326a = new K(this.context, R.string.no_data, ((ShopRecommendDecorationInfo) this.item).getShopSuitDecorationInfo().getShopDecorationInfos());
        if (TextUtils.isEmpty(b(0))) {
            this.f17330e.set(Integer.valueOf(R.id.rbForever2));
            this.f17329d.set(Integer.valueOf(c(0)));
        } else {
            this.f17330e.set(Integer.valueOf(R.id.rbForever));
        }
        this.f17328c = new BuySuitListBean(0, ((ShopRecommendDecorationInfo) this.item).getShopSuitDecorationInfo().getSuitId());
        this.f17327b.add(this.f17328c);
        if (((ShopRecommendDecorationInfo) this.item).getShopSuitDecorationInfo().getIsActivity() != 0) {
            i();
            this.g.set(false);
        }
    }

    public /* synthetic */ void a(RadioGroupBindingAdapters.CheckedDataWrapper checkedDataWrapper) {
        d(checkedDataWrapper.getCheckedId());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String b(int i) {
        List<LimitedTimes> limitedTimes = ((ShopRecommendDecorationInfo) this.item).getShopSuitDecorationInfo().getLimitedTimes();
        return (limitedTimes == null || i >= limitedTimes.size() || limitedTimes.get(i).getDay() == 0) ? "" : this.context.getString(R.string.decorate_new_dress_buy_time_effective, Integer.valueOf(limitedTimes.get(i).getDay()));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public ShopRecommendDecorationInfo getItem() {
        return (ShopRecommendDecorationInfo) super.getItem();
    }
}
