package aca.babylion.pairmatching.domain;

public class Member {

    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 20;

    private final String name;

    public Member(final String name) {
        validateMemberName(name);
        this.name = name;
    }

    private void validateMemberName(final String name) {
        if (name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException("훈련생의 이름 길이는 최소 1글자 이상이어야 합니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("훈련생의 이름 길이는 최대 20글자 이내여야 합니다.");
        }
    }

    public String getName() {
        return name;
    }
}
