package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import cn.qqtheme.framework.widget.WheelView;
import com.alibaba.sdk.android.feedback.xblink.webview.HybridPlusWebView;
import com.google.android.gms.internal.ads.zzby;
import com.google.android.gms.internal.ads.zzcf;
import com.sandboxol.center.config.IntConstant;
import com.sandboxol.center.web.http.HttpCode;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzdv implements zzdw {
    protected static volatile zzex zzwg;
    protected MotionEvent zzwl;
    protected double zzwu;
    private double zzwv;
    private double zzww;
    protected float zzwx;
    protected float zzwy;
    protected float zzwz;
    protected float zzxa;
    protected DisplayMetrics zzxd;
    protected LinkedList<MotionEvent> zzwm = new LinkedList<>();
    protected long zzwn = 0;
    protected long zzwo = 0;
    protected long zzwp = 0;
    protected long zzwq = 0;
    protected long zzwr = 0;
    protected long zzws = 0;
    protected long zzwt = 0;
    private boolean zzxb = false;
    protected boolean zzxc = false;

    protected zzdv(Context context) {
        try {
            if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcre)).booleanValue()) {
                zzcx.zzbo();
            } else {
                zzfe.zzb(zzwg);
            }
            this.zzxd = context.getResources().getDisplayMetrics();
        } catch (Throwable unused) {
        }
    }

    private final void zzbx() {
        this.zzwr = 0L;
        this.zzwn = 0L;
        this.zzwo = 0L;
        this.zzwp = 0L;
        this.zzwq = 0L;
        this.zzws = 0L;
        this.zzwt = 0L;
        if (this.zzwm.size() > 0) {
            Iterator<MotionEvent> it = this.zzwm.iterator();
            while (it.hasNext()) {
                it.next().recycle();
            }
            this.zzwm.clear();
        } else {
            MotionEvent motionEvent = this.zzwl;
            if (motionEvent != null) {
                motionEvent.recycle();
            }
        }
        this.zzwl = null;
    }

    protected abstract long zza(StackTraceElement[] stackTraceElementArr) throws zzeu;

    protected abstract zzcf.zza.C0108zza zza(Context context, zzby.zza zzaVar);

    @Override // com.google.android.gms.internal.ads.zzdw
    public String zza(Context context, View view, Activity activity) {
        return zza(context, null, zzcw.zzno, view, activity, null);
    }

    protected abstract zzcf.zza.C0108zza zzb(Context context, View view, Activity activity);

    protected abstract zzfd zzb(MotionEvent motionEvent) throws zzeu;

    @Override // com.google.android.gms.internal.ads.zzdw
    public String zzb(Context context) {
        if (zzfg.isMainThread()) {
            throw new IllegalStateException("The caller must not be called from the UI thread.");
        }
        return zza(context, null, zzcw.zznn, null, null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzdw
    public void zzb(View view) {
    }

    protected abstract zzcf.zza.C0108zza zzc(Context context, View view, Activity activity);

    @Override // com.google.android.gms.internal.ads.zzdw
    public final String zza(Context context, String str, View view) {
        return zza(context, str, view, null);
    }

    @Override // com.google.android.gms.internal.ads.zzdw
    public String zza(Context context, String str, View view, Activity activity) {
        return zza(context, str, zzcw.zznp, view, activity, null);
    }

    @Override // com.google.android.gms.internal.ads.zzdw
    public void zza(MotionEvent motionEvent) {
        boolean z = false;
        if (this.zzxb) {
            zzbx();
            this.zzxb = false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.zzwu = 0.0d;
            this.zzwv = motionEvent.getRawX();
            this.zzww = motionEvent.getRawY();
        } else if (action == 1 || action == 2) {
            double rawX = motionEvent.getRawX();
            double rawY = motionEvent.getRawY();
            double d2 = this.zzwv;
            Double.isNaN(rawX);
            double d3 = rawX - d2;
            double d4 = this.zzww;
            Double.isNaN(rawY);
            double d5 = rawY - d4;
            this.zzwu += Math.sqrt((d3 * d3) + (d5 * d5));
            this.zzwv = rawX;
            this.zzww = rawY;
        }
        int action2 = motionEvent.getAction();
        if (action2 != 0) {
            try {
                if (action2 == 1) {
                    this.zzwl = MotionEvent.obtain(motionEvent);
                    this.zzwm.add(this.zzwl);
                    if (this.zzwm.size() > 6) {
                        this.zzwm.remove().recycle();
                    }
                    this.zzwp++;
                    this.zzwr = zza(new Throwable().getStackTrace());
                } else if (action2 == 2) {
                    this.zzwo += (long) (motionEvent.getHistorySize() + 1);
                    zzfd zzfdVarZzb = zzb(motionEvent);
                    if ((zzfdVarZzb == null || zzfdVarZzb.zzzs == null || zzfdVarZzb.zzzv == null) ? false : true) {
                        this.zzws += zzfdVarZzb.zzzs.longValue() + zzfdVarZzb.zzzv.longValue();
                    }
                    if (this.zzxd != null && zzfdVarZzb != null && zzfdVarZzb.zzzt != null && zzfdVarZzb.zzzw != null) {
                        z = true;
                    }
                    if (z) {
                        this.zzwt += zzfdVarZzb.zzzt.longValue() + zzfdVarZzb.zzzw.longValue();
                    }
                } else if (action2 == 3) {
                    this.zzwq++;
                }
            } catch (zzeu unused) {
            }
        } else {
            this.zzwx = motionEvent.getX();
            this.zzwy = motionEvent.getY();
            this.zzwz = motionEvent.getRawX();
            this.zzxa = motionEvent.getRawY();
            this.zzwn++;
        }
        this.zzxc = true;
    }

    @Override // com.google.android.gms.internal.ads.zzdw
    public void zza(int i, int i2, int i3) {
        if (this.zzwl != null) {
            if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcqr)).booleanValue()) {
                zzbx();
            } else {
                this.zzwl.recycle();
            }
        }
        DisplayMetrics displayMetrics = this.zzxd;
        if (displayMetrics != null) {
            float f2 = displayMetrics.density;
            this.zzwl = MotionEvent.obtain(0L, i3, 1, i * f2, i2 * f2, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, 0, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, 0, 0);
        } else {
            this.zzwl = null;
        }
        this.zzxc = false;
    }

    private final String zza(Context context, String str, int i, View view, Activity activity, byte[] bArr) {
        zzdu zzduVarZzcl;
        String str2;
        int i2;
        int i3;
        int i4;
        int i5;
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean zBooleanValue = ((Boolean) zzwm.zzpx().zzd(zzabb.zzcqt)).booleanValue();
        zzcf.zza.C0108zza c0108zzaZza = null;
        if (zBooleanValue) {
            zzduVarZzcl = zzwg != null ? zzwg.zzcl() : null;
            str2 = ((Boolean) zzwm.zzpx().zzd(zzabb.zzcre)).booleanValue() ? "be" : "te";
        } else {
            zzduVarZzcl = null;
            str2 = null;
        }
        try {
            if (i == zzcw.zznp) {
                c0108zzaZza = zzb(context, view, activity);
                this.zzxb = true;
                i5 = 1002;
            } else if (i == zzcw.zzno) {
                c0108zzaZza = zzc(context, view, activity);
                i5 = 1008;
            } else {
                c0108zzaZza = zza(context, null);
                i5 = 1000;
            }
            if (zBooleanValue && zzduVarZzcl != null) {
                zzduVarZzcl.zza(i5, -1, System.currentTimeMillis() - jCurrentTimeMillis, str2);
            }
        } catch (Exception e2) {
            if (zBooleanValue && zzduVarZzcl != null) {
                if (i == zzcw.zznp) {
                    i2 = IntConstant.PERMISSION_STORAGE_DOWNLOAD;
                } else if (i == zzcw.zzno) {
                    i2 = 1009;
                } else {
                    i2 = i == zzcw.zznn ? 1001 : -1;
                }
                zzduVarZzcl.zza(i2, -1, System.currentTimeMillis() - jCurrentTimeMillis, str2, e2);
            }
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (c0108zzaZza != null) {
            try {
                if (((zzcf.zza) ((zzejz) c0108zzaZza.zzbgt())).zzbgh() != 0) {
                    String strZzj = zzcx.zzj((zzcf.zza) ((zzejz) c0108zzaZza.zzbgt()), str);
                    if (!zBooleanValue || zzduVarZzcl == null) {
                        return strZzj;
                    }
                    if (i == zzcw.zznp) {
                        i4 = HttpCode.PASSWORD_NOT_SET;
                    } else if (i == zzcw.zzno) {
                        i4 = 1010;
                    } else {
                        i4 = i == zzcw.zznn ? 1004 : -1;
                    }
                    zzduVarZzcl.zza(i4, -1, System.currentTimeMillis() - jCurrentTimeMillis2, str2);
                    return strZzj;
                }
            } catch (Exception e3) {
                String string = Integer.toString(7);
                if (!zBooleanValue || zzduVarZzcl == null) {
                    return string;
                }
                if (i == zzcw.zznp) {
                    i3 = HttpCode.THIRD_PART_ACCOUNT_ALREADY_BIND_OTHER_USER;
                } else if (i == zzcw.zzno) {
                    i3 = HybridPlusWebView.LOAD_BEGIN;
                } else {
                    i3 = i == zzcw.zznn ? 1005 : -1;
                }
                zzduVarZzcl.zza(i3, -1, System.currentTimeMillis() - jCurrentTimeMillis2, str2, e3);
                return string;
            }
        }
        return Integer.toString(5);
    }
}
