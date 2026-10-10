package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzav implements zzk {
    private final Map<String, zzax> zzci;
    private long zzcj;
    private final zzaz zzck;
    private final int zzcl;

    public zzav(File file, int i) {
        this.zzci = new LinkedHashMap(16, 0.75f, true);
        this.zzcj = 0L;
        this.zzck = new zzay(this, file);
        this.zzcl = 20971520;
    }

    private final synchronized void remove(String str) {
        boolean zDelete = zzf(str).delete();
        removeEntry(str);
        if (!zDelete) {
            zzaq.d("Could not delete cache entry for key=%s, filename=%s", str, zze(str));
        }
    }

    private final void removeEntry(String str) {
        zzax zzaxVarRemove = this.zzci.remove(str);
        if (zzaxVarRemove != null) {
            this.zzcj -= zzaxVarRemove.zzcm;
        }
    }

    static long zzc(InputStream inputStream) throws IOException {
        return (((long) zza(inputStream)) & 255) | 0 | ((((long) zza(inputStream)) & 255) << 8) | ((((long) zza(inputStream)) & 255) << 16) | ((((long) zza(inputStream)) & 255) << 24) | ((((long) zza(inputStream)) & 255) << 32) | ((((long) zza(inputStream)) & 255) << 40) | ((((long) zza(inputStream)) & 255) << 48) | ((255 & ((long) zza(inputStream))) << 56);
    }

    private static String zze(String str) {
        int length = str.length() / 2;
        String strValueOf = String.valueOf(String.valueOf(str.substring(0, length).hashCode()));
        String strValueOf2 = String.valueOf(String.valueOf(str.substring(length).hashCode()));
        return strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
    }

    private final File zzf(String str) {
        return new File(this.zzck.zzo(), zze(str));
    }

    @Override // com.google.android.gms.internal.ads.zzk
    public final synchronized void initialize() {
        File fileZzo = this.zzck.zzo();
        if (!fileZzo.exists()) {
            if (!fileZzo.mkdirs()) {
                zzaq.e("Unable to create cache dir %s", fileZzo.getAbsolutePath());
            }
            return;
        }
        File[] fileArrListFiles = fileZzo.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            try {
                long length = file.length();
                zzba zzbaVar = new zzba(new BufferedInputStream(zza(file)), length);
                try {
                    zzax zzaxVarZzc = zzax.zzc(zzbaVar);
                    zzaxVarZzc.zzcm = length;
                    zza(zzaxVarZzc.zzcn, zzaxVarZzc);
                    zzbaVar.close();
                } catch (Throwable th) {
                    zzbaVar.close();
                    throw th;
                }
            } catch (IOException unused) {
                file.delete();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzk
    public final synchronized void zza(String str, boolean z) {
        zzn zznVarZzb = zzb(str);
        if (zznVarZzb != null) {
            zznVarZzb.zzv = 0L;
            zznVarZzb.zzu = 0L;
            zza(str, zznVarZzb);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzk
    public final synchronized zzn zzb(String str) {
        zzax zzaxVar = this.zzci.get(str);
        if (zzaxVar == null) {
            return null;
        }
        File fileZzf = zzf(str);
        try {
            zzba zzbaVar = new zzba(new BufferedInputStream(zza(fileZzf)), fileZzf.length());
            try {
                zzax zzaxVarZzc = zzax.zzc(zzbaVar);
                if (!TextUtils.equals(str, zzaxVarZzc.zzcn)) {
                    zzaq.d("%s: key=%s, found=%s", fileZzf.getAbsolutePath(), str, zzaxVarZzc.zzcn);
                    removeEntry(str);
                    return null;
                }
                byte[] bArrZza = zza(zzbaVar, zzbaVar.zzp());
                zzn zznVar = new zzn();
                zznVar.data = bArrZza;
                zznVar.zzr = zzaxVar.zzr;
                zznVar.zzs = zzaxVar.zzs;
                zznVar.zzt = zzaxVar.zzt;
                zznVar.zzu = zzaxVar.zzu;
                zznVar.zzv = zzaxVar.zzv;
                List<zzu> list = zzaxVar.zzx;
                TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
                for (zzu zzuVar : list) {
                    treeMap.put(zzuVar.getName(), zzuVar.getValue());
                }
                zznVar.zzw = treeMap;
                zznVar.zzx = Collections.unmodifiableList(zzaxVar.zzx);
                return zznVar;
            } finally {
                zzbaVar.close();
            }
        } catch (IOException e2) {
            zzaq.d("%s: %s", fileZzf.getAbsolutePath(), e2.toString());
            remove(str);
            return null;
        }
    }

    private zzav(zzaz zzazVar, int i) {
        this.zzci = new LinkedHashMap(16, 0.75f, true);
        this.zzcj = 0L;
        this.zzck = zzazVar;
        this.zzcl = 5242880;
    }

    @Override // com.google.android.gms.internal.ads.zzk
    public final synchronized void zza(String str, zzn zznVar) {
        long j;
        if (this.zzcj + ((long) zznVar.data.length) <= this.zzcl || zznVar.data.length <= this.zzcl * 0.9f) {
            File fileZzf = zzf(str);
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileZzf));
                zzax zzaxVar = new zzax(str, zznVar);
                if (zzaxVar.zza(bufferedOutputStream)) {
                    bufferedOutputStream.write(zznVar.data);
                    bufferedOutputStream.close();
                    zzaxVar.zzcm = fileZzf.length();
                    zza(str, zzaxVar);
                    if (this.zzcj >= this.zzcl) {
                        if (zzaq.DEBUG) {
                            zzaq.v("Pruning old cache entries.", new Object[0]);
                        }
                        long j2 = this.zzcj;
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        Iterator<Map.Entry<String, zzax>> it = this.zzci.entrySet().iterator();
                        int i = 0;
                        while (true) {
                            if (!it.hasNext()) {
                                j = j2;
                                break;
                            }
                            zzax value = it.next().getValue();
                            if (zzf(value.zzcn).delete()) {
                                j = j2;
                                this.zzcj -= value.zzcm;
                            } else {
                                j = j2;
                                zzaq.d("Could not delete cache entry for key=%s, filename=%s", value.zzcn, zze(value.zzcn));
                            }
                            it.remove();
                            i++;
                            if (this.zzcj < this.zzcl * 0.9f) {
                                break;
                            } else {
                                j2 = j;
                            }
                        }
                        if (zzaq.DEBUG) {
                            zzaq.v("pruned %d files, %d bytes, %d ms", Integer.valueOf(i), Long.valueOf(this.zzcj - j), Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
                        }
                    }
                    return;
                }
                bufferedOutputStream.close();
                zzaq.d("Failed to write header for %s", fileZzf.getAbsolutePath());
                throw new IOException();
            } catch (IOException unused) {
                if (!fileZzf.delete()) {
                    zzaq.d("Could not clean up file %s", fileZzf.getAbsolutePath());
                }
                if (this.zzck.zzo().exists()) {
                    return;
                }
                zzaq.d("Re-initializing cache after external clearing.", new Object[0]);
                this.zzci.clear();
                this.zzcj = 0L;
                initialize();
            }
        }
    }

    public zzav(zzaz zzazVar) {
        this(zzazVar, 5242880);
    }

    static int zzb(InputStream inputStream) throws IOException {
        return (zza(inputStream) << 24) | zza(inputStream) | 0 | (zza(inputStream) << 8) | (zza(inputStream) << 16);
    }

    static List<zzu> zzb(zzba zzbaVar) throws IOException {
        int iZzb = zzb((InputStream) zzbaVar);
        if (iZzb >= 0) {
            List<zzu> listEmptyList = iZzb == 0 ? Collections.emptyList() : new ArrayList<>();
            for (int i = 0; i < iZzb; i++) {
                listEmptyList.add(new zzu(zza(zzbaVar).intern(), zza(zzbaVar).intern()));
            }
            return listEmptyList;
        }
        StringBuilder sb = new StringBuilder(31);
        sb.append("readHeaderList size=");
        sb.append(iZzb);
        throw new IOException(sb.toString());
    }

    private final void zza(String str, zzax zzaxVar) {
        if (!this.zzci.containsKey(str)) {
            this.zzcj += zzaxVar.zzcm;
        } else {
            this.zzcj += zzaxVar.zzcm - this.zzci.get(str).zzcm;
        }
        this.zzci.put(str, zzaxVar);
    }

    private static byte[] zza(zzba zzbaVar, long j) throws IOException {
        long jZzp = zzbaVar.zzp();
        if (j >= 0 && j <= jZzp) {
            int i = (int) j;
            if (i == j) {
                byte[] bArr = new byte[i];
                new DataInputStream(zzbaVar).readFully(bArr);
                return bArr;
            }
        }
        StringBuilder sb = new StringBuilder(73);
        sb.append("streamToBytes length=");
        sb.append(j);
        sb.append(", maxLength=");
        sb.append(jZzp);
        throw new IOException(sb.toString());
    }

    private static InputStream zza(File file) throws FileNotFoundException {
        return new FileInputStream(file);
    }

    private static int zza(InputStream inputStream) throws IOException {
        int i = inputStream.read();
        if (i != -1) {
            return i;
        }
        throw new EOFException();
    }

    static void zza(OutputStream outputStream, int i) throws IOException {
        outputStream.write(i & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write(i >>> 24);
    }

    static void zza(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) j);
        outputStream.write((byte) (j >>> 8));
        outputStream.write((byte) (j >>> 16));
        outputStream.write((byte) (j >>> 24));
        outputStream.write((byte) (j >>> 32));
        outputStream.write((byte) (j >>> 40));
        outputStream.write((byte) (j >>> 48));
        outputStream.write((byte) (j >>> 56));
    }

    static void zza(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        zza(outputStream, bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    static String zza(zzba zzbaVar) throws IOException {
        return new String(zza(zzbaVar, zzc(zzbaVar)), "UTF-8");
    }
}
