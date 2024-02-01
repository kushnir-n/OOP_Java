package enums;

import java.util.Random;

public enum AttackEnum {
    ATTACK_1("#H1# поперхнулся, и вдруг, жестокий #H2#, не по этикету, провел ужасный бросок через пупок оппонента"),
    ATTACK_2("#H1# засмотрелся на <вырезано цензурой>, а #H2# мимоходом размозжил дубиной правый глаз оппонента."),
    ATTACK_3("#H1# поперхнулся, а небритый #H2# случайно разрубил дубиной грудину оппонента"),
    ATTACK_4("#H1# задумался, но внезапно #H2#, показав противнику кукиш, расцарапал физиономию врага"),
    ATTACK_5("#H1# вспомнил что-то важное, а в это время #H2# ласково, раздробил дубиной грудную клетку оппонента"),
    ATTACK_6("#H1# расстроился, как вдруг #H2# беспричинно саданул разбивающий удар кривой сучковатой палкой по сопатке соперника"),
    ATTACK_7("#H1# чесал <вырезано цензурой>, но в это время #H2# с испугу провел красивый удар кривой сучковатой палкой под лопатку оппонента"),
    ATTACK_8("#H1# расплылся в улыбке, а в это время #H2# показав палец, размозжил мощной дубиной мизинец соперника"),
    ATTACK_9("#H1# почесался, и вдруг, #H2#, забыв все светские манеры, вырвал клок волос соперника"),
    ATTACK_10("#H1# пытался сконцентрироваться, но внезапно #H2#, приняв боевые 100 грамм, гениально провел виртуозный захват голени врага");

    private final String value;

    AttackEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static String getRandomAttack() {
        AttackEnum[] attacks = { AttackEnum.ATTACK_1, AttackEnum.ATTACK_2, AttackEnum.ATTACK_3, AttackEnum.ATTACK_4, AttackEnum.ATTACK_5, AttackEnum.ATTACK_6, AttackEnum.ATTACK_7, AttackEnum.ATTACK_8, AttackEnum.ATTACK_9, AttackEnum.ATTACK_10 };
        int randomIndex = new Random().nextInt(attacks.length);
        return attacks[randomIndex].getValue();
    }
}
