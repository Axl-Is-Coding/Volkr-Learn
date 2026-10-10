package com.disabngo.blockynexus.view.dialog.g;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.entity.ScrapRequestTargetInfo;
import com.sandboxol.center.web.ScrapApi;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.common.widget.rv.pagerv.PageListModel;

/* JADX INFO: compiled from: ScrapRequestListModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class j extends PageListModel<ScrapRequestTargetInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f11582b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableField<String> f11583c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<Long> f11584d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObservableField<Integer> f11585e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ObservableField<String> f11586f;

    public j(Context context, String str, ObservableField<Long> observableField, ObservableField<Integer> observableField2, ObservableField<String> observableField3, ObservableField<String> observableField4, int i) {
        super(context, i);
        this.f11581a = str;
        this.f11584d = observableField;
        this.f11585e = observableField2;
        this.f11586f = observableField3;
        this.f11583c = observableField4;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<ScrapRequestTargetInfo> listItemViewModel) {
        gVar.a(2, R.layout.item_scrap_request);
    }

    @Override // com.sandboxol.common.widget.rv.pagerv.PageListModel
    public void onLoad(int i, int i2, OnResponseListener<PageData<ScrapRequestTargetInfo>> onResponseListener) {
        ScrapApi.getRequestTargetInfo(this.context, this.f11581a, i, i2, new i(this, onResponseListener));
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<ScrapRequestTargetInfo> getItemViewModel(ScrapRequestTargetInfo scrapRequestTargetInfo) {
        return new g(this.context, scrapRequestTargetInfo, this.f11584d, this.f11583c);
    }
}
