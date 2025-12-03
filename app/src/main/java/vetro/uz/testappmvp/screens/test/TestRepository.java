package vetro.uz.testappmvp.screens.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import vetro.uz.testappmvp.R;
import vetro.uz.testappmvp.models.CategoryEnum;
import vetro.uz.testappmvp.models.QuestionData;

public class TestRepository implements TestContract.Model{
    private static TestRepository instance;

    public static TestRepository getInstance(){
        if(instance == null){
            instance = new TestRepository();
        }
        return instance;
    }
    private TestRepository(){
        loadCountriesQuestions();
        loadSportsQuestions();
        loadFamousQuestions();

    }
    private HashMap<CategoryEnum, List<QuestionData>> questions = new HashMap<>();

    private void loadCountriesQuestions() {
        final ArrayList<QuestionData> list = new ArrayList<>();
        questions.put(CategoryEnum.COUNTRIES, list);
        list.add(new QuestionData("Rasmdagi qaysi davlat, javobni tanlang", R.drawable.c_brazil, "Argentina", "Yamayka", "Calumbiya", "Brazilya", "Brazilya"));
        list.add(new QuestionData("Rasmdagi qaysi davlat, javobni tanlang", R.drawable.c_italy, "Italiya", "Fransiya", "Belgiya", "Portugaliya", "Italiya"));
        list.add(new QuestionData("Rasmdagi qaysi davlat, javobni tanlang", R.drawable.c_japan, "Avstraliya", "Qatar", "Koryea", "Yaponiya", "Yaponiya"));
        list.add(new QuestionData("Rasmdagi qaysi davlat, javobni tanlang", R.drawable.c_spain, "Argentina", "Ispaniya", "Gollandiya", "Brazilya", "Ispaniya"));
        list.add(new QuestionData("Rasmdagi qaysi davlat, javobni tanlang", R.drawable.c_germany, "Ispaniya", "Italiya", "Germaniya", "Rassiya", "Germaniya"));
    }
    private void loadSportsQuestions() {
        final ArrayList<QuestionData> list = new ArrayList<>();
        questions.put(CategoryEnum.SPORT, list);
        list.add(new QuestionData("Rasmdagi sport turi qaysi?", R.drawable.s_football, "Basketbol", "Futbol", "Voleybol", "Tennis", "Futbol"));
        list.add(new QuestionData("Rasmdagi sport turi qaysi?", R.drawable.s_basketball, "Basketbol", "Futbol", "Tennis", "Hokkey", "Basketbol"));
        list.add(new QuestionData("Rasmdagi sport turi qaysi?", R.drawable.s_tennis, "Tennis", "Voleybol", "Futbol", "Ragbi", "Tennis"));
        list.add(new QuestionData("Rasmdagi sport turi qaysi?", R.drawable.s_swimming, "Futbol", "Suzish", "Basketbol", "Atletika", "Suzish"));
        list.add(new QuestionData("Rasmdagi sport turi qaysi?", R.drawable.s_volleyball, "Voleybol", "Rugbi", "Basketbol", "Tennis", "Voleybol"));
    }

    private void loadFamousQuestions() {
        final ArrayList<QuestionData> list = new ArrayList<>();
        questions.put(CategoryEnum.FAMOUS, list);
        list.add(new QuestionData("Rasmdagi shaxs kim?", R.drawable.f_albert_einstein, "Isaac Newton", "Nikola Tesla", "Albert Einstein", "Galileo Galilei", "Albert Einstein"));
        list.add(new QuestionData("Rasmdagi shaxs kim?", R.drawable.f_marie_curie, "Marie Curie", "Rosalind Franklin", "Ada Lovelace", "Jane Goodall", "Marie Curie"));
        list.add(new QuestionData("Rasmdagi shaxs kim?", R.drawable.f_nelson_mandela, "Barack Obama", "Nelson Mandela", "Mahatma Gandhi", "Martin Luther King", "Nelson Mandela"));
        list.add(new QuestionData("Rasmdagi shaxs kim?", R.drawable.f_leonardo_da_vinci, "Pablo Picasso", "Vincent van Gogh", "Leonardo da Vinci", "Michelangelo", "Leonardo da Vinci"));
        list.add(new QuestionData("Rasmdagi shaxs kim?", R.drawable.f_michael_jordan, "Lionel Messi", "Cristiano Ronaldo", "Michael Jordan", "LeBron James", "Michael Jordan"));
    }
    @Override
    public QuestionData getQuestion(CategoryEnum category, int index) {
        return  Objects.requireNonNull(questions.get(category)).get(index);
    }
    @Override
    public int getMaxQuestionCount(CategoryEnum category) {
        return Objects.requireNonNull(questions.get(category)).size();
    }
}
