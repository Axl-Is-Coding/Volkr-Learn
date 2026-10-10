package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.common.util.CollectionUtils;
import com.sandboxol.center.config.StringConstant;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaqd extends zzaqn {
    private static final Set<String> zzdnc = CollectionUtils.setOf("top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center");
    private int height;
    private final Object lock;
    private int width;
    private zzaqq zzdfo;
    private final zzbgj zzdgy;
    private final Activity zzdms;
    private String zzdnd;
    private boolean zzdne;
    private int zzdnf;
    private int zzdng;
    private int zzdnh;
    private int zzdni;
    private zzbhy zzdnj;
    private ImageView zzdnk;
    private LinearLayout zzdnl;
    private PopupWindow zzdnm;
    private RelativeLayout zzdnn;
    private ViewGroup zzdno;

    public zzaqd(zzbgj zzbgjVar, zzaqq zzaqqVar) {
        super(zzbgjVar, "resize");
        this.zzdnd = "top-right";
        this.zzdne = true;
        this.zzdnf = 0;
        this.zzdng = 0;
        this.height = -1;
        this.zzdnh = 0;
        this.zzdni = 0;
        this.width = -1;
        this.lock = new Object();
        this.zzdgy = zzbgjVar;
        this.zzdms = zzbgjVar.zzzu();
        this.zzdfo = zzaqqVar;
    }

    public final void zza(int i, int i2, boolean z) {
        synchronized (this.lock) {
            this.zzdnf = i;
            this.zzdng = i2;
            PopupWindow popupWindow = this.zzdnm;
        }
    }

    public final void zzac(boolean z) {
        synchronized (this.lock) {
            if (this.zzdnm != null) {
                this.zzdnm.dismiss();
                this.zzdnn.removeView(this.zzdgy.getView());
                if (this.zzdno != null) {
                    this.zzdno.removeView(this.zzdnk);
                    this.zzdno.addView(this.zzdgy.getView());
                    this.zzdgy.zza(this.zzdnj);
                }
                if (z) {
                    zzdz(StringConstant.PARTY_GAME_CATEGORY_DEFAULT);
                    if (this.zzdfo != null) {
                        this.zzdfo.zzup();
                    }
                }
                this.zzdnm = null;
                this.zzdnn = null;
                this.zzdno = null;
                this.zzdnl = null;
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:124:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x023d A[Catch: all -> 0x04c3, TryCatch #0 {, blocks: (B:4:0x0007, B:6:0x000b, B:7:0x0010, B:9:0x0012, B:11:0x001a, B:12:0x001f, B:14:0x0021, B:16:0x002d, B:17:0x0032, B:19:0x0034, B:21:0x003c, B:22:0x0041, B:24:0x0043, B:26:0x0051, B:27:0x0062, B:29:0x0070, B:30:0x0081, B:32:0x008f, B:33:0x00a0, B:35:0x00ae, B:36:0x00bf, B:38:0x00cd, B:39:0x00db, B:41:0x00e9, B:42:0x00eb, B:44:0x00f1, B:49:0x00fa, B:50:0x00ff, B:52:0x0101, B:54:0x0109, B:57:0x0111, B:59:0x0134, B:62:0x013a, B:64:0x013e, B:67:0x0144, B:69:0x0148, B:71:0x014c, B:143:0x029d, B:144:0x02a2, B:146:0x02a4, B:148:0x02c6, B:150:0x02ca, B:152:0x02da, B:154:0x030e, B:158:0x0344, B:159:0x0378, B:189:0x03ce, B:196:0x03fd, B:197:0x0415, B:198:0x0434, B:200:0x043c, B:201:0x0445, B:202:0x046b, B:205:0x046e, B:207:0x047e, B:209:0x0488, B:211:0x049a, B:212:0x04b3, B:208:0x0483, B:190:0x03d5, B:191:0x03dc, B:192:0x03e3, B:193:0x03ea, B:194:0x03f0, B:195:0x03f7, B:161:0x037c, B:164:0x0386, B:167:0x0390, B:170:0x039a, B:173:0x03a4, B:176:0x03ae, B:153:0x0309, B:214:0x04b5, B:215:0x04ba, B:125:0x023d, B:127:0x0241, B:128:0x0252, B:135:0x0280, B:137:0x0284, B:141:0x0294, B:138:0x0287, B:140:0x028e, B:131:0x0276, B:133:0x027b, B:72:0x0153, B:74:0x0157, B:75:0x015d, B:102:0x01aa, B:110:0x021b, B:112:0x021e, B:114:0x0221, B:116:0x0225, B:103:0x01b8, B:106:0x01e8, B:104:0x01c9, B:105:0x01dc, B:107:0x01eb, B:108:0x0202, B:109:0x0212, B:77:0x0161, B:80:0x016b, B:83:0x0175, B:86:0x017f, B:89:0x0189, B:92:0x0193, B:120:0x022d, B:121:0x0233, B:217:0x04bc, B:218:0x04c1), top: B:223:0x0007, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x029d A[Catch: all -> 0x04c3, TryCatch #0 {, blocks: (B:4:0x0007, B:6:0x000b, B:7:0x0010, B:9:0x0012, B:11:0x001a, B:12:0x001f, B:14:0x0021, B:16:0x002d, B:17:0x0032, B:19:0x0034, B:21:0x003c, B:22:0x0041, B:24:0x0043, B:26:0x0051, B:27:0x0062, B:29:0x0070, B:30:0x0081, B:32:0x008f, B:33:0x00a0, B:35:0x00ae, B:36:0x00bf, B:38:0x00cd, B:39:0x00db, B:41:0x00e9, B:42:0x00eb, B:44:0x00f1, B:49:0x00fa, B:50:0x00ff, B:52:0x0101, B:54:0x0109, B:57:0x0111, B:59:0x0134, B:62:0x013a, B:64:0x013e, B:67:0x0144, B:69:0x0148, B:71:0x014c, B:143:0x029d, B:144:0x02a2, B:146:0x02a4, B:148:0x02c6, B:150:0x02ca, B:152:0x02da, B:154:0x030e, B:158:0x0344, B:159:0x0378, B:189:0x03ce, B:196:0x03fd, B:197:0x0415, B:198:0x0434, B:200:0x043c, B:201:0x0445, B:202:0x046b, B:205:0x046e, B:207:0x047e, B:209:0x0488, B:211:0x049a, B:212:0x04b3, B:208:0x0483, B:190:0x03d5, B:191:0x03dc, B:192:0x03e3, B:193:0x03ea, B:194:0x03f0, B:195:0x03f7, B:161:0x037c, B:164:0x0386, B:167:0x0390, B:170:0x039a, B:173:0x03a4, B:176:0x03ae, B:153:0x0309, B:214:0x04b5, B:215:0x04ba, B:125:0x023d, B:127:0x0241, B:128:0x0252, B:135:0x0280, B:137:0x0284, B:141:0x0294, B:138:0x0287, B:140:0x028e, B:131:0x0276, B:133:0x027b, B:72:0x0153, B:74:0x0157, B:75:0x015d, B:102:0x01aa, B:110:0x021b, B:112:0x021e, B:114:0x0221, B:116:0x0225, B:103:0x01b8, B:106:0x01e8, B:104:0x01c9, B:105:0x01dc, B:107:0x01eb, B:108:0x0202, B:109:0x0212, B:77:0x0161, B:80:0x016b, B:83:0x0175, B:86:0x017f, B:89:0x0189, B:92:0x0193, B:120:0x022d, B:121:0x0233, B:217:0x04bc, B:218:0x04c1), top: B:223:0x0007, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02a4 A[Catch: all -> 0x04c3, TryCatch #0 {, blocks: (B:4:0x0007, B:6:0x000b, B:7:0x0010, B:9:0x0012, B:11:0x001a, B:12:0x001f, B:14:0x0021, B:16:0x002d, B:17:0x0032, B:19:0x0034, B:21:0x003c, B:22:0x0041, B:24:0x0043, B:26:0x0051, B:27:0x0062, B:29:0x0070, B:30:0x0081, B:32:0x008f, B:33:0x00a0, B:35:0x00ae, B:36:0x00bf, B:38:0x00cd, B:39:0x00db, B:41:0x00e9, B:42:0x00eb, B:44:0x00f1, B:49:0x00fa, B:50:0x00ff, B:52:0x0101, B:54:0x0109, B:57:0x0111, B:59:0x0134, B:62:0x013a, B:64:0x013e, B:67:0x0144, B:69:0x0148, B:71:0x014c, B:143:0x029d, B:144:0x02a2, B:146:0x02a4, B:148:0x02c6, B:150:0x02ca, B:152:0x02da, B:154:0x030e, B:158:0x0344, B:159:0x0378, B:189:0x03ce, B:196:0x03fd, B:197:0x0415, B:198:0x0434, B:200:0x043c, B:201:0x0445, B:202:0x046b, B:205:0x046e, B:207:0x047e, B:209:0x0488, B:211:0x049a, B:212:0x04b3, B:208:0x0483, B:190:0x03d5, B:191:0x03dc, B:192:0x03e3, B:193:0x03ea, B:194:0x03f0, B:195:0x03f7, B:161:0x037c, B:164:0x0386, B:167:0x0390, B:170:0x039a, B:173:0x03a4, B:176:0x03ae, B:153:0x0309, B:214:0x04b5, B:215:0x04ba, B:125:0x023d, B:127:0x0241, B:128:0x0252, B:135:0x0280, B:137:0x0284, B:141:0x0294, B:138:0x0287, B:140:0x028e, B:131:0x0276, B:133:0x027b, B:72:0x0153, B:74:0x0157, B:75:0x015d, B:102:0x01aa, B:110:0x021b, B:112:0x021e, B:114:0x0221, B:116:0x0225, B:103:0x01b8, B:106:0x01e8, B:104:0x01c9, B:105:0x01dc, B:107:0x01eb, B:108:0x0202, B:109:0x0212, B:77:0x0161, B:80:0x016b, B:83:0x0175, B:86:0x017f, B:89:0x0189, B:92:0x0193, B:120:0x022d, B:121:0x0233, B:217:0x04bc, B:218:0x04c1), top: B:223:0x0007, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x019d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzg(java.util.Map<java.lang.String, java.lang.String> r17) {
        /*
            Method dump skipped, instruction units count: 1274
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaqd.zzg(java.util.Map):void");
    }

    public final void zzi(int i, int i2) {
        this.zzdnf = i;
        this.zzdng = i2;
    }

    public final boolean zzuo() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzdnm != null;
        }
        return z;
    }
}
