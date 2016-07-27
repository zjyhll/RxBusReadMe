package com.example.administrator.rxbusreadme;

import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.hwangjr.rxbus.annotation.Produce;
import com.hwangjr.rxbus.annotation.Subscribe;
import com.hwangjr.rxbus.annotation.Tag;
import com.hwangjr.rxbus.thread.EventThread;
import timber.log.Timber;

/**
 * 2016/07/27
 * 这个工程提供了两种方式来调用rxbus
 * 1.BusProvider.getInstance().post(Object)            发送数据
 * 2.使用注释的方式 @Produce                           发送数据  （我个人觉得该方法目前没有方法1灵活）
 * 3@Subscribe                                         接收数据
 * 4.传递方与接收方的参数必须一致才能发收正常
 * 5.应用场景 ：从某接口、硬件、更复杂的数据来源获取到最新值之后更有效的更新相应的控件
 * Activity to show the story.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Init view and bus provider.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Timber.plant(new Timber.DebugTree());

        TextView tv = (TextView) findViewById(R.id.tv);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BusProvider.getInstance().post("任意命名的TAG", "This is bread!--onClick");
            }
        });

        BusProvider.getInstance().register(this);
    }

    /**
     * Unregister the register object.
     */
    @Override
    protected void onDestroy() {
        BusProvider.getInstance().unregister(this);
        super.onDestroy();
    }


    @Subscribe
    public void eat(String food) {
        // purpose
        Timber.e("food---------------> " + food);

    }

    @Subscribe
    public void eat1(String food) {
        // purpose
        Timber.e("food1---------------> " + food);
    }

    @Subscribe(
            thread = EventThread.IO,
            tags = {@Tag("任意命名的TAG")}
    )
    public void eat2(String food) {
        // purpose
        Timber.e("food2---------------> " + food);
    }

    /**
     * 如果是使用默认的tag，那所有的Subscribe都能接收到此数据
     */
    @Produce(
            thread = EventThread.IO,
            tags = {@Tag("任意命名的TAG")}
    )
    public String produceFood() {
        return "This is bread!";
    }

}
