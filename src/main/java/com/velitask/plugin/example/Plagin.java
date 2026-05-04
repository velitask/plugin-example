package com.velitask.plugin.example;

import com.velitask.sdk.IIndicator;
import com.velitask.sdk.IPlagin;
import com.velitask.sdk.i18n.Localization;

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
    public String[] defineAdditionLocales() {
        return new String[] { "ru" };
    }

    public void registerLocalization() {
        Localization.instance().registerBundle(
                getClass().getClassLoader(), "strings/strings");
    }

    @Override
    public IIndicator[] defineIndicators() {
        return new IIndicator[] {
                new SpeedometerIndicator()
        };
    }
}
