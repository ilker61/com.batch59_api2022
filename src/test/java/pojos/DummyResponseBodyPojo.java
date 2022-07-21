package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DummyResponseBodyPojo {

    /*
    1. tum key ler icin private veriable lar olusturuyoruz
    2. tum parametrelerle ve bir de parametresiz constructor larimizi olusturuyoruz
    3. Getters ve setters lar olusturulur
    4. toString() methodu olusturulur
     */


    // 1. adim; tum key ler icin private veriable lar olusturuyoruz

    private String status;
    private DummyDataPojo data;

    // 2. tum parametrelerle ve bir de parametresiz constructor larimizi olusturuyoruz


    public DummyResponseBodyPojo(String status, DummyDataPojo data) {
        this.status = status;
        this.data = data;
    }

    public DummyResponseBodyPojo() {
    }

    //3. Getters ve setters lar olusturulur


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DummyDataPojo getData() {
        return data;
    }

    public void setData(DummyDataPojo data) {
        this.data = data;
    }

    //4. toString() methodu olusturulur


    @Override
    public String toString() {
        return "DummyResponseBodyPojo{" +
                "status='" + status + '\'' +
                ", data=" + data +
                '}';
    }
}
