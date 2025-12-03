package vetro.uz.testappmvp.screens.main;

import vetro.uz.testappmvp.models.CategoryEnum;

public interface MainContract {
    interface View{
        void openQuiz(CategoryEnum category);
    }

    interface Presenter{
        void openCategory(CategoryEnum category);
    }
}
