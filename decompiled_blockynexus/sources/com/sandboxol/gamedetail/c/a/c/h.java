package com.sandboxol.gamedetail.c.a.c;

import android.content.Context;
import com.sandboxol.center.entity.CampaignRank;
import com.sandboxol.center.web.GameApi;
import com.sandboxol.common.interfaces.OnDataListener;

/* JADX INFO: compiled from: GameDetailRankModel.java */
/* JADX INFO: loaded from: classes3.dex */
public class h {
    public void a(Context context, String str, String str2, OnDataListener<CampaignRank> onDataListener) {
        GameApi.getGameMyRank(context, str, str2, new g(this, onDataListener, context));
    }
}
