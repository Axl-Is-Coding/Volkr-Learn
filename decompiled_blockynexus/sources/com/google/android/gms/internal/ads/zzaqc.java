package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.CalendarContract;
import android.text.TextUtils;
import com.google.android.gms.ads.impl.R;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaqc extends zzaqn {
    private final Map<String, String> zzczo;
    private String zzdmx;
    private long zzdmy;
    private long zzdmz;
    private String zzdna;
    private String zzdnb;
    private final Context zzvr;

    public zzaqc(zzbgj zzbgjVar, Map<String, String> map) {
        super(zzbgjVar, "createCalendarEvent");
        this.zzczo = map;
        this.zzvr = zzbgjVar.zzzu();
        this.zzdmx = zzdv("description");
        this.zzdna = zzdv("summary");
        this.zzdmy = zzdw("start_ticks");
        this.zzdmz = zzdw("end_ticks");
        this.zzdnb = zzdv("location");
    }

    private final String zzdv(String str) {
        return TextUtils.isEmpty(this.zzczo.get(str)) ? "" : this.zzczo.get(str);
    }

    private final long zzdw(String str) {
        String str2 = this.zzczo.get(str);
        if (str2 == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    @TargetApi(14)
    final Intent createIntent() {
        Intent data = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
        data.putExtra("title", this.zzdmx);
        data.putExtra("eventLocation", this.zzdnb);
        data.putExtra("description", this.zzdna);
        long j = this.zzdmy;
        if (j > -1) {
            data.putExtra("beginTime", j);
        }
        long j2 = this.zzdmz;
        if (j2 > -1) {
            data.putExtra("endTime", j2);
        }
        data.setFlags(268435456);
        return data;
    }

    public final void execute() {
        if (this.zzvr == null) {
            zzdx("Activity context is not available.");
            return;
        }
        com.google.android.gms.ads.internal.zzp.zzkr();
        if (!zzayu.zzat(this.zzvr).zzre()) {
            zzdx("This feature is not available on the device.");
            return;
        }
        com.google.android.gms.ads.internal.zzp.zzkr();
        AlertDialog.Builder builderZzas = zzayu.zzas(this.zzvr);
        Resources resources = com.google.android.gms.ads.internal.zzp.zzkv().getResources();
        builderZzas.setTitle(resources != null ? resources.getString(R.string.s5) : "Create calendar event");
        builderZzas.setMessage(resources != null ? resources.getString(R.string.s6) : "Allow Ad to create a calendar event?");
        builderZzas.setPositiveButton(resources != null ? resources.getString(R.string.s3) : AbstractSpiCall.HEADER_ACCEPT, new zzaqb(this));
        builderZzas.setNegativeButton(resources != null ? resources.getString(R.string.s4) : "Decline", new zzaqe(this));
        builderZzas.create().show();
    }
}
