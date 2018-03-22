package br.com.login.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by rafael on 21/03/18.
 */

public class GoogleActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private Button btn;
    private TextView t;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google);

        btn = (Button) findViewById(R.id.btn_logout);
        t = (TextView) findViewById(R.id.textView);


        Intent intent = getIntent();
        Bundle dados = new Bundle();
        dados = intent.getExtras();


        String user = dados.getString("user").toString();


        t.setText(user);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                auth.getInstance().signOut();
                if(auth == null) {
                    Intent i = new Intent(GoogleActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }else{
                    Toast.makeText(GoogleActivity.this, "Conectado ainda", Toast.LENGTH_SHORT).show();

                }
            }
        });


    }
}
