package cradle.spring.xx.app.view;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class IdView {

    @NotNull
    @Size(min=1, max=3)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
