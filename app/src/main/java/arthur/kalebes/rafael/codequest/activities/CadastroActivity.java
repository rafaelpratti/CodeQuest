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

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cadastro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnCadastrar = findViewById(R.id.btnCadastrar);
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etNome = findViewById(R.id.etNomeCadastro);
                EditText etEmail = findViewById(R.id.etEmailCadastro);
                EditText etSenha = findViewById(R.id.etSenhaCadastro);
                EditText etConfirmarSenha = findViewById(R.id.etConfirmarSenhaCadastro);

                String nome = etNome.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String senha = etSenha.getText().toString().trim();
                String confirmarSenha = etConfirmarSenha.getText().toString().trim();

                // Validação dos campos
                if (nome.isEmpty()) {
                    Toast.makeText(CadastroActivity.this, "Nome não pode ser vazio", Toast.LENGTH_LONG).show();
                    return;
                }

                if (email.isEmpty()) {
                    Toast.makeText(CadastroActivity.this, "Email não pode ser vazio", Toast.LENGTH_LONG).show();
                    return;
                }

                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(CadastroActivity.this, "Email inválido", Toast.LENGTH_LONG).show();
                    return;
                }

                if (senha.isEmpty()) {
                    Toast.makeText(CadastroActivity.this, "Senha não pode ser vazia", Toast.LENGTH_LONG).show();
                    return;
                }

                if (!senha.equals(confirmarSenha)) {
                    Toast.makeText(CadastroActivity.this, "Senhas não conferem", Toast.LENGTH_LONG).show();
                    return;
                }

                Config.setLogin(CadastroActivity.this, email);
                Config.setPassword(CadastroActivity.this, senha);

                Toast.makeText(CadastroActivity.this, "Cadastro realizado com sucesso!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(CadastroActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });


        TextView tvPossuoConta = findViewById(R.id.tvLinkcadastro_login);
        tvPossuoConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redireciona para a tela de cadastro
                Intent intent = new Intent(CadastroActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}