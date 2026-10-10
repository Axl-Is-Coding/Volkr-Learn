package com.disabngo.blockynexus.e.b.ra;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.TribeRank;
import com.disabngo.blockynexus.web.TribeApi;
import com.sandboxol.center.entity.RankInfo;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.common.widget.rv.pagerv.PageListModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: TribeRankPageListModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class k extends PageListModel<TribeRank> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f10138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ObservableField<List<TribeRank>> f10139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ObservableField<String> f10140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<TribeRank> f10141d;

    public k(Context context, int i, String str, ObservableField<List<TribeRank>> observableField, ObservableField<String> observableField2) {
        super(context, i);
        this.f10141d = new ArrayList();
        this.f10138a = str;
        this.f10139b = observableField;
        this.f10140c = observableField2;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<TribeRank> listItemViewModel) {
        gVar.a(2, R.layout.item_tribe_rank_page);
    }

    @Override // com.sandboxol.common.widget.rv.pagerv.PageListModel
    public void onLoad(int i, int i2, OnResponseListener<PageData<TribeRank>> onResponseListener) {
        if (i <= 50) {
            TribeApi.getAllTribeRank(this.context, this.f10138a, i, i2, new j(this, onResponseListener));
        } else {
            onResponseListener.onSuccess(new PageData<>());
        }
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<TribeRank> getItemViewModel(TribeRank tribeRank) {
        return new i(this.context, tribeRank);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(RankInfo<TribeRank> rankInfo) {
        List<TribeRank> data = rankInfo.getPageData().getData();
        ArrayList arrayList = new ArrayList();
        Iterator<TribeRank> it = data.iterator();
        while (it.hasNext()) {
            TribeRank next = it.next();
            if (arrayList.size() >= 3) {
                break;
            } else if (Integer.valueOf(next.getRank()).intValue() < 4) {
                arrayList.add(next);
                it.remove();
            }
        }
        if (arrayList.size() > 0) {
            this.f10141d.clear();
            this.f10141d.addAll(arrayList);
        }
        this.f10139b.set(this.f10141d);
    }
}
