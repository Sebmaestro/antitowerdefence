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
import java.io.InputStream;

/**
 * Author: David Eriksson
 */

public class SchemaTest {


    public SchemaTest(){
    }

    /**
     * validation: Validates the xml-file using the schema.
     * @return true if xml-file is valid and false if it is not.
     * @throws SAXException - Exception when parsing with SAX
     * @throws IOException - Exception when reading from IO
     */
    public boolean validation () throws SAXException, IOException {

        String schemaLang = "http://www.w3.org/2001/XMLSchema";
        SchemaFactory factory = SchemaFactory.newInstance(schemaLang);
        InputStream testFile = SchemaTest.class.getResourceAsStream(
                "/levels.xml");
        InputStream istream = SchemaTest.class.getResourceAsStream(
                "/schema.xsd");
        Schema schema = factory.newSchema(new StreamSource(istream));
        Validator validator = schema.newValidator();
        CustomHandler errorHandler = new CustomHandler();
        validator.setErrorHandler(errorHandler);
        validator.validate(new StreamSource(testFile));

        if (errorHandler.isValid()){
            return true;
        } else {
            return false;
        }

    }


    /**
     * Overrides methods in CustomHandler class.
     */
    class CustomHandler extends DefaultHandler {

        private boolean isValid = true;
        public boolean isValid() {
            return isValid;
        }

        /**
         * Sets isValid to false if exception is caught.
         * @param exception -
         * @throws SAXException - Exception when parsing with SAX
         */
        @Override
        public void warning(SAXParseException exception) throws SAXException {
         this.isValid = false;
            System.out.println(exception);
        }

        /**
         * Sets isValid to false if exception is caught.
         * @param exception -
         * @throws SAXException - Exception when parsing with SAX
         */
        @Override
        public void error(SAXParseException exception) throws SAXException {
            this.isValid = false;
            System.out.println(exception);
        }

        /**
         * Sets isValid to false if exception is caught.
         * @param exception -
         * @throws SAXException - Exception when parsing with SAX
         */
        @Override
        public void fatalError(SAXParseException exception) {
            this.isValid = false;
            System.out.println(exception);
        }
    }
}