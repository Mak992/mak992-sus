package testj;

import arc.Core;
import arc.Events;
import arc.util.Log;
import arc.util.Time;
import mindustry.game.EventType;
import mindustry.mod.Mod;
import mindustry.ui.dialogs.BaseDialog;
import testj.content.TestjmodBlocks;

public class Testjmod extends Mod{

    public Testjmod(){
        Log.info("Loaded Testjmod constructor.");

        //listen for game load event
        Events.on(EventType.ClientLoadEvent.class, e -> {
            //show dialog upon startup
            Time.runTask(10f, () -> {
                BaseDialog dialog = new BaseDialog("a");
                dialog.cont.add("dialog").row();
                //mod sprites are prefixed with the mod name (this mod is called 'example-java-mod' in its config)
                dialog.cont.image(Core.atlas.find("null")).pad(40f).row();
                dialog.cont.button("Dungeon master", dialog::hide).size(300f, 60f);
                dialog.show();
            });
        });
    }

    @Override
    public void loadContent(){

        Log.info("Loading some ci content.");

        TestjmodBlocks.load();

    }

}