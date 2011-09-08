/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.havejack.plugins.vip;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 *
 * @author daniel
 */
public class VIPPlayerListener extends PlayerListener{

    @Override
    public void onPlayerMove(PlayerMoveEvent event) {
    Player player = event.getPlayer();
    Block block = player.getLocation().getBlock().getRelative(BlockFace.DOWN);
    
    block.setType(Material.WOOL);
    
    
    }
    
}
