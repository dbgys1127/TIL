package study.datajpa.repository;

public interface NestedClosedProjection {
    String getUsername();

    TeamInfo getTeam();
    interface TeamInfo {
        String getName();
    }

}
