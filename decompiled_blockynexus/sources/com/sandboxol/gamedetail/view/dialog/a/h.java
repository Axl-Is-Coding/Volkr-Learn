package com.sandboxol.gamedetail.view.dialog.a;

import android.content.Context;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import com.sandboxol.gamedetail.R;
import com.sandboxol.greendao.entity.AuthorInfo;
import java.util.List;

/* JADX INFO: compiled from: AuthorListListModel.java */
/* JADX INFO: loaded from: classes3.dex */
public class h extends DataListModel<AuthorInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<AuthorInfo> f18128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f18129b;

    public h(Context context, int i, List<AuthorInfo> list, boolean z) {
        super(context, i);
        this.f18128a = list;
        this.f18129b = z;
        a(list);
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<AuthorInfo> getItemViewModel(AuthorInfo authorInfo) {
        return new f(this.context, authorInfo, this.f18129b);
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<AuthorInfo> listItemViewModel) {
        gVar.a(com.sandboxol.gamedetail.a.f17769b, R.layout.item_author_list_dialog);
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<AuthorInfo>> onResponseListener) {
        onResponseListener.onSuccess(this.f18128a);
    }

    private void a(List<AuthorInfo> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        list.get(list.size() - 1).setLast(true);
    }
}
