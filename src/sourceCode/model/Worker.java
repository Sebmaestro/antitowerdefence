package sourceCode.model;
import javax.swing.*;


/**
 * Created by denni on 2018-11-19.
 */
public class Worker extends SwingWorker<String, String> {
    String str;
    JTextArea area;

    public Worker(String str, JTextArea userArea) {
        this.str = str;
        this.area = userArea;

    }

    @Override
    protected String doInBackground() throws Exception {
        String str = new String();

        return  str;
    }


    @Override
    protected void done() {
        try {
            area.setText(get());

        } catch (Exception e) {
            str = (e.toString());
        }
        super.done();
    }


}