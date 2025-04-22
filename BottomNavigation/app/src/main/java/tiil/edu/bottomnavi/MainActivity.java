package tiil.edu.bottomnavi;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        bottomNav = findViewById(R.id.botnav);

        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int menuID = item.getItemId();

                if (menuID == R.id.menuhome)
                {
                    Toast.makeText(MainActivity.this, "Thay HOME", Toast.LENGTH_LONG).show();
                } else
                    if (menuID == R.id.menusearch)
                    {
                        Toast.makeText(MainActivity.this, "Thay SEARCH", Toast.LENGTH_LONG).show();
                    } else
                        if (menuID == R.id.menuprofile)
                        {
                            Toast.makeText(MainActivity.this, "Thay PROFILE", Toast.LENGTH_LONG).show();
                        } else return  false;
                return  true;
            }
        });
    }
}