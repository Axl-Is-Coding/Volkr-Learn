package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcjg extends zzbqo {
    private final zzaux zzdwc;
    private final WeakReference<zzbgj> zzfwr;
    private final zzbzp zzfws;
    private final zzbrh zzfwt;
    private final zzdtn zzfwu;
    private final zzbuk zzfwv;
    private final zzccm zzfww;
    private boolean zzgeb;
    private final zzbvv zzges;
    private final Context zzvr;

    zzcjg(zzbqn zzbqnVar, Context context, zzbgj zzbgjVar, zzccm zzccmVar, zzbzp zzbzpVar, zzbuk zzbukVar, zzbvv zzbvvVar, zzbrh zzbrhVar, zzdnv zzdnvVar, zzdtn zzdtnVar) {
        super(zzbqnVar);
        this.zzgeb = false;
        this.zzvr = context;
        this.zzfww = zzccmVar;
        this.zzfwr = new WeakReference<>(zzbgjVar);
        this.zzfws = zzbzpVar;
        this.zzfwv = zzbukVar;
        this.zzges = zzbvvVar;
        this.zzfwt = zzbrhVar;
        this.zzfwu = zzdtnVar;
        this.zzdwc = new zzavu(zzdnvVar.zzdtc);
    }

    public final void finalize() throws Throwable {
        try {
            zzbgj zzbgjVar = this.zzfwr.get();
            if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcxj)).booleanValue()) {
                if (!this.zzgeb && zzbgjVar != null) {
                    zzdzb zzdzbVar = zzbbz.zzeet;
                    zzbgjVar.getClass();
                    zzdzbVar.execute(zzcjf.zzh(zzbgjVar));
                }
            } else if (zzbgjVar != null) {
                zzbgjVar.destroy();
            }
        } finally {
            super.finalize();
        }
    }

    public final Bundle getAdMetadata() {
        return this.zzges.getAdMetadata();
    }

    public final boolean isClosed() {
        return this.zzfwt.isClosed();
    }

    public final boolean zzanu() {
        return this.zzgeb;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final boolean zzb(boolean z, Activity activity) {
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcnz)).booleanValue()) {
            com.google.android.gms.ads.internal.zzp.zzkr();
            if (zzayu.zzav(this.zzvr)) {
                zzbbq.zzfe("Rewarded ads that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit https://googlemobileadssdk.page.link/admob-interstitial-policies");
                this.zzfwv.zzajw();
                if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcoa)).booleanValue()) {
                    this.zzfwu.zzhc(this.zzfmw.zzhew.zzeou.zzdtb);
                }
                return false;
            }
        }
        if (this.zzgeb) {
            zzbbq.zzfe("The rewarded ad have been showed.");
            this.zzfwv.zzl(zzdpe.zza(zzdpg.AD_REUSED, null, null));
            return false;
        }
        this.zzgeb = true;
        this.zzfws.zzajl();
        Context context = activity;
        if (activity == null) {
            context = this.zzvr;
        }
        try {
            this.zzfww.zza(z, context);
            this.zzfws.zzajj();
            return true;
        } catch (zzccl e2) {
            this.zzfwv.zza(e2);
            return false;
        }
    }

    public final zzaux zzqz() {
        return this.zzdwc;
    }

    public final boolean zzra() {
        zzbgj zzbgjVar = this.zzfwr.get();
        return (zzbgjVar == null || zzbgjVar.zzacl()) ? false : true;
    }
}
