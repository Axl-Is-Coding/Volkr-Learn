package com.sandboxol.blocky.dialog.scrapanim;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import com.sandboxol.game.R;
import com.sandboxol.greendao.entity.ScrapTreasureRewardInfo;
import java.util.List;
import me.tatarka.bindingcollectionadapter2.g;

/* JADX INFO: loaded from: classes.dex */
public class ScrapAnimListModel extends DataListModel<ScrapTreasureRewardInfo> {
    public ObservableField<Boolean> isFromMain;
    private List<ScrapTreasureRewardInfo> rewardInfos;

    public ScrapAnimListModel(Context context, int i, List<ScrapTreasureRewardInfo> list, boolean z) {
        super(context, i);
        this.isFromMain = new ObservableField<>(false);
        this.rewardInfos = list;
        this.isFromMain.set(Boolean.valueOf(z));
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(g gVar, int i, ListItemViewModel<ScrapTreasureRewardInfo> listItemViewModel) {
        gVar.a(com.sandboxol.game.a.f17627b, R.layout.item_scrap_anim);
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<ScrapTreasureRewardInfo>> onResponseListener) {
        List<ScrapTreasureRewardInfo> list = this.rewardInfos;
        if (list == null || list.size() <= 0) {
            return;
        }
        onResponseListener.onSuccess(this.rewardInfos);
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public ListItemViewModel<ScrapTreasureRewardInfo> getItemViewModel(ScrapTreasureRewardInfo scrapTreasureRewardInfo) {
        return new ScrapAnimItemViewModel(this.context, scrapTreasureRewardInfo, this.isFromMain.get().booleanValue());
    }
}
