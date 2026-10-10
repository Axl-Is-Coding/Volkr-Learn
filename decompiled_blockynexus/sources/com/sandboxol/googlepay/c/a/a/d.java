package com.sandboxol.googlepay.c.a.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.databinding.ObservableField;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.ProductEntity;
import com.sandboxol.center.entity.StarCodeUser;
import com.sandboxol.center.router.manager.VipManager;
import com.sandboxol.center.utils.Helper;
import com.sandboxol.center.utils.IntentUtils;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.FirebaseUtils;
import rx.functions.Action0;

/* JADX INFO: compiled from: PayViewModel.java */
/* JADX INFO: loaded from: classes3.dex */
public class d extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f18336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ProductEntity f18337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private StarCodeUser f18338c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<String> f18339d = new ObservableField<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ReplyCommand f18340e = new ReplyCommand(new Action0() { // from class: com.sandboxol.googlepay.c.a.a.a
        @Override // rx.functions.Action0
        public final void call() {
            this.f18333a.i();
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ReplyCommand f18341f = new ReplyCommand(new Action0() { // from class: com.sandboxol.googlepay.c.a.a.b
        @Override // rx.functions.Action0
        public final void call() {
            this.f18334a.f();
        }
    });

    public d(Context context, ProductEntity productEntity, StarCodeUser starCodeUser) {
        this.f18336a = context;
        this.f18337b = productEntity;
        this.f18338c = starCodeUser;
        j();
    }

    private void h() {
        if (this.f18337b.getProductId().contains(StringConstant.MONEY_TYPE_DIAMOND) || this.f18337b.getProductId().contains("cube")) {
            StarCodeUser starCodeUser = this.f18338c;
            ReportDataAdapter.onEvent(this.f18336a, starCodeUser != null && (starCodeUser.getUserId() > 0L ? 1 : (starCodeUser.getUserId() == 0L ? 0 : -1)) != 0 && !TextUtils.isEmpty(this.f18338c.getStarCode()) ? EventConstant.STAR_TOPUP_DIAMONDS_STAR : EventConstant.TOPUP_DIAMONDS, this.f18337b.getProductId());
            FirebaseUtils.onEvent(this.f18336a, EventConstant.TOPUP_DIAMONDS, this.f18337b.getProductId());
        } else if (this.f18337b.getProductId().contains("vip")) {
            ReportDataAdapter.onEvent(this.f18336a, EventConstant.TOPUP_VIP, this.f18337b.getProductId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        String str = "userId=" + AccountCenter.newInstance().userId.get();
        StarCodeUser starCodeUser = this.f18338c;
        if (starCodeUser != null && starCodeUser.getUserId() != 0 && !TextUtils.isEmpty(this.f18338c.getStarCode())) {
            str = str + "&starCodeUserId=" + this.f18338c.getUserId() + "&starCode=" + this.f18338c.getStarCode();
        }
        IntentUtils.startGooglePayActivity(this.f18336a, this.f18337b.getProductId(), MessageToken.TOKEN_RECHARGE_PAY, str);
        h();
    }

    private void j() {
        this.f18339d.set(Helper.getVipLeftTime(AccountCenter.newInstance().vip.get().intValue(), this.f18337b.getMonth(), this.f18337b.getLevel(), AccountCenter.newInstance().expireDate.get()));
    }

    public /* synthetic */ void f() {
        VipManager.enterVipFragment(this.f18336a);
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        super.onDestroy();
        Messenger.getDefault().unregister(this);
    }
}
