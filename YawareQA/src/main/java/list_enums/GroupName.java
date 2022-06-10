package list_enums;

import java.util.List;
import java.util.Random;

public enum GroupName {

    Транспортный_отдел,
    Отдел_Логистики,
    Бухгалтерия,
    Отдел_Кадров;

    public static String getRandomGroupName() {
        return VALUES.get(RANDOM.nextInt(SIZE)).toString();
    }

    private static final List<GroupName> VALUES = List.of(values());
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();
}
