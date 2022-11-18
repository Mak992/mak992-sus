package testj.content;

import mindustry.content.Items;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.defense.Wall;

import static mindustry.type.ItemStack.with;

public class TestjmodBlocks {
    public static Block
            //defense
            testWall, testWallLarge;

    public static void load() {
        int wallHealthMultiplier = 4;
        testWall = new Wall("testWall") {
            {
                size = 1;
                health = 70 * wallHealthMultiplier;
                requirements(Category.defense, with(Items.scrap, 8));

        testWallLarge = new Wall("testWallLarge") {
            {
                size = 2;
                health = 70 * wallHealthMultiplier * 4;
                requirements(Category.defense, with(Items.copper, 32));
            }
        };
    }
};}}