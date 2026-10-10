package com.tendcloud.tenddata;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.security.MessageDigest;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public class cf {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f19922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static a f19923c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile cf f19924d = new cf();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedBlockingQueue<IBinder> f19925a = new LinkedBlockingQueue<>(1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ServiceConnection f19926e = new ServiceConnection() { // from class: com.tendcloud.tenddata.cf.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                cf.this.f19925a.put(iBinder);
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

        String getSerID(String str, String str2, String str3) {
            String string = null;
            try {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    this.mIBinder.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    string = parcelObtain2.readString();
                } catch (Throwable th) {
                    parcelObtain.recycle();
                    parcelObtain2.recycle();
                    throw th;
                }
                parcelObtain.recycle();
                parcelObtain2.recycle();
            } catch (Throwable unused) {
            }
            return string;
        }
    }

    private cf() {
    }

    private void b(Context context) {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
            intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
            if (context.bindService(intent, this.f19926e, 1)) {
                f19923c = new a(this.f19925a.take());
                try {
                    de.b().setOAID(a("OUID", context));
                } catch (Throwable unused) {
                }
                try {
                    de.b().setVAID(a("DUID", context));
                } catch (Throwable unused2) {
                }
                de.b().setAAID(a("AUID", context));
            }
        } catch (Throwable unused3) {
        }
    }

    public static void bindONEPLUSServiceGetOAID(Context context) {
        f19924d.b(context);
    }

    public static boolean a(Context context) {
        PackageInfo packageInfo;
        try {
            if (af.b(29) || !by.d() || (packageInfo = context.getPackageManager().getPackageInfo("com.heytap.openid", 0)) == null) {
                return false;
            }
            return packageInfo.versionCode >= 1;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static String a(String str, Context context) {
        Signature[] signatureArr;
        String packageName = context.getPackageName();
        if (f19922b == null) {
            String string = null;
            try {
                signatureArr = context.getPackageManager().getPackageInfo(packageName, 64).signatures;
            } catch (Throwable unused) {
                signatureArr = null;
            }
            if (signatureArr != null && signatureArr.length > 0) {
                byte[] byteArray = signatureArr[0].toByteArray();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                    if (messageDigest != null) {
                        byte[] bArrDigest = messageDigest.digest(byteArray);
                        StringBuilder sb = new StringBuilder();
                        for (byte b2 : bArrDigest) {
                            sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
                        }
                        string = sb.toString();
                    }
                } catch (Throwable unused2) {
                }
            }
            f19922b = string;
        }
        return f19923c.getSerID(packageName, f19922b, str);
    }
}
