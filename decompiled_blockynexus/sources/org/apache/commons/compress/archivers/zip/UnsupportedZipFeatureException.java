package org.apache.commons.compress.archivers.zip;

import java.io.Serializable;
import java.util.zip.ZipException;

/* JADX INFO: loaded from: classes5.dex */
public class UnsupportedZipFeatureException extends ZipException {
    private static final long serialVersionUID = 20161219;
    private final transient c entry;
    private final Feature reason;

    public static class Feature implements Serializable {
        private static final long serialVersionUID = 4112582948775420359L;
        private final String name;
        public static final Feature ENCRYPTION = new Feature("encryption");
        public static final Feature METHOD = new Feature("compression method");
        public static final Feature DATA_DESCRIPTOR = new Feature("data descriptor");
        public static final Feature SPLITTING = new Feature("splitting");

        private Feature(String str) {
            this.name = str;
        }

        public String toString() {
            return this.name;
        }
    }

    public UnsupportedZipFeatureException(Feature feature, c cVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("unsupported feature ");
        sb.append(feature);
        sb.append(" used in entry ");
        cVar.getName();
        throw null;
    }

    public c getEntry() {
        return this.entry;
    }

    public Feature getFeature() {
        return this.reason;
    }

    public UnsupportedZipFeatureException(ZipMethod zipMethod, c cVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("unsupported feature method '");
        sb.append(zipMethod.name());
        sb.append("' used in entry ");
        cVar.getName();
        throw null;
    }

    public UnsupportedZipFeatureException(Feature feature) {
        super("unsupported feature " + feature + " used in archive.");
        this.reason = feature;
        this.entry = null;
    }
}
