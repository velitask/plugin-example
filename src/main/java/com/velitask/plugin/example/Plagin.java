package com.velitask.plugin.example;

import com.velitask.sdk.IFileSource;
import com.velitask.sdk.IIndicator;
import com.velitask.sdk.IPlagin;
import com.velitask.sdk.db.PluginDatabase;

public class Plagin implements IPlagin {

    public static final String UID = "com.velitask.plugin.example";

    public static final String KEY = "PluginExample";

    public static final String KEY_INDICATOR = KEY + ".Indicator";

    @Override
    public String getUID() {
        return UID;
    }

    @Override
    public String getVersion() {
        return "1.0.0";
    }

    @Override
    public int getDbVersion() {
        return 1;
    }

    @Override
    public String[] defineAdditionLocales() {
        return new String[] { "ru" };
    }

    @Override
    public IIndicator[] defineIndicators() {
        return new IIndicator[] {
                new SpeedometerIndicator()
        };
    }

    @Override
    public void onSourceImported(IFileSource source, PluginDatabase db) {
        if (db == null || source == null) {
            return;
        }
        db.execute(
                "INSERT OR REPLACE INTO ${table:import_log}"
                + " (source_id, source_path, processed_at) VALUES (?, ?, ?)",
                source.getId(),
                source.getRelativePath(),
                System.currentTimeMillis()
        );
    }
}
