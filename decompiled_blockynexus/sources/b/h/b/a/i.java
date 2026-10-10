package b.h.b.a;

import android.content.Context;
import android.text.format.Formatter;
import android.util.Log;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: FileUtil.java */
/* JADX INFO: loaded from: classes3.dex */
public class i {
    public static String a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int i = inputStream.read();
            if (i == -1) {
                return byteArrayOutputStream.toString();
            }
            byteArrayOutputStream.write(i);
        }
    }

    public static long b(File file) {
        long jB = 0;
        try {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                for (int i = 0; i < fileArrListFiles.length; i++) {
                    jB += fileArrListFiles[i].isDirectory() ? b(fileArrListFiles[i]) : fileArrListFiles[i].length();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jB;
    }

    public static String a(Context context, Long l) {
        return (l == null || l.longValue() < 0) ? "0" : Formatter.formatFileSize(context, l.longValue());
    }

    public static boolean a(File file) {
        if (file.isDirectory()) {
            for (String str : file.list()) {
                if (!a(new File(file, str))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static Map<String, String> a(String str) {
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        HashMap map = new HashMap();
        try {
            fileInputStream = new FileInputStream(str);
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        } catch (Exception e2) {
            Log.e("getMapMD5List", e2.toString());
        }
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            String[] strArrSplit = line.split("\\*");
            map.put(strArrSplit[1], strArrSplit[0].replace(" ", ""));
            return map;
        }
        fileInputStream.close();
        return map;
    }
}
