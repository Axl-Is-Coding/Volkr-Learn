package com.disabngo.blockynexus.view.activity.videodetail;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.web.VideoApi;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.common.widget.rv.pagerv.PageListModel;
import com.sandboxol.greendao.entity.VideoInfo;
import java.util.List;

/* JADX INFO: compiled from: VideoDetailMoreListModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class w extends PageListModel<VideoInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f11225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f11226b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<String> f11227c;

    public w(Context context, int i, long j, long j2, List<String> list) {
        super(context, i);
        this.f11225a = j;
        this.f11226b = j2;
        this.f11227c = list;
    }

    @Override // com.sandboxol.common.base.model.DefaultListModel, com.sandboxol.common.base.model.IListModel
    public String getRefreshToken() {
        return MessageToken.TOKEN_VIDEO_DETAIL_LIST_REFRESH;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 2;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<VideoInfo> listItemViewModel) {
        if (listItemViewModel.getItem().isFirst()) {
            gVar.a(1, R.layout.item_app_video_detail_more_top);
        } else {
            gVar.a(1, R.layout.item_app_video_detail_more);
        }
    }

    @Override // com.sandboxol.common.widget.rv.pagerv.PageListModel
    public void onLoad(int i, int i2, OnResponseListener<PageData<VideoInfo>> onResponseListener) {
        VideoApi.getMoreVideoByAuthor(this.context, i, i2, this.f11227c, this.f11225a, this.f11226b, new v(this, i, onResponseListener));
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<VideoInfo> getItemViewModel(VideoInfo videoInfo) {
        return videoInfo.isFirst() ? new x(this.context, videoInfo) : new u(this.context, videoInfo);
    }

    public void b(long j) {
        this.f11226b = j;
    }

    public void a(long j) {
        this.f11225a = j;
    }

    public void a(List<String> list) {
        this.f11227c = list;
    }
}
