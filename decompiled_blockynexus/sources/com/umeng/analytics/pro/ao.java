package com.umeng.analytics.pro;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: HuaweiDeviceIdSupplier.java */
/* JADX INFO: loaded from: classes5.dex */
class ao implements al {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f20646a = "com.uodis.opendevice.aidl.OpenDeviceIdentifierService";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f20647b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f20648c = 2;

    /* JADX INFO: compiled from: HuaweiDeviceIdSupplier.java */
    private static final class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f20649a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final LinkedBlockingQueue<IBinder> f20650b;

        private a() {
            this.f20649a = false;
            this.f20650b = new LinkedBlockingQueue<>();
        }

        public IBinder a() throws InterruptedException {
            if (this.f20649a) {
                throw new IllegalStateException();
            }
            this.f20649a = true;
            return this.f20650b.poll(5L, TimeUnit.SECONDS);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f20650b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* JADX INFO: compiled from: HuaweiDeviceIdSupplier.java */
    private static final class b implements IInterface {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private IBinder f20651a;

        public b(IBinder iBinder) {
            this.f20651a = iBinder;
        }

        public String a() throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken(ao.f20646a);
                this.f20651a.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f20651a;
        }

        public boolean b() throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken(ao.f20646a);
                this.f20651a.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readInt() != 0;
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }

    ao() {
    }

    @Override // com.umeng.analytics.pro.al
    public String a(Context context) {
        a aVar = new a();
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        if (context.bindService(intent, aVar, 1)) {
            try {
                return new b(aVar.a()).a();
            } catch (Exception unused) {
            } finally {
                context.unbindService(aVar);
            }
        }
        return null;
    }
}
