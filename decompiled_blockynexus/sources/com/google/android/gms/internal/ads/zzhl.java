package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzhl implements Handler.Callback, zzna, zznc, zzof {
    private final Handler handler;
    private int repeatMode = 0;
    private int state = 1;
    private final zzhx[] zzaep;
    private final zzog zzaeq;
    private final Handler zzaes;
    private final zzid zzaev;
    private final zzia zzaew;
    private boolean zzaey;
    private boolean zzafc;
    private zzhy zzafd;
    private zzhu zzafh;
    private zzhn zzafi;
    private final zzhw[] zzafy;
    private final zzhs zzafz;
    private zzmz zzaga;
    private final zzpl zzagc;
    private final HandlerThread zzagd;
    private final zzhc zzage;
    private zzhx zzagf;
    private zzpd zzagg;
    private zzhx[] zzagh;
    private boolean zzagi;
    private boolean zzagj;
    private int zzagk;
    private int zzagl;
    private long zzagm;
    private int zzagn;
    private zzhm zzago;
    private long zzagp;
    private zzhk zzagq;
    private zzhk zzagr;
    private zzhk zzags;

    public zzhl(zzhx[] zzhxVarArr, zzog zzogVar, zzhs zzhsVar, boolean z, int i, Handler handler, zzhn zzhnVar, zzhc zzhcVar) {
        this.zzaep = zzhxVarArr;
        this.zzaeq = zzogVar;
        this.zzafz = zzhsVar;
        this.zzaey = z;
        this.zzaes = handler;
        this.zzafi = zzhnVar;
        this.zzage = zzhcVar;
        this.zzafy = new zzhw[zzhxVarArr.length];
        for (int i2 = 0; i2 < zzhxVarArr.length; i2++) {
            zzhxVarArr[i2].setIndex(i2);
            this.zzafy[i2] = zzhxVarArr[i2].zzdz();
        }
        this.zzagc = new zzpl();
        this.zzagh = new zzhx[0];
        this.zzaev = new zzid();
        this.zzaew = new zzia();
        zzogVar.zza(this);
        this.zzafh = zzhu.zzahz;
        this.zzagd = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.zzagd.start();
        this.handler = new Handler(this.zzagd.getLooper(), this);
    }

    private final void setState(int i) {
        if (this.state != i) {
            this.state = i;
            this.zzaes.obtainMessage(1, i, 0).sendToTarget();
        }
    }

    private final void zzdq(long j) throws zzhd {
        zzhk zzhkVar = this.zzags;
        this.zzagp = j + (zzhkVar == null ? 60000000L : zzhkVar.zzep());
        this.zzagc.zzel(this.zzagp);
        for (zzhx zzhxVar : this.zzagh) {
            zzhxVar.zzdo(this.zzagp);
        }
    }

    private final boolean zzdr(long j) {
        if (j == -9223372036854775807L || this.zzafi.zzagv < j) {
            return true;
        }
        zzhk zzhkVar = this.zzags.zzafw;
        return zzhkVar != null && zzhkVar.zzafu;
    }

    private final void zzet() throws zzhd {
        this.zzagj = false;
        this.zzagc.start();
        for (zzhx zzhxVar : this.zzagh) {
            zzhxVar.start();
        }
    }

    private final void zzeu() throws zzhd {
        this.zzagc.stop();
        for (zzhx zzhxVar : this.zzagh) {
            zza(zzhxVar);
        }
    }

    private final void zzev() throws zzhd {
        zzhk zzhkVar = this.zzags;
        if (zzhkVar == null) {
            return;
        }
        long jZzhq = zzhkVar.zzafm.zzhq();
        if (jZzhq != -9223372036854775807L) {
            zzdq(jZzhq);
        } else {
            zzhx zzhxVar = this.zzagf;
            if (zzhxVar == null || zzhxVar.zzfe()) {
                this.zzagp = this.zzagc.zzfz();
            } else {
                this.zzagp = this.zzagg.zzfz();
                this.zzagc.zzel(this.zzagp);
            }
            jZzhq = this.zzagp - this.zzags.zzep();
        }
        this.zzafi.zzagv = jZzhq;
        this.zzagm = SystemClock.elapsedRealtime() * 1000;
        long jZzhr = this.zzagh.length == 0 ? Long.MIN_VALUE : this.zzags.zzafm.zzhr();
        zzhn zzhnVar = this.zzafi;
        if (jZzhr == Long.MIN_VALUE) {
            jZzhr = this.zzafd.zza(this.zzags.zzafr, this.zzaew, false).zzaih;
        }
        zzhnVar.zzagw = jZzhr;
    }

    private final void zzew() {
        zzi(true);
        this.zzafz.onStopped();
        setState(1);
    }

    private final void zzex() throws IOException {
        zzhk zzhkVar = this.zzagq;
        if (zzhkVar == null || zzhkVar.zzafu) {
            return;
        }
        zzhk zzhkVar2 = this.zzagr;
        if (zzhkVar2 == null || zzhkVar2.zzafw == zzhkVar) {
            for (zzhx zzhxVar : this.zzagh) {
                if (!zzhxVar.zzec()) {
                    return;
                }
            }
            this.zzagq.zzafm.zzhn();
        }
    }

    private final void zzey() {
        zzhk zzhkVar = this.zzagq;
        long jZzhp = !zzhkVar.zzafu ? 0L : zzhkVar.zzafm.zzhp();
        if (jZzhp == Long.MIN_VALUE) {
            zzh(false);
            return;
        }
        long jZzep = this.zzagp - this.zzagq.zzep();
        boolean zZzdt = this.zzafz.zzdt(jZzhp - jZzep);
        zzh(zZzdt);
        if (zZzdt) {
            this.zzagq.zzafm.zzef(jZzep);
        }
    }

    private final void zzh(boolean z) {
        if (this.zzafc != z) {
            this.zzafc = z;
            this.zzaes.obtainMessage(2, z ? 1 : 0, 0).sendToTarget();
        }
    }

    private final void zzi(boolean z) {
        this.handler.removeMessages(2);
        this.zzagj = false;
        this.zzagc.stop();
        this.zzagg = null;
        this.zzagf = null;
        this.zzagp = 60000000L;
        for (zzhx zzhxVar : this.zzagh) {
            try {
                zza(zzhxVar);
                zzhxVar.disable();
            } catch (zzhd | RuntimeException e2) {
                Log.e("ExoPlayerImplInternal", "Stop failed.", e2);
            }
        }
        this.zzagh = new zzhx[0];
        zzhk zzhkVar = this.zzags;
        if (zzhkVar == null) {
            zzhkVar = this.zzagq;
        }
        zza(zzhkVar);
        this.zzagq = null;
        this.zzagr = null;
        this.zzags = null;
        zzh(false);
        if (z) {
            zzmz zzmzVar = this.zzaga;
            if (zzmzVar != null) {
                zzmzVar.zzia();
                this.zzaga = null;
            }
            this.zzafd = null;
        }
    }

    private final boolean zzu(int i) {
        this.zzafd.zza(i, this.zzaew, false);
        return !this.zzafd.zza(0, this.zzaev, false).zzait && this.zzafd.zza(i, this.zzaew, this.zzaev, this.repeatMode) == -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:162:0x028f A[Catch: IOException -> 0x08af, zzhd -> 0x08b4, RuntimeException -> 0x08b9, TryCatch #9 {RuntimeException -> 0x08b9, blocks: (B:3:0x0005, B:7:0x0019, B:9:0x0021, B:12:0x0028, B:16:0x002f, B:20:0x003a, B:23:0x004c, B:25:0x0052, B:29:0x005b, B:33:0x0063, B:34:0x0065, B:36:0x0069, B:37:0x0070, B:39:0x007a, B:41:0x007e, B:43:0x0082, B:44:0x0095, B:47:0x009b, B:10:0x0024, B:49:0x009f, B:56:0x00bd, B:63:0x00cb, B:66:0x00ce, B:69:0x00d8, B:73:0x00dc, B:74:0x00dd, B:76:0x00e1, B:78:0x00e6, B:81:0x00ec, B:83:0x00f2, B:86:0x00f7, B:88:0x00fc, B:92:0x0105, B:94:0x012f, B:95:0x0136, B:96:0x013d, B:98:0x0142, B:102:0x014f, B:104:0x0159, B:105:0x015b, B:107:0x015f, B:109:0x0165, B:112:0x016b, B:113:0x0172, B:114:0x0176, B:115:0x017d, B:117:0x0181, B:118:0x0186, B:119:0x0189, B:126:0x01c6, B:120:0x0198, B:122:0x01a0, B:123:0x01a6, B:125:0x01b0, B:128:0x01d2, B:130:0x01da, B:133:0x01e1, B:135:0x01e5, B:137:0x01ed, B:140:0x01f4, B:142:0x0207, B:143:0x0217, B:145:0x021b, B:147:0x022b, B:149:0x022f, B:151:0x023d, B:152:0x0242, B:160:0x028b, B:162:0x028f, B:165:0x0296, B:167:0x02a0, B:169:0x02aa, B:170:0x02af, B:171:0x02d7, B:173:0x02db, B:177:0x02e8, B:178:0x02eb, B:179:0x02f8, B:183:0x0306, B:185:0x030c, B:186:0x031f, B:188:0x0323, B:190:0x0333, B:192:0x0345, B:196:0x0353, B:198:0x0358, B:199:0x036c, B:200:0x0375, B:163:0x0292, B:153:0x025a, B:155:0x0262, B:157:0x026a, B:158:0x026f, B:202:0x0379, B:203:0x0384, B:210:0x038f, B:211:0x0390, B:213:0x0394, B:215:0x039c, B:217:0x03a9, B:216:0x03a3, B:219:0x03b5, B:221:0x03bd, B:222:0x03c6, B:224:0x03cc, B:225:0x03ec, B:229:0x03f5, B:235:0x0418, B:239:0x0426, B:247:0x043c, B:251:0x044a, B:254:0x0455, B:258:0x0464, B:259:0x046d, B:260:0x046e, B:262:0x0476, B:373:0x06da, B:375:0x06e0, B:376:0x06e8, B:378:0x0703, B:380:0x070e, B:384:0x0717, B:386:0x071d, B:392:0x0729, B:397:0x0733, B:399:0x073a, B:400:0x073d, B:402:0x0741, B:404:0x074f, B:405:0x0762, B:409:0x077b, B:411:0x0783, B:413:0x0789, B:446:0x0813, B:448:0x0817, B:450:0x081c, B:451:0x0824, B:453:0x0828, B:457:0x0831, B:462:0x0847, B:455:0x082d, B:458:0x0837, B:460:0x083c, B:461:0x0842, B:414:0x0793, B:416:0x0798, B:419:0x079f, B:421:0x07a7, B:425:0x07ba, B:435:0x07ec, B:437:0x07f4, B:428:0x07c2, B:429:0x07d0, B:422:0x07ac, B:433:0x07e6, B:438:0x07f8, B:440:0x07fd, B:445:0x0809, B:443:0x0803, B:263:0x047e, B:265:0x0482, B:278:0x04c5, B:280:0x04cd, B:305:0x05a7, B:307:0x05ab, B:310:0x05b4, B:312:0x05b8, B:314:0x05bc, B:316:0x05c3, B:318:0x05c7, B:320:0x05cd, B:322:0x05d9, B:323:0x0604, B:326:0x060b, B:328:0x0610, B:330:0x061c, B:332:0x0622, B:334:0x0628, B:335:0x062b, B:337:0x062f, B:339:0x0634, B:342:0x0646, B:345:0x064e, B:346:0x0651, B:348:0x0657, B:350:0x065f, B:355:0x0682, B:357:0x0687, B:360:0x0695, B:362:0x069b, B:364:0x06ab, B:366:0x06b1, B:367:0x06b8, B:369:0x06bb, B:370:0x06c4, B:371:0x06d4, B:372:0x06d7, B:315:0x05c0, B:282:0x04d5, B:284:0x04d9, B:292:0x0534, B:294:0x0538, B:297:0x0555, B:301:0x0563, B:303:0x0597, B:304:0x059b, B:300:0x055c, B:296:0x053f, B:286:0x04df, B:289:0x04f0, B:291:0x0523, B:266:0x0487, B:268:0x0491, B:270:0x0499, B:273:0x04a8, B:275:0x04ac, B:277:0x04b9, B:464:0x084b, B:468:0x0853, B:470:0x0859, B:471:0x0860, B:473:0x0865, B:474:0x086e, B:476:0x0872, B:478:0x0878, B:482:0x0884, B:484:0x0893, B:485:0x089f), top: B:512:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0292 A[Catch: IOException -> 0x08af, zzhd -> 0x08b4, RuntimeException -> 0x08b9, TryCatch #9 {RuntimeException -> 0x08b9, blocks: (B:3:0x0005, B:7:0x0019, B:9:0x0021, B:12:0x0028, B:16:0x002f, B:20:0x003a, B:23:0x004c, B:25:0x0052, B:29:0x005b, B:33:0x0063, B:34:0x0065, B:36:0x0069, B:37:0x0070, B:39:0x007a, B:41:0x007e, B:43:0x0082, B:44:0x0095, B:47:0x009b, B:10:0x0024, B:49:0x009f, B:56:0x00bd, B:63:0x00cb, B:66:0x00ce, B:69:0x00d8, B:73:0x00dc, B:74:0x00dd, B:76:0x00e1, B:78:0x00e6, B:81:0x00ec, B:83:0x00f2, B:86:0x00f7, B:88:0x00fc, B:92:0x0105, B:94:0x012f, B:95:0x0136, B:96:0x013d, B:98:0x0142, B:102:0x014f, B:104:0x0159, B:105:0x015b, B:107:0x015f, B:109:0x0165, B:112:0x016b, B:113:0x0172, B:114:0x0176, B:115:0x017d, B:117:0x0181, B:118:0x0186, B:119:0x0189, B:126:0x01c6, B:120:0x0198, B:122:0x01a0, B:123:0x01a6, B:125:0x01b0, B:128:0x01d2, B:130:0x01da, B:133:0x01e1, B:135:0x01e5, B:137:0x01ed, B:140:0x01f4, B:142:0x0207, B:143:0x0217, B:145:0x021b, B:147:0x022b, B:149:0x022f, B:151:0x023d, B:152:0x0242, B:160:0x028b, B:162:0x028f, B:165:0x0296, B:167:0x02a0, B:169:0x02aa, B:170:0x02af, B:171:0x02d7, B:173:0x02db, B:177:0x02e8, B:178:0x02eb, B:179:0x02f8, B:183:0x0306, B:185:0x030c, B:186:0x031f, B:188:0x0323, B:190:0x0333, B:192:0x0345, B:196:0x0353, B:198:0x0358, B:199:0x036c, B:200:0x0375, B:163:0x0292, B:153:0x025a, B:155:0x0262, B:157:0x026a, B:158:0x026f, B:202:0x0379, B:203:0x0384, B:210:0x038f, B:211:0x0390, B:213:0x0394, B:215:0x039c, B:217:0x03a9, B:216:0x03a3, B:219:0x03b5, B:221:0x03bd, B:222:0x03c6, B:224:0x03cc, B:225:0x03ec, B:229:0x03f5, B:235:0x0418, B:239:0x0426, B:247:0x043c, B:251:0x044a, B:254:0x0455, B:258:0x0464, B:259:0x046d, B:260:0x046e, B:262:0x0476, B:373:0x06da, B:375:0x06e0, B:376:0x06e8, B:378:0x0703, B:380:0x070e, B:384:0x0717, B:386:0x071d, B:392:0x0729, B:397:0x0733, B:399:0x073a, B:400:0x073d, B:402:0x0741, B:404:0x074f, B:405:0x0762, B:409:0x077b, B:411:0x0783, B:413:0x0789, B:446:0x0813, B:448:0x0817, B:450:0x081c, B:451:0x0824, B:453:0x0828, B:457:0x0831, B:462:0x0847, B:455:0x082d, B:458:0x0837, B:460:0x083c, B:461:0x0842, B:414:0x0793, B:416:0x0798, B:419:0x079f, B:421:0x07a7, B:425:0x07ba, B:435:0x07ec, B:437:0x07f4, B:428:0x07c2, B:429:0x07d0, B:422:0x07ac, B:433:0x07e6, B:438:0x07f8, B:440:0x07fd, B:445:0x0809, B:443:0x0803, B:263:0x047e, B:265:0x0482, B:278:0x04c5, B:280:0x04cd, B:305:0x05a7, B:307:0x05ab, B:310:0x05b4, B:312:0x05b8, B:314:0x05bc, B:316:0x05c3, B:318:0x05c7, B:320:0x05cd, B:322:0x05d9, B:323:0x0604, B:326:0x060b, B:328:0x0610, B:330:0x061c, B:332:0x0622, B:334:0x0628, B:335:0x062b, B:337:0x062f, B:339:0x0634, B:342:0x0646, B:345:0x064e, B:346:0x0651, B:348:0x0657, B:350:0x065f, B:355:0x0682, B:357:0x0687, B:360:0x0695, B:362:0x069b, B:364:0x06ab, B:366:0x06b1, B:367:0x06b8, B:369:0x06bb, B:370:0x06c4, B:371:0x06d4, B:372:0x06d7, B:315:0x05c0, B:282:0x04d5, B:284:0x04d9, B:292:0x0534, B:294:0x0538, B:297:0x0555, B:301:0x0563, B:303:0x0597, B:304:0x059b, B:300:0x055c, B:296:0x053f, B:286:0x04df, B:289:0x04f0, B:291:0x0523, B:266:0x0487, B:268:0x0491, B:270:0x0499, B:273:0x04a8, B:275:0x04ac, B:277:0x04b9, B:464:0x084b, B:468:0x0853, B:470:0x0859, B:471:0x0860, B:473:0x0865, B:474:0x086e, B:476:0x0872, B:478:0x0878, B:482:0x0884, B:484:0x0893, B:485:0x089f), top: B:512:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0296 A[Catch: IOException -> 0x08af, zzhd -> 0x08b4, RuntimeException -> 0x08b9, TryCatch #9 {RuntimeException -> 0x08b9, blocks: (B:3:0x0005, B:7:0x0019, B:9:0x0021, B:12:0x0028, B:16:0x002f, B:20:0x003a, B:23:0x004c, B:25:0x0052, B:29:0x005b, B:33:0x0063, B:34:0x0065, B:36:0x0069, B:37:0x0070, B:39:0x007a, B:41:0x007e, B:43:0x0082, B:44:0x0095, B:47:0x009b, B:10:0x0024, B:49:0x009f, B:56:0x00bd, B:63:0x00cb, B:66:0x00ce, B:69:0x00d8, B:73:0x00dc, B:74:0x00dd, B:76:0x00e1, B:78:0x00e6, B:81:0x00ec, B:83:0x00f2, B:86:0x00f7, B:88:0x00fc, B:92:0x0105, B:94:0x012f, B:95:0x0136, B:96:0x013d, B:98:0x0142, B:102:0x014f, B:104:0x0159, B:105:0x015b, B:107:0x015f, B:109:0x0165, B:112:0x016b, B:113:0x0172, B:114:0x0176, B:115:0x017d, B:117:0x0181, B:118:0x0186, B:119:0x0189, B:126:0x01c6, B:120:0x0198, B:122:0x01a0, B:123:0x01a6, B:125:0x01b0, B:128:0x01d2, B:130:0x01da, B:133:0x01e1, B:135:0x01e5, B:137:0x01ed, B:140:0x01f4, B:142:0x0207, B:143:0x0217, B:145:0x021b, B:147:0x022b, B:149:0x022f, B:151:0x023d, B:152:0x0242, B:160:0x028b, B:162:0x028f, B:165:0x0296, B:167:0x02a0, B:169:0x02aa, B:170:0x02af, B:171:0x02d7, B:173:0x02db, B:177:0x02e8, B:178:0x02eb, B:179:0x02f8, B:183:0x0306, B:185:0x030c, B:186:0x031f, B:188:0x0323, B:190:0x0333, B:192:0x0345, B:196:0x0353, B:198:0x0358, B:199:0x036c, B:200:0x0375, B:163:0x0292, B:153:0x025a, B:155:0x0262, B:157:0x026a, B:158:0x026f, B:202:0x0379, B:203:0x0384, B:210:0x038f, B:211:0x0390, B:213:0x0394, B:215:0x039c, B:217:0x03a9, B:216:0x03a3, B:219:0x03b5, B:221:0x03bd, B:222:0x03c6, B:224:0x03cc, B:225:0x03ec, B:229:0x03f5, B:235:0x0418, B:239:0x0426, B:247:0x043c, B:251:0x044a, B:254:0x0455, B:258:0x0464, B:259:0x046d, B:260:0x046e, B:262:0x0476, B:373:0x06da, B:375:0x06e0, B:376:0x06e8, B:378:0x0703, B:380:0x070e, B:384:0x0717, B:386:0x071d, B:392:0x0729, B:397:0x0733, B:399:0x073a, B:400:0x073d, B:402:0x0741, B:404:0x074f, B:405:0x0762, B:409:0x077b, B:411:0x0783, B:413:0x0789, B:446:0x0813, B:448:0x0817, B:450:0x081c, B:451:0x0824, B:453:0x0828, B:457:0x0831, B:462:0x0847, B:455:0x082d, B:458:0x0837, B:460:0x083c, B:461:0x0842, B:414:0x0793, B:416:0x0798, B:419:0x079f, B:421:0x07a7, B:425:0x07ba, B:435:0x07ec, B:437:0x07f4, B:428:0x07c2, B:429:0x07d0, B:422:0x07ac, B:433:0x07e6, B:438:0x07f8, B:440:0x07fd, B:445:0x0809, B:443:0x0803, B:263:0x047e, B:265:0x0482, B:278:0x04c5, B:280:0x04cd, B:305:0x05a7, B:307:0x05ab, B:310:0x05b4, B:312:0x05b8, B:314:0x05bc, B:316:0x05c3, B:318:0x05c7, B:320:0x05cd, B:322:0x05d9, B:323:0x0604, B:326:0x060b, B:328:0x0610, B:330:0x061c, B:332:0x0622, B:334:0x0628, B:335:0x062b, B:337:0x062f, B:339:0x0634, B:342:0x0646, B:345:0x064e, B:346:0x0651, B:348:0x0657, B:350:0x065f, B:355:0x0682, B:357:0x0687, B:360:0x0695, B:362:0x069b, B:364:0x06ab, B:366:0x06b1, B:367:0x06b8, B:369:0x06bb, B:370:0x06c4, B:371:0x06d4, B:372:0x06d7, B:315:0x05c0, B:282:0x04d5, B:284:0x04d9, B:292:0x0534, B:294:0x0538, B:297:0x0555, B:301:0x0563, B:303:0x0597, B:304:0x059b, B:300:0x055c, B:296:0x053f, B:286:0x04df, B:289:0x04f0, B:291:0x0523, B:266:0x0487, B:268:0x0491, B:270:0x0499, B:273:0x04a8, B:275:0x04ac, B:277:0x04b9, B:464:0x084b, B:468:0x0853, B:470:0x0859, B:471:0x0860, B:473:0x0865, B:474:0x086e, B:476:0x0872, B:478:0x0878, B:482:0x0884, B:484:0x0893, B:485:0x089f), top: B:512:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0375 A[Catch: IOException -> 0x08af, zzhd -> 0x08b4, RuntimeException -> 0x08b9, TryCatch #9 {RuntimeException -> 0x08b9, blocks: (B:3:0x0005, B:7:0x0019, B:9:0x0021, B:12:0x0028, B:16:0x002f, B:20:0x003a, B:23:0x004c, B:25:0x0052, B:29:0x005b, B:33:0x0063, B:34:0x0065, B:36:0x0069, B:37:0x0070, B:39:0x007a, B:41:0x007e, B:43:0x0082, B:44:0x0095, B:47:0x009b, B:10:0x0024, B:49:0x009f, B:56:0x00bd, B:63:0x00cb, B:66:0x00ce, B:69:0x00d8, B:73:0x00dc, B:74:0x00dd, B:76:0x00e1, B:78:0x00e6, B:81:0x00ec, B:83:0x00f2, B:86:0x00f7, B:88:0x00fc, B:92:0x0105, B:94:0x012f, B:95:0x0136, B:96:0x013d, B:98:0x0142, B:102:0x014f, B:104:0x0159, B:105:0x015b, B:107:0x015f, B:109:0x0165, B:112:0x016b, B:113:0x0172, B:114:0x0176, B:115:0x017d, B:117:0x0181, B:118:0x0186, B:119:0x0189, B:126:0x01c6, B:120:0x0198, B:122:0x01a0, B:123:0x01a6, B:125:0x01b0, B:128:0x01d2, B:130:0x01da, B:133:0x01e1, B:135:0x01e5, B:137:0x01ed, B:140:0x01f4, B:142:0x0207, B:143:0x0217, B:145:0x021b, B:147:0x022b, B:149:0x022f, B:151:0x023d, B:152:0x0242, B:160:0x028b, B:162:0x028f, B:165:0x0296, B:167:0x02a0, B:169:0x02aa, B:170:0x02af, B:171:0x02d7, B:173:0x02db, B:177:0x02e8, B:178:0x02eb, B:179:0x02f8, B:183:0x0306, B:185:0x030c, B:186:0x031f, B:188:0x0323, B:190:0x0333, B:192:0x0345, B:196:0x0353, B:198:0x0358, B:199:0x036c, B:200:0x0375, B:163:0x0292, B:153:0x025a, B:155:0x0262, B:157:0x026a, B:158:0x026f, B:202:0x0379, B:203:0x0384, B:210:0x038f, B:211:0x0390, B:213:0x0394, B:215:0x039c, B:217:0x03a9, B:216:0x03a3, B:219:0x03b5, B:221:0x03bd, B:222:0x03c6, B:224:0x03cc, B:225:0x03ec, B:229:0x03f5, B:235:0x0418, B:239:0x0426, B:247:0x043c, B:251:0x044a, B:254:0x0455, B:258:0x0464, B:259:0x046d, B:260:0x046e, B:262:0x0476, B:373:0x06da, B:375:0x06e0, B:376:0x06e8, B:378:0x0703, B:380:0x070e, B:384:0x0717, B:386:0x071d, B:392:0x0729, B:397:0x0733, B:399:0x073a, B:400:0x073d, B:402:0x0741, B:404:0x074f, B:405:0x0762, B:409:0x077b, B:411:0x0783, B:413:0x0789, B:446:0x0813, B:448:0x0817, B:450:0x081c, B:451:0x0824, B:453:0x0828, B:457:0x0831, B:462:0x0847, B:455:0x082d, B:458:0x0837, B:460:0x083c, B:461:0x0842, B:414:0x0793, B:416:0x0798, B:419:0x079f, B:421:0x07a7, B:425:0x07ba, B:435:0x07ec, B:437:0x07f4, B:428:0x07c2, B:429:0x07d0, B:422:0x07ac, B:433:0x07e6, B:438:0x07f8, B:440:0x07fd, B:445:0x0809, B:443:0x0803, B:263:0x047e, B:265:0x0482, B:278:0x04c5, B:280:0x04cd, B:305:0x05a7, B:307:0x05ab, B:310:0x05b4, B:312:0x05b8, B:314:0x05bc, B:316:0x05c3, B:318:0x05c7, B:320:0x05cd, B:322:0x05d9, B:323:0x0604, B:326:0x060b, B:328:0x0610, B:330:0x061c, B:332:0x0622, B:334:0x0628, B:335:0x062b, B:337:0x062f, B:339:0x0634, B:342:0x0646, B:345:0x064e, B:346:0x0651, B:348:0x0657, B:350:0x065f, B:355:0x0682, B:357:0x0687, B:360:0x0695, B:362:0x069b, B:364:0x06ab, B:366:0x06b1, B:367:0x06b8, B:369:0x06bb, B:370:0x06c4, B:371:0x06d4, B:372:0x06d7, B:315:0x05c0, B:282:0x04d5, B:284:0x04d9, B:292:0x0534, B:294:0x0538, B:297:0x0555, B:301:0x0563, B:303:0x0597, B:304:0x059b, B:300:0x055c, B:296:0x053f, B:286:0x04df, B:289:0x04f0, B:291:0x0523, B:266:0x0487, B:268:0x0491, B:270:0x0499, B:273:0x04a8, B:275:0x04ac, B:277:0x04b9, B:464:0x084b, B:468:0x0853, B:470:0x0859, B:471:0x0860, B:473:0x0865, B:474:0x086e, B:476:0x0872, B:478:0x0878, B:482:0x0884, B:484:0x0893, B:485:0x089f), top: B:512:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:294:0x0538 A[Catch: IOException -> 0x08af, zzhd -> 0x08b4, RuntimeException -> 0x08b9, TryCatch #9 {RuntimeException -> 0x08b9, blocks: (B:3:0x0005, B:7:0x0019, B:9:0x0021, B:12:0x0028, B:16:0x002f, B:20:0x003a, B:23:0x004c, B:25:0x0052, B:29:0x005b, B:33:0x0063, B:34:0x0065, B:36:0x0069, B:37:0x0070, B:39:0x007a, B:41:0x007e, B:43:0x0082, B:44:0x0095, B:47:0x009b, B:10:0x0024, B:49:0x009f, B:56:0x00bd, B:63:0x00cb, B:66:0x00ce, B:69:0x00d8, B:73:0x00dc, B:74:0x00dd, B:76:0x00e1, B:78:0x00e6, B:81:0x00ec, B:83:0x00f2, B:86:0x00f7, B:88:0x00fc, B:92:0x0105, B:94:0x012f, B:95:0x0136, B:96:0x013d, B:98:0x0142, B:102:0x014f, B:104:0x0159, B:105:0x015b, B:107:0x015f, B:109:0x0165, B:112:0x016b, B:113:0x0172, B:114:0x0176, B:115:0x017d, B:117:0x0181, B:118:0x0186, B:119:0x0189, B:126:0x01c6, B:120:0x0198, B:122:0x01a0, B:123:0x01a6, B:125:0x01b0, B:128:0x01d2, B:130:0x01da, B:133:0x01e1, B:135:0x01e5, B:137:0x01ed, B:140:0x01f4, B:142:0x0207, B:143:0x0217, B:145:0x021b, B:147:0x022b, B:149:0x022f, B:151:0x023d, B:152:0x0242, B:160:0x028b, B:162:0x028f, B:165:0x0296, B:167:0x02a0, B:169:0x02aa, B:170:0x02af, B:171:0x02d7, B:173:0x02db, B:177:0x02e8, B:178:0x02eb, B:179:0x02f8, B:183:0x0306, B:185:0x030c, B:186:0x031f, B:188:0x0323, B:190:0x0333, B:192:0x0345, B:196:0x0353, B:198:0x0358, B:199:0x036c, B:200:0x0375, B:163:0x0292, B:153:0x025a, B:155:0x0262, B:157:0x026a, B:158:0x026f, B:202:0x0379, B:203:0x0384, B:210:0x038f, B:211:0x0390, B:213:0x0394, B:215:0x039c, B:217:0x03a9, B:216:0x03a3, B:219:0x03b5, B:221:0x03bd, B:222:0x03c6, B:224:0x03cc, B:225:0x03ec, B:229:0x03f5, B:235:0x0418, B:239:0x0426, B:247:0x043c, B:251:0x044a, B:254:0x0455, B:258:0x0464, B:259:0x046d, B:260:0x046e, B:262:0x0476, B:373:0x06da, B:375:0x06e0, B:376:0x06e8, B:378:0x0703, B:380:0x070e, B:384:0x0717, B:386:0x071d, B:392:0x0729, B:397:0x0733, B:399:0x073a, B:400:0x073d, B:402:0x0741, B:404:0x074f, B:405:0x0762, B:409:0x077b, B:411:0x0783, B:413:0x0789, B:446:0x0813, B:448:0x0817, B:450:0x081c, B:451:0x0824, B:453:0x0828, B:457:0x0831, B:462:0x0847, B:455:0x082d, B:458:0x0837, B:460:0x083c, B:461:0x0842, B:414:0x0793, B:416:0x0798, B:419:0x079f, B:421:0x07a7, B:425:0x07ba, B:435:0x07ec, B:437:0x07f4, B:428:0x07c2, B:429:0x07d0, B:422:0x07ac, B:433:0x07e6, B:438:0x07f8, B:440:0x07fd, B:445:0x0809, B:443:0x0803, B:263:0x047e, B:265:0x0482, B:278:0x04c5, B:280:0x04cd, B:305:0x05a7, B:307:0x05ab, B:310:0x05b4, B:312:0x05b8, B:314:0x05bc, B:316:0x05c3, B:318:0x05c7, B:320:0x05cd, B:322:0x05d9, B:323:0x0604, B:326:0x060b, B:328:0x0610, B:330:0x061c, B:332:0x0622, B:334:0x0628, B:335:0x062b, B:337:0x062f, B:339:0x0634, B:342:0x0646, B:345:0x064e, B:346:0x0651, B:348:0x0657, B:350:0x065f, B:355:0x0682, B:357:0x0687, B:360:0x0695, B:362:0x069b, B:364:0x06ab, B:366:0x06b1, B:367:0x06b8, B:369:0x06bb, B:370:0x06c4, B:371:0x06d4, B:372:0x06d7, B:315:0x05c0, B:282:0x04d5, B:284:0x04d9, B:292:0x0534, B:294:0x0538, B:297:0x0555, B:301:0x0563, B:303:0x0597, B:304:0x059b, B:300:0x055c, B:296:0x053f, B:286:0x04df, B:289:0x04f0, B:291:0x0523, B:266:0x0487, B:268:0x0491, B:270:0x0499, B:273:0x04a8, B:275:0x04ac, B:277:0x04b9, B:464:0x084b, B:468:0x0853, B:470:0x0859, B:471:0x0860, B:473:0x0865, B:474:0x086e, B:476:0x0872, B:478:0x0878, B:482:0x0884, B:484:0x0893, B:485:0x089f), top: B:512:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:296:0x053f A[Catch: IOException -> 0x08af, zzhd -> 0x08b4, RuntimeException -> 0x08b9, TryCatch #9 {RuntimeException -> 0x08b9, blocks: (B:3:0x0005, B:7:0x0019, B:9:0x0021, B:12:0x0028, B:16:0x002f, B:20:0x003a, B:23:0x004c, B:25:0x0052, B:29:0x005b, B:33:0x0063, B:34:0x0065, B:36:0x0069, B:37:0x0070, B:39:0x007a, B:41:0x007e, B:43:0x0082, B:44:0x0095, B:47:0x009b, B:10:0x0024, B:49:0x009f, B:56:0x00bd, B:63:0x00cb, B:66:0x00ce, B:69:0x00d8, B:73:0x00dc, B:74:0x00dd, B:76:0x00e1, B:78:0x00e6, B:81:0x00ec, B:83:0x00f2, B:86:0x00f7, B:88:0x00fc, B:92:0x0105, B:94:0x012f, B:95:0x0136, B:96:0x013d, B:98:0x0142, B:102:0x014f, B:104:0x0159, B:105:0x015b, B:107:0x015f, B:109:0x0165, B:112:0x016b, B:113:0x0172, B:114:0x0176, B:115:0x017d, B:117:0x0181, B:118:0x0186, B:119:0x0189, B:126:0x01c6, B:120:0x0198, B:122:0x01a0, B:123:0x01a6, B:125:0x01b0, B:128:0x01d2, B:130:0x01da, B:133:0x01e1, B:135:0x01e5, B:137:0x01ed, B:140:0x01f4, B:142:0x0207, B:143:0x0217, B:145:0x021b, B:147:0x022b, B:149:0x022f, B:151:0x023d, B:152:0x0242, B:160:0x028b, B:162:0x028f, B:165:0x0296, B:167:0x02a0, B:169:0x02aa, B:170:0x02af, B:171:0x02d7, B:173:0x02db, B:177:0x02e8, B:178:0x02eb, B:179:0x02f8, B:183:0x0306, B:185:0x030c, B:186:0x031f, B:188:0x0323, B:190:0x0333, B:192:0x0345, B:196:0x0353, B:198:0x0358, B:199:0x036c, B:200:0x0375, B:163:0x0292, B:153:0x025a, B:155:0x0262, B:157:0x026a, B:158:0x026f, B:202:0x0379, B:203:0x0384, B:210:0x038f, B:211:0x0390, B:213:0x0394, B:215:0x039c, B:217:0x03a9, B:216:0x03a3, B:219:0x03b5, B:221:0x03bd, B:222:0x03c6, B:224:0x03cc, B:225:0x03ec, B:229:0x03f5, B:235:0x0418, B:239:0x0426, B:247:0x043c, B:251:0x044a, B:254:0x0455, B:258:0x0464, B:259:0x046d, B:260:0x046e, B:262:0x0476, B:373:0x06da, B:375:0x06e0, B:376:0x06e8, B:378:0x0703, B:380:0x070e, B:384:0x0717, B:386:0x071d, B:392:0x0729, B:397:0x0733, B:399:0x073a, B:400:0x073d, B:402:0x0741, B:404:0x074f, B:405:0x0762, B:409:0x077b, B:411:0x0783, B:413:0x0789, B:446:0x0813, B:448:0x0817, B:450:0x081c, B:451:0x0824, B:453:0x0828, B:457:0x0831, B:462:0x0847, B:455:0x082d, B:458:0x0837, B:460:0x083c, B:461:0x0842, B:414:0x0793, B:416:0x0798, B:419:0x079f, B:421:0x07a7, B:425:0x07ba, B:435:0x07ec, B:437:0x07f4, B:428:0x07c2, B:429:0x07d0, B:422:0x07ac, B:433:0x07e6, B:438:0x07f8, B:440:0x07fd, B:445:0x0809, B:443:0x0803, B:263:0x047e, B:265:0x0482, B:278:0x04c5, B:280:0x04cd, B:305:0x05a7, B:307:0x05ab, B:310:0x05b4, B:312:0x05b8, B:314:0x05bc, B:316:0x05c3, B:318:0x05c7, B:320:0x05cd, B:322:0x05d9, B:323:0x0604, B:326:0x060b, B:328:0x0610, B:330:0x061c, B:332:0x0622, B:334:0x0628, B:335:0x062b, B:337:0x062f, B:339:0x0634, B:342:0x0646, B:345:0x064e, B:346:0x0651, B:348:0x0657, B:350:0x065f, B:355:0x0682, B:357:0x0687, B:360:0x0695, B:362:0x069b, B:364:0x06ab, B:366:0x06b1, B:367:0x06b8, B:369:0x06bb, B:370:0x06c4, B:371:0x06d4, B:372:0x06d7, B:315:0x05c0, B:282:0x04d5, B:284:0x04d9, B:292:0x0534, B:294:0x0538, B:297:0x0555, B:301:0x0563, B:303:0x0597, B:304:0x059b, B:300:0x055c, B:296:0x053f, B:286:0x04df, B:289:0x04f0, B:291:0x0523, B:266:0x0487, B:268:0x0491, B:270:0x0499, B:273:0x04a8, B:275:0x04ac, B:277:0x04b9, B:464:0x084b, B:468:0x0853, B:470:0x0859, B:471:0x0860, B:473:0x0865, B:474:0x086e, B:476:0x0872, B:478:0x0878, B:482:0x0884, B:484:0x0893, B:485:0x089f), top: B:512:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:299:0x0559  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x055c A[Catch: IOException -> 0x08af, zzhd -> 0x08b4, RuntimeException -> 0x08b9, TryCatch #9 {RuntimeException -> 0x08b9, blocks: (B:3:0x0005, B:7:0x0019, B:9:0x0021, B:12:0x0028, B:16:0x002f, B:20:0x003a, B:23:0x004c, B:25:0x0052, B:29:0x005b, B:33:0x0063, B:34:0x0065, B:36:0x0069, B:37:0x0070, B:39:0x007a, B:41:0x007e, B:43:0x0082, B:44:0x0095, B:47:0x009b, B:10:0x0024, B:49:0x009f, B:56:0x00bd, B:63:0x00cb, B:66:0x00ce, B:69:0x00d8, B:73:0x00dc, B:74:0x00dd, B:76:0x00e1, B:78:0x00e6, B:81:0x00ec, B:83:0x00f2, B:86:0x00f7, B:88:0x00fc, B:92:0x0105, B:94:0x012f, B:95:0x0136, B:96:0x013d, B:98:0x0142, B:102:0x014f, B:104:0x0159, B:105:0x015b, B:107:0x015f, B:109:0x0165, B:112:0x016b, B:113:0x0172, B:114:0x0176, B:115:0x017d, B:117:0x0181, B:118:0x0186, B:119:0x0189, B:126:0x01c6, B:120:0x0198, B:122:0x01a0, B:123:0x01a6, B:125:0x01b0, B:128:0x01d2, B:130:0x01da, B:133:0x01e1, B:135:0x01e5, B:137:0x01ed, B:140:0x01f4, B:142:0x0207, B:143:0x0217, B:145:0x021b, B:147:0x022b, B:149:0x022f, B:151:0x023d, B:152:0x0242, B:160:0x028b, B:162:0x028f, B:165:0x0296, B:167:0x02a0, B:169:0x02aa, B:170:0x02af, B:171:0x02d7, B:173:0x02db, B:177:0x02e8, B:178:0x02eb, B:179:0x02f8, B:183:0x0306, B:185:0x030c, B:186:0x031f, B:188:0x0323, B:190:0x0333, B:192:0x0345, B:196:0x0353, B:198:0x0358, B:199:0x036c, B:200:0x0375, B:163:0x0292, B:153:0x025a, B:155:0x0262, B:157:0x026a, B:158:0x026f, B:202:0x0379, B:203:0x0384, B:210:0x038f, B:211:0x0390, B:213:0x0394, B:215:0x039c, B:217:0x03a9, B:216:0x03a3, B:219:0x03b5, B:221:0x03bd, B:222:0x03c6, B:224:0x03cc, B:225:0x03ec, B:229:0x03f5, B:235:0x0418, B:239:0x0426, B:247:0x043c, B:251:0x044a, B:254:0x0455, B:258:0x0464, B:259:0x046d, B:260:0x046e, B:262:0x0476, B:373:0x06da, B:375:0x06e0, B:376:0x06e8, B:378:0x0703, B:380:0x070e, B:384:0x0717, B:386:0x071d, B:392:0x0729, B:397:0x0733, B:399:0x073a, B:400:0x073d, B:402:0x0741, B:404:0x074f, B:405:0x0762, B:409:0x077b, B:411:0x0783, B:413:0x0789, B:446:0x0813, B:448:0x0817, B:450:0x081c, B:451:0x0824, B:453:0x0828, B:457:0x0831, B:462:0x0847, B:455:0x082d, B:458:0x0837, B:460:0x083c, B:461:0x0842, B:414:0x0793, B:416:0x0798, B:419:0x079f, B:421:0x07a7, B:425:0x07ba, B:435:0x07ec, B:437:0x07f4, B:428:0x07c2, B:429:0x07d0, B:422:0x07ac, B:433:0x07e6, B:438:0x07f8, B:440:0x07fd, B:445:0x0809, B:443:0x0803, B:263:0x047e, B:265:0x0482, B:278:0x04c5, B:280:0x04cd, B:305:0x05a7, B:307:0x05ab, B:310:0x05b4, B:312:0x05b8, B:314:0x05bc, B:316:0x05c3, B:318:0x05c7, B:320:0x05cd, B:322:0x05d9, B:323:0x0604, B:326:0x060b, B:328:0x0610, B:330:0x061c, B:332:0x0622, B:334:0x0628, B:335:0x062b, B:337:0x062f, B:339:0x0634, B:342:0x0646, B:345:0x064e, B:346:0x0651, B:348:0x0657, B:350:0x065f, B:355:0x0682, B:357:0x0687, B:360:0x0695, B:362:0x069b, B:364:0x06ab, B:366:0x06b1, B:367:0x06b8, B:369:0x06bb, B:370:0x06c4, B:371:0x06d4, B:372:0x06d7, B:315:0x05c0, B:282:0x04d5, B:284:0x04d9, B:292:0x0534, B:294:0x0538, B:297:0x0555, B:301:0x0563, B:303:0x0597, B:304:0x059b, B:300:0x055c, B:296:0x053f, B:286:0x04df, B:289:0x04f0, B:291:0x0523, B:266:0x0487, B:268:0x0491, B:270:0x0499, B:273:0x04a8, B:275:0x04ac, B:277:0x04b9, B:464:0x084b, B:468:0x0853, B:470:0x0859, B:471:0x0860, B:473:0x0865, B:474:0x086e, B:476:0x0872, B:478:0x0878, B:482:0x0884, B:484:0x0893, B:485:0x089f), top: B:512:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:303:0x0597 A[Catch: IOException -> 0x08af, zzhd -> 0x08b4, RuntimeException -> 0x08b9, TryCatch #9 {RuntimeException -> 0x08b9, blocks: (B:3:0x0005, B:7:0x0019, B:9:0x0021, B:12:0x0028, B:16:0x002f, B:20:0x003a, B:23:0x004c, B:25:0x0052, B:29:0x005b, B:33:0x0063, B:34:0x0065, B:36:0x0069, B:37:0x0070, B:39:0x007a, B:41:0x007e, B:43:0x0082, B:44:0x0095, B:47:0x009b, B:10:0x0024, B:49:0x009f, B:56:0x00bd, B:63:0x00cb, B:66:0x00ce, B:69:0x00d8, B:73:0x00dc, B:74:0x00dd, B:76:0x00e1, B:78:0x00e6, B:81:0x00ec, B:83:0x00f2, B:86:0x00f7, B:88:0x00fc, B:92:0x0105, B:94:0x012f, B:95:0x0136, B:96:0x013d, B:98:0x0142, B:102:0x014f, B:104:0x0159, B:105:0x015b, B:107:0x015f, B:109:0x0165, B:112:0x016b, B:113:0x0172, B:114:0x0176, B:115:0x017d, B:117:0x0181, B:118:0x0186, B:119:0x0189, B:126:0x01c6, B:120:0x0198, B:122:0x01a0, B:123:0x01a6, B:125:0x01b0, B:128:0x01d2, B:130:0x01da, B:133:0x01e1, B:135:0x01e5, B:137:0x01ed, B:140:0x01f4, B:142:0x0207, B:143:0x0217, B:145:0x021b, B:147:0x022b, B:149:0x022f, B:151:0x023d, B:152:0x0242, B:160:0x028b, B:162:0x028f, B:165:0x0296, B:167:0x02a0, B:169:0x02aa, B:170:0x02af, B:171:0x02d7, B:173:0x02db, B:177:0x02e8, B:178:0x02eb, B:179:0x02f8, B:183:0x0306, B:185:0x030c, B:186:0x031f, B:188:0x0323, B:190:0x0333, B:192:0x0345, B:196:0x0353, B:198:0x0358, B:199:0x036c, B:200:0x0375, B:163:0x0292, B:153:0x025a, B:155:0x0262, B:157:0x026a, B:158:0x026f, B:202:0x0379, B:203:0x0384, B:210:0x038f, B:211:0x0390, B:213:0x0394, B:215:0x039c, B:217:0x03a9, B:216:0x03a3, B:219:0x03b5, B:221:0x03bd, B:222:0x03c6, B:224:0x03cc, B:225:0x03ec, B:229:0x03f5, B:235:0x0418, B:239:0x0426, B:247:0x043c, B:251:0x044a, B:254:0x0455, B:258:0x0464, B:259:0x046d, B:260:0x046e, B:262:0x0476, B:373:0x06da, B:375:0x06e0, B:376:0x06e8, B:378:0x0703, B:380:0x070e, B:384:0x0717, B:386:0x071d, B:392:0x0729, B:397:0x0733, B:399:0x073a, B:400:0x073d, B:402:0x0741, B:404:0x074f, B:405:0x0762, B:409:0x077b, B:411:0x0783, B:413:0x0789, B:446:0x0813, B:448:0x0817, B:450:0x081c, B:451:0x0824, B:453:0x0828, B:457:0x0831, B:462:0x0847, B:455:0x082d, B:458:0x0837, B:460:0x083c, B:461:0x0842, B:414:0x0793, B:416:0x0798, B:419:0x079f, B:421:0x07a7, B:425:0x07ba, B:435:0x07ec, B:437:0x07f4, B:428:0x07c2, B:429:0x07d0, B:422:0x07ac, B:433:0x07e6, B:438:0x07f8, B:440:0x07fd, B:445:0x0809, B:443:0x0803, B:263:0x047e, B:265:0x0482, B:278:0x04c5, B:280:0x04cd, B:305:0x05a7, B:307:0x05ab, B:310:0x05b4, B:312:0x05b8, B:314:0x05bc, B:316:0x05c3, B:318:0x05c7, B:320:0x05cd, B:322:0x05d9, B:323:0x0604, B:326:0x060b, B:328:0x0610, B:330:0x061c, B:332:0x0622, B:334:0x0628, B:335:0x062b, B:337:0x062f, B:339:0x0634, B:342:0x0646, B:345:0x064e, B:346:0x0651, B:348:0x0657, B:350:0x065f, B:355:0x0682, B:357:0x0687, B:360:0x0695, B:362:0x069b, B:364:0x06ab, B:366:0x06b1, B:367:0x06b8, B:369:0x06bb, B:370:0x06c4, B:371:0x06d4, B:372:0x06d7, B:315:0x05c0, B:282:0x04d5, B:284:0x04d9, B:292:0x0534, B:294:0x0538, B:297:0x0555, B:301:0x0563, B:303:0x0597, B:304:0x059b, B:300:0x055c, B:296:0x053f, B:286:0x04df, B:289:0x04f0, B:291:0x0523, B:266:0x0487, B:268:0x0491, B:270:0x0499, B:273:0x04a8, B:275:0x04ac, B:277:0x04b9, B:464:0x084b, B:468:0x0853, B:470:0x0859, B:471:0x0860, B:473:0x0865, B:474:0x086e, B:476:0x0872, B:478:0x0878, B:482:0x0884, B:484:0x0893, B:485:0x089f), top: B:512:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:307:0x05ab A[Catch: IOException -> 0x08af, zzhd -> 0x08b4, RuntimeException -> 0x08b9, TryCatch #9 {RuntimeException -> 0x08b9, blocks: (B:3:0x0005, B:7:0x0019, B:9:0x0021, B:12:0x0028, B:16:0x002f, B:20:0x003a, B:23:0x004c, B:25:0x0052, B:29:0x005b, B:33:0x0063, B:34:0x0065, B:36:0x0069, B:37:0x0070, B:39:0x007a, B:41:0x007e, B:43:0x0082, B:44:0x0095, B:47:0x009b, B:10:0x0024, B:49:0x009f, B:56:0x00bd, B:63:0x00cb, B:66:0x00ce, B:69:0x00d8, B:73:0x00dc, B:74:0x00dd, B:76:0x00e1, B:78:0x00e6, B:81:0x00ec, B:83:0x00f2, B:86:0x00f7, B:88:0x00fc, B:92:0x0105, B:94:0x012f, B:95:0x0136, B:96:0x013d, B:98:0x0142, B:102:0x014f, B:104:0x0159, B:105:0x015b, B:107:0x015f, B:109:0x0165, B:112:0x016b, B:113:0x0172, B:114:0x0176, B:115:0x017d, B:117:0x0181, B:118:0x0186, B:119:0x0189, B:126:0x01c6, B:120:0x0198, B:122:0x01a0, B:123:0x01a6, B:125:0x01b0, B:128:0x01d2, B:130:0x01da, B:133:0x01e1, B:135:0x01e5, B:137:0x01ed, B:140:0x01f4, B:142:0x0207, B:143:0x0217, B:145:0x021b, B:147:0x022b, B:149:0x022f, B:151:0x023d, B:152:0x0242, B:160:0x028b, B:162:0x028f, B:165:0x0296, B:167:0x02a0, B:169:0x02aa, B:170:0x02af, B:171:0x02d7, B:173:0x02db, B:177:0x02e8, B:178:0x02eb, B:179:0x02f8, B:183:0x0306, B:185:0x030c, B:186:0x031f, B:188:0x0323, B:190:0x0333, B:192:0x0345, B:196:0x0353, B:198:0x0358, B:199:0x036c, B:200:0x0375, B:163:0x0292, B:153:0x025a, B:155:0x0262, B:157:0x026a, B:158:0x026f, B:202:0x0379, B:203:0x0384, B:210:0x038f, B:211:0x0390, B:213:0x0394, B:215:0x039c, B:217:0x03a9, B:216:0x03a3, B:219:0x03b5, B:221:0x03bd, B:222:0x03c6, B:224:0x03cc, B:225:0x03ec, B:229:0x03f5, B:235:0x0418, B:239:0x0426, B:247:0x043c, B:251:0x044a, B:254:0x0455, B:258:0x0464, B:259:0x046d, B:260:0x046e, B:262:0x0476, B:373:0x06da, B:375:0x06e0, B:376:0x06e8, B:378:0x0703, B:380:0x070e, B:384:0x0717, B:386:0x071d, B:392:0x0729, B:397:0x0733, B:399:0x073a, B:400:0x073d, B:402:0x0741, B:404:0x074f, B:405:0x0762, B:409:0x077b, B:411:0x0783, B:413:0x0789, B:446:0x0813, B:448:0x0817, B:450:0x081c, B:451:0x0824, B:453:0x0828, B:457:0x0831, B:462:0x0847, B:455:0x082d, B:458:0x0837, B:460:0x083c, B:461:0x0842, B:414:0x0793, B:416:0x0798, B:419:0x079f, B:421:0x07a7, B:425:0x07ba, B:435:0x07ec, B:437:0x07f4, B:428:0x07c2, B:429:0x07d0, B:422:0x07ac, B:433:0x07e6, B:438:0x07f8, B:440:0x07fd, B:445:0x0809, B:443:0x0803, B:263:0x047e, B:265:0x0482, B:278:0x04c5, B:280:0x04cd, B:305:0x05a7, B:307:0x05ab, B:310:0x05b4, B:312:0x05b8, B:314:0x05bc, B:316:0x05c3, B:318:0x05c7, B:320:0x05cd, B:322:0x05d9, B:323:0x0604, B:326:0x060b, B:328:0x0610, B:330:0x061c, B:332:0x0622, B:334:0x0628, B:335:0x062b, B:337:0x062f, B:339:0x0634, B:342:0x0646, B:345:0x064e, B:346:0x0651, B:348:0x0657, B:350:0x065f, B:355:0x0682, B:357:0x0687, B:360:0x0695, B:362:0x069b, B:364:0x06ab, B:366:0x06b1, B:367:0x06b8, B:369:0x06bb, B:370:0x06c4, B:371:0x06d4, B:372:0x06d7, B:315:0x05c0, B:282:0x04d5, B:284:0x04d9, B:292:0x0534, B:294:0x0538, B:297:0x0555, B:301:0x0563, B:303:0x0597, B:304:0x059b, B:300:0x055c, B:296:0x053f, B:286:0x04df, B:289:0x04f0, B:291:0x0523, B:266:0x0487, B:268:0x0491, B:270:0x0499, B:273:0x04a8, B:275:0x04ac, B:277:0x04b9, B:464:0x084b, B:468:0x0853, B:470:0x0859, B:471:0x0860, B:473:0x0865, B:474:0x086e, B:476:0x0872, B:478:0x0878, B:482:0x0884, B:484:0x0893, B:485:0x089f), top: B:512:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:315:0x05c0 A[Catch: IOException -> 0x08af, zzhd -> 0x08b4, RuntimeException -> 0x08b9, TryCatch #9 {RuntimeException -> 0x08b9, blocks: (B:3:0x0005, B:7:0x0019, B:9:0x0021, B:12:0x0028, B:16:0x002f, B:20:0x003a, B:23:0x004c, B:25:0x0052, B:29:0x005b, B:33:0x0063, B:34:0x0065, B:36:0x0069, B:37:0x0070, B:39:0x007a, B:41:0x007e, B:43:0x0082, B:44:0x0095, B:47:0x009b, B:10:0x0024, B:49:0x009f, B:56:0x00bd, B:63:0x00cb, B:66:0x00ce, B:69:0x00d8, B:73:0x00dc, B:74:0x00dd, B:76:0x00e1, B:78:0x00e6, B:81:0x00ec, B:83:0x00f2, B:86:0x00f7, B:88:0x00fc, B:92:0x0105, B:94:0x012f, B:95:0x0136, B:96:0x013d, B:98:0x0142, B:102:0x014f, B:104:0x0159, B:105:0x015b, B:107:0x015f, B:109:0x0165, B:112:0x016b, B:113:0x0172, B:114:0x0176, B:115:0x017d, B:117:0x0181, B:118:0x0186, B:119:0x0189, B:126:0x01c6, B:120:0x0198, B:122:0x01a0, B:123:0x01a6, B:125:0x01b0, B:128:0x01d2, B:130:0x01da, B:133:0x01e1, B:135:0x01e5, B:137:0x01ed, B:140:0x01f4, B:142:0x0207, B:143:0x0217, B:145:0x021b, B:147:0x022b, B:149:0x022f, B:151:0x023d, B:152:0x0242, B:160:0x028b, B:162:0x028f, B:165:0x0296, B:167:0x02a0, B:169:0x02aa, B:170:0x02af, B:171:0x02d7, B:173:0x02db, B:177:0x02e8, B:178:0x02eb, B:179:0x02f8, B:183:0x0306, B:185:0x030c, B:186:0x031f, B:188:0x0323, B:190:0x0333, B:192:0x0345, B:196:0x0353, B:198:0x0358, B:199:0x036c, B:200:0x0375, B:163:0x0292, B:153:0x025a, B:155:0x0262, B:157:0x026a, B:158:0x026f, B:202:0x0379, B:203:0x0384, B:210:0x038f, B:211:0x0390, B:213:0x0394, B:215:0x039c, B:217:0x03a9, B:216:0x03a3, B:219:0x03b5, B:221:0x03bd, B:222:0x03c6, B:224:0x03cc, B:225:0x03ec, B:229:0x03f5, B:235:0x0418, B:239:0x0426, B:247:0x043c, B:251:0x044a, B:254:0x0455, B:258:0x0464, B:259:0x046d, B:260:0x046e, B:262:0x0476, B:373:0x06da, B:375:0x06e0, B:376:0x06e8, B:378:0x0703, B:380:0x070e, B:384:0x0717, B:386:0x071d, B:392:0x0729, B:397:0x0733, B:399:0x073a, B:400:0x073d, B:402:0x0741, B:404:0x074f, B:405:0x0762, B:409:0x077b, B:411:0x0783, B:413:0x0789, B:446:0x0813, B:448:0x0817, B:450:0x081c, B:451:0x0824, B:453:0x0828, B:457:0x0831, B:462:0x0847, B:455:0x082d, B:458:0x0837, B:460:0x083c, B:461:0x0842, B:414:0x0793, B:416:0x0798, B:419:0x079f, B:421:0x07a7, B:425:0x07ba, B:435:0x07ec, B:437:0x07f4, B:428:0x07c2, B:429:0x07d0, B:422:0x07ac, B:433:0x07e6, B:438:0x07f8, B:440:0x07fd, B:445:0x0809, B:443:0x0803, B:263:0x047e, B:265:0x0482, B:278:0x04c5, B:280:0x04cd, B:305:0x05a7, B:307:0x05ab, B:310:0x05b4, B:312:0x05b8, B:314:0x05bc, B:316:0x05c3, B:318:0x05c7, B:320:0x05cd, B:322:0x05d9, B:323:0x0604, B:326:0x060b, B:328:0x0610, B:330:0x061c, B:332:0x0622, B:334:0x0628, B:335:0x062b, B:337:0x062f, B:339:0x0634, B:342:0x0646, B:345:0x064e, B:346:0x0651, B:348:0x0657, B:350:0x065f, B:355:0x0682, B:357:0x0687, B:360:0x0695, B:362:0x069b, B:364:0x06ab, B:366:0x06b1, B:367:0x06b8, B:369:0x06bb, B:370:0x06c4, B:371:0x06d4, B:372:0x06d7, B:315:0x05c0, B:282:0x04d5, B:284:0x04d9, B:292:0x0534, B:294:0x0538, B:297:0x0555, B:301:0x0563, B:303:0x0597, B:304:0x059b, B:300:0x055c, B:296:0x053f, B:286:0x04df, B:289:0x04f0, B:291:0x0523, B:266:0x0487, B:268:0x0491, B:270:0x0499, B:273:0x04a8, B:275:0x04ac, B:277:0x04b9, B:464:0x084b, B:468:0x0853, B:470:0x0859, B:471:0x0860, B:473:0x0865, B:474:0x086e, B:476:0x0872, B:478:0x0878, B:482:0x0884, B:484:0x0893, B:485:0x089f), top: B:512:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:318:0x05c7 A[Catch: IOException -> 0x08af, zzhd -> 0x08b4, RuntimeException -> 0x08b9, LOOP:9: B:318:0x05c7->B:322:0x05d9, LOOP_START, TryCatch #9 {RuntimeException -> 0x08b9, blocks: (B:3:0x0005, B:7:0x0019, B:9:0x0021, B:12:0x0028, B:16:0x002f, B:20:0x003a, B:23:0x004c, B:25:0x0052, B:29:0x005b, B:33:0x0063, B:34:0x0065, B:36:0x0069, B:37:0x0070, B:39:0x007a, B:41:0x007e, B:43:0x0082, B:44:0x0095, B:47:0x009b, B:10:0x0024, B:49:0x009f, B:56:0x00bd, B:63:0x00cb, B:66:0x00ce, B:69:0x00d8, B:73:0x00dc, B:74:0x00dd, B:76:0x00e1, B:78:0x00e6, B:81:0x00ec, B:83:0x00f2, B:86:0x00f7, B:88:0x00fc, B:92:0x0105, B:94:0x012f, B:95:0x0136, B:96:0x013d, B:98:0x0142, B:102:0x014f, B:104:0x0159, B:105:0x015b, B:107:0x015f, B:109:0x0165, B:112:0x016b, B:113:0x0172, B:114:0x0176, B:115:0x017d, B:117:0x0181, B:118:0x0186, B:119:0x0189, B:126:0x01c6, B:120:0x0198, B:122:0x01a0, B:123:0x01a6, B:125:0x01b0, B:128:0x01d2, B:130:0x01da, B:133:0x01e1, B:135:0x01e5, B:137:0x01ed, B:140:0x01f4, B:142:0x0207, B:143:0x0217, B:145:0x021b, B:147:0x022b, B:149:0x022f, B:151:0x023d, B:152:0x0242, B:160:0x028b, B:162:0x028f, B:165:0x0296, B:167:0x02a0, B:169:0x02aa, B:170:0x02af, B:171:0x02d7, B:173:0x02db, B:177:0x02e8, B:178:0x02eb, B:179:0x02f8, B:183:0x0306, B:185:0x030c, B:186:0x031f, B:188:0x0323, B:190:0x0333, B:192:0x0345, B:196:0x0353, B:198:0x0358, B:199:0x036c, B:200:0x0375, B:163:0x0292, B:153:0x025a, B:155:0x0262, B:157:0x026a, B:158:0x026f, B:202:0x0379, B:203:0x0384, B:210:0x038f, B:211:0x0390, B:213:0x0394, B:215:0x039c, B:217:0x03a9, B:216:0x03a3, B:219:0x03b5, B:221:0x03bd, B:222:0x03c6, B:224:0x03cc, B:225:0x03ec, B:229:0x03f5, B:235:0x0418, B:239:0x0426, B:247:0x043c, B:251:0x044a, B:254:0x0455, B:258:0x0464, B:259:0x046d, B:260:0x046e, B:262:0x0476, B:373:0x06da, B:375:0x06e0, B:376:0x06e8, B:378:0x0703, B:380:0x070e, B:384:0x0717, B:386:0x071d, B:392:0x0729, B:397:0x0733, B:399:0x073a, B:400:0x073d, B:402:0x0741, B:404:0x074f, B:405:0x0762, B:409:0x077b, B:411:0x0783, B:413:0x0789, B:446:0x0813, B:448:0x0817, B:450:0x081c, B:451:0x0824, B:453:0x0828, B:457:0x0831, B:462:0x0847, B:455:0x082d, B:458:0x0837, B:460:0x083c, B:461:0x0842, B:414:0x0793, B:416:0x0798, B:419:0x079f, B:421:0x07a7, B:425:0x07ba, B:435:0x07ec, B:437:0x07f4, B:428:0x07c2, B:429:0x07d0, B:422:0x07ac, B:433:0x07e6, B:438:0x07f8, B:440:0x07fd, B:445:0x0809, B:443:0x0803, B:263:0x047e, B:265:0x0482, B:278:0x04c5, B:280:0x04cd, B:305:0x05a7, B:307:0x05ab, B:310:0x05b4, B:312:0x05b8, B:314:0x05bc, B:316:0x05c3, B:318:0x05c7, B:320:0x05cd, B:322:0x05d9, B:323:0x0604, B:326:0x060b, B:328:0x0610, B:330:0x061c, B:332:0x0622, B:334:0x0628, B:335:0x062b, B:337:0x062f, B:339:0x0634, B:342:0x0646, B:345:0x064e, B:346:0x0651, B:348:0x0657, B:350:0x065f, B:355:0x0682, B:357:0x0687, B:360:0x0695, B:362:0x069b, B:364:0x06ab, B:366:0x06b1, B:367:0x06b8, B:369:0x06bb, B:370:0x06c4, B:371:0x06d4, B:372:0x06d7, B:315:0x05c0, B:282:0x04d5, B:284:0x04d9, B:292:0x0534, B:294:0x0538, B:297:0x0555, B:301:0x0563, B:303:0x0597, B:304:0x059b, B:300:0x055c, B:296:0x053f, B:286:0x04df, B:289:0x04f0, B:291:0x0523, B:266:0x0487, B:268:0x0491, B:270:0x0499, B:273:0x04a8, B:275:0x04ac, B:277:0x04b9, B:464:0x084b, B:468:0x0853, B:470:0x0859, B:471:0x0860, B:473:0x0865, B:474:0x086e, B:476:0x0872, B:478:0x0878, B:482:0x0884, B:484:0x0893, B:485:0x089f), top: B:512:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:371:0x06d4 A[Catch: IOException -> 0x08af, zzhd -> 0x08b4, RuntimeException -> 0x08b9, TryCatch #9 {RuntimeException -> 0x08b9, blocks: (B:3:0x0005, B:7:0x0019, B:9:0x0021, B:12:0x0028, B:16:0x002f, B:20:0x003a, B:23:0x004c, B:25:0x0052, B:29:0x005b, B:33:0x0063, B:34:0x0065, B:36:0x0069, B:37:0x0070, B:39:0x007a, B:41:0x007e, B:43:0x0082, B:44:0x0095, B:47:0x009b, B:10:0x0024, B:49:0x009f, B:56:0x00bd, B:63:0x00cb, B:66:0x00ce, B:69:0x00d8, B:73:0x00dc, B:74:0x00dd, B:76:0x00e1, B:78:0x00e6, B:81:0x00ec, B:83:0x00f2, B:86:0x00f7, B:88:0x00fc, B:92:0x0105, B:94:0x012f, B:95:0x0136, B:96:0x013d, B:98:0x0142, B:102:0x014f, B:104:0x0159, B:105:0x015b, B:107:0x015f, B:109:0x0165, B:112:0x016b, B:113:0x0172, B:114:0x0176, B:115:0x017d, B:117:0x0181, B:118:0x0186, B:119:0x0189, B:126:0x01c6, B:120:0x0198, B:122:0x01a0, B:123:0x01a6, B:125:0x01b0, B:128:0x01d2, B:130:0x01da, B:133:0x01e1, B:135:0x01e5, B:137:0x01ed, B:140:0x01f4, B:142:0x0207, B:143:0x0217, B:145:0x021b, B:147:0x022b, B:149:0x022f, B:151:0x023d, B:152:0x0242, B:160:0x028b, B:162:0x028f, B:165:0x0296, B:167:0x02a0, B:169:0x02aa, B:170:0x02af, B:171:0x02d7, B:173:0x02db, B:177:0x02e8, B:178:0x02eb, B:179:0x02f8, B:183:0x0306, B:185:0x030c, B:186:0x031f, B:188:0x0323, B:190:0x0333, B:192:0x0345, B:196:0x0353, B:198:0x0358, B:199:0x036c, B:200:0x0375, B:163:0x0292, B:153:0x025a, B:155:0x0262, B:157:0x026a, B:158:0x026f, B:202:0x0379, B:203:0x0384, B:210:0x038f, B:211:0x0390, B:213:0x0394, B:215:0x039c, B:217:0x03a9, B:216:0x03a3, B:219:0x03b5, B:221:0x03bd, B:222:0x03c6, B:224:0x03cc, B:225:0x03ec, B:229:0x03f5, B:235:0x0418, B:239:0x0426, B:247:0x043c, B:251:0x044a, B:254:0x0455, B:258:0x0464, B:259:0x046d, B:260:0x046e, B:262:0x0476, B:373:0x06da, B:375:0x06e0, B:376:0x06e8, B:378:0x0703, B:380:0x070e, B:384:0x0717, B:386:0x071d, B:392:0x0729, B:397:0x0733, B:399:0x073a, B:400:0x073d, B:402:0x0741, B:404:0x074f, B:405:0x0762, B:409:0x077b, B:411:0x0783, B:413:0x0789, B:446:0x0813, B:448:0x0817, B:450:0x081c, B:451:0x0824, B:453:0x0828, B:457:0x0831, B:462:0x0847, B:455:0x082d, B:458:0x0837, B:460:0x083c, B:461:0x0842, B:414:0x0793, B:416:0x0798, B:419:0x079f, B:421:0x07a7, B:425:0x07ba, B:435:0x07ec, B:437:0x07f4, B:428:0x07c2, B:429:0x07d0, B:422:0x07ac, B:433:0x07e6, B:438:0x07f8, B:440:0x07fd, B:445:0x0809, B:443:0x0803, B:263:0x047e, B:265:0x0482, B:278:0x04c5, B:280:0x04cd, B:305:0x05a7, B:307:0x05ab, B:310:0x05b4, B:312:0x05b8, B:314:0x05bc, B:316:0x05c3, B:318:0x05c7, B:320:0x05cd, B:322:0x05d9, B:323:0x0604, B:326:0x060b, B:328:0x0610, B:330:0x061c, B:332:0x0622, B:334:0x0628, B:335:0x062b, B:337:0x062f, B:339:0x0634, B:342:0x0646, B:345:0x064e, B:346:0x0651, B:348:0x0657, B:350:0x065f, B:355:0x0682, B:357:0x0687, B:360:0x0695, B:362:0x069b, B:364:0x06ab, B:366:0x06b1, B:367:0x06b8, B:369:0x06bb, B:370:0x06c4, B:371:0x06d4, B:372:0x06d7, B:315:0x05c0, B:282:0x04d5, B:284:0x04d9, B:292:0x0534, B:294:0x0538, B:297:0x0555, B:301:0x0563, B:303:0x0597, B:304:0x059b, B:300:0x055c, B:296:0x053f, B:286:0x04df, B:289:0x04f0, B:291:0x0523, B:266:0x0487, B:268:0x0491, B:270:0x0499, B:273:0x04a8, B:275:0x04ac, B:277:0x04b9, B:464:0x084b, B:468:0x0853, B:470:0x0859, B:471:0x0860, B:473:0x0865, B:474:0x086e, B:476:0x0872, B:478:0x0878, B:482:0x0884, B:484:0x0893, B:485:0x089f), top: B:512:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:431:0x07e2  */
    /* JADX WARN: Removed duplicated region for block: B:432:0x07e4  */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean handleMessage(android.os.Message r35) {
        /*
            Method dump skipped, instruction units count: 2344
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhl.handleMessage(android.os.Message):boolean");
    }

    public final synchronized void release() {
        if (this.zzagi) {
            return;
        }
        this.handler.sendEmptyMessage(6);
        while (!this.zzagi) {
            try {
                wait();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
        this.zzagd.quit();
    }

    public final void stop() {
        this.handler.sendEmptyMessage(5);
    }

    public final void zza(zzmz zzmzVar, boolean z) {
        this.handler.obtainMessage(0, 1, 0, zzmzVar).sendToTarget();
    }

    public final synchronized void zzb(zzhh... zzhhVarArr) {
        if (this.zzagi) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            return;
        }
        int i = this.zzagk;
        this.zzagk = i + 1;
        this.handler.obtainMessage(11, zzhhVarArr).sendToTarget();
        while (this.zzagl <= i) {
            try {
                wait();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzof
    public final void zzes() {
        this.handler.sendEmptyMessage(10);
    }

    public final void zzf(boolean z) {
        this.handler.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
    }

    public final void zza(zzhy zzhyVar, int i, long j) {
        this.handler.obtainMessage(3, new zzhm(zzhyVar, i, j)).sendToTarget();
    }

    public final void zza(zzhh... zzhhVarArr) {
        if (this.zzagi) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        } else {
            this.zzagk++;
            this.handler.obtainMessage(11, zzhhVarArr).sendToTarget();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final void zza(zzmx zzmxVar) {
        this.handler.obtainMessage(8, zzmxVar).sendToTarget();
    }

    private final void zza(long j, long j2) {
        this.handler.removeMessages(2);
        long jElapsedRealtime = (j + j2) - SystemClock.elapsedRealtime();
        if (jElapsedRealtime <= 0) {
            this.handler.sendEmptyMessage(2);
        } else {
            this.handler.sendEmptyMessageDelayed(2, jElapsedRealtime);
        }
    }

    @Override // com.google.android.gms.internal.ads.zznc
    public final void zzb(zzhy zzhyVar, Object obj) {
        this.handler.obtainMessage(7, Pair.create(zzhyVar, obj)).sendToTarget();
    }

    private final void zzb(Object obj, int i) {
        this.zzaes.obtainMessage(6, new zzhp(this.zzafd, obj, this.zzafi, i)).sendToTarget();
    }

    private final Pair<Integer, Long> zzb(int i, long j) {
        return zzb(this.zzafd, i, -9223372036854775807L);
    }

    private final long zza(int i, long j) throws zzhd {
        zzhk zzhkVar;
        zzeu();
        this.zzagj = false;
        setState(2);
        zzhk zzhkVar2 = this.zzags;
        if (zzhkVar2 == null) {
            zzhk zzhkVar3 = this.zzagq;
            if (zzhkVar3 != null) {
                zzhkVar3.release();
            }
            zzhkVar = null;
        } else {
            zzhkVar = null;
            while (zzhkVar2 != null) {
                if (zzhkVar2.zzafr == i && zzhkVar2.zzafu) {
                    zzhkVar = zzhkVar2;
                } else {
                    zzhkVar2.release();
                }
                zzhkVar2 = zzhkVar2.zzafw;
            }
        }
        zzhk zzhkVar4 = this.zzags;
        if (zzhkVar4 != zzhkVar || zzhkVar4 != this.zzagr) {
            for (zzhx zzhxVar : this.zzagh) {
                zzhxVar.disable();
            }
            this.zzagh = new zzhx[0];
            this.zzagg = null;
            this.zzagf = null;
            this.zzags = null;
        }
        if (zzhkVar != null) {
            zzhkVar.zzafw = null;
            this.zzagq = zzhkVar;
            this.zzagr = zzhkVar;
            zzb(zzhkVar);
            zzhk zzhkVar5 = this.zzags;
            if (zzhkVar5.zzafv) {
                j = zzhkVar5.zzafm.zzeg(j);
            }
            zzdq(j);
            zzey();
        } else {
            this.zzagq = null;
            this.zzagr = null;
            this.zzags = null;
            zzdq(j);
        }
        this.handler.sendEmptyMessage(2);
        return j;
    }

    private final Pair<Integer, Long> zzb(zzhy zzhyVar, int i, long j) {
        return zza(zzhyVar, i, j, 0L);
    }

    private final void zzb(zzhk zzhkVar) throws zzhd {
        if (this.zzags == zzhkVar) {
            return;
        }
        boolean[] zArr = new boolean[this.zzaep.length];
        int i = 0;
        int i2 = 0;
        while (true) {
            zzhx[] zzhxVarArr = this.zzaep;
            if (i < zzhxVarArr.length) {
                zzhx zzhxVar = zzhxVarArr[i];
                zArr[i] = zzhxVar.getState() != 0;
                zzob zzobVarZzbg = zzhkVar.zzafx.zzbhx.zzbg(i);
                if (zzobVarZzbg != null) {
                    i2++;
                }
                if (zArr[i] && (zzobVarZzbg == null || (zzhxVar.zzee() && zzhxVar.zzeb() == this.zzags.zzafo[i]))) {
                    if (zzhxVar == this.zzagf) {
                        this.zzagc.zza(this.zzagg);
                        this.zzagg = null;
                        this.zzagf = null;
                    }
                    zza(zzhxVar);
                    zzhxVar.disable();
                }
                i++;
            } else {
                this.zzags = zzhkVar;
                this.zzaes.obtainMessage(3, zzhkVar.zzafx).sendToTarget();
                zza(zArr, i2);
                return;
            }
        }
    }

    private static void zza(zzhx zzhxVar) throws zzhd {
        if (zzhxVar.getState() == 2) {
            zzhxVar.stop();
        }
    }

    private final void zza(Object obj, int i) {
        this.zzafi = new zzhn(0, 0L);
        zzb(obj, i);
        this.zzafi = new zzhn(0, -9223372036854775807L);
        setState(4);
        zzi(false);
    }

    private final int zza(int i, zzhy zzhyVar, zzhy zzhyVar2) {
        int iZzfg = zzhyVar.zzfg();
        int iZza = i;
        int iZzc = -1;
        for (int i2 = 0; i2 < iZzfg && iZzc == -1; i2++) {
            iZza = zzhyVar.zza(iZza, this.zzaew, this.zzaev, this.repeatMode);
            iZzc = zzhyVar2.zzc(zzhyVar.zza(iZza, this.zzaew, true).zzafn);
        }
        return iZzc;
    }

    private final Pair<Integer, Long> zza(zzhm zzhmVar) {
        zzhy zzhyVar = zzhmVar.zzafd;
        if (zzhyVar.isEmpty()) {
            zzhyVar = this.zzafd;
        }
        try {
            Pair<Integer, Long> pairZzb = zzb(zzhyVar, zzhmVar.zzagt, zzhmVar.zzagu);
            zzhy zzhyVar2 = this.zzafd;
            if (zzhyVar2 == zzhyVar) {
                return pairZzb;
            }
            int iZzc = zzhyVar2.zzc(zzhyVar.zza(((Integer) pairZzb.first).intValue(), this.zzaew, true).zzafn);
            if (iZzc != -1) {
                return Pair.create(Integer.valueOf(iZzc), (Long) pairZzb.second);
            }
            int iZza = zza(((Integer) pairZzb.first).intValue(), zzhyVar, this.zzafd);
            if (iZza == -1) {
                return null;
            }
            this.zzafd.zza(iZza, this.zzaew, false);
            return zzb(0, -9223372036854775807L);
        } catch (IndexOutOfBoundsException unused) {
            throw new zzht(this.zzafd, zzhmVar.zzagt, zzhmVar.zzagu);
        }
    }

    private final Pair<Integer, Long> zza(zzhy zzhyVar, int i, long j, long j2) {
        zzoz.zzc(i, 0, zzhyVar.zzff());
        zzhyVar.zza(i, this.zzaev, false, j2);
        if (j == -9223372036854775807L) {
            j = this.zzaev.zzaiw;
            if (j == -9223372036854775807L) {
                return null;
            }
        }
        long j3 = this.zzaev.zzaix + j;
        long j4 = zzhyVar.zza(0, this.zzaew, false).zzaih;
        if (j4 != -9223372036854775807L) {
            int i2 = (j3 > j4 ? 1 : (j3 == j4 ? 0 : -1));
        }
        return Pair.create(0, Long.valueOf(j3));
    }

    private static void zza(zzhk zzhkVar) {
        while (zzhkVar != null) {
            zzhkVar.release();
            zzhkVar = zzhkVar.zzafw;
        }
    }

    private final void zza(boolean[] zArr, int i) throws zzhd {
        this.zzagh = new zzhx[i];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            zzhx[] zzhxVarArr = this.zzaep;
            if (i2 >= zzhxVarArr.length) {
                return;
            }
            zzhx zzhxVar = zzhxVarArr[i2];
            zzob zzobVarZzbg = this.zzags.zzafx.zzbhx.zzbg(i2);
            if (zzobVarZzbg != null) {
                int i4 = i3 + 1;
                this.zzagh[i3] = zzhxVar;
                if (zzhxVar.getState() == 0) {
                    zzhz zzhzVar = this.zzags.zzafx.zzbhz[i2];
                    boolean z = this.zzaey && this.state == 3;
                    boolean z2 = !zArr[i2] && z;
                    zzho[] zzhoVarArr = new zzho[zzobVarZzbg.length()];
                    for (int i5 = 0; i5 < zzhoVarArr.length; i5++) {
                        zzhoVarArr[i5] = zzobVarZzbg.zzbe(i5);
                    }
                    zzhk zzhkVar = this.zzags;
                    zzhxVar.zza(zzhzVar, zzhoVarArr, zzhkVar.zzafo[i2], this.zzagp, z2, zzhkVar.zzep());
                    zzpd zzpdVarZzea = zzhxVar.zzea();
                    if (zzpdVarZzea != null) {
                        if (this.zzagg == null) {
                            this.zzagg = zzpdVarZzea;
                            this.zzagf = zzhxVar;
                            this.zzagg.zzb(this.zzafh);
                        } else {
                            throw zzhd.zza(new IllegalStateException("Multiple renderer media clocks enabled."));
                        }
                    }
                    if (z) {
                        zzhxVar.start();
                    }
                }
                i3 = i4;
            }
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzno
    public final /* synthetic */ void zza(zznl zznlVar) {
        this.handler.obtainMessage(9, (zzmx) zznlVar).sendToTarget();
    }
}
