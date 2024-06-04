package org.apache.cordova.keypress;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;
import android.view.KeyEvent;

public class KeyPressPlugin extends CordovaPlugin {
    private CallbackContext callbackContext;

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("onKeyPress")) {
            this.callbackContext = callbackContext;
            return true;
        }
        return false;
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (this.callbackContext != null) {
            try {
                this.callbackContext.success(keyCode);
            } catch (Exception e) {
                this.callbackContext.error("Failed to handle key press event");
            }
        }
        return super.onKeyUp(keyCode, event);
    }
}
