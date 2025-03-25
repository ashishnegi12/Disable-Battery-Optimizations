package in.jvapps.disable_battery_optimization;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;

import in.jvapps.disable_battery_optimization.managers.KillerManager;
import in.jvapps.disable_battery_optimization.utils.BatteryOptimizationUtil;
import in.jvapps.disable_battery_optimization.utils.PrefKeys;
import in.jvapps.disable_battery_optimization.utils.PrefUtils;

import java.util.List;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry;

public class DisableBatteryOptimizationPlugin implements FlutterPlugin, ActivityAware, MethodCallHandler {
    private Context mContext;
    private Activity mActivity;
    private MethodChannel channel;

    private static final int REQUEST_DISABLE_BATTERY_OPTIMIZATIONS = 2244;
    private final String TAG = "BO:DisableOptimization";
    private static final String CHANNEL_NAME = "in.jvapps.disable_battery_optimization";

    private String autoStartTitle;
    private String autoStartMessage;
    private String manBatteryTitle;
    private String manBatteryMessage;

    // V2 embedding
    @Override
    public void onAttachedToEngine(@NonNull FlutterPluginBinding binding) {
        channel = new MethodChannel(binding.getBinaryMessenger(), CHANNEL_NAME);
        channel.setMethodCallHandler(this);
        mContext = binding.getApplicationContext();
    }

    @Override
    public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
        channel.setMethodCallHandler(null);
        channel = null;
        mContext = null;
    }

    @Override
    public void onAttachedToActivity(@NonNull ActivityPluginBinding binding) {
        mActivity = binding.getActivity();
        if (mContext == null) {
            mContext = mActivity.getApplicationContext();
        }
    }

    @Override
    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    @Override
    public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding binding) {
        onAttachedToActivity(binding);
    }

    @Override
    public void onDetachedFromActivity() {
        mActivity = null;
    }

    // Rest of your existing methods remain unchanged...
    @Override
    public void onMethodCall(@NonNull MethodCall call, @NonNull Result result) {
        // Your existing implementation...
    }

    private void showAutoStartEnabler(@NonNull final BatteryOptimizationUtil.OnBatteryOptimizationAccepted positiveCallback,
                                    @NonNull final BatteryOptimizationUtil.OnBatteryOptimizationCanceled negativeCallback) {
        // Your existing implementation...
    }

    // ... (keep all other existing methods exactly as they were)
}
