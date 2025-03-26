package stu.jc.digitalassisttile;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.service.quicksettings.TileService;

import java.io.DataOutputStream;

public class DigitalAssistTileService extends TileService {
    @SuppressLint("StartActivityAndCollapseDeprecated")
    @Override
    public void onClick() {
        if (executeRootCommand("input keyevent 219"))  // KEYCODE_ASSIST
            return;
        Intent intent = new Intent(Intent.ACTION_VOICE_COMMAND);  // ACTION_ASSIST not working
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivityAndCollapse(intent);  // Not allowed on API > 33
    }

    public static boolean executeRootCommand(String command) {
        try {
            Process su = Runtime.getRuntime().exec("su");
            DataOutputStream outputStream = new DataOutputStream(su.getOutputStream());
            outputStream.writeBytes(command + "\n");
            outputStream.writeBytes("exit\n");
            outputStream.close();
            int exitCode = su.waitFor();
            return exitCode == 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
