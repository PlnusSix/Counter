package com.plnus.puerility.counter.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.widget.RxTextView;
import com.jakewharton.rxbinding.widget.TextViewAfterTextChangeEvent;
import com.plnus.puerility.counter.R;
import com.plnus.puerility.counter.model.entity.RecordCurrentInfo;

import java.text.SimpleDateFormat;
import java.util.Date;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public class CounterActivity extends AppCompatActivity implements ICounterView {

    private TextView mBack, mTitle, mOption, mDisplayCurrInfo;
    private Button mRecord;
    private EditText mStartPlace, mReachPlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        initViews();
        initStartPlace();
        initDestinationPlace();
        initRecord();
    }

    private void initViews() {
        mBack = (TextView) this.findViewById(R.id.common_toolbar_back);
        mTitle = (TextView) this.findViewById(R.id.common_toolbar_title);
        mOption = (TextView) this.findViewById(R.id.common_toolbar_option);
        mRecord = (Button) this.findViewById(R.id.counter_btn_record);
        mStartPlace = (EditText) this.findViewById(R.id.counter_start_place_editText);
        mReachPlace = (EditText) this.findViewById(R.id.counter_reach_place_editText);
        mDisplayCurrInfo = (TextView) this.findViewById(R.id.counter_current_info);

        mBack.setText("");
        mTitle.setText("计时器");
        mOption.setText("历史记录");
    }

    private void initStartPlace() {
        RxTextView.afterTextChangeEvents(((EditText) findViewById(R.id.counter_start_place_editText)))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<TextViewAfterTextChangeEvent>() {
                    public String mStartPlace;

                    @Override
                    public void call(TextViewAfterTextChangeEvent textViewAfterTextChangeEvent) {
                        mStartPlace = textViewAfterTextChangeEvent.editable().toString();
                    }
                });
    }

    private void initDestinationPlace() {
        RxTextView.afterTextChangeEvents(((EditText) findViewById(R.id.counter_reach_place_editText)))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<TextViewAfterTextChangeEvent>() {
                    public String mReachPlace;

                    @Override
                    public void call(TextViewAfterTextChangeEvent textViewAfterTextChangeEvent) {
                        mReachPlace = textViewAfterTextChangeEvent.editable().toString();
                    }
                });
    }

    private void initRecord() {
        RxView.clicks(mRecord)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        doRecord();
                    }
                });
    }

    /**
     * 记录操作
     */
    private void doRecord() {
        if (RecordCurrentInfo.get().isRecord()) {
            doStopRecord();
        } else {
            doStartRecord();
        }
    }

    /**
     * 开始记录时的一些逻辑
     */
    private void doStartRecord() {
        String start = mStartPlace.getText().toString();
        String reach = mReachPlace.getText().toString();
        if (TextUtils.isEmpty(start) || TextUtils.isEmpty(reach)) {
            return;
        }
        if (RecordCurrentInfo.get().isRecord()) {
            Toast.makeText(this, "状态错误", Toast.LENGTH_SHORT).show();
            return;
        } else {
            RecordCurrentInfo.get().setRecord(true);
        }
        RecordCurrentInfo.get().setStartPlace(start);
        RecordCurrentInfo.get().setReachPlace(reach);
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm");
        String currentTime = sdf.format(new Date());
        RecordCurrentInfo.get().setStartTime(currentTime);
        mStartPlace.setFocusable(false);
        mStartPlace.setFocusableInTouchMode(false);
        mReachPlace.setFocusable(false);
        mReachPlace.setFocusableInTouchMode(false);
        mRecord.setBackgroundResource(R.drawable.shape_counter_begin_btn_bg_press);
        mRecord.setText("停止记录");
        mDisplayCurrInfo.setText("出发地点：" + RecordCurrentInfo.get().getStartPlace()
                + "\n" + "到达地点：" + RecordCurrentInfo.get().getReachPlace()
                + "\n" + "出发时间：" + RecordCurrentInfo.get().getStartTime()
                + "\n" + "到达时间：未知");
    }

    /**
     * 结束记录时的一些逻辑
     */
    private void doStopRecord() {
        if (!RecordCurrentInfo.get().isRecord()) {
            Toast.makeText(this, "状态错误", Toast.LENGTH_SHORT).show();
            return;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm");
        String reachTime = sdf.format(new Date());
        RecordCurrentInfo.get().setReachTime(reachTime);
        RecordCurrentInfo.get().setRecord(false);
        mStartPlace.setText("");
        mStartPlace.setFocusableInTouchMode(true);
        mReachPlace.setText("");
        mReachPlace.setFocusableInTouchMode(true);
        mRecord.setBackgroundResource(R.drawable.shape_counter_begin_btn_bg_normal);
        mRecord.setText("开始记录");
        mDisplayCurrInfo.setText("出发地点：" + RecordCurrentInfo.get().getStartPlace()
                + "\n" + "到达地点：" + RecordCurrentInfo.get().getReachPlace()
                + "\n" + "出发时间：" + RecordCurrentInfo.get().getStartTime()
                + "\n" + "到达时间：" + RecordCurrentInfo.get().getReachTime());
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
