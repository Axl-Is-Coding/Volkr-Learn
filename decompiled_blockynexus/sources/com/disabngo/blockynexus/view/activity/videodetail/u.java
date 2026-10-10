package com.disabngo.blockynexus.view.activity.videodetail;

import android.content.Context;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.greendao.entity.VideoInfo;
import rx.functions.Action0;

/* JADX INFO: compiled from: VideoDetailMoreItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class u extends ListItemViewModel<VideoInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ReplyCommand f11221a;

    public u(Context context, VideoInfo videoInfo) {
        super(context, videoInfo);
        this.f11221a = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.videodetail.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f11190a.f();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void f() {
        Messenger.getDefault().send(Long.valueOf(((VideoInfo) this.item).getVideoId()), MessageToken.TOKEN_VIDEO_DETAIL_INFO_REFRESH);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public VideoInfo getItem() {
        return (VideoInfo) super.getItem();
    }
}
