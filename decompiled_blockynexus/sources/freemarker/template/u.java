package freemarker.template;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/* JADX INFO: compiled from: TemplateDateModel.java */
/* JADX INFO: loaded from: classes5.dex */
public interface u extends E {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List f21736b = Collections.unmodifiableList(Arrays.asList("UNKNOWN", "TIME", "DATE", "DATETIME"));

    Date b() throws TemplateModelException;
}
