package tiil.edu.usingrecyclerview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    LandScapeAdapter landScapeAdapter;
    ArrayList<LandScape> recyclerviewdata;
    RecyclerView recyclerViewLandScape;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recyclerviewdata = getdataforreyclerview();

        recyclerViewLandScape =findViewById(R.id.recyclerland);
        RecyclerView.LayoutManager layoutlinear = new LinearLayoutManager(this);
        recyclerViewLandScape.setLayoutManager(layoutlinear);

        landScapeAdapter =new LandScapeAdapter(this, recyclerviewdata);
        recyclerViewLandScape.setAdapter(landScapeAdapter);

    }
    ArrayList<LandScape> getdataforreyclerview(){
        ArrayList<LandScape> dsdulieu = new ArrayList<>();
        LandScape landScape1 = new LandScape("nha_trang", "tp nha trang");
        dsdulieu.add(landScape1);
        dsdulieu.add(new LandScape("phan_thiet", "tp phan thiet"));
        dsdulieu.add(new LandScape("da_nang", "tp da nang"));
        dsdulieu.add(new LandScape("quy_nhon", "tp quy nhon"));
        return dsdulieu;
    }
}