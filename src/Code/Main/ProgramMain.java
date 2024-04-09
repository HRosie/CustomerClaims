package Code.Main;

import Code.Functions.*;
import Code.Files.*;
import Code.Manager.*;

import java.io.IOException;
import java.text.ParseException;

public class ProgramMain {
    public static void main(String[] args) throws IOException, ParseException {
        ClaimProcessManagerImpl manager = new ClaimProcessManagerImpl();
        SaveData save = new SaveData();
        LoadData load = new LoadData();
        ClaimControl control = new ClaimControl(manager, null,save,load,manager);
        ClaimMenu menu = new ClaimMenu(control);
        control.setMenu(menu);
        control.application();
    }
}

