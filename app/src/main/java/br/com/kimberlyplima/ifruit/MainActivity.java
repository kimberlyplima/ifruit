package br.com.kimberlyplima.ifruit;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private EditText txtSenha;
    private EditText txtEmail;
    private Button btnLogin;
    private Button btnCadastro;
    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener authListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtSenha = (EditText) findViewById(R.id.txt_senha);
        txtEmail = (EditText) findViewById(R.id.txt_email);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnCadastro = (Button) findViewById(R.id.btn_cadastro);

        auth = FirebaseAuth.getInstance();
        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                if(firebaseAuth.getCurrentUser() != null){
                    // Descomentar a linha de baixo para aproveitar a sessao logada do usuario
                   // startActivity(new Intent(MainActivity.this , ContaLogadaActivity.class));
                }

            }
        };


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startLogin();
            }
        });

        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CadastroActivity.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        auth.addAuthStateListener(authListener);
    }

    private void startLogin () {
        String email = txtEmail.getText().toString();
        String senha = txtSenha.getText().toString();

        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(senha)){
            Toast.makeText(MainActivity.this,"O preenchimento dos campos e obrigatorio", Toast.LENGTH_LONG).show();
        } else {

            auth.signInWithEmailAndPassword(email, senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        startActivity(new Intent(MainActivity.this , ContaLogadaActivity.class));
                    } else {
                        Toast.makeText(MainActivity.this, "E-mail ou senha incorretos", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }
}
