package tools;

import java.util.Random;
import tools.StoneTypes;

public class StoneType {

    public static StoneTypes random() {
        final StoneTypes[] values = StoneTypes.values();
        int pick = new Random().nextInt(values.length);
        return values[pick];
    }

    public static Pattern getPattern(StoneTypes x) {
        Pattern pattern = new Pattern(4, 4);
        switch (x) {
            case BAR:
                for (int i = 0; i < 4; i++)
                    pattern.set(i, 0, true);
                break;
            case J:
            case L:
                for (int i = 0; i < 3; i++)
                    pattern.set(0, i, true);
                if (x == StoneTypes.L) {
                    pattern.set(1, 0, true);
                } else {
                    pattern.set(1, 2, true);
                }
                break;
            case T:
                for (int i = 0; i < 3; i++)
                    pattern.set(1, i, true);
                pattern.set(0, 1, true);
                break;
            case SQUARE:
                for (int i = 0; i <= 1; i++) {
                    pattern.set(0, i, true);
                    pattern.set(1, i, true);
                }
                break;
            case S:
                for (int i = 0; i < 2; i++) {
                    pattern.set(0, i + 1, true);
                    pattern.set(1, i, true);
                }
                break;
            case Z:
                for (int i = 0; i < 2; i++) {
                    pattern.set(0, i, true);
                    pattern.set(1, i + 1, true);
                }
        }
        return pattern;
    }

    public static String toString(StoneTypes type) {
        if (type == null)
            return "";
        return type.toString();
    }
}