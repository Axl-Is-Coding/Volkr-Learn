package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzemt {
    static String zzam(zzeip zzeipVar) {
        zzemw zzemwVar = new zzemw(zzeipVar);
        StringBuilder sb = new StringBuilder(zzemwVar.size());
        for (int i = 0; i < zzemwVar.size(); i++) {
            byte bZzfu = zzemwVar.zzfu(i);
            if (bZzfu == 34) {
                sb.append("\\\"");
            } else if (bZzfu == 39) {
                sb.append("\\'");
            } else if (bZzfu != 92) {
                switch (bZzfu) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (bZzfu < 32 || bZzfu > 126) {
                            sb.append('\\');
                            sb.append((char) (((bZzfu >>> 6) & 3) + 48));
                            sb.append((char) (((bZzfu >>> 3) & 7) + 48));
                            sb.append((char) ((bZzfu & 7) + 48));
                        } else {
                            sb.append((char) bZzfu);
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }
}
