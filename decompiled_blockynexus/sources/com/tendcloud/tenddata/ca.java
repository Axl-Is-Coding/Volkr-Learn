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
public final class ca {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile ca f19915c = new ca();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LinkedBlockingQueue<IBinder> f19917b = new LinkedBlockingQueue<>(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ServiceConnection f19916a = new ServiceConnection() { // from class: com.tendcloud.tenddata.ca.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                ca.this.f19917b.put(iBinder);
            } catch (Throwable unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    /* JADX INFO: compiled from: td */
    public static final class a implements IInterface {
        private IBinder iBinder;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.iBinder;
        }

        public String getOAID() {
            String string = null;
            try {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    this.iBinder.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    string = parcelObtain2.readString();
                } catch (Throwable unused) {
                } finally {
                    parcelObtain.recycle();
                    parcelObtain2.recycle();
                }
            } catch (Throwable unused2) {
            }
            return string;
        }

        private a(IBinder iBinder) {
            this.iBinder = iBinder;
        }
    }

    private ca() {
    }

    private void b(Context context) {
        try {
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage("com.huawei.hwid");
            if (context.bindService(intent, this.f19916a, 1)) {
                try {
                    de.b().setOAID(new a(this.f19917b.take()).getOAID());
                } catch (Throwable unused) {
                }
                context.unbindService(this.f19916a);
            }
        } catch (Throwable unused2) {
        }
    }

    public static void bindHWServiceGetOAID(Context context) {
        f19915c.b(context);
    }

    public static boolean a(Context context) {
        try {
            if (af.b(29) || !by.b()) {
                return false;
            }
            context.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
