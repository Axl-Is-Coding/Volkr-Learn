package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzeoi implements zzbs, Closeable, Iterator<zzbp> {
    protected zzeok zzitt;
    protected zzbo zzitx;
    private static final zzbp zzitw = new zzeoh("eof ");
    private static zzeoq zzdc = zzeoq.zzn(zzeoi.class);
    private zzbp zzity = null;
    long zzitz = 0;
    long zzbgl = 0;
    long zzawj = 0;
    private List<zzbp> zziua = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.Iterator
    /* JADX INFO: renamed from: zzbkh, reason: merged with bridge method [inline-methods] */
    public final zzbp next() {
        zzbp zzbpVarZza;
        zzbp zzbpVar = this.zzity;
        if (zzbpVar != null && zzbpVar != zzitw) {
            this.zzity = null;
            return zzbpVar;
        }
        zzeok zzeokVar = this.zzitt;
        if (zzeokVar == null || this.zzitz >= this.zzawj) {
            this.zzity = zzitw;
            throw new NoSuchElementException();
        }
        try {
            synchronized (zzeokVar) {
                this.zzitt.zzfc(this.zzitz);
                zzbpVarZza = this.zzitx.zza(this.zzitt, this);
                this.zzitz = this.zzitt.position();
            }
            return zzbpVarZza;
        } catch (EOFException unused) {
            throw new NoSuchElementException();
        } catch (IOException unused2) {
            throw new NoSuchElementException();
        }
    }

    public void close() throws IOException {
        this.zzitt.close();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        zzbp zzbpVar = this.zzity;
        if (zzbpVar == zzitw) {
            return false;
        }
        if (zzbpVar != null) {
            return true;
        }
        try {
            this.zzity = (zzbp) next();
            return true;
        } catch (NoSuchElementException unused) {
            this.zzity = zzitw;
            return false;
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        for (int i = 0; i < this.zziua.size(); i++) {
            if (i > 0) {
                sb.append(";");
            }
            sb.append(this.zziua.get(i).toString());
        }
        sb.append("]");
        return sb.toString();
    }

    public void zza(zzeok zzeokVar, long j, zzbo zzboVar) throws IOException {
        this.zzitt = zzeokVar;
        long jPosition = zzeokVar.position();
        this.zzbgl = jPosition;
        this.zzitz = jPosition;
        zzeokVar.zzfc(zzeokVar.position() + j);
        this.zzawj = zzeokVar.position();
        this.zzitx = zzboVar;
    }

    public final List<zzbp> zzbkg() {
        return (this.zzitt == null || this.zzity == zzitw) ? this.zziua : new zzeoo(this.zziua, this);
    }
}
