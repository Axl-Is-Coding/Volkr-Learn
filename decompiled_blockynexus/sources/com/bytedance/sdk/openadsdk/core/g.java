package com.bytedance.sdk.openadsdk.core;

import io.rong.common.rlog.RLogReporter;

/* JADX INFO: compiled from: ErrorCode.java */
/* JADX INFO: loaded from: classes.dex */
public class g {
    public static String a(int i) {
        if (i == -100) {
            return com.bytedance.sdk.openadsdk.utils.t.a(o.a(), "tt_init_setting_config_not_complete");
        }
        if (i == -15) {
            return com.bytedance.sdk.openadsdk.utils.t.a(o.a(), "tt_lack_android_manifest_configuration");
        }
        if (i == 20001) {
            return com.bytedance.sdk.openadsdk.utils.t.a(o.a(), "tt_no_ad");
        }
        if (i == 50001) {
            return com.bytedance.sdk.openadsdk.utils.t.a(o.a(), "tt_sys_error");
        }
        if (i == 60007) {
            return com.bytedance.sdk.openadsdk.utils.t.a(o.a(), "tt_error_verify_reward");
        }
        if (i == 201) {
            return com.bytedance.sdk.openadsdk.utils.t.a(o.a(), "tt_load_creative_icon_response_error");
        }
        if (i == 202) {
            return com.bytedance.sdk.openadsdk.utils.t.a(o.a(), "tt_load_creative_icon_error");
        }
        switch (i) {
            case -12:
                return com.bytedance.sdk.openadsdk.utils.t.a(o.a(), "tt_splash_not_have_cache_error");
            case -11:
                return com.bytedance.sdk.openadsdk.utils.t.a(o.a(), "tt_splash_cache_expired_error");
            case -10:
                return com.bytedance.sdk.openadsdk.utils.t.a(o.a(), "tt_splash_cache_parse_error");
            case -9:
                return com.bytedance.sdk.openadsdk.utils.t.a(o.a(), "tt_request_body_error");
            case -8:
                return com.bytedance.sdk.openadsdk.utils.t.a(o.a(), "tt_frequent_call_erroe");
            case -7:
                return com.bytedance.sdk.openadsdk.utils.t.a(o.a(), "tt_splash_ad_load_image_error");
            case -6:
                return com.bytedance.sdk.openadsdk.utils.t.a(o.a(), "tt_insert_ad_load_image_error");
            case RLogReporter.UploadCallback.HTTP_ERROR /* -5 */:
                return com.bytedance.sdk.openadsdk.utils.t.a(o.a(), "tt_banner_ad_load_image_error");
            case -4:
                return com.bytedance.sdk.openadsdk.utils.t.a(o.a(), "tt_ad_data_error");
            case -3:
                return com.bytedance.sdk.openadsdk.utils.t.a(o.a(), "tt_no_ad_parse");
            case -2:
                return com.bytedance.sdk.openadsdk.utils.t.a(o.a(), "tt_net_error");
            case -1:
                return com.bytedance.sdk.openadsdk.utils.t.a(o.a(), "tt_parse_fail");
            default:
                switch (i) {
                    case 101:
                        return com.bytedance.sdk.openadsdk.utils.t.a(o.a(), "tt_render_render_parse_error");
                    case 102:
                        return com.bytedance.sdk.openadsdk.utils.t.a(o.a(), "tt_render_main_template_invalid");
                    case 103:
                        return com.bytedance.sdk.openadsdk.utils.t.a(o.a(), "tt_render_diff_template_invalid");
                    case 104:
                        return com.bytedance.sdk.openadsdk.utils.t.a(o.a(), "tt_render_fail_meta_invalid");
                    case 105:
                        return com.bytedance.sdk.openadsdk.utils.t.a(o.a(), "tt_render_fail_template_parse_error");
                    case 106:
                        return com.bytedance.sdk.openadsdk.utils.t.a(o.a(), "tt_render_fail_unknown");
                    case 107:
                        return com.bytedance.sdk.openadsdk.utils.t.a(o.a(), "tt_render_fail_timeout");
                    case 108:
                        return com.bytedance.sdk.openadsdk.utils.t.a(o.a(), "tt_reder_ad_load_timeout");
                    case 109:
                        return com.bytedance.sdk.openadsdk.utils.t.a(o.a(), "tt_template_load_fail");
                    default:
                        switch (i) {
                            case 40000:
                                return com.bytedance.sdk.openadsdk.utils.t.a(o.a(), "tt_content_type");
                            case 40001:
                                return com.bytedance.sdk.openadsdk.utils.t.a(o.a(), "tt_request_pb_error");
                            case 40002:
                                return com.bytedance.sdk.openadsdk.utils.t.a(o.a(), "tt_app_empty");
                            case 40003:
                                return com.bytedance.sdk.openadsdk.utils.t.a(o.a(), "tt_wap_empty");
                            case 40004:
                                return com.bytedance.sdk.openadsdk.utils.t.a(o.a(), "tt_adslot_empty");
                            case 40005:
                                return com.bytedance.sdk.openadsdk.utils.t.a(o.a(), "tt_adslot_size_empty");
                            case 40006:
                                return com.bytedance.sdk.openadsdk.utils.t.a(o.a(), "tt_adslot_id_error");
                            case 40007:
                                return com.bytedance.sdk.openadsdk.utils.t.a(o.a(), "tt_error_code_adcount_error");
                            case 40008:
                                return com.bytedance.sdk.openadsdk.utils.t.a(o.a(), "tt_error_image_size");
                            case 40009:
                                return com.bytedance.sdk.openadsdk.utils.t.a(o.a(), "tt_error_media_id");
                            case 40010:
                                return com.bytedance.sdk.openadsdk.utils.t.a(o.a(), "tt_error_media_type");
                            case 40011:
                                return com.bytedance.sdk.openadsdk.utils.t.a(o.a(), "tt_error_ad_type");
                            case 40012:
                            case 40017:
                                return com.bytedance.sdk.openadsdk.utils.t.a(o.a(), "tt_error_access_method_pass");
                            case 40013:
                                return com.bytedance.sdk.openadsdk.utils.t.a(o.a(), "tt_error_splash_ad_type");
                            case 40014:
                                return com.bytedance.sdk.openadsdk.utils.t.a(o.a(), "tt_error_redirect");
                            case 40015:
                                return com.bytedance.sdk.openadsdk.utils.t.a(o.a(), "tt_error_request_invalid");
                            case 40016:
                                return com.bytedance.sdk.openadsdk.utils.t.a(o.a(), "tt_error_slot_id_app_id_differ");
                            case 40018:
                                return com.bytedance.sdk.openadsdk.utils.t.a(o.a(), "tt_error_package_name");
                            case 40019:
                                return com.bytedance.sdk.openadsdk.utils.t.a(o.a(), "tt_error_adtype_differ");
                            case 40020:
                                return com.bytedance.sdk.openadsdk.utils.t.a(o.a(), "tt_error_new_register_limit");
                            case 40021:
                                return com.bytedance.sdk.openadsdk.utils.t.a(o.a(), "tt_error_apk_sign_check_error");
                            case 40022:
                                return com.bytedance.sdk.openadsdk.utils.t.a(o.a(), "tt_error_origin_ad_error");
                            case 40023:
                                return com.bytedance.sdk.openadsdk.utils.t.a(o.a(), "tt_error_union_os_error");
                            case 40024:
                                return com.bytedance.sdk.openadsdk.utils.t.a(o.a(), "tt_error_union_sdk_too_old");
                            default:
                                switch (i) {
                                    case 60001:
                                        return com.bytedance.sdk.openadsdk.utils.t.a(o.a(), "tt_ror_code_show_event_error");
                                    case 60002:
                                        return com.bytedance.sdk.openadsdk.utils.t.a(o.a(), "tt_error_code_click_event_error");
                                    default:
                                        return com.bytedance.sdk.openadsdk.utils.t.a(o.a(), "tt_error_unknow");
                                }
                        }
                }
        }
    }
}
