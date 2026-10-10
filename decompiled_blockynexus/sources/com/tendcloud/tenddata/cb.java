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
public class cb {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f19918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile cb f19919c = new cb();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedBlockingQueue<IBinder> f19920a = new LinkedBlockingQueue<>(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ServiceConnection f19921d = new ServiceConnection() { // from class: com.tendcloud.tenddata.cb.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                cb.this.f19920a.put(iBinder);
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

        a(IBinder iBinder) {
            this.mIBinder = iBinder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.mIBinder;
        }

        String getOAID() {
            String string = null;
            try {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    this.mIBinder.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    string = parcelObtain2.readString();
                } catch (Throwable unused) {
                }
                parcelObtain.recycle();
                parcelObtain2.recycle();
            } catch (Throwable unused2) {
            }
            return string;
        }
    }

    private cb() {
    }

    private void b(Context context) {
        try {
            Intent intent = new Intent();
            intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
            if (context.bindService(intent, this.f19921d, 1)) {
                f19918b = new a(this.f19920a.take());
                de.b().setOAID(f19918b.getOAID());
            }
        } catch (Throwable unused) {
        }
    }

    public static void bindLENOVOServiceGetOAID(Context context) {
        f19919c.b(context);
    }

    public static boolean a(Context context) {
        try {
            if (af.b(29) || !by.j()) {
                return false;
            }
            context.getPackageManager().getPackageInfo("com.zui.deviceidservice", 0);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
