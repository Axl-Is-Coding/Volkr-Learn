package com.bytedance.sdk.openadsdk.multipro.aidl.a;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.ICommonDialogListener;
import java.util.HashMap;

/* JADX INFO: compiled from: CommonDialogListenerManagerImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static HashMap<String, RemoteCallbackList<ICommonDialogListener>> f7029a = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile b f7030b;

    public static b a() {
        if (f7030b == null) {
            synchronized (b.class) {
                if (f7030b == null) {
                    f7030b = new b();
                }
            }
        }
        return f7030b;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.a.a, com.bytedance.sdk.openadsdk.IListenerManager
    public void broadcastDialogListener(String str, int i) throws RemoteException {
        RemoteCallbackList<ICommonDialogListener> remoteCallbackListRemove = f7029a.remove(str);
        if (remoteCallbackListRemove == null) {
            return;
        }
        int iBeginBroadcast = remoteCallbackListRemove.beginBroadcast();
        for (int i2 = 0; i2 < iBeginBroadcast; i2++) {
            ICommonDialogListener iCommonDialogListener = (ICommonDialogListener) remoteCallbackListRemove.getBroadcastItem(i2);
            if (iCommonDialogListener != null) {
                if (i == 1) {
                    iCommonDialogListener.onDialogBtnYes();
                } else if (i == 2) {
                    iCommonDialogListener.onDialogBtnNo();
                } else if (i != 3) {
                    iCommonDialogListener.onDialogCancel();
                } else {
                    iCommonDialogListener.onDialogCancel();
                }
            }
        }
        remoteCallbackListRemove.finishBroadcast();
        remoteCallbackListRemove.kill();
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.a.a, com.bytedance.sdk.openadsdk.IListenerManager
    public void registerDialogListener(String str, ICommonDialogListener iCommonDialogListener) throws RemoteException {
        if (iCommonDialogListener == null) {
            return;
        }
        RemoteCallbackList<ICommonDialogListener> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(iCommonDialogListener);
        f7029a.put(str, remoteCallbackList);
    }
}
