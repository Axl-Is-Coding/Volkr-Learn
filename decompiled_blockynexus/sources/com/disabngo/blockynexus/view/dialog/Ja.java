package com.disabngo.blockynexus.view.dialog;

import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.entity.ScrapRewardComposeInfo;
import com.sandboxol.center.web.error.ScrapOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;

/* JADX INFO: compiled from: ScrapRewardDetailsDialog.java */
/* JADX INFO: loaded from: classes2.dex */
class Ja extends OnResponseListener<ScrapRewardComposeInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f11313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Pa f11314b;

    Ja(Pa pa, boolean z) {
        this.f11314b = pa;
        this.f11313a = z;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(ScrapRewardComposeInfo scrapRewardComposeInfo) {
        if (scrapRewardComposeInfo == null) {
            return;
        }
        this.f11314b.a(this.f11313a, scrapRewardComposeInfo);
        ReportDataAdapter.onEvent(((FullScreenDialog) this.f11314b).context, EventConstant.REDEEM_ITEM_SUC);
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_REFRESH_SCRAP_RED_POINT_NUM);
        if (scrapRewardComposeInfo.getRewardType() == 1) {
            Messenger.getDefault().send(5, MessageToken.TOKEN_ACCOUNT);
            return;
        }
        if (scrapRewardComposeInfo.getRewardType() == 3) {
            Messenger.getDefault().send(RefreshMsg.create(), MessageToken.TOKEN_REFRESH_DECORATION_TYPE + scrapRewardComposeInfo.getDecorationType());
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        if (i == 5008) {
            AppToastUtils.showShortNegativeTipToast(((FullScreenDialog) this.f11314b).context, R.string.app_scrap_status_tips_2);
        } else {
            ScrapOnError.showErrorTip(((FullScreenDialog) this.f11314b).context, i);
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(((FullScreenDialog) this.f11314b).context, i);
    }
}
