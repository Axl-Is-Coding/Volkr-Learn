package c.t.m.g;

import android.os.Bundle;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public final class Oa implements Ma {
    @Override // c.t.m.g.Ma
    public final Bundle a(String str, byte[] bArr, La la) {
        Bundle bundle = new Bundle();
        Na na = new Na(this, bundle, la);
        if (bArr == null) {
            bArr = Ta.f3014a;
        }
        Ya.a(str, bArr, 0, na);
        return bundle;
    }
}
