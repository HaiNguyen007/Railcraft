package mods.railcraft.common.plugins.jei.blastfurnace;

import com.google.common.collect.Lists;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IRecipeWrapper;
import mods.railcraft.api.crafting.IBlastFurnaceRecipe;
import mods.railcraft.common.plugins.forge.LocalizationPlugin;
import net.minecraft.client.Minecraft;

import java.awt.*;
import java.util.Collections;

public class BlastFurnaceRecipeWrapper implements IRecipeWrapper {
    private IBlastFurnaceRecipe recipe;

    public BlastFurnaceRecipeWrapper(IBlastFurnaceRecipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public void getIngredients(IIngredients ingredients) {
        ingredients.setInputs(VanillaTypes.ITEM, Lists.newArrayList(recipe.getInput().getMatchingStacks()));
        ingredients.setOutputLists(VanillaTypes.ITEM, Lists.newArrayList(Collections.singletonList(recipe.getOutput()), Collections.singletonList(recipe.getSecondOutput())));
    }

    @Override
    public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {
        int cookTime = recipe.getCookTime();
        //TODO correct position
        //minecraft.fontRenderer.drawString(LocalizationPlugin.translate("gui.railcraft.jei.burntime", cookTime), -2, 41, Color.GRAY.getRGB());
    }
}
