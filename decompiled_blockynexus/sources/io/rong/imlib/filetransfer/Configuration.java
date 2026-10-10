package io.rong.imlib.filetransfer;

/* JADX INFO: loaded from: classes5.dex */
public class Configuration {
    private final int connectTimeout;
    private final int readTimeout;

    public static class Builder {
        private int connectTimeout;
        private boolean isSelfCertificate;
        private int readTimeout;

        public Configuration build() {
            return new Configuration(this);
        }

        public Builder connectTimeout(int i) {
            this.connectTimeout = i;
            return this;
        }

        public Builder enableHttpsSelfCertificate(boolean z) {
            this.isSelfCertificate = z;
            return this;
        }

        public boolean isSelfCertificate() {
            return this.isSelfCertificate;
        }

        public Builder readTimeout(int i) {
            this.readTimeout = i;
            return this;
        }
    }

    protected int getConnectTimeout() {
        return this.connectTimeout;
    }

    protected int getReadTimeout() {
        return this.readTimeout;
    }

    private Configuration(Builder builder) {
        this.connectTimeout = builder.connectTimeout;
        this.readTimeout = builder.readTimeout;
    }
}
