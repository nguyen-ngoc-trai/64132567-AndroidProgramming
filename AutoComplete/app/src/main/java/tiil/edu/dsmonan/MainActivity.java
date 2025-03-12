package tiil.edu.dsmonan;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        AutoCompleteTextView auto = findViewById(R.id.Auto);
        ArrayList<String> dsMonAN = new ArrayList<>();
        dsMonAN.add("Phở");
        dsMonAN.add("Cơm");
        dsMonAN.add("Bún");
        dsMonAN.add("Gà");
        dsMonAN.add("Cá");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dsMonAN
        );
        auto.setAdapter(adapter);

        ListView list = findViewById(R.id.List);
        ArrayList<String> dsApp = new ArrayList<>();
        dsApp.add("Zalo");
        dsApp.add("FaceBook");
        dsApp.add("TikTok");
        dsApp.add("Mess");

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dsApp
        );

        list.setAdapter(adapter1);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String giatri = dsApp.get(position);
                Toast.makeText(MainActivity.this, "Chọn" + giatri, Toast.LENGTH_LONG).show();

            }
        });
    }
}