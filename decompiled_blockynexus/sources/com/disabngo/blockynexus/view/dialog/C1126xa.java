package com.disabngo.blockynexus.view.dialog;

import android.content.Intent;
import android.net.Uri;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.dialog.DialogC1122va;
import com.sandboxol.center.config.UrlConstant;
import com.sandboxol.center.router.manager.LoginManager;
import com.sandboxol.center.view.dialog.TwoButtonDialog;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.HttpUtils;
import com.sandboxol.greendao.entity.Dispatch;

/* JADX INFO: renamed from: com.disabngo.blockynexus.view.dialog.xa, reason: case insensitive filesystem */
/* JADX INFO: compiled from: EnterMiniGameDialog.java */
/* JADX INFO: loaded from: classes2.dex */
class C1126xa extends OnResponseListener<Dispatch> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ DialogC1122va.b f11713a;

    C1126xa(DialogC1122va.b bVar) {
        this.f11713a = bVar;
    }

    public /* synthetic */ void a() {
        DialogC1122va.this.f11691a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(UrlConstant.PLAY_STORE_URL)));
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        DialogC1122va.this.c();
        if (i == 2) {
            AppToastUtils.showShortNegativeTipToast(DialogC1122va.this.f11691a, R.string.follow_friend_failed);
            com.disabngo.blockynexus.d.n.a(DialogC1122va.this.f11691a, DialogC1122va.this.f11691a.getString(R.string.follow_friend_failed));
            return;
        }
        if (i == 3) {
            AppToastUtils.showShortNegativeTipToast(DialogC1122va.this.f11691a, R.string.game_detail_appreciation_game_not_exist);
            com.disabngo.blockynexus.d.n.a(DialogC1122va.this.f11691a, DialogC1122va.this.f11691a.getString(R.string.game_detail_appreciation_game_not_exist));
            return;
        }
        if (i == 4) {
            AppToastUtils.showShortNegativeTipToast(DialogC1122va.this.f11691a, R.string.game_version_not_match);
            com.disabngo.blockynexus.d.n.a(DialogC1122va.this.f11691a, DialogC1122va.this.f11691a.getString(R.string.game_version_not_match));
            return;
        }
        if (i == 7) {
            LoginManager.switchAccount(DialogC1122va.this.f11691a);
            return;
        }
        if (i == 10) {
            AppToastUtils.showShortNegativeTipToast(DialogC1122va.this.f11691a, R.string.follow_friend_is_finish);
            com.disabngo.blockynexus.d.n.a(DialogC1122va.this.f11691a, DialogC1122va.this.f11691a.getString(R.string.follow_friend_is_finish));
            return;
        }
        if (i == 11) {
            AppToastUtils.showShortNegativeTipToast(DialogC1122va.this.f11691a, R.string.follow_friend_is_full);
            com.disabngo.blockynexus.d.n.a(DialogC1122va.this.f11691a, DialogC1122va.this.f11691a.getString(R.string.follow_friend_is_full));
            return;
        }
        if (i == 12) {
            AppToastUtils.showShortNegativeTipToast(DialogC1122va.this.f11691a, R.string.follow_friend_not_support_watch);
            com.disabngo.blockynexus.d.n.a(DialogC1122va.this.f11691a, DialogC1122va.this.f11691a.getString(R.string.follow_friend_not_support_watch));
            return;
        }
        if (i == 14) {
            AppToastUtils.showShortNegativeTipToast(DialogC1122va.this.f11691a, R.string.follow_friend_engine_version_not_support);
            com.disabngo.blockynexus.d.n.a(DialogC1122va.this.f11691a, DialogC1122va.this.f11691a.getString(R.string.follow_friend_engine_version_not_support));
            return;
        }
        if (i == 15) {
            AppToastUtils.showShortNegativeTipToast(DialogC1122va.this.f11691a, R.string.follow_friend_not_in_game);
            com.disabngo.blockynexus.d.n.a(DialogC1122va.this.f11691a, DialogC1122va.this.f11691a.getString(R.string.follow_friend_not_in_game));
            return;
        }
        if (i == 16) {
            AppToastUtils.showShortNegativeTipToast(DialogC1122va.this.f11691a, R.string.follow_friend_is_watching);
            com.disabngo.blockynexus.d.n.a(DialogC1122va.this.f11691a, DialogC1122va.this.f11691a.getString(R.string.follow_friend_is_watching));
            return;
        }
        if (i == 2009) {
            new TwoButtonDialog(DialogC1122va.this.f11691a).setRightButtonText(R.string.dialog_button_update).setListener(new TwoButtonDialog.OnTwoButtonDialogClickListener() { // from class: com.disabngo.blockynexus.view.dialog.h
                @Override // com.sandboxol.center.view.dialog.TwoButtonDialog.OnTwoButtonDialogClickListener
                public final void onClick() {
                    this.f11588a.a();
                }
            }).setDetailText(R.string.play_game_after_update).show();
            com.disabngo.blockynexus.d.n.a(DialogC1122va.this.f11691a, DialogC1122va.this.f11691a.getString(R.string.play_game_after_update));
        } else if (i == 2010) {
            AppToastUtils.showShortNegativeTipToast(DialogC1122va.this.f11691a, R.string.game_version_too_low);
            com.disabngo.blockynexus.d.n.a(DialogC1122va.this.f11691a, DialogC1122va.this.f11691a.getString(R.string.game_version_too_low));
        } else if (i == 2011) {
            AppToastUtils.showShortNegativeTipToast(DialogC1122va.this.f11691a, R.string.follow_friend_not_match);
            com.disabngo.blockynexus.d.n.a(DialogC1122va.this.f11691a, DialogC1122va.this.f11691a.getString(R.string.follow_friend_not_match));
        } else {
            AppToastUtils.showShortNegativeTipToast(DialogC1122va.this.f11691a, HttpUtils.getHttpErrorMsg(DialogC1122va.this.f11691a, i));
            com.disabngo.blockynexus.d.n.a(DialogC1122va.this.f11691a, HttpUtils.getHttpErrorMsg(DialogC1122va.this.f11691a, i));
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        if (i == 2) {
            DialogC1122va.this.c();
            return;
        }
        this.f11713a.f11699b.set(true);
        DialogC1122va.b bVar = this.f11713a;
        bVar.f11698a.set(HttpUtils.getHttpErrorMsg(DialogC1122va.this.f11691a, i));
        com.disabngo.blockynexus.d.n.a(DialogC1122va.this.f11691a, HttpUtils.getHttpErrorMsg(DialogC1122va.this.f11691a, i));
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Dispatch dispatch) {
        this.f11713a.a(dispatch, true);
    }
}
