package com.tendcloud.tenddata;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public final class ch {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile ch f19932c = new ch();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LinkedBlockingQueue<IBinder> f19934b = new LinkedBlockingQueue<>(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ServiceConnection f19933a = new ServiceConnection() { // from class: com.tendcloud.tenddata.ch.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                ch.this.f19934b.put(iBinder);
            } catch (Throwable unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    /* JADX INFO: compiled from: td */
    static class a implements IInterface {
        private IBinder mIBinder;

        public a(IBinder iBinder) {
            this.mIBinder = iBinder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.mIBinder;
        }

        public String getOAID() {
            String string = null;
            try {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    this.mIBinder.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    string = parcelObtain2.readString();
                } catch (Throwable unused) {
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            } catch (Throwable unused2) {
            }
            return string;
        }
    }

    private ch() {
    }

    private void b(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        if (context.bindService(intent, this.f19933a, 1)) {
            try {
                de.b().setOAID(new a(this.f19934b.take()).getOAID());
            } catch (Throwable unused) {
            }
        }
    }

    public static void bindSECServiceGetOAID(Context context) {
        f19932c.b(context);
    }

    public static boolean a(Context context) {
        try {
            if (af.b(29) || !by.f()) {
                return false;
            }
            context.getPackageManager().getPackageInfo("com.samsung.android.deviceidservice", 0);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
