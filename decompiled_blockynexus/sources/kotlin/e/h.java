package kotlin.e;

import com.sandboxol.common.utils.TextEllipsizeUtil;
import java.io.IOException;
import kotlin.text.k;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: _Sequences.kt */
/* JADX INFO: loaded from: classes5.dex */
public class h extends f {
    public static <T, R> a<R> a(a<? extends T> aVar, kotlin.jvm.a.b<? super T, ? extends R> bVar) {
        kotlin.jvm.internal.i.b(aVar, "$this$map");
        kotlin.jvm.internal.i.b(bVar, "transform");
        return new j(aVar, bVar);
    }

    public static final <T, A extends Appendable> A a(a<? extends T> aVar, A a2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, kotlin.jvm.a.b<? super T, ? extends CharSequence> bVar) throws IOException {
        kotlin.jvm.internal.i.b(aVar, "$this$joinTo");
        kotlin.jvm.internal.i.b(a2, "buffer");
        kotlin.jvm.internal.i.b(charSequence, "separator");
        kotlin.jvm.internal.i.b(charSequence2, "prefix");
        kotlin.jvm.internal.i.b(charSequence3, "postfix");
        kotlin.jvm.internal.i.b(charSequence4, "truncated");
        a2.append(charSequence2);
        int i2 = 0;
        for (T t : aVar) {
            i2++;
            if (i2 > 1) {
                a2.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            k.a(a2, t, bVar);
        }
        if (i >= 0 && i2 > i) {
            a2.append(charSequence4);
        }
        a2.append(charSequence3);
        return a2;
    }

    public static /* synthetic */ String a(a aVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, kotlin.jvm.a.b bVar, int i2, Object obj) {
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
        return a(aVar, charSequence, charSequence5, charSequence6, i3, charSequence7, bVar);
    }

    public static final <T> String a(a<? extends T> aVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, kotlin.jvm.a.b<? super T, ? extends CharSequence> bVar) throws IOException {
        kotlin.jvm.internal.i.b(aVar, "$this$joinToString");
        kotlin.jvm.internal.i.b(charSequence, "separator");
        kotlin.jvm.internal.i.b(charSequence2, "prefix");
        kotlin.jvm.internal.i.b(charSequence3, "postfix");
        kotlin.jvm.internal.i.b(charSequence4, "truncated");
        StringBuilder sb = new StringBuilder();
        a(aVar, sb, charSequence, charSequence2, charSequence3, i, charSequence4, bVar);
        String string = sb.toString();
        kotlin.jvm.internal.i.a((Object) string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    public static <T> Iterable<T> a(a<? extends T> aVar) {
        kotlin.jvm.internal.i.b(aVar, "$this$asIterable");
        return new g(aVar);
    }
}
