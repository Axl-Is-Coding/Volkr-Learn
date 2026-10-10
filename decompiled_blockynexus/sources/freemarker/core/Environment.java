package freemarker.core;

import freemarker.template.SimpleHash;
import freemarker.template.Template;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class Environment extends Configurable {
    private static final freemarker.template.E[] D;
    private static final Writer E;
    private final ArrayList F;
    private Namespace G;
    private boolean H;
    private static final ThreadLocal y = new ThreadLocal();
    private static final d.b.b z = d.b.b.d("freemarker.runtime");
    private static final d.b.b A = d.b.b.d("freemarker.runtime.attempt");
    private static final Map B = new HashMap();
    private static final DecimalFormat C = new DecimalFormat("0.################", new DecimalFormatSymbols(Locale.US));

    static {
        C.setGroupingUsed(false);
        C.setDecimalSeparatorAlwaysShown(false);
        D = new freemarker.template.E[0];
        E = new C2854zb();
    }

    static void a(Environment environment) {
        y.set(environment);
    }

    private static Nb b(Xb xb) {
        while (xb != null) {
            if (xb instanceof Nb) {
                return (Nb) xb;
            }
            xb = xb.q();
        }
        return null;
    }

    public static Environment d() {
        return (Environment) y.get();
    }

    public String c(String str) {
        return this.G.getTemplate().c(str);
    }

    public String e() {
        return this.G.getTemplate().e();
    }

    boolean f() {
        return this.H;
    }

    Xb[] g() {
        int size = this.F.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            Xb xb = (Xb) this.F.get(i2);
            if (i2 == size || xb.r()) {
                i++;
            }
        }
        if (i == 0) {
            return null;
        }
        Xb[] xbArr = new Xb[i];
        int i3 = i - 1;
        for (int i4 = 0; i4 < size; i4++) {
            Xb xb2 = (Xb) this.F.get(i4);
            if (i4 == size || xb2.r()) {
                xbArr[i3] = xb2;
                i3--;
            }
        }
        return xbArr;
    }

    public Template h() {
        return (Template) b();
    }

    public class Namespace extends SimpleHash {
        private final Template template;

        Namespace() {
            this.template = Environment.this.h();
        }

        public Template getTemplate() {
            Template template = this.template;
            return template == null ? Environment.this.h() : template;
        }

        Namespace(Template template) {
            this.template = template;
        }
    }

    static void a(Xb[] xbArr, boolean z2, Writer writer) {
        PrintWriter printWriter = (PrintWriter) (writer instanceof PrintWriter ? writer : null);
        try {
            if (xbArr == null) {
                writer.write("(The stack was empty)");
                if (printWriter != null) {
                    printWriter.println();
                    return;
                } else {
                    writer.write(10);
                    return;
                }
            }
            int length = xbArr.length;
            int i = (!z2 || length <= 10) ? length : 9;
            boolean z3 = false;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (i2 < length) {
                Xb xb = xbArr[i2];
                if (i2 > 1) {
                    Xb xb2 = xbArr[i2 - 1];
                }
                if (i4 < i) {
                    writer.write(i2 == 0 ? "\t- Failed at: " : "\t- Reached through: ");
                    writer.write(a(xb));
                    if (printWriter != null) {
                        printWriter.println();
                    } else {
                        writer.write(10);
                    }
                    i4++;
                } else {
                    i3++;
                }
                i2++;
            }
            if (i3 > 0) {
                writer.write("\t... (Had ");
                writer.write(String.valueOf(i3 + 0));
                writer.write(" more, hidden for tersenes)");
                z3 = true;
            }
            if (z3) {
                if (printWriter != null) {
                    printWriter.println();
                } else {
                    writer.write(10);
                }
            }
        } catch (IOException e2) {
            z.a("Failed to print FTL stack trace", e2);
        }
    }

    public String b(String str) {
        return this.G.getTemplate().b(str);
    }

    static String a(Xb xb) {
        StringBuffer stringBuffer = new StringBuffer();
        a(xb, stringBuffer);
        return stringBuffer.toString();
    }

    static void a(Xb xb, StringBuffer stringBuffer) {
        stringBuffer.append(Ob.a(xb.o(), 40));
        stringBuffer.append("  [");
        Nb nbB = b(xb);
        if (nbB != null) {
            stringBuffer.append(Ob.a(nbB, xb.f21501c, xb.f21500b));
        } else {
            stringBuffer.append(Ob.a(xb.l(), xb.f21501c, xb.f21500b));
        }
        stringBuffer.append("]");
    }
}
