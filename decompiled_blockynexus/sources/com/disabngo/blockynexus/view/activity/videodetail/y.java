package com.disabngo.blockynexus.view.activity.videodetail;

import android.app.Activity;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0516a;
import com.just.agentweb.AgentWeb;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.OnDataListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;
import com.sandboxol.greendao.c.Aa;
import com.sandboxol.greendao.entity.VideoDetailInfo;
import java.util.ArrayList;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: VideoDetailViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class y extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private t f11228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Activity f11229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public VideoDetailInfo f11230c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public w f11231d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public j f11232e = new j();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ReplyCommand f11233f = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.videodetail.i
        @Override // rx.functions.Action0
        public final void call() {
            this.f11198a.f();
        }
    });
    public ReplyCommand g = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.videodetail.c
        @Override // rx.functions.Action0
        public final void call() {
            this.f11192a.j();
        }
    });
    public ReplyCommand h = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.videodetail.f
        @Override // rx.functions.Action0
        public final void call() {
            this.f11195a.i();
        }
    });
    public ReplyCommand i = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.videodetail.g
        @Override // rx.functions.Action0
        public final void call() {
            this.f11196a.h();
        }
    });
    public ReplyCommand j = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.videodetail.h
        @Override // rx.functions.Action0
        public final void call() {
            this.f11197a.onBack();
        }
    });
    public AgentWeb k;

    public y(Activity activity, AbstractC0516a abstractC0516a, VideoDetailInfo videoDetailInfo, boolean z) {
        this.f11229b = activity;
        this.f11230c = videoDetailInfo;
        a(z);
        a(abstractC0516a.n, videoDetailInfo.getVideoUrl());
        initMessenger();
    }

    private void a(ViewGroup viewGroup, String str) {
        t tVar = this.f11228a;
        if (tVar == null || this.k != null) {
            return;
        }
        this.k = tVar.a(this.f11229b, viewGroup, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        VideoDetailInfo videoDetailInfo;
        t tVar = this.f11228a;
        if (tVar != null && (videoDetailInfo = this.f11230c) != null) {
            tVar.b(this.f11229b, videoDetailInfo);
        }
        ReportDataAdapter.onEvent(this.f11229b, EventConstant.VEDIO_BAD_CLICK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        VideoDetailInfo videoDetailInfo;
        t tVar = this.f11228a;
        if (tVar != null && (videoDetailInfo = this.f11230c) != null) {
            tVar.c(this.f11229b, videoDetailInfo.getAuthorId());
        }
        ReportDataAdapter.onEvent(this.f11229b, EventConstant.VEDIO_HEAD_CLICK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        VideoDetailInfo videoDetailInfo = this.f11230c;
        if (videoDetailInfo != null) {
            String youtubeUrl = videoDetailInfo.getYoutubeUrl();
            if (this.f11228a != null && !TextUtils.isEmpty(youtubeUrl)) {
                this.f11228a.a(this.f11229b, youtubeUrl);
            }
        }
        ReportDataAdapter.onEvent(this.f11229b, EventConstant.VEDIO_FOLLOW_CLICK);
    }

    private void initMessenger() {
        Messenger.getDefault().register(this, MessageToken.TOKEN_VIDEO_DETAIL_INFO_REFRESH, Long.class, new Action1() { // from class: com.disabngo.blockynexus.view.activity.videodetail.e
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f11194a.a((Long) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        VideoDetailInfo videoDetailInfo;
        t tVar = this.f11228a;
        if (tVar != null && (videoDetailInfo = this.f11230c) != null) {
            tVar.c(this.f11229b, videoDetailInfo);
        }
        ReportDataAdapter.onEvent(this.f11229b, EventConstant.VEDIO_GOOD_CLICK);
    }

    private void k() {
        VideoDetailInfo videoDetailInfo;
        t tVar = this.f11228a;
        if (tVar == null || (videoDetailInfo = this.f11230c) == null) {
            return;
        }
        tVar.a(this.f11229b, videoDetailInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onBack() {
        Activity activity = this.f11229b;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        this.f11229b.finish();
    }

    public /* synthetic */ void b(VideoDetailInfo videoDetailInfo) {
        this.f11230c.refreshData(videoDetailInfo);
        AgentWeb agentWeb = this.k;
        if (agentWeb != null) {
            agentWeb.getUrlLoader().stopLoading();
            this.k.getUrlLoader().loadUrl(this.f11228a.a(videoDetailInfo.getVideoUrl()));
        }
        w wVar = this.f11231d;
        if (wVar != null) {
            wVar.a(videoDetailInfo.getAuthorId());
            this.f11231d.b(videoDetailInfo.getVideoId());
            this.f11231d.a(new ArrayList(this.f11230c.getTag().keySet()));
            Messenger.getDefault().send(RefreshMsg.create(), this.f11231d.getRefreshToken());
        }
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        AgentWeb agentWeb = this.k;
        if (agentWeb != null) {
            agentWeb.getWebLifeCycle().onDestroy();
        }
        super.onDestroy();
        Messenger.getDefault().unregister(this);
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onPause() {
        AgentWeb agentWeb = this.k;
        if (agentWeb != null) {
            agentWeb.getWebLifeCycle().onPause();
        }
        super.onPause();
        Aa.newInstance().a(this.f11230c);
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onResume() {
        AgentWeb agentWeb = this.k;
        if (agentWeb != null) {
            agentWeb.getWebLifeCycle().onResume();
        }
        super.onResume();
    }

    private void a(boolean z) {
        this.f11231d = new w(this.f11229b, R.string.no_data, this.f11230c.getAuthorId(), this.f11230c.getVideoId(), new ArrayList(this.f11230c.getTag().keySet()));
        if (this.f11228a == null) {
            this.f11228a = new t();
            if (z) {
                this.f11228a.a(this.f11229b, this.f11230c.getVideoId(), new OnDataListener() { // from class: com.disabngo.blockynexus.view.activity.videodetail.b
                    @Override // com.sandboxol.common.interfaces.OnDataListener
                    public final void onSuccess(Object obj) {
                        this.f11191a.a((VideoDetailInfo) obj);
                    }
                });
            }
        }
        k();
    }

    public /* synthetic */ void a(VideoDetailInfo videoDetailInfo) {
        this.f11230c.refreshData(videoDetailInfo);
    }

    public /* synthetic */ void a(Long l) {
        t tVar;
        Activity activity = this.f11229b;
        if (activity == null || (tVar = this.f11228a) == null) {
            return;
        }
        tVar.b(activity, l.longValue(), new OnDataListener() { // from class: com.disabngo.blockynexus.view.activity.videodetail.d
            @Override // com.sandboxol.common.interfaces.OnDataListener
            public final void onSuccess(Object obj) {
                this.f11193a.b((VideoDetailInfo) obj);
            }
        });
    }
}
