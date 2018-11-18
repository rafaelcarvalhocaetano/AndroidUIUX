package tesapp.com.br.autobot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Review extends AppCompatActivity {

    TextView title, subtitle;
    ImageView img;
    Animation anime, botao;
    Button btn_review;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        title = (TextView) findViewById(R.id.title_autobot);
        subtitle = (TextView) findViewById(R.id.text_rolha);
        img = (ImageView) findViewById(R.id.img_review_foguete);
        btn_review = (Button) findViewById(R.id.btn_view);


        /*Animação de baixo para cima*/
        anime = AnimationUtils.loadAnimation(this, R.anim.frombottom);
        botao = AnimationUtils.loadAnimation(this, R.anim.botao);

        title.setAnimation(botao);
        subtitle.setAnimation(botao);
        btn_review.setAnimation(botao);
        img.setAnimation(anime);
    }
}
