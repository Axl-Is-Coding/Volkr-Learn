package com.disabngo.blockynexus.e.b.xa;

import android.content.Context;
import android.text.TextUtils;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.web.VideoApi;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.common.widget.rv.pagerv.PageListModel;
import com.sandboxol.greendao.c.F;
import com.sandboxol.greendao.entity.VideoInfo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: VideoRecommendPageListModel.java */
/* JADX INFO: loaded from: classes.dex */
public class n extends PageListModel<VideoInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f10339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<String> f10340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ObservableField<Boolean> f10341c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f10342d;

    public n(Context context, int i, String str, List<String> list) {
        super(context, i);
        this.f10342d = false;
        this.f10339a = str;
        this.f10340b = list;
    }

    @Override // com.sandboxol.common.base.model.DefaultListModel, com.sandboxol.common.base.model.IListModel
    public String getLoadMoreToken() {
        return MessageToken.TOKEN_VIDEO_TOTAL_LOAD_MORE + this.f10339a;
    }

    @Override // com.sandboxol.common.base.model.DefaultListModel, com.sandboxol.common.base.model.IListModel
    public String getRefreshToken() {
        return MessageToken.TOKEN_VIDEO_TOTAL_REFRESH + this.f10339a;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<VideoInfo> listItemViewModel) {
        gVar.a(1, R.layout.item_app_video_recommend_page);
    }

    @Override // com.sandboxol.common.widget.rv.pagerv.PageListModel
    public void onLoad(int i, int i2, OnResponseListener<PageData<VideoInfo>> onResponseListener) {
        if (i == 0) {
            this.f10342d = false;
        }
        if (i == 0 && getData().isEmpty() && this.f10340b == null) {
            F fB = b(this.f10339a);
            fB.getClass();
            fB.b(new k(this, i, onResponseListener));
        }
        VideoApi.getVideoByTag(this.context, i, i2, this.f10339a, this.f10340b, new l(this, i, onResponseListener));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.sandboxol.greendao.c.F b(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            r1 = 96673(0x179a1, float:1.35468E-40)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L2a
            r1 = 108960(0x1a9a0, float:1.52685E-40)
            if (r0 == r1) goto L20
            r1 = 115029(0x1c155, float:1.6119E-40)
            if (r0 == r1) goto L16
            goto L34
        L16:
            java.lang.String r0 = "top"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L34
            r5 = 1
            goto L35
        L20:
            java.lang.String r0 = "new"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L34
            r5 = 0
            goto L35
        L2a:
            java.lang.String r0 = "all"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L34
            r5 = 2
            goto L35
        L34:
            r5 = -1
        L35:
            if (r5 == 0) goto L47
            if (r5 == r3) goto L42
            if (r5 == r2) goto L3d
            r5 = 0
            return r5
        L3d:
            com.sandboxol.greendao.c.Da r5 = com.sandboxol.greendao.c.Da.newInstance()
            return r5
        L42:
            com.sandboxol.greendao.c.Ca r5 = com.sandboxol.greendao.c.Ca.newInstance()
            return r5
        L47:
            com.sandboxol.greendao.c.Ba r5 = com.sandboxol.greendao.c.Ba.newInstance()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.e.b.xa.n.b(java.lang.String):com.sandboxol.greendao.c.F");
    }

    public void a(ObservableField<Boolean> observableField) {
        this.f10341c = observableField;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<VideoInfo> getItemViewModel(VideoInfo videoInfo) {
        return new j(this.context, videoInfo);
    }

    public List<String> a() {
        return this.f10340b;
    }

    public void a(String str) {
        if (TextUtils.equals(str, StringConstant.VIDEO_TYPE_ALL)) {
            this.f10340b = null;
            return;
        }
        List<String> list = this.f10340b;
        if (list != null) {
            list.clear();
            this.f10340b.add(str);
        } else {
            this.f10340b = new ArrayList();
            this.f10340b.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PageData<VideoInfo> pageData) {
        F fB = b(this.f10339a);
        fB.getClass();
        F f2 = fB;
        f2.a(new m(this, f2, pageData));
    }
}
