package com.disabngo.blockynexus.view.widget.gameRank.a;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.GameRankingInfo;
import com.sandboxol.center.web.GameApi;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import java.util.ArrayList;
import java.util.List;
import me.tatarka.bindingcollectionadapter2.g;

/* JADX INFO: compiled from: GameSelectModel.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends DataListModel<GameRankingInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static List<GameRankingInfo> f12090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f12091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f12092c;

    public d(Context context, int i, String str, long j) {
        super(context, i);
        this.f12091b = str;
        this.f12092c = j;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(g gVar, int i, ListItemViewModel<GameRankingInfo> listItemViewModel) {
        gVar.a(300, R.layout.item_window_discover_type_ranking);
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<GameRankingInfo>> onResponseListener) {
        String str = this.f12091b;
        if (str == null || str.isEmpty()) {
            List<GameRankingInfo> list = f12090a;
            if (list != null) {
                onResponseListener.onSuccess(list);
                return;
            } else {
                a(this.context, onResponseListener);
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        GameRankingInfo gameRankingInfo = new GameRankingInfo(-1L, this.context.getString(R.string.dicover_rang_item0), null, R.mipmap.icon_zonghe_ranking, StringConstant.GAME_ORDER_TYPE_COMPLEX);
        GameRankingInfo gameRankingInfo2 = new GameRankingInfo(-1L, this.context.getString(R.string.dicover_rang_item1), null, R.mipmap.icon_online_ranking, StringConstant.GAME_ORDER_TYPE_ONLINE);
        GameRankingInfo gameRankingInfo3 = new GameRankingInfo(-1L, this.context.getString(R.string.dicover_rang_item2), null, R.mipmap.icon_new_game, "new");
        GameRankingInfo gameRankingInfo4 = new GameRankingInfo(-1L, this.context.getString(R.string.dicover_rang_item3), null, R.mipmap.icon_dianzan_ranking, StringConstant.GAME_ORDER_TYPE_APPRECIATE);
        arrayList.add(gameRankingInfo);
        arrayList.add(gameRankingInfo2);
        arrayList.add(gameRankingInfo3);
        arrayList.add(gameRankingInfo4);
        onResponseListener.onSuccess(arrayList);
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<GameRankingInfo> getItemViewModel(GameRankingInfo gameRankingInfo) {
        return new b(this.context, this.f12091b, this.f12092c, gameRankingInfo);
    }

    public static void a(Context context, OnResponseListener<List<GameRankingInfo>> onResponseListener) {
        GameApi.getGameTypeList(context, new c(onResponseListener));
    }
}
