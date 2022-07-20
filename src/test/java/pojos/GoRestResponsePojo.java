package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GoRestResponsePojo {

    /*
    1. tum key ler icin private veriable lar olusturuyoruz
    2. tum parametrelerle ve bir de parametresiz constructor larimizi olusturuyoruz
    3. Getters ve setters lar olusturulur
    4. toString() methodu olusturulur
     */

    // 1. adim; tum key ler icin private veriable lar olusturuyoruz

    private Object meta;
    private GoRestDataPojo data;

    // 2. adim; tum parametrelerle ve bir de parametresiz constructor larimizi olusturuyoruz

    public GoRestResponsePojo(Object meta, GoRestDataPojo data) {
        this.meta = meta;
        this.data = data;
    }

    public GoRestResponsePojo() {
    }

    // 3. adim; Getters ve setters lar olusturulur

    public Object getMeta() {
        return meta;
    }

    public void setMeta(Object meta) {
        this.meta = meta;
    }

    public GoRestDataPojo getData() {
        return data;
    }

    public void setData(GoRestDataPojo data) {
        this.data = data;
    }

    // 4.adim ; toString() methodu olusturulur

    @Override
    public String toString() {
        return "GoRestResponsePojo{" +
                "meta=" + meta +
                ", data=" + data +
                '}';
    }
}
