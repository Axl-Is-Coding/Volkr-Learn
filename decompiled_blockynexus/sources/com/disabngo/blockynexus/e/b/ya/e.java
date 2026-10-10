package com.disabngo.blockynexus.e.b.ya;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0567ed;
import com.disabngo.blockynexus.view.dialog.videotag.VideoTagPopupWindowDialog;
import com.disabngo.blockynexus.web.error.VideoOnError;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.view.dialog.LoadingDialog;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.greendao.entity.VideoTagInfo;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: VideoTotalModel.java */
/* JADX INFO: loaded from: classes.dex */
class e extends OnResponseListener<Map<String, String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f10389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ VideoTagInfo f10390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ AbstractC0567ed f10391c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ LoadingDialog f10392d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ f f10393e;

    e(f fVar, Context context, VideoTagInfo videoTagInfo, AbstractC0567ed abstractC0567ed, LoadingDialog loadingDialog) {
        this.f10393e = fVar;
        this.f10389a = context;
        this.f10390b = videoTagInfo;
        this.f10391c = abstractC0567ed;
        this.f10392d = loadingDialog;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Map<String, String> map) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new VideoTagInfo(StringConstant.VIDEO_TYPE_ALL, BaseApplication.getContext().getString(R.string.category_all)));
        for (String str : map.keySet()) {
            arrayList.add(new VideoTagInfo(str, map.get(str)));
        }
        VideoTagPopupWindowDialog videoTagPopupWindowDialog = new VideoTagPopupWindowDialog(this.f10389a, arrayList, this.f10390b);
        ConstraintLayout constraintLayout = this.f10391c.f8294a;
        videoTagPopupWindowDialog.showAsDropDown(constraintLayout, 0, -constraintLayout.getHeight());
        if (this.f10392d.isShowing()) {
            this.f10392d.dismiss();
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        if (this.f10392d.isShowing()) {
            this.f10392d.dismiss();
        }
        VideoOnError.showErrorTip(this.f10389a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        if (this.f10392d.isShowing()) {
            this.f10392d.dismiss();
        }
        VideoOnError.showOnServerError(this.f10389a, i);
    }
}
