// ----------------------------------------------------------------------------
// The MIT License
// UnityMobileInput https://github.com/mopsicus/UnityMobileInput
// Copyright (c) 2018 Mopsicus <mail@mopsicus.ru>
// ----------------------------------------------------------------------------

package ru.mopsicus.mobileinput;

import org.json.JSONException;
import org.json.JSONObject;

import ru.mopsicus.MobileInputCommon.MobileInputCommon;

public class KeyboardListener implements KeyboardObserver {

    private boolean isPreviousState = false;
    private MobileInputCommon mobileInputCommon = new MobileInputCommon();

    @Override
    public void onKeyboardHeight(float height, int keyboardHeight, int orientation) {
        boolean isShow = (keyboardHeight > 0);
        JSONObject json = new JSONObject();
        try {
            json.put("msg", Plugin.KEYBOARD_ACTION);
            json.put("show", isShow);
            json.put("height", height);
        } catch (JSONException e) {}
        if (isPreviousState != isShow) {
            isPreviousState = isShow;
            mobileInputCommon.sendData(Plugin.name, json.toString());
        }
    }

}

