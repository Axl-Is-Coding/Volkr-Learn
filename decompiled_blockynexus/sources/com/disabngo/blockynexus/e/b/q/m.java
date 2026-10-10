package com.disabngo.blockynexus.e.b.q;

import com.disabngo.blockynexus.view.dialog.DialogC1116sa;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;
import io.reactivex.w;

/* JADX INFO: compiled from: DiskGameManageViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class m implements w<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ DialogC1116sa f10086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ n f10087b;

    m(n nVar, DialogC1116sa dialogC1116sa) {
        this.f10087b = nVar;
        this.f10086a = dialogC1116sa;
    }

    @Override // io.reactivex.w
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onNext(Long l) {
    }

    @Override // io.reactivex.w
    public void onComplete() {
        Messenger.getDefault().send(RefreshMsg.create(), MessageToken.TOKEN_REFRESH_DISK_GAME_MANAGE_LIST);
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_REFRESH_DISK_SPACE);
        this.f10087b.f10092e.set(true);
        this.f10086a.dismiss();
        this.f10087b.f10093f.clear();
        ReportDataAdapter.onEvent(this.f10087b.f10088a, EventConstant.CLEAN_GAME_SUC);
    }

    @Override // io.reactivex.w
    public void onError(Throwable th) {
        ReportDataAdapter.onError(this.f10087b.f10088a, th);
        this.f10087b.f10092e.set(true);
        this.f10086a.dismiss();
    }

    @Override // io.reactivex.w
    public void onSubscribe(io.reactivex.disposables.b bVar) {
    }
}
