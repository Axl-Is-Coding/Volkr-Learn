package org.apache.commons.compress.archivers.a;

/* JADX INFO: compiled from: TarUtils.java */
/* JADX INFO: loaded from: classes5.dex */
class e implements org.apache.commons.compress.archivers.zip.d {
    e() {
    }

    @Override // org.apache.commons.compress.archivers.zip.d
    public String decode(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length);
        for (byte b2 : bArr) {
            if (b2 == 0) {
                break;
            }
            sb.append((char) (b2 & 255));
        }
        return sb.toString();
    }
}
