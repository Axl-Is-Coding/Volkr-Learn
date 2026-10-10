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
public class bz {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f19911b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile bz f19912c = new bz();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedBlockingQueue<IBinder> f19913a = new LinkedBlockingQueue<>(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ServiceConnection f19914d = new ServiceConnection() { // from class: com.tendcloud.tenddata.bz.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                bz.this.f19913a.put(iBinder);
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
                    parcelObtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    this.mIBinder.transact(3, parcelObtain, parcelObtain2, 0);
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

    private bz() {
    }

    private void b(Context context) {
        try {
            Intent intent = new Intent();
            intent.setAction("com.asus.msa.action.ACCESS_DID");
            intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
            if (context.bindService(intent, this.f19914d, 1)) {
                f19911b = new a(this.f19913a.take());
                de.b().setOAID(f19911b.getOAID());
            }
        } catch (Throwable unused) {
        }
    }

    public static void bindASUSServiceGetOAID(Context context) {
        f19912c.b(context);
    }

    public static boolean a(Context context) {
        try {
            if (af.b(29) || !by.i()) {
                return false;
            }
            context.getPackageManager().getPackageInfo("com.asus.msa.SupplementaryDID", 0);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
