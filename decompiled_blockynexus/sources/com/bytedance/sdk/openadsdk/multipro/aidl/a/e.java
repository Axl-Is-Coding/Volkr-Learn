package com.bytedance.sdk.openadsdk.multipro.aidl.a;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IRewardAdInteractionListener;
import com.bytedance.sdk.openadsdk.utils.o;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: RewardAdVideoListenerManagerImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, RemoteCallbackList<IRewardAdInteractionListener>> f7035a = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile e f7036b;

    public static e a() {
        if (f7036b == null) {
            synchronized (e.class) {
                if (f7036b == null) {
                    f7036b = new e();
                }
            }
        }
        return f7036b;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.a.a, com.bytedance.sdk.openadsdk.IListenerManager
    public void executeRewardVideoCallback(String str, String str2, boolean z, int i, String str3) throws RemoteException {
        a(str, str2, z, i, str3);
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.a.a, com.bytedance.sdk.openadsdk.IListenerManager
    public synchronized void registerRewardVideoListener(String str, IRewardAdInteractionListener iRewardAdInteractionListener) throws RemoteException {
        RemoteCallbackList<IRewardAdInteractionListener> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(iRewardAdInteractionListener);
        f7035a.put(str, remoteCallbackList);
    }

    private synchronized void a(String str, String str2, boolean z, int i, String str3) {
        RemoteCallbackList<IRewardAdInteractionListener> remoteCallbackListRemove;
        try {
            if (f7035a != null) {
                if ("recycleRes".equals(str2)) {
                    remoteCallbackListRemove = f7035a.remove(str);
                } else {
                    remoteCallbackListRemove = f7035a.get(str);
                }
                if (remoteCallbackListRemove != null) {
                    int iBeginBroadcast = remoteCallbackListRemove.beginBroadcast();
                    for (int i2 = 0; i2 < iBeginBroadcast; i2++) {
                        try {
                            IRewardAdInteractionListener iRewardAdInteractionListener = (IRewardAdInteractionListener) remoteCallbackListRemove.getBroadcastItem(i2);
                            if (iRewardAdInteractionListener != null) {
                                if ("onAdShow".equals(str2)) {
                                    iRewardAdInteractionListener.onAdShow();
                                } else if ("onAdClose".equals(str2)) {
                                    iRewardAdInteractionListener.onAdClose();
                                } else if ("onVideoComplete".equals(str2)) {
                                    iRewardAdInteractionListener.onVideoComplete();
                                } else if ("onVideoError".equals(str2)) {
                                    iRewardAdInteractionListener.onVideoError();
                                } else if ("onAdVideoBarClick".equals(str2)) {
                                    iRewardAdInteractionListener.onAdVideoBarClick();
                                } else if ("onRewardVerify".equals(str2)) {
                                    iRewardAdInteractionListener.onRewardVerify(z, i, str3);
                                } else if ("onSkippedVideo".equals(str2)) {
                                    iRewardAdInteractionListener.onSkippedVideo();
                                } else if ("recycleRes".equals(str2)) {
                                    iRewardAdInteractionListener.onDestroy();
                                }
                            }
                        } catch (Throwable th) {
                            o.c("MultiProcess", "reward1 '" + str2 + "'  throws Exception :", th);
                        }
                    }
                    remoteCallbackListRemove.finishBroadcast();
                    if ("recycleRes".equals(str2)) {
                        remoteCallbackListRemove.kill();
                    }
                }
            }
        } catch (Throwable th2) {
            o.c("MultiProcess", "reward2 '" + str2 + "'  throws Exception :", th2);
        }
    }
}
