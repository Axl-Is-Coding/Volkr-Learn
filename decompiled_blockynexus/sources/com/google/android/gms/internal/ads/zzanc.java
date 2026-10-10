package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.ads.mediation.b;
import com.google.ads.mediation.d;
import com.google.android.ads.mediationtestsuite.dataobjects.AdUnit;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.mediation.customevent.CustomEventAdapter;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzanc extends zzane {
    private static final zzapn zzdld = new zzapn();
    private Map<Class<? extends NetworkExtras>, NetworkExtras> zzdlc;

    private final <NetworkExtrasT extends d, ServerParametersT extends MediationServerParameters> zzang zzdl(String str) throws RemoteException {
        try {
            Class<?> cls = Class.forName(str, false, zzanc.class.getClassLoader());
            if (b.class.isAssignableFrom(cls)) {
                b bVar = (b) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                return new zzaof(bVar, (d) this.zzdlc.get(bVar.getAdditionalParametersType()));
            }
            if (MediationAdapter.class.isAssignableFrom(cls)) {
                return new zzanx((MediationAdapter) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            }
            if (Adapter.class.isAssignableFrom(cls)) {
                return new zzanx((Adapter) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            }
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 64);
            sb.append("Could not instantiate mediation adapter: ");
            sb.append(str);
            sb.append(" (not a valid adapter).");
            zzbbq.zzfe(sb.toString());
            throw new RemoteException();
        } catch (Throwable unused) {
            return zzdm(str);
        }
    }

    private final zzang zzdm(String str) throws RemoteException {
        try {
            zzbbq.zzef("Reflection failed, retrying using direct instantiation");
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 43);
            sb.append("Could not instantiate mediation adapter: ");
            sb.append(str);
            sb.append(". ");
            zzbbq.zzd(sb.toString(), th);
        }
        if (AdUnit.GOOGLE_ADAPTER_CLASS.equals(str)) {
            return new zzanx(new AdMobAdapter());
        }
        if ("com.google.ads.mediation.AdUrlAdapter".equals(str)) {
            return new zzanx(new AdUrlAdapter());
        }
        if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            return new zzanx(new CustomEventAdapter());
        }
        if (AdUnit.CUSTOM_EVENT_ADAPTER_CLASS.equals(str)) {
            com.google.ads.mediation.customevent.CustomEventAdapter customEventAdapter = new com.google.ads.mediation.customevent.CustomEventAdapter();
            return new zzaof(customEventAdapter, (CustomEventExtras) this.zzdlc.get(customEventAdapter.getAdditionalParametersType()));
        }
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzanb
    public final zzang zzdi(String str) throws RemoteException {
        return zzdl(str);
    }

    @Override // com.google.android.gms.internal.ads.zzanb
    public final boolean zzdj(String str) throws RemoteException {
        try {
            return CustomEvent.class.isAssignableFrom(Class.forName(str, false, zzanc.class.getClassLoader()));
        } catch (Throwable unused) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 80);
            sb.append("Could not load custom event implementation class: ");
            sb.append(str);
            sb.append(", assuming old implementation.");
            zzbbq.zzfe(sb.toString());
            return false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzanb
    public final zzaph zzdk(String str) throws RemoteException {
        return zzapn.zzdt(str);
    }

    public final void zzf(Map<Class<? extends NetworkExtras>, NetworkExtras> map) {
        this.zzdlc = map;
    }
}
