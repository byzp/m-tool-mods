package byzp;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import arc.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.mod.*;
import mindustry.net.Administration.*;
import mindustry.world.blocks.storage.*;
import static mindustry.core.GameState.State.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;


public class pause extends Plugin{
public boolean p=false;

    @Override
    public void registerClientCommands(CommandHandler handler){
        
        //register a simple reply command
        handler.<Player>register("p","null",(args, player) -> {
            if(p==false){
                Vars.state.set(mindustry.core.GameState.State.paused);
                p=true;
            }else{
                Vars.state.set(mindustry.core.GameState.State.playing);
                p=false;
            }
        });
    }
    
    


}