/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.havejack.plugins.vip;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.material.MaterialData;
import org.bukkit.material.Wool;

/**
 *
 * @author daniel
 */
public class VIPPlayerListener extends PlayerListener{
    private final Vip plugin;
 
    public VIPPlayerListener(Vip plugin) {
        this.plugin = plugin;
    }



    @Override
    public void onPlayerMove(PlayerMoveEvent event) {
    Player player = event.getPlayer();
    Block block = player.getLocation().getBlock().getRelative(BlockFace.DOWN);
    if(!player.hasPermission("vip.carpet")){
        return;
    }
    if(!plugin.hasCarpet(player)){
        return;
        
    }
        
    
    if((!block.isEmpty()) && (!block.isLiquid())){
        if(block.getType() == Material.WOOL){  
        BlockState state = block.getState();
        MaterialData data = state.getData();
        
        if(data instanceof Wool){
            Wool wool = (Wool)data; 
            if(wool.getColor() == DyeColor.RED ){
                return;
            }
                
            }
        }
        
        plugin.putBlock(player, block.getState());
        block.setType(Material.WOOL);
        
        BlockState state = block.getState();
        MaterialData data = state.getData();
        
        if(data instanceof Wool){
            Wool wool = (Wool)data;
            wool.setColor(DyeColor.BLUE);
               
            }
            
    }
    
    }
    
    }
    
