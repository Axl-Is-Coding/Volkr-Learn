package freemarker.template;

import freemarker.core.Configurable;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

/* JADX INFO: renamed from: freemarker.template.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: Configuration.java */
/* JADX INFO: loaded from: classes5.dex */
public class C2881b extends Configurable implements Cloneable {
    private static final Version K;
    private static final boolean L;
    private static final Object M;
    static /* synthetic */ Class N;
    private static final d.b.b y = d.b.b.d("freemarker.cache");
    private static final String[] z = {"auto_import", "auto_include", "cache_storage", "default_encoding", "incompatible_improvements", "localized_lookup", "naming_convention", "strict_syntax", "tag_syntax", "template_loader", "template_lookup_strategy", "template_name_format", "template_update_delay", "whitespace_stripping"};
    private static final String[] A = {"autoImport", "autoInclude", "cacheStorage", "defaultEncoding", "incompatibleImprovements", "localizedLookup", "namingConvention", "strictSyntax", "tagSyntax", "templateLoader", "templateLookupStrategy", "templateNameFormat", "templateUpdateDelay", "whitespaceStripping"};
    public static final Version B = new Version(2, 3, 0);
    public static final Version C = new Version(2, 3, 19);
    public static final Version D = new Version(2, 3, 20);
    public static final Version E = new Version(2, 3, 21);
    public static final Version F = new Version(2, 3, 22);
    public static final Version G = new Version(2, 3, 23);
    public static final Version H = B;
    public static final String I = H.toString();
    public static final int J = H.intValue();

    static {
        Class clsB;
        Date date;
        boolean z2 = false;
        try {
            Properties properties = new Properties();
            if (N == null) {
                clsB = b("freemarker.template.Configuration");
                N = clsB;
            } else {
                clsB = N;
            }
            InputStream resourceAsStream = clsB.getClassLoader().getResourceAsStream("freemarker/version.properties");
            if (resourceAsStream == null) {
                throw new RuntimeException("Version file is missing.");
            }
            try {
                properties.load(resourceAsStream);
                resourceAsStream.close();
                String strA = a(properties, "version");
                String strA2 = a(properties, "buildTimestamp");
                if (strA2.endsWith("Z")) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(strA2.substring(0, strA2.length() - 1));
                    stringBuffer.append("+0000");
                    strA2 = stringBuffer.toString();
                }
                try {
                    date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).parse(strA2);
                } catch (ParseException unused) {
                    date = null;
                }
                K = new Version(strA, Boolean.valueOf(a(properties, "isGAECompliant")), date);
                try {
                    Class.forName("freemarker.core._2_4_OrLaterMarker");
                } catch (LinkageError unused2) {
                } catch (Throwable unused3) {
                }
                z2 = true;
                L = z2;
                M = new Object();
            } catch (Throwable th) {
                resourceAsStream.close();
                throw th;
            }
        } catch (IOException e2) {
            throw new RuntimeException("Failed to load and parse freemarker/version.properties", e2);
        }
    }

    private static String a(Properties properties, String str) {
        String property = properties.getProperty(str);
        if (property != null) {
            return property;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Version file is corrupt: \"");
        stringBuffer.append(str);
        stringBuffer.append("\" property is missing.");
        throw new RuntimeException(stringBuffer.toString());
    }

    static final boolean a(Version version) {
        return true;
    }

    static /* synthetic */ Class b(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    static final z c(Version version) {
        return z.f21756c;
    }

    public static Version d() {
        return K;
    }

    public static InterfaceC2891l b(Version version) {
        return version.intValue() < N.f21717d ? InterfaceC2891l.f21729b : new C2888i(version).build();
    }
}
