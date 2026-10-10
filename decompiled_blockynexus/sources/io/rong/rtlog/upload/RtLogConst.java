package io.rong.rtlog.upload;

/* JADX INFO: loaded from: classes5.dex */
class RtLogConst {
    static final int CONFIG_DEFAULT_INTERVAL_UPLOAD_TIME_SECOND = 30;
    static final int CONFIG_DEFAULT_LOG_LEVEL = 1;
    static final int CONFIG_DEFAULT_MAX_INTERVAL_DELAY_TIMES = 5;
    static final String CONFIG_DEFAULT_TIMING_UPLOAD_CONFIG = "default_config";
    static final String CONFIG_DEFAULT_TIMING_UPLOAD_URL = "logcollection.ronghub.com";
    static final int CONFIG_FULL_UPLOAD_INTERVAL_UPLOAD_TIME_SECOND = 5;
    static final int CONFIG_FULL_UPLOAD_MAX_RETRY_TIMES = 2;
    static final long CONFIG_TIMING_UPLOAD_STOP_IN_BACKGROUND_TIME_MILLIS = 300000;
    static final int CONFIG_TIMING_UPLOAD_TASK_START_DELAY_SECOND = 30;
    static final String SP_KEY_LOG_FULL_UPLOAD_CACHE = "full_log_cache";
    static final String SP_KEY_LOG_TIMING_UPLOAD_CONFIG = "log_config";
    static final String SP_LOG_FILE_NAME_PREFIX = "rt_log_cache_";

    RtLogConst() {
    }
}
