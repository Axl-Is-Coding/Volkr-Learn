package io.rong.imlib.filetransfer;

import android.text.TextUtils;
import com.alibaba.android.arouter.utils.Consts;
import io.rong.common.LibStorageUtils;
import io.rong.imlib.filetransfer.FtConst;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes5.dex */
public class FtUtilities {
    public static String generateKey(String str) {
        String str2 = str.replace("/", "_") + "__RC-";
        long jCurrentTimeMillis = System.currentTimeMillis();
        return ((str2 + new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(new Date(jCurrentTimeMillis))) + "_" + (((int) (Math.random() * 1000.0d)) % 10000)) + "_" + jCurrentTimeMillis;
    }

    public static String getCateDir(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "private" : "reception" : "chatroom" : "group" : "discussion" : "private";
    }

    public static String getFileKey(String str) {
        int iIndexOf = str.indexOf("?");
        if (iIndexOf != -1) {
            str = str.substring(0, iIndexOf);
        }
        int iLastIndexOf = str.lastIndexOf("/");
        if (iLastIndexOf != -1) {
            str = str.substring(iLastIndexOf + 1);
        }
        return str.replaceAll("%2F", "_");
    }

    public static String getFileName(String str, String str2) {
        String str3;
        String strSubstring = "";
        if (str2 == null) {
            return "";
        }
        int i = 0;
        if (str2.lastIndexOf(Consts.DOT) > 0) {
            strSubstring = str2.substring(str2.lastIndexOf(Consts.DOT));
            str2 = str2.substring(0, str2.lastIndexOf(Consts.DOT));
        }
        String strReplaceAll = Pattern.compile("[`!@#$%^&*()+=|{}':;',//[//].<>/?！@#￥%……&*（）——+|{}【】‘；：”“’。，、？~~]").matcher(str2).replaceAll("_");
        File file = new File(str, strReplaceAll + strSubstring);
        while (file.exists()) {
            i++;
            if (TextUtils.isEmpty(strSubstring)) {
                str3 = strReplaceAll + "(" + i + ")";
            } else {
                str3 = strReplaceAll + "(" + i + ")" + strSubstring;
            }
            file = new File(str, str3);
        }
        return file.getPath();
    }

    public static String getMediaDir(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "image" : LibStorageUtils.FILE : "video" : LibStorageUtils.AUDIO : "image";
    }

    public static FtConst.MimeType getMimeType(String str) {
        return isImageFile(str) ? FtConst.MimeType.FILE_IMAGE : isAudioFile(str) ? FtConst.MimeType.FILE_AUDIO : isVideoFile(str) ? FtConst.MimeType.FILE_VIDEO : isHtmlFile(str) ? FtConst.MimeType.FILE_HTML : FtConst.MimeType.FILE_TEXT_PLAIN;
    }

    public static String getSuffixName(String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] strArrSplit = str.split("\\.");
            if (strArrSplit.length > 1) {
                return Consts.DOT + strArrSplit[strArrSplit.length - 1];
            }
        }
        return "";
    }

    private static boolean isAudioFile(String str) {
        for (String str2 : new String[]{".au", ".snd", ".mid", ".rmi", ".aif", ".aifc", ".aiff", ".m3u", ".ra", ".ram", ".wav", ".aac"}) {
            if (str.toLowerCase().endsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isFileExist(String str) {
        return new File(str).exists();
    }

    private static boolean isHtmlFile(String str) {
        for (String str2 : new String[]{".html"}) {
            if (str.toLowerCase().endsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isImageFile(String str) {
        for (String str2 : new String[]{".bmp", ".cod", ".gif", ".ief", ".jpe", ".jpeg", ".jpg", ".jfif", ".svg", ".tif", ".tiff", ".ras", ".ico", ".pnm", ".pbm", ".pgm", ".ppm", ".xbm", ".xpm", ".xwd", ".rgb"}) {
            if (str.toLowerCase().endsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isVideoFile(String str) {
        for (String str2 : new String[]{".rmvb", ".avi", ".mp4", ".mp2", ".mpa", ".mpe", ".mpeg", ".mpg", ".mpv2", ".mov", ".qt", ".lsf", ".lsx", ".asf", ".asr", ".asx", ".avi", ".movie"}) {
            if (str.toLowerCase().endsWith(str2)) {
                return true;
            }
        }
        return false;
    }
}
