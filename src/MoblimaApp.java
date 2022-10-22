import Boundary.HomeBoundary;

public class MoblimaApp {
    public static void main(String[] args) throws Exception {

        char[][] layout = {
                { 0, 0, 0, 0, 0, 'S', 'C', 'R', 'E', 'E', 'N', 0, 0, 0 },
                { 'E', 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 'E' },
                { 'D', 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 'D' },
                { 'C', 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 'C' },
                { 'B', 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 'B' },
                { 'A', 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 'A' } };
        //CinemaController.addCinema("Hall 1", CinemaClass.NORMAL, layout);

        HomeBoundary.userUI();
        HomeBoundary.adminUI();
    }
}
