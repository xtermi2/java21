package com.github.xtermi2.java21.jep441patternmatching;

public class SwitchPatternMatching {

    record MyPair<S, T>(S fst, T snd) {
    }

    static String recordInference(MyPair<String, Integer> pair) {
        return switch (pair) {
            case MyPair(var f, var s) -> STR."MyPair(\{f},\{s})";
        };
    }

    static String labelWithGuard(Integer integer) {
        return switch (integer) {
            case -1, 1 -> "Special cases";
            case Integer i
                    when i > 0 -> "Positive integer cases";
            case Integer ignored -> "All the remaining integers";
        };
    }


    sealed interface CardClassification permits Suit, Tarot {
    }

    public enum Suit implements CardClassification {CLUBS, DIAMONDS, HEARTS, SPADES}

    final class Tarot implements CardClassification {
    }

    static void exhaustiveSwitchWithBetterEnumSupport(CardClassification c) {
        switch (c) {
            case Suit.CLUBS -> System.out.println("It's clubs");
            case Suit.DIAMONDS -> System.out.println("It's diamonds");
            case Suit.HEARTS -> System.out.println("It's hearts");
            case Suit.SPADES -> System.out.println("It's spades");
            case Tarot _ -> System.out.println("It's a tarot");
        }
    }

    static void goodEnumSwitch(Suit c) {
        switch (c) {
            case CLUBS -> System.out.println("It's clubs");
            case DIAMONDS -> System.out.println("It's diamonds");
            case HEARTS -> System.out.println("It's hearts");
            case SPADES -> System.out.println("It's spades");
        }
    }
}
