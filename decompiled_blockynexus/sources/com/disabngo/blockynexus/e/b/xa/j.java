package com.disabngo.blockynexus.e.b.xa;

import android.content.Context;
import com.disabngo.blockynexus.view.activity.videodetail.t;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.greendao.entity.VideoInfo;
import rx.functions.Action0;

/* JADX INFO: compiled from: VideoRecommendPageItemViewModel.java */
/* JADX INFO: loaded from: classes.dex */
public class j extends ListItemViewModel<VideoInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ReplyCommand f10329a;

    public j(Context context, VideoInfo videoInfo) {
        super(context, videoInfo);
        this.f10329a = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.xa.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f10323a.f();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void f() {
        t.b(this.context, ((VideoInfo) this.item).getVideoId());
        ReportDataAdapter.onEvent(this.context, EventConstant.VEDIO_CLICK);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public VideoInfo getItem() {
        return (VideoInfo) super.getItem();
    }
}
