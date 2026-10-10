package com.sandboxol.gamedetail.c.a.b;

import android.content.Context;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import com.sandboxol.gamedetail.R;
import com.sandboxol.greendao.entity.BannerPic;
import com.sandboxol.greendao.entity.Game;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: GameDetailIntroduceListModel.java */
/* JADX INFO: loaded from: classes3.dex */
public class h extends DataListModel<BannerPic> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Game f18057a;

    public h(Context context, int i, Game game) {
        super(context, i);
        this.f18057a = game;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<BannerPic> getItemViewModel(BannerPic bannerPic) {
        return bannerPic.isFirst() ? new m(this.context, bannerPic, this.f18057a) : new g(this.context, bannerPic);
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 2;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<BannerPic> listItemViewModel) {
        if (listItemViewModel.getItem().isFirst()) {
            gVar.a(com.sandboxol.gamedetail.a.f17769b, R.layout.item_game_detail_introduce_top);
        } else {
            gVar.a(com.sandboxol.gamedetail.a.f17769b, R.layout.item_game_detail_introduce);
        }
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<BannerPic>> onResponseListener) {
        Game game = this.f18057a;
        if (game == null || game.getWarmUpResponse() == null) {
            onResponseListener.onSuccess(new ArrayList());
        } else {
            onResponseListener.onSuccess(this.f18057a.getWarmUpResponse().getFeaturedPlay());
        }
    }
}
