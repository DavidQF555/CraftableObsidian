package io.github.davidqf555.minecraft.craftableobsidian;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private ShapedRecipe recipe;

    @Override
    public void onEnable() {
        ItemStack obsidian = new ItemStack(Material.OBSIDIAN);
        ShapedRecipe recipe = new ShapedRecipe(obsidian);
        recipe.shape("*%*", "$^&", "*%*");
        recipe.setIngredient('*', Material.AIR);
        recipe.setIngredient('%', Material.IRON_PICKAXE);
        recipe.setIngredient('^', Material.STONE);
        recipe.setIngredient('$', Material.LAVA_BUCKET);
        recipe.setIngredient('&', Material.WATER_BUCKET);
        getServer().addRecipe(recipe);
        this.recipe = recipe;
    }

    @EventHandler
    public void onCraftItem(CraftItemEvent event) {
        if (event.getRecipe().equals(recipe)) {
            ItemStack bucket = new ItemStack(Material.BUCKET);
            Inventory inventory = event.getInventory();
            inventory.setItem(4, bucket);
            inventory.setItem(6, bucket);
        }
    }
}