package freemarker.template;

import java.io.FileNotFoundException;

/* JADX INFO: loaded from: classes5.dex */
public final class TemplateNotFoundException extends FileNotFoundException {
    private final Object customLookupCondition;
    private final String templateName;

    public TemplateNotFoundException(String str, Object obj, String str2) {
        super(str2);
        this.templateName = str;
        this.customLookupCondition = obj;
    }

    public Object getCustomLookupCondition() {
        return this.customLookupCondition;
    }

    public String getTemplateName() {
        return this.templateName;
    }
}
