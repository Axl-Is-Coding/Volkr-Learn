package com.sandboxol.videosubmit.view.dialog.signupinfo;

import android.content.Context;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import com.sandboxol.videosubmit.BR;
import com.sandboxol.videosubmit.R;
import java.util.List;
import me.tatarka.bindingcollectionadapter2.g;

/* JADX INFO: loaded from: classes4.dex */
public class LinkListModel extends DataListModel<String> {
    private List<String> links;

    public LinkListModel(Context context, int i, List<String> list) {
        super(context, i);
        this.links = list;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(g gVar, int i, ListItemViewModel<String> listItemViewModel) {
        gVar.a(BR.ViewModel, R.layout.videosubmit_item_link);
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<String>> onResponseListener) {
        onResponseListener.onSuccess(this.links);
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public ListItemViewModel<String> getItemViewModel(String str) {
        return new LinkItemViewModel(this.context, str);
    }
}
