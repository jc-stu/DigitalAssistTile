package stu.jc.digitalassisttile;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityEvent;

public class AssistKeyAccessibilityService extends AccessibilityService {

    private static AssistKeyAccessibilityService instance;

    public static AssistKeyAccessibilityService getInstance() {
        return instance;
    }

    public void simulateKey(int keycode) {
        performGlobalAction(keycode);
    }

    @Override
    public void onServiceConnected() {
        instance = this;
    }

    @Override
    public void onDestroy() {
        instance = null;
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
    }

    @Override
    public void onInterrupt() {
    }

}