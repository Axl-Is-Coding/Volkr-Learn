package com.disabngo.blockynexus.e.b.ja;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.dialog.ShareDialog;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.messenger.Messenger;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: ShareViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class h extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ReplyCommand f9862b = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.ja.b
        @Override // rx.functions.Action0
        public final void call() {
            this.f9858a.f();
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.disabngo.blockynexus.e.b.X.a f9863c = new com.disabngo.blockynexus.e.b.X.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e f9864d;

    public h(Context context) {
        this.f9861a = context;
        initMessenger();
        this.f9864d = new e(context, R.string.no_data);
    }

    private void initMessenger() {
        Messenger.getDefault().register(this, MessageToken.TOKEN_GET_SHARE_REWARD, String.class, new Action1() { // from class: com.disabngo.blockynexus.e.b.ja.a
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f9857a.a((String) obj);
            }
        });
    }

    public /* synthetic */ void a(String str) {
        new g().a(this.f9861a, str);
    }

    public /* synthetic */ void f() {
        new ShareDialog(this.f9861a).show();
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        super.onDestroy();
        Messenger.getDefault().unregister(this);
    }
}
