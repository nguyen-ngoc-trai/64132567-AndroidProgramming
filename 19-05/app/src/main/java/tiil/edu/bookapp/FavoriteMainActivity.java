package tiil.edu.bookapp;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class FavoriteMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_favorite_main);

        RecyclerView recyclerView;
        SetsAdapter adapter;
        ArrayList<SetsMode> favoriteList = new ArrayList<>();
        ArrayList<SetsMode> allBooks; // Lấy từ bộ nhớ tạm hoặc nơi chứa dữ liệu

        recyclerView = findViewById(R.id.favoriteRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Giả sử allBooks được lưu trước đó trong SetsData
        allBooks = SetsData.getAllBooks(); // dùng singleton tạm lưu danh sách

        SharedPreferences prefs = getSharedPreferences("favorites", MODE_PRIVATE);
        Set<String> favNames = prefs.getStringSet("favorite_list", new HashSet<>());
        for (SetsMode book : allBooks) {
            if (favNames.contains(book.getSetName())) {
                favoriteList.add(book);
            }
        }

        adapter = new SetsAdapter(favoriteList, this);
        recyclerView.setAdapter(adapter);
    }
}