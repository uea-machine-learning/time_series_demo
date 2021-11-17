package week_8_demo.nestedclasses;

public class TeachingModule {
    private Student[] s;
    private StudentStats stats=new StudentStats();

    private class StudentStats{
        double maxMark;
        public void findStats() {
            maxMark = s[0].getModuleMark();
            for (int i = 1; i < s.length; i++) {
                double x = s[i].getModuleMark();
                if (x > maxMark)
                    maxMark = x;
            }
        }
        public double getMax(){
            return stats.maxMark;
        }
    }
}
