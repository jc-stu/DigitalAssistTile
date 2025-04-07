package stu.jc.digitalassisttile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;

public class AssistantSettingsActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(Settings.ACTION_VOICE_INPUT_SETTINGS);
        startActivity(intent);
        finish();
    }
}