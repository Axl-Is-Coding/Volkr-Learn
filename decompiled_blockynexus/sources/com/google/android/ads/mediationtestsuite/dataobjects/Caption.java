package com.google.android.ads.mediationtestsuite.dataobjects;

import com.google.android.ads.mediationtestsuite.R;
import com.google.android.ads.mediationtestsuite.viewmodels.TestState;

/* JADX INFO: loaded from: classes.dex */
public class Caption {
    private final Component component;
    private final TestState testState;

    public enum Component {
        SDK(R.string.gmts_sdk),
        ADAPTER(R.string.gmts_adapter),
        MANIFEST(R.string.gmts_manifest),
        AD_LOAD(R.string.gmts_ad_load);

        private final int stringResId;

        Component(int i) {
            this.stringResId = i;
        }

        public int getStringResId() {
            return this.stringResId;
        }
    }

    public Caption(TestState testState, Component component) {
        this.testState = testState;
        this.component = component;
    }

    public Component getComponent() {
        return this.component;
    }

    public TestState getTestState() {
        return this.testState;
    }
}
