package com.disabngo.blockynexus.view.dialog.videotag;

import android.content.Context;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.greendao.entity.VideoTagInfo;
import rx.functions.Action1;

/* JADX INFO: compiled from: VideoTagItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends ListItemViewModel<VideoTagInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public VideoTagInfo f11706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ReplyCommand<Boolean> f11707b;

    public e(Context context, VideoTagInfo videoTagInfo, VideoTagInfo videoTagInfo2) {
        super(context, videoTagInfo);
        this.f11707b = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.view.dialog.videotag.a
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f11702a.a(((Boolean) obj).booleanValue());
            }
        });
        this.f11706a = videoTagInfo2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(boolean z) {
        if (z) {
            this.f11706a.setGameId(((VideoTagInfo) this.item).getGameId());
            this.f11706a.setTagName(((VideoTagInfo) this.item).getTagName());
        } else {
            this.f11706a.setGameId("");
            this.f11706a.setTagName("");
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public VideoTagInfo getItem() {
        return (VideoTagInfo) super.getItem();
    }
}
