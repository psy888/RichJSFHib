package richjsf;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

//@ManagedBean(name = "home", eager = true)
//@SessionScoped
@Component
@Scope("view")
@Data
public class Home {
    private String msg = "hello";
    private List<String> msgs = new ArrayList<>();

    public void addMsg(){
        msgs.add(msg);
        msg = "";
    }

    public String getMessage(){
        return msg;
    }
}
