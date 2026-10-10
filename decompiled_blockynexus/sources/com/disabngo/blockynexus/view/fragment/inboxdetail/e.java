package com.disabngo.blockynexus.view.fragment.inboxdetail;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.Attachment;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import java.util.List;

/* JADX INFO: compiled from: InboxDetailAttachmentListModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends DataListModel<Attachment> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<Attachment> f11742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ObservableField<Integer> f11743b;

    public e(Context context, int i, List<Attachment> list, ObservableField<Integer> observableField) {
        super(context, i);
        this.f11742a = list;
        this.f11743b = observableField;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<Attachment> getItemViewModel(Attachment attachment) {
        return new f(this.context, attachment, this.f11743b);
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<Attachment> listItemViewModel) {
        gVar.a(2, R.layout.item_inbox_detail_attachment);
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<Attachment>> onResponseListener) {
        onResponseListener.onSuccess(this.f11742a);
    }
}
