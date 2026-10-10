package com.bytedance.sdk.openadsdk.multipro.aidl.a;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener;
import com.bytedance.sdk.openadsdk.utils.o;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: FullScreenVideoListenerManagerImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, RemoteCallbackList<IFullScreenVideoAdInteractionListener>> f7033a = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile d f7034b;

    public static d a() {
        if (f7034b == null) {
            synchronized (d.class) {
                if (f7034b == null) {
                    f7034b = new d();
                }
            }
        }
        return f7034b;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.a.a, com.bytedance.sdk.openadsdk.IListenerManager
    public void executeFullVideoCallback(String str, String str2) throws RemoteException {
        a(str, str2);
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.a.a, com.bytedance.sdk.openadsdk.IListenerManager
    public synchronized void registerFullVideoListener(String str, IFullScreenVideoAdInteractionListener iFullScreenVideoAdInteractionListener) throws RemoteException {
        RemoteCallbackList<IFullScreenVideoAdInteractionListener> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(iFullScreenVideoAdInteractionListener);
        f7033a.put(str, remoteCallbackList);
    }

    private synchronized void a(String str, String str2) {
        RemoteCallbackList<IFullScreenVideoAdInteractionListener> remoteCallbackListRemove;
        try {
            if (f7033a != null) {
                if ("recycleRes".equals(str2)) {
                    remoteCallbackListRemove = f7033a.remove(str);
                } else {
                    remoteCallbackListRemove = f7033a.get(str);
                }
                if (remoteCallbackListRemove != null) {
                    int iBeginBroadcast = remoteCallbackListRemove.beginBroadcast();
                    for (int i = 0; i < iBeginBroadcast; i++) {
                        try {
                            IFullScreenVideoAdInteractionListener iFullScreenVideoAdInteractionListener = (IFullScreenVideoAdInteractionListener) remoteCallbackListRemove.getBroadcastItem(i);
                            if (iFullScreenVideoAdInteractionListener != null) {
                                if ("onAdShow".equals(str2)) {
                                    iFullScreenVideoAdInteractionListener.onAdShow();
                                } else if ("onAdClose".equals(str2)) {
                                    iFullScreenVideoAdInteractionListener.onAdClose();
                                } else if ("onVideoComplete".equals(str2)) {
                                    iFullScreenVideoAdInteractionListener.onVideoComplete();
                                } else if ("onSkippedVideo".equals(str2)) {
                                    iFullScreenVideoAdInteractionListener.onSkippedVideo();
                                } else if ("onAdVideoBarClick".equals(str2)) {
                                    iFullScreenVideoAdInteractionListener.onAdVideoBarClick();
                                } else if ("recycleRes".equals(str2)) {
                                    iFullScreenVideoAdInteractionListener.onDestroy();
                                }
                            }
                        } catch (Throwable th) {
                            o.c("MultiProcess", "fullScreen2 method " + str2 + " throws Exception :", th);
                        }
                    }
                    remoteCallbackListRemove.finishBroadcast();
                    if ("recycleRes".equals(str2)) {
                        remoteCallbackListRemove.kill();
                    }
                }
            }
        } catch (Throwable th2) {
            o.c("MultiProcess", "fullScreen1 method " + str2 + " throws Exception :", th2);
        }
    }
}
