package com.sandboxol.center.router.moduleApi;

import android.content.Context;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.greendao.entity.Game;

/* JADX INFO: loaded from: classes3.dex */
public interface IGameDetailService extends IBaseService {
    void enterGameDetail(Context context, String str, Game game);

    void enterGameDetail(Context context, String str, String str2);

    void gameDetail(Context context, String str, long j, OnResponseListener<Game> onResponseListener);
}
