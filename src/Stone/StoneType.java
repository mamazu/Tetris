package tools;

import java.util.Random;

public class StoneType {

    public static StoneTypes random() {
        final StoneTypes[] values = StoneTypes.values();
        int pick = new Random().nextInt(values.length);
        return values[pick];
    }

    public static Pattern getPattern(StoneTypes x) {
        Pattern pattern = new Pattern(1, 1);
        switch (x) {
            case BAR:
                pattern= new Pattern(1, 4);
                pattern.setAll(true);
                return pattern;
            case J:
            case L:
                pattern = new Pattern(2, 3);
                for (int i = 0; i < 3; i++)
                    pattern.set(0, i, true);
                if (x == StoneTypes.L) {
                    pattern.set(1, 2, true);
                } else {
                    pattern.set(1, 0, true);
                }
                break;
            case T:
                pattern = new Pattern(3, 2);
                pattern.set(1, 0, true);
                for (int i = 0; i < 3; i++)
                    pattern.set(i, 1, true);
                break;
            case SQUARE:
                pattern = new Pattern(2, 2);
                pattern.setAll(true);
                return pattern;
            case Z:
            case S:
                pattern = new Pattern(3, 2);
                for (int i = 0; i < 2; i++) {
                    pattern.set(i, (StoneTypes.S == x) ? 1 : 0, true);
                    pattern.set(i+1, (StoneTypes.S == x) ? 0 : 1, true);
                }
                break;
        }
        return pattern;
    }

    public static String toString(StoneTypes type) {
        if (type == null)
            return "";
        return type.toString();
    }
}