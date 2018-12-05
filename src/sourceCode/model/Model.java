package sourceCode.model;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by denni on 2018-12-05.
 */
public class Model {

    public Model() throws IOException{
        InputStream inputStream = getClass().getResourceAsStream("./src/resources/testLevel.xml");
    }

}
