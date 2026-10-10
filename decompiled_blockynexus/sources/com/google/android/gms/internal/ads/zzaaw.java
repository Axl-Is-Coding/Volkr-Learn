package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaaw {
    private final Collection<zzaaq<?>> zzclj = new ArrayList();
    private final Collection<zzaaq<String>> zzclk = new ArrayList();
    private final Collection<zzaaq<String>> zzcll = new ArrayList();

    public final void zza(zzaaq zzaaqVar) {
        this.zzclj.add(zzaaqVar);
    }

    public final void zzb(zzaaq<String> zzaaqVar) {
        this.zzclk.add(zzaaqVar);
    }

    public final void zzc(zzaaq<String> zzaaqVar) {
        this.zzcll.add(zzaaqVar);
    }

    public final List<String> zzrg() {
        ArrayList arrayList = new ArrayList();
        Iterator<zzaaq<String>> it = this.zzclk.iterator();
        while (it.hasNext()) {
            String str = (String) zzwm.zzpx().zzd(it.next());
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(str);
            }
        }
        arrayList.addAll(zzabg.zzrm());
        return arrayList;
    }

    public final List<String> zzrh() {
        List<String> listZzrg = zzrg();
        Iterator<zzaaq<String>> it = this.zzcll.iterator();
        while (it.hasNext()) {
            String str = (String) zzwm.zzpx().zzd(it.next());
            if (!TextUtils.isEmpty(str)) {
                listZzrg.add(str);
            }
        }
        listZzrg.addAll(zzabg.zzrn());
        return listZzrg;
    }

    public final void zza(SharedPreferences.Editor editor, int i, JSONObject jSONObject) {
        for (zzaaq<?> zzaaqVar : this.zzclj) {
            if (zzaaqVar.getSource() == 1) {
                zzaaqVar.zza(editor, zzaaqVar.zzb(jSONObject));
            }
        }
        if (jSONObject != null) {
            editor.putString("flag_configuration", jSONObject.toString());
        } else {
            zzbbq.zzfc("Flag Json is null.");
        }
    }
}
