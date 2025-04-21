package byzp;

import arc.Core;
import arc.math.Rand;
import arc.util.serialization.Base64Coder;
import mindustry.Vars;
import mindustry.gen.Icon;
import mindustry.mod.Mod;

public class main extends Mod {
    public void init() {
        super.init();
        Vars.ui.settings.addCategory("@ruuid.settings", Icon.book, table -> {
            table.checkPref("@ruuid.check", false);
        });
        if (Core.settings.getBool("@ruuid.check")) {
            byte[] result = new byte[8];
            new Rand().nextBytes(result);
            String uuid = new String(Base64Coder.encode(result));
            Core.settings.put("uuid", uuid);
            Core.app.post(() -> {
                Vars.ui.showText("@info", "@success");
            });
            Core.settings.put("@ruuid.check", false);
        }
    }
}
