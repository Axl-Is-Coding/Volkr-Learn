package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PointF;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import fi.iki.elonen.NanoHTTPD;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzazp {
    private Handler handler;
    private int state;
    private String zzbre;
    private String zzbuu;
    private String zzdps;
    private String zzdti;
    private int zzebo;
    private PointF zzebp;
    private PointF zzebq;
    private Runnable zzebr;
    private final Context zzvr;

    public zzazp(Context context) {
        this.state = 0;
        this.zzebr = new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzazo
            private final zzazp zzebn;

            {
                this.zzebn = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzebn.zzye();
            }
        };
        this.zzvr = context;
        this.zzebo = ViewConfiguration.get(context).getScaledTouchSlop();
        com.google.android.gms.ads.internal.zzp.zzlf().zzyj();
        this.handler = com.google.android.gms.ads.internal.zzp.zzlf().getHandler();
    }

    private final boolean zza(float f2, float f3, float f4, float f5) {
        return Math.abs(this.zzebp.x - f2) < ((float) this.zzebo) && Math.abs(this.zzebp.y - f3) < ((float) this.zzebo) && Math.abs(this.zzebq.x - f4) < ((float) this.zzebo) && Math.abs(this.zzebq.y - f5) < ((float) this.zzebo);
    }

    public final void setAdUnitId(String str) {
        this.zzbuu = str;
    }

    public final void showDialog() {
        try {
            if (!(this.zzvr instanceof Activity)) {
                zzbbq.zzfd("Can not create dialog without Activity Context");
                return;
            }
            String str = !TextUtils.isEmpty(com.google.android.gms.ads.internal.zzp.zzlb().zzyf()) ? "Creative Preview (Enabled)" : "Creative Preview";
            String str2 = com.google.android.gms.ads.internal.zzp.zzlb().zzyg() ? "Troubleshooting (Enabled)" : "Troubleshooting";
            ArrayList arrayList = new ArrayList();
            final int iZza = zza((List<String>) arrayList, "Ad Information", true);
            final int iZza2 = zza((List<String>) arrayList, str, true);
            final int iZza3 = zza((List<String>) arrayList, str2, true);
            AlertDialog.Builder builder = new AlertDialog.Builder(this.zzvr, com.google.android.gms.ads.internal.zzp.zzkt().zzxz());
            builder.setTitle("Select a Debug Mode").setItems((CharSequence[]) arrayList.toArray(new String[0]), new DialogInterface.OnClickListener(this, iZza, iZza2, iZza3) { // from class: com.google.android.gms.internal.ads.zzazr
                private final zzazp zzebn;
                private final int zzebs;
                private final int zzebt;
                private final int zzebu;

                {
                    this.zzebn = this;
                    this.zzebs = iZza;
                    this.zzebt = iZza2;
                    this.zzebu = iZza3;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.zzebn.zza(this.zzebs, this.zzebt, this.zzebu, dialogInterface, i);
                }
            });
            builder.create().show();
        } catch (WindowManager.BadTokenException e2) {
            zzayp.zza("", e2);
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(100);
        sb.append("{Dialog: ");
        sb.append(this.zzdps);
        sb.append(",DebugSignal: ");
        sb.append(this.zzdti);
        sb.append(",AFMA Version: ");
        sb.append(this.zzbre);
        sb.append(",Ad Unit ID: ");
        sb.append(this.zzbuu);
        sb.append("}");
        return sb.toString();
    }

    public final void zzae(String str) {
        this.zzbre = str;
    }

    public final void zzd(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        int historySize = motionEvent.getHistorySize();
        int pointerCount = motionEvent.getPointerCount();
        if (actionMasked == 0) {
            this.state = 0;
            this.zzebp = new PointF(motionEvent.getX(0), motionEvent.getY(0));
            return;
        }
        int i = this.state;
        if (i == -1) {
            return;
        }
        boolean z = true;
        if (i == 0 && actionMasked == 5) {
            this.state = 5;
            this.zzebq = new PointF(motionEvent.getX(1), motionEvent.getY(1));
            this.handler.postDelayed(this.zzebr, ((Long) zzwm.zzpx().zzd(zzabb.zzctl)).longValue());
            return;
        }
        if (this.state == 5) {
            if (pointerCount == 2) {
                if (actionMasked == 2) {
                    boolean z2 = false;
                    for (int i2 = 0; i2 < historySize; i2++) {
                        if (!zza(motionEvent.getHistoricalX(0, i2), motionEvent.getHistoricalY(0, i2), motionEvent.getHistoricalX(1, i2), motionEvent.getHistoricalY(1, i2))) {
                            z2 = true;
                        }
                    }
                    if (zza(motionEvent.getX(), motionEvent.getY(), motionEvent.getX(1), motionEvent.getY(1))) {
                        z = z2;
                    }
                } else {
                    z = false;
                }
            }
            if (z) {
                this.state = -1;
                this.handler.removeCallbacks(this.zzebr);
            }
        }
    }

    public final void zzet(String str) {
        this.zzdps = str;
    }

    public final void zzeu(String str) {
        this.zzdti = str;
    }

    final /* synthetic */ void zzyc() {
        com.google.android.gms.ads.internal.zzp.zzlb().zza(this.zzvr, this.zzbuu, this.zzbre, this.zzdti);
    }

    final /* synthetic */ void zzyd() {
        com.google.android.gms.ads.internal.zzp.zzlb().zze(this.zzvr, this.zzbuu, this.zzbre);
    }

    final /* synthetic */ void zzye() {
        this.state = 4;
        showDialog();
    }

    private static int zza(List<String> list, String str, boolean z) {
        list.add(str);
        return list.size() - 1;
    }

    final /* synthetic */ void zza(String str, DialogInterface dialogInterface, int i) {
        com.google.android.gms.ads.internal.zzp.zzkr();
        zzayu.zza(this.zzvr, Intent.createChooser(new Intent("android.intent.action.SEND").setType(NanoHTTPD.MIME_PLAINTEXT).putExtra("android.intent.extra.TEXT", str), "Share via"));
    }

    public zzazp(Context context, String str) {
        this(context);
        this.zzdps = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final /* synthetic */ void zza(int r1, int r2, int r3, android.content.DialogInterface r4, int r5) {
        /*
            r0 = this;
            if (r5 != r1) goto L9b
            android.content.Context r1 = r0.zzvr
            boolean r1 = r1 instanceof android.app.Activity
            if (r1 != 0) goto Le
            java.lang.String r1 = "Can not create dialog without Activity Context"
            com.google.android.gms.internal.ads.zzbbq.zzfd(r1)
            return
        Le:
            java.lang.String r1 = r0.zzdps
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L71
            java.lang.String r2 = "\\+"
            java.lang.String r3 = "%20"
            java.lang.String r1 = r1.replaceAll(r2, r3)
            android.net.Uri$Builder r2 = new android.net.Uri$Builder
            r2.<init>()
            android.net.Uri$Builder r1 = r2.encodedQuery(r1)
            android.net.Uri r1 = r1.build()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            com.google.android.gms.ads.internal.zzp.zzkr()
            java.util.Map r1 = com.google.android.gms.internal.ads.zzayu.zzj(r1)
            java.util.Set r3 = r1.keySet()
            java.util.Iterator r3 = r3.iterator()
        L3f:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L62
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            r2.append(r4)
            java.lang.String r5 = " = "
            r2.append(r5)
            java.lang.Object r4 = r1.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            r2.append(r4)
            java.lang.String r4 = "\n\n"
            r2.append(r4)
            goto L3f
        L62:
            java.lang.String r1 = r2.toString()
            java.lang.String r1 = r1.trim()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L71
            goto L73
        L71:
            java.lang.String r1 = "No debug information"
        L73:
            android.app.AlertDialog$Builder r2 = new android.app.AlertDialog$Builder
            android.content.Context r3 = r0.zzvr
            r2.<init>(r3)
            r2.setMessage(r1)
            java.lang.String r3 = "Ad Information"
            r2.setTitle(r3)
            com.google.android.gms.internal.ads.zzazq r3 = new com.google.android.gms.internal.ads.zzazq
            r3.<init>(r0, r1)
            java.lang.String r1 = "Share"
            r2.setPositiveButton(r1, r3)
            android.content.DialogInterface$OnClickListener r1 = com.google.android.gms.internal.ads.zzazt.zzebv
            java.lang.String r3 = "Close"
            r2.setNegativeButton(r3, r1)
            android.app.AlertDialog r1 = r2.create()
            r1.show()
            return
        L9b:
            if (r5 != r2) goto Lad
            java.lang.String r1 = "Debug mode [Creative Preview] selected."
            com.google.android.gms.internal.ads.zzbbq.zzef(r1)
            com.google.android.gms.internal.ads.zzdzb r1 = com.google.android.gms.internal.ads.zzbbz.zzeep
            com.google.android.gms.internal.ads.zzazs r2 = new com.google.android.gms.internal.ads.zzazs
            r2.<init>(r0)
            r1.execute(r2)
            return
        Lad:
            if (r5 != r3) goto Lbe
            java.lang.String r1 = "Debug mode [Troubleshooting] selected."
            com.google.android.gms.internal.ads.zzbbq.zzef(r1)
            com.google.android.gms.internal.ads.zzdzb r1 = com.google.android.gms.internal.ads.zzbbz.zzeep
            com.google.android.gms.internal.ads.zzazv r2 = new com.google.android.gms.internal.ads.zzazv
            r2.<init>(r0)
            r1.execute(r2)
        Lbe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzazp.zza(int, int, int, android.content.DialogInterface, int):void");
    }
}
