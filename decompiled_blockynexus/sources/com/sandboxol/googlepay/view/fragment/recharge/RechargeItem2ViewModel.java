package com.sandboxol.googlepay.view.fragment.recharge;

import android.content.Context;
import android.text.TextUtils;
import androidx.databinding.ObservableField;
import com.android.billingclient.api.BillingClient;
import com.sandboxol.adsoversea.config.SharedConstant;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.StarCodeUser;
import com.sandboxol.center.router.manager.AdsManager;
import com.sandboxol.center.router.manager.VipManager;
import com.sandboxol.center.utils.IntentUtils;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.FirebaseUtils;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.googlepay.R;
import com.sandboxol.googlepay.entity.RechargeInfo;
import com.sandboxol.vip.entity.VipProductType;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes3.dex */
public class RechargeItem2ViewModel extends ListItemViewModel<RechargeInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ObservableField<StarCodeUser> f18355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableField<Integer> f18356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ReplyCommand f18357c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ReplyCommand f18358d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ReplyCommand f18359e;

    public RechargeItem2ViewModel(Context context, RechargeInfo rechargeInfo, ObservableField<StarCodeUser> observableField) {
        super(context, rechargeInfo);
        this.f18356b = new ObservableField<>(0);
        this.f18357c = new ReplyCommand(new Action0() { // from class: com.sandboxol.googlepay.view.fragment.recharge.b
            @Override // rx.functions.Action0
            public final void call() {
                this.f18365a.onClickPay();
            }
        });
        this.f18358d = new ReplyCommand(new Action0() { // from class: com.sandboxol.googlepay.view.fragment.recharge.c
            @Override // rx.functions.Action0
            public final void call() {
                this.f18366a.onClickVip();
            }
        });
        this.f18359e = new ReplyCommand(new Action0() { // from class: com.sandboxol.googlepay.view.fragment.recharge.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f18364a.h();
            }
        });
        this.f18355a = observableField;
        initData();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void f() {
        if (((RechargeInfo) this.item).getProductEntity().getProductId().contains(StringConstant.MONEY_TYPE_DIAMOND) || ((RechargeInfo) this.item).getProductEntity().getProductId().contains("cube")) {
            ObservableField<StarCodeUser> observableField = this.f18355a;
            ReportDataAdapter.onEvent(this.context, observableField != null && (observableField.get().getUserId() > 0L ? 1 : (observableField.get().getUserId() == 0L ? 0 : -1)) != 0 && !TextUtils.isEmpty(this.f18355a.get().getStarCode()) ? EventConstant.STAR_TOPUP_DIAMONDS_STAR : EventConstant.TOPUP_DIAMONDS, ((RechargeInfo) this.item).getProductEntity().getProductId());
            FirebaseUtils.onEvent(this.context, EventConstant.TOPUP_DIAMONDS, ((RechargeInfo) this.item).getProductEntity().getProductId());
        } else if (((RechargeInfo) this.item).getProductEntity().getProductId().contains("vip")) {
            ReportDataAdapter.onEvent(this.context, EventConstant.TOPUP_VIP, ((RechargeInfo) this.item).getProductEntity().getProductId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void h() {
        if (!((RechargeInfo) this.item).isFree() || !AdsManager.isShowIronAds(this.context, 2, 5)) {
            AppToastUtils.showShortNegativeTipToast(this.context, R.string.googleplay_ads_cant_watch_today);
            return;
        }
        AdsManager.showRewardVideo(5);
        this.f18356b.set(Integer.valueOf(r0.get().intValue() - 1));
        ReportDataAdapter.onEvent(this.context, EventConstant.CLICK_TOPUP_AD);
        FirebaseUtils.onEvent(this.context, EventConstant.CLICK_TOPUP_AD);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void i() {
        String str = "userId=" + AccountCenter.newInstance().userId.get();
        ObservableField<StarCodeUser> observableField = this.f18355a;
        if (observableField != null && observableField.get().getUserId() != 0 && !TextUtils.isEmpty(this.f18355a.get().getStarCode())) {
            str = str + "&starCodeUserId=" + this.f18355a.get().getUserId() + "&starCode=" + this.f18355a.get().getStarCode();
        }
        IntentUtils.startGooglePayActivity(this.context, ((RechargeInfo) this.item).getProductEntity().getProductId(), MessageToken.TOKEN_RECHARGE_PAY, str);
        f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initData() {
        if (((RechargeInfo) this.item).isFree()) {
            this.f18356b.set(Integer.valueOf(2 - SharedUtils.getInt(this.context, SharedConstant.SHOW_ADS_TIMES)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void onClickPay() {
        if (((RechargeInfo) this.item).isFree()) {
            h();
        } else {
            i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void onClickVip() {
        if (((RechargeInfo) this.item).getVipProductEntity() == null || TextUtils.isEmpty(((RechargeInfo) this.item).getVipProductEntity().getProductId()) || TextUtils.isEmpty(((RechargeInfo) this.item).getVipProductEntity().getType())) {
            AppToastUtils.showShortNegativeTipToast(this.context, R.string.base_recharge_failed);
            return;
        }
        String str = "userId=" + AccountCenter.newInstance().userId.get();
        ObservableField<StarCodeUser> observableField = this.f18355a;
        if (observableField != null && observableField.get().getUserId() != 0 && !TextUtils.isEmpty(this.f18355a.get().getStarCode())) {
            str = str + "&starCodeUserId=" + this.f18355a.get().getUserId() + "&starCode=" + this.f18355a.get().getStarCode();
        }
        if (VipProductType.SUB.equals(((RechargeInfo) this.item).getVipProductEntity().getType())) {
            IntentUtils.startSubsGooglePayActivity(this.context, ((RechargeInfo) this.item).getVipProductEntity().getProductId(), BillingClient.SkuType.SUBS, MessageToken.TOKEN_RECHARGE_PAY, str);
        } else {
            IntentUtils.startGooglePayActivity(this.context, ((RechargeInfo) this.item).getVipProductEntity().getProductId(), MessageToken.TOKEN_RECHARGE_PAY, str);
        }
        VipManager.reportRechargePageVipClick(this.context, String.valueOf(((RechargeInfo) this.item).getVipProductEntity().getLevel()));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public RechargeInfo getItem() {
        return (RechargeInfo) super.getItem();
    }
}
