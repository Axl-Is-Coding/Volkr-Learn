package freemarker.template;

import freemarker.template.utility.NullArgumentException;

/* JADX INFO: compiled from: _TemplateAPI.java */
/* JADX INFO: loaded from: classes5.dex */
public class N {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f21714a = C2881b.B.intValue();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f21715b = C2881b.C.intValue();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f21716c = C2881b.D.intValue();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f21717d = C2881b.E.intValue();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f21718e = C2881b.F.intValue();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f21719f = C2881b.G.intValue();
    public static final int g = Version.intValueFor(2, 4, 0);

    public static void a(Version version) {
        NullArgumentException.check("incompatibleImprovements", version);
        int iIntValue = version.intValue();
        if (iIntValue <= C2881b.d().intValue()) {
            if (iIntValue < f21714a) {
                throw new IllegalArgumentException("\"incompatibleImprovements\" must be at least 2.3.0.");
            }
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("The FreeMarker version requested by \"incompatibleImprovements\" was ");
        stringBuffer.append(version);
        stringBuffer.append(", but the installed FreeMarker version is only ");
        stringBuffer.append(C2881b.d());
        stringBuffer.append(". You may need to upgrade FreeMarker in your project.");
        throw new IllegalArgumentException(stringBuffer.toString());
    }

    public static boolean b(Version version) {
        return C2881b.a(version);
    }

    public static z c(Version version) {
        return C2881b.c(version);
    }
}
