package com.disabngo.blockynexus.e.b.y;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.sandboxol.center.download.utils.GameDownloadUtils;
import com.sandboxol.center.entity.AppEngineResourceUpdateResult;
import com.sandboxol.center.router.moduleInfo.game.team.entity.GameMassage;
import com.sandboxol.center.utils.DialogUtils;
import com.sandboxol.center.web.GameApi;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.imchat.web.error.PartyOnError;
import java.util.List;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.y.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: CheckGameInfoUtils.java */
/* JADX INFO: loaded from: classes2.dex */
class C0956g extends OnResponseListener<List<AppEngineResourceUpdateResult>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f10373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f10374b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f10375c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f10376d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ GameMassage f10377e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ ObservableField f10378f;
    final /* synthetic */ C0958i g;

    C0956g(C0958i c0958i, Context context, String str, long j, String str2, GameMassage gameMassage, ObservableField observableField) {
        this.g = c0958i;
        this.f10373a = context;
        this.f10374b = str;
        this.f10375c = j;
        this.f10376d = str2;
        this.f10377e = gameMassage;
        this.f10378f = observableField;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        DialogUtils.newsInstant().hideLoadingDialog();
        PartyOnError.showErrorTip(this.f10373a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        DialogUtils.newsInstant().hideLoadingDialog();
        PartyOnError.showServerError(this.f10373a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(List<AppEngineResourceUpdateResult> list) {
        boolean zIsNeedUpdate = GameDownloadUtils.isNeedUpdate(list);
        if (com.disabngo.blockynexus.e.f9061e.booleanValue()) {
            zIsNeedUpdate = false;
        }
        if (zIsNeedUpdate) {
            GameApi.gameDetail(this.f10373a, this.f10374b, this.f10375c, new C0955f(this, list));
        } else if (this.g.f10384b != null) {
            this.g.f10384b.a(this.f10373a, this.f10377e);
        } else {
            C0958i.b(this.f10373a, this.f10377e);
        }
        DialogUtils.newsInstant().hideLoadingDialog();
    }
}
