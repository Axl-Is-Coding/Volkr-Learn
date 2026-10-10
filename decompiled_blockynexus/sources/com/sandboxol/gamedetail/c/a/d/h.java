package com.sandboxol.gamedetail.c.a.d;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.GameDetailShop;
import com.sandboxol.center.utils.DialogUtils;
import com.sandboxol.center.utils.TimeUtil;
import com.sandboxol.center.view.dialog.PayGdiamondDialog;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.DateUtils;
import com.sandboxol.gamedetail.R;
import rx.functions.Action0;

/* JADX INFO: compiled from: GameDetailShopItemViewModel.java */
/* JADX INFO: loaded from: classes3.dex */
public class h extends ListItemViewModel<GameDetailShop> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f18105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableField<String> f18106b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ReplyCommand f18107c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ReplyCommand f18108d;

    public h(Context context, GameDetailShop gameDetailShop, String str) {
        super(context, gameDetailShop);
        this.f18106b = new ObservableField<>();
        this.f18107c = new ReplyCommand(new Action0() { // from class: com.sandboxol.gamedetail.c.a.d.d
            @Override // rx.functions.Action0
            public final void call() {
                this.f18103a.i();
            }
        });
        this.f18108d = new ReplyCommand(new Action0() { // from class: com.sandboxol.gamedetail.c.a.d.c
            @Override // rx.functions.Action0
            public final void call() {
                this.f18102a.h();
            }
        });
        this.f18105a = str;
        if (gameDetailShop.getExpireDate() != null) {
            this.f18106b.set(DateUtils.timeStamp2Date(Long.parseLong(gameDetailShop.getExpireDate()), TimeUtil.DEFAULT_DAY_NO_SEPRATOR));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void h() {
        if (!AccountCenter.newInstance().login.get().booleanValue()) {
            AppToastUtils.showShortNegativeTipToast(this.context, R.string.gamedetail_not_login);
            return;
        }
        ReportDataAdapter.onEvent(this.context, EventConstant.CLICK_BUY_GOODS);
        if (((GameDetailShop) this.item).getCurrency() == 2 || ((GameDetailShop) this.item).getPrice() <= AccountCenter.newInstance().diamonds.get().longValue()) {
            f();
        } else {
            DialogUtils.newsInstant().showPayGdiamondDialog(this.context, (int) (((long) ((GameDetailShop) this.item).getPrice()) - AccountCenter.newInstance().diamonds.get().longValue()), new PayGdiamondDialog.OnTwoButtonDialogClickListener() { // from class: com.sandboxol.gamedetail.c.a.d.b
                @Override // com.sandboxol.center.view.dialog.PayGdiamondDialog.OnTwoButtonDialogClickListener
                public final void onClick() {
                    this.f18101a.f();
                }
            }, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void i() {
        com.sandboxol.gamedetail.view.dialog.e eVar = new com.sandboxol.gamedetail.view.dialog.e(this.context);
        eVar.a((GameDetailShop) this.item);
        eVar.show();
        ReportDataAdapter.onEvent(this.context, EventConstant.CLICK_GOODS_DETAIL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void f() {
        com.sandboxol.gamedetail.web.c.a(this.context, this.f18105a, ((GameDetailShop) this.item).getId(), new g(this));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public GameDetailShop getItem() {
        return (GameDetailShop) super.getItem();
    }
}
