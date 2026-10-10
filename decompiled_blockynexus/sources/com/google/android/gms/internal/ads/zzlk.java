package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.android.gms.internal.ads.zzmc;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzlk {
    private static final int zzayx = zzpq.zzbl("nam");
    private static final int zzayy = zzpq.zzbl("trk");
    private static final int zzayz = zzpq.zzbl("cmt");
    private static final int zzaza = zzpq.zzbl("day");
    private static final int zzazb = zzpq.zzbl("ART");
    private static final int zzazc = zzpq.zzbl("too");
    private static final int zzazd = zzpq.zzbl("alb");
    private static final int zzaze = zzpq.zzbl("com");
    private static final int zzazf = zzpq.zzbl("wrt");
    private static final int zzazg = zzpq.zzbl("lyr");
    private static final int zzazh = zzpq.zzbl("gen");
    private static final int zzazi = zzpq.zzbl("covr");
    private static final int zzazj = zzpq.zzbl("gnre");
    private static final int zzazk = zzpq.zzbl("grp");
    private static final int zzazl = zzpq.zzbl("disk");
    private static final int zzazm = zzpq.zzbl("trkn");
    private static final int zzazn = zzpq.zzbl("tmpo");
    private static final int zzazo = zzpq.zzbl("cpil");
    private static final int zzazp = zzpq.zzbl("aART");
    private static final int zzazq = zzpq.zzbl("sonm");
    private static final int zzazr = zzpq.zzbl("soal");
    private static final int zzazs = zzpq.zzbl("soar");
    private static final int zzazt = zzpq.zzbl("soaa");
    private static final int zzazu = zzpq.zzbl("soco");
    private static final int zzazv = zzpq.zzbl("rtng");
    private static final int zzazw = zzpq.zzbl("pgap");
    private static final int zzazx = zzpq.zzbl("sosn");
    private static final int zzazy = zzpq.zzbl("tvsh");
    private static final int zzazz = zzpq.zzbl("----");
    private static final String[] zzbaa = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop"};

    private static zzmm zza(int i, String str, zzpk zzpkVar) {
        int i2 = zzpkVar.readInt();
        if (zzpkVar.readInt() == zzkr.zzavx) {
            zzpkVar.zzbp(8);
            return new zzmm(str, null, zzpkVar.zzbq(i2 - 16));
        }
        String strValueOf = String.valueOf(zzkr.zzas(i));
        Log.w("MetadataUtil", strValueOf.length() != 0 ? "Failed to parse text attribute: ".concat(strValueOf) : new String("Failed to parse text attribute: "));
        return null;
    }

    private static zzmm zzb(int i, String str, zzpk zzpkVar) {
        int i2 = zzpkVar.readInt();
        if (zzpkVar.readInt() == zzkr.zzavx && i2 >= 22) {
            zzpkVar.zzbp(10);
            int unsignedShort = zzpkVar.readUnsignedShort();
            if (unsignedShort > 0) {
                StringBuilder sb = new StringBuilder(11);
                sb.append(unsignedShort);
                String string = sb.toString();
                int unsignedShort2 = zzpkVar.readUnsignedShort();
                if (unsignedShort2 > 0) {
                    String strValueOf = String.valueOf(string);
                    StringBuilder sb2 = new StringBuilder(String.valueOf(strValueOf).length() + 12);
                    sb2.append(strValueOf);
                    sb2.append("/");
                    sb2.append(unsignedShort2);
                    string = sb2.toString();
                }
                return new zzmm(str, null, string);
            }
        }
        String strValueOf2 = String.valueOf(zzkr.zzas(i));
        Log.w("MetadataUtil", strValueOf2.length() != 0 ? "Failed to parse index/count attribute: ".concat(strValueOf2) : new String("Failed to parse index/count attribute: "));
        return null;
    }

    public static zzmc.zza zzd(zzpk zzpkVar) {
        zzmm zzmmVar;
        int position = zzpkVar.getPosition() + zzpkVar.readInt();
        int i = zzpkVar.readInt();
        int i2 = i >>> 24;
        zzmc.zza zzmiVar = null;
        try {
            if (i2 == 169 || i2 == 65533) {
                int i3 = 16777215 & i;
                if (i3 == zzayz) {
                    int i4 = zzpkVar.readInt();
                    if (zzpkVar.readInt() == zzkr.zzavx) {
                        zzpkVar.zzbp(8);
                        String strZzbq = zzpkVar.zzbq(i4 - 16);
                        zzmiVar = new zzmi("und", strZzbq, strZzbq);
                    } else {
                        String strValueOf = String.valueOf(zzkr.zzas(i));
                        Log.w("MetadataUtil", strValueOf.length() != 0 ? "Failed to parse comment attribute: ".concat(strValueOf) : new String("Failed to parse comment attribute: "));
                    }
                    return zzmiVar;
                }
                if (i3 != zzayx && i3 != zzayy) {
                    if (i3 != zzaze && i3 != zzazf) {
                        if (i3 == zzaza) {
                            return zza(i, "TDRC", zzpkVar);
                        }
                        if (i3 == zzazb) {
                            return zza(i, "TPE1", zzpkVar);
                        }
                        if (i3 == zzazc) {
                            return zza(i, "TSSE", zzpkVar);
                        }
                        if (i3 == zzazd) {
                            return zza(i, "TALB", zzpkVar);
                        }
                        if (i3 == zzazg) {
                            return zza(i, "USLT", zzpkVar);
                        }
                        if (i3 == zzazh) {
                            return zza(i, "TCON", zzpkVar);
                        }
                        if (i3 == zzazk) {
                            return zza(i, "TIT1", zzpkVar);
                        }
                    }
                    return zza(i, "TCOM", zzpkVar);
                }
                return zza(i, "TIT2", zzpkVar);
            }
            if (i == zzazj) {
                int iZze = zze(zzpkVar);
                String str = (iZze <= 0 || iZze > zzbaa.length) ? null : zzbaa[iZze - 1];
                if (str != null) {
                    zzmmVar = new zzmm("TCON", null, str);
                } else {
                    Log.w("MetadataUtil", "Failed to parse standard genre code");
                    zzmmVar = null;
                }
                return zzmmVar;
            }
            if (i == zzazl) {
                return zzb(i, "TPOS", zzpkVar);
            }
            if (i == zzazm) {
                return zzb(i, "TRCK", zzpkVar);
            }
            if (i == zzazn) {
                return zza(i, "TBPM", zzpkVar, true, false);
            }
            if (i == zzazo) {
                return zza(i, "TCMP", zzpkVar, true, true);
            }
            if (i == zzazi) {
                int i5 = zzpkVar.readInt();
                if (zzpkVar.readInt() == zzkr.zzavx) {
                    int iZzar = zzkr.zzar(zzpkVar.readInt());
                    String str2 = iZzar == 13 ? "image/jpeg" : iZzar == 14 ? "image/png" : null;
                    if (str2 == null) {
                        StringBuilder sb = new StringBuilder(41);
                        sb.append("Unrecognized cover art flags: ");
                        sb.append(iZzar);
                        Log.w("MetadataUtil", sb.toString());
                    } else {
                        zzpkVar.zzbp(4);
                        byte[] bArr = new byte[i5 - 16];
                        zzpkVar.zze(bArr, 0, bArr.length);
                        zzmiVar = new zzmg(str2, null, 3, bArr);
                    }
                } else {
                    Log.w("MetadataUtil", "Failed to parse cover art attribute");
                }
                return zzmiVar;
            }
            if (i == zzazp) {
                return zza(i, "TPE2", zzpkVar);
            }
            if (i == zzazq) {
                return zza(i, "TSOT", zzpkVar);
            }
            if (i == zzazr) {
                return zza(i, "TSO2", zzpkVar);
            }
            if (i == zzazs) {
                return zza(i, "TSOA", zzpkVar);
            }
            if (i == zzazt) {
                return zza(i, "TSOP", zzpkVar);
            }
            if (i == zzazu) {
                return zza(i, "TSOC", zzpkVar);
            }
            if (i == zzazv) {
                return zza(i, "ITUNESADVISORY", zzpkVar, false, false);
            }
            if (i == zzazw) {
                return zza(i, "ITUNESGAPLESS", zzpkVar, false, true);
            }
            if (i == zzazx) {
                return zza(i, "TVSHOWSORT", zzpkVar);
            }
            if (i == zzazy) {
                return zza(i, "TVSHOW", zzpkVar);
            }
            if (i == zzazz) {
                String strZzbq2 = null;
                String strZzbq3 = null;
                int i6 = -1;
                int i7 = -1;
                while (zzpkVar.getPosition() < position) {
                    int position2 = zzpkVar.getPosition();
                    int i8 = zzpkVar.readInt();
                    int i9 = zzpkVar.readInt();
                    zzpkVar.zzbp(4);
                    if (i9 == zzkr.zzavv) {
                        strZzbq2 = zzpkVar.zzbq(i8 - 12);
                    } else if (i9 == zzkr.zzavw) {
                        strZzbq3 = zzpkVar.zzbq(i8 - 12);
                    } else {
                        if (i9 == zzkr.zzavx) {
                            i6 = position2;
                            i7 = i8;
                        }
                        zzpkVar.zzbp(i8 - 12);
                    }
                }
                if ("com.apple.iTunes".equals(strZzbq2) && "iTunSMPB".equals(strZzbq3) && i6 != -1) {
                    zzpkVar.zzbo(i6);
                    zzpkVar.zzbp(16);
                    zzmiVar = new zzmi("und", strZzbq3, zzpkVar.zzbq(i7 - 16));
                }
                return zzmiVar;
            }
            String strValueOf2 = String.valueOf(zzkr.zzas(i));
            Log.d("MetadataUtil", strValueOf2.length() != 0 ? "Skipped unknown metadata entry: ".concat(strValueOf2) : new String("Skipped unknown metadata entry: "));
            return null;
        } finally {
            zzpkVar.zzbo(position);
        }
    }

    private static int zze(zzpk zzpkVar) {
        zzpkVar.zzbp(4);
        if (zzpkVar.readInt() == zzkr.zzavx) {
            zzpkVar.zzbp(8);
            return zzpkVar.readUnsignedByte();
        }
        Log.w("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }

    private static zzmj zza(int i, String str, zzpk zzpkVar, boolean z, boolean z2) {
        int iZze = zze(zzpkVar);
        if (z2) {
            iZze = Math.min(1, iZze);
        }
        if (iZze >= 0) {
            if (z) {
                return new zzmm(str, null, Integer.toString(iZze));
            }
            return new zzmi("und", str, Integer.toString(iZze));
        }
        String strValueOf = String.valueOf(zzkr.zzas(i));
        Log.w("MetadataUtil", strValueOf.length() != 0 ? "Failed to parse uint8 attribute: ".concat(strValueOf) : new String("Failed to parse uint8 attribute: "));
        return null;
    }
}
