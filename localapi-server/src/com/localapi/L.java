package com.localapi;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Tiny logging facade: android.util.Log on device, stdout on the host JVM test rig.
 */
public final class L {

    private static boolean host;
    private static final Object FILE_LOCK = new Object();
    private static volatile File logDir;
    private static final long MAX_LOG_BYTES = 2L * 1024L * 1024L;

    /** Configure persistent diagnostics under the app-specific external files directory. */
    public static void configure(File filesRoot) {
        if (filesRoot == null) return;
        File dir = new File(filesRoot, "log");
        if (!dir.exists() && !dir.mkdirs() && !dir.isDirectory()) {
            System.err.println("[LocalAPI] unable to create log directory: " + dir);
            return;
        }
        logDir = dir;
        i("diagnostics: persistent logs enabled at " + dir.getAbsolutePath());
    }

    static String stackTrace(Throwable t) {
        if (t == null) return "null";
        java.io.StringWriter sw = new java.io.StringWriter();
        java.io.PrintWriter pw = new java.io.PrintWriter(sw);
        t.printStackTrace(pw);
        pw.flush();
        return sw.toString();
    }

    private static void writeFile(String level, String msg) {
        File dir = logDir;
        if (dir == null) return;
        String stamp;
        try {
            stamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US)
                    .format(new Date());
        } catch (Throwable ignored) {
            stamp = String.valueOf(System.currentTimeMillis());
        }
        byte[] bytes = (stamp + " [" + level + "] " + msg + "\n")
                .getBytes(StandardCharsets.UTF_8);
        synchronized (FILE_LOCK) {
            try {
                append(new File(dir, "app.log"), bytes);
                if ("ERROR".equals(level)) append(new File(dir, "error.log"), bytes);
                String m = msg == null ? "" : msg;
                if (m.startsWith("REQ ") || m.startsWith("RES ")
                        || m.startsWith("ASSET ") || m.startsWith("SKINICON ")) {
                    append(new File(dir, "network.log"), bytes);
                }
                if (m.startsWith("maps:") || m.startsWith("MAP_")
                        || m.startsWith("game-res ") || m.startsWith("dispatch ")
                        || m.startsWith("ASSET ")) {
                    append(new File(dir, "game.log"), bytes);
                }
            } catch (Throwable ignored) {
                // Diagnostics must never crash or block normal app behavior.
            }
        }
    }

    private static void append(File file, byte[] bytes) throws Exception {
        if (file.exists() && file.length() + bytes.length > MAX_LOG_BYTES) {
            File old = new File(file.getParentFile(), file.getName() + ".1");
            if (old.exists()) old.delete();
            if (!file.renameTo(old)) file.delete();
        }
        FileOutputStream out = new FileOutputStream(file, true);
        try {
            out.write(bytes);
            out.flush();
        } finally {
            out.close();
        }
    }

    static {
        try {
            Class.forName("android.util.Log");
        } catch (Throwable t) {
            host = true;
        }
    }

    private L() {}

    public static void i(String msg) {
        writeFile("INFO", msg);
        if (host) {
            System.out.println("[LocalAPI] " + msg);
        } else {
            try {
                android.util.Log.i("LocalAPI", msg);
            } catch (Throwable ignore) {
                System.out.println("[LocalAPI] " + msg);
            }
        }
    }

    public static void e(String msg) {
        writeFile("ERROR", msg);
        if (host) {
            System.err.println("[LocalAPI] " + msg);
        } else {
            try {
                android.util.Log.e("LocalAPI", msg);
            } catch (Throwable ignore) {
                System.err.println("[LocalAPI] " + msg);
            }
        }
    }
    /** GameServer stdout/stderr pump — tagged separately so it is filterable. */
    public static void gs(String msg) {
        writeFile("GAME", msg);
        if (host) {
            System.out.println("[GS] " + msg);
        } else {
            try {
                android.util.Log.i("GS", msg);
            } catch (Throwable ignore) {
                System.out.println("[GS] " + msg);
            }
        }
    }
}
