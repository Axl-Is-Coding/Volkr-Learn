package com.twitter.sdk.android.tweetui;

import android.text.TextUtils;
import com.twitter.sdk.android.core.models.HashtagEntity;
import com.twitter.sdk.android.core.models.MediaEntity;
import com.twitter.sdk.android.core.models.MentionEntity;
import com.twitter.sdk.android.core.models.SymbolEntity;
import com.twitter.sdk.android.core.models.UrlEntity;
import com.twitter.sdk.android.tweetui.internal.a.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: TweetTextUtils.java */
/* JADX INFO: loaded from: classes5.dex */
final class K {
    static C2776n a(com.twitter.sdk.android.core.models.m mVar) {
        if (mVar == null) {
            return null;
        }
        C2776n c2776n = new C2776n();
        a(c2776n, mVar);
        b(c2776n, mVar);
        return c2776n;
    }

    static void b(C2776n c2776n, com.twitter.sdk.android.core.models.m mVar) {
        if (TextUtils.isEmpty(mVar.A)) {
            return;
        }
        a.d dVarB = com.twitter.sdk.android.tweetui.internal.a.a.f20390a.b(mVar.A);
        StringBuilder sb = new StringBuilder(dVarB.f20397a);
        b(c2776n.f20438b, dVarB.f20398b);
        b(c2776n.f20439c, dVarB.f20398b);
        b(c2776n.f20440d, dVarB.f20398b);
        b(c2776n.f20441e, dVarB.f20398b);
        b(c2776n.f20442f, dVarB.f20398b);
        a(sb, c2776n);
        c2776n.f20437a = sb.toString();
    }

    static void a(C2776n c2776n, com.twitter.sdk.android.core.models.m mVar) {
        com.twitter.sdk.android.core.models.o oVar = mVar.f20241d;
        if (oVar == null) {
            return;
        }
        List<UrlEntity> list = oVar.f20251b;
        if (list != null) {
            Iterator<UrlEntity> it = list.iterator();
            while (it.hasNext()) {
                c2776n.f20438b.add(o.a(it.next()));
            }
        }
        List<MediaEntity> list2 = mVar.f20241d.f20253d;
        if (list2 != null) {
            Iterator<MediaEntity> it2 = list2.iterator();
            while (it2.hasNext()) {
                c2776n.f20439c.add(new C2775m(it2.next()));
            }
        }
        List<HashtagEntity> list3 = mVar.f20241d.f20254e;
        if (list3 != null) {
            Iterator<HashtagEntity> it3 = list3.iterator();
            while (it3.hasNext()) {
                c2776n.f20440d.add(o.a(it3.next()));
            }
        }
        List<MentionEntity> list4 = mVar.f20241d.f20252c;
        if (list4 != null) {
            Iterator<MentionEntity> it4 = list4.iterator();
            while (it4.hasNext()) {
                c2776n.f20441e.add(o.a(it4.next()));
            }
        }
        List<SymbolEntity> list5 = mVar.f20241d.f20255f;
        if (list5 != null) {
            Iterator<SymbolEntity> it5 = list5.iterator();
            while (it5.hasNext()) {
                c2776n.f20442f.add(o.a(it5.next()));
            }
        }
    }

    static void b(List<? extends o> list, List<int[]> list2) {
        if (list == null || list2 == null || list2.isEmpty()) {
            return;
        }
        int size = list2.size();
        int i = 0;
        int i2 = 0;
        for (o oVar : list) {
            int i3 = i;
            int i4 = 0;
            while (i < size) {
                int[] iArr = list2.get(i);
                int i5 = iArr[0];
                int i6 = iArr[1];
                int i7 = i6 - i5;
                if (i6 < oVar.f20443a) {
                    i2 += i7;
                    i3++;
                } else if (i6 < oVar.f20444b) {
                    i4 += i7;
                }
                i++;
            }
            int i8 = i4 + i2;
            oVar.f20443a -= i8;
            oVar.f20444b -= i8;
            i = i3;
        }
    }

    static void a(StringBuilder sb, C2776n c2776n) {
        ArrayList arrayList = new ArrayList();
        int length = sb.length() - 1;
        for (int i = 0; i < length; i++) {
            if (Character.isHighSurrogate(sb.charAt(i)) && Character.isLowSurrogate(sb.charAt(i + 1))) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        a(c2776n.f20438b, arrayList);
        a(c2776n.f20439c, arrayList);
        a(c2776n.f20440d, arrayList);
        a(c2776n.f20441e, arrayList);
        a(c2776n.f20442f, arrayList);
    }

    static void a(List<? extends o> list, List<Integer> list2) {
        if (list == null || list2 == null) {
            return;
        }
        for (o oVar : list) {
            int i = oVar.f20443a;
            int i2 = 0;
            Iterator<Integer> it = list2.iterator();
            while (it.hasNext() && it.next().intValue() - i2 <= i) {
                i2++;
            }
            oVar.f20443a += i2;
            oVar.f20444b += i2;
        }
    }
}
