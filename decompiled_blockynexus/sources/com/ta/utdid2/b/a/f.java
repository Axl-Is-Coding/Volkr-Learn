package com.ta.utdid2.b.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/* JADX INFO: compiled from: NetworkUtils.java */
/* JADX INFO: loaded from: classes5.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ConnectivityManager f19355a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f19356d = {4, 7, 2, 1};

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m94a(Context context) {
        ConnectivityManager connectivityManagerA = a(context);
        if (connectivityManagerA == null) {
            Log.e("NetworkUtils", "connManager is null!");
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManagerA.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnected();
            }
            return false;
        } catch (Exception e2) {
            Log.e("NetworkUtils", e2.toString());
            return false;
        }
    }

    public static boolean b(Context context) {
        ConnectivityManager connectivityManagerA = a(context);
        if (connectivityManagerA != null) {
            try {
                NetworkInfo activeNetworkInfo = connectivityManagerA.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    int subtype = activeNetworkInfo.getSubtype();
                    if (d.f19354e) {
                        Log.d("NetworkUtils", "subType:" + subtype + ": name:" + activeNetworkInfo.getSubtypeName());
                    }
                    for (int i : f19356d) {
                        if (i == subtype) {
                            return true;
                        }
                    }
                } else {
                    Log.e("NetworkUtils", "networkInfo is null!");
                }
            } catch (Exception e2) {
                Log.e("NetworkUtils", e2.toString());
            }
        } else {
            Log.e("NetworkUtils", "connManager is null!");
        }
        return false;
    }

    public static ConnectivityManager a(Context context) {
        if (context == null) {
            Log.e("NetworkUtils", "context is null!");
            return null;
        }
        if (f19355a == null) {
            f19355a = (ConnectivityManager) context.getSystemService("connectivity");
        }
        return f19355a;
    }
}
