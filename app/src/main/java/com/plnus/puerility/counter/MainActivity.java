package com.plnus.puerility.counter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.plnus.puerility.counter.view.CounterActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterCounterView();
    }

    /**
     * 直接进入计时页面，然后将MainActivity结束掉
     * 把最底层的Activity直接设置为CounterActivity
     */
    private void enterCounterView() {
        this.startActivity(new Intent(this, CounterActivity.class));
        this.finish();
    }
}
