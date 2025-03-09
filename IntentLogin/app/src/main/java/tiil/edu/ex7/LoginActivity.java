package tiil.edu.ex7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);


        Button btnXacNhan = (Button) findViewById(R.id.btnOK);

        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Xử Lí dăng nhap
                //Lay du lieu
                //B1: Tìm tham chieu đk
                EditText edtTenDN = (EditText) findViewById(R.id.edtUserName);
                EditText edtPass = (EditText) findViewById(R.id.edtPassword);
                //B2: Lấy dữ liệu
                String tenDăngNhâp = edtTenDN.getText().toString();
                String mk = edtPass.getText().toString();
                // Kiểm tra MK
                if( tenDăngNhâp.equals("nguyenngoctrai") && mk.equals("123")){
                    //chuyên màn hình
                    Intent iQuiz = new Intent(LoginActivity.this, HomeActivity.class);
                    //Gói dữ kiệu vài iQuiz
                    iQuiz.putExtra("ten_đang_nhâp", tenDăngNhâp);
                    iQuiz.putExtra("mk_đang_nhâp",mk);
                    //Gửi đi
                    startActivity(iQuiz);
                }else {
                    Toast.makeText(LoginActivity.this, "BẠN NHẬP SAI THÔNG TIN", Toast.LENGTH_LONG);
                }
            }
        });

    }
}