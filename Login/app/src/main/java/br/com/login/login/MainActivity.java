package br.com.login.login;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    private ViewPager pageOne;
    private LinearLayout linearLayout;

    private SliderAdapter sliderAdapter;

    private TextView[] mDots;

    private Button btnBack;
    private Button btnNext;

    private int currentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pageOne = (ViewPager) findViewById(R.id.sliderViewPager);
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);

        btnBack = (Button) findViewById(R.id.prev_btn);
        btnNext = (Button) findViewById(R.id.next_btn);

        sliderAdapter = new SliderAdapter(this);

        pageOne.setAdapter( sliderAdapter );

        addDotsIndicator(0);

        pageOne.addOnPageChangeListener( viewList );

    }

    public void addDotsIndicator(int position){

        mDots = new TextView[3];
        linearLayout.removeAllViews();

        for (int i = 0; i<mDots.length; i++){

            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransparenteFalseWhite));

            linearLayout.addView( mDots[i] );

        }
        if(mDots.length > 0){
            mDots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }


        //click do btn
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pageOne.setCurrentItem(currentPage +1);
            }
        });
        //click do btn
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pageOne.setCurrentItem( currentPage -1);
            }
        });
    }

    ViewPager.OnPageChangeListener viewList = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            addDotsIndicator( position );
            currentPage = position;

            if( position == 0 ){

                btnNext.setEnabled(true);
                btnBack.setEnabled( false );
                btnBack.setVisibility(View.INVISIBLE );

                btnNext.setText("Next");
                btnBack.setText("");

            }else if( position == 1){

                btnNext.setEnabled(true);
                btnBack.setEnabled( true );
                btnBack.setVisibility(View.VISIBLE );

                btnNext.setText("Next");
                btnBack.setText("Back");

            }else if(position == 2){

                btnNext.setEnabled(true);
                btnBack.setEnabled( true );
                btnBack.setVisibility(View.VISIBLE );

                btnNext.setText("Finish");
                /*
                *  if(btnNext.getText().equals("Finish")){
                    btnNext.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i = new Intent(MainActivity.this, Teste.class);
                            startActivity( i );
                            finish();
                        }
                    });
                }
                *
                * */

                if(position >= 2){
                    btnNext.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i = new Intent(MainActivity.this, Teste.class);
                            startActivity( i );
                            finish();
                        }
                    });
                }



                btnBack.setText("Back");

            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
