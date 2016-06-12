package cmcm.com.systempropertiesdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //SystemProperties.get();
        //canWeSetSystemProperty();
        canWeSetSystemProperty2();
    }

    // 通过反射调用 SystemProperties 是可以的
    private void invokeSystemPropertiesByReflection(){
        try {
            Class<?> threadClazz = Class.forName("android.os.SystemProperties");
            Method method = threadClazz.getMethod("get", String.class);
            Log.v("sunzy", "result = " + method.invoke(null, "ro.product.device"));
        } catch (Exception e){
            Log.wtf("sunzy", e);
        }
    }

    // 我们不能改动系统属性
    private void canWeSetSystemProperty(){
        try {
            Class<?> threadClazz = Class.forName("android.os.SystemProperties");
            Method method = threadClazz.getMethod("set", String.class, String.class);
            Log.v("sunzy", "result = " + method.invoke(null, "ro.product.device", "dddd"));
        } catch (Exception e){
            Log.wtf("sunzy", e);
        }
    }

    //wlan.driver.status 这个也不能改
    private void canWeSetSystemProperty2(){
        try {
            Class<?> threadClazz = Class.forName("android.os.SystemProperties");
            Method method = threadClazz.getMethod("set", String.class, String.class);
            Log.v("sunzy", "result = " + method.invoke(null, "wlan.driver.status", "dddd"));
        } catch (Exception e){
            Log.wtf("sunzy", e);
        }
    }
}
