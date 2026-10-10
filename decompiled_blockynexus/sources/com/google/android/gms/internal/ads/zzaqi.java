package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.ads.impl.R;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaqi extends zzaqn {
    private final Map<String, String> zzczo;
    private final Context zzvr;

    public zzaqi(zzbgj zzbgjVar, Map<String, String> map) {
        super(zzbgjVar, "storePicture");
        this.zzczo = map;
        this.zzvr = zzbgjVar.zzzu();
    }

    public final void execute() {
        if (this.zzvr == null) {
            zzdx("Activity context is not available");
            return;
        }
        com.google.android.gms.ads.internal.zzp.zzkr();
        if (!zzayu.zzat(this.zzvr).zzrd()) {
            zzdx("Feature is not supported by the device.");
            return;
        }
        String str = this.zzczo.get("iurl");
        if (TextUtils.isEmpty(str)) {
            zzdx("Image url cannot be empty.");
            return;
        }
        if (!URLUtil.isValidUrl(str)) {
            String strValueOf = String.valueOf(str);
            zzdx(strValueOf.length() != 0 ? "Invalid image url: ".concat(strValueOf) : new String("Invalid image url: "));
            return;
        }
        String lastPathSegment = Uri.parse(str).getLastPathSegment();
        com.google.android.gms.ads.internal.zzp.zzkr();
        if (!zzayu.zzeo(lastPathSegment)) {
            String strValueOf2 = String.valueOf(lastPathSegment);
            zzdx(strValueOf2.length() != 0 ? "Image type not recognized: ".concat(strValueOf2) : new String("Image type not recognized: "));
            return;
        }
        Resources resources = com.google.android.gms.ads.internal.zzp.zzkv().getResources();
        com.google.android.gms.ads.internal.zzp.zzkr();
        AlertDialog.Builder builderZzas = zzayu.zzas(this.zzvr);
        builderZzas.setTitle(resources != null ? resources.getString(R.string.s1) : "Save image");
        builderZzas.setMessage(resources != null ? resources.getString(R.string.s2) : "Allow Ad to store image in Picture gallery?");
        builderZzas.setPositiveButton(resources != null ? resources.getString(R.string.s3) : AbstractSpiCall.HEADER_ACCEPT, new zzaqh(this, str, lastPathSegment));
        builderZzas.setNegativeButton(resources != null ? resources.getString(R.string.s4) : "Decline", new zzaqk(this));
        builderZzas.create().show();
    }
}
