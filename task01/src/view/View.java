package view;

import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class View {
    private final Logger log = Logger.getLogger(View.class.getName());

    public View() {
        try {
            LogManager.getLogManager().readConfiguration( // берем конфиг для логов
                    View.class.getResourceAsStream("../log.config"));
        } catch (IOException e) {  // печаль, беда...
            System.err.println("Could not setup logger configuration: " + e.toString());
        }
    }
    public void printInfo(String string) {
        log.info(string);
    }
    public void printWarning(String string) {
        log.warning(string);
    }

}
