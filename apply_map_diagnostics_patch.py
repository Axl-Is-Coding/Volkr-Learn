#!/usr/bin/env python3
"""
Local-only diagnostic patcher for the Volkr-Learn / BlockyNexus checkout.

- Does NOT use GitHub, git, or the network.
- Does NOT patch an APK or change any repository remote.
- Updates maintained Java source only.
- Creates timestamped backups before writing.
- Run from the repository root:
    python3 tools/apply_map_diagnostics_patch.py
"""
from pathlib import Path
from datetime import datetime
import sys

ROOT = Path.cwd()
FILES = {
    "L": ROOT / "localapi-server/src/com/localapi/L.java",
    "LocalServer": ROOT / "localapi-server/src/com/localapi/LocalServer.java",
    "LocalHttpd": ROOT / "localapi-server/src/com/localapi/LocalHttpd.java",
    "MapAssets": ROOT / "localapi-server/src/com/localapi/MapAssets.java",
    "Handlers": ROOT / "localapi-server/src/com/localapi/Handlers.java",
}

missing = [str(p) for p in FILES.values() if not p.is_file()]
if missing:
    print("ERROR: Run this from the repository root; missing files:")
    print("\n".join("  " + x for x in missing))
    sys.exit(2)

texts = {name: path.read_text(encoding="utf-8") for name, path in FILES.items()}

def replace_once(name, old, new, label):
    src = texts[name]
    count = src.count(old)
    if count != 1:
        raise RuntimeError(
            f"{name}: expected exactly one match for {label}, found {count}. "
            "No files have been changed."
        )
    texts[name] = src.replace(old, new, 1)

# 1) Persistent logs: <external app files>/log/{app,error,network,game}.log
replace_once(
    "L",
    "package com.localapi;\n",
    """package com.localapi;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
""",
    "L.java imports",
)

replace_once(
    "L",
    """    private static boolean host;

    static {
""",
    """    private static boolean host;
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
        byte[] bytes = (stamp + " [" + level + "] " + msg + "\\n")
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
""",
    "L.java persistent logging fields",
)

replace_once(
    "L",
    """    public static void i(String msg) {
        if (host) {
""",
    """    public static void i(String msg) {
        writeFile("INFO", msg);
        if (host) {
""",
    "L.i file logging",
)
replace_once(
    "L",
    """    public static void e(String msg) {
        if (host) {
""",
    """    public static void e(String msg) {
        writeFile("ERROR", msg);
        if (host) {
""",
    "L.e file logging",
)
replace_once(
    "L",
    """    public static void gs(String msg) {
        if (host) {
""",
    """    public static void gs(String msg) {
        writeFile("GAME", msg);
        if (host) {
""",
    "L.gs file logging",
)

# 2) Configure persistent logs as early as LocalServer's Android entry point.
replace_once(
    "LocalServer",
    """        Context app = context.getApplicationContext();
        File filesDir = app.getFilesDir();
        // Seed assets ship inside the APK""",
    """        Context app = context.getApplicationContext();
        File filesDir = app.getFilesDir();
        File externalFilesDir = app.getExternalFilesDir(null);
        L.configure(externalFilesDir != null ? externalFilesDir : filesDir);
        L.i("diagnostics: device=" + android.os.Build.MANUFACTURER + " "
                + android.os.Build.MODEL + " sdk=" + android.os.Build.VERSION.SDK_INT
                + " filesDir=" + filesDir.getAbsolutePath()
                + " externalFilesDir=" + (externalFilesDir == null ? "null"
                        : externalFilesDir.getAbsolutePath()));
        // Seed assets ship inside the APK""",
    "LocalServer diagnostics initialization",
)

# 3) Expose a read-only map diagnostic endpoint and log asset requests that
# previously bypassed the normal REQ/RES logger.
replace_once(
    "LocalHttpd",
    """        // LocalServer.probeServing() liveness probe — answer silently (no REQ/
        // RES/UNMAPPED log noise in the diagnostics, the probe runs every few
        // seconds from every non-holder app process).
        if (uri != null && uri.endsWith("/health")) {""",
    """        // LocalServer.probeServing() liveness probe — answer silently (no REQ/
        // RES/UNMAPPED log noise in the diagnostics, the probe runs every few
        // seconds from every non-holder app process).
        if ("GET".equals(verb) && "/localapi/diagnostics/maps".equals(uri)) {
            L.i("MAP_DIAG endpoint requested");
            return respond(MapAssets.diagnosticsJson(store));
        }
        if (uri != null && uri.endsWith("/health")) {""",
    "LocalHttpd diagnostics endpoint",
)
replace_once(
    "LocalHttpd",
    """    private Response serveAsset(String uri) {
        byte[] data = uri.startsWith("/sandbox/dresses/dress-resources/")
""",
    """    private Response serveAsset(String uri) {
        L.i("ASSET REQ GET " + uri);
        byte[] data = uri.startsWith("/sandbox/dresses/dress-resources/")
""",
    "LocalHttpd asset request log",
)
replace_once(
    "LocalHttpd",
    """        if (data == null) {
            L.i("ASSET miss " + uri);
            return respond("{\\"code\\":0,\\"message\\":\\"asset not available\\"}");
        }""",
    """        if (data == null) {
            L.e("ASSET MISS " + uri
                    + " -> legacy HTTP 200 JSON miss envelope; inspect maps diagnostics");
            return respond("{\\"code\\":0,\\"message\\":\\"asset not available\\"}");
        }""",
    "LocalHttpd asset miss diagnostic",
)
replace_once(
    "LocalHttpd",
    """        L.i("ASSET " + uri + " " + data.length + "b " + mime);
        return r;""",
    """        L.i("ASSET OK " + uri + " bytes=" + data.length + " mime=" + mime);
        return r;""",
    "LocalHttpd asset success diagnostic",
)

