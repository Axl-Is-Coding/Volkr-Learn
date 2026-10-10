package com.disabngo.blockynexus.e.b.W.b;

import android.content.Context;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.web.RankingApi;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.common.widget.rv.pagerv.PageListModel;
import com.sandboxol.greendao.entity.RankInfoResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ClanRankPageListModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class n extends PageListModel<RankInfoResponse> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f9526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ObservableList<RankInfoResponse> f9527c;
    private Context context;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<RankInfoResponse> f9528d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<RankInfoResponse> f9529e;

    public n(Context context, int i, ObservableList<RankInfoResponse> observableList, ObservableField<RankInfoResponse> observableField, int i2, int i3) {
        super(context, i);
        this.f9529e = new ArrayList();
        this.context = context;
        this.f9527c = observableList;
        this.f9528d = observableField;
        this.f9525a = i2;
        this.f9526b = i3;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<RankInfoResponse> listItemViewModel) {
        gVar.a(361, R.layout.item_rank_detail_content);
    }

    @Override // com.sandboxol.common.widget.rv.pagerv.PageListModel
    public void onLoad(int i, int i2, OnResponseListener<PageData<RankInfoResponse>> onResponseListener) {
        int i3 = this.f9525a;
        if (i3 == 0) {
            int i4 = this.f9526b;
            if (i4 == 0) {
                RankingApi.getClanRegionWeeklyRanks(this.context, i, i2, new i(this, i, onResponseListener));
            } else if (i4 == 1) {
                RankingApi.getClanGlobalWeeklyRanks(this.context, i, i2, new j(this, i, onResponseListener));
            }
        } else if (i3 == 1) {
            int i5 = this.f9526b;
            if (i5 == 0) {
                RankingApi.getClanRegionOverallRanks(this.context, i, i2, new k(this, i, onResponseListener));
            } else if (i5 == 1) {
                RankingApi.getClanGlobalOverallRanks(this.context, i, i2, new l(this, i, onResponseListener));
            }
        }
        a(this.f9525a, this.f9526b);
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<RankInfoResponse> getItemViewModel(RankInfoResponse rankInfoResponse) {
        return new com.disabngo.blockynexus.e.b.W.b(this.context, rankInfoResponse);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PageData<RankInfoResponse> pageData) {
        List<RankInfoResponse> data = pageData.getData();
        ArrayList arrayList = new ArrayList();
        Iterator<RankInfoResponse> it = data.iterator();
        while (it.hasNext()) {
            RankInfoResponse next = it.next();
            if (arrayList.size() >= 3) {
                break;
            } else if (next.getRank() < 4) {
                arrayList.add(next);
                it.remove();
            }
        }
        if (arrayList.size() > 0) {
            this.f9529e.clear();
            this.f9529e.addAll(arrayList);
        }
        this.f9527c.clear();
        this.f9527c.addAll(this.f9529e);
    }

    private void a(int i, int i2) {
        RankingApi.getUserRankInfoResponse(this.context, i == 0 ? "week" : "overall", "clan", i2 == 0, new m(this));
    }
}
