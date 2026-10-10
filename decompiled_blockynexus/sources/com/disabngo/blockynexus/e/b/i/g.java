package com.disabngo.blockynexus.e.b.i;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.entity.VideoStarConfigDescribe;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import java.util.List;

/* JADX INFO: compiled from: CashListModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class g extends DataListModel<VideoStarConfigDescribe> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<VideoStarConfigDescribe> f9818a;

    public g(Context context, List<VideoStarConfigDescribe> list) {
        super(context, R.string.no_data);
        this.f9818a = list;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<VideoStarConfigDescribe> getItemViewModel(VideoStarConfigDescribe videoStarConfigDescribe) {
        return new e(this.context, videoStarConfigDescribe);
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<VideoStarConfigDescribe> listItemViewModel) {
        gVar.a(2, R.layout.item_cash_answering);
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<VideoStarConfigDescribe>> onResponseListener) {
        List<VideoStarConfigDescribe> list = this.f9818a;
        if (list == null || list.size() <= 0) {
            return;
        }
        onResponseListener.onSuccess(this.f9818a);
    }
}
