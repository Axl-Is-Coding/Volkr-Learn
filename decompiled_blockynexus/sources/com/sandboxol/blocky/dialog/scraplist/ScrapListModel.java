package com.sandboxol.blocky.dialog.scraplist;

import android.content.Context;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import com.sandboxol.game.R;
import com.sandboxol.greendao.entity.ScrapTreasureRewardInfo;
import java.util.List;
import me.tatarka.bindingcollectionadapter2.g;

/* JADX INFO: loaded from: classes.dex */
public class ScrapListModel extends DataListModel<ScrapTreasureRewardInfo> {
    private List<ScrapTreasureRewardInfo> rewardInfos;

    public ScrapListModel(Context context, int i, List<ScrapTreasureRewardInfo> list) {
        super(context, i);
        this.rewardInfos = list;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(g gVar, int i, ListItemViewModel<ScrapTreasureRewardInfo> listItemViewModel) {
        gVar.a(com.sandboxol.game.a.f17627b, R.layout.item_scrap_list);
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<ScrapTreasureRewardInfo>> onResponseListener) {
        onResponseListener.onSuccess(this.rewardInfos);
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public ListItemViewModel<ScrapTreasureRewardInfo> getItemViewModel(ScrapTreasureRewardInfo scrapTreasureRewardInfo) {
        return new ScrapListItemViewModel(this.context, scrapTreasureRewardInfo);
    }
}
