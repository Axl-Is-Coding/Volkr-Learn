package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzjn implements Parcelable, Comparator<zza> {
    public static final Parcelable.Creator<zzjn> CREATOR = new zzjm();
    private int zzahv;
    private final zza[] zzaok;
    public final int zzaol;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    public static final class zza implements Parcelable {
        public static final Parcelable.Creator<zza> CREATOR = new zzjo();
        private final byte[] data;
        private final String mimeType;
        private final UUID uuid;
        private int zzahv;
        public final boolean zzaom;

        public zza(UUID uuid, String str, byte[] bArr) {
            this(uuid, str, bArr, false);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            zza zzaVar = (zza) obj;
            return this.mimeType.equals(zzaVar.mimeType) && zzpq.zza(this.uuid, zzaVar.uuid) && Arrays.equals(this.data, zzaVar.data);
        }

        public final int hashCode() {
            if (this.zzahv == 0) {
                this.zzahv = (((this.uuid.hashCode() * 31) + this.mimeType.hashCode()) * 31) + Arrays.hashCode(this.data);
            }
            return this.zzahv;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.uuid.getMostSignificantBits());
            parcel.writeLong(this.uuid.getLeastSignificantBits());
            parcel.writeString(this.mimeType);
            parcel.writeByteArray(this.data);
            parcel.writeByte(this.zzaom ? (byte) 1 : (byte) 0);
        }

        private zza(UUID uuid, String str, byte[] bArr, boolean z) {
            zzoz.checkNotNull(uuid);
            this.uuid = uuid;
            zzoz.checkNotNull(str);
            this.mimeType = str;
            zzoz.checkNotNull(bArr);
            this.data = bArr;
            this.zzaom = false;
        }

        zza(Parcel parcel) {
            this.uuid = new UUID(parcel.readLong(), parcel.readLong());
            this.mimeType = parcel.readString();
            this.data = parcel.createByteArray();
            this.zzaom = parcel.readByte() != 0;
        }
    }

    public zzjn(List<zza> list) {
        this(false, (zza[]) list.toArray(new zza[list.size()]));
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zza zzaVar, zza zzaVar2) {
        zza zzaVar3 = zzaVar;
        zza zzaVar4 = zzaVar2;
        return zzha.UUID_NIL.equals(zzaVar3.uuid) ? zzha.UUID_NIL.equals(zzaVar4.uuid) ? 0 : 1 : zzaVar3.uuid.compareTo(zzaVar4.uuid);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzjn.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.zzaok, ((zzjn) obj).zzaok);
    }

    public final int hashCode() {
        if (this.zzahv == 0) {
            this.zzahv = Arrays.hashCode(this.zzaok);
        }
        return this.zzahv;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.zzaok, 0);
    }

    public final zza zzag(int i) {
        return this.zzaok[i];
    }

    public zzjn(zza... zzaVarArr) {
        this(true, zzaVarArr);
    }

    private zzjn(boolean z, zza... zzaVarArr) {
        zzaVarArr = z ? (zza[]) zzaVarArr.clone() : zzaVarArr;
        Arrays.sort(zzaVarArr, this);
        for (int i = 1; i < zzaVarArr.length; i++) {
            if (zzaVarArr[i - 1].uuid.equals(zzaVarArr[i].uuid)) {
                String strValueOf = String.valueOf(zzaVarArr[i].uuid);
                StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 25);
                sb.append("Duplicate data for uuid: ");
                sb.append(strValueOf);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        this.zzaok = zzaVarArr;
        this.zzaol = zzaVarArr.length;
    }

    zzjn(Parcel parcel) {
        this.zzaok = (zza[]) parcel.createTypedArray(zza.CREATOR);
        this.zzaol = this.zzaok.length;
    }
}
