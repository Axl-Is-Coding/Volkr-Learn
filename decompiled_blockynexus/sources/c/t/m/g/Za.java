package c.t.m.g;

import java.util.regex.Pattern;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public final class Za {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f3068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f3069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f3070c;

    static {
        Pattern patternCompile = Pattern.compile("[0-9a-zA-Z+-]*");
        f3068a = patternCompile;
        f3069b = patternCompile;
        f3070c = f3068a;
        Pattern.compile("[A-Z0-9]{12}");
    }

    public static String a(String str, Pattern pattern) {
        return (str != null && pattern.matcher(str).matches()) ? str : "";
    }
}
