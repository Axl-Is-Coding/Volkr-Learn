package com.disabngo.blockynexus.view.dialog.videotag;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import com.sandboxol.greendao.entity.VideoTagInfo;
import java.util.List;
import me.tatarka.bindingcollectionadapter2.g;

/* JADX INFO: compiled from: VideoTagListModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class f extends DataListModel<VideoTagInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<VideoTagInfo> f11708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private VideoTagInfo f11709b;

    public f(Context context, int i, List<VideoTagInfo> list, VideoTagInfo videoTagInfo) {
        super(context, i);
        this.f11708a = list;
        this.f11709b = videoTagInfo;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<VideoTagInfo> getItemViewModel(VideoTagInfo videoTagInfo) {
        return new e(this.context, videoTagInfo, this.f11709b);
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(g gVar, int i, ListItemViewModel<VideoTagInfo> listItemViewModel) {
        gVar.a(1, R.layout.item_app_dialog_video_tag);
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<VideoTagInfo>> onResponseListener) {
        onResponseListener.onSuccess(this.f11708a);
    }
}
