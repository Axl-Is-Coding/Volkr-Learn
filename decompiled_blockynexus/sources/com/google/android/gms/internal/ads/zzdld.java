package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbqo;
import com.google.android.gms.internal.ads.zzbtn;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdld<R extends zzbtn<AdT>, AdT extends zzbqo> implements zzdqv<AdT> {
    private final zzdlv<R, zzdqk<AdT>> zzhbt;

    public zzdld(zzdlv<R, zzdqk<AdT>> zzdlvVar) {
        this.zzhbt = zzdlvVar;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.ads.zzdqv
    public final zzdzc<zzdqk<AdT>> zza(zzdqy zzdqyVar) {
        zzdlc zzdlcVar = (zzdlc) zzdqyVar;
        return this.zzhbt.zza(zzdlcVar.zzhbr, zzdlcVar.zzhbq);
    }

    @Override // com.google.android.gms.internal.ads.zzdqv
    public final void zzb(Throwable th) {
    }

    @Override // com.google.android.gms.internal.ads.zzdqv
    public final void zza(zzdqk<AdT> zzdqkVar) {
        zzdqkVar.zzhiq = this.zzhbt.zzasv().zzaev();
    }
}
