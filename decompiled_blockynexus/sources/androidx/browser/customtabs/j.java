package androidx.browser.customtabs;

import android.os.Bundle;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.IPostMessageService;

/* JADX INFO: compiled from: PostMessageService.java */
/* JADX INFO: loaded from: classes.dex */
class j extends IPostMessageService.Stub {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ PostMessageService f783a;

    j(PostMessageService postMessageService) {
        this.f783a = postMessageService;
    }

    @Override // android.support.customtabs.IPostMessageService
    public void onMessageChannelReady(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) throws RemoteException {
        iCustomTabsCallback.onMessageChannelReady(bundle);
    }

    @Override // android.support.customtabs.IPostMessageService
    public void onPostMessage(ICustomTabsCallback iCustomTabsCallback, String str, Bundle bundle) throws RemoteException {
        iCustomTabsCallback.onPostMessage(str, bundle);
    }
}
