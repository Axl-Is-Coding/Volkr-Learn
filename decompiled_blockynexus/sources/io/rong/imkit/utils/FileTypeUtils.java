package io.rong.imkit.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import androidx.core.content.FileProvider;
import androidx.core.os.b;
import cn.qqtheme.framework.util.ConvertUtils;
import com.alibaba.android.arouter.utils.Consts;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import fi.iki.elonen.NanoHTTPD;
import io.rong.common.FileUtils;
import io.rong.common.RLog;
import io.rong.imkit.R;
import io.rong.imkit.RongIM;
import io.rong.imkit.model.FileInfo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class FileTypeUtils {
    public static final FileFilter ALL_FOLDER_AND_FILES_FILTER = new FileFilter() { // from class: io.rong.imkit.utils.FileTypeUtils.1
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return !file.isHidden();
        }
    };
    public static final int GIGABYTE = 1073741824;
    public static final int KILOBYTE = 1024;
    public static final int MEGABYTE = 1048576;
    private static final String TAG = "FileTypeUtils";

    public static class FileNameComparator implements Comparator<FileInfo> {
        protected static final int FIRST = -1;
        protected static final int SECOND = 1;

        @Override // java.util.Comparator
        public int compare(FileInfo fileInfo, FileInfo fileInfo2) {
            return (fileInfo.isDirectory() || fileInfo2.isDirectory()) ? fileInfo.isDirectory() == fileInfo2.isDirectory() ? fileInfo.getFileName().compareToIgnoreCase(fileInfo2.getFileName()) : fileInfo.isDirectory() ? -1 : 1 : fileInfo.getFileName().compareToIgnoreCase(fileInfo2.getFileName());
        }
    }

    public static final class FileTypeFilter implements FileFilter {
        private String[] filesSuffix;

        public FileTypeFilter(String[] strArr) {
            this.filesSuffix = strArr;
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return !file.isHidden() && (file.isDirectory() || FileTypeUtils.checkSuffix(file.getName(), this.filesSuffix));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean checkSuffix(String str, String[] strArr) {
        for (String str2 : strArr) {
            if (str != null && str.toLowerCase().endsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    public static int fileTypeImageId(Context context, String str) {
        return context == null ? R.drawable.rc_file_icon_file : checkSuffix(str, context.getResources().getStringArray(R.array.rc_image_file_suffix)) ? R.drawable.rc_file_icon_picture : checkSuffix(str, context.getResources().getStringArray(R.array.rc_file_file_suffix)) ? R.drawable.rc_file_icon_file : checkSuffix(str, context.getResources().getStringArray(R.array.rc_video_file_suffix)) ? R.drawable.rc_file_icon_video : checkSuffix(str, context.getResources().getStringArray(R.array.rc_audio_file_suffix)) ? R.drawable.rc_file_icon_audio : checkSuffix(str, context.getResources().getStringArray(R.array.rc_word_file_suffix)) ? R.drawable.rc_file_icon_word : checkSuffix(str, context.getResources().getStringArray(R.array.rc_excel_file_suffix)) ? R.drawable.rc_file_icon_excel : checkSuffix(str, context.getResources().getStringArray(R.array.rc_ppt_file_suffix)) ? R.drawable.rc_file_icon_ppt : checkSuffix(str, context.getResources().getStringArray(R.array.rc_pdf_file_suffix)) ? R.drawable.rc_file_icon_pdf : checkSuffix(str, context.getResources().getStringArray(R.array.rc_apk_file_suffix)) ? R.drawable.rc_file_icon_apk : checkSuffix(str, context.getResources().getStringArray(R.array.rc_key_file_suffix)) ? R.drawable.rc_file_icon_key : checkSuffix(str, context.getResources().getStringArray(R.array.rc_numbers_file_suffix)) ? R.drawable.rc_file_icon_numbers : checkSuffix(str, context.getResources().getStringArray(R.array.rc_pages_file_suffix)) ? R.drawable.rc_file_icon_pages : R.drawable.rc_file_icon_else;
    }

    public static String formatFileSize(long j) {
        return j < 1024 ? String.format("%d B", Integer.valueOf((int) j)) : j < 1048576 ? String.format("%.2f KB", Float.valueOf(j / 1024.0f)) : j < ConvertUtils.GB ? String.format("%.2f MB", Float.valueOf(j / 1048576.0f)) : String.format("%.2f G", Float.valueOf(j / 1.0737418E9f));
    }

    public static List<FileInfo> getAudioFilesInfo(Context context, File file) {
        ArrayList arrayList = new ArrayList();
        if (context == null) {
            return arrayList;
        }
        getFileInfos(file, new FileTypeFilter(context.getResources().getStringArray(R.array.rc_audio_file_suffix)), arrayList);
        return arrayList;
    }

    public static String[] getExternalStorageDirectories(Context context) {
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 19) {
            for (File file : context.getExternalFilesDirs(null)) {
                if (file != null) {
                    String str = file.getPath().split("/Android")[0];
                    if (Build.VERSION.SDK_INT >= 21 ? Environment.isExternalStorageRemovable(file) : "mounted".equals(b.a(file))) {
                        arrayList.add(str);
                    }
                }
            }
        }
        if (arrayList.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            try {
                Process processStart = new ProcessBuilder(new String[0]).command("mount").redirectErrorStream(true).start();
                processStart.waitFor();
                InputStream inputStream = processStart.getInputStream();
                byte[] bArr = new byte[1024];
                while (inputStream.read(bArr) != -1) {
                    sb.append(new String(bArr));
                }
                inputStream.close();
            } catch (Exception e2) {
                RLog.e(TAG, "getExternalStorageDirectories", e2);
            }
            for (String str2 : sb.toString().split(UMCustomLogInfoBuilder.LINE_SEP)) {
                if (!str2.toLowerCase(Locale.US).contains("asec") && str2.matches("(?i).*vold.*(vfat|ntfs|exfat|fat32|ext3|ext4).*rw.*")) {
                    for (String str3 : str2.split(" ")) {
                        if (str3.startsWith("/") && !str3.toLowerCase(Locale.US).contains("vold")) {
                            arrayList.add(str3);
                        }
                    }
                }
            }
        }
        if (Build.VERSION.SDK_INT >= 23) {
            int i = 0;
            while (i < arrayList.size()) {
                if (!((String) arrayList.get(i)).toLowerCase().matches(".*[0-9a-f]{4}[-][0-9a-f]{4}")) {
                    arrayList.remove(i);
                    i--;
                }
                i++;
            }
        } else {
            int i2 = 0;
            while (i2 < arrayList.size()) {
                if (!((String) arrayList.get(i2)).toLowerCase().contains("ext") && !((String) arrayList.get(i2)).toLowerCase().contains("sdcard")) {
                    arrayList.remove(i2);
                    i2--;
                }
                i2++;
            }
        }
        String[] strArr = new String[arrayList.size()];
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            strArr[i3] = (String) arrayList.get(i3);
        }
        return strArr;
    }

    public static int getFileIconResource(Context context, FileInfo fileInfo) {
        return fileInfo.isDirectory() ? R.drawable.rc_ad_list_folder_icon : getFileTypeImageId(context, fileInfo.getFileName());
    }

    private static FileInfo getFileInfoFromFile(File file) {
        FileInfo fileInfo = new FileInfo();
        fileInfo.setFileName(file.getName());
        fileInfo.setFilePath(file.getPath());
        fileInfo.setDirectory(file.isDirectory());
        if (file.isDirectory()) {
            fileInfo.setFileSize(getNumFilesInFolder(fileInfo));
        } else {
            fileInfo.setFileSize(file.length());
        }
        int iLastIndexOf = file.getName().lastIndexOf(Consts.DOT);
        if (iLastIndexOf > 0) {
            fileInfo.setSuffix(file.getName().substring(iLastIndexOf + 1));
        }
        return fileInfo;
    }

    private static void getFileInfos(File file, FileFilter fileFilter, List<FileInfo> list) {
        File[] fileArrListFiles = file.listFiles(fileFilter);
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    getFileInfos(file2, fileFilter, list);
                } else if (file2.length() != 0) {
                    list.add(getFileInfoFromFile(file2));
                }
            }
        }
    }

    public static List<FileInfo> getFileInfosFromFileArray(File[] fileArr) {
        ArrayList arrayList = new ArrayList();
        for (File file : fileArr) {
            arrayList.add(getFileInfoFromFile(file));
        }
        return arrayList;
    }

    private static int getFileTypeImageId(Context context, String str) {
        return checkSuffix(str, context.getResources().getStringArray(R.array.rc_file_file_suffix)) ? R.drawable.rc_ad_list_file_icon : checkSuffix(str, context.getResources().getStringArray(R.array.rc_video_file_suffix)) ? R.drawable.rc_ad_list_video_icon : checkSuffix(str, context.getResources().getStringArray(R.array.rc_audio_file_suffix)) ? R.drawable.rc_ad_list_audio_icon : checkSuffix(str, context.getResources().getStringArray(R.array.rc_ppt_file_suffix)) ? R.drawable.rc_ad_list_ppt_icon : checkSuffix(str, context.getResources().getStringArray(R.array.rc_pdf_file_suffix)) ? R.drawable.rc_ad_list_pdf_icon : checkSuffix(str, context.getResources().getStringArray(R.array.rc_image_file_suffix)) ? R.drawable.rc_file_icon_picture : checkSuffix(str, context.getResources().getStringArray(R.array.rc_apk_file_suffix)) ? R.drawable.rc_file_icon_apk : checkSuffix(str, context.getResources().getStringArray(R.array.rc_word_file_suffix)) ? R.drawable.rc_file_icon_word : checkSuffix(str, context.getResources().getStringArray(R.array.rc_excel_file_suffix)) ? R.drawable.rc_file_icon_excel : checkSuffix(str, context.getResources().getStringArray(R.array.rc_key_file_suffix)) ? R.drawable.rc_ad_list_key_icon : checkSuffix(str, context.getResources().getStringArray(R.array.rc_numbers_file_suffix)) ? R.drawable.rc_ad_list_numbers_icon : checkSuffix(str, context.getResources().getStringArray(R.array.rc_pages_file_suffix)) ? R.drawable.rc_ad_list_pages_icon : R.drawable.rc_ad_list_other_icon;
    }

    private static String getIntentType(Context context, Intent intent, String str) {
        String str2;
        if (checkSuffix(str, context.getResources().getStringArray(R.array.rc_image_file_suffix))) {
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addFlags(268435456);
            str2 = "image/*";
        } else {
            str2 = null;
        }
        if (checkSuffix(str, context.getResources().getStringArray(R.array.rc_file_file_suffix))) {
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addFlags(268435456);
            str2 = NanoHTTPD.MIME_PLAINTEXT;
        }
        if (checkSuffix(str, context.getResources().getStringArray(R.array.rc_video_file_suffix))) {
            intent.addFlags(67108864);
            intent.putExtra("oneshot", 0);
            intent.putExtra("configchange", 0);
            str2 = "video/*";
        }
        if (checkSuffix(str, context.getResources().getStringArray(R.array.rc_audio_file_suffix))) {
            intent.addFlags(67108864);
            intent.putExtra("oneshot", 0);
            intent.putExtra("configchange", 0);
            str2 = "audio/*";
        }
        if (checkSuffix(str, context.getResources().getStringArray(R.array.rc_word_file_suffix))) {
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addFlags(268435456);
            str2 = "application/msword";
        }
        if (checkSuffix(str, context.getResources().getStringArray(R.array.rc_excel_file_suffix))) {
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addFlags(268435456);
            str2 = "application/vnd.ms-excel";
        }
        if (checkSuffix(str, context.getResources().getStringArray(R.array.rc_pdf_file_suffix))) {
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addFlags(268435456);
            str2 = "application/pdf";
        }
        if (!checkSuffix(str, context.getResources().getStringArray(R.array.rc_ppt_file_suffix))) {
            return str2;
        }
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(268435456);
        return "application/vnd.ms-powerpoint";
    }

    public static int getNumFilesInFolder(FileInfo fileInfo) {
        File[] fileArrListFiles;
        if (fileInfo.isDirectory() && (fileArrListFiles = new File(fileInfo.getFilePath()).listFiles(ALL_FOLDER_AND_FILES_FILTER)) != null) {
            return fileArrListFiles.length;
        }
        return 0;
    }

    public static Intent getOpenFileIntent(String str, String str2) {
        String intentType;
        Intent intent = new Intent("android.intent.action.VIEW");
        if (RongIM.getInstance().getApplicationContext() == null || (intentType = getIntentType(RongIM.getInstance().getApplicationContext(), intent, str)) == null || str2 == null || !isIntentHandlerAvailable(RongIM.getInstance().getApplicationContext(), intent)) {
            return null;
        }
        intent.setDataAndType(FileProvider.getUriForFile(RongIM.getInstance().getApplicationContext(), RongIM.getInstance().getApplicationContext().getPackageName() + RongIM.getInstance().getApplicationContext().getResources().getString(R.string.rc_authorities_fileprovider), new File(str2)), intentType);
        return intent;
    }

    public static List<FileInfo> getOtherFilesInfo(Context context, File file) {
        ArrayList arrayList = new ArrayList();
        if (context == null) {
            return arrayList;
        }
        getFileInfos(file, new FileTypeFilter(context.getResources().getStringArray(R.array.rc_other_file_suffix)), arrayList);
        return arrayList;
    }

    public static List<FileInfo> getTextFilesInfo(Context context, File file) {
        ArrayList arrayList = new ArrayList();
        if (context == null) {
            return arrayList;
        }
        getFileInfos(file, new FileTypeFilter(context.getResources().getStringArray(R.array.rc_file_file_suffix)), arrayList);
        return arrayList;
    }

    public static List<FileInfo> getVideoFilesInfo(Context context, File file) {
        ArrayList arrayList = new ArrayList();
        if (context == null) {
            return arrayList;
        }
        getFileInfos(file, new FileTypeFilter(context.getResources().getStringArray(R.array.rc_video_file_suffix)), arrayList);
        return arrayList;
    }

    private static boolean isIntentHandlerAvailable(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    public String getSDCardPath() {
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        if (absolutePath.endsWith("/")) {
            absolutePath = absolutePath.substring(0, absolutePath.length() - 1);
        }
        String str = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("mount").getInputStream()));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                if (line.toLowerCase().contains("sdcard") && line.contains(".android_secure")) {
                    String[] strArrSplit = line.split(" ");
                    if (strArrSplit.length > 1) {
                        String strReplace = strArrSplit[1].replace("/.android_secure", "");
                        if (!absolutePath.equals(strReplace)) {
                            str = strReplace;
                        }
                    }
                }
            }
        } catch (Exception e2) {
            RLog.e(TAG, "getSDCardPath", e2);
        }
        return str;
    }

    public static Intent getOpenFileIntent(Context context, String str, Uri uri) {
        Intent intent;
        String intentType;
        if (context == null || (intentType = getIntentType(context, (intent = new Intent("android.intent.action.VIEW")), str)) == null || uri == null || !isIntentHandlerAvailable(context, intent)) {
            return null;
        }
        if (FileUtils.uriStartWithContent(uri)) {
            intent.setDataAndType(uri, intentType);
        } else {
            String string = uri.toString();
            if (FileUtils.uriStartWithFile(uri)) {
                string = string.substring(7);
            }
            intent.setDataAndType(FileProvider.getUriForFile(context, context.getPackageName() + context.getResources().getString(R.string.rc_authorities_fileprovider), new File(string)), intentType);
        }
        return intent;
    }
}
