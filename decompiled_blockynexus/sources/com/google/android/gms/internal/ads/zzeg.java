package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzeg {
    private static final String[] zzyb = {"/aclk", "/pcs/click", "/dbm/clk"};
    private String zzxx = "googleads.g.doubleclick.net";
    private String zzxy = "/pagead/ads";
    private String zzxz = "ad.doubleclick.net";
    private String[] zzya = {".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
    private zzdw zzyc;

    public zzeg(zzdw zzdwVar) {
        this.zzyc = zzdwVar;
    }

    private final boolean zza(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            return uri.getHost().equals(this.zzxz);
        } catch (NullPointerException unused) {
            return false;
        }
    }

    public final boolean zzb(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            String host = uri.getHost();
            for (String str : this.zzya) {
                if (host.endsWith(str)) {
                    return true;
                }
            }
        } catch (NullPointerException unused) {
        }
        return false;
    }

    public final boolean zzc(Uri uri) {
        if (zzb(uri)) {
            for (String str : zzyb) {
                if (uri.getPath().endsWith(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final zzdw zzca() {
        return this.zzyc;
    }

    public final Uri zza(Uri uri, Context context) throws zzef {
        return zza(uri, this.zzyc.zzb(context));
    }

    public final void zza(MotionEvent motionEvent) {
        this.zzyc.zza(motionEvent);
    }

    public final Uri zza(Uri uri, Context context, View view, Activity activity) throws zzef {
        try {
            return zza(uri, this.zzyc.zza(context, uri.getQueryParameter("ai"), view, activity));
        } catch (UnsupportedOperationException unused) {
            throw new zzef("Provided Uri is not in a valid state");
        }
    }

    private final Uri zza(Uri uri, String str) throws zzef {
        try {
            boolean zZza = zza(uri);
            if (zZza) {
                if (uri.toString().contains("dc_ms=")) {
                    throw new zzef("Parameter already exists: dc_ms");
                }
            } else if (uri.getQueryParameter("ms") != null) {
                throw new zzef("Query parameter already exists: ms");
            }
            if (zZza) {
                String string = uri.toString();
                int iIndexOf = string.indexOf(";adurl");
                if (iIndexOf != -1) {
                    int i = iIndexOf + 1;
                    return Uri.parse(string.substring(0, i) + "dc_ms=" + str + ";" + string.substring(i));
                }
                String encodedPath = uri.getEncodedPath();
                int iIndexOf2 = string.indexOf(encodedPath);
                return Uri.parse(string.substring(0, encodedPath.length() + iIndexOf2) + ";dc_ms=" + str + ";" + string.substring(iIndexOf2 + encodedPath.length()));
            }
            String string2 = uri.toString();
            int iIndexOf3 = string2.indexOf("&adurl");
            if (iIndexOf3 == -1) {
                iIndexOf3 = string2.indexOf("?adurl");
            }
            if (iIndexOf3 != -1) {
                int i2 = iIndexOf3 + 1;
                return Uri.parse(string2.substring(0, i2) + "ms=" + str + "&" + string2.substring(i2));
            }
            return uri.buildUpon().appendQueryParameter("ms", str).build();
        } catch (UnsupportedOperationException unused) {
            throw new zzef("Provided Uri is not in a valid state");
        }
    }
}
