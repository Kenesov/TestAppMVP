package vetro.uz.testappmvp.screens.main;

import vetro.uz.testappmvp.models.CategoryEnum;

public class MainPresenter implements MainContract.Presenter {
    private final MainContract.View view;
    public MainPresenter(MainContract.View view) {this.view = view;}
    @Override
    public void openCategory(CategoryEnum category) {view.openQuiz(category);}
}
