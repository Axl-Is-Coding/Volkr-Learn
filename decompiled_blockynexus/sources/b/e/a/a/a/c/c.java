package b.e.a.a.a.c;

import android.view.View;
import b.e.a.a.a.c.a;
import b.e.a.a.a.d.f;
import com.iab.omid.library.ironsrc.adsession.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f2574a;

    public c(a aVar) {
        this.f2574a = aVar;
    }

    ArrayList<View> a() {
        View rootView;
        ArrayList<View> arrayList = new ArrayList<>();
        b.e.a.a.a.b.a aVarA = b.e.a.a.a.b.a.a();
        if (aVarA != null) {
            Collection<g> collectionC = aVarA.c();
            IdentityHashMap identityHashMap = new IdentityHashMap((collectionC.size() * 2) + 3);
            Iterator<g> it = collectionC.iterator();
            while (it.hasNext()) {
                View viewE = it.next().e();
                if (viewE != null && f.c(viewE) && (rootView = viewE.getRootView()) != null && !identityHashMap.containsKey(rootView)) {
                    identityHashMap.put(rootView, rootView);
                    float fA = f.a(rootView);
                    int size = arrayList.size();
                    while (size > 0 && f.a(arrayList.get(size - 1)) > fA) {
                        size--;
                    }
                    arrayList.add(size, rootView);
                }
            }
        }
        return arrayList;
    }

    @Override // b.e.a.a.a.c.a
    public JSONObject a(View view) {
        return b.e.a.a.a.d.b.a(0, 0, 0, 0);
    }

    @Override // b.e.a.a.a.c.a
    public void a(View view, JSONObject jSONObject, a.InterfaceC0040a interfaceC0040a, boolean z) {
        Iterator<View> it = a().iterator();
        while (it.hasNext()) {
            interfaceC0040a.a(it.next(), this.f2574a, jSONObject);
        }
    }
}
