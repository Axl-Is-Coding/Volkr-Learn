package freemarker.template;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class MalformedTemplateNameException extends IOException {
    private final String malformednessDescription;
    private final String templateName;

    public MalformedTemplateNameException(String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Malformed template name, ");
        stringBuffer.append(freemarker.template.utility.h.e(str));
        stringBuffer.append(": ");
        stringBuffer.append(str2);
        super(stringBuffer.toString());
        this.templateName = str;
        this.malformednessDescription = str2;
    }

    public String getMalformednessDescription() {
        return this.malformednessDescription;
    }

    public String getTemplateName() {
        return this.templateName;
    }
}
