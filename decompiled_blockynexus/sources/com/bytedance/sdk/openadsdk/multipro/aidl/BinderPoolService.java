package com.bytedance.sdk.openadsdk.multipro.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IBinderPool;
import com.bytedance.sdk.openadsdk.multipro.aidl.a.b;
import com.bytedance.sdk.openadsdk.multipro.aidl.a.c;
import com.bytedance.sdk.openadsdk.multipro.aidl.a.d;
import com.bytedance.sdk.openadsdk.multipro.aidl.a.e;
import com.bytedance.sdk.openadsdk.utils.o;

/* JADX INFO: loaded from: classes.dex */
public class BinderPoolService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Binder f7020a = new a();

    public static class a extends IBinderPool.Stub {
        @Override // com.bytedance.sdk.openadsdk.IBinderPool
        public IBinder queryBinder(int i) throws RemoteException {
            o.c("MultiProcess", "queryBinder...........binderCode=" + i);
            if (i == 0) {
                return e.a();
            }
            if (i == 1) {
                return d.a();
            }
            if (i == 2) {
                return b.a();
            }
            if (i != 4) {
                return null;
            }
            return c.a();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        o.b("MultiProcess", "BinderPoolService onBind ! ");
        return this.f7020a;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        o.b("MultiProcess", "BinderPoolService has been created ! ");
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        o.b("MultiProcess", "BinderPoolService is destroy ! ");
    }
}
