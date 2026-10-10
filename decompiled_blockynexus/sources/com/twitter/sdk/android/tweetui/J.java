package com.twitter.sdk.android.tweetui;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.facebook.internal.AnalyticsEvents;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: TweetTextLinkifier.java */
/* JADX INFO: loaded from: classes5.dex */
final class J {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Pattern f20342a = Pattern.compile("^https?://twitter\\.com(/#!)?/\\w+/status/\\d+$");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final Pattern f20343b = Pattern.compile("^https?://vine\\.co(/#!)?/v/\\w+$");

    static CharSequence a(C2776n c2776n, s sVar, int i, int i2, boolean z, boolean z2) {
        if (c2776n == null) {
            return null;
        }
        if (TextUtils.isEmpty(c2776n.f20437a)) {
            return c2776n.f20437a;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(c2776n.f20437a);
        List<o> listA = a(com.twitter.sdk.android.core.models.i.a(c2776n.f20438b), com.twitter.sdk.android.core.models.i.a(c2776n.f20439c), com.twitter.sdk.android.core.models.i.a(c2776n.f20440d), com.twitter.sdk.android.core.models.i.a(c2776n.f20441e), com.twitter.sdk.android.core.models.i.a(c2776n.f20442f));
        a(spannableStringBuilder, listA, a(c2776n.f20437a, listA, z, z2), sVar, i, i2);
        return a(spannableStringBuilder);
    }

    static boolean b(o oVar) {
        return f20342a.matcher(oVar.f20447e).find();
    }

    static boolean c(o oVar) {
        return f20343b.matcher(oVar.f20447e).find();
    }

    static CharSequence a(CharSequence charSequence) {
        int length = charSequence.length();
        while (length > 0 && charSequence.charAt(length - 1) <= ' ') {
            length--;
        }
        return length < charSequence.length() ? charSequence.subSequence(0, length) : charSequence;
    }

    static List<o> a(List<o> list, List<C2775m> list2, List<o> list3, List<o> list4, List<o> list5) {
        ArrayList arrayList = new ArrayList(list);
        arrayList.addAll(list2);
        arrayList.addAll(list3);
        arrayList.addAll(list4);
        arrayList.addAll(list5);
        Collections.sort(arrayList, new Comparator() { // from class: com.twitter.sdk.android.tweetui.j
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return J.a((o) obj, (o) obj2);
            }
        });
        return arrayList;
    }

    static /* synthetic */ int a(o oVar, o oVar2) {
        if (oVar == null && oVar2 != null) {
            return -1;
        }
        if (oVar != null && oVar2 == null) {
            return 1;
        }
        if (oVar == null && oVar2 == null) {
            return 0;
        }
        int i = oVar.f20443a;
        int i2 = oVar2.f20443a;
        if (i < i2) {
            return -1;
        }
        return i > i2 ? 1 : 0;
    }

    private static void a(SpannableStringBuilder spannableStringBuilder, List<o> list, o oVar, final s sVar, final int i, final int i2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int i3 = 0;
        for (final o oVar2 : list) {
            int i4 = oVar2.f20443a - i3;
            int i5 = oVar2.f20444b - i3;
            if (i4 >= 0 && i5 <= spannableStringBuilder.length()) {
                if (oVar != null && oVar.f20443a == oVar2.f20443a) {
                    spannableStringBuilder.replace(i4, i5, "");
                    i3 += i5 - i4;
                } else if (!TextUtils.isEmpty(oVar2.f20445c)) {
                    spannableStringBuilder.replace(i4, i5, (CharSequence) oVar2.f20445c);
                    int length = i5 - (oVar2.f20445c.length() + i4);
                    i3 += length;
                    final boolean z = false;
                    spannableStringBuilder.setSpan(new com.twitter.sdk.android.tweetui.internal.g(i2, i, z) { // from class: com.twitter.sdk.android.tweetui.TweetTextLinkifier$1
                        @Override // android.text.style.ClickableSpan, com.twitter.sdk.android.tweetui.internal.HighlightedClickableSpan
                        public void onClick(View view) {
                            s sVar2 = sVar;
                            if (sVar2 == null) {
                                return;
                            }
                            sVar2.a(oVar2.f20446d);
                        }
                    }, i4, i5 - length, 33);
                }
            }
        }
    }

    static o a(String str, List<o> list, boolean z, boolean z2) {
        if (list.isEmpty()) {
            return null;
        }
        o oVar = list.get(list.size() - 1);
        if (a(str).endsWith(oVar.f20446d) && (a(oVar) || ((z && b(oVar)) || (z2 && c(oVar))))) {
            return oVar;
        }
        return null;
    }

    static String a(String str) {
        return str.endsWith(Character.toString((char) 8206)) ? str.substring(0, str.length() - 1) : str;
    }

    static boolean a(o oVar) {
        return (oVar instanceof C2775m) && AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO.equals(((C2775m) oVar).f20436f);
    }
}
