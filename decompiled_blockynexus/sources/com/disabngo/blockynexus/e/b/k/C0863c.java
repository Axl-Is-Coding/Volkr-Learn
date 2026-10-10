package com.disabngo.blockynexus.e.b.k;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.entity.VideoStarConfigDescribe;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import java.util.List;
import me.tatarka.bindingcollectionadapter2.g;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.k.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: CashHelpListModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class C0863c extends DataListModel<VideoStarConfigDescribe> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<VideoStarConfigDescribe> f9865a;

    public C0863c(Context context, List<VideoStarConfigDescribe> list) {
        super(context, R.string.no_data);
        this.f9865a = list;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<VideoStarConfigDescribe> getItemViewModel(VideoStarConfigDescribe videoStarConfigDescribe) {
        return new C0862b(this.context, videoStarConfigDescribe);
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(g gVar, int i, ListItemViewModel<VideoStarConfigDescribe> listItemViewModel) {
        gVar.a(2, R.layout.item_cash_instructions);
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<VideoStarConfigDescribe>> onResponseListener) {
        List<VideoStarConfigDescribe> list = this.f9865a;
        if (list == null || list.size() <= 0) {
            return;
        }
        onResponseListener.onSuccess(this.f9865a);
    }
}
