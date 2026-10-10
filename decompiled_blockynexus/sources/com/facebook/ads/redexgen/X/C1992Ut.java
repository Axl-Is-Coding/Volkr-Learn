package com.facebook.ads.redexgen.X;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ut, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1992Ut implements C6Y {
    public static String[] A02;
    public final /* synthetic */ C1994Uv A00;
    public final /* synthetic */ List A01;

    static {
        A00();
    }

    public static void A00() {
        A02 = new String[]{"IDUzbTXfLYpZDU4pK2kXQil8tMhG7RY8", "Z5d5k39m9crHDopO6AEw9f8SoKMTT7ix", "IveabQPx2elzsPaafQdxf", "DTCFkmk3oZJb2r35tHvEOgJ8FwtFSJKN", "oJAEAa909Y4vXdHyK3IPvCd4oyzp37cQ", "4smqyHOTFll606jIQbjCa", "GdFqyjY9JjKZ3ZH3Nsuny0jnLefl3EYG", "u7DTPzY4ZnL64vf2BaZ33uVh1ryYgEua"};
    }

    public C1992Ut(C1994Uv c1994Uv, List list) {
        this.A00 = c1994Uv;
        this.A01 = list;
    }

    @Override // com.facebook.ads.redexgen.X.C6Y
    public final AbstractC14046n A58() {
        HashMap map = new HashMap();
        Iterator it = this.A01.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            String[] strArr = A02;
            if (strArr[1].charAt(13) == strArr[7].charAt(13)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[1] = "Um1XGSBPp3z3NkeiC1bP7QkPe7DiDluX";
            strArr2[7] = "6eK8uyM5uh6d0JMEhPLz83VmKAM97iIF";
            if (zHasNext) {
                C6X c6x = (C6X) it.next();
                if (c6x.A02()) {
                    String str = (String) c6x.A01();
                    map.put(str, new C1993Uu(str));
                }
            } else {
                return this.A00.A03(map);
            }
        }
    }
}
