package androidx.browser.customtabs;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.customtabs.IPostMessageService;

/* JADX INFO: loaded from: classes.dex */
public class PostMessageService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IPostMessageService.Stub f756a = new j(this);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f756a;
    }
}
