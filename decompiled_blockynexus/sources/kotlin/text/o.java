package kotlin.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: Strings.kt */
/* JADX INFO: loaded from: classes5.dex */
public class o extends n {
    public static final int b(CharSequence charSequence, char[] cArr, int i, boolean z) {
        kotlin.jvm.internal.i.b(charSequence, "$this$lastIndexOfAny");
        kotlin.jvm.internal.i.b(cArr, "chars");
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(kotlin.collections.i.a(cArr), i);
        }
        for (int iB = kotlin.d.h.b(i, a(charSequence)); iB >= 0; iB--) {
            char cCharAt = charSequence.charAt(iB);
            int length = cArr.length;
            boolean z2 = false;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (b.a(cArr[i2], cCharAt, z)) {
                    z2 = true;
                    break;
                }
                i2++;
            }
            if (z2) {
                return iB;
            }
        }
        return -1;
    }

    public static final int a(CharSequence charSequence) {
        kotlin.jvm.internal.i.b(charSequence, "$this$lastIndex");
        return charSequence.length() - 1;
    }

    public static final String a(CharSequence charSequence, kotlin.d.d dVar) {
        kotlin.jvm.internal.i.b(charSequence, "$this$substring");
        kotlin.jvm.internal.i.b(dVar, "range");
        return charSequence.subSequence(dVar.f().intValue(), dVar.e().intValue() + 1).toString();
    }

    public static final boolean a(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, boolean z) {
        kotlin.jvm.internal.i.b(charSequence, "$this$regionMatchesImpl");
        kotlin.jvm.internal.i.b(charSequence2, "other");
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > charSequence2.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!b.a(charSequence.charAt(i + i4), charSequence2.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    public static final int a(CharSequence charSequence, char[] cArr, int i, boolean z) {
        boolean z2;
        kotlin.jvm.internal.i.b(charSequence, "$this$indexOfAny");
        kotlin.jvm.internal.i.b(cArr, "chars");
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(kotlin.collections.i.a(cArr), i);
        }
        int iA = kotlin.d.h.a(i, 0);
        int iA2 = a(charSequence);
        if (iA > iA2) {
            return -1;
        }
        while (true) {
            char cCharAt = charSequence.charAt(iA);
            int length = cArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z2 = false;
                    break;
                }
                if (b.a(cArr[i2], cCharAt, z)) {
                    z2 = true;
                    break;
                }
                i2++;
            }
            if (z2) {
                return iA;
            }
            if (iA == iA2) {
                return -1;
            }
            iA++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair<Integer, String> b(CharSequence charSequence, Collection<String> collection, int i, boolean z, boolean z2) {
        Object next;
        Object next2;
        if (!z && collection.size() == 1) {
            String str = (String) kotlin.collections.k.a((Iterable) collection);
            int iA = !z2 ? a(charSequence, str, i, false, 4, (Object) null) : b(charSequence, str, i, false, 4, (Object) null);
            if (iA < 0) {
                return null;
            }
            return kotlin.j.a(Integer.valueOf(iA), str);
        }
        kotlin.d.b dVar = !z2 ? new kotlin.d.d(kotlin.d.h.a(i, 0), charSequence.length()) : kotlin.d.h.c(kotlin.d.h.b(i, a(charSequence)), 0);
        if (charSequence instanceof String) {
            int first = dVar.getFirst();
            int last = dVar.getLast();
            int iA2 = dVar.a();
            if (iA2 < 0 ? first >= last : first <= last) {
                while (true) {
                    Iterator<T> it = collection.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it.next();
                        String str2 = (String) next2;
                        if (n.a(str2, 0, (String) charSequence, first, str2.length(), z)) {
                            break;
                        }
                    }
                    String str3 = (String) next2;
                    if (str3 == null) {
                        if (first == last) {
                            break;
                        }
                        first += iA2;
                    } else {
                        return kotlin.j.a(Integer.valueOf(first), str3);
                    }
                }
            }
        } else {
            int first2 = dVar.getFirst();
            int last2 = dVar.getLast();
            int iA3 = dVar.a();
            if (iA3 < 0 ? first2 >= last2 : first2 <= last2) {
                while (true) {
                    Iterator<T> it2 = collection.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it2.next();
                        String str4 = (String) next;
                        if (a(str4, 0, charSequence, first2, str4.length(), z)) {
                            break;
                        }
                    }
                    String str5 = (String) next;
                    if (str5 == null) {
                        if (first2 == last2) {
                            break;
                        }
                        first2 += iA3;
                    } else {
                        return kotlin.j.a(Integer.valueOf(first2), str5);
                    }
                }
            }
        }
        return null;
    }

    static /* synthetic */ int a(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        return a(charSequence, charSequence2, i, i2, z, (i3 & 16) != 0 ? false : z2);
    }

    private static final int a(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        kotlin.d.b bVarC;
        if (!z2) {
            bVarC = new kotlin.d.d(kotlin.d.h.a(i, 0), kotlin.d.h.b(i2, charSequence.length()));
        } else {
            bVarC = kotlin.d.h.c(kotlin.d.h.b(i, a(charSequence)), kotlin.d.h.a(i2, 0));
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int first = bVarC.getFirst();
            int last = bVarC.getLast();
            int iA = bVarC.a();
            if (iA >= 0) {
                if (first > last) {
                    return -1;
                }
            } else if (first < last) {
                return -1;
            }
            while (!n.a((String) charSequence2, 0, (String) charSequence, first, charSequence2.length(), z)) {
                if (first == last) {
                    return -1;
                }
                first += iA;
            }
            return first;
        }
        int first2 = bVarC.getFirst();
        int last2 = bVarC.getLast();
        int iA2 = bVarC.a();
        if (iA2 >= 0) {
            if (first2 > last2) {
                return -1;
            }
        } else if (first2 < last2) {
            return -1;
        }
        while (!a(charSequence2, 0, charSequence, first2, charSequence2.length(), z)) {
            if (first2 == last2) {
                return -1;
            }
            first2 += iA2;
        }
        return first2;
    }

    public static /* synthetic */ int a(CharSequence charSequence, char c2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return a(charSequence, c2, i, z);
    }

    public static final int a(CharSequence charSequence, char c2, int i, boolean z) {
        kotlin.jvm.internal.i.b(charSequence, "$this$indexOf");
        return (z || !(charSequence instanceof String)) ? a(charSequence, new char[]{c2}, i, z) : ((String) charSequence).indexOf(c2, i);
    }

    public static /* synthetic */ int b(CharSequence charSequence, char c2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = a(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return b(charSequence, c2, i, z);
    }

    public static final int b(CharSequence charSequence, char c2, int i, boolean z) {
        kotlin.jvm.internal.i.b(charSequence, "$this$lastIndexOf");
        return (z || !(charSequence instanceof String)) ? b(charSequence, new char[]{c2}, i, z) : ((String) charSequence).lastIndexOf(c2, i);
    }

    public static /* synthetic */ int a(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return a(charSequence, str, i, z);
    }

    public static final int a(CharSequence charSequence, String str, int i, boolean z) {
        kotlin.jvm.internal.i.b(charSequence, "$this$indexOf");
        kotlin.jvm.internal.i.b(str, "string");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(str, i);
        }
        return a(charSequence, str, i, charSequence.length(), z, false, 16, null);
    }

    public static /* synthetic */ int b(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = a(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return b(charSequence, str, i, z);
    }

    public static final int b(CharSequence charSequence, String str, int i, boolean z) {
        kotlin.jvm.internal.i.b(charSequence, "$this$lastIndexOf");
        kotlin.jvm.internal.i.b(str, "string");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(str, i);
        }
        return a(charSequence, (CharSequence) str, i, 0, z, true);
    }

    public static /* synthetic */ boolean a(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return a(charSequence, charSequence2, z);
    }

    public static final boolean a(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        kotlin.jvm.internal.i.b(charSequence, "$this$contains");
        kotlin.jvm.internal.i.b(charSequence2, "other");
        if (charSequence2 instanceof String) {
            if (a(charSequence, (String) charSequence2, 0, z, 2, (Object) null) >= 0) {
                return true;
            }
        } else if (a(charSequence, charSequence2, 0, charSequence.length(), z, false, 16, null) >= 0) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ kotlin.e.a b(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return b(charSequence, strArr, z, i);
    }

    public static final kotlin.e.a<String> b(final CharSequence charSequence, String[] strArr, boolean z, int i) {
        kotlin.jvm.internal.i.b(charSequence, "$this$splitToSequence");
        kotlin.jvm.internal.i.b(strArr, "delimiters");
        return kotlin.e.h.a(a(charSequence, strArr, 0, z, i, 2, null), new kotlin.jvm.a.b<kotlin.d.d, String>() { // from class: kotlin.text.StringsKt__StringsKt$splitToSequence$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.a.b
            public final String invoke(kotlin.d.d dVar) {
                kotlin.jvm.internal.i.b(dVar, "it");
                return o.a(charSequence, dVar);
            }
        });
    }

    static /* synthetic */ kotlin.e.a a(CharSequence charSequence, String[] strArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return a(charSequence, strArr, i, z, i2);
    }

    private static final kotlin.e.a<kotlin.d.d> a(CharSequence charSequence, String[] strArr, int i, final boolean z, int i2) {
        if (i2 >= 0) {
            final List listA = kotlin.collections.h.a(strArr);
            return new e(charSequence, i, i2, new kotlin.jvm.a.c<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>>() { // from class: kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.a.c
                public /* bridge */ /* synthetic */ Pair<? extends Integer, ? extends Integer> invoke(CharSequence charSequence2, Integer num) {
                    return invoke(charSequence2, num.intValue());
                }

                public final Pair<Integer, Integer> invoke(CharSequence charSequence2, int i3) {
                    kotlin.jvm.internal.i.b(charSequence2, "$receiver");
                    Pair pairB = o.b(charSequence2, (Collection<String>) listA, i3, z, false);
                    if (pairB != null) {
                        return kotlin.j.a(pairB.getFirst(), Integer.valueOf(((String) pairB.getSecond()).length()));
                    }
                    return null;
                }
            });
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2 + '.').toString());
    }

    public static /* synthetic */ List a(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return a(charSequence, strArr, z, i);
    }

    public static final List<String> a(CharSequence charSequence, String[] strArr, boolean z, int i) {
        kotlin.jvm.internal.i.b(charSequence, "$this$split");
        kotlin.jvm.internal.i.b(strArr, "delimiters");
        if (strArr.length == 1) {
            String str = strArr[0];
            if (!(str.length() == 0)) {
                return a(charSequence, str, z, i);
            }
        }
        Iterable iterableA = kotlin.e.h.a(a(charSequence, strArr, 0, z, i, 2, null));
        ArrayList arrayList = new ArrayList(kotlin.collections.n.a(iterableA, 10));
        Iterator it = iterableA.iterator();
        while (it.hasNext()) {
            arrayList.add(a(charSequence, (kotlin.d.d) it.next()));
        }
        return arrayList;
    }

    private static final List<String> a(CharSequence charSequence, String str, boolean z, int i) {
        int length = 0;
        if (i >= 0) {
            int iA = a(charSequence, str, 0, z);
            if (iA != -1 && i != 1) {
                boolean z2 = i > 0;
                ArrayList arrayList = new ArrayList(z2 ? kotlin.d.h.b(i, 10) : 10);
                do {
                    arrayList.add(charSequence.subSequence(length, iA).toString());
                    length = str.length() + iA;
                    if (z2 && arrayList.size() == i - 1) {
                        break;
                    }
                    iA = a(charSequence, str, length, z);
                } while (iA != -1);
                arrayList.add(charSequence.subSequence(length, charSequence.length()).toString());
                return arrayList;
            }
            return kotlin.collections.l.a(charSequence.toString());
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i + '.').toString());
    }
}
