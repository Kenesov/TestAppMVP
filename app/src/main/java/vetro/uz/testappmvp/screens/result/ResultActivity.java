package vetro.uz.testappmvp.screens.result;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import vetro.uz.testappmvp.R;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView a = findViewById(R.id.txt_currect);
        TextView b = findViewById(R.id.txt_wrong);
        int togri = getIntent().getIntExtra("togri", 0);
        int xato = getIntent().getIntExtra("xato", 0);
        a.setText(String.valueOf(xato));
        b.setText(String.valueOf(togri));
    }
}