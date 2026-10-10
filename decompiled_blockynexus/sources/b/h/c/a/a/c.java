package b.h.c.a.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.e;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.ProductEntity;
import com.sandboxol.center.router.moduleInfo.pay.RechargeBroadcastType;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.dialog.HideNavigationBarDialog;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.game.R;
import com.sandboxol.game.a.AbstractC2668g;
import com.sandboxol.messager.MessagerClient;
import com.sandboxol.messager.a.f;
import rx.functions.Action0;

/* JADX INFO: compiled from: RechargeDetailDialog.java */
/* JADX INFO: loaded from: classes4.dex */
public class c extends HideNavigationBarDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ProductEntity f2812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ReplyCommand f2814c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ReplyCommand f2815d;

    public c(Context context, ProductEntity productEntity, String str) {
        super(context);
        this.f2814c = new ReplyCommand(new Action0() { // from class: b.h.c.a.a.b
            @Override // rx.functions.Action0
            public final void call() {
                this.f2811a.onClose();
            }
        });
        this.f2815d = new ReplyCommand(new Action0() { // from class: b.h.c.a.a.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f2810a.a();
            }
        });
        this.f2812a = productEntity;
        this.f2813b = str;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        try {
            if (!TextUtils.isEmpty(this.f2813b) && this.f2813b.contains("starCodeUserId")) {
                ReportDataAdapter.onEvent(this.context, EventConstant.STAR_CLICK_GAME_CODEPAY_GGPAY, this.f2812a.getProductId());
            }
            f fVar = new f();
            fVar.b(StringConstant.PRODUCT_ID, this.f2812a.getProductId());
            fVar.b(StringConstant.RECHARGE_PARAMS, this.f2813b);
            MessagerClient.getIns().sendMsg1(RechargeBroadcastType.NAME_INTENT_UTILS, fVar);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClose() {
        if (isShowing()) {
            ReportDataAdapter.onEvent(this.context, EventConstant.STAR_CLICK_CODEPAY_CLOSE);
            cancel();
        }
    }

    public void initView() {
        AbstractC2668g abstractC2668g = (AbstractC2668g) e.a(LayoutInflater.from(this.context), R.layout.dialog_recharge_detail, (ViewGroup) null, false);
        abstractC2668g.a(this);
        setContentView(abstractC2668g.getRoot());
        ReportDataAdapter.onEvent(this.context, EventConstant.STAR_GAMESHOW_CODEPAY);
    }
}
