package com.disabngo.blockynexus.e.b.da;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.entity.ScrapRewardInfo;
import com.sandboxol.center.web.ScrapApi;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.common.widget.rv.pagerv.PageListModel;
import java.util.Map;

/* JADX INFO: compiled from: ScrapMainListModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class l extends PageListModel<ScrapRewardInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ObservableField<Boolean> f9708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f9709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f9710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f9711d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<Integer, Boolean> f9712e;

    public l(Context context, ObservableField<Boolean> observableField, int i, Map<Integer, Boolean> map, int i2, int i3) {
        super(context, i3);
        this.f9708a = observableField;
        this.f9709b = i;
        this.f9712e = map;
        this.f9710c = i2;
    }

    @Override // com.sandboxol.common.base.model.DefaultListModel, com.sandboxol.common.base.model.IListModel
    public String getRefreshToken() {
        return MessageToken.TOKEN_REFRESH_SCRAP_LIST + this.f9710c;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<ScrapRewardInfo> listItemViewModel) {
        gVar.a(2, R.layout.item_scrap_main);
    }

    @Override // com.sandboxol.common.widget.rv.pagerv.PageListModel
    public void onLoad(int i, int i2, OnResponseListener<PageData<ScrapRewardInfo>> onResponseListener) {
        Map<Integer, Boolean> map = this.f9712e;
        if (map == null) {
            return;
        }
        if (map.get(Integer.valueOf(this.f9710c)).booleanValue()) {
            ScrapApi.getScrapRewardList(this.context, this.f9709b, i, i2, new k(this, onResponseListener));
        } else {
            onResponseListener.onSuccess(null);
        }
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<ScrapRewardInfo> getItemViewModel(ScrapRewardInfo scrapRewardInfo) {
        return new j(this.context, scrapRewardInfo, this.f9708a);
    }
}
