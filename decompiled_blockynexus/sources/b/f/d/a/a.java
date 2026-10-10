package b.f.d.a;

import com.ironsource.sdk.utils.i;
import java.util.HashMap;

/* JADX INFO: compiled from: ISNEventParams.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<String, Object> f2626a = new HashMap<>();

    public HashMap<String, Object> a() {
        return this.f2626a;
    }

    public a a(String str, Object obj) {
        if (obj != null) {
            this.f2626a.put(str, i.b(obj.toString()));
        }
        return this;
    }
}
