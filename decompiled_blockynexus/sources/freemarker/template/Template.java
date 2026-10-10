package freemarker.template;

import com.alibaba.android.arouter.utils.Consts;
import freemarker.core.Configurable;
import freemarker.core.ParseException;
import freemarker.core.Xb;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class Template extends Configurable {
    private int A;
    private final String B;
    private final String C;
    private final ArrayList D;
    private Map E;
    private Map F;
    private Xb y;
    private String z;

    public static class WrongEncodingException extends ParseException {
        private static final long serialVersionUID = 1;
        private final String constructorSpecifiedEncoding;
        public String specifiedEncoding;

        public WrongEncodingException(String str) {
            this(str, null);
        }

        public String getConstructorSpecifiedEncoding() {
            return this.constructorSpecifiedEncoding;
        }

        @Override // freemarker.core.ParseException, java.lang.Throwable
        public String getMessage() {
            String string;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Encoding specified inside the template (");
            stringBuffer.append(this.specifiedEncoding);
            stringBuffer.append(") doesn't match the encoding specified for the Template constructor");
            if (this.constructorSpecifiedEncoding != null) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append(" (");
                stringBuffer2.append(this.constructorSpecifiedEncoding);
                stringBuffer2.append(").");
                string = stringBuffer2.toString();
            } else {
                string = Consts.DOT;
            }
            stringBuffer.append(string);
            return stringBuffer.toString();
        }

        public String getTemplateSpecifiedEncoding() {
            return this.specifiedEncoding;
        }

        public WrongEncodingException(String str, String str2) {
            this.specifiedEncoding = str;
            this.constructorSpecifiedEncoding = str2;
        }
    }

    public void a(Writer writer) throws IOException {
        writer.write(this.y.e());
    }

    public String b(String str) {
        if (!str.equals("")) {
            return (String) this.E.get(str);
        }
        String str2 = this.z;
        return str2 == null ? "" : str2;
    }

    public String c(String str) {
        if (str == null) {
            return null;
        }
        return str.length() == 0 ? this.z == null ? "" : "N" : str.equals(this.z) ? "" : (String) this.F.get(str);
    }

    public int d() {
        return this.A;
    }

    public String e() {
        return this.z;
    }

    public String f() {
        return this.B;
    }

    public String g() {
        String str = this.C;
        return str != null ? str : f();
    }

    public String toString() {
        StringWriter stringWriter = new StringWriter();
        try {
            a(stringWriter);
            return stringWriter.toString();
        } catch (IOException e2) {
            throw new RuntimeException(e2.getMessage());
        }
    }

    public String a(int i, int i2, int i3, int i4) {
        if (i2 < 1 || i4 < 1) {
            return null;
        }
        int i5 = i - 1;
        int i6 = i3 - 1;
        int i7 = i4 - 1;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i8 = i2 - 1; i8 <= i7; i8++) {
            if (i8 < this.D.size()) {
                stringBuffer.append(this.D.get(i8));
            }
        }
        int length = (this.D.get(i7).toString().length() - i6) - 1;
        stringBuffer.delete(0, i5);
        stringBuffer.delete(stringBuffer.length() - length, stringBuffer.length());
        return stringBuffer.toString();
    }
}
