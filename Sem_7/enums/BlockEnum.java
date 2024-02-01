package enums;

import java.util.Random;

public enum BlockEnum {
    BLOCK_1("#H1# просчитался и небритый #H2# отбил щитом удар мизинцем в горло"),
    BLOCK_2("#H1# думал о <вырезано цензурой>, вследствие чего жестокий #H2# остановил удар мечом в пояс"),
    BLOCK_3("#H1# старался провести удар, но смелый #H2# отбил щитом удар гардой по щиколотке"),
    BLOCK_4("#H1# не контролировал ситуацию, и потому обезумевший #H2# заблокировал удар тяжелой дубиной по ребрам"),
    BLOCK_5("#H1# оступился и хитрый #H2# блокировал удар кривой сучковатой палкой в ухо"),
    BLOCK_6("#H1# испугался и #H2# остановил удар обухом топора по селезенке"),
    BLOCK_7("#H1# выдохся и потому страшный #H2# поставил блок на тычок топором по правой ноге"),
    BLOCK_8("#H1# пытался нанести удар, но безумный #H2# остановил удар маленьким топорищем под коленную чашечку"),
    BLOCK_9("#H1# не рассчитал свои силы и задумчивый #H2# поставил блок на тычок кривой сучковатой палкой по <вырезано цензурой>"),
    BLOCK_10("#H1# поскользнулся и неустрашимый #H2# блокировал тычок тяжелой дубиной в пах");

    private final String value;

    BlockEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static String getRandomBlock() {
        BlockEnum[] blocks = { BlockEnum.BLOCK_1, BlockEnum.BLOCK_2, BlockEnum.BLOCK_3, BlockEnum.BLOCK_4, BlockEnum.BLOCK_5, BlockEnum.BLOCK_6, BlockEnum.BLOCK_7, BlockEnum.BLOCK_8, BlockEnum.BLOCK_9, BlockEnum.BLOCK_10 };
        int randomIndex = new Random().nextInt(blocks.length);
        return blocks[randomIndex].getValue();
    }
}
