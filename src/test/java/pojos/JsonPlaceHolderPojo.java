package pojos;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class JsonPlaceHolderPojo {

    /*
    1. tum key ler icin private veriable lar olusturuyoruz
    2. tum parametrelerle ve bir de parametresiz constructor larimizi olusturuyoruz
    3. Getters ve setters lar olusturulur
    4. toString() methodu olusturulur
     */

    // 1. adim; tum key ler icin private veriable lar olusturuyoruz

    private Integer userId;
    private String title;
    private Boolean completed;

    // 2. adim; tum parametrelerle ve bir de parametresiz constructor larimizi olusturuyoruz

    public JsonPlaceHolderPojo(Integer userId, String title, Boolean completed) {

        this.userId = userId;
        this.title = title;
        this.completed = completed;

    }

    public JsonPlaceHolderPojo() {
    }

    // 3. adim; Getters ve setters lar olusturulur


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    // 4.adim ; toString() methodu olusturulur

    @Override
    public String toString() {
        return "JsonPlaceHolderPojo{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", completed='" + completed + '\'' +
                '}';
    }

    // farkli key value ikililerinin uyusmazligini @JsonIgnoreProperties(ignoreUnknown = true)
    // anotation unu pojo clasinin basina yazarak cozebiliriz.
}
