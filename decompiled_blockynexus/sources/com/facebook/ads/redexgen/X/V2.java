package com.facebook.ads.redexgen.X;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class V2 implements C6Y {
    public static String[] A02;
    public final /* synthetic */ V4 A00;
    public final /* synthetic */ List A01;

    static {
        A00();
    }

    public static void A00() {
        A02 = new String[]{"2ZaMFzGKyd9hSHjcUno1udsEhbeu09ce", "vtEgA47YqlpfzAewuy7ISaRlDIFsO2a2", "0pnteHQI04JELPJiiEYAY3M", "2nICVeqwE", "Lm6L6ti1RgkYKkQwD0idrMIu4GdN9z0L", "56JOKRJet", "nEp6Q7dVZjXWwne9d2QyLy7miVXBQb0l", "dXPHGnc4ncUJghGdDaugHzl"};
    }

    public V2(V4 v4, List list) {
        this.A00 = v4;
        this.A01 = list;
    }

    @Override // com.facebook.ads.redexgen.X.C6Y
    public final AbstractC14046n A58() {
        HashMap map = new HashMap();
        Iterator it = this.A01.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            String[] strArr = A02;
            if (strArr[2].length() == strArr[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[2] = "3z5KEoLDxtAdyJAxPBbZMV2";
            strArr2[5] = "xCESy1UOQ";
            if (zHasNext) {
                C6X c6x = (C6X) it.next();
                if (c6x.A02()) {
                    String strA07 = V4.A07((String) c6x.A01());
                    map.put(strA07, new V3(V4.A03(strA07)));
                }
            } else {
                return this.A00.A02(map);
            }
        }
    }
}
