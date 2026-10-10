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
public class ck {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f19935b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f19936c = "com.mdid.msa";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile ck f19937d = new ck();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedBlockingQueue<IBinder> f19938a = new LinkedBlockingQueue<>(1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ServiceConnection f19939e = new ServiceConnection() { // from class: com.tendcloud.tenddata.ck.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                ck.this.f19938a.put(iBinder);
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
                    parcelObtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
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

    private ck() {
    }

    private void b(Context context) {
        try {
            String packageName = context.getPackageName();
            a(packageName, context);
            Intent intent = new Intent();
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
            intent.setAction("com.bun.msa.action.bindto.service");
            intent.putExtra("com.bun.msa.param.pkgname", packageName);
            if (context.bindService(intent, this.f19939e, 1)) {
                f19935b = new a(this.f19938a.take());
                de.b().setOAID(f19935b.getOAID());
            }
        } catch (Throwable unused) {
        }
    }

    public static void bindZTEServiceGetOAID(Context context) {
        f19937d.b(context);
    }

    public static boolean a(Context context) {
        try {
            if (af.b(29) || !by.g()) {
                return false;
            }
            context.getPackageManager().getPackageInfo(f19936c, 0);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static void a(String str, Context context) {
        Intent intent = new Intent();
        intent.setClassName(f19936c, "com.mdid.msa.service.MsaKlService");
        intent.setAction("com.bun.msa.action.start.service");
        intent.putExtra("com.bun.msa.param.pkgname", str);
        try {
            intent.putExtra("com.bun.msa.param.runinset", true);
            if (context.startService(intent) != null) {
            }
        } catch (Throwable unused) {
        }
    }
}
