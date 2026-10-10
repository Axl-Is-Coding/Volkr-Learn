package com.google.android.ads.mediationtestsuite.dataobjects;

import android.content.Context;
import android.util.Log;
import com.google.android.ads.mediationtestsuite.R;
import com.google.android.ads.mediationtestsuite.viewmodels.TestState;

/* JADX INFO: loaded from: classes.dex */
public enum TestResult {
    UNTESTED(TestState.WARNING, R.string.gmts_not_tested_label),
    SUCCESS(TestState.OK, R.string.gmts_section_working),
    FAILURE_INTERNAL_ERROR(TestState.ERROR, R.string.gmts_error_internal_error),
    FAILURE_INVALID_REQUEST(TestState.ERROR, R.string.gmts_error_invalid_request),
    FAILURE_NETWORK_ERROR(TestState.ERROR, R.string.gmts_error_network_error),
    FAILURE_NO_FILL(TestState.ERROR, R.string.gmts_error_no_fill_title),
    FAILURE_UNABLE_TO_TEST(TestState.ERROR, R.string.gmts_section_missing_components);

    public static final int FAIL_COLOR = -30584;
    public static final int NEUTRAL_COLOR = -4473925;
    public static final int OK_COLOR = -7798904;
    private final TestState testState;
    private final int textResId;

    /* JADX INFO: renamed from: com.google.android.ads.mediationtestsuite.dataobjects.TestResult$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$android$ads$mediationtestsuite$dataobjects$TestResult = new int[TestResult.values().length];

        static {
            try {
                $SwitchMap$com$google$android$ads$mediationtestsuite$dataobjects$TestResult[TestResult.FAILURE_INTERNAL_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$android$ads$mediationtestsuite$dataobjects$TestResult[TestResult.FAILURE_INVALID_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$android$ads$mediationtestsuite$dataobjects$TestResult[TestResult.FAILURE_NETWORK_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$android$ads$mediationtestsuite$dataobjects$TestResult[TestResult.FAILURE_NO_FILL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    TestResult(TestState testState, int i) {
        this.testState = testState;
        this.textResId = i;
    }

    public static TestResult getFailureResult(int i) {
        if (i == 0) {
            return FAILURE_INTERNAL_ERROR;
        }
        if (i == 1) {
            return FAILURE_INVALID_REQUEST;
        }
        if (i == 2) {
            return FAILURE_NETWORK_ERROR;
        }
        if (i == 3) {
            return FAILURE_NO_FILL;
        }
        Log.d("gma_test", "Unknown error encountered. Defaulting to untested.");
        return UNTESTED;
    }

    public int getErrorCode() {
        int i = AnonymousClass1.$SwitchMap$com$google$android$ads$mediationtestsuite$dataobjects$TestResult[ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        if (i != 3) {
            return i != 4 ? -1 : 3;
        }
        return 2;
    }

    public TestState getTestState() {
        return this.testState;
    }

    public String getText(Context context) {
        return context.getString(this.textResId);
    }

    public boolean isFailure() {
        return this.testState == TestState.ERROR;
    }
}
