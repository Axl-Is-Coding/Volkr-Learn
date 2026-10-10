package com.sandboxol.recharge.dialog.rechargeshop;

import android.content.Context;
import android.text.TextUtils;
import androidx.databinding.ObservableField;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.ProductEntity;
import com.sandboxol.center.entity.StarCodeUser;
import com.sandboxol.center.router.moduleInfo.game.GameBroadcastType;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.messager.MessagerClient;
import rx.functions.Action0;

/* JADX INFO: compiled from: RechargeShopItemViewModel.java */
/* JADX INFO: loaded from: classes4.dex */
public class l extends ListItemViewModel<ProductEntity> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ReplyCommand f18877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f18878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ObservableField<StarCodeUser> f18879c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f18880d;

    public l(Context context, ObservableField<StarCodeUser> observableField, ProductEntity productEntity, String str) {
        super(context, productEntity);
        this.f18877a = new ReplyCommand(new Action0() { // from class: com.sandboxol.recharge.dialog.rechargeshop.g
            @Override // rx.functions.Action0
            public final void call() {
                this.f18867a.f();
            }
        });
        this.f18880d = "";
        this.f18878b = str;
        this.f18879c = observableField;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void f() {
        this.f18880d = "";
        if (TextUtils.isEmpty(this.f18878b)) {
            ObservableField<StarCodeUser> observableField = this.f18879c;
            if (observableField != null && observableField.get().getUserId() != 0 && !TextUtils.isEmpty(this.f18879c.get().getStarCode())) {
                this.f18880d = "starCodeUserId=" + this.f18879c.get().getUserId() + "&starCode=" + this.f18879c.get().getStarCode();
            }
        } else {
            ObservableField<StarCodeUser> observableField2 = this.f18879c;
            if (observableField2 != null && observableField2.get().getUserId() != 0 && !TextUtils.isEmpty(this.f18879c.get().getStarCode())) {
                this.f18880d = "&starCodeUserId=" + this.f18879c.get().getUserId() + "&starCode=" + this.f18879c.get().getStarCode();
            }
        }
        ObservableField<StarCodeUser> observableField3 = this.f18879c;
        if ((observableField3 == null || observableField3.get().getUserId() == 0 || TextUtils.isEmpty(this.f18879c.get().getStarCode())) ? false : true) {
            ReportDataAdapter.onEvent(this.context, EventConstant.STAR_CLICK_GAMETP_USECODEBUY, ((ProductEntity) this.item).getProductId());
        }
        new b.h.c.a.a.c(this.context, (ProductEntity) this.item, this.f18878b + this.f18880d).show();
        com.sandboxol.messager.a.f fVar = new com.sandboxol.messager.a.f();
        fVar.b(StringConstant.PRODUCT_ID, ((ProductEntity) this.item).getProductId());
        MessagerClient.getIns().sendMsg1(GameBroadcastType.TOP_UP_DIAMONDS_GAME, fVar);
    }
}
