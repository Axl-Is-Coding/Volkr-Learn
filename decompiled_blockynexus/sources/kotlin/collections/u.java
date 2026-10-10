package kotlin.collections;

import com.sandboxol.common.utils.TextEllipsizeUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: _Collections.kt */
/* JADX INFO: loaded from: classes5.dex */
public class u extends t {
    public static <T> T a(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.i.b(iterable, "$this$single");
        if (iterable instanceof List) {
            return (T) f((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        T next = it.next();
        if (it.hasNext()) {
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        return next;
    }

    public static <T> List<T> b(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.i.b(iterable, "$this$toList");
        if (!(iterable instanceof Collection)) {
            return m.b(c(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return m.a();
        }
        if (size != 1) {
            return a(collection);
        }
        return l.a(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static final <T> List<T> c(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.i.b(iterable, "$this$toMutableList");
        if (iterable instanceof Collection) {
            return a((Collection) iterable);
        }
        ArrayList arrayList = new ArrayList();
        a(iterable, arrayList);
        return arrayList;
    }

    public static <T> T d(List<? extends T> list) {
        kotlin.jvm.internal.i.b(list, "$this$first");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static <T> T e(List<? extends T> list) {
        kotlin.jvm.internal.i.b(list, "$this$last");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(m.a((List) list));
    }

    public static final <T> T f(List<? extends T> list) {
        kotlin.jvm.internal.i.b(list, "$this$single");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        }
        if (size == 1) {
            return list.get(0);
        }
        throw new IllegalArgumentException("List has more than one element.");
    }

    public static final <T, C extends Collection<? super T>> C a(Iterable<? extends T> iterable, C c2) {
        kotlin.jvm.internal.i.b(iterable, "$this$toCollection");
        kotlin.jvm.internal.i.b(c2, "destination");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            c2.add(it.next());
        }
        return c2;
    }

    public static final <T> List<T> a(Collection<? extends T> collection) {
        kotlin.jvm.internal.i.b(collection, "$this$toMutableList");
        return new ArrayList(collection);
    }

    public static final <T, A extends Appendable> A a(Iterable<? extends T> iterable, A a2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, kotlin.jvm.a.b<? super T, ? extends CharSequence> bVar) throws IOException {
        kotlin.jvm.internal.i.b(iterable, "$this$joinTo");
        kotlin.jvm.internal.i.b(a2, "buffer");
        kotlin.jvm.internal.i.b(charSequence, "separator");
        kotlin.jvm.internal.i.b(charSequence2, "prefix");
        kotlin.jvm.internal.i.b(charSequence3, "postfix");
        kotlin.jvm.internal.i.b(charSequence4, "truncated");
        a2.append(charSequence2);
        int i2 = 0;
        for (T t : iterable) {
            i2++;
            if (i2 > 1) {
                a2.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            kotlin.text.k.a(a2, t, bVar);
        }
        if (i >= 0 && i2 > i) {
            a2.append(charSequence4);
        }
        a2.append(charSequence3);
        return a2;
    }

    public static /* synthetic */ String a(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, kotlin.jvm.a.b bVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i2 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i2 & 4) == 0 ? charSequence3 : "";
        int i3 = (i2 & 8) != 0 ? -1 : i;
        if ((i2 & 16) != 0) {
            charSequence4 = TextEllipsizeUtil.SignLib.END_POINT;
        }
        CharSequence charSequence7 = charSequence4;
        if ((i2 & 32) != 0) {
            bVar = null;
        }
        return a(iterable, charSequence, charSequence5, charSequence6, i3, charSequence7, bVar);
    }

    public static final <T> String a(Iterable<? extends T> iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, kotlin.jvm.a.b<? super T, ? extends CharSequence> bVar) throws IOException {
        kotlin.jvm.internal.i.b(iterable, "$this$joinToString");
        kotlin.jvm.internal.i.b(charSequence, "separator");
        kotlin.jvm.internal.i.b(charSequence2, "prefix");
        kotlin.jvm.internal.i.b(charSequence3, "postfix");
        kotlin.jvm.internal.i.b(charSequence4, "truncated");
        StringBuilder sb = new StringBuilder();
        a(iterable, sb, charSequence, charSequence2, charSequence3, i, charSequence4, bVar);
        String string = sb.toString();
        kotlin.jvm.internal.i.a((Object) string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }
}
