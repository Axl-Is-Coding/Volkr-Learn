package c.t.m.g;

import java.util.regex.Pattern;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public final class Ub {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f3020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f3021b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f3022c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f3023d;

    static {
        Pattern patternCompile = Pattern.compile("[0-9a-zA-Z+-]*");
        f3020a = patternCompile;
        f3021b = patternCompile;
        f3022c = f3020a;
        f3023d = Pattern.compile("[A-Z0-9]{12}");
    }

    public static String a(String str, Pattern pattern) {
        return (str != null && pattern.matcher(str).matches()) ? str : "";
    }
}
