package arthur.kalebes.rafael.codequest.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.*;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import arthur.kalebes.rafael.codequest.R;
import arthur.kalebes.rafael.codequest.fragments.CursosFragment;
import arthur.kalebes.rafael.codequest.fragments.MeuProgressoFragment;
import arthur.kalebes.rafael.codequest.fragments.MeusCursosFragment;
import arthur.kalebes.rafael.codequest.fragments.PerfilFragment;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Default Fragment
        loadFragment(new CursosFragment());

        // BottomNavigationView listener
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment fragment = null;
            if (item.getItemId() == R.id.cursos) {
                fragment = new CursosFragment();
            }

            if (item.getItemId() == R.id.meusCursos) {
                fragment = new MeusCursosFragment();
            }

            if (item.getItemId() == R.id.progresso) {
                fragment = new MeuProgressoFragment();
            }

            if (item.getItemId() == R.id.perfil) {
                fragment = new PerfilFragment();
            }

            return loadFragment(fragment);
        });
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frameLayout, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
