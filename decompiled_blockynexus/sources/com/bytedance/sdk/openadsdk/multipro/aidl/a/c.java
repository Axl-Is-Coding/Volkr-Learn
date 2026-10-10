package com.bytedance.sdk.openadsdk.multipro.aidl.a;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.ICommonPermissionListener;
import com.bytedance.sdk.openadsdk.utils.o;
import java.util.HashMap;

/* JADX INFO: compiled from: CommonPermissionListenerManagerImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HashMap<String, RemoteCallbackList<ICommonPermissionListener>> f7031a = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile c f7032b;

    public static c a() {
        if (f7032b == null) {
            synchronized (c.class) {
                if (f7032b == null) {
                    f7032b = new c();
                }
            }
        }
        return f7032b;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.a.a, com.bytedance.sdk.openadsdk.IListenerManager
    public void broadcastPermissionListener(String str, String str2) throws RemoteException {
        o.b("MultiProcess", "00000 CommonPermissionListenerManagerImpl broadcastDialogListener: 00000" + String.valueOf(str) + ", " + str2);
        RemoteCallbackList<ICommonPermissionListener> remoteCallbackListRemove = f7031a.remove(str);
        if (remoteCallbackListRemove == null) {
            return;
        }
        int iBeginBroadcast = remoteCallbackListRemove.beginBroadcast();
        for (int i = 0; i < iBeginBroadcast; i++) {
            ICommonPermissionListener iCommonPermissionListener = (ICommonPermissionListener) remoteCallbackListRemove.getBroadcastItem(i);
            if (iCommonPermissionListener != null) {
                o.b("MultiProcess", "CommonPermissionListenerManagerImpl broadcastDialogListener: " + String.valueOf(str) + ", " + str2);
                if (str2 == null) {
                    iCommonPermissionListener.onGranted();
                } else {
                    iCommonPermissionListener.onDenied(str2);
                }
            }
        }
        remoteCallbackListRemove.finishBroadcast();
        remoteCallbackListRemove.kill();
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.a.a, com.bytedance.sdk.openadsdk.IListenerManager
    public void registerPermissionListener(String str, ICommonPermissionListener iCommonPermissionListener) throws RemoteException {
        if (iCommonPermissionListener == null) {
            return;
        }
        o.b("MultiProcess", "CommonPermissionListenerManagerImpl registerPermissionListener");
        RemoteCallbackList<ICommonPermissionListener> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(iCommonPermissionListener);
        f7031a.put(str, remoteCallbackList);
    }
}
