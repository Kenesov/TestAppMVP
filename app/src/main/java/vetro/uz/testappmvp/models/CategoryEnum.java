package vetro.uz.testappmvp.models;

public enum CategoryEnum {
    COUNTRIES("Davlatlar"),  SPORT("Sport turlari"), FAMOUS("Mashhur shahslar");
    private String categoryName;
    CategoryEnum(String categoryName){this.categoryName = categoryName;}

    public String getCategoryName() {
        return categoryName;
    }
}
