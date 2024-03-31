package com.bluelotuscoding.epicfightclasses.world.item;

import com.bluelotuscoding.epicfightclasses.main.EpicFightClassesMain;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import yesman.epicfight.main.EpicFightMod;
import yesman.epicfight.world.item.EpicFightItemTier;
import yesman.epicfight.world.item.WeaponItem;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OathTakerItem extends WeaponItem {
    private final float attackDamage;
    private final double attackSpeed;
    @OnlyIn(Dist.CLIENT)
    private List<Component> tooltipExpand;

    public OathTakerItem(Item.Properties build) {
        super(EpicFightItemTier.UCHIGATANA, 0, -2.0F, build);
        if (EpicFightMod.isPhysicalClient()) {
            this.tooltipExpand = new ArrayList<Component> ();
            this.tooltipExpand.add(new TextComponent(""));
            this.tooltipExpand.add(new TranslatableComponent("item." + EpicFightClassesMain.MOD_ID + ".oath_taker.tooltip"));
        }
        this.attackDamage = 6.0F;
        this.attackSpeed = -2.4F;
    }

    @Override
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
        return toRepair.getItem() == Items.OBSIDIAN;
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        if (slot == EquipmentSlot.MAINHAND) {
            ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
            builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", this.attackDamage, AttributeModifier.Operation.ADDITION));
            builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", this.attackSpeed, AttributeModifier.Operation.ADDITION));
            return builder.build();
        }

        return super.getAttributeModifiers(slot, stack);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        for (Component txtComp : tooltipExpand) {
            tooltip.add(txtComp);
        }
    }
}
