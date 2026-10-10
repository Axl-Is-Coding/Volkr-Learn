package com.sandboxol.file.f;

import android.content.Context;
import android.util.Log;
import com.sandboxol.common.utils.MD5Util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: FileUtil.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    public static boolean a(String str, String str2, String str3, MessageDigest messageDigest) {
        String fileMD5String = "";
        try {
            fileMD5String = MD5Util.getFileMD5String(new FileInputStream(str2 + str3), messageDigest);
            return fileMD5String.equals(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            Log.w("unZipCheckSoMd5", "realMd5 = " + str + "\npath = " + str2 + "\nfileName = " + str3 + "\nfromFileMd5 = " + fileMD5String);
            return false;
        }
    }

    public static String b(String str) {
        if (str.isEmpty()) {
            return "";
        }
        int iLastIndexOf = str.lastIndexOf(35);
        if (iLastIndexOf > 0) {
            str = str.substring(0, iLastIndexOf);
        }
        int iLastIndexOf2 = str.lastIndexOf(63);
        if (iLastIndexOf2 > 0) {
            str = str.substring(0, iLastIndexOf2);
        }
        int iLastIndexOf3 = str.lastIndexOf(47);
        if (iLastIndexOf3 >= 0) {
            str = str.substring(iLastIndexOf3 + 1);
        }
        return (str.isEmpty() || !Pattern.matches("[a-zA-Z_0-9.\\-()%]+", str)) ? "" : str;
    }

    public static boolean a(String str, String str2, String str3) throws Exception {
        String fileMD5String = MD5Util.getFileMD5String(new FileInputStream(str2 + str3));
        boolean zEquals = fileMD5String.equals(str);
        if (!zEquals) {
            Log.w("checkSoMd5", "realMd5 = " + str + "\npath = " + str2 + "\nfileName = " + str3 + "\nfromFileMd5 = " + fileMD5String);
        }
        return zEquals;
    }

    public static Map<String, String> a(Context context, String str, String str2) {
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        HashMap map = new HashMap();
        try {
            fileInputStream = new FileInputStream(str + "/" + str2);
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        } catch (Exception e2) {
            Log.e("PrivilegeInfo", e2.toString());
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

    public static boolean a(String str) {
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                System.out.println("删除单个文件" + str + "成功！");
                return true;
            }
            System.out.println("删除单个文件" + str + "失败！");
            return false;
        }
        System.out.println("删除单个文件失败：" + str + "不存在！");
        return false;
    }
}
