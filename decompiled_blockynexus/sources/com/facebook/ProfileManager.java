package com.facebook;

import android.content.Intent;
import androidx.localbroadcastmanager.a.b;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;

/* JADX INFO: loaded from: classes.dex */
public final class ProfileManager {
    public static final String ACTION_CURRENT_PROFILE_CHANGED = "com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED";
    public static final String EXTRA_NEW_PROFILE = "com.facebook.sdk.EXTRA_NEW_PROFILE";
    public static final String EXTRA_OLD_PROFILE = "com.facebook.sdk.EXTRA_OLD_PROFILE";
    private static volatile ProfileManager instance;
    private Profile currentProfile;
    private final b localBroadcastManager;
    private final ProfileCache profileCache;

    ProfileManager(b bVar, ProfileCache profileCache) {
        Validate.notNull(bVar, "localBroadcastManager");
        Validate.notNull(profileCache, "profileCache");
        this.localBroadcastManager = bVar;
        this.profileCache = profileCache;
    }

    static ProfileManager getInstance() {
        if (instance == null) {
            synchronized (ProfileManager.class) {
                if (instance == null) {
                    instance = new ProfileManager(b.a(FacebookSdk.getApplicationContext()), new ProfileCache());
                }
            }
        }
        return instance;
    }

    private void sendCurrentProfileChangedBroadcast(Profile profile, Profile profile2) {
        Intent intent = new Intent(ACTION_CURRENT_PROFILE_CHANGED);
        intent.putExtra(EXTRA_OLD_PROFILE, profile);
        intent.putExtra(EXTRA_NEW_PROFILE, profile2);
        this.localBroadcastManager.a(intent);
    }

    Profile getCurrentProfile() {
        return this.currentProfile;
    }

    boolean loadCurrentProfile() {
        Profile profileLoad = this.profileCache.load();
        if (profileLoad == null) {
            return false;
        }
        setCurrentProfile(profileLoad, false);
        return true;
    }

    void setCurrentProfile(Profile profile) {
        setCurrentProfile(profile, true);
    }

    private void setCurrentProfile(Profile profile, boolean z) {
        Profile profile2 = this.currentProfile;
        this.currentProfile = profile;
        if (z) {
            if (profile != null) {
                this.profileCache.save(profile);
            } else {
                this.profileCache.clear();
            }
        }
        if (Utility.areObjectsEqual(profile2, profile)) {
            return;
        }
        sendCurrentProfileChangedBroadcast(profile2, profile);
    }
}
