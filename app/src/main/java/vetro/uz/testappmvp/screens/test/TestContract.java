package vetro.uz.testappmvp.screens.test;

import vetro.uz.testappmvp.models.CategoryEnum;
import vetro.uz.testappmvp.models.QuestionData;

public interface TestContract {

    interface Model{
        QuestionData getQuestion(CategoryEnum category, int index);
        int getMaxQuestionCount(CategoryEnum category);
    }

    interface View{
        void closeScreen();
        void setVariantChecked(int index);
        void clearVariantChecked(int index);
        void showQuestion(QuestionData question);
        void enabledNext(boolean enabled);
        void openResult(int correctAnswersCount, int wrongAnswersCount);
    }

    interface Presenter{
        void selectVariant(int variantIndex);
        void next();
        void prev();
        void back();
    }
}
