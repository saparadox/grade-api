package use_case;
import api.GradeDB;
import entity.Grade;
import entity.Team;

public final class GetAverageGradeUseCase {
    private final GradeDB gradeDB;

    public GetAverageGradeUseCase(GradeDB gradeDB) {
        this.gradeDB = gradeDB;
    }

    public float getAverageGrade(String course) {
        // TODO: Get average grade for all students in your team.
        Team myTeam = gradeDB.getMyTeam();
        int sum = 0;
        String[] utorids = myTeam.getMembers();
        for(int i = 0; i < myTeam.getMembers().length; i++){
            System.out.println(i);
            sum = sum + gradeDB.getGrade(utorids[i], course).getGrade();
        }

        return (float) sum/myTeam.getMembers().length;
    }
}
