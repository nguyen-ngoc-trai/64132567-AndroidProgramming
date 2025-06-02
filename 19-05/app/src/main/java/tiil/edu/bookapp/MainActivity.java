package tiil.edu.bookapp;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;



import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ArrayList<SetsMode> list;

        SetsAdapter adapter;

        RecyclerView recyclerView;

        NavigationView navigationView;

        DrawerLayout drawerLayout;

        ImageView menu, user;

        View header;

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        menu = findViewById(R.id.menu);

        user = findViewById(R.id.user);

        navigationView = (NavigationView)findViewById(R.id.navmenu);

        drawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);

        recyclerView = findViewById(R.id.recyclerView);

        EditText searchBox = findViewById(R.id.searchBox);

        list = new ArrayList<>();

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        list.add(new SetsMode(
                "Hoa Hồng Sớm Mai",
                "Tác Giả: Lâm Địch Nhi",
                "Văn Học Nghệ Thuật",
                "1093 Trang",
                "01/01/2024",
                R.drawable.book1
        ));
        list.add(new SetsMode(
                "Thiên Nga Đen",
                "Tác Giả: Nassim Nicholas Taleb",
                "Khoa Học - Công Nghệ",
                "441 Trang",
                "02/01/2024",
                R.drawable.book2
        ));

        list.add(new SetsMode(
                "Lập Trình Căn Bản",
                "Tác Giả: CodeGym",
                "Khoa Học - Công Nghệ",
                "173 Trang",
                "02/01/2024",
                R.drawable.book3
        ));

        list.add(new SetsMode(
                "Binh Pháp Tôn Tử",
                "Tác Giả: Tôn Tử",
                "Thể Thao - Võ Thuật",
                "64 Trang",
                "02/01/2024",
                R.drawable.book4
        ));
        list.add(new SetsMode(
                "Thao Túng Tâm Lý",
                "Tác Giả: Shannon Thomas",
                "Tâm Lí - Kĩ Năng",
                "222 Trang",
                "02/01/2024",
                R.drawable.book5
        ));
        list.add(new SetsMode(
                "Làm Giàu Từ Chăn Nuôi",
                "Tác Giả: Phùng Thị Thu Hà",
                "Trồng Trọt - Chăn Nuôi",
                "223 Trang",
                "02/01/2024",
                R.drawable.book6
        ));
        list.add(new SetsMode(
                "Putin Và Logic Cảu Quyền Lực",
                "Tác Giả: Hubert Seipel",
                "Chính Trị - Xã Hội",
                "283 Trang",
                "02/01/2024",
                R.drawable.book7
        ));
        list.add(new SetsMode(
                "Sự Nghiệp Cả Đời",
                "Tác Giả: A. M. Vasilevskiy",
                "Truyện Ngắn - Tiểu Thuyết",
                "652 Trang",
                "02/01/2024",
                R.drawable.book8
        ));
        list.add(new SetsMode(
                "Những Cuộc Phiêu Lưu Trong Kinh Doanh",
                "Tác Giả: John Brooks",
                "Quản Trị Kinh Doanh",
                "339 Trang",
                "02/01/2024",
                R.drawable.book9
        ));
        list.add(new SetsMode(
                "499 Điều Cấm Kỵ Trong Kinh Doanh",
                "Tác Giả: Đang Cập Nhật",
                "Tôn Giáo - Tâm Linh",
                "235 Trang",
                "02/01/2024",
                R.drawable.book10
        ));


        SetsData.setAllBooks(list);

        adapter = new SetsAdapter(list,this);
        recyclerView.setAdapter(adapter);

        header = navigationView.getHeaderView(0);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(drawerLayout.isDrawerOpen(GravityCompat.START)){
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                else {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                if (id == R.id.home) {
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "HOME", Toast.LENGTH_SHORT).show();
                }

                else if (id == R.id.share) {
                    String shareBody = "I am using Book App";
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_TEXT, shareBody);
                    startActivity(Intent.createChooser(intent, "Share via"));
                }

                else if (id == R.id.rate) {
                    try {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/")));
                    } catch (ActivityNotFoundException e) {
                        Toast.makeText(MainActivity.this, "No browser app found.", Toast.LENGTH_SHORT).show();
                    }
                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        searchBox.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });

    }
}