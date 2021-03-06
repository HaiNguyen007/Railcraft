/*------------------------------------------------------------------------------
 Copyright (c) CovertJaguar, 2011-2018
 http://railcraft.info

 This code is the property of CovertJaguar
 and may only be used with explicit written
 permission unless otherwise specified on the
 license page at http://railcraft.info/wiki/info:license.
 -----------------------------------------------------------------------------*/

package mods.railcraft.common.blocks.charge;

import mods.railcraft.common.blocks.ItemBlockRailcraftSubtyped;
import mods.railcraft.common.gui.tooltips.ToolTip;
import mods.railcraft.common.plugins.forge.LocalizationPlugin;
import mods.railcraft.common.util.misc.HumanReadableNumberFormatter;
import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.Nullable;

/**
 * Created by CovertJaguar on 6/25/2017 for Railcraft.
 *
 * @author CovertJaguar <http://www.railcraft.info>
 */
public class ItemChargeBattery extends ItemBlockRailcraftSubtyped {
    public ItemChargeBattery(Block block) {
        super(block);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ToolTip getToolTip(ItemStack stack, @Nullable World world, ITooltipFlag adv) {
        ToolTip tips = super.getToolTip(stack, world, adv);
        BatteryVariant variant = (BatteryVariant) getVariant(stack);
        if (variant != null) {
            if (tips == null)
                tips = new ToolTip();
            tips.add(LocalizationPlugin.translate("tile.railcraft.charge.battery.tips.capacity", HumanReadableNumberFormatter.format(variant.chargeDef.getBatterySpec().getCapacity())));
            tips.add(LocalizationPlugin.translate("tile.railcraft.charge.battery.tips.maxdraw", HumanReadableNumberFormatter.format(variant.chargeDef.getBatterySpec().getMaxDraw())));
            tips.add(LocalizationPlugin.translate("tile.railcraft.charge.battery.tips.loss", HumanReadableNumberFormatter.format(variant.loss)));
            tips.add(LocalizationPlugin.translate("tile.railcraft.charge.battery.tips.efficiency", HumanReadableNumberFormatter.format(variant.chargeDef.getBatterySpec().getEfficiency())));
        }
        return tips;
    }

}
