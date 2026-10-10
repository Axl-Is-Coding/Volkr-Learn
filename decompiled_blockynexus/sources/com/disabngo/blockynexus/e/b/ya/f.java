package com.disabngo.blockynexus.e.b.ya;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0567ed;
import com.disabngo.blockynexus.web.VideoApi;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.view.dialog.LoadingDialog;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.greendao.entity.VideoTagInfo;
import java.util.List;

/* JADX INFO: compiled from: VideoTotalModel.java */
/* JADX INFO: loaded from: classes.dex */
public class f {
    public void a(Context context, VideoTagInfo videoTagInfo, AbstractC0567ed abstractC0567ed) {
        LoadingDialog loadingDialog = new LoadingDialog(context);
        loadingDialog.show();
        VideoApi.getVideoTagList(context, new e(this, context, videoTagInfo, abstractC0567ed, loadingDialog));
    }

    public VideoTagInfo a(String str, List<String> list) {
        if (list != null && !list.isEmpty()) {
            return new VideoTagInfo(list.get(0), str);
        }
        return new VideoTagInfo(StringConstant.VIDEO_TYPE_ALL, BaseApplication.getContext().getString(R.string.category_all));
    }
}
