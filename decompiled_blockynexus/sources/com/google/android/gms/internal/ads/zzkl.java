package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import com.google.android.gms.internal.ads.zzjn;
import com.google.firebase.FirebaseError;
import io.rong.imkit.utils.FileTypeUtils;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzkl implements zzjv {
    private static final zzka zzapj = new zzko();
    private static final byte[] zzapk = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    private static final byte[] zzapl = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    private static final UUID zzapm = new UUID(72057594037932032L, -9223371306706625679L);
    private long zzaih;
    private final zzks zzapd;
    private final zzkj zzapn;
    private final SparseArray<zzkq> zzapo;
    private final boolean zzapp;
    private final zzpk zzapq;
    private final zzpk zzapr;
    private final zzpk zzaps;
    private final zzpk zzapt;
    private final zzpk zzapu;
    private final zzpk zzapv;
    private final zzpk zzapw;
    private final zzpk zzapx;
    private final zzpk zzapy;
    private ByteBuffer zzapz;
    private long zzaqa;
    private long zzaqb;
    private long zzaqc;
    private long zzaqd;
    private zzkq zzaqe;
    private boolean zzaqf;
    private int zzaqg;
    private long zzaqh;
    private boolean zzaqi;
    private long zzaqj;
    private long zzaqk;
    private long zzaql;
    private zzpe zzaqm;
    private zzpe zzaqn;
    private boolean zzaqo;
    private int zzaqp;
    private long zzaqq;
    private long zzaqr;
    private int zzaqs;
    private int zzaqt;
    private int[] zzaqu;
    private int zzaqv;
    private int zzaqw;
    private int zzaqx;
    private int zzaqy;
    private boolean zzaqz;
    private boolean zzara;
    private boolean zzarb;
    private boolean zzarc;
    private byte zzard;
    private int zzare;
    private int zzarf;
    private int zzarg;
    private boolean zzarh;
    private boolean zzari;
    private zzjx zzarj;

    public zzkl() {
        this(0);
    }

    static int zzan(int i) {
        switch (i) {
            case 131:
            case 136:
            case 155:
            case 159:
            case 176:
            case 179:
            case 186:
            case 215:
            case 231:
            case 241:
            case 251:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 22186:
            case 22203:
            case 25188:
            case 2352003:
            case 2807729:
                return 2;
            case 134:
            case FirebaseError.ERROR_WEAK_PASSWORD /* 17026 */:
            case 2274716:
                return 3;
            case 160:
            case 174:
            case 183:
            case 187:
            case 224:
            case 225:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case 163:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case 181:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
                return 5;
            default:
                return 0;
        }
    }

    static boolean zzao(int i) {
        return i == 357149030 || i == 524531317 || i == 475249515 || i == 374648427;
    }

    private final void zzb(zzjy zzjyVar, int i) throws InterruptedException, IOException {
        if (this.zzaps.limit() >= i) {
            return;
        }
        if (this.zzaps.capacity() < i) {
            zzpk zzpkVar = this.zzaps;
            byte[] bArr = zzpkVar.data;
            zzpkVar.zzc(Arrays.copyOf(bArr, Math.max(bArr.length << 1, i)), this.zzaps.limit());
        }
        zzpk zzpkVar2 = this.zzaps;
        zzjyVar.readFully(zzpkVar2.data, zzpkVar2.limit(), i - this.zzaps.limit());
        this.zzaps.zzbn(i);
    }

    private final long zzea(long j) throws zzhv {
        long j2 = this.zzaqc;
        if (j2 != -9223372036854775807L) {
            return zzpq.zza(j, j2, 1000L);
        }
        throw new zzhv("Can't scale timecode prior to timecodeScale being set.");
    }

    private final void zzgu() {
        this.zzaqy = 0;
        this.zzarg = 0;
        this.zzarf = 0;
        this.zzaqz = false;
        this.zzara = false;
        this.zzarc = false;
        this.zzare = 0;
        this.zzard = (byte) 0;
        this.zzarb = false;
        this.zzapv.reset();
    }

    @Override // com.google.android.gms.internal.ads.zzjv
    public final void release() {
    }

    @Override // com.google.android.gms.internal.ads.zzjv
    public final boolean zza(zzjy zzjyVar) throws InterruptedException, IOException {
        return new zzkp().zza(zzjyVar);
    }

    final void zzap(int i) throws zzhv {
        zzke zzkdVar;
        zzpe zzpeVar;
        zzpe zzpeVar2;
        int i2;
        if (i == 160) {
            if (this.zzaqp != 2) {
                return;
            }
            if (!this.zzari) {
                this.zzaqx |= 1;
            }
            zza(this.zzapo.get(this.zzaqv), this.zzaqq);
            this.zzaqp = 0;
            return;
        }
        if (i == 174) {
            String str = this.zzaqe.zzarm;
            if ((("V_VP8".equals(str) || "V_VP9".equals(str) || "V_MPEG2".equals(str) || "V_MPEG4/ISO/SP".equals(str) || "V_MPEG4/ISO/ASP".equals(str) || "V_MPEG4/ISO/AP".equals(str) || "V_MPEG4/ISO/AVC".equals(str) || "V_MPEGH/ISO/HEVC".equals(str) || "V_MS/VFW/FOURCC".equals(str) || "V_THEORA".equals(str) || "A_OPUS".equals(str) || "A_VORBIS".equals(str) || "A_AAC".equals(str) || "A_MPEG/L2".equals(str) || "A_MPEG/L3".equals(str) || "A_AC3".equals(str) || "A_EAC3".equals(str) || "A_TRUEHD".equals(str) || "A_DTS".equals(str) || "A_DTS/EXPRESS".equals(str) || "A_DTS/LOSSLESS".equals(str) || "A_FLAC".equals(str) || "A_MS/ACM".equals(str) || "A_PCM/INT/LIT".equals(str) || "S_TEXT/UTF8".equals(str) || "S_VOBSUB".equals(str) || "S_HDMV/PGS".equals(str) || "S_DVBSUB".equals(str)) ? 1 : 0) != 0) {
                zzkq zzkqVar = this.zzaqe;
                zzkqVar.zza(this.zzarj, zzkqVar.number);
                SparseArray<zzkq> sparseArray = this.zzapo;
                zzkq zzkqVar2 = this.zzaqe;
                sparseArray.put(zzkqVar2.number, zzkqVar2);
            }
            this.zzaqe = null;
            return;
        }
        if (i == 19899) {
            int i3 = this.zzaqg;
            if (i3 != -1) {
                long j = this.zzaqh;
                if (j != -1) {
                    if (i3 == 475249515) {
                        this.zzaqj = j;
                        return;
                    }
                    return;
                }
            }
            throw new zzhv("Mandatory element SeekID or SeekPosition not found");
        }
        if (i == 25152) {
            zzkq zzkqVar3 = this.zzaqe;
            if (zzkqVar3.zzaro) {
                zzkf zzkfVar = zzkqVar3.zzarq;
                if (zzkfVar == null) {
                    throw new zzhv("Encrypted Track found but ContentEncKeyID was not found");
                }
                zzkqVar3.zzahf = new zzjn(new zzjn.zza(zzha.UUID_NIL, "video/webm", zzkfVar.zzapa));
                return;
            }
            return;
        }
        if (i == 28032) {
            zzkq zzkqVar4 = this.zzaqe;
            if (zzkqVar4.zzaro && zzkqVar4.zzarp != null) {
                throw new zzhv("Combining encryption and compression is not supported");
            }
            return;
        }
        if (i == 357149030) {
            if (this.zzaqc == -9223372036854775807L) {
                this.zzaqc = 1000000L;
            }
            long j2 = this.zzaqd;
            if (j2 != -9223372036854775807L) {
                this.zzaih = zzea(j2);
                return;
            }
            return;
        }
        if (i == 374648427) {
            if (this.zzapo.size() == 0) {
                throw new zzhv("No valid tracks were found");
            }
            this.zzarj.zzgr();
            return;
        }
        if (i == 475249515 && !this.zzaqf) {
            zzjx zzjxVar = this.zzarj;
            if (this.zzaqb == -1 || this.zzaih == -9223372036854775807L || (zzpeVar = this.zzaqm) == null || zzpeVar.size() == 0 || (zzpeVar2 = this.zzaqn) == null || zzpeVar2.size() != this.zzaqm.size()) {
                this.zzaqm = null;
                this.zzaqn = null;
                zzkdVar = new zzkd(this.zzaih);
            } else {
                int size = this.zzaqm.size();
                int[] iArr = new int[size];
                long[] jArr = new long[size];
                long[] jArr2 = new long[size];
                long[] jArr3 = new long[size];
                for (int i4 = 0; i4 < size; i4++) {
                    jArr3[i4] = this.zzaqm.get(i4);
                    jArr[i4] = this.zzaqb + this.zzaqn.get(i4);
                }
                while (true) {
                    i2 = size - 1;
                    if (i >= i2) {
                        break;
                    }
                    int i5 = i + 1;
                    iArr[i] = (int) (jArr[i5] - jArr[i]);
                    jArr2[i] = jArr3[i5] - jArr3[i];
                    i = i5;
                }
                iArr[i2] = (int) ((this.zzaqb + this.zzaqa) - jArr[i2]);
                jArr2[i2] = this.zzaih - jArr3[i2];
                this.zzaqm = null;
                this.zzaqn = null;
                zzkdVar = new zzjt(iArr, jArr, jArr2, jArr3);
            }
            zzjxVar.zza(zzkdVar);
            this.zzaqf = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzjv
    public final void zzc(long j, long j2) {
        this.zzaql = -9223372036854775807L;
        this.zzaqp = 0;
        this.zzapn.reset();
        this.zzapd.reset();
        zzgu();
    }

    final void zzd(int i, long j, long j2) throws zzhv {
        if (i == 160) {
            this.zzari = false;
            return;
        }
        if (i == 174) {
            this.zzaqe = new zzkq(null);
            return;
        }
        if (i == 187) {
            this.zzaqo = false;
            return;
        }
        if (i == 19899) {
            this.zzaqg = -1;
            this.zzaqh = -1L;
            return;
        }
        if (i == 20533) {
            this.zzaqe.zzaro = true;
            return;
        }
        if (i == 21968) {
            this.zzaqe.zzarv = true;
            return;
        }
        if (i != 25152) {
            if (i == 408125543) {
                long j3 = this.zzaqb;
                if (j3 != -1 && j3 != j) {
                    throw new zzhv("Multiple Segment elements not supported");
                }
                this.zzaqb = j;
                this.zzaqa = j2;
                return;
            }
            if (i == 475249515) {
                this.zzaqm = new zzpe();
                this.zzaqn = new zzpe();
            } else if (i == 524531317 && !this.zzaqf) {
                if (this.zzapp && this.zzaqj != -1) {
                    this.zzaqi = true;
                } else {
                    this.zzarj.zza(new zzkd(this.zzaih));
                    this.zzaqf = true;
                }
            }
        }
    }

    private zzkl(int i) {
        this(new zzki(), 0);
    }

    @Override // com.google.android.gms.internal.ads.zzjv
    public final void zza(zzjx zzjxVar) {
        this.zzarj = zzjxVar;
    }

    private zzkl(zzkj zzkjVar, int i) {
        this.zzaqb = -1L;
        this.zzaqc = -9223372036854775807L;
        this.zzaqd = -9223372036854775807L;
        this.zzaih = -9223372036854775807L;
        this.zzaqj = -1L;
        this.zzaqk = -1L;
        this.zzaql = -9223372036854775807L;
        this.zzapn = zzkjVar;
        this.zzapn.zza(new zzkn(this, null));
        this.zzapp = true;
        this.zzapd = new zzks();
        this.zzapo = new SparseArray<>();
        this.zzaps = new zzpk(4);
        this.zzapt = new zzpk(ByteBuffer.allocate(4).putInt(-1).array());
        this.zzapu = new zzpk(4);
        this.zzapq = new zzpk(zzpf.zzbjr);
        this.zzapr = new zzpk(4);
        this.zzapv = new zzpk();
        this.zzapw = new zzpk();
        this.zzapx = new zzpk(8);
        this.zzapy = new zzpk();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0039 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0005 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzjv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zza(com.google.android.gms.internal.ads.zzjy r9, com.google.android.gms.internal.ads.zzkb r10) throws java.lang.InterruptedException, java.io.IOException {
        /*
            r8 = this;
            r0 = 0
            r8.zzarh = r0
            r1 = 1
            r2 = 1
        L5:
            if (r2 == 0) goto L3a
            boolean r3 = r8.zzarh
            if (r3 != 0) goto L3a
            com.google.android.gms.internal.ads.zzkj r2 = r8.zzapn
            boolean r2 = r2.zzb(r9)
            if (r2 == 0) goto L5
            long r3 = r9.getPosition()
            boolean r5 = r8.zzaqi
            if (r5 == 0) goto L25
            r8.zzaqk = r3
            long r3 = r8.zzaqj
            r10.position = r3
            r8.zzaqi = r0
        L23:
            r3 = 1
            goto L37
        L25:
            boolean r3 = r8.zzaqf
            if (r3 == 0) goto L36
            long r3 = r8.zzaqk
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L36
            r10.position = r3
            r8.zzaqk = r5
            goto L23
        L36:
            r3 = 0
        L37:
            if (r3 == 0) goto L5
            return r1
        L3a:
            if (r2 == 0) goto L3d
            return r0
        L3d:
            r9 = -1
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkl.zza(com.google.android.gms.internal.ads.zzjy, com.google.android.gms.internal.ads.zzkb):int");
    }

    final void zzc(int i, long j) throws zzhv {
        if (i == 20529) {
            if (j == 0) {
                return;
            }
            StringBuilder sb = new StringBuilder(55);
            sb.append("ContentEncodingOrder ");
            sb.append(j);
            sb.append(" not supported");
            throw new zzhv(sb.toString());
        }
        if (i == 20530) {
            if (j == 1) {
                return;
            }
            StringBuilder sb2 = new StringBuilder(55);
            sb2.append("ContentEncodingScope ");
            sb2.append(j);
            sb2.append(" not supported");
            throw new zzhv(sb2.toString());
        }
        switch (i) {
            case 131:
                this.zzaqe.type = (int) j;
                return;
            case 136:
                this.zzaqe.zzaso = j == 1;
                return;
            case 155:
                this.zzaqr = zzea(j);
                return;
            case 159:
                this.zzaqe.zzahm = (int) j;
                return;
            case 176:
                this.zzaqe.width = (int) j;
                return;
            case 179:
                this.zzaqm.add(zzea(j));
                return;
            case 186:
                this.zzaqe.height = (int) j;
                return;
            case 215:
                this.zzaqe.number = (int) j;
                return;
            case 231:
                this.zzaql = zzea(j);
                return;
            case 241:
                if (this.zzaqo) {
                    return;
                }
                this.zzaqn.add(j);
                this.zzaqo = true;
                return;
            case 251:
                this.zzari = true;
                return;
            case 16980:
                if (j == 3) {
                    return;
                }
                StringBuilder sb3 = new StringBuilder(50);
                sb3.append("ContentCompAlgo ");
                sb3.append(j);
                sb3.append(" not supported");
                throw new zzhv(sb3.toString());
            case 17029:
                if (j < 1 || j > 2) {
                    StringBuilder sb4 = new StringBuilder(53);
                    sb4.append("DocTypeReadVersion ");
                    sb4.append(j);
                    sb4.append(" not supported");
                    throw new zzhv(sb4.toString());
                }
                return;
            case 17143:
                if (j == 1) {
                    return;
                }
                StringBuilder sb5 = new StringBuilder(50);
                sb5.append("EBMLReadVersion ");
                sb5.append(j);
                sb5.append(" not supported");
                throw new zzhv(sb5.toString());
            case 18401:
                if (j == 5) {
                    return;
                }
                StringBuilder sb6 = new StringBuilder(49);
                sb6.append("ContentEncAlgo ");
                sb6.append(j);
                sb6.append(" not supported");
                throw new zzhv(sb6.toString());
            case 18408:
                if (j == 1) {
                    return;
                }
                StringBuilder sb7 = new StringBuilder(56);
                sb7.append("AESSettingsCipherMode ");
                sb7.append(j);
                sb7.append(" not supported");
                throw new zzhv(sb7.toString());
            case 21420:
                this.zzaqh = j + this.zzaqb;
                return;
            case 21432:
                int i2 = (int) j;
                if (i2 == 0) {
                    this.zzaqe.zzahj = 0;
                    return;
                }
                if (i2 == 1) {
                    this.zzaqe.zzahj = 2;
                    return;
                } else if (i2 == 3) {
                    this.zzaqe.zzahj = 1;
                    return;
                } else {
                    if (i2 != 15) {
                        return;
                    }
                    this.zzaqe.zzahj = 3;
                    return;
                }
            case 21680:
                this.zzaqe.zzars = (int) j;
                return;
            case 21682:
                this.zzaqe.zzaru = (int) j;
                return;
            case 21690:
                this.zzaqe.zzart = (int) j;
                return;
            case 21930:
                this.zzaqe.zzasp = j == 1;
                return;
            case 22186:
                this.zzaqe.zzasm = j;
                return;
            case 22203:
                this.zzaqe.zzasn = j;
                return;
            case 25188:
                this.zzaqe.zzasl = (int) j;
                return;
            case 2352003:
                this.zzaqe.zzarn = (int) j;
                return;
            case 2807729:
                this.zzaqc = j;
                return;
            default:
                switch (i) {
                    case 21945:
                        int i3 = (int) j;
                        if (i3 == 1) {
                            this.zzaqe.zzary = 2;
                            return;
                        } else {
                            if (i3 != 2) {
                                return;
                            }
                            this.zzaqe.zzary = 1;
                            return;
                        }
                    case 21946:
                        int i4 = (int) j;
                        if (i4 != 1) {
                            if (i4 == 16) {
                                this.zzaqe.zzarx = 6;
                                return;
                            } else if (i4 == 18) {
                                this.zzaqe.zzarx = 7;
                                return;
                            } else if (i4 != 6 && i4 != 7) {
                                return;
                            }
                        }
                        this.zzaqe.zzarx = 3;
                        return;
                    case 21947:
                        zzkq zzkqVar = this.zzaqe;
                        zzkqVar.zzarv = true;
                        int i5 = (int) j;
                        if (i5 == 1) {
                            zzkqVar.zzarw = 1;
                            return;
                        }
                        if (i5 == 9) {
                            zzkqVar.zzarw = 6;
                            return;
                        } else {
                            if (i5 == 4 || i5 == 5 || i5 == 6 || i5 == 7) {
                                this.zzaqe.zzarw = 2;
                                return;
                            }
                            return;
                        }
                    case 21948:
                        this.zzaqe.zzarz = (int) j;
                        return;
                    case 21949:
                        this.zzaqe.zzasa = (int) j;
                        return;
                    default:
                        return;
                }
        }
    }

    final void zza(int i, double d2) {
        if (i == 181) {
            this.zzaqe.zzahn = (int) d2;
            return;
        }
        if (i != 17545) {
            switch (i) {
                case 21969:
                    this.zzaqe.zzasb = (float) d2;
                    break;
                case 21970:
                    this.zzaqe.zzasc = (float) d2;
                    break;
                case 21971:
                    this.zzaqe.zzasd = (float) d2;
                    break;
                case 21972:
                    this.zzaqe.zzase = (float) d2;
                    break;
                case 21973:
                    this.zzaqe.zzasf = (float) d2;
                    break;
                case 21974:
                    this.zzaqe.zzasg = (float) d2;
                    break;
                case 21975:
                    this.zzaqe.zzash = (float) d2;
                    break;
                case 21976:
                    this.zzaqe.zzasi = (float) d2;
                    break;
                case 21977:
                    this.zzaqe.zzasj = (float) d2;
                    break;
                case 21978:
                    this.zzaqe.zzask = (float) d2;
                    break;
            }
            return;
        }
        this.zzaqd = (long) d2;
    }

    final void zza(int i, String str) throws zzhv {
        if (i == 134) {
            this.zzaqe.zzarm = str;
            return;
        }
        if (i != 17026) {
            if (i != 2274716) {
                return;
            }
            this.zzaqe.zzaht = str;
        } else {
            if ("webm".equals(str) || "matroska".equals(str)) {
                return;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 22);
            sb.append("DocType ");
            sb.append(str);
            sb.append(" not supported");
            throw new zzhv(sb.toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:80:0x01fd, code lost:
    
        throw new com.google.android.gms.internal.ads.zzhv("EBML lacing sample size out of range.");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void zza(int r20, int r21, com.google.android.gms.internal.ads.zzjy r22) throws java.lang.InterruptedException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 692
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkl.zza(int, int, com.google.android.gms.internal.ads.zzjy):void");
    }

    private final void zza(zzkq zzkqVar, long j) {
        byte[] bArrZzbk;
        if ("S_TEXT/UTF8".equals(zzkqVar.zzarm)) {
            byte[] bArr = this.zzapw.data;
            long j2 = this.zzaqr;
            if (j2 == -9223372036854775807L) {
                bArrZzbk = zzapl;
            } else {
                int i = (int) (j2 / 3600000000L);
                long j3 = j2 - (((long) i) * 3600000000L);
                int i2 = (int) (j3 / 60000000);
                long j4 = j3 - ((long) (60000000 * i2));
                int i3 = (int) (j4 / 1000000);
                bArrZzbk = zzpq.zzbk(String.format(Locale.US, "%02d:%02d:%02d,%03d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf((int) ((j4 - ((long) (1000000 * i3))) / 1000))));
            }
            System.arraycopy(bArrZzbk, 0, bArr, 19, 12);
            zzkg zzkgVar = zzkqVar.zzasq;
            zzpk zzpkVar = this.zzapw;
            zzkgVar.zza(zzpkVar, zzpkVar.limit());
            this.zzarg += this.zzapw.limit();
        }
        zzkqVar.zzasq.zza(j, this.zzaqx, this.zzarg, 0, zzkqVar.zzarq);
        this.zzarh = true;
        zzgu();
    }

    private final void zza(zzjy zzjyVar, zzkq zzkqVar, int i) throws InterruptedException, IOException {
        int i2;
        if ("S_TEXT/UTF8".equals(zzkqVar.zzarm)) {
            int length = zzapk.length + i;
            if (this.zzapw.capacity() < length) {
                this.zzapw.data = Arrays.copyOf(zzapk, length + i);
            }
            zzjyVar.readFully(this.zzapw.data, zzapk.length, i);
            this.zzapw.zzbo(0);
            this.zzapw.zzbn(length);
            return;
        }
        zzkg zzkgVar = zzkqVar.zzasq;
        if (!this.zzaqz) {
            if (zzkqVar.zzaro) {
                this.zzaqx &= -1073741825;
                if (!this.zzara) {
                    zzjyVar.readFully(this.zzaps.data, 0, 1);
                    this.zzaqy++;
                    byte[] bArr = this.zzaps.data;
                    if ((bArr[0] & 128) != 128) {
                        this.zzard = bArr[0];
                        this.zzara = true;
                    } else {
                        throw new zzhv("Extension bit is set in signal byte");
                    }
                }
                byte b2 = this.zzard;
                if ((b2 & 1) == 1) {
                    boolean z = (b2 & 2) == 2;
                    this.zzaqx |= FileTypeUtils.GIGABYTE;
                    if (!this.zzarb) {
                        zzjyVar.readFully(this.zzapx.data, 0, 8);
                        this.zzaqy += 8;
                        this.zzarb = true;
                        this.zzaps.data[0] = (byte) ((z ? 128 : 0) | 8);
                        this.zzaps.zzbo(0);
                        zzkgVar.zza(this.zzaps, 1);
                        this.zzarg++;
                        this.zzapx.zzbo(0);
                        zzkgVar.zza(this.zzapx, 8);
                        this.zzarg += 8;
                    }
                    if (z) {
                        if (!this.zzarc) {
                            zzjyVar.readFully(this.zzaps.data, 0, 1);
                            this.zzaqy++;
                            this.zzaps.zzbo(0);
                            this.zzare = this.zzaps.readUnsignedByte();
                            this.zzarc = true;
                        }
                        int i3 = this.zzare << 2;
                        this.zzaps.reset(i3);
                        zzjyVar.readFully(this.zzaps.data, 0, i3);
                        this.zzaqy += i3;
                        short s = (short) ((this.zzare / 2) + 1);
                        int i4 = (s * 6) + 2;
                        ByteBuffer byteBuffer = this.zzapz;
                        if (byteBuffer == null || byteBuffer.capacity() < i4) {
                            this.zzapz = ByteBuffer.allocate(i4);
                        }
                        this.zzapz.position(0);
                        this.zzapz.putShort(s);
                        int i5 = 0;
                        int i6 = 0;
                        while (true) {
                            i2 = this.zzare;
                            if (i5 >= i2) {
                                break;
                            }
                            int iZzjf = this.zzaps.zzjf();
                            if (i5 % 2 == 0) {
                                this.zzapz.putShort((short) (iZzjf - i6));
                            } else {
                                this.zzapz.putInt(iZzjf - i6);
                            }
                            i5++;
                            i6 = iZzjf;
                        }
                        int i7 = (i - this.zzaqy) - i6;
                        if (i2 % 2 == 1) {
                            this.zzapz.putInt(i7);
                        } else {
                            this.zzapz.putShort((short) i7);
                            this.zzapz.putInt(0);
                        }
                        this.zzapy.zzc(this.zzapz.array(), i4);
                        zzkgVar.zza(this.zzapy, i4);
                        this.zzarg += i4;
                    }
                }
            } else {
                byte[] bArr2 = zzkqVar.zzarp;
                if (bArr2 != null) {
                    this.zzapv.zzc(bArr2, bArr2.length);
                }
            }
            this.zzaqz = true;
        }
        int iLimit = i + this.zzapv.limit();
        if (!"V_MPEG4/ISO/AVC".equals(zzkqVar.zzarm) && !"V_MPEGH/ISO/HEVC".equals(zzkqVar.zzarm)) {
            while (true) {
                int i8 = this.zzaqy;
                if (i8 >= iLimit) {
                    break;
                } else {
                    zza(zzjyVar, zzkgVar, iLimit - i8);
                }
            }
        } else {
            byte[] bArr3 = this.zzapr.data;
            bArr3[0] = 0;
            bArr3[1] = 0;
            bArr3[2] = 0;
            int i9 = zzkqVar.zzasr;
            int i10 = 4 - i9;
            while (this.zzaqy < iLimit) {
                int i11 = this.zzarf;
                if (i11 == 0) {
                    int iMin = Math.min(i9, this.zzapv.zzja());
                    zzjyVar.readFully(bArr3, i10 + iMin, i9 - iMin);
                    if (iMin > 0) {
                        this.zzapv.zze(bArr3, i10, iMin);
                    }
                    this.zzaqy += i9;
                    this.zzapr.zzbo(0);
                    this.zzarf = this.zzapr.zzjf();
                    this.zzapq.zzbo(0);
                    zzkgVar.zza(this.zzapq, 4);
                    this.zzarg += 4;
                } else {
                    this.zzarf = i11 - zza(zzjyVar, zzkgVar, i11);
                }
            }
        }
        if ("A_VORBIS".equals(zzkqVar.zzarm)) {
            this.zzapt.zzbo(0);
            zzkgVar.zza(this.zzapt, 4);
            this.zzarg += 4;
        }
    }

    private final int zza(zzjy zzjyVar, zzkg zzkgVar, int i) throws InterruptedException, IOException {
        int iZza;
        int iZzja = this.zzapv.zzja();
        if (iZzja > 0) {
            iZza = Math.min(i, iZzja);
            zzkgVar.zza(this.zzapv, iZza);
        } else {
            iZza = zzkgVar.zza(zzjyVar, i, false);
        }
        this.zzaqy += iZza;
        this.zzarg += iZza;
        return iZza;
    }

    private static int[] zza(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        return iArr.length >= i ? iArr : new int[Math.max(iArr.length << 1, i)];
    }
}
