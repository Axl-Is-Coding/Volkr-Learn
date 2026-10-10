package io.rong.imkit.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.Spannable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.umeng.analytics.pro.ci;
import io.rong.common.FileUtils;
import io.rong.common.LibStorageUtils;
import io.rong.common.RLog;
import io.rong.imkit.R;
import io.rong.imkit.RongContext;
import io.rong.imkit.RongIM;
import io.rong.imkit.message.CombineMessage;
import io.rong.imkit.userInfoCache.RongUserInfoManager;
import io.rong.imkit.utilities.RongUtils;
import io.rong.imlib.MessageTag;
import io.rong.imlib.model.Message;
import io.rong.imlib.model.MessageContent;
import io.rong.imlib.model.UserInfo;
import io.rong.message.FileMessage;
import io.rong.message.GIFMessage;
import io.rong.message.ImageMessage;
import io.rong.message.LocationMessage;
import io.rong.message.SightMessage;
import io.rong.message.TextMessage;
import io.rong.message.utils.BitmapUtil;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class CombineMessageUtils {
    private static final String BASE64_PRE = "data:image/jpeg;base64,";
    private static final String COMBINE_FILE_PATH = "combine";
    private static final String COMBINE_FILE_SUFFIX = ".html";
    private static final int IMAGE_HEIGHT = 100;
    private static final int IMAGE_WIDTH = 100;
    private static final String JSON_FILE_NAME = "combine.json";
    private static final String MSG_BASE_HEAD_STYLE = "{%style%}";
    private static final String MSG_COMBINE_BODY = "{%combineBody%}";
    private static final String MSG_DURATION = "{%duration%}";
    private static final String MSG_FILE_ICON = "{%fileIcon%}";
    private static final String MSG_FILE_NAME = "{%fileName%}";
    private static final String MSG_FILE_SIZE = "{%fileSize%}";
    private static final String MSG_FILE_TYPE = "{%fileType%}";
    private static final String MSG_FILE_URL = "{%fileUrl%}";
    private static final String MSG_FOOT = "{%foot%}";
    private static final String MSG_IMAGE_BASE64 = "{%imageBase64%}";
    private static final String MSG_IMAG_URL = "{%imgUrl%}";
    private static final String MSG_LATITUDE = "{%latitude%}";
    private static final String MSG_LOCATION_NAME = "{%locationName%}";
    private static final String MSG_LONGITTUDE = "{%longitude%}";
    private static final String MSG_PORTRAIT = "{%portrait%}";
    private static final String MSG_SEND_TIME = "{%sendTime%}";
    private static final String MSG_SHOW_USER = "{%showUser%}";
    private static final String MSG_SIZE = "{%size%}";
    private static final String MSG_TEXT = "{%text%}";
    private static final String MSG_TIME = "{%time%}";
    private static final String MSG_TITLE = "{%title%}";
    private static final String MSG_USER_NAMEM = "{%userName%}";
    private static final String NO_USER = "rong-none-user";
    private static final String TAG = "CombineMessageUtils";
    private static final String TAG_BASE_BOTTOM = "baseBottom";
    private static final String TAG_BASE_HEAD = "baseHead";
    private static final String TAG_CARD = "RC:CardMsg";
    private static final String TAG_COMBINE = "RC:CombineMsg";
    private static final String TAG_FILE = "RC:FileMsg";
    private static final String TAG_GIF = "RC:GIFMsg";
    private static final String TAG_HQVC = "RC:HQVCMsg";
    private static final String TAG_IMG = "RC:ImgMsg";
    private static final String TAG_IMG_TEXT = "RC:ImgTextMsg";
    private static final String TAG_LBS = "RC:LBSMsg";
    private static final String TAG_MSG_COMBINE_BODY = "CombineMsgBody";
    private static final String TAG_RP = "RCJrmf:RpMsg";
    private static final String TAG_SIGHT = "RC:SightMsg";
    private static final String TAG_STK = "RC:StkMsg";
    private static final String TAG_TIME = "time";
    private static final String TAG_TXT = "RC:TxtMsg";
    private static final String TAG_VC = "RC:VcMsg";
    private static final String TAG_VCSUMMARY = "RC:VCSummary";
    private static final String TAG_VST = "RC:VSTMsg";
    private Map<String, String> DATA;
    private Uri URI;
    private Boolean isSameDay;
    private Boolean isSameYear;
    private String style;

    private static class Holder {
        private static volatile CombineMessageUtils Utils = new CombineMessageUtils();

        private Holder() {
        }
    }

    private String getBase64FromImageId(int i) {
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(RongIM.getInstance().getApplicationContext().getResources(), i);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmapDecodeResource.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return BASE64_PRE + Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
    }

    private String getBase64FromUrl(Uri uri) {
        if (uri == null) {
            return "";
        }
        String scheme = uri.getScheme();
        if (scheme == null || !scheme.equals(LibStorageUtils.FILE)) {
            RLog.d(TAG, "getBase64FromUrl uri is not file, uri:" + uri.toString());
            return uri.toString();
        }
        Bitmap resizedBitmap = null;
        try {
            resizedBitmap = BitmapUtil.getResizedBitmap(RongIM.getInstance().getApplicationContext(), uri, 100, 100);
        } catch (IOException e2) {
            RLog.e(TAG, "getBase64FromUrl", e2);
        }
        if (resizedBitmap == null) {
            RLog.e(TAG, "getBase64FromUrl bitmap is null, uri:" + uri.toString());
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        resizedBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return BASE64_PRE + Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
    }

    private Map<String, String> getDATA() {
        this.DATA = setData(getJson());
        return this.DATA;
    }

    private String getHtmlBaseBottom() {
        return getHtmlFromType(TAG_BASE_BOTTOM);
    }

    private String getHtmlBaseHead() {
        return getHtmlFromType(TAG_BASE_HEAD).replace(MSG_BASE_HEAD_STYLE, this.style);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private String getHtmlFromMessageContent(Message message, MessageContent messageContent) {
        MessageTag messageTag = (MessageTag) messageContent.getClass().getAnnotation(MessageTag.class);
        Context applicationContext = RongIM.getInstance().getApplicationContext();
        if (applicationContext == null || messageTag == null || !messageTag.value().startsWith("RC:")) {
            RLog.e(TAG, "getHtmlFromMessageContent tag is UnKnown, content:" + messageContent);
            return "";
        }
        String strValue = messageTag.value();
        String userInfo = setUserInfo(getHtmlFromType(strValue), message);
        byte b2 = -1;
        switch (strValue.hashCode()) {
            case -2042295573:
                if (strValue.equals(TAG_VC)) {
                    b2 = 2;
                }
                break;
            case -1835503925:
                if (strValue.equals(TAG_COMBINE)) {
                    b2 = ci.l;
                }
                break;
            case -1160730064:
                if (strValue.equals(TAG_VCSUMMARY)) {
                    b2 = 7;
                }
                break;
            case -961182724:
                if (strValue.equals(TAG_FILE)) {
                    b2 = 12;
                }
                break;
            case -926790277:
                if (strValue.equals(TAG_RP)) {
                    b2 = 8;
                }
                break;
            case -911587622:
                if (strValue.equals(TAG_IMG_TEXT)) {
                    b2 = 1;
                }
                break;
            case 105394658:
                if (strValue.equals(TAG_HQVC)) {
                    b2 = 3;
                }
                break;
            case 447751656:
                if (strValue.equals(TAG_CARD)) {
                    b2 = 5;
                }
                break;
            case 659653286:
                if (strValue.equals(TAG_GIF)) {
                    b2 = 11;
                }
                break;
            case 751141447:
                if (strValue.equals(TAG_IMG)) {
                    b2 = 10;
                }
                break;
            case 796721677:
                if (strValue.equals(TAG_LBS)) {
                    b2 = ci.k;
                }
                break;
            case 1044016768:
                if (strValue.equals(TAG_STK)) {
                    b2 = 4;
                }
                break;
            case 1076608122:
                if (strValue.equals(TAG_TXT)) {
                    b2 = 0;
                }
                break;
            case 1098742835:
                if (strValue.equals(TAG_VST)) {
                    b2 = 6;
                }
                break;
            case 1310555117:
                if (strValue.equals(TAG_SIGHT)) {
                    b2 = 9;
                }
                break;
        }
        switch (b2) {
            case 0:
                return userInfo.replace(MSG_TEXT, ((TextMessage) messageContent).getContent());
            case 1:
            case 2:
            case 3:
                return userInfo.replace(MSG_TEXT, getSpannable(messageContent));
            case 4:
                return userInfo.replace(MSG_TEXT, applicationContext.getString(R.string.rc_message_content_sticker));
            case 5:
                return userInfo.replace(MSG_TEXT, applicationContext.getString(R.string.rc_message_content_card));
            case 6:
            case 7:
                return userInfo.replace(MSG_TEXT, applicationContext.getString(R.string.rc_message_content_vst));
            case 8:
                return userInfo.replace(MSG_TEXT, applicationContext.getString(R.string.rc_message_content_rp));
            case 9:
                SightMessage sightMessage = (SightMessage) messageContent;
                return userInfo.replace(MSG_FILE_NAME, sightMessage.getName()).replace(MSG_SIZE, FileTypeUtils.formatFileSize(sightMessage.getSize())).replace(MSG_FILE_URL, sightMessage.getMediaUrl() != null ? sightMessage.getMediaUrl().toString() : "").replace(MSG_IMAGE_BASE64, getBase64FromUrl(sightMessage.getThumbUri())).replace(MSG_DURATION, String.valueOf(sightMessage.getDuration()));
            case 10:
                ImageMessage imageMessage = (ImageMessage) messageContent;
                return userInfo.replace(MSG_FILE_URL, imageMessage.getMediaUrl() != null ? imageMessage.getMediaUrl().toString() : "").replace(MSG_IMAG_URL, getBase64FromUrl(imageMessage.getThumUri()));
            case 11:
                GIFMessage gIFMessage = (GIFMessage) messageContent;
                return userInfo.replace(MSG_FILE_URL, gIFMessage.getRemoteUri() != null ? gIFMessage.getRemoteUri().toString() : "").replace(MSG_IMAG_URL, getBase64FromUrl(gIFMessage.getRemoteUri()));
            case 12:
                FileMessage fileMessage = (FileMessage) messageContent;
                return userInfo.replace(MSG_FILE_NAME, fileMessage.getName()).replace(MSG_SIZE, FileTypeUtils.formatFileSize(fileMessage.getSize())).replace(MSG_FILE_SIZE, String.valueOf(fileMessage.getSize())).replace(MSG_FILE_URL, fileMessage.getFileUrl() != null ? fileMessage.getFileUrl().toString() : "").replace(MSG_FILE_TYPE, fileMessage.getType()).replace(MSG_FILE_ICON, getBase64FromImageId(FileTypeUtils.fileTypeImageId(applicationContext, fileMessage.getName())));
            case 13:
                LocationMessage locationMessage = (LocationMessage) messageContent;
                return userInfo.replace(MSG_LOCATION_NAME, locationMessage.getPoi()).replace(MSG_LATITUDE, String.valueOf(locationMessage.getLat())).replace(MSG_LONGITTUDE, String.valueOf(locationMessage.getLng()));
            case 14:
                CombineMessage combineMessage = (CombineMessage) messageContent;
                StringBuilder sb = new StringBuilder();
                String htmlFromType = getHtmlFromType(TAG_MSG_COMBINE_BODY);
                Iterator<String> it = combineMessage.getSummaryList().iterator();
                while (it.hasNext()) {
                    sb.append(htmlFromType.replace(MSG_TEXT, it.next()));
                }
                return userInfo.replace(MSG_FILE_URL, combineMessage.getMediaUrl() != null ? combineMessage.getMediaUrl().toString() : "").replace(MSG_TITLE, combineMessage.getTitle()).replace(MSG_COMBINE_BODY, sb.toString()).replace(MSG_FOOT, applicationContext.getString(R.string.rc_combine_chat_history));
            default:
                RLog.e(TAG, "getHtmlFromMessageContent UnKnown type:" + strValue);
                return userInfo;
        }
    }

    private String getHtmlFromMessageList(List<Message> list) {
        StringBuilder sb = new StringBuilder();
        sb.append(getHtmlBaseHead());
        sb.append(getHtmlTime(list));
        for (Message message : list) {
            sb.append(getHtmlFromMessageContent(message, message.getContent()));
        }
        sb.append(getHtmlBaseBottom());
        return sb.toString();
    }

    private String getHtmlFromType(String str) {
        Map<String, String> map = this.DATA;
        if (map == null || map.size() == 0) {
            this.DATA = getDATA();
        }
        Map<String, String> map2 = this.DATA;
        if (map2 == null || map2.size() == 0) {
            RLog.e(TAG, "getHtmlFromType data is null");
            return "";
        }
        if (TAG_HQVC.equals(str)) {
            str = TAG_VC;
        }
        if (TAG_VST.equals(str)) {
            str = TAG_VCSUMMARY;
        }
        String str2 = this.DATA.get(str);
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        RLog.e(TAG, "getHtmlFromType html is null, type:" + str);
        return "";
    }

    private String getHtmlTime(List<Message> list) {
        String str;
        boolean z = false;
        long sentTime = list.get(0).getSentTime();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(sentTime);
        long sentTime2 = list.get(list.size() - 1).getSentTime();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(sentTime2);
        this.isSameYear = Boolean.valueOf(calendar.get(1) == calendar2.get(1));
        if (this.isSameYear.booleanValue() && calendar.get(2) == calendar2.get(2) && calendar.get(5) == calendar2.get(5)) {
            z = true;
        }
        this.isSameDay = Boolean.valueOf(z);
        if (this.isSameDay.booleanValue()) {
            str = new SimpleDateFormat("yyyy-M-d", Locale.CANADA).format(Long.valueOf(sentTime));
        } else {
            str = new SimpleDateFormat("yyyy-M-d", Locale.CANADA).format(Long.valueOf(sentTime)) + " - " + new SimpleDateFormat("yyyy-M-d", Locale.CANADA).format(Long.valueOf(sentTime2));
        }
        return getHtmlFromType(TAG_TIME).replace(MSG_TIME, str);
    }

    public static CombineMessageUtils getInstance() {
        return Holder.Utils;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.IOException, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    private String getJson() throws Throwable {
        String line;
        String string = "getJson";
        StringBuilder sb = new StringBuilder();
        ?? e2 = 0;
        e2 = 0;
        try {
            try {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(RongIM.getInstance().getApplicationContext().getAssets().open(JSON_FILE_NAME)));
                    while (true) {
                        try {
                            line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            sb.append(line);
                        } catch (IOException e3) {
                            e = e3;
                            e2 = bufferedReader;
                            RLog.e(TAG, "getJson", e);
                            if (e2 != 0) {
                                e2.close();
                                e2 = e2;
                            }
                            string = sb.toString();
                            return string;
                        } catch (Throwable th) {
                            th = th;
                            e2 = bufferedReader;
                            if (e2 != 0) {
                                try {
                                    e2.close();
                                } catch (IOException e4) {
                                    RLog.e(TAG, string, e4);
                                }
                            }
                            throw th;
                        }
                    }
                    bufferedReader.close();
                    e2 = line;
                } catch (IOException e5) {
                    e2 = e5;
                    RLog.e(TAG, "getJson", e2);
                }
            } catch (IOException e6) {
                e = e6;
            }
            string = sb.toString();
            return string;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private String getSendTime(Message message) {
        String string;
        String str;
        long sentTime = message.getSentTime();
        Context applicationContext = RongIM.getInstance().getApplicationContext();
        if (sentTime <= 0) {
            return "";
        }
        if (RongDateUtils.isTime24Hour(applicationContext)) {
            str = new SimpleDateFormat("H:mm", Locale.CANADA).format(Long.valueOf(sentTime));
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(sentTime);
            int i = calendar.get(10);
            int i2 = calendar.get(12);
            if (calendar.get(9) == 0) {
                if (i < 6) {
                    if (i == 0) {
                        i = 12;
                    }
                    string = applicationContext.getResources().getString(R.string.rc_daybreak_format);
                } else {
                    string = applicationContext.getResources().getString(R.string.rc_morning_format);
                }
            } else if (i == 0) {
                string = applicationContext.getResources().getString(R.string.rc_noon_format);
                i = 12;
            } else {
                string = i <= 5 ? applicationContext.getResources().getString(R.string.rc_afternoon_format) : applicationContext.getResources().getString(R.string.rc_night_format);
            }
            if (i2 < 10) {
                str = string + " " + i + ":0" + i2;
            } else {
                str = string + " " + i + ":" + i2;
            }
        }
        return new SimpleDateFormat(this.isSameDay.booleanValue() ? "" : this.isSameYear.booleanValue() ? "M-d " : "yyyy-M-d ", Locale.CANADA).format(Long.valueOf(sentTime)) + str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String getSpannable(MessageContent messageContent) {
        Spannable contentSummary = RongContext.getInstance().getMessageTemplate(messageContent.getClass()).getContentSummary(RongIM.getInstance().getApplicationContext(), messageContent);
        return contentSummary == null ? "" : contentSummary.toString();
    }

    private String getUserName(Message message) {
        UserInfo userInfo = RongUserInfoManager.getInstance().getUserInfo(message.getSenderUserId());
        return userInfo == null ? "" : userInfo.getName();
    }

    private String getUserPortrait(Message message) {
        UserInfo userInfo = RongUserInfoManager.getInstance().getUserInfo(message.getSenderUserId());
        if (userInfo == null) {
            RLog.d(TAG, "getUserPortrait userInfo is null, msg:" + message);
            return "";
        }
        Uri portraitUri = userInfo.getPortraitUri();
        if (portraitUri != null && !portraitUri.equals(this.URI)) {
            this.URI = portraitUri;
            return getBase64FromUrl(portraitUri);
        }
        Log.d(TAG, "getUserPortrait is same uri:" + portraitUri);
        return "";
    }

    private Map<String, String> setData(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.DATA.put(TAG_BASE_HEAD, jSONObject.optString(TAG_BASE_HEAD));
            this.DATA.put(TAG_TIME, jSONObject.optString(TAG_TIME));
            this.DATA.put(TAG_TXT, jSONObject.optString(TAG_TXT));
            this.DATA.put(TAG_SIGHT, jSONObject.optString(TAG_SIGHT));
            this.DATA.put(TAG_IMG, jSONObject.optString(TAG_IMG));
            this.DATA.put(TAG_GIF, jSONObject.optString(TAG_GIF));
            this.DATA.put(TAG_COMBINE, jSONObject.optString(TAG_COMBINE));
            this.DATA.put(TAG_MSG_COMBINE_BODY, jSONObject.optString(TAG_MSG_COMBINE_BODY));
            this.DATA.put(TAG_FILE, jSONObject.optString(TAG_FILE));
            this.DATA.put(TAG_VC, jSONObject.optString(TAG_VC));
            this.DATA.put(TAG_CARD, jSONObject.optString(TAG_CARD));
            this.DATA.put(TAG_STK, jSONObject.optString(TAG_STK));
            this.DATA.put(TAG_IMG_TEXT, jSONObject.optString(TAG_IMG_TEXT));
            this.DATA.put(TAG_LBS, jSONObject.optString(TAG_LBS));
            this.DATA.put(TAG_VCSUMMARY, jSONObject.optString(TAG_VCSUMMARY));
            this.DATA.put(TAG_RP, jSONObject.optString(TAG_RP));
            this.DATA.put(TAG_BASE_BOTTOM, jSONObject.optString(TAG_BASE_BOTTOM));
            return this.DATA;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return this.DATA;
        }
    }

    private String setUserInfo(String str, Message message) {
        String userPortrait = getUserPortrait(message);
        return str.replace(MSG_PORTRAIT, userPortrait).replace(MSG_SHOW_USER, TextUtils.isEmpty(userPortrait) ? NO_USER : "").replace(MSG_USER_NAMEM, getUserName(message)).replace(MSG_SEND_TIME, getSendTime(message));
    }

    public String getCombineFilePath(String str) {
        return FileUtils.getCachePath(RongIM.getInstance().getApplicationContext()) + File.separator + COMBINE_FILE_PATH + File.separator + RongUtils.md5(str) + COMBINE_FILE_SUFFIX;
    }

    Uri getUrlFromMessageList(List<Message> list) {
        this.style = "";
        this.URI = null;
        this.isSameYear = false;
        this.isSameDay = false;
        String str = FileUtils.getCachePath(RongIM.getInstance().getApplicationContext()) + File.separator + COMBINE_FILE_PATH + File.separator + System.currentTimeMillis() + COMBINE_FILE_SUFFIX;
        FileUtils.saveFile(getHtmlFromMessageList(list), str);
        return Uri.parse("file://" + str);
    }

    public void setStyle(String str) {
        this.style = str;
    }

    private CombineMessageUtils() {
        this.DATA = new HashMap();
        this.URI = null;
        this.style = "";
    }
}
