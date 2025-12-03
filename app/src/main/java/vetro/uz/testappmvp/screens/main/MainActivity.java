package vetro.uz.testappmvp.screens.main;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import vetro.uz.testappmvp.R;
import vetro.uz.testappmvp.models.CategoryEnum;
import vetro.uz.testappmvp.screens.test.TestActivity;

public class MainActivity extends AppCompatActivity implements MainContract.View{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        MainPresenter presenter = new MainPresenter(this);


        findViewById(R.id.buttonCountries).setOnClickListener(v->presenter.openCategory(CategoryEnum.COUNTRIES));
        findViewById(R.id.buttonSports).setOnClickListener(v->presenter.openCategory(CategoryEnum.SPORT));
        findViewById(R.id.buttonFamous).setOnClickListener(v->presenter.openCategory(CategoryEnum.FAMOUS));

    }

    @Override
    public void openQuiz(CategoryEnum category) {
        Intent intent = new Intent(this, TestActivity.class);
        intent.putExtra("CATEGORY", category);
        startActivity(intent);
    }
}