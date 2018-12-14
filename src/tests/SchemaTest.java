package tests;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class SchemaTest {


    public SchemaTest() throws SAXException, IOException {

        String schemaLang = "http://www.w3.org/2001/XMLSchema";
        SchemaFactory factory = SchemaFactory.newInstance(schemaLang);
        Schema schema = factory.newSchema(new StreamSource("/Users/David/" +
                "IdeaProjects/Javagrupp7/antitowerdefence/src/resources/schema.xsd"));
        Validator validator = schema.newValidator();
        File testFile = new File("/Users/David/IdeaProjects/Javagrupp7/" +
                "antitowerdefence/src/resources/testLevel.xml");
        CustomHandler errorHandler = new CustomHandler();
        validator.setErrorHandler(errorHandler);
        validator.validate(new StreamSource(testFile));

        if (errorHandler.isValid()){
            System.out.println("Xmlfile is valid");
        } else {
            System.out.println("Xmlfile is not valid");
        }


    }

    class CustomHandler extends DefaultHandler {

        private boolean isValid = true;

        public boolean isValid() {
            return isValid;
        }
        @Override
        public void warning(SAXParseException exception) throws SAXException {
         this.isValid = false;
        }

        @Override
        public void error(SAXParseException exception) throws SAXException {
            this.isValid = false;

        }

        @Override
        public void fatalError(SAXParseException exception) throws SAXException {
            this.isValid = false;

        }

    }

}