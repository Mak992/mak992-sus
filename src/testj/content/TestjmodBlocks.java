package testj.content;

import mindustry.content.Items;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.defense.Wall;

import static mindustry.type.ItemStack.with;

public class TestjmodBlocks {
    public static Block
            //defense
            testWall;

    public static void load() {
        testWall = new Wall("testWall") {
            {
                size = 1;
                health = 120;
                requirements(Category.defense, with(Items.copper, 6));
            }
        };
    }
}