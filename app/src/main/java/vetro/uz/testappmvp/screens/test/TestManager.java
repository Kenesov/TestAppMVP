package vetro.uz.testappmvp.screens.test;

import vetro.uz.testappmvp.models.CategoryEnum;
import vetro.uz.testappmvp.models.QuestionData;

public class TestManager implements TestContract.Presenter{
    private final TestContract.Model model;
    private final TestContract.View view;
    private final CategoryEnum category;
    private int selectedVariantIndex = -1;
    private int currentQuestionIndex = 0;
    private int correctAnswersCount = 0;
    private int wrongAnswersCount = 0;
    private int[] selectedElementsArray;

    public TestManager(CategoryEnum category, TestContract.Model model, TestContract.View view){
        this.category = category;
        this.model = model;
        this.view = view;

        view.enabledNext(false);
        selectedElementsArray = new int[model.getMaxQuestionCount(category)];
        for (int i = 0; i < selectedElementsArray.length; i++) selectedElementsArray[i] = -1;
        loadQuestion();
        view.enabledNext(false);
    }
    private void loadQuestion(){
        final QuestionData question = model.getQuestion(category, currentQuestionIndex);
        view.showQuestion(question);
    }
    @Override
    public void selectVariant(int variantIndex) {
        if (selectedVariantIndex != -1){
            view.clearVariantChecked(selectedVariantIndex);
        }
        selectedVariantIndex = variantIndex;
        view.setVariantChecked(variantIndex);
        view.enabledNext(true);
    }

    @Override
    public void next() {
        if (selectedVariantIndex == -1) return;
        final QuestionData question = model.getQuestion(category, currentQuestionIndex);
        String[] variants = {question.getVariant1(), question.getVariant2(), question.getVariant3(), question.getVariant4()};
        String selectedVariant = variants[selectedVariantIndex];
        selectedElementsArray[currentQuestionIndex] = selectedVariantIndex;
        if (selectedVariant.equals(question.getAnswer())){
            correctAnswersCount++;
        }else {
            wrongAnswersCount++;
        }
        currentQuestionIndex++;
        view.clearVariantChecked(selectedVariantIndex);
        selectedVariantIndex = -1;
        view.enabledNext(false);
        if (currentQuestionIndex < model.getMaxQuestionCount(category)) {
            loadQuestion();
        } else {
            view.openResult(correctAnswersCount, wrongAnswersCount);
            view.closeScreen();
        }
    }

    @Override
    public void prev() {
        if (currentQuestionIndex == 0) return;

        currentQuestionIndex--;

        final QuestionData question = model.getQuestion(category, currentQuestionIndex);
        view.showQuestion(question);

        for (int i = 0; i < 4; i++) {
            view.clearVariantChecked(i);
        }

        int prevSelected = selectedElementsArray[currentQuestionIndex];

        selectedVariantIndex = prevSelected;

        if (prevSelected != -1) {
            view.setVariantChecked(prevSelected);
            view.enabledNext(true);
        } else {
            view.enabledNext(false);
        }
    }



    @Override
    public void back() {view.closeScreen();}
}
