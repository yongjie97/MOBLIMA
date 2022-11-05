import Boundary.HomeBoundary;

public class MoblimaApp {
        public static void main(String[] args) throws Exception {

                // char[][] layout = {
                //                 { 0, 0, 0, 0, 0, 'S', 'C', 'R', 'E', 'E', 'N', 0, 0, 0 },
                //                 { 'E', 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 'E' },
                //                 { 'D', 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 'D' },
                //                 { 'C', 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 'C' },
                //                 { 'B', 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 'B' },
                //                 { 'A', 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 'A' } };
                // char[][] layout2 = {
                //                 { 0, 0, 0, 0, ' ', 'S', 'C', 'R', 'E', 'E', 'N', 0, 0 },
                //                 { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                //                 { 'D', 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 'D' },
                //                 { 'C', 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 'C' },
                //                 { 'B', 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 'B' },
                //                 { 'A', 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 'A' } };

                // char[][] layout3 = {
                //                 { 0, 0, 0, 0, 0, 0, 0, 0, 0, ' ', 'S', 'C', 'R', 'E', 'E', 'N', 0, 0 },
                //                 { 'G', 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 'G' },
                //                 { 'F', 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 'F' },
                //                 { 'E', 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 'E' },
                //                 { 'D', 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 'D' },
                //                 { 'C', 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 'C' },
                //                 { 'B', 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 'B' },
                //                 { 'A', 0, 0, 2, 0, 0, 2, 2, 2, 2, 0, 0, 2, 0, 0, 'A' } };

                // CineplexController.addCineplex("GV Yishun");
                // CinemaController.addCinema(1, "GY1", "Hall 1", CinemaClass.NORMAL, layout);
                // CinemaController.addCinema(1, "GY2", "Hall 2", CinemaClass.NORMAL, layout3);
                // CinemaController.addCinema(1, "GY3", "Hall 3", CinemaClass.PLATINUM, layout2);

                // CineplexController.addCineplex("GV Bishan");
                // CinemaController.addCinema(2, "GB1","Hall 1", CinemaClass.NORMAL, layout3);
                // UserController.register("Staff 2", "guestusername", "guestpassword");
                
                HomeBoundary.userUI();
        }

}
