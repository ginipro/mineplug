import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public  class HalloWelt extends JavaPlugin{
    public void  onEnable(){
        this.getLogger().info("Hallo Welt!!");
    }

    public void  onDisable(){
        this.getLogger().info("Bin Weg Ha!!!!");
    }

    public boolean onCommand(CommandSender sender, Command befehl, String befehlsname,String[] args){

        this.getLogger().info("befehlt="+befehlsname);

        if( befehlsname.equals("halloserver")) {

            Bukkit.broadcastMessage("Hallo Leute");
            return  true;
        }

        if( befehlsname.equals("diamant")) {
            Player spieler = (Player) sender;
            Location p = spieler.getLocation();
            p.setX(p.getX()+2);
            World w  = spieler.getWorld();
            double yStart = p.getY();
            double zStart = p.getZ();
            for(int y = 0; y < 10; y++){
                p.setY(yStart + y);
                for(int z = 0; z < 20; z++){
                    p.setZ(zStart + z);
                    Block block = w.getBlockAt(p);
                    if (y == 3){
                        block.setType(Material.IRON_BLOCK);
                    } else if (y == 9){
                        block.setType(Material.NETHERITE_BLOCK);
                    } else {
                        block.setType(Material.DIAMOND_BLOCK);
                    }
                }

            }

            spieler.getInventory().setItemInMainHand(new ItemStack(Material.DIAMOND_PICKAXE) );

            return  true;
        }

        return  false;
    }
}