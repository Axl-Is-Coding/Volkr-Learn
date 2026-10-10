package com.umeng.commonsdk.statistics.common;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: AdvertisingId.java */
/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.common.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AdvertisingId.java */
    private static final class C0184a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f21155a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f21156b;

        C0184a(String str, boolean z) {
            this.f21155a = str;
            this.f21156b = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String b() {
            return this.f21155a;
        }

        public boolean a() {
            return this.f21156b;
        }
    }

    /* JADX INFO: compiled from: AdvertisingId.java */
    private static final class b implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f21157a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final LinkedBlockingQueue<IBinder> f21158b;

        private b() {
            this.f21157a = false;
            this.f21158b = new LinkedBlockingQueue<>(1);
        }

        public IBinder a() throws InterruptedException {
            if (this.f21157a) {
                throw new IllegalStateException();
            }
            this.f21157a = true;
            return this.f21158b.take();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f21158b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static String a(Context context) {
        try {
            C0184a c0184aD = d(context);
            if (c0184aD != null && !c0184aD.a()) {
                return c0184aD.b();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static String b(Context context) {
        try {
            C0184a c0184aD = d(context);
            if (c0184aD == null) {
                return null;
            }
            return c0184aD.b();
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean c(Context context) {
        try {
            C0184a c0184aD = d(context);
            if (c0184aD != null) {
                return c0184aD.a();
            }
            return true;
        } catch (Exception unused) {
            return true;
        }
    }

    private static C0184a d(Context context) throws Exception {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return null;
        }
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            b bVar = new b();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            if (!context.bindService(intent, bVar, 1)) {
                throw new IOException("Google Play connection failed");
            }
            try {
                try {
                    c cVar = new c(bVar.a());
                    boolean zA = cVar.a(true);
                    return new C0184a(zA ? "" : cVar.a(), zA);
                } catch (Exception e2) {
                    throw e2;
                }
            } finally {
                context.unbindService(bVar);
            }
        } catch (Exception e3) {
            throw e3;
        }
    }

    /* JADX INFO: compiled from: AdvertisingId.java */
    private static final class c implements IInterface {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private IBinder f21159a;

        public c(IBinder iBinder) {
            this.f21159a = iBinder;
        }

        public String a() throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f21159a.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f21159a;
        }

        public boolean a(boolean z) throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                parcelObtain.writeInt(z ? 1 : 0);
                this.f21159a.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readInt() != 0;
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }
}
