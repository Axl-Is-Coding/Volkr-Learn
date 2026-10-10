package com.sandboxol.googlepay.view.fragment.recharge;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.databinding.ObservableField;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.ProductEntity;
import com.sandboxol.center.entity.StarCodeUser;
import com.sandboxol.center.router.manager.AdsManager;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.FirebaseUtils;
import com.sandboxol.googlepay.R;
import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public class RechargeItemViewModel extends ListItemViewModel<ProductEntity> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ObservableField<StarCodeUser> f18360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableField<Integer> f18361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ReplyCommand f18362c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ReplyCommand f18363d;

    /* JADX WARN: Multi-variable type inference failed */
    private void f() {
        if (!((ProductEntity) this.item).isFree() || !AdsManager.isShowIronAds(this.context, 2, 5)) {
            AppToastUtils.showShortNegativeTipToast(this.context, R.string.googleplay_ads_cant_watch_today);
            return;
        }
        AdsManager.showRewardVideo(5);
        this.f18361b.set(Integer.valueOf(r0.get().intValue() - 1));
        ReportDataAdapter.onEvent(this.context, EventConstant.CLICK_TOPUP_AD);
        FirebaseUtils.onEvent(this.context, EventConstant.CLICK_TOPUP_AD);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void onClickPay() {
        if (((ProductEntity) this.item).isFree()) {
            f();
            return;
        }
        ReportDataAdapter.onEvent(this.context, this.f18360a.get() != null && (this.f18360a.get().getUserId() > 0L ? 1 : (this.f18360a.get().getUserId() == 0L ? 0 : -1)) != 0 && !TextUtils.isEmpty(this.f18360a.get().getStarCode()) ? EventConstant.STAR_CLICK_DIAMONDS_STAR : EventConstant.CLICK_DIAMONDS, ((ProductEntity) this.item).getProductId());
        Bundle bundle = new Bundle();
        bundle.putSerializable(StringConstant.DIAMOND_PRODUCT_INFO, (Serializable) this.item);
        bundle.putParcelable(StringConstant.DIAMOND_STAR_CODE_INFO, this.f18360a.get());
        Context context = this.context;
        TemplateUtils.startTemplate(context, com.sandboxol.googlepay.c.a.a.c.class, context.getString(R.string.googleplay_pay_choose_pay_mode), bundle);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public ProductEntity getItem() {
        return (ProductEntity) super.getItem();
    }
}
