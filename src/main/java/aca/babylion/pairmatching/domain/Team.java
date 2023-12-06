package aca.babylion.pairmatching.domain;

import java.util.List;

public class Team {

    private final List<Member> members;

    public Team(final List<Member> members) {
        validateMembersCount(members);
        this.members = members;
    }

    private void validateMembersCount(final List<Member> members) {
        if (members.size() != 2 && members.size() != 3) {
            throw new IllegalArgumentException("한 팀엔 2명 또는 3명의 훈련생이 필요합니다.");
        }
    }

    public List<Member> getMembers() {
        return members;
    }

    public int getMemberCount() {
        return members.size();
    }
}
