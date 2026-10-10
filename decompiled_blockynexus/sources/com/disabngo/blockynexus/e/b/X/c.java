package com.disabngo.blockynexus.e.b.X;

import android.content.Context;
import androidx.databinding.ObservableList;
import com.disabngo.blockynexus.d.A;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.common.web.error.ServerOnError;
import java.util.Map;

/* JADX INFO: compiled from: RecommendModel.java */
/* JADX INFO: loaded from: classes2.dex */
class c extends OnResponseListener<Map<String, Integer>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f9582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ObservableList f9583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ d f9584c;

    c(d dVar, Context context, ObservableList observableList) {
        this.f9584c = dVar;
        this.f9582a = context;
        this.f9583b = observableList;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Map<String, Integer> map) {
        for (String str : map.keySet()) {
            if (map.get(str).intValue() > SharedUtils.getLong(this.f9582a, "game.update.sp.name", "game.update.content.count" + str + AccountCenter.newInstance().userId.get()) && !this.f9583b.contains(str)) {
                this.f9583b.add(str);
            }
        }
        if (this.f9583b.isEmpty()) {
            return;
        }
        Messenger.getDefault().send(A.a(this.f9583b), MessageToken.TOKEN_GAME_UPDATE_CONTENT_REFRESH);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f9582a, i);
    }
}