# 4) Map index, lookup, pack, and file-resolution diagnostics.
replace_once(
    "MapAssets",
    """    static JSONObject entryForGame(String scriptType) {
        Map<String, JSONObject> g = byGame;
        if (g == null || scriptType == null) return null;
        return g.get(scriptType);
    }""",
    """    static JSONObject entryForGame(String scriptType) {
        Map<String, JSONObject> g = byGame;
        JSONObject entry = (g == null || scriptType == null)
                ? null : g.get(scriptType);
        if (entry == null) {
            L.e("MAP_LOOKUP_MISS scriptType=" + scriptType
                    + " indexed=" + indexed
                    + " games=" + (g == null ? -1 : g.size())
                    + " files=" + (byKey == null ? -1 : byKey.size()));
        } else {
            L.i("MAP_LOOKUP_HIT scriptType=" + scriptType
                    + " zipName=" + entry.optString("zipName")
                    + " version=" + entry.optInt("version", 0));
        }
        return entry;
    }""",
    "MapAssets entry lookup",
)
replace_once(
    "MapAssets",
    """    static byte[] fileBytes(StateStore store, String key) {
        File f = resolveUri(store, key);
        if (f == null || !f.exists() || f.length() == 0) return null;
        try {
            return slurpBin(f);
        } catch (Throwable t) {
            L.e("maps: read failed " + key + ": " + t);
            return null;
        }
    }""",
    """    static byte[] fileBytes(StateStore store, String key) {
        File f = resolveUri(store, key);
        if (f == null) {
            L.e("MAP_FILE_MISS key=" + key
                    + " indexed=" + indexed
                    + " games=" + (byGame == null ? -1 : byGame.size())
                    + " files=" + (byKey == null ? -1 : byKey.size())
                    + " mapsDir=" + mapsDir(store).getAbsolutePath());
            return null;
        }
        if (!f.exists() || !f.isFile() || f.length() == 0) {
            L.e("MAP_FILE_INVALID key=" + key + " path=" + f.getAbsolutePath()
                    + " exists=" + f.exists() + " file=" + f.isFile()
                    + " bytes=" + f.length());
            return null;
        }
        try {
            byte[] data = slurpBin(f);
            L.i("MAP_FILE_OK key=" + key + " path=" + f.getAbsolutePath()
                    + " bytes=" + data.length);
            return data;
        } catch (Throwable t) {
            L.e("maps: read failed " + key + ": " + L.stackTrace(t));
            return null;
        }
    }""",
    "MapAssets fileBytes diagnostics",
)
replace_once(
    "MapAssets",
    """                    } catch (Throwable t) {
                        // best-effort: the API stays fully functional, the
                        // engine simply has no map bundles until a later
                        // boot retry succeeds.
                        L.i("maps: pack unavailable: "
                                + t.getClass().getSimpleName());
                    }""",
    """                    } catch (Throwable t) {
                        // Best-effort: keep the API alive, but preserve the
                        // complete reason in persistent diagnostics.
                        L.e("maps: pack unavailable: " + L.stackTrace(t));
                    }""",
    "MapAssets pack thread exception detail",
)
replace_once(
    "MapAssets",
    """            } catch (IOException e) {
                last = e;
                try {""",
    """            } catch (IOException e) {
                last = e;
                L.e("maps: download attempt " + i + " failed: " + e);
                try {""",
    "MapAssets download attempt detail",
)
replace_once(
    "MapAssets",
    """    /** True once any servable files are indexed. */
    static boolean hasIndex() {
        return indexed && !byKey.isEmpty();
    }
""",
    """    /** True once any servable files are indexed. */
    static boolean hasIndex() {
        return indexed && !byKey.isEmpty();
    }

    /** Read-only diagnostics snapshot for the loopback endpoint and log files. */
    static String diagnosticsJson(StateStore store) {
        JSONObject out = new JSONObject();
        File dir = mapsDir(store);
        File pack = packFile(store);
        File index = indexFile(store);
        File manifest = new File(dir, "_manifest/manifest.csv");
        File games = new File(dir, "_manifest/games.csv");
        try {
            out.put("indexed", indexed);
            out.put("hasIndex", hasIndex());
            out.put("gameCount", byGame == null ? 0 : byGame.size());
            out.put("indexedFileCount", byKey == null ? 0 : byKey.size());
            out.put("mapsDir", dir.getAbsolutePath());
            out.put("mapsDirExists", dir.isDirectory());
            out.put("packPath", pack.getAbsolutePath());
            out.put("packExists", pack.isFile());
            out.put("packBytes", pack.isFile() ? pack.length() : 0);
            out.put("indexPath", index.getAbsolutePath());
            out.put("indexExists", index.isFile());
            out.put("indexBytes", index.isFile() ? index.length() : 0);
            out.put("manifestExists", manifest.isFile());
            out.put("gamesManifestExists", games.isFile());
            org.json.JSONArray samples = new org.json.JSONArray();
            if (byGame != null) {
                int n = 0;
                for (String key : byGame.keySet()) {
                    samples.put(key);
                    if (++n >= 12) break;
                }
            }
            out.put("sampleGameIds", samples);
        } catch (Throwable t) {
            L.e("MAP_DIAG snapshot failed: " + L.stackTrace(t));
            try { out.put("diagnosticError", String.valueOf(t)); }
            catch (Throwable ignored) {}
        }
        String json = out.toString();
        L.i("MAP_DIAG " + json);
        return json;
    }
""",
    "MapAssets diagnostics snapshot",
)

