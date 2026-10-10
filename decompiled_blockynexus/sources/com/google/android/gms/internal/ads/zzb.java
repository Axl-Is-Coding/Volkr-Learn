package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzb {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.security.cert.X509Certificate[][] zza(java.lang.String r18) throws com.google.android.gms.internal.ads.zzh, java.lang.SecurityException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 665
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzb.zza(java.lang.String):java.security.cert.X509Certificate[][]");
    }

    private static String zzb(int i) {
        if (i == 1) {
            return "SHA-256";
        }
        if (i == 2) {
            return "SHA-512";
        }
        StringBuilder sb = new StringBuilder(44);
        sb.append("Unknown content digest algorthm: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    private static int zzc(int i) {
        if (i == 1) {
            return 32;
        }
        if (i == 2) {
            return 64;
        }
        StringBuilder sb = new StringBuilder(44);
        sb.append("Unknown content digest algorthm: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    private static byte[] zzb(ByteBuffer byteBuffer) throws IOException {
        int i = byteBuffer.getInt();
        if (i < 0) {
            throw new IOException("Negative length");
        }
        if (i <= byteBuffer.remaining()) {
            byte[] bArr = new byte[i];
            byteBuffer.get(bArr);
            return bArr;
        }
        int iRemaining = byteBuffer.remaining();
        StringBuilder sb = new StringBuilder(90);
        sb.append("Underflow while reading length-prefixed value. Length: ");
        sb.append(i);
        sb.append(", available: ");
        sb.append(iRemaining);
        throw new IOException(sb.toString());
    }

    private static X509Certificate[][] zza(FileChannel fileChannel, zze zzeVar) throws SecurityException {
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer byteBufferZza = zza(zzeVar.zzb);
                int i = 0;
                while (byteBufferZza.hasRemaining()) {
                    i++;
                    try {
                        arrayList.add(zza(zza(byteBufferZza), map, certificateFactory));
                    } catch (IOException | SecurityException | BufferUnderflowException e2) {
                        StringBuilder sb = new StringBuilder(48);
                        sb.append("Failed to parse/verify signer #");
                        sb.append(i);
                        sb.append(" block");
                        throw new SecurityException(sb.toString(), e2);
                    }
                }
                if (i > 0) {
                    if (!map.isEmpty()) {
                        long j = zzeVar.zzc;
                        long j2 = zzeVar.zzd;
                        long j3 = zzeVar.zze;
                        ByteBuffer byteBuffer = zzeVar.zzf;
                        if (!map.isEmpty()) {
                            zzf zzfVar = new zzf(fileChannel, 0L, j);
                            zzf zzfVar2 = new zzf(fileChannel, j2, j3 - j2);
                            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
                            byteBufferDuplicate.order(ByteOrder.LITTLE_ENDIAN);
                            zzi.zza(byteBufferDuplicate, j);
                            zzd zzdVar = new zzd(byteBufferDuplicate);
                            int[] iArr = new int[map.size()];
                            Iterator it = map.keySet().iterator();
                            int i2 = 0;
                            while (it.hasNext()) {
                                iArr[i2] = ((Integer) it.next()).intValue();
                                i2++;
                            }
                            try {
                                byte[][] bArrZza = zza(iArr, new zzc[]{zzfVar, zzfVar2, zzdVar});
                                for (int i3 = 0; i3 < iArr.length; i3++) {
                                    int i4 = iArr[i3];
                                    if (!MessageDigest.isEqual((byte[]) map.get(Integer.valueOf(i4)), bArrZza[i3])) {
                                        throw new SecurityException(String.valueOf(zzb(i4)).concat(" digest of contents did not verify"));
                                    }
                                }
                                return (X509Certificate[][]) arrayList.toArray(new X509Certificate[arrayList.size()][]);
                            } catch (DigestException e3) {
                                throw new SecurityException("Failed to compute digest(s) of contents", e3);
                            }
                        }
                        throw new SecurityException("No digests provided");
                    }
                    throw new SecurityException("No content digests found");
                }
                throw new SecurityException("No signers found");
            } catch (IOException e4) {
                throw new SecurityException("Failed to read list of signers", e4);
            }
        } catch (CertificateException e5) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e5);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x00ac A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0015 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.security.cert.X509Certificate[] zza(java.nio.ByteBuffer r22, java.util.Map<java.lang.Integer, byte[]> r23, java.security.cert.CertificateFactory r24) throws java.io.IOException, java.lang.SecurityException {
        /*
            Method dump skipped, instruction units count: 828
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzb.zza(java.nio.ByteBuffer, java.util.Map, java.security.cert.CertificateFactory):java.security.cert.X509Certificate[]");
    }

    private static byte[][] zza(int[] iArr, zzc[] zzcVarArr) throws DigestException {
        long j;
        zzc[] zzcVarArr2 = zzcVarArr;
        int length = zzcVarArr2.length;
        long j2 = 0;
        int i = 0;
        long size = 0;
        int i2 = 0;
        while (true) {
            j = 1048576;
            if (i2 >= length) {
                break;
            }
            size += ((zzcVarArr2[i2].size() + 1048576) - 1) / 1048576;
            i2++;
        }
        if (size < 2097151) {
            int i3 = (int) size;
            byte[][] bArr = new byte[iArr.length][];
            for (int i4 = 0; i4 < iArr.length; i4++) {
                byte[] bArr2 = new byte[(zzc(iArr[i4]) * i3) + 5];
                bArr2[0] = 90;
                zza(i3, bArr2, 1);
                bArr[i4] = bArr2;
            }
            byte[] bArr3 = new byte[5];
            bArr3[0] = -91;
            MessageDigest[] messageDigestArr = new MessageDigest[iArr.length];
            for (int i5 = 0; i5 < iArr.length; i5++) {
                String strZzb = zzb(iArr[i5]);
                try {
                    messageDigestArr[i5] = MessageDigest.getInstance(strZzb);
                } catch (NoSuchAlgorithmException e2) {
                    throw new RuntimeException(String.valueOf(strZzb).concat(" digest not supported"), e2);
                }
            }
            int length2 = zzcVarArr2.length;
            int i6 = 0;
            int i7 = 0;
            while (i6 < length2) {
                zzc zzcVar = zzcVarArr2[i6];
                long j3 = j2;
                int i8 = i6;
                long size2 = zzcVar.size();
                while (size2 > j2) {
                    int iMin = (int) Math.min(size2, j);
                    zza(iMin, bArr3, 1);
                    for (MessageDigest messageDigest : messageDigestArr) {
                        messageDigest.update(bArr3);
                    }
                    long j4 = j3;
                    try {
                        zzcVar.zza(messageDigestArr, j4, iMin);
                        int i9 = 0;
                        while (i9 < iArr.length) {
                            int i10 = iArr[i9];
                            byte[] bArr4 = bArr3;
                            byte[] bArr5 = bArr[i9];
                            int iZzc = zzc(i10);
                            int i11 = length2;
                            MessageDigest messageDigest2 = messageDigestArr[i9];
                            MessageDigest[] messageDigestArr2 = messageDigestArr;
                            int iDigest = messageDigest2.digest(bArr5, (i7 * iZzc) + 5, iZzc);
                            if (iDigest != iZzc) {
                                String algorithm = messageDigest2.getAlgorithm();
                                StringBuilder sb = new StringBuilder(String.valueOf(algorithm).length() + 46);
                                sb.append("Unexpected output size of ");
                                sb.append(algorithm);
                                sb.append(" digest: ");
                                sb.append(iDigest);
                                throw new RuntimeException(sb.toString());
                            }
                            i9++;
                            bArr3 = bArr4;
                            length2 = i11;
                            messageDigestArr = messageDigestArr2;
                        }
                        long j5 = iMin;
                        long j6 = j4 + j5;
                        size2 -= j5;
                        i7++;
                        bArr3 = bArr3;
                        j = 1048576;
                        j3 = j6;
                        j2 = 0;
                    } catch (IOException e3) {
                        StringBuilder sb2 = new StringBuilder(59);
                        sb2.append("Failed to digest chunk #");
                        sb2.append(i7);
                        sb2.append(" of section #");
                        sb2.append(i);
                        throw new DigestException(sb2.toString(), e3);
                    }
                }
                i++;
                i6 = i8 + 1;
                zzcVarArr2 = zzcVarArr;
                j2 = 0;
                j = 1048576;
            }
            byte[][] bArr6 = new byte[iArr.length][];
            for (int i12 = 0; i12 < iArr.length; i12++) {
                int i13 = iArr[i12];
                byte[] bArr7 = bArr[i12];
                String strZzb2 = zzb(i13);
                try {
                    bArr6[i12] = MessageDigest.getInstance(strZzb2).digest(bArr7);
                } catch (NoSuchAlgorithmException e4) {
                    throw new RuntimeException(String.valueOf(strZzb2).concat(" digest not supported"), e4);
                }
            }
            return bArr6;
        }
        StringBuilder sb3 = new StringBuilder(37);
        sb3.append("Too many chunks: ");
        sb3.append(size);
        throw new DigestException(sb3.toString());
    }

    private static int zza(int i) {
        if (i == 513) {
            return 1;
        }
        if (i == 514) {
            return 2;
        }
        if (i == 769) {
            return 1;
        }
        switch (i) {
            case 257:
            case 259:
                return 1;
            case 258:
            case 260:
                return 2;
            default:
                String strValueOf = String.valueOf(Long.toHexString(i));
                throw new IllegalArgumentException(strValueOf.length() != 0 ? "Unknown signature algorithm: 0x".concat(strValueOf) : new String("Unknown signature algorithm: 0x"));
        }
    }

    private static ByteBuffer zza(ByteBuffer byteBuffer, int i, int i2) {
        if (i2 >= 8) {
            int iCapacity = byteBuffer.capacity();
            if (i2 <= byteBuffer.capacity()) {
                int iLimit = byteBuffer.limit();
                int iPosition = byteBuffer.position();
                try {
                    byteBuffer.position(0);
                    byteBuffer.limit(i2);
                    byteBuffer.position(8);
                    ByteBuffer byteBufferSlice = byteBuffer.slice();
                    byteBufferSlice.order(byteBuffer.order());
                    return byteBufferSlice;
                } finally {
                    byteBuffer.position(0);
                    byteBuffer.limit(iLimit);
                    byteBuffer.position(iPosition);
                }
            }
            StringBuilder sb = new StringBuilder(41);
            sb.append("end > capacity: ");
            sb.append(i2);
            sb.append(" > ");
            sb.append(iCapacity);
            throw new IllegalArgumentException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(38);
        sb2.append("end < start: ");
        sb2.append(i2);
        sb2.append(" < 8");
        throw new IllegalArgumentException(sb2.toString());
    }

    private static ByteBuffer zza(ByteBuffer byteBuffer, int i) throws BufferUnderflowException {
        if (i >= 0) {
            int iLimit = byteBuffer.limit();
            int iPosition = byteBuffer.position();
            int i2 = i + iPosition;
            if (i2 >= iPosition && i2 <= iLimit) {
                byteBuffer.limit(i2);
                try {
                    ByteBuffer byteBufferSlice = byteBuffer.slice();
                    byteBufferSlice.order(byteBuffer.order());
                    byteBuffer.position(i2);
                    return byteBufferSlice;
                } finally {
                    byteBuffer.limit(iLimit);
                }
            }
            throw new BufferUnderflowException();
        }
        StringBuilder sb = new StringBuilder(17);
        sb.append("size: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    private static ByteBuffer zza(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer.remaining() >= 4) {
            int i = byteBuffer.getInt();
            if (i >= 0) {
                if (i <= byteBuffer.remaining()) {
                    return zza(byteBuffer, i);
                }
                int iRemaining = byteBuffer.remaining();
                StringBuilder sb = new StringBuilder(101);
                sb.append("Length-prefixed field longer than remaining buffer. Field length: ");
                sb.append(i);
                sb.append(", remaining: ");
                sb.append(iRemaining);
                throw new IOException(sb.toString());
            }
            throw new IllegalArgumentException("Negative length");
        }
        int iRemaining2 = byteBuffer.remaining();
        StringBuilder sb2 = new StringBuilder(93);
        sb2.append("Remaining buffer too short to contain length of length-prefixed field. Remaining: ");
        sb2.append(iRemaining2);
        throw new IOException(sb2.toString());
    }

    private static void zza(int i, byte[] bArr, int i2) {
        bArr[1] = (byte) i;
        bArr[2] = (byte) (i >>> 8);
        bArr[3] = (byte) (i >>> 16);
        bArr[4] = (byte) (i >>> 24);
    }
}
