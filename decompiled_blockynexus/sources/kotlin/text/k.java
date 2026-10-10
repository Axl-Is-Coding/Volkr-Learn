package kotlin.text;

import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: StringBuilder.kt */
/* JADX INFO: loaded from: classes5.dex */
public class k extends j {
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void a(Appendable appendable, T t, kotlin.jvm.a.b<? super T, ? extends CharSequence> bVar) throws IOException {
        kotlin.jvm.internal.i.b(appendable, "$this$appendElement");
        if (bVar != null) {
            appendable.append(bVar.invoke(t));
            return;
        }
        if (t != 0 ? t instanceof CharSequence : true) {
            appendable.append((CharSequence) t);
        } else if (t instanceof Character) {
            appendable.append(((Character) t).charValue());
        } else {
            appendable.append(String.valueOf(t));
        }
    }
}
