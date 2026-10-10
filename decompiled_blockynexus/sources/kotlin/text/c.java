package kotlin.text;

import java.nio.charset.Charset;

/* JADX INFO: compiled from: Charsets.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f22856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Charset f22857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Charset f22858c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Charset f22859d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Charset f22860e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Charset f22861f;
    public static final c g = new c();

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        kotlin.jvm.internal.i.a((Object) charsetForName, "Charset.forName(\"UTF-8\")");
        f22856a = charsetForName;
        Charset charsetForName2 = Charset.forName("UTF-16");
        kotlin.jvm.internal.i.a((Object) charsetForName2, "Charset.forName(\"UTF-16\")");
        f22857b = charsetForName2;
        Charset charsetForName3 = Charset.forName("UTF-16BE");
        kotlin.jvm.internal.i.a((Object) charsetForName3, "Charset.forName(\"UTF-16BE\")");
        f22858c = charsetForName3;
        Charset charsetForName4 = Charset.forName("UTF-16LE");
        kotlin.jvm.internal.i.a((Object) charsetForName4, "Charset.forName(\"UTF-16LE\")");
        f22859d = charsetForName4;
        Charset charsetForName5 = Charset.forName("US-ASCII");
        kotlin.jvm.internal.i.a((Object) charsetForName5, "Charset.forName(\"US-ASCII\")");
        f22860e = charsetForName5;
        Charset charsetForName6 = Charset.forName("ISO-8859-1");
        kotlin.jvm.internal.i.a((Object) charsetForName6, "Charset.forName(\"ISO-8859-1\")");
        f22861f = charsetForName6;
    }

    private c() {
    }
}
