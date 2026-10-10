package com.sandboxol.gamedetail.c.a.b;

import android.content.Context;
import android.text.Html;
import androidx.databinding.ObservableField;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.GameUpdateContentInfo;
import com.sandboxol.center.utils.Helper;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: GameDetailIntroduceModel.java */
/* JADX INFO: loaded from: classes3.dex */
class j extends OnResponseListener<GameUpdateContentInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f18062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f18063b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ObservableField f18064c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ObservableField f18065d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ k f18066e;

    j(k kVar, Context context, String str, ObservableField observableField, ObservableField observableField2) {
        this.f18066e = kVar;
        this.f18062a = context;
        this.f18063b = str;
        this.f18064c = observableField;
        this.f18065d = observableField2;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(GameUpdateContentInfo gameUpdateContentInfo) {
        if (gameUpdateContentInfo != null) {
            long count = gameUpdateContentInfo.getCount();
            long j = SharedUtils.getLong(this.f18062a, "game.update.sp.name", "game.update.content.count" + this.f18063b + AccountCenter.newInstance().userId.get(), 0L);
            if (count > j) {
                SharedUtils.putLong(this.f18062a, "game.update.sp.name", "game.update.content.count" + this.f18063b + AccountCenter.newInstance().userId.get(), count);
                SharedUtils.putBoolean(this.f18062a, "game.update.sp.name", "game.update.content.open" + this.f18063b + AccountCenter.newInstance().userId.get(), true);
            }
            if (count >= j) {
                if (!SharedUtils.getBoolean(this.f18062a, "game.update.sp.name", "game.update.content.open" + this.f18063b + AccountCenter.newInstance().userId.get(), false) || gameUpdateContentInfo.getContent() == null) {
                    return;
                }
                this.f18064c.set(Html.fromHtml(Helper.webContent2String(gameUpdateContentInfo.getContent())).toString());
                this.f18065d.set(true);
            }
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f18062a, i);
    }
}
