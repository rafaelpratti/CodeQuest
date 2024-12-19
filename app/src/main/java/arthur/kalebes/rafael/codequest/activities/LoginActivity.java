package arthur.kalebes.rafael.codequest.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import arthur.kalebes.rafael.codequest.R;
import arthur.kalebes.rafael.codequest.util.Config;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etEmail = findViewById(R.id.etEmailLogin);
                String email = etEmail.getText().toString();
                EditText etSenha = findViewById(R.id.etSenhaLogin);
                String senha = etSenha.getText().toString();

                if (email.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Email não preenchido", Toast.LENGTH_LONG).show();
                    return;
                }

                if (senha.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Senha não preenchido", Toast.LENGTH_LONG).show();
                    return;
                }

                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(LoginActivity.this, "Email inválido", Toast.LENGTH_LONG).show();
                    return;
                }


                Config.setLogin(LoginActivity.this, email);
                Config.setPassword(LoginActivity.this, senha);


                // Redireciona para a HomeActivity
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);

                // Finaliza a tela de login (opcional)
                finish();
            }
        });

        TextView tvNaoPossuoConta = findViewById(R.id.tvLinkcadastro_login);
        tvNaoPossuoConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redireciona para a tela de cadastro
                Intent intent = new Intent(LoginActivity.this, CadastroActivity.class);
                startActivity(intent);
            }
        });


    }
}