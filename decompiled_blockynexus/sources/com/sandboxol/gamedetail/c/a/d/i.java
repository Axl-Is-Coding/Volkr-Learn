package com.sandboxol.gamedetail.c.a.d;

import android.content.Context;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.entity.GameDetailShop;
import com.sandboxol.center.router.moduleInfo.game.EngineEnv;
import com.sandboxol.center.web.GameApi;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import com.sandboxol.gamedetail.R;
import java.util.List;

/* JADX INFO: compiled from: GameDetailShopListModel.java */
/* JADX INFO: loaded from: classes3.dex */
public class i extends DataListModel<GameDetailShop> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f18109a;

    public i(Context context, int i, String str) {
        super(context, i);
        this.f18109a = str;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<GameDetailShop> getItemViewModel(GameDetailShop gameDetailShop) {
        return new h(this.context, gameDetailShop, this.f18109a);
    }

    @Override // com.sandboxol.common.base.model.DefaultListModel, com.sandboxol.common.base.model.IListModel
    public String getRefreshToken() {
        return MessageToken.TOKEN_REFRESH_GAME_DETAIL_SHOP;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<GameDetailShop> listItemViewModel) {
        gVar.a(com.sandboxol.gamedetail.a.f17769b, R.layout.item_game_detail_shop);
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<GameDetailShop>> onResponseListener) {
        GameApi.getGameDetailShop(this.context, this.f18109a, (int) EngineEnv.v2().getEngineVersion(), onResponseListener);
    }
}
