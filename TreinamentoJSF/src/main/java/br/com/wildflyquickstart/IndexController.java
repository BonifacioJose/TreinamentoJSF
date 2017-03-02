package br.com.wildflyquickstart;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Bonifácio
 */
@Named
@ViewScoped
public class IndexController implements Serializable {

    public String getHelloWorld() {
        return "Hello World!";
    }
}
