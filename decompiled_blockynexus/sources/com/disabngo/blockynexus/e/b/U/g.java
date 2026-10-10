package com.disabngo.blockynexus.e.b.U;

import android.app.Activity;
import android.content.Context;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.entity.GameWarmUpResponse;
import com.sandboxol.center.router.manager.GameDetailManager;
import com.sandboxol.center.web.GameApi;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.messenger.Messenger;
import rx.functions.Action0;

/* JADX INFO: compiled from: PreheatViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class g extends ViewModel {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f9461b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f9463d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f9464e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public GameWarmUpResponse f9460a = new GameWarmUpResponse();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.disabngo.blockynexus.e.b.X.a f9462c = new com.disabngo.blockynexus.e.b.X.a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ReplyCommand f9465f = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.U.a
        @Override // rx.functions.Action0
        public final void call() {
            this.f9457a.h();
        }
    });
    public ReplyCommand g = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.U.b
        @Override // rx.functions.Action0
        public final void call() {
            this.f9458a.f();
        }
    });

    public g(Context context, String str) {
        this.f9463d = context;
        this.f9464e = str;
        this.f9461b = new e(context, R.string.preheat_no_introduction);
        a(str);
    }

    private void a(String str) {
        GameApi.gamePreheat(this.f9463d, str, new f(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_GO_CAMPAIGN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Context context = this.f9463d;
        GameDetailManager.enterGameDetail(context, context.getString(R.string.main_game), this.f9464e);
        ((Activity) this.f9463d).finish();
    }
}
