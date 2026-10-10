package com.disabngo.blockynexus.message.provider;

import com.disabngo.blockynexus.message.provider.ScrapHelpProvider;
import com.disabngo.blockynexus.view.dialog.Fa;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.utils.ScrapStatusHelper;
import com.sandboxol.common.messenger.Messenger;

/* JADX INFO: compiled from: ScrapHelpProvider.java */
/* JADX INFO: loaded from: classes2.dex */
class l implements Fa.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ m f10479a;

    l(m mVar) {
        this.f10479a = mVar;
    }

    @Override // com.disabngo.blockynexus.view.dialog.Fa.a
    public void a() {
        ScrapStatusHelper.getInstance().updateCacheData(this.f10479a.f10480a.getContext(), this.f10479a.f10481b.f10430a.getUuid(), 1);
        ScrapHelpProvider.AnonymousClass1 anonymousClass1 = this.f10479a.f10481b;
        ScrapHelpProvider.this.a(anonymousClass1.f10431b, anonymousClass1.f10432c, anonymousClass1.f10430a, anonymousClass1.f10433d);
    }

    @Override // com.disabngo.blockynexus.view.dialog.Fa.a
    public void b() {
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_OPEN_SCRAP_MAIN);
        ScrapStatusHelper.getInstance().updateCacheData(this.f10479a.f10480a.getContext(), this.f10479a.f10481b.f10430a.getUuid(), 1);
        ScrapHelpProvider.AnonymousClass1 anonymousClass1 = this.f10479a.f10481b;
        ScrapHelpProvider.this.a(anonymousClass1.f10431b, anonymousClass1.f10432c, anonymousClass1.f10430a, anonymousClass1.f10433d);
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_CLOSE_CHAT_ACTIVITY);
    }
}
