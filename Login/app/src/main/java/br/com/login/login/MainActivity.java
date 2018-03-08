package br.com.login.login;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {


    private ViewPager pageOne;
    private LinearLayout linearLayout;

    private SliderAdapter sliderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pageOne = (ViewPager) findViewById(R.id.sliderViewPager);
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);

        sliderAdapter = new SliderAdapter(this);
         pageOne.setAdapter( sliderAdapter );


    }
}
