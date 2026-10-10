package com.tendcloud.tenddata;

import android.content.Context;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public final class cm {
    static void a(Context context, String str, String str2) {
        if (str.isEmpty() || str2 == null || str2.isEmpty()) {
            return;
        }
        File file = new File(context.getFilesDir() + "/rHAR/");
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            FileWriter fileWriter = new FileWriter(new File(file, str2), true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(str + UMCustomLogInfoBuilder.LINE_SEP);
            bufferedWriter.close();
            fileWriter.close();
        } catch (Throwable unused) {
        }
    }

    public static void b(Context context, String str, String str2) {
        if (str.isEmpty() || str2 == null || str2.isEmpty()) {
            return;
        }
        File file = new File(context.getFilesDir() + "/rHAR/");
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, str2);
        if (file2.exists()) {
            file2.delete();
        }
        try {
            FileWriter fileWriter = new FileWriter(file2);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(str);
            bufferedWriter.close();
            fileWriter.close();
        } catch (Throwable unused) {
        }
    }

    private static void c(Context context, String str) {
        try {
            File file = new File(new File(context.getFilesDir() + "/rHAR/"), str);
            if (file.exists()) {
                file.delete();
            }
        } catch (Throwable unused) {
        }
    }

    static void c(Context context, String str, String str2) {
        if (b(context, str2) != null) {
            c(context, str2);
        }
        a(context, str, str2);
    }

    static String a(Context context, String str) {
        return a(context, str, false);
    }

    static String a(Context context, String str, boolean z) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        File file = new File(context.getFilesDir() + "/rHAR/");
        if (!file.exists() && !file.mkdirs()) {
            m.dForInternal("POIFileUtil", "Failed to create directory: " + file.getAbsolutePath());
        }
        File file2 = new File(file, str);
        if (!file2.exists()) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file2));
            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                sb.append(line);
                if (z) {
                    break;
                }
                sb.append('\n');
            }
            bufferedReader.close();
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String b(Context context, String str) {
        if (str != null && !str.isEmpty()) {
            File file = new File(context.getFilesDir() + "/rHAR/");
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, str);
            if (file2.exists()) {
                try {
                    StringBuilder sb = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file2));
                    if (bufferedReader.readLine() != null) {
                        for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                            sb.append(line);
                            sb.append('\n');
                        }
                        bufferedReader.close();
                    }
                    return sb.toString();
                } catch (Throwable unused) {
                }
            }
        }
        return null;
    }
}
