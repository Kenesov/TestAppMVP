package vetro.uz.testappmvp.screens.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

import vetro.uz.testappmvp.R;
import vetro.uz.testappmvp.models.CategoryEnum;
import vetro.uz.testappmvp.models.QuestionData;
import vetro.uz.testappmvp.screens.result.ResultActivity;

public class TestActivity extends AppCompatActivity implements TestContract.View {
    private TextView textQuestion;
    private ImageView imageQuestion;
    private List<ImageView> icons;
    private List<TextView> variants;
    private AppCompatButton prev;
    private AppCompatButton next;
    private TestManager presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_test);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        findViews();
        attachListeners();
        CategoryEnum selectedCategory = (CategoryEnum) getIntent().getSerializableExtra("CATEGORY");
        presenter = new TestManager(selectedCategory, TestRepository.getInstance(), this);
    }
    private void findViews() {
        next = findViewById(R.id.buttonNext);
        prev = findViewById(R.id.buttonprev);
        imageQuestion = findViewById(R.id.img_question);
        textQuestion = findViewById(R.id.textQuestion);
        variants = new ArrayList<>(4);
        icons = new ArrayList<>(4);


        loadItem(R.id.variant1, 0);
        loadItem(R.id.variant2, 1);
        loadItem(R.id.variant3,2);
        loadItem(R.id.variant4,3);
    }

    private void loadItem(int id, int index){
        View variant = findViewById(id);
        variant.setOnClickListener(v -> presenter.selectVariant(index));
        ImageView icon = variant.findViewById(R.id.icon);
        TextView variantText = variant.findViewById(R.id.variant);
        variants.add(variantText);
        icons.add(icon);
    }
    private void attachListeners() {
        next.setOnClickListener(v -> presenter.next());
        findViewById(R.id.buttonBack).setOnClickListener(v -> presenter.back());
        prev.setOnClickListener(v -> presenter.prev());
    }


    @Override
    public void closeScreen() {finish();}

    @Override
    public void setVariantChecked(int index) {
        icons.get(index).setImageResource(R.drawable.ic_checked);
    }

    @Override
    public void clearVariantChecked(int index) {
        icons.get(index).setImageResource(R.drawable.ic_unchecked);
    }

    @Override
    public void showQuestion(QuestionData question) {
        imageQuestion.setImageResource(question.getImgQuestion());
        textQuestion.setText(question.getQuestion());
        variants.get(0).setText(question.getVariant1());
        variants.get(1).setText(question.getVariant2());
        variants.get(2).setText(question.getVariant3());
        variants.get(3).setText(question.getVariant4());
    }

    @Override
    public void enabledNext(boolean enabled) {next.setEnabled(enabled);}

    @Override
    public void openResult(int correctAnswersCount, int wrongAnswersCount) {
        Intent b = new Intent(TestActivity.this, ResultActivity.class);
        b.putExtra("togri", correctAnswersCount);
        b.putExtra("xato", wrongAnswersCount);
        startActivity(b);
    }
}