package com.bytedance.sdk.openadsdk.multipro.aidl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IBinderPool;
import com.bytedance.sdk.openadsdk.utils.o;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: BinderPool.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile a f7021c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f7022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private IBinderPool f7023b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private CountDownLatch f7024d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f7025e = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f7026f = 0;
    private ServiceConnection g = new ServiceConnection() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.a.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            a.this.f7023b = IBinderPool.Stub.asInterface(iBinder);
            try {
                a.this.f7023b.asBinder().linkToDeath(a.this.h, 0);
            } catch (RemoteException e2) {
                o.c("MultiProcess", "onServiceConnected throws :", e2);
            }
            a.this.f7024d.countDown();
            o.b("MultiProcess", "onServiceConnected - binderService consume time ：" + (System.currentTimeMillis() - a.this.f7026f));
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            o.c("MultiProcess", "BinderPool......onServiceDisconnected");
        }
    };
    private IBinder.DeathRecipient h = new IBinder.DeathRecipient() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.a.2
        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            o.d("MultiProcess", "binder died.");
            a.this.f7023b.asBinder().unlinkToDeath(a.this.h, 0);
            a.this.f7023b = null;
            a.this.a();
        }
    };

    private a(Context context) {
        this.f7022a = context.getApplicationContext();
        a();
    }

    public static a a(Context context) {
        if (f7021c == null) {
            synchronized (a.class) {
                if (f7021c == null) {
                    f7021c = new a(context);
                }
            }
        }
        return f7021c;
    }

    public IBinder a(int i) {
        try {
            if (this.f7023b != null) {
                return this.f7023b.queryBinder(i);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a() {
        o.c("MultiProcess", "BinderPool......connectBinderPoolService");
        this.f7024d = new CountDownLatch(1);
        this.f7022a.bindService(new Intent(this.f7022a, (Class<?>) BinderPoolService.class), this.g, 1);
        this.f7026f = System.currentTimeMillis();
        try {
            this.f7024d.await();
        } catch (InterruptedException e2) {
            o.c("MultiProcess", "connectBinderPoolService throws: ", e2);
        }
    }
}
