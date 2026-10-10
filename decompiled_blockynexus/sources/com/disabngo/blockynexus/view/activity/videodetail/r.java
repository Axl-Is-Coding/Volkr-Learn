package com.disabngo.blockynexus.view.activity.videodetail;

import android.content.Context;
import com.sandboxol.greendao.entity.VideoDetailInfo;

/* JADX INFO: compiled from: VideoDetailModel.java */
/* JADX INFO: loaded from: classes2.dex */
class r implements com.sandboxol.greendao.a.c<VideoDetailInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f11218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f11219b;

    r(Context context, long j) {
        this.f11218a = context;
        this.f11219b = j;
    }

    @Override // com.sandboxol.greendao.a.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(VideoDetailInfo videoDetailInfo) {
        if (videoDetailInfo == null) {
            t.d(this.f11218a, this.f11219b);
        } else {
            t.b(this.f11218a, videoDetailInfo, (Boolean) true);
        }
    }

    @Override // com.sandboxol.greendao.a.c
    public void onError(int i, String str) {
        t.d(this.f11218a, this.f11219b);
    }
}
