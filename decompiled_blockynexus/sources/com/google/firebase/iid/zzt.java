package com.google.firebase.iid;

import android.os.Bundle;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
final class zzt implements Continuation<Bundle, String> {
    private final /* synthetic */ zzs zzbs;

    zzt(zzs zzsVar) {
        this.zzbs = zzsVar;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ String then(Task<Bundle> task) throws Exception {
        Bundle result = task.getResult(IOException.class);
        zzs zzsVar = this.zzbs;
        return zzs.zza(result);
    }
}
