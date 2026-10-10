package com.sandboxol.decorate.view.dialog.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.databinding.ObservableField;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.entity.BuyDecorationListBean;
import com.sandboxol.center.router.moduleInfo.decorate.LimitedTimes;
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

/* JADX INFO: compiled from: DressBuyItemViewModel.java */
/* JADX INFO: loaded from: classes3.dex */
public class F extends ListItemViewModel<ShopRecommendDecorationInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<BuyDecorationListBean> f17315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableField<Integer> f17316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableField<Integer> f17317c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<Boolean> f17318d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObservableField<Boolean> f17319e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ObservableField<Long> f17320f;
    private ObservableField<Long> g;
    public ReplyCommand<RadioGroupBindingAdapters.CheckedDataWrapper> h;
    public ReplyCommand i;
    public ReplyCommand j;
    private BuyDecorationListBean k;

    public F(Context context, ShopRecommendDecorationInfo shopRecommendDecorationInfo, ObservableField<Long> observableField, ObservableField<Long> observableField2, List<BuyDecorationListBean> list) {
        super(context, shopRecommendDecorationInfo);
        this.f17316b = new ObservableField<>(0);
        this.f17317c = new ObservableField<>(0);
        this.f17318d = new ObservableField<>(true);
        this.f17319e = new ObservableField<>(true);
        this.h = new ReplyCommand<>(new Action1() { // from class: com.sandboxol.decorate.view.dialog.a.w
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f17355a.a((RadioGroupBindingAdapters.CheckedDataWrapper) obj);
            }
        });
        this.i = new ReplyCommand(new Action0() { // from class: com.sandboxol.decorate.view.dialog.a.v
            @Override // rx.functions.Action0
            public final void call() {
                this.f17354a.i();
            }
        });
        this.j = new ReplyCommand(new Action0() { // from class: com.sandboxol.decorate.view.dialog.a.u
            @Override // rx.functions.Action0
            public final void call() {
                this.f17353a.h();
            }
        });
        this.f17320f = observableField;
        this.g = observableField2;
        this.f17315a = list;
        initData();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void c(int i) {
        try {
            List<LimitedTimes> limitedTimes = ((ShopRecommendDecorationInfo) this.item).getShopDecorationInfo().getLimitedTimes();
            if (limitedTimes != null && !limitedTimes.isEmpty()) {
                this.f17317c.set(Integer.valueOf(i));
                if (i == R.id.rb7) {
                    a(limitedTimes, 0);
                    this.f17316b.set(Integer.valueOf(limitedTimes.get(0).getPrice()));
                    if (this.k != null) {
                        this.k.setDay(limitedTimes.get(0).getDay());
                    }
                } else if (i == R.id.rb30) {
                    a(limitedTimes, 1);
                    this.f17316b.set(Integer.valueOf(limitedTimes.get(1).getPrice()));
                    if (this.k != null) {
                        this.k.setDay(limitedTimes.get(1).getDay());
                    }
                } else if (i == R.id.rbForever) {
                    a(limitedTimes, 2);
                    this.f17316b.set(Integer.valueOf(limitedTimes.get(2).getPrice()));
                    if (this.k != null) {
                        this.k.setDay(limitedTimes.get(2).getDay());
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void h() {
        ReportDataAdapter.onEvent(this.context, CommonEventConstant.CLICK_CART_ENTRANCE, String.valueOf(((ShopRecommendDecorationInfo) this.item).getShopDecorationInfo().getId()));
        new LeaveDressShopDialog(this.context, ((ShopRecommendDecorationInfo) this.item).getShopDecorationInfo().getActivityFlag()).a(new LeaveDressShopDialog.OnTwoButtonDialogClickListener() { // from class: com.sandboxol.decorate.view.dialog.a.x
            @Override // com.sandboxol.decorate.view.dialog.LeaveDressShopDialog.OnTwoButtonDialogClickListener
            public final void onClick() {
                Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_CLOSE_DRESS_BUY_DIALOG);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void i() {
        if (this.f17318d.get().booleanValue()) {
            if (((ShopRecommendDecorationInfo) this.item).getShopDecorationInfo().getCurrency() == 2) {
                ObservableField<Long> observableField = this.f17320f;
                observableField.set(Long.valueOf(observableField.get().longValue() - ((long) this.f17316b.get().intValue())));
            } else {
                ObservableField<Long> observableField2 = this.g;
                observableField2.set(Long.valueOf(observableField2.get().longValue() - ((long) this.f17316b.get().intValue())));
            }
            BuyDecorationListBean buyDecorationListBean = this.k;
            if (buyDecorationListBean != null) {
                this.f17315a.remove(buyDecorationListBean);
            }
        } else {
            if (((ShopRecommendDecorationInfo) this.item).getShopDecorationInfo().getCurrency() == 2) {
                ObservableField<Long> observableField3 = this.f17320f;
                observableField3.set(Long.valueOf(observableField3.get().longValue() + ((long) this.f17316b.get().intValue())));
            } else {
                ObservableField<Long> observableField4 = this.g;
                observableField4.set(Long.valueOf(observableField4.get().longValue() + ((long) this.f17316b.get().intValue())));
            }
            BuyDecorationListBean buyDecorationListBean2 = this.k;
            if (buyDecorationListBean2 != null) {
                this.f17315a.add(buyDecorationListBean2);
            }
        }
        this.f17318d.set(Boolean.valueOf(!r0.get().booleanValue()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initData() {
        this.f17319e.set(true);
        if (TextUtils.isEmpty(b(0))) {
            this.f17317c.set(Integer.valueOf(R.id.rbForever2));
            List<LimitedTimes> limitedTimes = ((ShopRecommendDecorationInfo) this.item).getShopDecorationInfo().getLimitedTimes();
            this.f17316b.set(Integer.valueOf((limitedTimes == null || limitedTimes.isEmpty()) ? ((ShopRecommendDecorationInfo) this.item).getShopDecorationInfo().getPrice() : limitedTimes.get(0).getPrice()));
        } else {
            c(R.id.rbForever);
        }
        this.k = new BuyDecorationListBean(0, ((ShopRecommendDecorationInfo) this.item).getShopDecorationInfo().getId());
        this.f17315a.add(this.k);
        if (((ShopRecommendDecorationInfo) this.item).getShopDecorationInfo().getIsActivity() != 0) {
            i();
            this.f17319e.set(false);
        }
    }

    public /* synthetic */ void a(RadioGroupBindingAdapters.CheckedDataWrapper checkedDataWrapper) {
        c(checkedDataWrapper.getCheckedId());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String b(int i) {
        List<LimitedTimes> limitedTimes = ((ShopRecommendDecorationInfo) this.item).getShopDecorationInfo().getLimitedTimes();
        return (limitedTimes == null || i >= limitedTimes.size() || limitedTimes.get(i).getDay() == 0) ? "" : this.context.getString(R.string.decorate_new_dress_buy_time_effective, Integer.valueOf(limitedTimes.get(i).getDay()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(List<LimitedTimes> list, int i) {
        if (!this.f17318d.get().booleanValue() || this.f17316b.get().intValue() == 0) {
            return;
        }
        if (((ShopRecommendDecorationInfo) this.item).getShopDecorationInfo().getCurrency() == 2) {
            ObservableField<Long> observableField = this.f17320f;
            observableField.set(Long.valueOf((observableField.get().longValue() - ((long) this.f17316b.get().intValue())) + ((long) list.get(i).getPrice())));
        } else {
            ObservableField<Long> observableField2 = this.g;
            observableField2.set(Long.valueOf((observableField2.get().longValue() - ((long) this.f17316b.get().intValue())) + ((long) list.get(i).getPrice())));
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public ShopRecommendDecorationInfo getItem() {
        return (ShopRecommendDecorationInfo) super.getItem();
    }
}
