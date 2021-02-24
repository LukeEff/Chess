package io.github.lukeeff.chess;

public enum Team {
    WHITE("White"),
    BLACK("Black");

        private final String title;

        Team(String title) {
            this.title = title;
        }

        public String toString() {
            return title;
        }

}
