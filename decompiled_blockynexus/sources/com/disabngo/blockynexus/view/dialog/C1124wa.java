package com.disabngo.blockynexus.view.dialog;

import android.content.Intent;
import android.net.Uri;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.dialog.DialogC1122va;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.UrlConstant;
import com.sandboxol.center.entity.AppInfoCenter;
import com.sandboxol.center.router.manager.LoginManager;
import com.sandboxol.center.view.dialog.OneButtonDialog;
import com.sandboxol.center.view.dialog.TwoButtonDialog;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.HttpUtils;
import com.sandboxol.greendao.entity.MiniGameToken;

/* JADX INFO: renamed from: com.disabngo.blockynexus.view.dialog.wa, reason: case insensitive filesystem */
/* JADX INFO: compiled from: EnterMiniGameDialog.java */
/* JADX INFO: loaded from: classes2.dex */
class C1124wa extends OnResponseListener<MiniGameToken> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ DialogC1122va.b f11711a;

    C1124wa(DialogC1122va.b bVar) {
        this.f11711a = bVar;
    }

    public /* synthetic */ void a() {
        DialogC1122va.this.f11691a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(UrlConstant.PLAY_STORE_URL)));
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        DialogC1122va.this.c();
        if (i == 7) {
            LoginManager.switchAccount(DialogC1122va.this.f11691a);
        } else if (i == 2009) {
            new TwoButtonDialog(DialogC1122va.this.f11691a).setRightButtonText(R.string.dialog_button_update).setListener(new TwoButtonDialog.OnTwoButtonDialogClickListener() { // from class: com.disabngo.blockynexus.view.dialog.g
                @Override // com.sandboxol.center.view.dialog.TwoButtonDialog.OnTwoButtonDialogClickListener
                public final void onClick() {
                    this.f11564a.a();
                }
            }).setDetailText(R.string.play_game_after_update).show();
        } else if (i == 2 || i == 4) {
            new OneButtonDialog(DialogC1122va.this.f11691a).setDetailText(R.string.enter_mini_game_map_not_found).show();
        } else {
            AppToastUtils.showShortNegativeTipToast(DialogC1122va.this.f11691a, HttpUtils.getHttpErrorMsg(DialogC1122va.this.f11691a, i));
        }
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_ENTER_GAME_SUCCESS_CLICK);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        if (i != 2) {
            this.f11711a.f11699b.set(true);
            DialogC1122va.b bVar = this.f11711a;
            bVar.f11698a.set(HttpUtils.getHttpErrorMsg(DialogC1122va.this.f11691a, i));
            ReportDataAdapter.onEvent(DialogC1122va.this.f11691a, EventConstant.ENTER_GAME_TIMEOUT, String.valueOf(i));
        } else {
            AppToastUtils.showShortNegativeTipToast(DialogC1122va.this.f11691a, DialogC1122va.this.f11691a.getString(R.string.base_invalid_argument));
            DialogC1122va.this.c();
        }
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_ENTER_GAME_SUCCESS_CLICK);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(MiniGameToken miniGameToken) {
        AppInfoCenter.newInstance().setLatelyRegion(miniGameToken.getRegion() == 0 ? NativeContentAd.ASSET_HEADLINE : String.valueOf(miniGameToken.getRegion()));
        this.f11711a.a(miniGameToken);
    }
}
