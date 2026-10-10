package freemarker.template;

import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
public final class SimpleScalar implements K, Serializable {
    private final String value;

    public SimpleScalar(String str) {
        this.value = str;
    }

    public static SimpleScalar newInstanceOrNull(String str) {
        if (str != null) {
            return new SimpleScalar(str);
        }
        return null;
    }

    @Override // freemarker.template.K
    public String getAsString() {
        String str = this.value;
        return str == null ? "" : str;
    }

    public String toString() {
        return this.value;
    }
}
