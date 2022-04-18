package common;

public class EnumData {
    public static enum GameType {
        BALL("볼"),
        NOTHING("낫싱"),
        STRIKE("스트라이크");

        GameType(String type) {
            this.type = type;
        }

        final private String type;

        public String getType() {
            return type;
        }
    }
}