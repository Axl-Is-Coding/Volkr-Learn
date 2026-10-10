package com.iab.omid.library.ironsrc.walking.a;

import android.text.TextUtils;
import com.iab.omid.library.ironsrc.adsession.g;
import com.iab.omid.library.ironsrc.walking.a.b;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class f extends a {
    public f(b.InterfaceC0141b interfaceC0141b, HashSet<String> hashSet, JSONObject jSONObject, long j) {
        super(interfaceC0141b, hashSet, jSONObject, j);
    }

    private void b(String str) {
        b.e.a.a.a.b.a aVarA = b.e.a.a.a.b.a.a();
        if (aVarA != null) {
            for (g gVar : aVarA.b()) {
                if (this.f14560c.contains(gVar.i())) {
                    gVar.j().a(str, this.f14562e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public String doInBackground(Object... objArr) {
        if (b.e.a.a.a.d.b.b(this.f14561d, this.f14564b.b())) {
            return null;
        }
        this.f14564b.a(this.f14561d);
        return this.f14561d.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.iab.omid.library.ironsrc.walking.a.b, android.os.AsyncTask
    /* JADX INFO: renamed from: a */
    public void onPostExecute(String str) {
        if (!TextUtils.isEmpty(str)) {
            b(str);
        }
        super.onPostExecute(str);
    }
}
