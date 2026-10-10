package com.disabngo.blockynexus.e.b.ya;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0567ed;
import com.disabngo.blockynexus.e.b.xa.n;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;
import com.sandboxol.greendao.entity.VideoTagInfo;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: VideoTotalViewModel.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f10394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public n f10395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f10396c = new d();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<String> f10397d = new ObservableField<>(BaseApplication.getContext().getString(R.string.category_all));

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ReplyCommand f10398e = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.ya.a
        @Override // rx.functions.Action0
        public final void call() {
            this.f10387a.f();
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private f f10399f;
    private AbstractC0567ed g;

    public g(Context context, AbstractC0567ed abstractC0567ed) {
        this.f10394a = context;
        this.g = abstractC0567ed;
        initData();
        initMessenger();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        f fVar = this.f10399f;
        if (fVar == null || this.g == null) {
            return;
        }
        fVar.a(this.f10394a, fVar.a(this.f10397d.get(), this.f10395b.a()), this.g);
    }

    private void initData() {
        this.f10395b = new n(this.f10394a, R.string.no_data, StringConstant.VIDEO_TYPE_ALL, null);
        if (this.f10399f == null) {
            this.f10399f = new f();
        }
    }

    private void initMessenger() {
        Messenger.getDefault().register(this, MessageToken.TOKEN_VIDEO_TOTAL_SELECT_TAG, VideoTagInfo.class, new Action1() { // from class: com.disabngo.blockynexus.e.b.ya.b
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f10388a.a((VideoTagInfo) obj);
            }
        });
    }

    public /* synthetic */ void a(VideoTagInfo videoTagInfo) {
        if (this.f10395b != null) {
            this.f10397d.set(videoTagInfo.getTagName());
            this.f10395b.a(videoTagInfo.getGameId());
            Messenger.getDefault().send(RefreshMsg.create(), this.f10395b.getRefreshToken());
        }
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        super.onDestroy();
        Messenger.getDefault().unregister(this);
    }
}
