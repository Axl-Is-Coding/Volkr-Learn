package io.rong.push.platform.google;

import com.google.android.gms.iid.InstanceIDListenerService;
import io.rong.push.PushManager;
import io.rong.push.PushType;

/* JADX INFO: loaded from: classes5.dex */
public class RongGCMInstanceIDListenerService extends InstanceIDListenerService {
    @Override // com.google.android.gms.iid.InstanceIDListenerService
    public void onTokenRefresh() {
        PushManager.getInstance().onTokenRefresh(this, PushType.GOOGLE_GCM);
    }
}