# 5) Log the raw and normalized game resource ID and the dispatch map URL decision.
replace_once(
    "Handlers",
    """        String gameType = ctx.query("gameType");
        long clientV = rv == null || rv.isEmpty() ? 0 : parseLong(rv, 0);
        JSONObject out = new JSONObject();""",
    """        String gameType = ctx.query("gameType");
        long clientV = rv == null || rv.isEmpty() ? 0 : parseLong(rv, 0);
        L.i("MAP_GAME_RES request rawGameType=" + gameType
                + " resVersion=" + clientV + " index=" + MapAssets.hasIndex());
        JSONObject out = new JSONObject();""",
    "Handlers gameResInfo request trace",
)
replace_once(
    "Handlers",
    """        } else {
            out.put("durl", "");
            out.put("resVersion", (int) Math.max(1, clientV));
        }
        return envelope("obj", out.toString());
    }

    /**
     * GET /decoration/api/v1/new/decorations/check/resource""",
    """        } else {
            out.put("durl", "");
            out.put("resVersion", (int) Math.max(1, clientV));
            L.e("MAP_GAME_RES_NO_ENTRY rawGameType=" + gameType
                    + " normalizedScript=" + script
                    + " index=" + MapAssets.hasIndex()
                    + " response=durl-empty");
        }
        return envelope("obj", out.toString());
    }

    /**
     * GET /decoration/api/v1/new/decorations/check/resource""",
    "Handlers gameResInfo miss trace",
)
replace_once(
    "Handlers",
    """        out.put("downurl", mapEntry == null ? "" : MapAssets.durlFor(mapEntry));
        out.put("name", name);""",
    """        String downurl = mapEntry == null ? "" : MapAssets.durlFor(mapEntry);
        out.put("downurl", downurl);
        L.i("MAP_DISPATCH gameType=" + gameType + " engineType=" + engineType
                + " mapEntry=" + (mapEntry != null)
                + " downurlPresent=" + !downurl.isEmpty()
                + " downurl=" + downurl);
        out.put("name", name);""",
    "Handlers dispatch map URL trace",
)

# All transformations succeeded in memory. Only now create backups and write.
timestamp = datetime.now().strftime("%Y%m%d-%H%M%S")
backup_dir = ROOT / (".map-diagnostics-backup-" + timestamp)
backup_dir.mkdir()
for name, path in FILES.items():
    (backup_dir / path.name).write_text(path.read_text(encoding="utf-8"), encoding="utf-8")

for name, path in FILES.items():
    path.write_text(texts[name], encoding="utf-8", newline="\n")

print("Applied local-only map diagnostics patch.")
print("Changed files:")
for path in FILES.values():
    print("  " + str(path.relative_to(ROOT)))
print("Backup directory: " + str(backup_dir.relative_to(ROOT)))
print()
print("After rebuilding/installing the APK, reproduce one failed map load.")
print("Logs should appear under:")
print("  /storage/emulated/0/Android/data/com.disabngo.blockynexus/files/log/")
print("Files: app.log, error.log, network.log, game.log (with .1 rotation backups).")
print("Optional loopback diagnostics endpoint:")
print("  http://127.0.0.1:18080/localapi/diagnostics/maps")
print("This patch intentionally does not change the map-miss HTTP status or map selection behavior.")
