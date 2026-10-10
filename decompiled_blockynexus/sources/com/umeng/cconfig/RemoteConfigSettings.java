package com.umeng.cconfig;

/* JADX INFO: loaded from: classes5.dex */
public class RemoteConfigSettings {
    private final boolean autoUpdateConfig;

    public static class Builder {
        private boolean autoUpdateConfig = false;

        public RemoteConfigSettings build() {
            return new RemoteConfigSettings(this);
        }

        public Builder setAutoUpdateModeEnabled(boolean z) {
            this.autoUpdateConfig = z;
            return this;
        }
    }

    public boolean isAutoUpdateModeEnabled() {
        return this.autoUpdateConfig;
    }

    private RemoteConfigSettings(Builder builder) {
        this.autoUpdateConfig = builder.autoUpdateConfig;
    }
}
