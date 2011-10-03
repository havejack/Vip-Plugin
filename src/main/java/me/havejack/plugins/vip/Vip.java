package me.havejack.plugins.vip;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import org.bukkit.ChatColor;
import org.bukkit.block.BlockState;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event.Type;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.plugin.java.JavaPlugin;

public class Vip extends JavaPlugin {
    private PlayerListener playerlistener = new VIPPlayerListener(this);
    private Set<Player> carpets = new HashSet<Player>();
    private Map<Player, LinkedList<BlockState>> blocks = new HashMap<Player, LinkedList<BlockState>>();
    
            public void onDisable() {
        // TODO: Place any custom disable code here.
        System.out.println(this + " is now disabled Sad Face!");
    }

    public void onEnable() {
        // TODO: place any custom enable code here, such as registering events
        getServer().getPluginManager().registerEvent(Type.PLAYER_MOVE, playerlistener, null, Priority.Highest, this);
       
        getCommand("reddcarpet").setExecutor(new CommandExecutor() {
            public boolean onCommand(CommandSender cs, Command cmnd, String alias, String[] args) {
            if(args.length > 0){  
                return false;
            }
                
            if(cs instanceof Player){
                Player player = (Player)cs;
                
                if(player.hasPermission("vip.carpet")) {
                        setCarpet(player, !hasCarpet(player));
                    }else{
                    player.sendMessage(ChatColor.RED + "NO RED CARPET FOR YOU");                
                }
            }else{
                cs.sendMessage(ChatColor.RED + "You Are not popular enough to have this");
            }
            
            
            return true;
            }
        });
        
        System.out.println(this + " is now enabled! Make people VIP !");
    }
    public boolean hasCarpet(Player player){
        return carpets.contains(player);
        
    }
    public void setCarpet(Player player, boolean enabled){
        if(enabled){
            carpets.add(player);
        }else{
            carpets.remove(player);       
        }
    }
 
    private LinkedList<BlockState> getBlockList(Player player){
       LinkedList<BlockState> result = blocks.get(player);
       
       if(result == null){
          result = new LinkedList<BlockState>();
          blocks.put(player, result);
       }
       
       return result;
    }
    
    public void putBlock(Player player, BlockState block){
        LinkedList<BlockState> list = getBlockList(player);
        
        if(list.size() > 10){
        BlockState old = list.removeFirst();
        
        old.update(true);
        }
        
        list.add(block);
    }
    
}
    