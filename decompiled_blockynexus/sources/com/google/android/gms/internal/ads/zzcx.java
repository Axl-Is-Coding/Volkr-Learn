package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzcx {
    private static boolean zznr;
    private static MessageDigest zzns;
    private static final Object zznt = new Object();
    private static final Object zznu = new Object();
    static CountDownLatch zznv = new CountDownLatch(1);

    private static Vector<byte[]> zza(byte[] bArr, int i) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        int length = ((bArr.length + 255) - 1) / 255;
        Vector<byte[]> vector = new Vector<>();
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 255;
            try {
                vector.add(Arrays.copyOfRange(bArr, i3, bArr.length - i3 > 255 ? i3 + 255 : bArr.length));
            } catch (IndexOutOfBoundsException unused) {
                return null;
            }
        }
        return vector;
    }

    public static byte[] zzb(byte[] bArr) throws NoSuchAlgorithmException {
        byte[] bArrDigest;
        synchronized (zznt) {
            MessageDigest messageDigestZzbp = zzbp();
            if (messageDigestZzbp == null) {
                throw new NoSuchAlgorithmException("Cannot compute hash");
            }
            messageDigestZzbp.reset();
            messageDigestZzbp.update(bArr);
            bArrDigest = zzns.digest();
        }
        return bArrDigest;
    }

    static void zzbo() {
        synchronized (zznu) {
            if (!zznr) {
                zznr = true;
                new Thread(new zzcz()).start();
            }
        }
    }

    private static MessageDigest zzbp() {
        boolean zAwait;
        MessageDigest messageDigest;
        zzbo();
        try {
            zAwait = zznv.await(2L, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
            zAwait = false;
        }
        if (zAwait && (messageDigest = zzns) != null) {
            return messageDigest;
        }
        return null;
    }

    static String zzj(zzcf.zza zzaVar, String str) throws GeneralSecurityException, UnsupportedEncodingException {
        byte[] bArrZza;
        byte[] byteArray = zzaVar.toByteArray();
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcre)).booleanValue()) {
            Vector<byte[]> vectorZza = zza(byteArray, 255);
            if (vectorZza == null || vectorZza.size() == 0) {
                bArrZza = zza(zza(zzcf.zza.zzd.PSN_ENCODE_SIZE_FAIL).toByteArray(), str, true);
            } else {
                zzcf.zzf.zza zzaVarZzbl = zzcf.zzf.zzbl();
                Iterator<byte[]> it = vectorZza.iterator();
                while (it.hasNext()) {
                    zzaVarZzbl.zzj(zzeip.zzu(zza(it.next(), str, false)));
                }
                zzaVarZzbl.zzk(zzeip.zzu(zzb(byteArray)));
                bArrZza = ((zzcf.zzf) zzaVarZzbl.zzbgt()).toByteArray();
            }
        } else {
            if (zzfe.zzaaa == null) {
                throw new GeneralSecurityException();
            }
            bArrZza = ((zzcf.zzf) zzcf.zzf.zzbl().zzj(zzeip.zzu(zzfe.zzaaa.zzc(byteArray, str != null ? str.getBytes() : new byte[0]))).zzb(zzcm.TINK_HYBRID).zzbgt()).toByteArray();
        }
        return zzcv.zza(bArrZza, true);
    }

    private static zzcf.zza zza(zzcf.zza.zzd zzdVar) {
        zzcf.zza.C0108zza c0108zzaZzaq = zzcf.zza.zzaq();
        c0108zzaZzaq.zzn(zzdVar.zzv());
        return (zzcf.zza) c0108zzaZzaq.zzbgt();
    }

    private static byte[] zza(byte[] bArr, String str, boolean z) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        byte[] bArrArray;
        int i = z ? 239 : 255;
        if (bArr.length > i) {
            bArr = zza(zzcf.zza.zzd.PSN_ENCODE_SIZE_FAIL).toByteArray();
        }
        if (bArr.length < i) {
            byte[] bArr2 = new byte[i - bArr.length];
            new SecureRandom().nextBytes(bArr2);
            bArrArray = ByteBuffer.allocate(i + 1).put((byte) bArr.length).put(bArr).put(bArr2).array();
        } else {
            bArrArray = ByteBuffer.allocate(i + 1).put((byte) bArr.length).put(bArr).array();
        }
        if (z) {
            bArrArray = ByteBuffer.allocate(256).put(zzb(bArrArray)).put(bArrArray).array();
        }
        byte[] bArr3 = new byte[256];
        for (zzde zzdeVar : new zzdc().zzvo) {
            zzdeVar.zza(bArrArray, bArr3);
        }
        if (str != null && str.length() > 0) {
            if (str.length() > 32) {
                str = str.substring(0, 32);
            }
            new zzeic(str.getBytes("UTF-8")).zzt(bArr3);
        }
        return bArr3;
    }
}
