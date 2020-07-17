import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	ShapedRecipe craftingObsidian;

	public void onEnable() {
		ItemStack obsidian = new ItemStack(Material.OBSIDIAN);
		ShapedRecipe craftingObsidian = new ShapedRecipe(obsidian);
		craftingObsidian.shape(new String[] { "*%*", "$^&", "*%*" });
		craftingObsidian.setIngredient('*', Material.AIR);
		craftingObsidian.setIngredient('%', Material.IRON_PICKAXE);
		craftingObsidian.setIngredient('^', Material.STONE);
		craftingObsidian.setIngredient('$', Material.LAVA_BUCKET);
		craftingObsidian.setIngredient('&', Material.WATER_BUCKET);
		getServer().addRecipe(craftingObsidian);
		this.craftingObsidian = craftingObsidian;
	}

	public void onDisable() {}

	@EventHandler
	public void afterCrafting(CraftItemEvent e) {
		if(e.getRecipe().equals(craftingObsidian)) {
			ItemStack bucket = new ItemStack(Material.BUCKET);
			e.getInventory().setItem(4, bucket);
			e.getInventory().setItem(6, bucket);
		} 
	}
}