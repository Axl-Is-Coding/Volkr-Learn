package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.provider.Settings;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.webkit.WebSettings;
import cn.qqtheme.framework.widget.WheelView;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.SharedPreferencesUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@TargetApi(17)
public class zzaze extends zzazd {
    public zzaze() {
        super();
    }

    @Override // com.google.android.gms.internal.ads.zzazd
    public final String getDefaultUserAgent(Context context) {
        zzbbb zzbbbVarZzyl = zzbbb.zzyl();
        if (TextUtils.isEmpty(zzbbbVarZzyl.zzedk)) {
            zzbbbVarZzyl.zzedk = ClientLibraryUtils.isPackageSide() ? (String) zzbay.zza(context, new zzbba(zzbbbVarZzyl, context)) : (String) zzbay.zza(context, new zzbbd(zzbbbVarZzyl, GooglePlayServicesUtilLight.getRemoteContext(context), context));
        }
        return zzbbbVarZzyl.zzedk;
    }

    @Override // com.google.android.gms.internal.ads.zzazd
    public final boolean zza(Context context, WebSettings webSettings) {
        super.zza(context, webSettings);
        webSettings.setMediaPlaybackRequiresUserGesture(false);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzazd
    public final int zzb(ContentResolver contentResolver) {
        return Settings.Global.getInt(contentResolver, "airplane_mode_on", 0);
    }

    @Override // com.google.android.gms.internal.ads.zzazd
    public final void zzbg(Context context) {
        zzbbb zzbbbVarZzyl = zzbbb.zzyl();
        zzayp.zzei("Updating user agent.");
        String defaultUserAgent = WebSettings.getDefaultUserAgent(context);
        if (!defaultUserAgent.equals(zzbbbVarZzyl.zzedk)) {
            Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
            if (ClientLibraryUtils.isPackageSide() || remoteContext == null) {
                SharedPreferences.Editor editorPutString = context.getSharedPreferences("admob_user_agent", 0).edit().putString("user_agent", WebSettings.getDefaultUserAgent(context));
                if (remoteContext != null) {
                    SharedPreferencesUtils.publishWorldReadableSharedPreferences(context, editorPutString, "admob_user_agent");
                    throw null;
                }
                editorPutString.apply();
            }
            zzbbbVarZzyl.zzedk = defaultUserAgent;
        }
        zzayp.zzei("User agent is updated.");
    }

    @Override // com.google.android.gms.internal.ads.zzazd
    public final Drawable zza(Context context, Bitmap bitmap, boolean z, float f2) {
        if (z && f2 > WheelView.DividerConfig.FILL && f2 <= 25.0f) {
            try {
                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), false);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateScaledBitmap);
                RenderScript renderScriptCreate = RenderScript.create(context);
                ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
                Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateScaledBitmap);
                Allocation allocationCreateFromBitmap2 = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateBitmap);
                scriptIntrinsicBlurCreate.setRadius(f2);
                scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
                scriptIntrinsicBlurCreate.forEach(allocationCreateFromBitmap2);
                allocationCreateFromBitmap2.copyTo(bitmapCreateBitmap);
                return new BitmapDrawable(context.getResources(), bitmapCreateBitmap);
            } catch (RuntimeException unused) {
                return new BitmapDrawable(context.getResources(), bitmap);
            }
        }
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    @Override // com.google.android.gms.internal.ads.zzazd
    public final int zza(ContentResolver contentResolver) {
        return Settings.Global.getInt(contentResolver, "wifi_on", 0);
    }
}
