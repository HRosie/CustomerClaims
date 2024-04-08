package Code.Main;

import Code.Functions.*;
import Code.Files.*;
import Code.Manager.*;

import java.io.IOException;
import java.util.Set;

public class ProgramMain {
    public static void main(String[] args) throws IOException {
        ClaimProcessManagerImpl manager = new ClaimProcessManagerImpl();

        SaveData save = new SaveData();

        LoadData load = new LoadData();

        ClaimController controller = new ClaimController(manager, null,save,load,manager);

        ClaimView view = new ClaimView(controller);

        controller.setView(view);

        controller.application();
    }
}

