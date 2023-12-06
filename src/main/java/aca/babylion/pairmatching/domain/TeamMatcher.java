package aca.babylion.pairmatching.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TeamMatcher {

    private final List<Member> members;

    public TeamMatcher(final List<Member> members) {
        final ArrayList<Member> tempMembers = new ArrayList<>(members);
        Collections.shuffle(tempMembers);
        this.members = tempMembers;
    }

    public List<Member> getMembers() {
        return members;
    }

    public List<Team> match() {
        if (members.size() % 2 == 1) {
            List<Team> teams = new ArrayList<>();
            //홀수 -> 한팀에 3명 나머지 2명
            final List<Member> threeTeam = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                threeTeam.add(members.get(i));
            }
            teams.add(new Team(threeTeam));

            for (int i = 3; i < members.size(); i += 2) {
                final Team team = new Team(members.subList(i, i + 2));
                teams.add(team);
            }
            return teams;
        } else {
            List<Team> teams = new ArrayList<>();
            for (int i = 0; i < members.size(); i += 2) {
                final Team team = new Team(members.subList(i, i + 2));
                teams.add(team);
            }
            return teams;
        }
    }
}
