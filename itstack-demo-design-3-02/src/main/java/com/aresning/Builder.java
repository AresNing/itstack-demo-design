package com.aresning;

import org.itstack.demo.design.ceiling.LevelOneCeiling;
import org.itstack.demo.design.ceiling.LevelTwoCeiling;
import org.itstack.demo.design.coat.DuluxCoat;
import org.itstack.demo.design.coat.LiBangCoat;
import org.itstack.demo.design.floor.ShengXiangFloor;
import org.itstack.demo.design.tile.DongPengTile;
import org.itstack.demo.design.tile.MarcoPoloTile;

/**
 * Created with Intellij IDEA
 * <h3>itstack-demo-design<h3>
 *
 * @author : AresNing
 * @date : 2023-09-24 14:03
 * @description :
 */
public class Builder {
    public IMenu levelOne(Double area) {
        return new DecorationPackageMenu(area, "")
                .appendCeiling(new LevelTwoCeiling())
                .appendCoat(new DuluxCoat())
                .appendFloor(new ShengXiangFloor());
    }

    public IMenu levelTwo(Double area){
        return new DecorationPackageMenu(area, "轻奢田园")
                .appendCeiling(new LevelTwoCeiling())   // 吊顶，二级顶
                .appendCoat(new LiBangCoat())           // 涂料，立邦
                .appendTile(new MarcoPoloTile());       // 地砖，马可波罗
    }

    public IMenu levelThree(Double area){
        return new DecorationPackageMenu(area, "现代简约")
                .appendCeiling(new LevelOneCeiling())   // 吊顶，二级顶
                .appendCoat(new LiBangCoat())           // 涂料，立邦
                .appendTile(new DongPengTile());        // 地砖，东鹏
    }
}
